package com.baidu.tbadk.coreExtra.d;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebSocketStateHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    private static q a = null;
    private int b;
    private com.baidu.adp.lib.network.websocket.c c = null;
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private List<String> g = null;
    private boolean h = false;
    private UpdateClientInfoMessage i = null;
    private final com.baidu.adp.lib.network.websocket.c j = new r(this);

    public static synchronized q a() {
        q qVar;
        synchronized (q.class) {
            if (a == null) {
                a = new q();
            }
            qVar = a;
        }
        return qVar;
    }

    private q() {
        MessageManager.getInstance().addResponsedMessageRule(new s(this, MessageTypes.CMD_UPDATE_CLIENT_INFO));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        j();
        com.baidu.adp.framework.c.c.a().a(true);
        BdLog.e("【打开】了上线不成功消息拦截机制");
        NoNetworkView.a();
    }

    private UpdateClientInfoMessage f() {
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
        String str = new al().a().a().a().j;
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
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.h.b(TbadkApplication.m252getInst().getApp())));
        stringBuffer.append(",");
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.h.c(TbadkApplication.m252getInst().getApp())));
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
        int a2 = com.baidu.adp.lib.util.h.a(TbadkApplication.m252getInst().getContext(), 70.0f);
        updateClientInfoMessage.setHeight(com.baidu.adp.lib.util.h.a(TbadkApplication.m252getInst().getContext(), 70.0f));
        updateClientInfoMessage.setWidth(a2);
        if (com.baidu.tbadk.coreExtra.a.a.a().b()) {
            updateClientInfoMessage.setPub_env(3);
        }
        updateClientInfoMessage.setSecretKey(com.baidu.tbadk.message.websockt.c.b().c());
        updateClientInfoMessage.addUserInfo("pversion", "1.0.3");
        return updateClientInfoMessage;
    }

    private String a(String str) {
        int lastIndexOf;
        if (str != null && (lastIndexOf = str.lastIndexOf(":")) >= 5) {
            try {
                return str.substring(5, lastIndexOf);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    private String g() {
        if (this.g == null || this.d <= -1 || this.d >= this.g.size()) {
            return null;
        }
        return a.a().b().get(this.d);
    }

    public void b() {
        MessageManager.getInstance().setConnStateCallback(this.j);
    }

    public boolean c() {
        return this.b >= 5;
    }

    public void d() {
        this.b++;
        if (c()) {
            k();
            WebSocketStateHelper.a(WebSocketStateHelper.WebSocketStateInfo.UNAVAIL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        BdLog.e("【关闭】了上线不成功消息拦截机制，----online succ");
        WebSocketStateHelper.a(WebSocketStateHelper.WebSocketStateInfo.ONLINE);
        this.b = 0;
        j();
        a.a().a(com.baidu.tbadk.h.a);
        a.a().c();
        e.a().a(com.baidu.tbadk.h.a);
        com.baidu.adp.framework.c.c.a().a(false);
        NoNetworkView.a();
        com.baidu.adp.framework.c.c.a().c("online succ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i() {
        BdLog.i("start online");
        TiebaStatic.imLog((int) MessageTypes.CMD_UPDATE_CLIENT_INFO, 0, "on connect", "start online", (String) null, 0, (String) null);
        this.i = f();
        MessageManager.getInstance().sendMessage(this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        if (i > 30) {
            e();
            return;
        }
        int i2 = i + 1;
        String g = g();
        if (g == null) {
            if (!a.a().d()) {
                a.a().a(new t(this, str, i));
            }
            e();
            return;
        }
        String a2 = a(g);
        if (a2 == null) {
            e();
        } else {
            new i(a2, new u(this, g, str, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str) {
        d();
        com.baidu.adp.framework.c.c.a().a(8, "online error = " + i2);
    }

    private void j() {
        this.f = false;
        this.d = 0;
        this.h = false;
        this.e = false;
    }

    private void k() {
        if (!this.h) {
            this.h = true;
            if (this.e) {
                this.e = false;
                e.a().b(com.baidu.tbadk.h.a);
            }
            e.a().b();
            if (!UtilHelper.isNetOk()) {
                e.a().a(0);
                e();
            } else if (!this.f) {
                new i("www.baidu.com", new v(this));
                this.f = true;
            } else {
                a("change ip to reconnect with DNS' failed.", 0);
            }
        }
    }

    public void a(com.baidu.adp.lib.network.websocket.c cVar) {
        this.c = cVar;
    }
}
