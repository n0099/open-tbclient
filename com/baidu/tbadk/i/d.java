package com.baidu.tbadk.i;

import android.view.View;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.data.f;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
/* loaded from: classes.dex */
public class d extends j.a {
    public HTypeListView aFS;
    public com.baidu.tieba.a.a aFT;
    public int apA;
    private View mBottomLine;
    public TbPageContext mPageContext;
    public View mRootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.apA = 3;
        this.mRootView = view;
        this.mPageContext = tbPageContext;
        this.aFS = (HTypeListView) view.findViewById(d.g.listview_story_pic);
        this.mBottomLine = view.findViewById(d.g.story_bottom_line);
        this.aFS.setSelector(d.f.transparent_bg);
        this.aFT = new com.baidu.tieba.a.a(this.mPageContext, this.aFS);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.aFT.a(fVar.getList(), "0", "0");
        }
    }

    public void Ex() {
        if (this.apA != TbadkCoreApplication.getInst().getSkinType()) {
            this.apA = TbadkCoreApplication.getInst().getSkinType();
            aj.k(this.aFS, d.C0082d.cp_bg_line_d);
            aj.k(this.mBottomLine, d.C0082d.cp_bg_line_c);
            this.aFT.notifyDataSetChanged();
        }
    }
}
