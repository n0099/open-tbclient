package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class o {
    private final BlackListModel aTW;
    private PersonalTalkSettingActivity aTX;
    private t aTY;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.c.a aTT = new com.baidu.tbadk.coreExtra.c.a(null);
    private boolean QP = false;
    private boolean aTU = false;
    private boolean aTV = false;
    private com.baidu.adp.framework.listener.e mListener = new p(this, 0);
    private CustomMessageListener mCustomListener = new q(this, 0);

    public boolean KM() {
        return this.aTV;
    }

    public void cy(boolean z) {
        this.aTV = z;
    }

    public DataRes KN() {
        return this.data;
    }

    public boolean KO() {
        return this.aTU;
    }

    public o(PersonalTalkSettingActivity personalTalkSettingActivity, t tVar, long j) {
        this.aTX = personalTalkSettingActivity;
        this.aTY = tVar;
        this.aTW = new BlackListModel(personalTalkSettingActivity);
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tieba.im.i.a(new r(this, j), new s(this, j, personalTalkSettingActivity));
    }

    public void cz(boolean z) {
        this.aTX.showLoadingDialog(null);
        if (z) {
            this.aTW.addToBlackList(this.data.id.longValue());
        } else {
            this.aTW.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.aTT != null) {
            this.aTT.cancel();
        }
        if (this.aTW != null) {
            this.aTW.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e KP() {
        return this.mListener;
    }

    public CustomMessageListener KQ() {
        return this.mCustomListener;
    }
}
