package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a bPE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.bPE = aVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        FrsActivity frsActivity7;
        this.bPE.awp = false;
        if (responsedMessage == null) {
            frsActivity6 = this.bPE.bET;
            frsActivity7 = this.bPE.bET;
            frsActivity6.iV(frsActivity7.getPageContext().getString(u.j.neterror));
        } else if (responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                frsActivity5 = this.bPE.bET;
                frsActivity5.iV(responsedMessage.getErrorString());
                return;
            }
            frsActivity3 = this.bPE.bET;
            frsActivity4 = this.bPE.bET;
            frsActivity3.iV(frsActivity4.getPageContext().getString(u.j.neterror));
        } else {
            if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                frsActivity2 = this.bPE.bET;
                frsActivity2.K(((LoadMoreHttpResponseMessage) responsedMessage).getThreadList());
                this.bPE.a((LoadMoreHttpResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                frsActivity = this.bPE.bET;
                frsActivity.K(((LoadMoreResponseSocketMessage) responsedMessage).getThreadList());
                this.bPE.a((LoadMoreResponseSocketMessage) responsedMessage);
            }
            this.bPE.bMx++;
        }
    }
}
