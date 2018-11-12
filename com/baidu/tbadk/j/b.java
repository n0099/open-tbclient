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
    private int aIf;
    private HTypeListView aYF;
    private com.baidu.tieba.b.b aYG;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.aIf = 3;
        this.mPageContext = tbPageContext;
        this.aYF = (HTypeListView) view.findViewById(e.g.follow_live_list);
        this.mBottomLine = view.findViewById(e.g.follow_live_bottom_line);
        this.aYF.setSelector(e.f.transparent_bg);
        this.aYG = new com.baidu.tieba.b.b(this.mPageContext, this.aYF);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.aYG.setDatas(bVar.getList());
        }
    }

    public void Mo() {
        if (this.aIf != TbadkCoreApplication.getInst().getSkinType()) {
            this.aIf = TbadkCoreApplication.getInst().getSkinType();
            al.j(this.aYF, e.d.cp_bg_line_d);
            al.j(this.mBottomLine, e.d.cp_bg_line_c);
            this.aYG.notifyDataSetChanged();
        }
    }
}
