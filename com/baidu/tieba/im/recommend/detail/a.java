package com.baidu.tieba.im.recommend.detail;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ RecommendDetailActivity bmm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(RecommendDetailActivity recommendDetailActivity) {
        this.bmm = recommendDetailActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVar;
        iVar = this.bmm.bmk;
        iVar.setSwitch(false);
    }
}
