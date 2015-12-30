package com.baidu.tbadk.widget.a;

import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes.dex */
class e extends com.baidu.adp.base.g {
    final /* synthetic */ d aEa;
    private final /* synthetic */ x aEb;
    private final /* synthetic */ TextView aEc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, x xVar, TextView textView) {
        this.aEa = dVar;
        this.aEb = xVar;
        this.aEc = textView;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        a aVar;
        TbPageContext tbPageContext;
        a aVar2;
        TbPageContext tbPageContext2;
        a aVar3;
        if ((obj instanceof y) && this.aEb.getErrorCode() == 0) {
            y yVar = (y) obj;
            yVar.setLike(1);
            aVar3 = this.aEa.aDZ;
            aVar3.a(this.aEc, yVar.isLike() == 1);
        } else if (AntiHelper.ne(this.aEb.getErrorCode())) {
            aVar2 = this.aEa.aDZ;
            tbPageContext2 = aVar2.mTbPageContext;
            AntiHelper.Q(tbPageContext2.getPageActivity(), this.aEb.getErrorString());
        } else {
            aVar = this.aEa.aDZ;
            tbPageContext = aVar.mTbPageContext;
            tbPageContext.showToast(this.aEb.getErrorString());
        }
    }
}
