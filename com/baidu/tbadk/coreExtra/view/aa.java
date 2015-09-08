package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.coreExtra.util.TbCountDownTimer;
import com.baidu.tbadk.coreExtra.view.ProgressCountDownView;
/* loaded from: classes.dex */
class aa extends TbCountDownTimer {
    final /* synthetic */ ProgressCountDownView anx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(ProgressCountDownView progressCountDownView, long j, long j2) {
        super(j, j2);
        this.anx = progressCountDownView;
    }

    @Override // com.baidu.tbadk.coreExtra.util.TbCountDownTimer
    public void onTick(long j) {
        this.anx.refreshPregress(j);
        this.anx.refreshText(j);
    }

    @Override // com.baidu.tbadk.coreExtra.util.TbCountDownTimer
    public void onFinish() {
        ProgressCountDownView.a aVar;
        ProgressCountDownView.a aVar2;
        aVar = this.anx.mListerner;
        if (aVar != null) {
            aVar2 = this.anx.mListerner;
            aVar2.onFinish();
        }
    }
}
