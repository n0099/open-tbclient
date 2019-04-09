package com.baidu.tbadk.l;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
/* loaded from: classes.dex */
public class b extends v.a {
    private int bUN;
    private HTypeListView cmt;
    private com.baidu.tieba.b.b cmu;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.bUN = 3;
        this.mPageContext = tbPageContext;
        this.cmt = (HTypeListView) view.findViewById(d.g.follow_live_list);
        this.mBottomLine = view.findViewById(d.g.follow_live_bottom_line);
        this.cmt.setSelector(d.f.transparent_bg);
        this.cmu = new com.baidu.tieba.b.b(this.mPageContext, this.cmt);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.cmu.setDatas(bVar.getList());
        }
    }

    public void ank() {
        if (this.bUN != TbadkCoreApplication.getInst().getSkinType()) {
            this.bUN = TbadkCoreApplication.getInst().getSkinType();
            al.l(this.cmt, d.C0277d.cp_bg_line_d);
            al.l(this.mBottomLine, d.C0277d.cp_bg_line_c);
            this.cmu.notifyDataSetChanged();
        }
    }
}
