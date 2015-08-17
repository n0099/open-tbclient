package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a bam;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.bam = aVar;
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
        this.bam.avu = false;
        if (responsedMessage == null) {
            frsActivity6 = this.bam.aVx;
            frsActivity7 = this.bam.aVx;
            frsActivity6.gE(frsActivity7.getPageContext().getString(i.C0057i.neterror));
        } else if (responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                frsActivity5 = this.bam.aVx;
                frsActivity5.gE(responsedMessage.getErrorString());
                return;
            }
            frsActivity3 = this.bam.aVx;
            frsActivity4 = this.bam.aVx;
            frsActivity3.gE(frsActivity4.getPageContext().getString(i.C0057i.neterror));
        } else {
            if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                frsActivity2 = this.bam.aVx;
                frsActivity2.C(((LoadMoreHttpResponseMessage) responsedMessage).getThreadList());
            } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                frsActivity = this.bam.aVx;
                frsActivity.C(((LoadMoreResponseSocketMessage) responsedMessage).getThreadList());
            }
            this.bam.aZt++;
        }
    }
}
