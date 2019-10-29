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
    private HTypeListView cJd;
    private com.baidu.tieba.b.b cJe;
    private int csX;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.csX = 3;
        this.mPageContext = tbPageContext;
        this.cJd = (HTypeListView) view.findViewById(R.id.follow_live_list);
        this.mBottomLine = view.findViewById(R.id.follow_live_bottom_line);
        this.cJd.setSelector(R.drawable.transparent_bg);
        this.cJe = new com.baidu.tieba.b.b(this.mPageContext, this.cJd);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.cJe.setDatas(bVar.getList());
        }
    }

    public void avs() {
        if (this.csX != TbadkCoreApplication.getInst().getSkinType()) {
            this.csX = TbadkCoreApplication.getInst().getSkinType();
            am.setBackgroundColor(this.cJd, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            this.cJe.notifyDataSetChanged();
        }
    }
}
