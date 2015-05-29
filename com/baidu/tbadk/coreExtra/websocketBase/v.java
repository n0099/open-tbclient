package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import com.baidu.tbadk.game.GameInfoData;
/* loaded from: classes.dex */
public class v {
    private static v ahL = null;
    private int ahI;
    private com.baidu.adp.framework.client.socket.link.g ahJ = null;
    private UpdateClientInfoMessage ahK = null;
    private final com.baidu.adp.framework.client.socket.link.g oN = new w(this);

    public static synchronized v yA() {
        v vVar;
        synchronized (v.class) {
            if (ahL == null) {
                synchronized (v.class) {
                    if (ahL == null) {
                        ahL = new v();
                    }
                }
            }
            vVar = ahL;
        }
        return vVar;
    }

    private v() {
        MessageManager.getInstance().addResponsedMessageRule(new x(this, BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES));
    }

    public void init() {
        MessageManager.getInstance().getSocketClient().a(this.oN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UpdateClientInfoMessage yB() {
        UpdateClientInfoMessage updateClientInfoMessage = new UpdateClientInfoMessage();
        updateClientInfoMessage.addUserInfo("_client_type", "2");
        updateClientInfoMessage.addUserInfo("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.m411getInst().getImei() != null) {
            updateClientInfoMessage.addUserInfo("_phone_imei", TbadkCoreApplication.m411getInst().getImei());
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
        String str = new aa().sX().tS().tV().mNetType;
        if (str != null) {
            updateClientInfoMessage.addUserInfo("net_type", str);
        }
        String valueOf = String.valueOf(com.baidu.adp.lib.util.k.jc());
        if (valueOf != null) {
            updateClientInfoMessage.addUserInfo("net", valueOf);
        }
        updateClientInfoMessage.addUserInfo("cuid", TbadkCoreApplication.m411getInst().getCuid());
        updateClientInfoMessage.addUserInfo("timestamp", Long.toString(System.currentTimeMillis()));
        updateClientInfoMessage.addUserInfo("model", Build.MODEL);
        updateClientInfoMessage.addUserInfo("_os_version", Build.VERSION.RELEASE);
        StringBuffer stringBuffer = new StringBuffer(15);
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst().getApp())));
        stringBuffer.append(",");
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getApp())));
        updateClientInfoMessage.addUserInfo("_phone_screen", stringBuffer.toString());
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wj() > 0) {
            updateClientInfoMessage.addUserInfo("_msg_status", GameInfoData.NOT_FROM_DETAIL);
        } else {
            updateClientInfoMessage.addUserInfo("_msg_status", "1");
        }
        updateClientInfoMessage.addUserInfo("_pic_quality", String.valueOf(TbadkCoreApplication.m411getInst().getViewImageQuality()));
        try {
            if (TbadkCoreApplication.isLogin()) {
                com.baidu.tbadk.core.a.c ca = com.baidu.tbadk.core.a.a.qi().ca(TbadkCoreApplication.getCurrentBduss());
                if (ca != null) {
                    updateClientInfoMessage.setBduss(ca.wk);
                } else {
                    updateClientInfoMessage.setBduss(TbadkCoreApplication.getCurrentBduss());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int dip2px = com.baidu.adp.lib.util.n.dip2px(TbadkCoreApplication.m411getInst().getContext(), 70.0f);
        updateClientInfoMessage.setHeight(com.baidu.adp.lib.util.n.dip2px(TbadkCoreApplication.m411getInst().getContext(), 70.0f));
        updateClientInfoMessage.setWidth(dip2px);
        if (com.baidu.tbadk.coreExtra.a.a.vd().ve()) {
            updateClientInfoMessage.setPub_env(3);
        }
        updateClientInfoMessage.setSecretKey(com.baidu.adp.framework.client.socket.coder.d.eL().eM());
        updateClientInfoMessage.addUserInfo("pversion", TiebaIMConfig.PROTOBUF_VERSION);
        if (TbadkCoreApplication.m411getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.m411getInst().getCustomizedFilter().a(updateClientInfoMessage);
        }
        return updateClientInfoMessage;
    }

    public boolean yC() {
        return this.ahI >= 5;
    }

    public void yD() {
        this.ahI++;
        if (yC()) {
            BdSocketLinkService.setAvailable(false);
            NoNetworkView.uv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yE() {
        this.ahI = 0;
        MessageManager.getInstance().getSocketClient().ew();
        NoNetworkView.uv();
        BdSocketLinkService.stopReConnStrategy("online succ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str) {
        yD();
        BdSocketLinkService.close(8, "online error = " + i2);
    }

    public void a(com.baidu.adp.framework.client.socket.link.g gVar) {
        this.ahJ = gVar;
    }
}
