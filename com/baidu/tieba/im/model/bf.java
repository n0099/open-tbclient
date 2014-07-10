package com.baidu.tieba.im.model;

import com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity;
/* loaded from: classes.dex */
class bf extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ OfficialBarMsglistModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(OfficialBarMsglistModel officialBarMsglistModel) {
        this.b = officialBarMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        com.baidu.tieba.im.db.o.d().b(OfficialBarChatActivity.b);
        return null;
    }
}
