package com.baidu.tbadk.i;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
/* loaded from: classes.dex */
public class b extends q.a {
    private HTypeListView aPh;
    private com.baidu.tieba.b.b aPi;
    private int ayX;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.ayX = 3;
        this.mPageContext = tbPageContext;
        this.aPh = (HTypeListView) view.findViewById(d.g.follow_live_list);
        this.mBottomLine = view.findViewById(d.g.follow_live_bottom_line);
        this.aPh.setSelector(d.f.transparent_bg);
        this.aPi = new com.baidu.tieba.b.b(this.mPageContext, this.aPh);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.aPi.setDatas(bVar.getList());
        }
    }

    public void IB() {
        if (this.ayX != TbadkCoreApplication.getInst().getSkinType()) {
            this.ayX = TbadkCoreApplication.getInst().getSkinType();
            al.j(this.aPh, d.C0141d.cp_bg_line_d);
            al.j(this.mBottomLine, d.C0141d.cp_bg_line_c);
            this.aPi.notifyDataSetChanged();
        }
    }
}
