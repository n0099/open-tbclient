package com.baidu.tieba.frs.frsgood;

import android.os.Handler;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class q implements NoNetworkView.a {
    final /* synthetic */ FrsGoodActivity bkp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsGoodActivity frsGoodActivity) {
        this.bkp = frsGoodActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ax(boolean z) {
        Handler handler;
        if (z) {
            handler = this.bkp.bko;
            handler.sendEmptyMessageDelayed(0, 500L);
        }
    }
}
