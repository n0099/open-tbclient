package com.baidu.tieba.im.live.livenotify;

import com.baidu.tbadk.core.util.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ LiveNotifyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LiveNotifyActivity liveNotifyActivity) {
        this.a = liveNotifyActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar;
        sVar = this.a.b;
        aj.a(sVar.f(), this.a.a(), 0, -1);
    }
}
