package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.coreExtra.util.TbCountDownTimer;
/* loaded from: classes.dex */
class ap extends TbCountDownTimer {
    final /* synthetic */ ProgressCountDownView afD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(ProgressCountDownView progressCountDownView, long j, long j2) {
        super(j, j2);
        this.afD = progressCountDownView;
    }

    @Override // com.baidu.tbadk.coreExtra.util.TbCountDownTimer
    public void onTick(long j) {
        this.afD.refreshPregress(j);
        this.afD.refreshText(j);
    }

    @Override // com.baidu.tbadk.coreExtra.util.TbCountDownTimer
    public void onFinish() {
        aq aqVar;
        aq aqVar2;
        aqVar = this.afD.mListerner;
        if (aqVar != null) {
            aqVar2 = this.afD.mListerner;
            aqVar2.onFinish();
        }
    }
}
