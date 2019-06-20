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
    private int ccJ;
    private HTypeListView cuC;
    private com.baidu.tieba.b.b cuD;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.ccJ = 3;
        this.mPageContext = tbPageContext;
        this.cuC = (HTypeListView) view.findViewById(R.id.follow_live_list);
        this.mBottomLine = view.findViewById(R.id.follow_live_bottom_line);
        this.cuC.setSelector(R.drawable.transparent_bg);
        this.cuD = new com.baidu.tieba.b.b(this.mPageContext, this.cuC);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.cuD.setDatas(bVar.getList());
        }
    }

    public void asn() {
        if (this.ccJ != TbadkCoreApplication.getInst().getSkinType()) {
            this.ccJ = TbadkCoreApplication.getInst().getSkinType();
            al.l(this.cuC, R.color.cp_bg_line_d);
            al.l(this.mBottomLine, R.color.cp_bg_line_c);
            this.cuD.notifyDataSetChanged();
        }
    }
}
