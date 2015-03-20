package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class v extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ OfficialBarChatActivity aYU;
    private final /* synthetic */ UserData aYV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(OfficialBarChatActivity officialBarChatActivity, UserData userData) {
        this.aYU = officialBarChatActivity;
        this.aYV = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: ER */
    public Void doInBackground() {
        com.baidu.tieba.im.settingcache.h.Tp().a(TbadkApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), this.aYV);
        return null;
    }
}
