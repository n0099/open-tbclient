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
    public HTypeListView aEM;
    public com.baidu.tieba.a.a aEN;
    public TbPageContext ako;
    public int aoR;
    private View axt;
    public View mRootView;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.aoR = 3;
        this.mRootView = view;
        this.ako = tbPageContext;
        this.aEM = (HTypeListView) view.findViewById(d.h.listview_story_pic);
        this.axt = view.findViewById(d.h.story_bottom_line);
        this.aEM.setSelector(d.g.transparent_bg);
        this.aEN = new com.baidu.tieba.a.a(this.ako, this.aEM);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.aEN.a(eVar.Cl(), "0", "0");
        }
    }

    public void Em() {
        if (this.aoR != TbadkCoreApplication.getInst().getSkinType()) {
            this.aoR = TbadkCoreApplication.getInst().getSkinType();
            ai.k(this.aEM, d.e.cp_bg_line_d);
            ai.k(this.axt, d.e.cp_bg_line_c);
            this.aEN.notifyDataSetChanged();
        }
    }
}
