package com.baidu.tieba.im.model;

import com.baidu.tieba.im.chat.PersonalChatActivity;
/* loaded from: classes.dex */
final class bl extends com.baidu.tieba.im.m<Void> {
    final /* synthetic */ PersonalMsglistModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(PersonalMsglistModel personalMsglistModel) {
        this.b = personalMsglistModel;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Void a() {
        com.baidu.tieba.im.db.n.d().b(PersonalChatActivity.b);
        return null;
    }
}
