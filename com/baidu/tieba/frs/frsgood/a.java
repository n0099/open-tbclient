package com.baidu.tieba.frs.frsgood;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class a extends Handler {
    final /* synthetic */ FrsGoodActivity aZM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FrsGoodActivity frsGoodActivity) {
        this.aZM = frsGoodActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.aZM.ci(false);
    }
}
