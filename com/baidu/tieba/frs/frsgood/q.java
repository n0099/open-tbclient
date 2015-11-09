package com.baidu.tieba.frs.frsgood;

import android.os.Handler;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class q implements NoNetworkView.a {
    final /* synthetic */ FrsGoodActivity baf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsGoodActivity frsGoodActivity) {
        this.baf = frsGoodActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ax(boolean z) {
        Handler handler;
        if (z) {
            handler = this.baf.bae;
            handler.sendEmptyMessageDelayed(0, 500L);
        }
    }
}
