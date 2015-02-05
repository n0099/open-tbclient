package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.coreExtra.util.TbCountDownTimer;
/* loaded from: classes.dex */
class aq extends TbCountDownTimer {
    final /* synthetic */ ProgressCountDownView Vo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(ProgressCountDownView progressCountDownView, long j, long j2) {
        super(j, j2);
        this.Vo = progressCountDownView;
    }

    @Override // com.baidu.tbadk.coreExtra.util.TbCountDownTimer
    public void onTick(long j) {
        this.Vo.refreshPregress(j);
        this.Vo.refreshText(j);
    }

    @Override // com.baidu.tbadk.coreExtra.util.TbCountDownTimer
    public void onFinish() {
        ar arVar;
        ar arVar2;
        arVar = this.Vo.mListerner;
        if (arVar != null) {
            arVar2 = this.Vo.mListerner;
            arVar2.onFinish();
        }
    }
}
