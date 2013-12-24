package com.baidu.tieba;

import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bb implements com.baidu.tieba.im.a<Integer> {
    final /* synthetic */ AccountData a;
    final /* synthetic */ TiebaApplication b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(AccountData accountData, TiebaApplication tiebaApplication) {
        this.a = accountData;
        this.b = tiebaApplication;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Integer num) {
        com.baidu.tieba.im.chat.a.a = num.intValue();
        com.baidu.tieba.im.i.a(this.a, this.b);
        com.baidu.tieba.im.m.b();
    }
}
