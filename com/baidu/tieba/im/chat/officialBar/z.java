package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class z extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ OfficialBarChatActivity b;
    private final /* synthetic */ UserData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(OfficialBarChatActivity officialBarChatActivity, UserData userData) {
        this.b = officialBarChatActivity;
        this.c = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(az.a().d(TbadkApplication.getCurrentAccount(), String.valueOf(this.c.getUserId())));
    }
}
