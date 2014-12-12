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
    private g biu;
    private a biv;
    private boolean biw = false;
    private j bix = new b(this);
    private HttpMessageListener biy = new c(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
    private com.baidu.adp.framework.listener.a biz = new e(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(SecretSettingActivityConfig.class, SecretSettingActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.biu = new g(this);
        this.biv = new a();
        this.biu.a(this.bix);
        if (this.biv.Rg()) {
            this.biu.dc(true);
            this.biu.b(this.biv);
        } else {
            this.biu.dc(false);
        }
        this.biu.dd(TbadkCoreApplication.m255getInst().getLocationShared());
        registerListener(this.biz);
        registerListener(this.biy);
        vB();
        sendMessage(new RequestPrivacySetting());
    }

    private void vB() {
        MessageManager.getInstance().registerTask(uJ());
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
        this.biu.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.biu.Rq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(String str, String str2) {
        if (this.biw) {
            com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(getPageContext().getPageActivity());
            iVar.a(getResources().getStringArray(r.privacy_setting_config), new f(this, str)).bZ(str2);
            iVar.e(getPageContext()).nW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rl() {
        sendMessage(new CustomMessage(2008001, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    private SocketMessageTask uJ() {
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
