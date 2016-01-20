package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a blx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.blx = aVar;
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
        this.blx.axY = false;
        if (responsedMessage == null) {
            frsActivity6 = this.blx.beB;
            frsActivity7 = this.blx.beB;
            frsActivity6.ht(frsActivity7.getPageContext().getString(n.j.neterror));
        } else if (responsedMessage.getError() != 0) {
            if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                frsActivity5 = this.blx.beB;
                frsActivity5.ht(responsedMessage.getErrorString());
                return;
            }
            frsActivity3 = this.blx.beB;
            frsActivity4 = this.blx.beB;
            frsActivity3.ht(frsActivity4.getPageContext().getString(n.j.neterror));
        } else {
            if (responsedMessage instanceof LoadMoreHttpResponseMessage) {
                frsActivity2 = this.blx.beB;
                frsActivity2.C(((LoadMoreHttpResponseMessage) responsedMessage).getThreadList());
            } else if (responsedMessage instanceof LoadMoreResponseSocketMessage) {
                frsActivity = this.blx.beB;
                frsActivity.C(((LoadMoreResponseSocketMessage) responsedMessage).getThreadList());
            }
            this.blx.bkt++;
        }
    }
}
