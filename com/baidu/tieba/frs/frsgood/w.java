package com.baidu.tieba.frs.frsgood;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.loadmore.LoadMoreHttpResponseMessage;
import com.baidu.tieba.frs.loadmore.LoadMoreResponseSocketMessage;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ v aZQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(v vVar, int i, int i2) {
        super(i, i2);
        this.aZQ = vVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        FrsGoodActivity frsGoodActivity;
        FrsGoodActivity frsGoodActivity2;
        FrsGoodActivity frsGoodActivity3;
        FrsGoodActivity frsGoodActivity4;
        FrsGoodActivity frsGoodActivity5;
        FrsGoodActivity frsGoodActivity6;
        FrsGoodActivity frsGoodActivity7;
        this.aZQ.axc = false;
        if (responsedMessage == null) {
            frsGoodActivity6 = this.aZQ.aWL;
            frsGoodActivity7 = this.aZQ.aWL;
            frsGoodActivity6.gL(frsGoodActivity7.getPageContext().getString(i.h.neterror));
        } else if (responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                frsGoodActivity5 = this.aZQ.aWL;
                frsGoodActivity5.gL(responsedMessage.getErrorString());
                return;
            }
            frsGoodActivity3 = this.aZQ.aWL;
            frsGoodActivity4 = this.aZQ.aWL;
            frsGoodActivity3.gL(frsGoodActivity4.getPageContext().getString(i.h.neterror));
        } else {
            if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                frsGoodActivity2 = this.aZQ.aWL;
                frsGoodActivity2.B(((LoadMoreHttpResponseMessage) responsedMessage).getThreadList());
            } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                frsGoodActivity = this.aZQ.aWL;
                frsGoodActivity.B(((LoadMoreResponseSocketMessage) responsedMessage).getThreadList());
            }
            this.aZQ.aZM++;
        }
    }
}
