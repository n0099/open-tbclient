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
    private int bUJ;
    private HTypeListView cmq;
    private com.baidu.tieba.b.b cmr;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.bUJ = 3;
        this.mPageContext = tbPageContext;
        this.cmq = (HTypeListView) view.findViewById(d.g.follow_live_list);
        this.mBottomLine = view.findViewById(d.g.follow_live_bottom_line);
        this.cmq.setSelector(d.f.transparent_bg);
        this.cmr = new com.baidu.tieba.b.b(this.mPageContext, this.cmq);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.cmr.setDatas(bVar.getList());
        }
    }

    public void ano() {
        if (this.bUJ != TbadkCoreApplication.getInst().getSkinType()) {
            this.bUJ = TbadkCoreApplication.getInst().getSkinType();
            al.l(this.cmq, d.C0236d.cp_bg_line_d);
            al.l(this.mBottomLine, d.C0236d.cp_bg_line_c);
            this.cmr.notifyDataSetChanged();
        }
    }
}
