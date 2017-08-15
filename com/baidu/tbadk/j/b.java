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
    public HTypeListView aGd;
    public com.baidu.tieba.a.a aGe;
    public int aqm;
    private View ayL;
    public View mRootView;
    public TbPageContext oV;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.aqm = 3;
        this.mRootView = view;
        this.oV = tbPageContext;
        this.aGd = (HTypeListView) view.findViewById(d.h.listview_story_pic);
        this.ayL = view.findViewById(d.h.story_bottom_line);
        this.aGd.setSelector(d.g.transparent_bg);
        this.aGe = new com.baidu.tieba.a.a(this.oV, this.aGd);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.aGe.a(eVar.Ct(), "0", "0");
        }
    }

    public void Eu() {
        if (this.aqm != TbadkCoreApplication.getInst().getSkinType()) {
            this.aqm = TbadkCoreApplication.getInst().getSkinType();
            ai.k(this.aGd, d.e.cp_bg_line_d);
            ai.k(this.ayL, d.e.cp_bg_line_c);
            this.aGe.notifyDataSetChanged();
        }
    }
}
