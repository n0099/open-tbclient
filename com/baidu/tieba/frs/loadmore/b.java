package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a bom;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.bom = aVar;
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
        this.bom.ayQ = false;
        if (responsedMessage == null) {
            frsActivity6 = this.bom.bgW;
            frsActivity7 = this.bom.bgW;
            frsActivity6.ht(frsActivity7.getPageContext().getString(t.j.neterror));
        } else if (responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                frsActivity5 = this.bom.bgW;
                frsActivity5.ht(responsedMessage.getErrorString());
                return;
            }
            frsActivity3 = this.bom.bgW;
            frsActivity4 = this.bom.bgW;
            frsActivity3.ht(frsActivity4.getPageContext().getString(t.j.neterror));
        } else {
            if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                frsActivity2 = this.bom.bgW;
                frsActivity2.E(((LoadMoreHttpResponseMessage) responsedMessage).getThreadList());
            } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                frsActivity = this.bom.bgW;
                frsActivity.E(((LoadMoreResponseSocketMessage) responsedMessage).getThreadList());
            }
            this.bom.bnq++;
        }
    }
}
