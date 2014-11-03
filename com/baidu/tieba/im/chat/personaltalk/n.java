package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tieba.im.model.BlackListModel;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes.dex */
public class n {
    private final BlackListModel aSJ;
    private PersonalTalkSettingActivity aSK;
    private s aSL;
    private DataRes data;
    private com.baidu.tbadk.coreExtra.b.a aSG = new com.baidu.tbadk.coreExtra.b.a(null);
    private boolean Lo = false;
    private boolean aSH = false;
    private boolean aSI = false;
    private com.baidu.adp.framework.listener.e ayS = new o(this, 0);
    private CustomMessageListener mCustomListener = new p(this, 0);

    public boolean KK() {
        return this.aSI;
    }

    public void cL(boolean z) {
        this.aSI = z;
    }

    public DataRes KL() {
        return this.data;
    }

    public boolean KM() {
        return this.aSH;
    }

    public n(PersonalTalkSettingActivity personalTalkSettingActivity, s sVar, long j) {
        this.aSK = personalTalkSettingActivity;
        this.aSL = sVar;
        this.aSJ = new BlackListModel(personalTalkSettingActivity);
        personalTalkSettingActivity.showProgressBar();
        com.baidu.tieba.im.e.a(new q(this, j), new r(this, j, personalTalkSettingActivity));
    }

    public void cM(boolean z) {
        this.aSK.showLoadingDialog(null);
        if (z) {
            this.aSJ.addToBlackList(this.data.id.longValue());
        } else {
            this.aSJ.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.aSG != null) {
            this.aSG.cancel();
        }
        if (this.aSJ != null) {
            this.aSJ.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.e KN() {
        return this.ayS;
    }

    public CustomMessageListener KO() {
        return this.mCustomListener;
    }
}
