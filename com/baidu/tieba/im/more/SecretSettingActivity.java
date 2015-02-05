package com.baidu.tieba.im.more;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.IMBlackListActivityConfig;
import com.baidu.tbadk.core.atomData.SecretSettingActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    private g bjQ;
    private a bjR;
    private boolean bjS = false;
    private j bjT = new b(this);
    private HttpMessageListener bjU = new c(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
    private com.baidu.adp.framework.listener.a bjV = new e(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(SecretSettingActivityConfig.class, SecretSettingActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bjQ = new g(this);
        this.bjR = new a();
        this.bjQ.a(this.bjT);
        if (this.bjR.Rx()) {
            this.bjQ.dh(true);
            this.bjQ.b(this.bjR);
        } else {
            this.bjQ.dh(false);
        }
        this.bjQ.di(TbadkCoreApplication.m255getInst().getLocationShared());
        registerListener(this.bjV);
        registerListener(this.bjU);
        vN();
        sendMessage(new RequestPrivacySetting());
    }

    private void vN() {
        MessageManager.getInstance().registerTask(uU());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.GET_PRIVATE_INFO_CMD, O("c/u/user/getPrivateInfo", 303016));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(ResponsedPrivacyHttpMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static String O(String str, int i) {
        return String.valueOf(TbConfig.SERVER_ADDRESS) + str + "?cmd=" + i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bjQ.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.bjQ.RH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(String str, String str2) {
        if (this.bjS) {
            com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(getPageContext().getPageActivity());
            iVar.a(getResources().getStringArray(r.privacy_setting_config), new f(this, str)).bU(str2);
            iVar.e(getPageContext()).nS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RC() {
        sendMessage(new CustomMessage(2008001, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    private SocketMessageTask uU() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303016);
        socketMessageTask.i(true);
        socketMessageTask.setResponsedClass(ResponsedPrivacySocketMessage.class);
        socketMessageTask.j(false);
        return socketMessageTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(String str, int i) {
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage(str, i);
        privacySettingMessage.addParam("opt", str);
        privacySettingMessage.addParam("val", String.valueOf(i));
        sendMessage(privacySettingMessage);
    }
}
