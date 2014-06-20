package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.GroupDeleteMsgResponsedMessage;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        PersonalTalkSettingActivity personalTalkSettingActivity2;
        long j;
        PersonalTalkSettingActivity personalTalkSettingActivity3;
        long j2;
        personalTalkSettingActivity = this.a.a;
        personalTalkSettingActivity.closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new GroupDeleteMsgResponsedMessage());
        personalTalkSettingActivity2 = this.a.a;
        j = personalTalkSettingActivity2.c;
        ImMessageCenterPojo a = com.baidu.tieba.im.b.e.a(String.valueOf(j));
        if (a != null) {
            a.setLast_content(" ");
            a.setLast_user_name(" ");
            a.setLast_rid(0L);
        }
        StringBuilder sb = new StringBuilder("clear cache by person:");
        personalTalkSettingActivity3 = this.a.a;
        j2 = personalTalkSettingActivity3.c;
        BdSocketLinkService.startService(true, sb.append(j2).toString());
    }
}
