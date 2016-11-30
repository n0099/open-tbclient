package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a cga;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.cga = aVar;
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
        this.cga.aAG = false;
        if (responsedMessage == null) {
            frsActivity6 = this.cga.bTA;
            frsActivity7 = this.cga.bTA;
            frsActivity6.jU(frsActivity7.getPageContext().getString(r.j.neterror));
        } else if (responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                frsActivity5 = this.cga.bTA;
                frsActivity5.jU(responsedMessage.getErrorString());
                return;
            }
            frsActivity3 = this.cga.bTA;
            frsActivity4 = this.cga.bTA;
            frsActivity3.jU(frsActivity4.getPageContext().getString(r.j.neterror));
        } else {
            if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                frsActivity2 = this.cga.bTA;
                frsActivity2.M(((LoadMoreHttpResponseMessage) responsedMessage).getThreadList());
                this.cga.a((LoadMoreHttpResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                frsActivity = this.cga.bTA;
                frsActivity.M(((LoadMoreResponseSocketMessage) responsedMessage).getThreadList());
                this.cga.a((LoadMoreResponseSocketMessage) responsedMessage);
            }
            this.cga.ccT++;
        }
    }
}
