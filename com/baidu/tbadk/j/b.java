package com.baidu.tbadk.j;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
/* loaded from: classes.dex */
public class b extends q.a {
    private HTypeListView aQd;
    private com.baidu.tieba.b.b aQe;
    private int azI;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.azI = 3;
        this.mPageContext = tbPageContext;
        this.aQd = (HTypeListView) view.findViewById(d.g.follow_live_list);
        this.mBottomLine = view.findViewById(d.g.follow_live_bottom_line);
        this.aQd.setSelector(d.f.transparent_bg);
        this.aQe = new com.baidu.tieba.b.b(this.mPageContext, this.aQd);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.aQe.setDatas(bVar.getList());
        }
    }

    public void IO() {
        if (this.azI != TbadkCoreApplication.getInst().getSkinType()) {
            this.azI = TbadkCoreApplication.getInst().getSkinType();
            am.j(this.aQd, d.C0140d.cp_bg_line_d);
            am.j(this.mBottomLine, d.C0140d.cp_bg_line_c);
            this.aQe.notifyDataSetChanged();
        }
    }
}
