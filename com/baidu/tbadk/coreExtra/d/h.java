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
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import com.baidu.tbadk.switchs.NetDeleteSwitch;
import com.baidu.tbadk.switchs.NetTypeFixedSwitch;
import java.util.Map;
/* loaded from: classes.dex */
public class h {
    private static h fCb = null;
    private int fBY;
    private com.baidu.adp.framework.client.socket.link.a fBZ = null;
    private UpdateClientInfoMessage fCa = null;
    private int fCc = 0;
    private final com.baidu.adp.framework.client.socket.link.a Jk = new com.baidu.adp.framework.client.socket.link.a() { // from class: com.baidu.tbadk.coreExtra.d.h.1
        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(k.a aVar) {
            if (h.this.fBZ != null) {
                h.this.fBZ.a(aVar);
            }
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public boolean onClose(int i, String str) {
            com.baidu.tbadk.lcs.a.d(0, 2, 0, 0, 0);
            if (h.this.fBZ != null) {
                h.this.fBZ.onClose(i, str);
            }
            return false;
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void onConnected(Map<String, String> map) {
            com.baidu.tbadk.lcs.a.d(0, 1, 0, 0, 0);
            if (h.this.fBZ != null) {
                h.this.fBZ.onConnected(map);
            }
            com.baidu.adp.framework.client.socket.i.debug("TbOnline", 1001, 0, "begin_online", 0, "begin online");
            if (com.baidu.tbadk.n.k.bHF().isSmallFlow() && h.b(h.this) < 10) {
                com.baidu.adp.framework.client.socket.i.perfWebSocketConTime();
            }
            com.baidu.tbadk.lcs.a.d(1001, 0, 0, 3, 0);
            h.this.fCa = h.this.bDT();
            MessageManager.getInstance().sendMessage(h.this.fCa);
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
            if (h.this.fBZ != null) {
                h.this.fBZ.a(cVar);
            }
        }

        @Override // com.baidu.adp.framework.client.socket.link.a
        public void onTextMessage(String str) {
            if (h.this.fBZ != null) {
                h.this.fBZ.onTextMessage(str);
            }
        }
    };

    static /* synthetic */ int b(h hVar) {
        int i = hVar.fCc + 1;
        hVar.fCc = i;
        return i;
    }

    public static synchronized h bDS() {
        h hVar;
        synchronized (h.class) {
            if (fCb == null) {
                synchronized (h.class) {
                    if (fCb == null) {
                        fCb = new h();
                    }
                }
            }
            hVar = fCb;
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
                    h.this.j(socketResponsedMessage.getCmd(), -1, null);
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
                    h.this.j(socketResponsedMessage.getCmd(), responseOnlineMessage.getError(), responseOnlineMessage.getErrorString());
                    com.baidu.adp.framework.client.socket.i.debug("TbOnline", socketResponsedMessage.getCmd(), j, i, "online_failed", responseOnlineMessage.getError(), responseOnlineMessage.getErrorString() + "online failed. count-" + h.this.fBY);
                    return null;
                }
                h.this.bDW();
                com.baidu.adp.framework.client.socket.i.debug("TbOnline", socketResponsedMessage.getCmd(), j, i, "online_succ", 0, "online succ. retry count-" + h.this.fBY);
                return socketResponsedMessage;
            }
        });
    }

    public void init() {
        MessageManager.getInstance().getSocketClient().a(this.Jk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UpdateClientInfoMessage bDT() {
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
            String str = new z().bvQ().bwz().bwD().mNetType;
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
        updateClientInfoMessage.addUserInfo("sample_id", TbSingleton.getInstance().getSampleId());
        updateClientInfoMessage.addUserInfo("sdk_ver", TbadkCoreApplication.getInst().getSdk_ver());
        updateClientInfoMessage.addUserInfo("framework_ver", TbadkCoreApplication.getInst().getFramework_ver());
        updateClientInfoMessage.addUserInfo("swan_game_ver", TbadkCoreApplication.getInst().getSwan_game_ver());
        updateClientInfoMessage.addUserInfo("_os_version", Build.VERSION.RELEASE);
        StringBuffer stringBuffer = new StringBuffer(15);
        stringBuffer.append(String.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
        stringBuffer.append(",");
        stringBuffer.append(String.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
        updateClientInfoMessage.addUserInfo("_phone_screen", stringBuffer.toString());
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bBF().bBI() > 0) {
            updateClientInfoMessage.addUserInfo("_msg_status", "0");
        } else {
            updateClientInfoMessage.addUserInfo("_msg_status", "1");
        }
        updateClientInfoMessage.addUserInfo("_pic_quality", String.valueOf(com.baidu.tbadk.core.k.bou().getViewImageQuality()));
        String yunpushChannelId = TbadkCoreApplication.getInst().getYunpushChannelId();
        Log.i("BaiduYunPush", "channel_id " + yunpushChannelId);
        if (!TextUtils.isEmpty(yunpushChannelId)) {
            updateClientInfoMessage.addUserInfo(SharedPrefConfig.CHANNEL_ID, yunpushChannelId);
        }
        try {
            if (TbadkCoreApplication.isLogin()) {
                a.b AB = com.baidu.tbadk.core.a.a.bov().AB(TbadkCoreApplication.getCurrentBduss());
                String c = com.baidu.tbadk.core.a.d.c(TbadkCoreApplication.getCurrentAccountInfo());
                if (AB != null) {
                    updateClientInfoMessage.setBduss(AB.mBduss, c);
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
        if (com.baidu.tbadk.coreExtra.b.a.bzq().bzr()) {
            updateClientInfoMessage.setPub_env(Integer.valueOf(com.baidu.tbadk.coreExtra.b.a.bzq().bzs()));
        }
        if (TbSingleton.getInstance().isVisitPreviewServer()) {
            updateClientInfoMessage.setPub_env(Integer.valueOf(com.baidu.adp.lib.f.b.toInt(TbSingleton.getInstance().getPubEnvValue(), 0)));
        }
        updateClientInfoMessage.setSecretKey(com.baidu.adp.framework.client.socket.coder.d.kU().getSecretKeyBytes());
        updateClientInfoMessage.addUserInfo("pversion", "1.0.3");
        if (TbadkCoreApplication.getInst().getCustomizedFilter() != null) {
            updateClientInfoMessage = TbadkCoreApplication.getInst().getCustomizedFilter().a(updateClientInfoMessage);
        }
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        updateClientInfoMessage.addUserInfo("q_type", String.valueOf(com.baidu.tbadk.core.k.bou().getViewImageQuality()));
        updateClientInfoMessage.addUserInfo("scr_h", String.valueOf(l.getEquipmentHeight(inst)));
        updateClientInfoMessage.addUserInfo("scr_w", String.valueOf(l.getEquipmentWidth(inst)));
        updateClientInfoMessage.addUserInfo("scr_dip", String.valueOf(Double.valueOf(l.getEquipmentDensity(inst))));
        updateClientInfoMessage.addUserInfo("active_timestamp", TbSingleton.getInstance().getActiveTimeStamp() + "");
        updateClientInfoMessage.addUserInfo("first_install_time", TbSingleton.getInstance().getAppFirstInstallTime() + "");
        updateClientInfoMessage.addUserInfo(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, TbSingleton.getInstance().getAppLastUpdateTime() + "");
        updateClientInfoMessage.addUserInfo("event_day", TbSingleton.getInstance().getData());
        return updateClientInfoMessage;
    }

    public boolean bDU() {
        return this.fBY >= 5;
    }

    public void bDV() {
        this.fBY++;
        if (bDU()) {
            BdSocketLinkService.setAvailable(false);
            NoNetworkView.updateUI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDW() {
        this.fBY = 0;
        MessageManager.getInstance().getSocketClient().unBlockMessageQueue();
        NoNetworkView.updateUI();
        BdSocketLinkService.stopReConnStrategy("online succ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, int i2, String str) {
        bDV();
        BdSocketLinkService.close(8, "online error = " + i2);
    }

    public void a(com.baidu.adp.framework.client.socket.link.a aVar) {
        this.fBZ = aVar;
    }
}
