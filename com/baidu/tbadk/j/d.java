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
    public HTypeListView aFj;
    public com.baidu.tieba.a.a aFk;
    public int api;
    private View mBottomLine;
    public TbPageContext mPageContext;
    public View mRootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.api = 3;
        this.mRootView = view;
        this.mPageContext = tbPageContext;
        this.aFj = (HTypeListView) view.findViewById(d.g.listview_story_pic);
        this.mBottomLine = view.findViewById(d.g.story_bottom_line);
        this.aFj.setSelector(d.f.transparent_bg);
        this.aFk = new com.baidu.tieba.a.a(this.mPageContext, this.aFj);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.aFk.a(fVar.getList(), "0", "0");
        }
    }

    public void Ee() {
        if (this.api != TbadkCoreApplication.getInst().getSkinType()) {
            this.api = TbadkCoreApplication.getInst().getSkinType();
            aj.k(this.aFj, d.C0080d.cp_bg_line_d);
            aj.k(this.mBottomLine, d.C0080d.cp_bg_line_c);
            this.aFk.notifyDataSetChanged();
        }
    }
}
