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
    public HTypeListView aGe;
    public com.baidu.tieba.a.a aGf;
    public int aqm;
    private View ayM;
    public View mRootView;
    public TbPageContext oW;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.aqm = 3;
        this.mRootView = view;
        this.oW = tbPageContext;
        this.aGe = (HTypeListView) view.findViewById(d.h.listview_story_pic);
        this.ayM = view.findViewById(d.h.story_bottom_line);
        this.aGe.setSelector(d.g.transparent_bg);
        this.aGf = new com.baidu.tieba.a.a(this.oW, this.aGe);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.aGf.a(eVar.Ct(), "0", "0");
        }
    }

    public void Eu() {
        if (this.aqm != TbadkCoreApplication.getInst().getSkinType()) {
            this.aqm = TbadkCoreApplication.getInst().getSkinType();
            ai.k(this.aGe, d.e.cp_bg_line_d);
            ai.k(this.ayM, d.e.cp_bg_line_c);
            this.aGf.notifyDataSetChanged();
        }
    }
}
