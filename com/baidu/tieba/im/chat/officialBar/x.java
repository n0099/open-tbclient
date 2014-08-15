package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ OfficialBarChatActivity a;
    private final /* synthetic */ UserData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(OfficialBarChatActivity officialBarChatActivity, UserData userData) {
        this.a = officialBarChatActivity;
        this.b = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        ay.a().a(TbadkApplication.getCurrentAccount(), OfficialBarChatActivity.b, this.b);
        return null;
    }
}
