package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ FrsLoadMoreModel bRZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(FrsLoadMoreModel frsLoadMoreModel, int i, int i2) {
        super(i, i2);
        this.bRZ = frsLoadMoreModel;
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
        this.bRZ.isLoading = false;
        if (responsedMessage == null) {
            frsActivity6 = this.bRZ.bHh;
            frsActivity7 = this.bRZ.bHh;
            frsActivity6.iP(frsActivity7.getPageContext().getString(r.l.neterror));
        } else if (responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                frsActivity5 = this.bRZ.bHh;
                frsActivity5.iP(responsedMessage.getErrorString());
                return;
            }
            frsActivity3 = this.bRZ.bHh;
            frsActivity4 = this.bRZ.bHh;
            frsActivity3.iP(frsActivity4.getPageContext().getString(r.l.neterror));
        } else {
            if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                frsActivity2 = this.bRZ.bHh;
                frsActivity2.F(((LoadMoreHttpResponseMessage) responsedMessage).getThreadList());
                this.bRZ.a((LoadMoreHttpResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                frsActivity = this.bRZ.bHh;
                frsActivity.F(((LoadMoreResponseSocketMessage) responsedMessage).getThreadList());
                this.bRZ.a((LoadMoreResponseSocketMessage) responsedMessage);
            }
            this.bRZ.loadIndex++;
        }
    }
}
