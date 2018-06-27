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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import com.baidu.tbadk.k.m;
import com.baidu.tbadk.o.ag;
import com.baidu.tbadk.o.ah;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static g aKr = null;
    private int aKo;
    private com.baidu.adp.framework.client.socket.link.a aKp = null;
    private UpdateClientInfoMessage aKq = null;
    private int aKs = 0;
    private final com.baidu.adp.framework.client.socket.link.a tB = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.g.1
        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(k.a aVar) {
            if (g.this.aKp != null) {
                g.this.aKp.a(aVar);
            }
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean d(int i, String str) {
            if (g.this.aKp != null) {
                g.this.aKp.d(i, str);
                return false;
            }
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void h(Map<String, String> map) {
            if (g.this.aKp != null) {
                g.this.aKp.h(map);
            }
            i.a("TbOnline", 1001, 0, "begin_online", 0, "begin online");
            if (m.KK().KL() && g.b(g.this) < 10) {
                i.fy();
            }
            g.this.aKq = g.this.GO();
            MessageManager.getInstance().sendMessage(g.this.aKq);
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
            if (g.this.aKp != null) {
                g.this.aKp.a(cVar);
            }
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void S(String str) {
            if (g.this.aKp != null) {
                g.this.aKp.S(str);
            }
        }
    };

    static /* synthetic */ int b(g gVar) {
        int i = gVar.aKs + 1;
        gVar.aKs = i;
        return i;
    }

    public static synchronized g GN() {
        g gVar;
        synchronized (g.class) {
            if (aKr == null) {
                synchronized (g.class) {
                    if (aKr == null) {
                        aKr = new g();
                    }
                }
            }
            gVar = aKr;
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
                    i.a("TbOnline", socketResponsedMessage.getCmd(), j, i, "online_failed", responseOnlineMessage.getError(), responseOnlineMessage.getErrorString() + "online failed. count-" + g.this.aKo);
                    return null;
                }
                g.this.GR();
                i.a("TbOnline", socketResponsedMessage.getCmd(), j, i, "online_succ", 0, "online succ. retry count-" + g.this.aKo);
                return socketResponsedMessage;
            }
        });
    }

    public void init() {
        MessageManager.getInstance().getSocketClient().a(this.tB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UpdateClientInfoMessage GO() {
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
        if (ah.ip()) {
            updateClientInfoMessage.addUserInfo("net_type", String.valueOf(com.baidu.adp.lib.util.j.jJ()));
        } else {
            String str = new y().yX().zX().Aa().mNetType;
            if (str != null) {
                updateClientInfoMessage.addUserInfo("net_type", str);
            }
        }
        if (!ag.ip() && (valueOf = String.valueOf(com.baidu.adp.lib.util.j.jJ())) != null) {
            updateClientInfoMessage.addUserInfo("net", valueOf);
        }
        updateClientInfoMessage.addUserInfo("cuid", TbadkCoreApplication.getInst().getCuid());
        updateClientInfoMessage.addUserInfo("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
        updateClientInfoMessage.addUserInfo("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
        updateClientInfoMessage.addUserInfo(HttpConstants.TIMESTAMP, Long.toString(System.currentTimeMillis()));
        updateClientInfoMessage.addUserInfo("model", Build.MODEL);
        updateClientInfoMessage.addUserInfo("_os_version", Build.VERSION.RELEASE);
        StringBuffer stringBuffer = new StringBuffer(15);
        stringBuffer.append(String.valueOf(l.ah(TbadkCoreApplication.getInst().getApp())));
        stringBuffer.append(",");
        stringBuffer.append(String.valueOf(l.aj(TbadkCoreApplication.getInst().getApp())));
        updateClientInfoMessage.addUserInfo("_phone_screen", stringBuffer.toString());
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DW().DZ() > 0) {
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
                a.b dd = com.baidu.tbadk.core.a.a.tA().dd(TbadkCoreApplication.getCurrentBduss());
                String c = com.baidu.tbadk.core.a.d.c(TbadkCoreApplication.getCurrentAccountInfo());
                if (dd != null) {
                    updateClientInfoMessage.setBduss(dd.Bi, c);
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
        if (com.baidu.tbadk.coreExtra.b.a.BH().BI()) {
            updateClientInfoMessage.setPub_env(Integer.valueOf(com.baidu.tbadk.coreExtra.b.a.BH().BJ()));
        }
        updateClientInfoMessage.setSecretKey(com.baidu.adp.framework.client.socket.coder.d.fH().fI());
        updateClientInfoMessage.addUserInfo("pversion", "1.0.3");
        if (TbadkCoreApplication.getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.getInst().getCustomizedFilter().a(updateClientInfoMessage);
        }
        return updateClientInfoMessage;
    }

    public boolean GP() {
        return this.aKo >= 5;
    }

    public void GQ() {
        this.aKo++;
        if (GP()) {
            BdSocketLinkService.setAvailable(false);
            NoNetworkView.AB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GR() {
        this.aKo = 0;
        MessageManager.getInstance().getSocketClient().fp();
        NoNetworkView.AB();
        BdSocketLinkService.stopReConnStrategy("online succ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, String str) {
        GQ();
        BdSocketLinkService.close(8, "online error = " + i2);
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.aKp = aVar;
    }
}
