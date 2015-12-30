package com.baidu.tieba.frs.frsgood;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.loadmore.LoadMoreHttpResponseMessage;
import com.baidu.tieba.frs.loadmore.LoadMoreResponseSocketMessage;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ v bkx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(v vVar, int i, int i2) {
        super(i, i2);
        this.bkx = vVar;
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
        this.bkx.axY = false;
        if (responsedMessage == null) {
            frsGoodActivity6 = this.bkx.bgr;
            frsGoodActivity7 = this.bkx.bgr;
            frsGoodActivity6.hs(frsGoodActivity7.getPageContext().getString(n.j.neterror));
        } else if (responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                frsGoodActivity5 = this.bkx.bgr;
                frsGoodActivity5.hs(responsedMessage.getErrorString());
                return;
            }
            frsGoodActivity3 = this.bkx.bgr;
            frsGoodActivity4 = this.bkx.bgr;
            frsGoodActivity3.hs(frsGoodActivity4.getPageContext().getString(n.j.neterror));
        } else {
            if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                frsGoodActivity2 = this.bkx.bgr;
                frsGoodActivity2.C(((LoadMoreHttpResponseMessage) responsedMessage).getThreadList());
            } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                frsGoodActivity = this.bkx.bgr;
                frsGoodActivity.C(((LoadMoreResponseSocketMessage) responsedMessage).getThreadList());
            }
            this.bkx.bkt++;
        }
    }
}
