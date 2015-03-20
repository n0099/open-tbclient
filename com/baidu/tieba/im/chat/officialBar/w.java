package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class w extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ OfficialBarChatActivity aYU;
    private final /* synthetic */ UserData aYW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(OfficialBarChatActivity officialBarChatActivity, UserData userData) {
        this.aYU = officialBarChatActivity;
        this.aYW = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.h.Tp().aF(TbadkApplication.getCurrentAccount(), String.valueOf(this.aYW.getUserId())));
    }
}
