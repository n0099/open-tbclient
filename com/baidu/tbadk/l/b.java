package com.baidu.tbadk.l;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
/* loaded from: classes.dex */
public class b extends v.a {
    private HTypeListView cIm;
    private com.baidu.tieba.b.b cIn;
    private int csg;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.csg = 3;
        this.mPageContext = tbPageContext;
        this.cIm = (HTypeListView) view.findViewById(R.id.follow_live_list);
        this.mBottomLine = view.findViewById(R.id.follow_live_bottom_line);
        this.cIm.setSelector(R.drawable.transparent_bg);
        this.cIn = new com.baidu.tieba.b.b(this.mPageContext, this.cIm);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.cIn.setDatas(bVar.getList());
        }
    }

    public void avq() {
        if (this.csg != TbadkCoreApplication.getInst().getSkinType()) {
            this.csg = TbadkCoreApplication.getInst().getSkinType();
            am.setBackgroundColor(this.cIm, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            this.cIn.notifyDataSetChanged();
        }
    }
}
