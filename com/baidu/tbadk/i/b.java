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
    private int bdE;
    private HTypeListView btT;
    private com.baidu.tieba.a.b btU;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.bdE = 3;
        this.mPageContext = tbPageContext;
        this.btT = (HTypeListView) view.findViewById(d.g.follow_live_list);
        this.mBottomLine = view.findViewById(d.g.follow_live_bottom_line);
        this.btT.setSelector(d.f.transparent_bg);
        this.btU = new com.baidu.tieba.a.b(this.mPageContext, this.btT);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.btU.setDatas(bVar.getList());
        }
    }

    public void LZ() {
        if (this.bdE != TbadkCoreApplication.getInst().getSkinType()) {
            this.bdE = TbadkCoreApplication.getInst().getSkinType();
            aj.t(this.btT, d.C0108d.cp_bg_line_d);
            aj.t(this.mBottomLine, d.C0108d.cp_bg_line_c);
            this.btU.notifyDataSetChanged();
        }
    }
}
