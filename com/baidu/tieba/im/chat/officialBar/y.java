package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
final class y extends com.baidu.tieba.im.m<Void> {
    final /* synthetic */ OfficialBarChatActivity b;
    private final /* synthetic */ UserData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(OfficialBarChatActivity officialBarChatActivity, UserData userData) {
        this.b = officialBarChatActivity;
        this.c = userData;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Void a() {
        bb.a().a(TbadkApplication.E(), OfficialBarChatActivity.b, this.c);
        return null;
    }
}
