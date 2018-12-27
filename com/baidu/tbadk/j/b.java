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
    private int aLH;
    private HTypeListView bcg;
    private com.baidu.tieba.b.b bch;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.aLH = 3;
        this.mPageContext = tbPageContext;
        this.bcg = (HTypeListView) view.findViewById(e.g.follow_live_list);
        this.mBottomLine = view.findViewById(e.g.follow_live_bottom_line);
        this.bcg.setSelector(e.f.transparent_bg);
        this.bch = new com.baidu.tieba.b.b(this.mPageContext, this.bcg);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.bch.setDatas(bVar.getList());
        }
    }

    public void Nt() {
        if (this.aLH != TbadkCoreApplication.getInst().getSkinType()) {
            this.aLH = TbadkCoreApplication.getInst().getSkinType();
            al.j(this.bcg, e.d.cp_bg_line_d);
            al.j(this.mBottomLine, e.d.cp_bg_line_c);
            this.bch.notifyDataSetChanged();
        }
    }
}
