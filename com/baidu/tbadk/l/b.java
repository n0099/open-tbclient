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
    private int bUM;
    private HTypeListView cms;
    private com.baidu.tieba.b.b cmt;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.bUM = 3;
        this.mPageContext = tbPageContext;
        this.cms = (HTypeListView) view.findViewById(d.g.follow_live_list);
        this.mBottomLine = view.findViewById(d.g.follow_live_bottom_line);
        this.cms.setSelector(d.f.transparent_bg);
        this.cmt = new com.baidu.tieba.b.b(this.mPageContext, this.cms);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.cmt.setDatas(bVar.getList());
        }
    }

    public void ank() {
        if (this.bUM != TbadkCoreApplication.getInst().getSkinType()) {
            this.bUM = TbadkCoreApplication.getInst().getSkinType();
            al.l(this.cms, d.C0277d.cp_bg_line_d);
            al.l(this.mBottomLine, d.C0277d.cp_bg_line_c);
            this.cmt.notifyDataSetChanged();
        }
    }
}
