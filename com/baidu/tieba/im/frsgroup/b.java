package com.baidu.tieba.im.frsgroup;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsGroupActivity f1557a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsGroupActivity frsGroupActivity) {
        this.f1557a = frsGroupActivity;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f1557a.runOnUiThread(new c(this));
    }
}
