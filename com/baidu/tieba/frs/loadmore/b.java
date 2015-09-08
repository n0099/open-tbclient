package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a baH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.baH = aVar;
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
        this.baH.axc = false;
        if (responsedMessage == null) {
            frsActivity6 = this.baH.aVM;
            frsActivity7 = this.baH.aVM;
            frsActivity6.gL(frsActivity7.getPageContext().getString(i.h.neterror));
        } else if (responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                frsActivity5 = this.baH.aVM;
                frsActivity5.gL(responsedMessage.getErrorString());
                return;
            }
            frsActivity3 = this.baH.aVM;
            frsActivity4 = this.baH.aVM;
            frsActivity3.gL(frsActivity4.getPageContext().getString(i.h.neterror));
        } else {
            if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                frsActivity2 = this.baH.aVM;
                frsActivity2.B(((LoadMoreHttpResponseMessage) responsedMessage).getThreadList());
            } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                frsActivity = this.baH.aVM;
                frsActivity.B(((LoadMoreResponseSocketMessage) responsedMessage).getThreadList());
            }
            this.baH.aZM++;
        }
    }
}
