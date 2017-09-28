package com.baidu.tbadk.i;

import android.view.View;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
/* loaded from: classes.dex */
public class b extends j.a {
    public HTypeListView aEM;
    public com.baidu.tieba.a.a aEN;
    public int aoZ;
    private View mBottomLine;
    public TbPageContext mG;
    public View mRootView;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.aoZ = 3;
        this.mRootView = view;
        this.mG = tbPageContext;
        this.aEM = (HTypeListView) view.findViewById(d.h.listview_story_pic);
        this.mBottomLine = view.findViewById(d.h.story_bottom_line);
        this.aEM.setSelector(d.g.transparent_bg);
        this.aEN = new com.baidu.tieba.a.a(this.mG, this.aEM);
    }

    public void a(com.baidu.tbadk.data.d dVar) {
        if (dVar != null) {
            this.aEN.a(dVar.BR(), "0", "0");
        }
    }

    public void DW() {
        if (this.aoZ != TbadkCoreApplication.getInst().getSkinType()) {
            this.aoZ = TbadkCoreApplication.getInst().getSkinType();
            aj.k(this.aEM, d.e.cp_bg_line_d);
            aj.k(this.mBottomLine, d.e.cp_bg_line_c);
            this.aEN.notifyDataSetChanged();
        }
    }
}
