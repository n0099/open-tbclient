package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.a.j;
import com.baidu.adp.framework.client.socket.i;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import com.baidu.tbadk.l.r;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static g aAg = null;
    private int aAd;
    private com.baidu.adp.framework.client.socket.link.a aAe = null;
    private UpdateClientInfoMessage aAf = null;
    private int aAh = 0;
    private final com.baidu.adp.framework.client.socket.link.a qC = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.g.1
        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(k.a aVar) {
            if (g.this.aAe != null) {
                g.this.aAe.a(aVar);
            }
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean d(int i, String str) {
            if (g.this.aAe != null) {
                g.this.aAe.d(i, str);
                return false;
            }
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void e(Map<String, String> map) {
            if (g.this.aAe != null) {
                g.this.aAe.e(map);
            }
            i.a("TbOnline", 1001, 0, "begin_online", 0, "begin online");
            if (r.Gz().GA() && g.b(g.this) < 10) {
                i.dl();
            }
            g.this.aAf = g.this.Cm();
            MessageManager.getInstance().sendMessage(g.this.aAf);
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
            if (g.this.aAe != null) {
                g.this.aAe.a(cVar);
            }
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void J(String str) {
            if (g.this.aAe != null) {
                g.this.aAe.J(str);
            }
        }
    };

    static /* synthetic */ int b(g gVar) {
        int i = gVar.aAh + 1;
        gVar.aAh = i;
        return i;
    }

    public static synchronized g Cl() {
        g gVar;
        synchronized (g.class) {
            if (aAg == null) {
                synchronized (g.class) {
                    if (aAg == null) {
                        aAg = new g();
                    }
                }
            }
            gVar = aAg;
        }
        return gVar;
    }

    private g() {
        MessageManager.getInstance().addResponsedMessageRule(new j(1001) { // from class: com.baidu.tbadk.coreExtra.websocketBase.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.a.g
            /* renamed from: d */
            public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
                int i;
                if (!(socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    g.this.b(socketResponsedMessage.getCmd(), -1, null);
                    return null;
                }
                ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
                long j = 0;
                if (responseOnlineMessage.getOrginalMessage() == null || !(responseOnlineMessage.getOrginalMessage() instanceof SocketMessage)) {
                    i = 0;
                } else {
                    i = ((SocketMessage) responseOnlineMessage.getOrginalMessage()).getSquencedId();
                    j = ((SocketMessage) responseOnlineMessage.getOrginalMessage()).getClientLogID();
                }
                if (responseOnlineMessage.getError() != 0) {
                    g.this.b(socketResponsedMessage.getCmd(), responseOnlineMessage.getError(), responseOnlineMessage.getErrorString());
                    i.a("TbOnline", socketResponsedMessage.getCmd(), j, i, "online_failed", responseOnlineMessage.getError(), responseOnlineMessage.getErrorString() + "online failed. count-" + g.this.aAd);
                    return null;
                }
                g.this.Cp();
                i.a("TbOnline", socketResponsedMessage.getCmd(), j, i, "online_succ", 0, "online succ. retry count-" + g.this.aAd);
                return socketResponsedMessage;
            }
        });
    }

    public void init() {
        MessageManager.getInstance().getSocketClient().a(this.qC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UpdateClientInfoMessage Cm() {
        UpdateClientInfoMessage updateClientInfoMessage = new UpdateClientInfoMessage();
        updateClientInfoMessage.addUserInfo("_client_type", "2");
        updateClientInfoMessage.addUserInfo("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            updateClientInfoMessage.addUserInfo("_phone_imei", TbadkCoreApplication.getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            updateClientInfoMessage.addUserInfo("_client_id", clientId);
        }
        if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
            updateClientInfoMessage.addUserInfo("subapp_type", TbConfig.getSubappType());
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            updateClientInfoMessage.addUserInfo("from", from);
        }
        String str = new w().vm().wi().wl().mNetType;
        if (str != null) {
            updateClientInfoMessage.addUserInfo("net_type", str);
        }
        String valueOf = String.valueOf(com.baidu.adp.lib.util.i.hx());
        if (valueOf != null) {
            updateClientInfoMessage.addUserInfo("net", valueOf);
        }
        updateClientInfoMessage.addUserInfo("cuid", TbadkCoreApplication.getInst().getCuid());
        updateClientInfoMessage.addUserInfo("timestamp", Long.toString(System.currentTimeMillis()));
        updateClientInfoMessage.addUserInfo("model", Build.MODEL);
        updateClientInfoMessage.addUserInfo("_os_version", Build.VERSION.RELEASE);
        StringBuffer stringBuffer = new StringBuffer(15);
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst().getApp())));
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst().getApp())));
        updateClientInfoMessage.addUserInfo("_phone_screen", stringBuffer.toString());
        if (com.baidu.tbadk.coreExtra.messageCenter.b.zw().zz() > 0) {
            updateClientInfoMessage.addUserInfo("_msg_status", "0");
        } else {
            updateClientInfoMessage.addUserInfo("_msg_status", "1");
        }
        updateClientInfoMessage.addUserInfo("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
        try {
            if (TbadkCoreApplication.isLogin()) {
                a.b cy = com.baidu.tbadk.core.a.a.pg().cy(TbadkCoreApplication.getCurrentBduss());
                String d = com.baidu.tbadk.core.a.e.d(TbadkCoreApplication.getCurrentAccountInfo());
                if (cy != null) {
                    updateClientInfoMessage.setBduss(cy.mBduss, d);
                } else {
                    updateClientInfoMessage.setBduss(TbadkCoreApplication.getCurrentBduss(), d);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int dip2px = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getContext(), 70.0f);
        updateClientInfoMessage.setHeight(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getContext(), 70.0f));
        updateClientInfoMessage.setWidth(dip2px);
        if (com.baidu.tbadk.coreExtra.b.a.xQ().xR()) {
            updateClientInfoMessage.setPub_env(Integer.valueOf(com.baidu.tbadk.coreExtra.b.a.xQ().xS()));
        }
        updateClientInfoMessage.setSecretKey(com.baidu.adp.framework.client.socket.coder.d.du().dv());
        updateClientInfoMessage.addUserInfo("pversion", TiebaIMConfig.PROTOBUF_VERSION);
        if (TbadkCoreApplication.getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.getInst().getCustomizedFilter().a(updateClientInfoMessage);
        }
        return updateClientInfoMessage;
    }

    public boolean Cn() {
        return this.aAd >= 5;
    }

    public void Co() {
        this.aAd++;
        if (Cn()) {
            BdSocketLinkService.setAvailable(false);
            NoNetworkView.wQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cp() {
        this.aAd = 0;
        MessageManager.getInstance().getSocketClient().dd();
        NoNetworkView.wQ();
        BdSocketLinkService.stopReConnStrategy("online succ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, String str) {
        Co();
        BdSocketLinkService.close(8, "online error = " + i2);
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.aAe = aVar;
    }
}
