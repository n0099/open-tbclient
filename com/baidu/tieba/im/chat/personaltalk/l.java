package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import protobuf.QueryUserInfos.QueryUserInfosRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l extends com.baidu.adp.framework.c.g {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(k kVar, int i) {
        super(0);
        this.a = kVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        p pVar;
        p pVar2;
        PersonalTalkSettingActivity personalTalkSettingActivity;
        PersonalTalkSettingActivity personalTalkSettingActivity2;
        QueryUserInfosRes.DataRes dataRes;
        QueryUserInfosRes.DataRes dataRes2;
        PersonalTalkSettingActivity personalTalkSettingActivity3;
        p pVar3;
        p pVar4;
        PersonalTalkSettingActivity personalTalkSettingActivity4;
        PersonalTalkSettingActivity personalTalkSettingActivity5;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 != null) {
            switch (socketResponsedMessage2.g()) {
                case 104102:
                    if (socketResponsedMessage2 instanceof com.baidu.adp.framework.message.f) {
                        personalTalkSettingActivity = this.a.h;
                        personalTalkSettingActivity.closeLoadingDialog();
                        if (socketResponsedMessage2.e() != 0) {
                            personalTalkSettingActivity2 = this.a.h;
                            personalTalkSettingActivity2.showToast(socketResponsedMessage2.f());
                        }
                    }
                    if (socketResponsedMessage2 instanceof ResponseUpdateMaskInfoMessage) {
                        ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage2;
                        if (responseUpdateMaskInfoMessage.h() instanceof com.baidu.tbadk.core.message.d) {
                            com.baidu.tbadk.core.message.d dVar = (com.baidu.tbadk.core.message.d) responseUpdateMaskInfoMessage.h();
                            if (dVar.i() == 10) {
                                this.a.e = dVar.j() == 1;
                                pVar = this.a.i;
                                if (pVar != null) {
                                    pVar2 = this.a.i;
                                    pVar2.a();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 205003:
                    if ((socketResponsedMessage2 instanceof com.baidu.adp.framework.message.f) && socketResponsedMessage2.e() != 0) {
                        personalTalkSettingActivity4 = this.a.h;
                        personalTalkSettingActivity4.hideProgressBar();
                        personalTalkSettingActivity5 = this.a.h;
                        personalTalkSettingActivity5.showToast(socketResponsedMessage2.f());
                        return;
                    } else if (socketResponsedMessage2 instanceof ResponseQueryUserInfoMessage) {
                        ResponseQueryUserInfoMessage responseQueryUserInfoMessage = (ResponseQueryUserInfoMessage) socketResponsedMessage2;
                        if (responseQueryUserInfoMessage.d() != null) {
                            this.a.c = responseQueryUserInfoMessage.d();
                            k kVar = this.a;
                            dataRes = this.a.c;
                            kVar.d = dataRes.getHasConcerned() == 1;
                            k kVar2 = this.a;
                            dataRes2 = this.a.c;
                            kVar2.e = dataRes2.getIsBlacklist() == 1;
                            personalTalkSettingActivity3 = this.a.h;
                            personalTalkSettingActivity3.hideProgressBar();
                            pVar3 = this.a.i;
                            if (pVar3 != null) {
                                pVar4 = this.a.i;
                                pVar4.a();
                                return;
                            }
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
