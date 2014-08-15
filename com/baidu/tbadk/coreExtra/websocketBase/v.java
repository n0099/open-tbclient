package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
/* loaded from: classes.dex */
public class v {
    private static v d = null;
    private int a;
    private com.baidu.adp.framework.client.socket.link.c b = null;
    private UpdateClientInfoMessage c = null;
    private final com.baidu.adp.framework.client.socket.link.c e = new w(this);

    public static synchronized v a() {
        v vVar;
        synchronized (v.class) {
            if (d == null) {
                synchronized (v.class) {
                    if (d == null) {
                        d = new v();
                    }
                }
            }
            vVar = d;
        }
        return vVar;
    }

    private v() {
        MessageManager.getInstance().addResponsedMessageRule(new x(this, 1001));
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
            updateClientInfoMessage.addUserInfo(com.baidu.tbadk.core.frameworkData.a.FROM, from);
        }
        String str = new ae().a().a().a().j;
        if (str != null) {
            updateClientInfoMessage.addUserInfo("net_type", str);
        }
        updateClientInfoMessage.addUserInfo("cuid", TbadkApplication.getUniqueIdentifier());
        updateClientInfoMessage.addUserInfo("timestamp", Long.toString(System.currentTimeMillis()));
        updateClientInfoMessage.addUserInfo("model", Build.MODEL);
        updateClientInfoMessage.addUserInfo("_os_version", Build.VERSION.RELEASE);
        StringBuffer stringBuffer = new StringBuffer(15);
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.j.b(TbadkApplication.m252getInst().getApp())));
        stringBuffer.append(",");
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.j.c(TbadkApplication.m252getInst().getApp())));
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
            e.printStackTrace();
        }
        int a = com.baidu.adp.lib.util.j.a(TbadkApplication.m252getInst().getContext(), 70.0f);
        updateClientInfoMessage.setHeight(com.baidu.adp.lib.util.j.a(TbadkApplication.m252getInst().getContext(), 70.0f));
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
