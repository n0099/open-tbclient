package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.coreExtra.util.TbCountDownTimer;
/* loaded from: classes.dex */
class aq extends TbCountDownTimer {
    final /* synthetic */ ProgressCountDownView Vr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(ProgressCountDownView progressCountDownView, long j, long j2) {
        super(j, j2);
        this.Vr = progressCountDownView;
    }

    @Override // com.baidu.tbadk.coreExtra.util.TbCountDownTimer
    public void onTick(long j) {
        this.Vr.refreshPregress(j);
        this.Vr.refreshText(j);
    }

    @Override // com.baidu.tbadk.coreExtra.util.TbCountDownTimer
    public void onFinish() {
        ar arVar;
        ar arVar2;
        arVar = this.Vr.mListerner;
        if (arVar != null) {
            arVar2 = this.Vr.mListerner;
            arVar2.onFinish();
        }
    }
}
