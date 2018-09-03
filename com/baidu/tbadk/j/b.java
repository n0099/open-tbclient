package com.baidu.tbadk.j;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
/* loaded from: classes.dex */
public class b extends q.a {
    private HTypeListView aQa;
    private com.baidu.tieba.b.b aQb;
    private int azF;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.azF = 3;
        this.mPageContext = tbPageContext;
        this.aQa = (HTypeListView) view.findViewById(f.g.follow_live_list);
        this.mBottomLine = view.findViewById(f.g.follow_live_bottom_line);
        this.aQa.setSelector(f.C0146f.transparent_bg);
        this.aQb = new com.baidu.tieba.b.b(this.mPageContext, this.aQa);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.aQb.setDatas(bVar.getList());
        }
    }

    public void IO() {
        if (this.azF != TbadkCoreApplication.getInst().getSkinType()) {
            this.azF = TbadkCoreApplication.getInst().getSkinType();
            am.j(this.aQa, f.d.cp_bg_line_d);
            am.j(this.mBottomLine, f.d.cp_bg_line_c);
            this.aQb.notifyDataSetChanged();
        }
    }
}
