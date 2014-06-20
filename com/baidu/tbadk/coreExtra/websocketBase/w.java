package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
/* loaded from: classes.dex */
public class w {
    private static w d = null;
    private int a;
    private com.baidu.adp.framework.client.socket.link.c b = null;
    private UpdateClientInfoMessage c = null;
    private final com.baidu.adp.framework.client.socket.link.c e = new x(this);

    public static synchronized w a() {
        w wVar;
        synchronized (w.class) {
            if (d == null) {
                synchronized (w.class) {
                    if (d == null) {
                        d = new w();
                    }
                }
            }
            wVar = d;
        }
        return wVar;
    }

    private w() {
        MessageManager.getInstance().addResponsedMessageRule(new y(this, 1001));
    }

    public void b() {
        MessageManager.getInstance().getSocketClient().a(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UpdateClientInfoMessage e() {
        UpdateClientInfoMessage updateClientInfoMessage = new UpdateClientInfoMessage();
        updateClientInfoMessage.addUserInfo("_client_type", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
        updateClientInfoMessage.addUserInfo("_client_version", TbConfig.getVersion());
        if (TbadkApplication.m252getInst().getImei() != null) {
            updateClientInfoMessage.addUserInfo("_phone_imei", TbadkApplication.m252getInst().getImei());
        }
        String clientId = TbadkApplication.getClientId();
        if (clientId != null) {
            updateClientInfoMessage.addUserInfo("_client_id", clientId);
        }
        String from = TbadkApplication.getFrom();
        if (from != null && from.length() > 0) {
            updateClientInfoMessage.addUserInfo("from", from);
        }
        String str = new an().a().a().a().j;
        if (str != null) {
            updateClientInfoMessage.addUserInfo("net_type", str);
        }
        String uniqueIdentifier = TbadkApplication.getUniqueIdentifier();
        if (uniqueIdentifier != null) {
            updateClientInfoMessage.addUserInfo("cuid", uniqueIdentifier);
        }
        updateClientInfoMessage.addUserInfo("timestamp", Long.toString(System.currentTimeMillis()));
        updateClientInfoMessage.addUserInfo("model", Build.MODEL);
        updateClientInfoMessage.addUserInfo("_os_version", Build.VERSION.RELEASE);
        StringBuffer stringBuffer = new StringBuffer(15);
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.k.b(TbadkApplication.m252getInst().getApp())));
        stringBuffer.append(",");
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.k.c(TbadkApplication.m252getInst().getApp())));
        updateClientInfoMessage.addUserInfo("_phone_screen", stringBuffer.toString());
        if (TbadkApplication.m252getInst().getMsgFrequency() > 0) {
            updateClientInfoMessage.addUserInfo("_msg_status", "0");
        } else {
            updateClientInfoMessage.addUserInfo("_msg_status", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
        }
        updateClientInfoMessage.addUserInfo("_pic_quality", String.valueOf(TbadkApplication.m252getInst().getViewImageQuality()));
        try {
            if (TbadkApplication.isLogin()) {
                AccountLoginHelper.OurToken parseBDUSS = AccountLoginHelper.parseBDUSS(TbadkApplication.getCurrentBduss());
                if (parseBDUSS != null) {
                    updateClientInfoMessage.setBduss(parseBDUSS.mBduss);
                } else {
                    updateClientInfoMessage.setBduss(TbadkApplication.getCurrentBduss());
                }
            }
        } catch (Exception e) {
            BdLog.e("createUpdateClientInfoMessage getaccountdata error.");
        }
        int a = com.baidu.adp.lib.util.k.a(TbadkApplication.m252getInst().getContext(), 70.0f);
        updateClientInfoMessage.setHeight(com.baidu.adp.lib.util.k.a(TbadkApplication.m252getInst().getContext(), 70.0f));
        updateClientInfoMessage.setWidth(a);
        if (com.baidu.tbadk.coreExtra.a.a.a().b()) {
            updateClientInfoMessage.setPub_env(3);
        }
        updateClientInfoMessage.setSecretKey(com.baidu.adp.framework.client.socket.coder.d.a().b());
        updateClientInfoMessage.addUserInfo("pversion", "1.0.3");
        return updateClientInfoMessage;
    }

    public boolean c() {
        return this.a >= 5;
    }

    public void d() {
        this.a++;
        if (c()) {
            BdSocketLinkService.setAvailable(false);
            NoNetworkView.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        BdLog.i("【关闭】了上线不成功消息拦截机制，----online succ");
        this.a = 0;
        MessageManager.getInstance().getSocketClient().b();
        NoNetworkView.a();
        BdSocketLinkService.stopReConnStrategy("online succ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str) {
        d();
        BdSocketLinkService.close(8, "online error = " + i2);
    }

    public void a(com.baidu.adp.framework.client.socket.link.c cVar) {
        this.b = cVar;
    }
}
