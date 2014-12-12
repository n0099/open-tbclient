package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import protobuf.QueryUserInfos.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ o aTZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(o oVar, int i) {
        super(i);
        this.aTZ = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        DataRes dataRes;
        DataRes dataRes2;
        PersonalTalkSettingActivity personalTalkSettingActivity;
        t tVar;
        t tVar2;
        PersonalTalkSettingActivity personalTalkSettingActivity2;
        PersonalTalkSettingActivity personalTalkSettingActivity3;
        t tVar3;
        t tVar4;
        PersonalTalkSettingActivity personalTalkSettingActivity4;
        PersonalTalkSettingActivity personalTalkSettingActivity5;
        if (socketResponsedMessage != null) {
            switch (socketResponsedMessage.getCmd()) {
                case 104102:
                    if (socketResponsedMessage instanceof ResponsedMessage) {
                        personalTalkSettingActivity4 = this.aTZ.aTX;
                        personalTalkSettingActivity4.closeLoadingDialog();
                        if (socketResponsedMessage.getError() != 0) {
                            personalTalkSettingActivity5 = this.aTZ.aTX;
                            personalTalkSettingActivity5.showToast(socketResponsedMessage.getErrorString());
                        }
                    }
                    if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                        ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                        if (responseUpdateMaskInfoMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage) {
                            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) responseUpdateMaskInfoMessage.getOrginalMessage();
                            if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                                this.aTZ.aTU = requestUpdateMaskInfoMessage.getIsMask() == 1;
                                tVar3 = this.aTZ.aTY;
                                if (tVar3 != null) {
                                    tVar4 = this.aTZ.aTY;
                                    tVar4.qw();
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
                        personalTalkSettingActivity2 = this.aTZ.aTX;
                        personalTalkSettingActivity2.hideProgressBar();
                        personalTalkSettingActivity3 = this.aTZ.aTX;
                        personalTalkSettingActivity3.showToast(socketResponsedMessage.getErrorString());
                        return;
                    } else if (socketResponsedMessage instanceof ResponseQueryUserInfoMessage) {
                        ResponseQueryUserInfoMessage responseQueryUserInfoMessage = (ResponseQueryUserInfoMessage) socketResponsedMessage;
                        if (responseQueryUserInfoMessage.getResData() != null) {
                            this.aTZ.data = responseQueryUserInfoMessage.getResData();
                            o oVar = this.aTZ;
                            dataRes = this.aTZ.data;
                            oVar.QP = dataRes.hasConcerned.intValue() == 1;
                            o oVar2 = this.aTZ;
                            dataRes2 = this.aTZ.data;
                            oVar2.aTU = dataRes2.isBlacklist.intValue() == 1;
                            personalTalkSettingActivity = this.aTZ.aTX;
                            personalTalkSettingActivity.hideProgressBar();
                            tVar = this.aTZ.aTY;
                            if (tVar != null) {
                                tVar2 = this.aTZ.aTY;
                                tVar2.qw();
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
