package com.baidu.tieba.frs.frsgood;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class a extends Handler {
    final /* synthetic */ FrsGoodActivity bsj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FrsGoodActivity frsGoodActivity) {
        this.bsj = frsGoodActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.bsj.cK(false);
    }
}
