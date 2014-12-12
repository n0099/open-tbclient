package com.baidu.tieba.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class ad extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ UserData aRI;
    final /* synthetic */ FloatingPersonalChatActivity aYF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.aYF = floatingPersonalChatActivity;
        this.aRI = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.j.SY().aE(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aRI.getUserId())));
    }
}
