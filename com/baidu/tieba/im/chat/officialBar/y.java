package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class y extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ OfficialBarChatActivity a;
    private final /* synthetic */ UserData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(OfficialBarChatActivity officialBarChatActivity, UserData userData) {
        this.a = officialBarChatActivity;
        this.b = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(ay.a().c(TbadkApplication.getCurrentAccount(), String.valueOf(this.b.getUserId())));
    }
}
