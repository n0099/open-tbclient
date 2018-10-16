package com.baidu.tbadk.j;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
/* loaded from: classes.dex */
public class b extends q.a {
    private int aHp;
    private HTypeListView aXR;
    private com.baidu.tieba.b.b aXS;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.aHp = 3;
        this.mPageContext = tbPageContext;
        this.aXR = (HTypeListView) view.findViewById(e.g.follow_live_list);
        this.mBottomLine = view.findViewById(e.g.follow_live_bottom_line);
        this.aXR.setSelector(e.f.transparent_bg);
        this.aXS = new com.baidu.tieba.b.b(this.mPageContext, this.aXR);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.aXS.setDatas(bVar.getList());
        }
    }

    public void Mc() {
        if (this.aHp != TbadkCoreApplication.getInst().getSkinType()) {
            this.aHp = TbadkCoreApplication.getInst().getSkinType();
            al.j(this.aXR, e.d.cp_bg_line_d);
            al.j(this.mBottomLine, e.d.cp_bg_line_c);
            this.aXS.notifyDataSetChanged();
        }
    }
}
