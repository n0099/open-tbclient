package com.baidu.tbadk.i;

import android.view.View;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
/* loaded from: classes.dex */
public class b extends r.a {
    private int bfL;
    private HTypeListView bww;
    private com.baidu.tieba.a.b bwx;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.bfL = 3;
        this.mPageContext = tbPageContext;
        this.bww = (HTypeListView) view.findViewById(d.g.follow_live_list);
        this.mBottomLine = view.findViewById(d.g.follow_live_bottom_line);
        this.bww.setSelector(d.f.transparent_bg);
        this.bwx = new com.baidu.tieba.a.b(this.mPageContext, this.bww);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.bwx.setDatas(bVar.getList());
        }
    }

    public void Mv() {
        if (this.bfL != TbadkCoreApplication.getInst().getSkinType()) {
            this.bfL = TbadkCoreApplication.getInst().getSkinType();
            aj.t(this.bww, d.C0140d.cp_bg_line_d);
            aj.t(this.mBottomLine, d.C0140d.cp_bg_line_c);
            this.bwx.notifyDataSetChanged();
        }
    }
}
