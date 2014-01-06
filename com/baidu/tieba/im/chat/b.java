package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends SingleRunnable<Void> {
    final /* synthetic */ int a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        if (TiebaApplication.G() != null) {
            com.baidu.tieba.im.db.as.a().a(this.a);
            return null;
        }
        return null;
    }
}
