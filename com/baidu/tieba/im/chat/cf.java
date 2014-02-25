package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf extends com.baidu.tieba.im.c<Boolean> {
    final /* synthetic */ MsglistActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(MsglistActivity msglistActivity) {
        this.a = msglistActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Boolean b() {
        return Boolean.valueOf(com.baidu.tieba.im.chat.personaltalk.a.b(TiebaApplication.A(), String.valueOf(this.a.e.b().getUserId())));
    }
}
