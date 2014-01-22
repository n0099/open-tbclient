package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r extends SingleRunnable<Void> {
    final /* synthetic */ int a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        if (TiebaApplication.F() != null) {
            com.baidu.tieba.im.db.au.a().a(this.a);
            return null;
        }
        return null;
    }
}
