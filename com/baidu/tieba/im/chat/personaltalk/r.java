package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class r {
    private final BlackListModel aVo;
    private PersonalTalkSettingActivity aVp;
    private w aVq;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.c.a aVl = new com.baidu.tbadk.coreExtra.c.a(null);
    private boolean Rq = false;
    private boolean aVm = false;
    private boolean aVn = false;
    private com.baidu.adp.framework.listener.e mListener = new s(this, 0);
    private CustomMessageListener mCustomListener = new t(this, 0);

    public boolean Lc() {
        return this.aVn;
    }

    public void cC(boolean z) {
        this.aVn = z;
    }

    public DataRes Ld() {
        return this.data;
    }

    public boolean Le() {
        return this.aVm;
    }

    public r(PersonalTalkSettingActivity personalTalkSettingActivity, w wVar, long j) {
        this.aVp = personalTalkSettingActivity;
        this.aVq = wVar;
        this.aVo = new BlackListModel(personalTalkSettingActivity);
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
        this.aVp.showLoadingDialog(null);
        if (z) {
            this.aVo.addToBlackList(this.data.id.longValue());
        } else {
            this.aVo.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.aVl != null) {
            this.aVl.cancel();
        }
        if (this.aVo != null) {
            this.aVo.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e Lf() {
        return this.mListener;
    }

    public CustomMessageListener Lg() {
        return this.mCustomListener;
    }
}
