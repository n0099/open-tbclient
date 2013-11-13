package com.baidu.tieba.chat;

import com.baidu.tieba.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListFragment f1142a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ChatListFragment chatListFragment) {
        this.f1142a = chatListFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1142a.I();
        } catch (Exception e) {
            bg.b("ChatListFragment", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
