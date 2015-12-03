package com.baidu.tieba.frs.frsgood;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.loadmore.LoadMoreHttpResponseMessage;
import com.baidu.tieba.frs.loadmore.LoadMoreResponseSocketMessage;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ v bgG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(v vVar, int i, int i2) {
        super(i, i2);
        this.bgG = vVar;
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
        this.bgG.awu = false;
        if (responsedMessage == null) {
            frsGoodActivity6 = this.bgG.bcs;
            frsGoodActivity7 = this.bgG.bcs;
            frsGoodActivity6.hh(frsGoodActivity7.getPageContext().getString(n.i.neterror));
        } else if (responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                frsGoodActivity5 = this.bgG.bcs;
                frsGoodActivity5.hh(responsedMessage.getErrorString());
                return;
            }
            frsGoodActivity3 = this.bgG.bcs;
            frsGoodActivity4 = this.bgG.bcs;
            frsGoodActivity3.hh(frsGoodActivity4.getPageContext().getString(n.i.neterror));
        } else {
            if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                frsGoodActivity2 = this.bgG.bcs;
                frsGoodActivity2.E(((LoadMoreHttpResponseMessage) responsedMessage).getThreadList());
            } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                frsGoodActivity = this.bgG.bcs;
                frsGoodActivity.E(((LoadMoreResponseSocketMessage) responsedMessage).getThreadList());
            }
            this.bgG.bgC++;
        }
    }
}
