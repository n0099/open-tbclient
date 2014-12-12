package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class y extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ UserData aRI;
    final /* synthetic */ OfficialBarChatActivity aSZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(OfficialBarChatActivity officialBarChatActivity, UserData userData) {
        this.aSZ = officialBarChatActivity;
        this.aRI = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.h.SX().aE(TbadkApplication.getCurrentAccount(), String.valueOf(this.aRI.getUserId())));
    }
}
