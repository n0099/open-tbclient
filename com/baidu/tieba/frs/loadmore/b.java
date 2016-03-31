package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a btl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.btl = aVar;
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
        this.btl.azx = false;
        if (responsedMessage == null) {
            frsActivity6 = this.btl.blH;
            frsActivity7 = this.btl.blH;
            frsActivity6.hJ(frsActivity7.getPageContext().getString(t.j.neterror));
        } else if (responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                frsActivity5 = this.btl.blH;
                frsActivity5.hJ(responsedMessage.getErrorString());
                return;
            }
            frsActivity3 = this.btl.blH;
            frsActivity4 = this.btl.blH;
            frsActivity3.hJ(frsActivity4.getPageContext().getString(t.j.neterror));
        } else {
            if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                frsActivity2 = this.btl.blH;
                frsActivity2.B(((LoadMoreHttpResponseMessage) responsedMessage).getThreadList());
                this.btl.a((LoadMoreHttpResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                frsActivity = this.btl.blH;
                frsActivity.B(((LoadMoreResponseSocketMessage) responsedMessage).getThreadList());
                this.btl.a((LoadMoreResponseSocketMessage) responsedMessage);
            }
            this.btl.bsn++;
        }
    }
}
