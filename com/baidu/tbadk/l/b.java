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
    private int cdS;
    private HTypeListView cvX;
    private com.baidu.tieba.b.b cvY;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.cdS = 3;
        this.mPageContext = tbPageContext;
        this.cvX = (HTypeListView) view.findViewById(R.id.follow_live_list);
        this.mBottomLine = view.findViewById(R.id.follow_live_bottom_line);
        this.cvX.setSelector(R.drawable.transparent_bg);
        this.cvY = new com.baidu.tieba.b.b(this.mPageContext, this.cvX);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.cvY.setDatas(bVar.getList());
        }
    }

    public void atw() {
        if (this.cdS != TbadkCoreApplication.getInst().getSkinType()) {
            this.cdS = TbadkCoreApplication.getInst().getSkinType();
            am.l(this.cvX, R.color.cp_bg_line_d);
            am.l(this.mBottomLine, R.color.cp_bg_line_c);
            this.cvY.notifyDataSetChanged();
        }
    }
}
