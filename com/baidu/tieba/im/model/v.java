package com.baidu.tieba.im.model;

import com.baidu.tieba.im.chat.PersonalChatActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ MsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* bridge */ /* synthetic */ Void a() {
        com.baidu.tieba.im.db.q.a().a(PersonalChatActivity.b);
        return null;
    }
}
