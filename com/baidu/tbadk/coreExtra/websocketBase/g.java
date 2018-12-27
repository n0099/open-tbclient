package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.a.j;
import com.baidu.adp.framework.client.socket.i;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import com.baidu.tbadk.l.m;
import com.baidu.tbadk.p.al;
import com.baidu.tbadk.p.am;
import com.baidu.webkit.internal.ETAG;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static g aWC = null;
    private int aWz;
    private com.baidu.adp.framework.client.socket.link.a aWA = null;
    private UpdateClientInfoMessage aWB = null;
    private int aWD = 0;
    private final com.baidu.adp.framework.client.socket.link.a wF = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.g.1
        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(k.a aVar) {
            if (g.this.aWA != null) {
                g.this.aWA.a(aVar);
            }
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean e(int i, String str) {
            com.baidu.tbadk.lcs.a.b(0, 2, 0, 0, 0);
            if (g.this.aWA != null) {
                g.this.aWA.e(i, str);
            }
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void i(Map<String, String> map) {
            com.baidu.tbadk.lcs.a.b(0, 1, 0, 0, 0);
            if (g.this.aWA != null) {
                g.this.aWA.i(map);
            }
            i.a("TbOnline", 1001, 0, "begin_online", 0, "begin online");
            if (m.Pl().Pm() && g.b(g.this) < 10) {
                i.gX();
            }
            com.baidu.tbadk.lcs.a.b(1001, 0, 0, 3, 0);
            g.this.aWB = g.this.Lq();
            MessageManager.getInstance().sendMessage(g.this.aWB);
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
            if (g.this.aWA != null) {
                g.this.aWA.a(cVar);
            }
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void aj(String str) {
            if (g.this.aWA != null) {
                g.this.aWA.aj(str);
            }
        }
    };

    static /* synthetic */ int b(g gVar) {
        int i = gVar.aWD + 1;
        gVar.aWD = i;
        return i;
    }

    public static synchronized g Lp() {
        g gVar;
        synchronized (g.class) {
            if (aWC == null) {
                synchronized (g.class) {
                    if (aWC == null) {
                        aWC = new g();
                    }
                }
            }
            gVar = aWC;
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
                    i.a("TbOnline", socketResponsedMessage.getCmd(), j, i, "online_failed", responseOnlineMessage.getError(), responseOnlineMessage.getErrorString() + "online failed. count-" + g.this.aWz);
                    return null;
                }
                g.this.Lt();
                i.a("TbOnline", socketResponsedMessage.getCmd(), j, i, "online_succ", 0, "online succ. retry count-" + g.this.aWz);
                return socketResponsedMessage;
            }
        });
    }

    public void init() {
        MessageManager.getInstance().getSocketClient().a(this.wF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UpdateClientInfoMessage Lq() {
        String valueOf;
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
        if (am.jJ()) {
            updateClientInfoMessage.addUserInfo(ETAG.KEY_NET_TYPE, String.valueOf(com.baidu.adp.lib.util.j.netType()));
        } else {
            String str = new x().Dj().Eh().Ek().mNetType;
            if (str != null) {
                updateClientInfoMessage.addUserInfo(ETAG.KEY_NET_TYPE, str);
            }
        }
        if (!al.jJ() && (valueOf = String.valueOf(com.baidu.adp.lib.util.j.netType())) != null) {
            updateClientInfoMessage.addUserInfo("net", valueOf);
        }
        updateClientInfoMessage.addUserInfo("cuid", TbadkCoreApplication.getInst().getCuid());
        updateClientInfoMessage.addUserInfo("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
        updateClientInfoMessage.addUserInfo("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
        updateClientInfoMessage.addUserInfo(HttpConstants.TIMESTAMP, Long.toString(System.currentTimeMillis()));
        updateClientInfoMessage.addUserInfo("model", Build.MODEL);
        updateClientInfoMessage.addUserInfo("_os_version", Build.VERSION.RELEASE);
        StringBuffer stringBuffer = new StringBuffer(15);
        stringBuffer.append(String.valueOf(l.aO(TbadkCoreApplication.getInst().getApp())));
        stringBuffer.append(",");
        stringBuffer.append(String.valueOf(l.aQ(TbadkCoreApplication.getInst().getApp())));
        updateClientInfoMessage.addUserInfo("_phone_screen", stringBuffer.toString());
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IA() > 0) {
            updateClientInfoMessage.addUserInfo("_msg_status", "0");
        } else {
            updateClientInfoMessage.addUserInfo("_msg_status", "1");
        }
        updateClientInfoMessage.addUserInfo("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
        String yunpushChannelId = TbadkCoreApplication.getInst().getYunpushChannelId();
        Log.i("BaiduYunPush", "channel_id " + yunpushChannelId);
        if (!TextUtils.isEmpty(yunpushChannelId)) {
            updateClientInfoMessage.addUserInfo("channel_id", yunpushChannelId);
        }
        try {
            if (TbadkCoreApplication.isLogin()) {
                a.b eb = com.baidu.tbadk.core.a.a.xJ().eb(TbadkCoreApplication.getCurrentBduss());
                String c = com.baidu.tbadk.core.a.d.c(TbadkCoreApplication.getCurrentAccountInfo());
                if (eb != null) {
                    updateClientInfoMessage.setBduss(eb.El, c);
                } else {
                    updateClientInfoMessage.setBduss(TbadkCoreApplication.getCurrentBduss(), c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int dip2px = l.dip2px(TbadkCoreApplication.getInst().getContext(), 70.0f);
        updateClientInfoMessage.setHeight(l.dip2px(TbadkCoreApplication.getInst().getContext(), 70.0f));
        updateClientInfoMessage.setWidth(dip2px);
        if (com.baidu.tbadk.coreExtra.b.a.Gc().Gd()) {
            updateClientInfoMessage.setPub_env(Integer.valueOf(com.baidu.tbadk.coreExtra.b.a.Gc().Ge()));
        }
        updateClientInfoMessage.setSecretKey(com.baidu.adp.framework.client.socket.coder.d.hf().hg());
        updateClientInfoMessage.addUserInfo("pversion", "1.0.3");
        if (TbadkCoreApplication.getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.getInst().getCustomizedFilter().a(updateClientInfoMessage);
        }
        return updateClientInfoMessage;
    }

    public boolean Lr() {
        return this.aWz >= 5;
    }

    public void Ls() {
        this.aWz++;
        if (Lr()) {
            BdSocketLinkService.setAvailable(false);
            NoNetworkView.updateUI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lt() {
        this.aWz = 0;
        MessageManager.getInstance().getSocketClient().gP();
        NoNetworkView.updateUI();
        BdSocketLinkService.stopReConnStrategy("online succ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, String str) {
        Ls();
        BdSocketLinkService.close(8, "online error = " + i2);
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.aWA = aVar;
    }
}
