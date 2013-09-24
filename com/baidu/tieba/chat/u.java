package com.baidu.tieba.chat;

import com.baidu.tieba.util.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListFragment f977a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ChatListFragment chatListFragment) {
        this.f977a = chatListFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f977a.D();
        } catch (Exception e) {
            av.b("ChatListFragment", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
