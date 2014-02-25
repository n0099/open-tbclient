package com.baidu.tieba.im.model;

import com.baidu.tieba.im.chat.PersonalChatActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.tieba.im.c<Void> {
    final /* synthetic */ MsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Void b() {
        com.baidu.tieba.im.db.q.a().a(PersonalChatActivity.b);
        return null;
    }
}
