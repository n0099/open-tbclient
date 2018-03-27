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
    private int bfC;
    private HTypeListView bwm;
    private com.baidu.tieba.a.b bwn;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.bfC = 3;
        this.mPageContext = tbPageContext;
        this.bwm = (HTypeListView) view.findViewById(d.g.follow_live_list);
        this.mBottomLine = view.findViewById(d.g.follow_live_bottom_line);
        this.bwm.setSelector(d.f.transparent_bg);
        this.bwn = new com.baidu.tieba.a.b(this.mPageContext, this.bwm);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.bwn.setDatas(bVar.getList());
        }
    }

    public void Mv() {
        if (this.bfC != TbadkCoreApplication.getInst().getSkinType()) {
            this.bfC = TbadkCoreApplication.getInst().getSkinType();
            aj.t(this.bwm, d.C0141d.cp_bg_line_d);
            aj.t(this.mBottomLine, d.C0141d.cp_bg_line_c);
            this.bwn.notifyDataSetChanged();
        }
    }
}
