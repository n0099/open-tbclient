package com.baidu.tieba.bubble;
/* loaded from: classes.dex */
class c implements s {
    final /* synthetic */ BubbleChooseActivity ajj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BubbleChooseActivity bubbleChooseActivity) {
        this.ajj = bubbleChooseActivity;
    }

    @Override // com.baidu.tieba.bubble.s
    public void dV(int i) {
        g gVar;
        this.ajj.dU(i);
        gVar = this.ajj.ajb;
        gVar.showProgressBar();
    }

    @Override // com.baidu.tieba.bubble.s
    public void yk() {
    }
}
