package com.baidu.tieba.frs.frsgood;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.loadmore.LoadMoreHttpResponseMessage;
import com.baidu.tieba.frs.loadmore.LoadMoreResponseSocketMessage;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ v aZJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(v vVar, int i, int i2) {
        super(i, i2);
        this.aZJ = vVar;
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
        this.aZJ.avB = false;
        if (responsedMessage == null) {
            frsGoodActivity6 = this.aZJ.aWe;
            frsGoodActivity7 = this.aZJ.aWe;
            frsGoodActivity6.gO(frsGoodActivity7.getPageContext().getString(i.h.neterror));
        } else if (responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                frsGoodActivity5 = this.aZJ.aWe;
                frsGoodActivity5.gO(responsedMessage.getErrorString());
                return;
            }
            frsGoodActivity3 = this.aZJ.aWe;
            frsGoodActivity4 = this.aZJ.aWe;
            frsGoodActivity3.gO(frsGoodActivity4.getPageContext().getString(i.h.neterror));
        } else {
            if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                frsGoodActivity2 = this.aZJ.aWe;
                frsGoodActivity2.B(((LoadMoreHttpResponseMessage) responsedMessage).getThreadList());
            } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                frsGoodActivity = this.aZJ.aWe;
                frsGoodActivity.B(((LoadMoreResponseSocketMessage) responsedMessage).getThreadList());
            }
            this.aZJ.aZF++;
        }
    }
}
