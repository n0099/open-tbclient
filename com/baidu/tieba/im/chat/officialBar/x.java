package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class x extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ UserData aRF;
    final /* synthetic */ OfficialBarChatActivity aSZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(OfficialBarChatActivity officialBarChatActivity, UserData userData) {
        this.aSZ = officialBarChatActivity;
        this.aRF = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Kp */
    public Void doInBackground() {
        com.baidu.tieba.im.settingcache.h.SX().a(TbadkApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), this.aRF);
        return null;
    }
}
