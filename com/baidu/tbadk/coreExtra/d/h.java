package com.baidu.tbadk.coreExtra.d;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.b.j;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import com.baidu.tbadk.n.m;
import com.baidu.tbadk.switchs.NetDeleteSwitch;
import com.baidu.tbadk.switchs.NetTypeFixedSwitch;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
/* loaded from: classes2.dex */
public class h {
    private static h eJh = null;
    private int eJe;
    private com.baidu.adp.framework.client.socket.link.a eJf = null;
    private UpdateClientInfoMessage eJg = null;
    private int eJi = 0;
    private final com.baidu.adp.framework.client.socket.link.a Io = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tbadk.coreExtra.d.h.1
        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(k.a aVar) {
            if (h.this.eJf != null) {
                h.this.eJf.a(aVar);
            }
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean onClose(int i, String str) {
            com.baidu.tbadk.lcs.a.d(0, 2, 0, 0, 0);
            if (h.this.eJf != null) {
                h.this.eJf.onClose(i, str);
            }
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void onConnected(Map<String, String> map) {
            com.baidu.tbadk.lcs.a.d(0, 1, 0, 0, 0);
            if (h.this.eJf != null) {
                h.this.eJf.onConnected(map);
            }
            com.baidu.adp.framework.client.socket.i.debug("TbOnline", 1001, 0, "begin_online", 0, "begin online");
            if (m.bun().buo() && h.b(h.this) < 10) {
                com.baidu.adp.framework.client.socket.i.perfWebSocketConTime();
            }
            com.baidu.tbadk.lcs.a.d(1001, 0, 0, 3, 0);
            h.this.eJg = h.this.bqL();
            MessageManager.getInstance().sendMessage(h.this.eJg);
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
            if (h.this.eJf != null) {
                h.this.eJf.a(cVar);
            }
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void onTextMessage(String str) {
            if (h.this.eJf != null) {
                h.this.eJf.onTextMessage(str);
            }
        }
    };

    static /* synthetic */ int b(h hVar) {
        int i = hVar.eJi + 1;
        hVar.eJi = i;
        return i;
    }

    public static synchronized h bqK() {
        h hVar;
        synchronized (h.class) {
            if (eJh == null) {
                synchronized (h.class) {
                    if (eJh == null) {
                        eJh = new h();
                    }
                }
            }
            hVar = eJh;
        }
        return hVar;
    }

    private h() {
        MessageManager.getInstance().addResponsedMessageRule(new j(1001) { // from class: com.baidu.tbadk.coreExtra.d.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.b.g
            /* renamed from: e */
            public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
                int i;
                if (!(socketResponsedMessage instanceof ResponseOnlineMessage)) {
                    h.this.g(socketResponsedMessage.getCmd(), -1, null);
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
                    h.this.g(socketResponsedMessage.getCmd(), responseOnlineMessage.getError(), responseOnlineMessage.getErrorString());
                    com.baidu.adp.framework.client.socket.i.debug("TbOnline", socketResponsedMessage.getCmd(), j, i, "online_failed", responseOnlineMessage.getError(), responseOnlineMessage.getErrorString() + "online failed. count-" + h.this.eJe);
                    return null;
                }
                h.this.bqO();
                com.baidu.adp.framework.client.socket.i.debug("TbOnline", socketResponsedMessage.getCmd(), j, i, "online_succ", 0, "online succ. retry count-" + h.this.eJe);
                return socketResponsedMessage;
            }
        });
    }

    public void init() {
        MessageManager.getInstance().getSocketClient().a(this.Io);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UpdateClientInfoMessage bqL() {
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
        if (NetTypeFixedSwitch.isOn()) {
            updateClientInfoMessage.addUserInfo("net_type", String.valueOf(com.baidu.adp.lib.util.j.netType()));
        } else {
            String str = new aa().biQ().bjv().bjz().mNetType;
            if (str != null) {
                updateClientInfoMessage.addUserInfo("net_type", str);
            }
        }
        if (!NetDeleteSwitch.isOn() && (valueOf = String.valueOf(com.baidu.adp.lib.util.j.netType())) != null) {
            updateClientInfoMessage.addUserInfo("net", valueOf);
        }
        updateClientInfoMessage.addUserInfo("cuid", TbadkCoreApplication.getInst().getCuid());
        updateClientInfoMessage.addUserInfo("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
        updateClientInfoMessage.addUserInfo("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
        updateClientInfoMessage.addUserInfo("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
        updateClientInfoMessage.addUserInfo("timestamp", Long.toString(System.currentTimeMillis()));
        updateClientInfoMessage.addUserInfo("model", Build.MODEL);
        updateClientInfoMessage.addUserInfo("_os_version", Build.VERSION.RELEASE);
        StringBuffer stringBuffer = new StringBuffer(15);
        stringBuffer.append(String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuffer.append(String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        updateClientInfoMessage.addUserInfo("_phone_screen", stringBuffer.toString());
        if (com.baidu.tbadk.coreExtra.messageCenter.d.boy().boB() > 0) {
            updateClientInfoMessage.addUserInfo("_msg_status", "0");
        } else {
            updateClientInfoMessage.addUserInfo("_msg_status", "1");
        }
        updateClientInfoMessage.addUserInfo("_pic_quality", String.valueOf(TbadkCoreApplication.getInst().getViewImageQuality()));
        String yunpushChannelId = TbadkCoreApplication.getInst().getYunpushChannelId();
        Log.i("BaiduYunPush", "channel_id " + yunpushChannelId);
        if (!TextUtils.isEmpty(yunpushChannelId)) {
            updateClientInfoMessage.addUserInfo(SharedPrefConfig.CHANNEL_ID, yunpushChannelId);
        }
        try {
            if (TbadkCoreApplication.isLogin()) {
                a.b yM = com.baidu.tbadk.core.a.a.bbN().yM(TbadkCoreApplication.getCurrentBduss());
                String c = com.baidu.tbadk.core.a.d.c(TbadkCoreApplication.getCurrentAccountInfo());
                if (yM != null) {
                    updateClientInfoMessage.setBduss(yM.mBduss, c);
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
        if (com.baidu.tbadk.coreExtra.b.a.bmk().bml()) {
            updateClientInfoMessage.setPub_env(Integer.valueOf(com.baidu.tbadk.coreExtra.b.a.bmk().bmm()));
        }
        if (TbSingleton.getInstance().isVisitPreviewServer()) {
            updateClientInfoMessage.setPub_env(Integer.valueOf(com.baidu.adp.lib.f.b.toInt(TbSingleton.getInstance().getPubEnvValue(), 0)));
        }
        updateClientInfoMessage.setSecretKey(com.baidu.adp.framework.client.socket.coder.d.lt().getSecretKeyBytes());
        updateClientInfoMessage.addUserInfo("pversion", "1.0.3");
        if (TbadkCoreApplication.getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.getInst().getCustomizedFilter().a(updateClientInfoMessage);
        }
        return updateClientInfoMessage;
    }

    public boolean bqM() {
        return this.eJe >= 5;
    }

    public void bqN() {
        this.eJe++;
        if (bqM()) {
            BdSocketLinkService.setAvailable(false);
            NoNetworkView.updateUI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqO() {
        this.eJe = 0;
        MessageManager.getInstance().getSocketClient().unBlockMessageQueue();
        NoNetworkView.updateUI();
        BdSocketLinkService.stopReConnStrategy("online succ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, int i2, String str) {
        bqN();
        BdSocketLinkService.close(8, "online error = " + i2);
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.eJf = aVar;
    }
}
