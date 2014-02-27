package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
/* loaded from: classes.dex */
final class g implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.a = eVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        PersonalTalkSettingActivity personalTalkSettingActivity2;
        long j;
        PersonalTalkSettingActivity personalTalkSettingActivity3;
        long j2;
        personalTalkSettingActivity = this.a.a;
        personalTalkSettingActivity.closeLoadingDialog();
        com.baidu.tieba.im.messageCenter.d.a().e(new com.baidu.tieba.im.message.h());
        com.baidu.tieba.im.db.d d = com.baidu.tieba.im.db.h.a().d();
        personalTalkSettingActivity2 = this.a.a;
        j = personalTalkSettingActivity2.c;
        ImMessageCenterPojo a = d.a(String.valueOf(j));
        if (a != null) {
            a.setLast_content(" ");
            a.setLast_user_name(" ");
            a.setLast_rid(0L);
            d.a(a);
        }
        StringBuilder sb = new StringBuilder("clear cache by person:");
        personalTalkSettingActivity3 = this.a.a;
        j2 = personalTalkSettingActivity3.c;
        TiebaSocketLinkService.a(true, sb.append(j2).toString());
    }
}
