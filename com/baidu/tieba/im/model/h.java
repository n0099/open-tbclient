package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
final class h implements Runnable {
    final /* synthetic */ CommonPersonalMsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(CommonPersonalMsglistModel commonPersonalMsglistModel) {
        this.a = commonPersonalMsglistModel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c.finish();
    }
}
