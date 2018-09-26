package com.baidu.tbadk.j;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
/* loaded from: classes.dex */
public class b extends q.a {
    private int aCJ;
    private HTypeListView aTs;
    private com.baidu.tieba.b.b aTt;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.aCJ = 3;
        this.mPageContext = tbPageContext;
        this.aTs = (HTypeListView) view.findViewById(e.g.follow_live_list);
        this.mBottomLine = view.findViewById(e.g.follow_live_bottom_line);
        this.aTs.setSelector(e.f.transparent_bg);
        this.aTt = new com.baidu.tieba.b.b(this.mPageContext, this.aTs);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.aTt.setDatas(bVar.getList());
        }
    }

    public void Ke() {
        if (this.aCJ != TbadkCoreApplication.getInst().getSkinType()) {
            this.aCJ = TbadkCoreApplication.getInst().getSkinType();
            al.j(this.aTs, e.d.cp_bg_line_d);
            al.j(this.mBottomLine, e.d.cp_bg_line_c);
            this.aTt.notifyDataSetChanged();
        }
    }
}
