package com.baidu.tieba.bubble;
/* loaded from: classes.dex */
class c implements s {
    final /* synthetic */ BubbleChooseActivity aja;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BubbleChooseActivity bubbleChooseActivity) {
        this.aja = bubbleChooseActivity;
    }

    @Override // com.baidu.tieba.bubble.s
    public void dV(int i) {
        g gVar;
        this.aja.dU(i);
        gVar = this.aja.aiS;
        gVar.showProgressBar();
    }

    @Override // com.baidu.tieba.bubble.s
    public void yi() {
    }
}
