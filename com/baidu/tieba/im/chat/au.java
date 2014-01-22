package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends SingleRunnable<Boolean> {
    final /* synthetic */ as a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar) {
        this.a = asVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        return Boolean.valueOf(com.baidu.tieba.im.groupInfo.u.b(TiebaApplication.A(), this.a.c()));
    }
}
