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
    public com.baidu.tieba.a.a aEA;
    public HTypeListView aEz;
    public int aoN;
    private View mBottomLine;
    public TbPageContext mH;
    public View mRootView;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.aoN = 3;
        this.mRootView = view;
        this.mH = tbPageContext;
        this.aEz = (HTypeListView) view.findViewById(d.h.listview_story_pic);
        this.mBottomLine = view.findViewById(d.h.story_bottom_line);
        this.aEz.setSelector(d.g.transparent_bg);
        this.aEA = new com.baidu.tieba.a.a(this.mH, this.aEz);
    }

    public void a(com.baidu.tbadk.data.d dVar) {
        if (dVar != null) {
            this.aEA.a(dVar.BL(), "0", "0");
        }
    }

    public void DQ() {
        if (this.aoN != TbadkCoreApplication.getInst().getSkinType()) {
            this.aoN = TbadkCoreApplication.getInst().getSkinType();
            aj.k(this.aEz, d.e.cp_bg_line_d);
            aj.k(this.mBottomLine, d.e.cp_bg_line_c);
            this.aEA.notifyDataSetChanged();
        }
    }
}
