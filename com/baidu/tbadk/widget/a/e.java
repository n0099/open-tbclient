package com.baidu.tbadk.widget.a;

import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes.dex */
class e extends com.baidu.adp.base.g {
    final /* synthetic */ d aEQ;
    private final /* synthetic */ w aER;
    private final /* synthetic */ TextView aES;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, w wVar, TextView textView) {
        this.aEQ = dVar;
        this.aER = wVar;
        this.aES = textView;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        a aVar;
        TbPageContext tbPageContext;
        a aVar2;
        TbPageContext tbPageContext2;
        a aVar3;
        if ((obj instanceof x) && this.aER.getErrorCode() == 0) {
            x xVar = (x) obj;
            xVar.setLike(1);
            aVar3 = this.aEQ.aEP;
            aVar3.a(this.aES, xVar.isLike() == 1);
        } else if (AntiHelper.or(this.aER.getErrorCode())) {
            aVar2 = this.aEQ.aEP;
            tbPageContext2 = aVar2.mTbPageContext;
            AntiHelper.X(tbPageContext2.getPageActivity(), this.aER.getErrorString());
        } else {
            aVar = this.aEQ.aEP;
            tbPageContext = aVar.mTbPageContext;
            tbPageContext.showToast(this.aER.getErrorString());
        }
    }
}
