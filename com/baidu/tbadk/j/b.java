package com.baidu.tbadk.j;

import android.view.View;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.data.e;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
/* loaded from: classes.dex */
public class b extends j.a {
    public HTypeListView aGc;
    public com.baidu.tieba.a.a aGd;
    public TbPageContext alI;
    public int aql;
    public View mRootView;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.aql = 3;
        this.mRootView = view;
        this.alI = tbPageContext;
        this.aGc = (HTypeListView) view.findViewById(d.h.listview_story_pic);
        this.aGc.setSelector(d.g.transparent_bg);
        this.aGd = new com.baidu.tieba.a.a(this.alI, this.aGc);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.aGd.a(eVar.Ct(), "0", "0");
        }
    }

    public void Eu() {
        if (this.aql != TbadkCoreApplication.getInst().getSkinType()) {
            this.aql = TbadkCoreApplication.getInst().getSkinType();
            ai.k(this.aGc, d.e.cp_bg_line_e);
            this.aGd.notifyDataSetChanged();
        }
    }
}
