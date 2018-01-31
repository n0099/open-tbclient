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
    private int bdS;
    private HTypeListView bum;
    private com.baidu.tieba.a.b bun;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.bdS = 3;
        this.mPageContext = tbPageContext;
        this.bum = (HTypeListView) view.findViewById(d.g.follow_live_list);
        this.mBottomLine = view.findViewById(d.g.follow_live_bottom_line);
        this.bum.setSelector(d.f.transparent_bg);
        this.bun = new com.baidu.tieba.a.b(this.mPageContext, this.bum);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.bun.setDatas(bVar.getList());
        }
    }

    public void LP() {
        if (this.bdS != TbadkCoreApplication.getInst().getSkinType()) {
            this.bdS = TbadkCoreApplication.getInst().getSkinType();
            aj.t(this.bum, d.C0108d.cp_bg_line_d);
            aj.t(this.mBottomLine, d.C0108d.cp_bg_line_c);
            this.bun.notifyDataSetChanged();
        }
    }
}
