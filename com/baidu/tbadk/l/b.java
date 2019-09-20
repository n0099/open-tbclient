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
    private int ceL;
    private HTypeListView cwT;
    private com.baidu.tieba.b.b cwU;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.ceL = 3;
        this.mPageContext = tbPageContext;
        this.cwT = (HTypeListView) view.findViewById(R.id.follow_live_list);
        this.mBottomLine = view.findViewById(R.id.follow_live_bottom_line);
        this.cwT.setSelector(R.drawable.transparent_bg);
        this.cwU = new com.baidu.tieba.b.b(this.mPageContext, this.cwT);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.cwU.setDatas(bVar.getList());
        }
    }

    public void atI() {
        if (this.ceL != TbadkCoreApplication.getInst().getSkinType()) {
            this.ceL = TbadkCoreApplication.getInst().getSkinType();
            am.l(this.cwT, R.color.cp_bg_line_d);
            am.l(this.mBottomLine, R.color.cp_bg_line_c);
            this.cwU.notifyDataSetChanged();
        }
    }
}
