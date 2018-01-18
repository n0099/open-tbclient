package com.baidu.tbadk.i;

import android.view.View;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
/* loaded from: classes.dex */
public class b extends r.a {
    private int bdK;
    private HTypeListView buc;
    private com.baidu.tieba.a.b bud;
    private View mBottomLine;
    private TbPageContext mPageContext;

    public b(View view, TbPageContext tbPageContext) {
        super(view);
        this.bdK = 3;
        this.mPageContext = tbPageContext;
        this.buc = (HTypeListView) view.findViewById(d.g.follow_live_list);
        this.mBottomLine = view.findViewById(d.g.follow_live_bottom_line);
        this.buc.setSelector(d.f.transparent_bg);
        this.bud = new com.baidu.tieba.a.b(this.mPageContext, this.buc);
    }

    public void a(com.baidu.tbadk.data.b bVar) {
        if (bVar != null) {
            this.bud.setDatas(bVar.getList());
        }
    }

    public void LN() {
        if (this.bdK != TbadkCoreApplication.getInst().getSkinType()) {
            this.bdK = TbadkCoreApplication.getInst().getSkinType();
            aj.t(this.buc, d.C0107d.cp_bg_line_d);
            aj.t(this.mBottomLine, d.C0107d.cp_bg_line_c);
            this.bud.notifyDataSetChanged();
        }
    }
}
