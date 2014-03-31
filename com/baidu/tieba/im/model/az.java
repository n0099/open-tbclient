package com.baidu.tieba.im.model;

import com.baidu.tieba.im.chat.snapGroup.SnapGroupChatActivity;
/* loaded from: classes.dex */
final class az extends com.baidu.tieba.im.m<Void> {
    final /* synthetic */ OfficialBarMsglistModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(OfficialBarMsglistModel officialBarMsglistModel) {
        this.b = officialBarMsglistModel;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Void a() {
        com.baidu.tieba.im.db.m.d().b(SnapGroupChatActivity.b);
        return null;
    }
}
