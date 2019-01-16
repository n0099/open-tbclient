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
    private int aMj;
    private HTypeListView bcQ;
    private com.baidu.tieba.b.b bcR;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.aMj = 3;
        this.mPageContext = tbPageContext;
        this.bcQ = (HTypeListView) view.findViewById(e.g.follow_live_list);
        this.mBottomLine = view.findViewById(e.g.follow_live_bottom_line);
        this.bcQ.setSelector(e.f.transparent_bg);
        this.bcR = new com.baidu.tieba.b.b(this.mPageContext, this.bcQ);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.bcR.setDatas(bVar.getList());
        }
    }

    public void NK() {
        if (this.aMj != TbadkCoreApplication.getInst().getSkinType()) {
            this.aMj = TbadkCoreApplication.getInst().getSkinType();
            al.j(this.bcQ, e.d.cp_bg_line_d);
            al.j(this.mBottomLine, e.d.cp_bg_line_c);
            this.bcR.notifyDataSetChanged();
        }
    }
}
