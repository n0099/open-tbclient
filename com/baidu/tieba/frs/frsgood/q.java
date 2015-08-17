package com.baidu.tieba.frs.frsgood;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class q implements NoNetworkView.a {
    final /* synthetic */ FrsGoodActivity aZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsGoodActivity frsGoodActivity) {
        this.aZp = frsGoodActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ay(boolean z) {
        Handler handler;
        if (z) {
            handler = this.aZp.aZo;
            handler.sendMessageDelayed(new Message(), 500L);
        }
    }
}
