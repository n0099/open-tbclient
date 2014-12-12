package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tieba.im.message.RequestQueryUserInfoMessage;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tieba.im.g<PersonalSettingItemData> {
    private final /* synthetic */ long aQT;
    final /* synthetic */ o aTZ;
    private final /* synthetic */ PersonalTalkSettingActivity aUa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar, long j, PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.aTZ = oVar;
        this.aQT = j;
        this.aUa = personalTalkSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: a */
    public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
        if (personalSettingItemData != null) {
            this.aTZ.aTV = personalSettingItemData.isAcceptNotify();
        }
        RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
        requestQueryUserInfoMessage.setReqUserId(this.aQT);
        this.aUa.sendMessage(requestQueryUserInfoMessage);
    }
}
