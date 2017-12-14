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
    public HTypeListView aFW;
    public com.baidu.tieba.a.a aFX;
    public int apD;
    private View mBottomLine;
    public TbPageContext mPageContext;
    public View mRootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.apD = 3;
        this.mRootView = view;
        this.mPageContext = tbPageContext;
        this.aFW = (HTypeListView) view.findViewById(d.g.listview_story_pic);
        this.mBottomLine = view.findViewById(d.g.story_bottom_line);
        this.aFW.setSelector(d.f.transparent_bg);
        this.aFX = new com.baidu.tieba.a.a(this.mPageContext, this.aFW);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.aFX.a(fVar.getList(), "0", "0");
        }
    }

    public void Ey() {
        if (this.apD != TbadkCoreApplication.getInst().getSkinType()) {
            this.apD = TbadkCoreApplication.getInst().getSkinType();
            aj.k(this.aFW, d.C0096d.cp_bg_line_d);
            aj.k(this.mBottomLine, d.C0096d.cp_bg_line_c);
            this.aFX.notifyDataSetChanged();
        }
    }
}
