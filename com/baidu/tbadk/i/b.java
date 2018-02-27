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
    private int bfz;
    private HTypeListView bwj;
    private com.baidu.tieba.a.b bwk;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.bfz = 3;
        this.mPageContext = tbPageContext;
        this.bwj = (HTypeListView) view.findViewById(d.g.follow_live_list);
        this.mBottomLine = view.findViewById(d.g.follow_live_bottom_line);
        this.bwj.setSelector(d.f.transparent_bg);
        this.bwk = new com.baidu.tieba.a.b(this.mPageContext, this.bwj);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.bwk.setDatas(bVar.getList());
        }
    }

    public void Mu() {
        if (this.bfz != TbadkCoreApplication.getInst().getSkinType()) {
            this.bfz = TbadkCoreApplication.getInst().getSkinType();
            aj.t(this.bwj, d.C0141d.cp_bg_line_d);
            aj.t(this.mBottomLine, d.C0141d.cp_bg_line_c);
            this.bwk.notifyDataSetChanged();
        }
    }
}
