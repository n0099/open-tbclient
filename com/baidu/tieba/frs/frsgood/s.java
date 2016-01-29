package com.baidu.tieba.frs.frsgood;

import android.os.Handler;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class s implements NoNetworkView.a {
    final /* synthetic */ FrsGoodActivity bnm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsGoodActivity frsGoodActivity) {
        this.bnm = frsGoodActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ay(boolean z) {
        Handler handler;
        if (z) {
            handler = this.bnm.bnl;
            handler.sendEmptyMessageDelayed(0, 500L);
        }
    }
}
