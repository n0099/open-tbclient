package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import protobuf.QueryUserInfos.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(l lVar, int i) {
        super(i);
        this.a = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        DataRes dataRes;
        DataRes dataRes2;
        PersonalTalkSettingActivity personalTalkSettingActivity;
        q qVar;
        q qVar2;
        PersonalTalkSettingActivity personalTalkSettingActivity2;
        PersonalTalkSettingActivity personalTalkSettingActivity3;
        q qVar3;
        q qVar4;
        PersonalTalkSettingActivity personalTalkSettingActivity4;
        PersonalTalkSettingActivity personalTalkSettingActivity5;
        if (socketResponsedMessage != null) {
            switch (socketResponsedMessage.getCmd()) {
                case 104102:
                    if (socketResponsedMessage instanceof ResponsedMessage) {
                        personalTalkSettingActivity4 = this.a.g;
                        personalTalkSettingActivity4.closeLoadingDialog();
                        if (socketResponsedMessage.getError() != 0) {
                            personalTalkSettingActivity5 = this.a.g;
                            personalTalkSettingActivity5.showToast(socketResponsedMessage.getErrorString());
                        }
                    }
                    if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                        ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                        if (responseUpdateMaskInfoMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage) {
                            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) responseUpdateMaskInfoMessage.getOrginalMessage();
                            if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                                this.a.d = requestUpdateMaskInfoMessage.getIsMask() == 1;
                                qVar3 = this.a.h;
                                if (qVar3 != null) {
                                    qVar4 = this.a.h;
                                    qVar4.a();
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
                    if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() != 0) {
                        personalTalkSettingActivity2 = this.a.g;
                        personalTalkSettingActivity2.hideProgressBar();
                        personalTalkSettingActivity3 = this.a.g;
                        personalTalkSettingActivity3.showToast(socketResponsedMessage.getErrorString());
                        return;
                    } else if (socketResponsedMessage instanceof ResponseQueryUserInfoMessage) {
                        ResponseQueryUserInfoMessage responseQueryUserInfoMessage = (ResponseQueryUserInfoMessage) socketResponsedMessage;
                        if (responseQueryUserInfoMessage.getResData() != null) {
                            this.a.b = responseQueryUserInfoMessage.getResData();
                            l lVar = this.a;
                            dataRes = this.a.b;
                            lVar.c = dataRes.hasConcerned.intValue() == 1;
                            l lVar2 = this.a;
                            dataRes2 = this.a.b;
                            lVar2.d = dataRes2.isBlacklist.intValue() == 1;
                            personalTalkSettingActivity = this.a.g;
                            personalTalkSettingActivity.hideProgressBar();
                            qVar = this.a.h;
                            if (qVar != null) {
                                qVar2 = this.a.h;
                                qVar2.a();
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
