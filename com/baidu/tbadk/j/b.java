package com.baidu.tbadk.j;

import android.view.View;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.data.e;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
/* loaded from: classes.dex */
public class b extends j.a {
    public HTypeListView aFw;
    public com.baidu.tieba.a.a aFx;
    public int apS;
    private View axX;
    public TbPageContext mF;
    public View mRootView;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.apS = 3;
        this.mRootView = view;
        this.mF = tbPageContext;
        this.aFw = (HTypeListView) view.findViewById(d.h.listview_story_pic);
        this.axX = view.findViewById(d.h.story_bottom_line);
        this.aFw.setSelector(d.g.transparent_bg);
        this.aFx = new com.baidu.tieba.a.a(this.mF, this.aFw);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.aFx.a(eVar.Co(), "0", "0");
        }
    }

    public void Es() {
        if (this.apS != TbadkCoreApplication.getInst().getSkinType()) {
            this.apS = TbadkCoreApplication.getInst().getSkinType();
            aj.k(this.aFw, d.e.cp_bg_line_d);
            aj.k(this.axX, d.e.cp_bg_line_c);
            this.aFx.notifyDataSetChanged();
        }
    }
}
