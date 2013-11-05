package com.baidu.tieba.im.b;

import com.baidu.tieba.home.EnterForumActivity;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1384a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.f1384a = dVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        EnterForumActivity enterForumActivity;
        enterForumActivity = this.f1384a.d;
        enterForumActivity.runOnUiThread(new h(this));
    }
}
