package com.baidu.tieba.im.more;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.IMBlackListActivityConfig;
import com.baidu.tbadk.core.atomData.SecretSettingActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.q;
/* loaded from: classes.dex */
public class SecretSettingActivity extends BaseActivity {
    private g bfb;
    private a bfc;
    private boolean bfd = false;
    private j bfe = new b(this);
    private HttpMessageListener bff = new c(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
    private com.baidu.adp.framework.listener.a bfg = new e(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);

    static {
        TbadkApplication.m251getInst().RegisterIntent(SecretSettingActivityConfig.class, SecretSettingActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bfb = new g(this);
        this.bfc = new a();
        this.bfb.a(this.bfe);
        if (this.bfc.QH()) {
            this.bfb.dn(true);
            this.bfb.b(this.bfc);
        } else {
            this.bfb.dn(false);
        }
        this.bfb.dp(TbadkApplication.m251getInst().getLocationShared());
        registerListener(this.bfg);
        registerListener(this.bff);
        sb();
        sendMessage(new RequestPrivacySetting());
    }

    private void sb() {
        MessageManager.getInstance().registerTask(ri());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.GET_PRIVATE_INFO_CMD, s("c/u/user/getPrivateInfo", 303016));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(ResponsedPrivacyHttpMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static String s(String str, int i) {
        return String.valueOf(TbConfig.SERVER_ADDRESS) + str + "?cmd=" + i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bfb.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.bfb.QR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(String str, String str2) {
        if (this.bfd) {
            com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this);
            iVar.a(getResources().getStringArray(q.privacy_setting_config), new f(this, str)).bh(str2);
            iVar.kZ().la();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QM() {
        sendMessage(new CustomMessage(2008001, new IMBlackListActivityConfig(this)));
    }

    private SocketMessageTask ri() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303016);
        socketMessageTask.e(true);
        socketMessageTask.setResponsedClass(ResponsedPrivacySocketMessage.class);
        socketMessageTask.f(false);
        return socketMessageTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, int i) {
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage(str, i);
        privacySettingMessage.addParam("opt", str);
        privacySettingMessage.addParam("val", String.valueOf(i));
        sendMessage(privacySettingMessage);
    }
}
