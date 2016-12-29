package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a bLJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.bLJ = aVar;
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
        this.bLJ.aAd = false;
        if (responsedMessage == null) {
            frsActivity6 = this.bLJ.bzH;
            frsActivity7 = this.bLJ.bzH;
            frsActivity6.iA(frsActivity7.getPageContext().getString(r.j.neterror));
        } else if (responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                frsActivity5 = this.bLJ.bzH;
                frsActivity5.iA(responsedMessage.getErrorString());
                return;
            }
            frsActivity3 = this.bLJ.bzH;
            frsActivity4 = this.bLJ.bzH;
            frsActivity3.iA(frsActivity4.getPageContext().getString(r.j.neterror));
        } else {
            if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                frsActivity2 = this.bLJ.bzH;
                frsActivity2.D(((LoadMoreHttpResponseMessage) responsedMessage).getThreadList());
                this.bLJ.a((LoadMoreHttpResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                frsActivity = this.bLJ.bzH;
                frsActivity.D(((LoadMoreResponseSocketMessage) responsedMessage).getThreadList());
                this.bLJ.a((LoadMoreResponseSocketMessage) responsedMessage);
            }
            this.bLJ.bIA++;
        }
    }
}
