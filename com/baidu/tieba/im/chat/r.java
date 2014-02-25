package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends com.baidu.tieba.im.c<Void> {
    private final /* synthetic */ int a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Void b() {
        if (TiebaApplication.F() != null) {
            com.baidu.tieba.im.db.q.a().a(this.a);
            return null;
        }
        return null;
    }
}
