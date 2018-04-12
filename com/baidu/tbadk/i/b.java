package com.baidu.tbadk.i;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
/* loaded from: classes.dex */
public class b extends q.a {
    private HTypeListView aGJ;
    private com.baidu.tieba.b.b aGK;
    private int aqQ;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view2, TbPageContext tbPageContext) {
        super(view2);
        this.aqQ = 3;
        this.mPageContext = tbPageContext;
        this.aGJ = (HTypeListView) view2.findViewById(d.g.follow_live_list);
        this.mBottomLine = view2.findViewById(d.g.follow_live_bottom_line);
        this.aGJ.setSelector(d.f.transparent_bg);
        this.aGK = new com.baidu.tieba.b.b(this.mPageContext, this.aGJ);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.aGK.setDatas(bVar.getList());
        }
    }

    public void EY() {
        if (this.aqQ != TbadkCoreApplication.getInst().getSkinType()) {
            this.aqQ = TbadkCoreApplication.getInst().getSkinType();
            ak.j(this.aGJ, d.C0126d.cp_bg_line_d);
            ak.j(this.mBottomLine, d.C0126d.cp_bg_line_c);
            this.aGK.notifyDataSetChanged();
        }
    }
}
