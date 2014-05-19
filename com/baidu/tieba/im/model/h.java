package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ CommonPersonalMsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(CommonPersonalMsglistModel commonPersonalMsglistModel) {
        this.a = commonPersonalMsglistModel;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.t.finish();
    }
}
