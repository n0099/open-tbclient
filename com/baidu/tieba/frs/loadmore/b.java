package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a bbe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.bbe = aVar;
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
        this.bbe.auq = false;
        if (responsedMessage == null) {
            frsActivity6 = this.bbe.aVn;
            frsActivity7 = this.bbe.aVn;
            frsActivity6.gQ(frsActivity7.getPageContext().getString(i.h.neterror));
        } else if (responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                frsActivity5 = this.bbe.aVn;
                frsActivity5.gQ(responsedMessage.getErrorString());
                return;
            }
            frsActivity3 = this.bbe.aVn;
            frsActivity4 = this.bbe.aVn;
            frsActivity3.gQ(frsActivity4.getPageContext().getString(i.h.neterror));
        } else {
            if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                frsActivity2 = this.bbe.aVn;
                frsActivity2.B(((LoadMoreHttpResponseMessage) responsedMessage).getThreadList());
            } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                frsActivity = this.bbe.aVn;
                frsActivity.B(((LoadMoreResponseSocketMessage) responsedMessage).getThreadList());
            }
            this.bbe.baj++;
        }
    }
}
