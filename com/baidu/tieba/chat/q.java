package com.baidu.tieba.chat;

import com.baidu.tieba.util.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListFragment f1195a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ChatListFragment chatListFragment) {
        this.f1195a = chatListFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1195a.J();
        } catch (Exception e) {
            bd.b("ChatListFragment", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
