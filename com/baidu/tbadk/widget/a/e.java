package com.baidu.tbadk.widget.a;

import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes.dex */
class e extends com.baidu.adp.base.g {
    final /* synthetic */ d aGl;
    private final /* synthetic */ w aGm;
    private final /* synthetic */ TextView aGn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, w wVar, TextView textView) {
        this.aGl = dVar;
        this.aGm = wVar;
        this.aGn = textView;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        a aVar;
        TbPageContext tbPageContext;
        a aVar2;
        TbPageContext tbPageContext2;
        a aVar3;
        if ((obj instanceof x) && this.aGm.getErrorCode() == 0) {
            x xVar = (x) obj;
            xVar.setLike(1);
            aVar3 = this.aGl.aGk;
            aVar3.a(this.aGn, xVar.isLike() == 1);
        } else if (AntiHelper.pB(this.aGm.getErrorCode())) {
            aVar2 = this.aGl.aGk;
            tbPageContext2 = aVar2.mTbPageContext;
            AntiHelper.O(tbPageContext2.getPageActivity(), this.aGm.getErrorString());
        } else {
            aVar = this.aGl.aGk;
            tbPageContext = aVar.mTbPageContext;
            tbPageContext.showToast(this.aGm.getErrorString());
        }
    }
}
