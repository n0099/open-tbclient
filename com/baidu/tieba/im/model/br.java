package com.baidu.tieba.im.model;

import com.baidu.tieba.im.chat.PersonalChatActivity;
/* loaded from: classes.dex */
class br extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ PersonalMsglistModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(PersonalMsglistModel personalMsglistModel) {
        this.b = personalMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        com.baidu.tieba.im.db.p.d().b(PersonalChatActivity.b);
        return null;
    }
}
