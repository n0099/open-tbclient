package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a bRr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.bRr = aVar;
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
        this.bRr.axe = false;
        if (responsedMessage == null) {
            frsActivity6 = this.bRr.bGh;
            frsActivity7 = this.bRr.bGh;
            frsActivity6.jb(frsActivity7.getPageContext().getString(u.j.neterror));
        } else if (responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                frsActivity5 = this.bRr.bGh;
                frsActivity5.jb(responsedMessage.getErrorString());
                return;
            }
            frsActivity3 = this.bRr.bGh;
            frsActivity4 = this.bRr.bGh;
            frsActivity3.jb(frsActivity4.getPageContext().getString(u.j.neterror));
        } else {
            if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                frsActivity2 = this.bRr.bGh;
                frsActivity2.L(((LoadMoreHttpResponseMessage) responsedMessage).getThreadList());
                this.bRr.a((LoadMoreHttpResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                frsActivity = this.bRr.bGh;
                frsActivity.L(((LoadMoreResponseSocketMessage) responsedMessage).getThreadList());
                this.bRr.a((LoadMoreResponseSocketMessage) responsedMessage);
            }
            this.bRr.bOh++;
        }
    }
}
