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
    private int cdL;
    private HTypeListView cvQ;
    private com.baidu.tieba.b.b cvR;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.cdL = 3;
        this.mPageContext = tbPageContext;
        this.cvQ = (HTypeListView) view.findViewById(R.id.follow_live_list);
        this.mBottomLine = view.findViewById(R.id.follow_live_bottom_line);
        this.cvQ.setSelector(R.drawable.transparent_bg);
        this.cvR = new com.baidu.tieba.b.b(this.mPageContext, this.cvQ);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.cvR.setDatas(bVar.getList());
        }
    }

    public void atu() {
        if (this.cdL != TbadkCoreApplication.getInst().getSkinType()) {
            this.cdL = TbadkCoreApplication.getInst().getSkinType();
            am.l(this.cvQ, R.color.cp_bg_line_d);
            am.l(this.mBottomLine, R.color.cp_bg_line_c);
            this.cvR.notifyDataSetChanged();
        }
    }
}
