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
    public HTypeListView aFt;
    public com.baidu.tieba.a.a aFu;
    public int apQ;
    private View axU;
    public TbPageContext mF;
    public View mRootView;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.apQ = 3;
        this.mRootView = view;
        this.mF = tbPageContext;
        this.aFt = (HTypeListView) view.findViewById(d.h.listview_story_pic);
        this.axU = view.findViewById(d.h.story_bottom_line);
        this.aFt.setSelector(d.g.transparent_bg);
        this.aFu = new com.baidu.tieba.a.a(this.mF, this.aFt);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.aFu.a(eVar.Co(), "0", "0");
        }
    }

    public void Es() {
        if (this.apQ != TbadkCoreApplication.getInst().getSkinType()) {
            this.apQ = TbadkCoreApplication.getInst().getSkinType();
            aj.k(this.aFt, d.e.cp_bg_line_d);
            aj.k(this.axU, d.e.cp_bg_line_c);
            this.aFu.notifyDataSetChanged();
        }
    }
}
