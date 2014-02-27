package com.baidu.tieba.im.randchat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q implements e {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(WaittingActivity waittingActivity) {
        this.a = waittingActivity;
    }

    @Override // com.baidu.tieba.im.randchat.e
    public final void a(String str) {
        WaittingActivity.a(this.a, str);
    }
}
