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
    private int aLF;
    private HTypeListView bcd;
    private com.baidu.tieba.b.b bce;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.aLF = 3;
        this.mPageContext = tbPageContext;
        this.bcd = (HTypeListView) view.findViewById(e.g.follow_live_list);
        this.mBottomLine = view.findViewById(e.g.follow_live_bottom_line);
        this.bcd.setSelector(e.f.transparent_bg);
        this.bce = new com.baidu.tieba.b.b(this.mPageContext, this.bcd);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.bce.setDatas(bVar.getList());
        }
    }

    public void Ns() {
        if (this.aLF != TbadkCoreApplication.getInst().getSkinType()) {
            this.aLF = TbadkCoreApplication.getInst().getSkinType();
            al.j(this.bcd, e.d.cp_bg_line_d);
            al.j(this.mBottomLine, e.d.cp_bg_line_c);
            this.bce.notifyDataSetChanged();
        }
    }
}
