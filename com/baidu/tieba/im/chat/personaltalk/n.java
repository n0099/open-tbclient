package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class n {
    private final BlackListModel aSv;
    private PersonalTalkSettingActivity aSw;
    private s aSx;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.b.a aSs = new com.baidu.tbadk.coreExtra.b.a(null);
    private boolean Ll = false;
    private boolean aSt = false;
    private boolean aSu = false;
    private com.baidu.adp.framework.listener.e ayJ = new o(this, 0);
    private CustomMessageListener mCustomListener = new p(this, 0);

    public boolean KG() {
        return this.aSu;
    }

    public void cL(boolean z) {
        this.aSu = z;
    }

    public DataRes KH() {
        return this.data;
    }

    public boolean KI() {
        return this.aSt;
    }

    public n(PersonalTalkSettingActivity personalTalkSettingActivity, s sVar, long j) {
        this.aSw = personalTalkSettingActivity;
        this.aSx = sVar;
        this.aSv = new BlackListModel(personalTalkSettingActivity);
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tieba.im.e.a(new q(this, j), new r(this, j, personalTalkSettingActivity));
    }

    public void cM(boolean z) {
        this.aSw.showLoadingDialog(null);
        if (z) {
            this.aSv.addToBlackList(this.data.id.longValue());
        } else {
            this.aSv.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.aSs != null) {
            this.aSs.cancel();
        }
        if (this.aSv != null) {
            this.aSv.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e KJ() {
        return this.ayJ;
    }

    public CustomMessageListener KK() {
        return this.mCustomListener;
    }
}
