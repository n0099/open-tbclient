package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a ccD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.ccD = aVar;
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
        this.ccD.azO = false;
        if (responsedMessage == null) {
            frsActivity6 = this.ccD.bRi;
            frsActivity7 = this.ccD.bRi;
            frsActivity6.jR(frsActivity7.getPageContext().getString(r.j.neterror));
        } else if (responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                frsActivity5 = this.ccD.bRi;
                frsActivity5.jR(responsedMessage.getErrorString());
                return;
            }
            frsActivity3 = this.ccD.bRi;
            frsActivity4 = this.ccD.bRi;
            frsActivity3.jR(frsActivity4.getPageContext().getString(r.j.neterror));
        } else {
            if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                frsActivity2 = this.ccD.bRi;
                frsActivity2.L(((LoadMoreHttpResponseMessage) responsedMessage).getThreadList());
                this.ccD.a((LoadMoreHttpResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                frsActivity = this.ccD.bRi;
                frsActivity.L(((LoadMoreResponseSocketMessage) responsedMessage).getThreadList());
                this.ccD.a((LoadMoreResponseSocketMessage) responsedMessage);
            }
            this.ccD.bZw++;
        }
    }
}
