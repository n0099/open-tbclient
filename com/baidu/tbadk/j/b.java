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
    private int aMk;
    private HTypeListView bcR;
    private com.baidu.tieba.b.b bcS;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.aMk = 3;
        this.mPageContext = tbPageContext;
        this.bcR = (HTypeListView) view.findViewById(e.g.follow_live_list);
        this.mBottomLine = view.findViewById(e.g.follow_live_bottom_line);
        this.bcR.setSelector(e.f.transparent_bg);
        this.bcS = new com.baidu.tieba.b.b(this.mPageContext, this.bcR);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.bcS.setDatas(bVar.getList());
        }
    }

    public void NK() {
        if (this.aMk != TbadkCoreApplication.getInst().getSkinType()) {
            this.aMk = TbadkCoreApplication.getInst().getSkinType();
            al.j(this.bcR, e.d.cp_bg_line_d);
            al.j(this.mBottomLine, e.d.cp_bg_line_c);
            this.bcS.notifyDataSetChanged();
        }
    }
}
