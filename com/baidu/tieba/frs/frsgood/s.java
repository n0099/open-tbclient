package com.baidu.tieba.frs.frsgood;

import android.os.Handler;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class s implements NoNetworkView.a {
    final /* synthetic */ FrsGoodActivity bsj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsGoodActivity frsGoodActivity) {
        this.bsj = frsGoodActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aA(boolean z) {
        Handler handler;
        if (z) {
            handler = this.bsj.bsi;
            handler.sendEmptyMessageDelayed(0, 500L);
        }
    }
}
