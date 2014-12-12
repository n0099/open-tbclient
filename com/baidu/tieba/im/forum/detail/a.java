package com.baidu.tieba.im.forum.detail;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ ForumDetailActivity aZe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForumDetailActivity forumDetailActivity) {
        this.aZe = forumDetailActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        k kVar;
        kVar = this.aZe.aZa;
        kVar.setSwitch(false);
    }
}
