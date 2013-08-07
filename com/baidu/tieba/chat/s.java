package com.baidu.tieba.chat;

import com.baidu.tieba.util.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListActivity f948a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ChatListActivity chatListActivity) {
        this.f948a = chatListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f948a.d();
        } catch (Exception e) {
            aj.b("ChatListActivity", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
