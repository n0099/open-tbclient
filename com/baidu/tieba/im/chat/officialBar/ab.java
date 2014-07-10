package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class ab extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ OfficialBarChatActivity b;
    private final /* synthetic */ UserData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(OfficialBarChatActivity officialBarChatActivity, UserData userData) {
        this.b = officialBarChatActivity;
        this.c = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        bd.a().a(TbadkApplication.getCurrentAccount(), OfficialBarChatActivity.b, this.c);
        return null;
    }
}
