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
    private HTypeListView aGK;
    private com.baidu.tieba.b.b aGL;
    private int aqQ;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view2, TbPageContext tbPageContext) {
        super(view2);
        this.aqQ = 3;
        this.mPageContext = tbPageContext;
        this.aGK = (HTypeListView) view2.findViewById(d.g.follow_live_list);
        this.mBottomLine = view2.findViewById(d.g.follow_live_bottom_line);
        this.aGK.setSelector(d.f.transparent_bg);
        this.aGL = new com.baidu.tieba.b.b(this.mPageContext, this.aGK);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.aGL.setDatas(bVar.getList());
        }
    }

    public void EW() {
        if (this.aqQ != TbadkCoreApplication.getInst().getSkinType()) {
            this.aqQ = TbadkCoreApplication.getInst().getSkinType();
            ak.j(this.aGK, d.C0126d.cp_bg_line_d);
            ak.j(this.mBottomLine, d.C0126d.cp_bg_line_c);
            this.aGL.notifyDataSetChanged();
        }
    }
}
