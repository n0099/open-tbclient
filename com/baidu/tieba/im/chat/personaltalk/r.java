package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class r {
    private final BlackListModel aVp;
    private PersonalTalkSettingActivity aVq;
    private w aVr;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.c.a aVm = new com.baidu.tbadk.coreExtra.c.a(null);
    private boolean Rt = false;
    private boolean aVn = false;
    private boolean aVo = false;
    private com.baidu.adp.framework.listener.e mListener = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    public boolean Lh() {
        return this.aVo;
    }

    public void cC(boolean z) {
        this.aVo = z;
    }

    public DataRes Li() {
        return this.data;
    }

    public boolean Lj() {
        return this.aVn;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, w wVar, long j) {
        this.aVq = personalTalkSettingActivity;
        this.aVr = wVar;
        this.aVp = new BlackListModel(personalTalkSettingActivity);
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tieba.im.i.a(new u(this, j), new v(this, j, personalTalkSettingActivity));
    }

    public void cD(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void cE(boolean z) {
        this.aVq.showLoadingDialog(null);
        if (z) {
            this.aVp.addToBlackList(this.data.id.longValue());
        } else {
            this.aVp.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.aVm != null) {
            this.aVm.cancel();
        }
        if (this.aVp != null) {
            this.aVp.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e Lk() {
        return this.mListener;
    }

    public CustomMessageListener Ll() {
        return this.mCustomListener;
    }
}
