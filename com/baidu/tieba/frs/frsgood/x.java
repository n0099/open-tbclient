package com.baidu.tieba.frs.frsgood;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.loadmore.LoadMoreHttpResponseMessage;
import com.baidu.tieba.frs.loadmore.LoadMoreResponseSocketMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ w bnu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(w wVar, int i, int i2) {
        super(i, i2);
        this.bnu = wVar;
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
        this.bnu.ayQ = false;
        if (responsedMessage == null) {
            frsGoodActivity6 = this.bnu.bjc;
            frsGoodActivity7 = this.bnu.bjc;
            frsGoodActivity6.ht(frsGoodActivity7.getPageContext().getString(t.j.neterror));
        } else if (responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                frsGoodActivity5 = this.bnu.bjc;
                frsGoodActivity5.ht(responsedMessage.getErrorString());
                return;
            }
            frsGoodActivity3 = this.bnu.bjc;
            frsGoodActivity4 = this.bnu.bjc;
            frsGoodActivity3.ht(frsGoodActivity4.getPageContext().getString(t.j.neterror));
        } else {
            if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                frsGoodActivity2 = this.bnu.bjc;
                frsGoodActivity2.E(((LoadMoreHttpResponseMessage) responsedMessage).getThreadList());
            } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                frsGoodActivity = this.bnu.bjc;
                frsGoodActivity.E(((LoadMoreResponseSocketMessage) responsedMessage).getThreadList());
            }
            this.bnu.bnq++;
        }
    }
}
