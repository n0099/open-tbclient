package com.baidu.tbadk.j;

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
    public HTypeListView aFr;
    public com.baidu.tieba.a.a aFs;
    public int aph;
    private View mBottomLine;
    public TbPageContext mPageContext;
    public View mRootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.aph = 3;
        this.mRootView = view;
        this.mPageContext = tbPageContext;
        this.aFr = (HTypeListView) view.findViewById(d.g.listview_story_pic);
        this.mBottomLine = view.findViewById(d.g.story_bottom_line);
        this.aFr.setSelector(d.f.transparent_bg);
        this.aFs = new com.baidu.tieba.a.a(this.mPageContext, this.aFr);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.aFs.a(fVar.getList(), "0", "0");
        }
    }

    public void Eq() {
        if (this.aph != TbadkCoreApplication.getInst().getSkinType()) {
            this.aph = TbadkCoreApplication.getInst().getSkinType();
            aj.k(this.aFr, d.C0080d.cp_bg_line_d);
            aj.k(this.mBottomLine, d.C0080d.cp_bg_line_c);
            this.aFs.notifyDataSetChanged();
        }
    }
}
