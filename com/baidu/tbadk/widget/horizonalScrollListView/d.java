package com.baidu.tbadk.widget.horizonalScrollListView;

import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes.dex */
class d extends com.baidu.adp.base.g {
    final /* synthetic */ c aCs;
    private final /* synthetic */ x aCt;
    private final /* synthetic */ TextView aCu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, x xVar, TextView textView) {
        this.aCs = cVar;
        this.aCt = xVar;
        this.aCu = textView;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        HorizonalScrollListView horizonalScrollListView;
        TbPageContext tbPageContext;
        HorizonalScrollListView horizonalScrollListView2;
        TbPageContext tbPageContext2;
        HorizonalScrollListView horizonalScrollListView3;
        if ((obj instanceof y) && this.aCt.getErrorCode() == 0) {
            y yVar = (y) obj;
            yVar.setLike(1);
            horizonalScrollListView3 = this.aCs.aCr;
            horizonalScrollListView3.a(this.aCu, yVar.isLike() == 1);
        } else if (AntiHelper.mC(this.aCt.getErrorCode())) {
            horizonalScrollListView2 = this.aCs.aCr;
            tbPageContext2 = horizonalScrollListView2.mTbPageContext;
            AntiHelper.Q(tbPageContext2.getPageActivity(), this.aCt.getErrorString());
        } else {
            horizonalScrollListView = this.aCs.aCr;
            tbPageContext = horizonalScrollListView.mTbPageContext;
            tbPageContext.showToast(this.aCt.getErrorString());
        }
    }
}
