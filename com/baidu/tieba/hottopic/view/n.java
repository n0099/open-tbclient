package com.baidu.tieba.hottopic.view;

import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes.dex */
class n extends com.baidu.adp.base.g {
    private final /* synthetic */ w aER;
    private final /* synthetic */ TextView aES;
    final /* synthetic */ m bNp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, w wVar, TextView textView) {
        this.bNp = mVar;
        this.aER = wVar;
        this.aES = textView;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        j jVar;
        TbPageContext tbPageContext;
        j jVar2;
        TbPageContext tbPageContext2;
        j jVar3;
        if ((obj instanceof x) && this.aER.getErrorCode() == 0) {
            x xVar = (x) obj;
            xVar.setLike(1);
            jVar3 = this.bNp.bNo;
            jVar3.a(this.aES, xVar.isLike() == 1);
        } else if (AntiHelper.or(this.aER.getErrorCode())) {
            jVar2 = this.bNp.bNo;
            tbPageContext2 = jVar2.mTbPageContext;
            AntiHelper.X(tbPageContext2.getPageActivity(), this.aER.getErrorString());
        } else {
            jVar = this.bNp.bNo;
            tbPageContext = jVar.mTbPageContext;
            tbPageContext.showToast(this.aER.getErrorString());
        }
    }
}
