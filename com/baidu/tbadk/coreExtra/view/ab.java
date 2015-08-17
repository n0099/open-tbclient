package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.coreExtra.util.TbCountDownTimer;
import com.baidu.tbadk.coreExtra.view.ProgressCountDownView;
/* loaded from: classes.dex */
class ab extends TbCountDownTimer {
    final /* synthetic */ ProgressCountDownView alL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(ProgressCountDownView progressCountDownView, long j, long j2) {
        super(j, j2);
        this.alL = progressCountDownView;
    }

    @Override // com.baidu.tbadk.coreExtra.util.TbCountDownTimer
    public void onTick(long j) {
        this.alL.refreshPregress(j);
        this.alL.refreshText(j);
    }

    @Override // com.baidu.tbadk.coreExtra.util.TbCountDownTimer
    public void onFinish() {
        ProgressCountDownView.a aVar;
        ProgressCountDownView.a aVar2;
        aVar = this.alL.mListerner;
        if (aVar != null) {
            aVar2 = this.alL.mListerner;
            aVar2.onFinish();
        }
    }
}
