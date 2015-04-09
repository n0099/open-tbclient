package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a aNm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.aNm = aVar;
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
        this.aNm.anb = false;
        if (responsedMessage == null) {
            frsActivity6 = this.aNm.aKd;
            frsActivity7 = this.aNm.aKd;
            frsActivity6.onFailed(frsActivity7.getPageContext().getString(y.neterror));
        } else if (responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                frsActivity5 = this.aNm.aKd;
                frsActivity5.onFailed(responsedMessage.getErrorString());
                return;
            }
            frsActivity3 = this.aNm.aKd;
            frsActivity4 = this.aNm.aKd;
            frsActivity3.onFailed(frsActivity4.getPageContext().getString(y.neterror));
        } else {
            if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                frsActivity2 = this.aNm.aKd;
                frsActivity2.w(((LoadMoreHttpResponseMessage) responsedMessage).getThreadList());
            } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                frsActivity = this.aNm.aKd;
                frsActivity.w(((LoadMoreResponseSocketMessage) responsedMessage).getThreadList());
            }
            this.aNm.aNi++;
        }
    }
}
