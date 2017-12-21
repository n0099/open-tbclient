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
    public HTypeListView aFZ;
    public com.baidu.tieba.a.a aGa;
    public int apG;
    private View mBottomLine;
    public TbPageContext mPageContext;
    public View mRootView;

    public d(View view, TbPageContext tbPageContext) {
        super(view);
        this.apG = 3;
        this.mRootView = view;
        this.mPageContext = tbPageContext;
        this.aFZ = (HTypeListView) view.findViewById(d.g.listview_story_pic);
        this.mBottomLine = view.findViewById(d.g.story_bottom_line);
        this.aFZ.setSelector(d.f.transparent_bg);
        this.aGa = new com.baidu.tieba.a.a(this.mPageContext, this.aFZ);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.aGa.a(fVar.getList(), "0", "0");
        }
    }

    public void Ey() {
        if (this.apG != TbadkCoreApplication.getInst().getSkinType()) {
            this.apG = TbadkCoreApplication.getInst().getSkinType();
            aj.k(this.aFZ, d.C0095d.cp_bg_line_d);
            aj.k(this.mBottomLine, d.C0095d.cp_bg_line_c);
            this.aGa.notifyDataSetChanged();
        }
    }
}
