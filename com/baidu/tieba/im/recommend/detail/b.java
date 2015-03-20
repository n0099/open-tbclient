package com.baidu.tieba.im.recommend.detail;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ RecommendDetailActivity blW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(RecommendDetailActivity recommendDetailActivity) {
        this.blW = recommendDetailActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVar;
        iVar = this.blW.blU;
        iVar.setSwitch(true);
    }
}
