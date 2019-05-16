package com.baidu.tbadk.l;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
/* loaded from: classes.dex */
public class b extends v.a {
    private int ccI;
    private HTypeListView cuB;
    private com.baidu.tieba.b.b cuC;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.ccI = 3;
        this.mPageContext = tbPageContext;
        this.cuB = (HTypeListView) view.findViewById(R.id.follow_live_list);
        this.mBottomLine = view.findViewById(R.id.follow_live_bottom_line);
        this.cuB.setSelector(R.drawable.transparent_bg);
        this.cuC = new com.baidu.tieba.b.b(this.mPageContext, this.cuB);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.cuC.setDatas(bVar.getList());
        }
    }

    public void asn() {
        if (this.ccI != TbadkCoreApplication.getInst().getSkinType()) {
            this.ccI = TbadkCoreApplication.getInst().getSkinType();
            al.l(this.cuB, R.color.cp_bg_line_d);
            al.l(this.mBottomLine, R.color.cp_bg_line_c);
            this.cuC.notifyDataSetChanged();
        }
    }
}
