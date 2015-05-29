package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a aPy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.aPy = aVar;
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
        this.aPy.aoe = false;
        if (responsedMessage == null) {
            frsActivity6 = this.aPy.aMk;
            frsActivity7 = this.aPy.aMk;
            frsActivity6.onFailed(frsActivity7.getPageContext().getString(t.neterror));
        } else if (responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                frsActivity5 = this.aPy.aMk;
                frsActivity5.onFailed(responsedMessage.getErrorString());
                return;
            }
            frsActivity3 = this.aPy.aMk;
            frsActivity4 = this.aPy.aMk;
            frsActivity3.onFailed(frsActivity4.getPageContext().getString(t.neterror));
        } else {
            if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                frsActivity2 = this.aPy.aMk;
                frsActivity2.v(((LoadMoreHttpResponseMessage) responsedMessage).getThreadList());
            } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                frsActivity = this.aPy.aMk;
                frsActivity.v(((LoadMoreResponseSocketMessage) responsedMessage).getThreadList());
            }
            this.aPy.aPu++;
        }
    }
}
