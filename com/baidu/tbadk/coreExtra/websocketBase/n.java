package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
/* loaded from: classes.dex */
public class n {
    private static n amR = null;
    private int amO;
    private com.baidu.adp.framework.client.socket.link.e amP = null;
    private UpdateClientInfoMessage amQ = null;
    private final com.baidu.adp.framework.client.socket.link.e oN = new o(this);

    public static synchronized n zL() {
        n nVar;
        synchronized (n.class) {
            if (amR == null) {
                synchronized (n.class) {
                    if (amR == null) {
                        amR = new n();
                    }
                }
            }
            nVar = amR;
        }
        return nVar;
    }

    private n() {
        MessageManager.getInstance().addResponsedMessageRule(new p(this, BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES));
    }

    public void init() {
        MessageManager.getInstance().getSocketClient().a(this.oN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UpdateClientInfoMessage zM() {
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
        String str = new v().ue().uV().uY().mNetType;
        if (str != null) {
            updateClientInfoMessage.addUserInfo("net_type", str);
        }
        String valueOf = String.valueOf(com.baidu.adp.lib.util.i.iU());
        if (valueOf != null) {
            updateClientInfoMessage.addUserInfo("net", valueOf);
        }
        updateClientInfoMessage.addUserInfo(SocialConstants.PARAM_CUID, TbadkCoreApplication.m411getInst().getCuid());
        updateClientInfoMessage.addUserInfo("timestamp", Long.toString(System.currentTimeMillis()));
        updateClientInfoMessage.addUserInfo("model", Build.MODEL);
        updateClientInfoMessage.addUserInfo("_os_version", Build.VERSION.RELEASE);
        StringBuffer stringBuffer = new StringBuffer(15);
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp())));
        stringBuffer.append(",");
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp())));
        updateClientInfoMessage.addUserInfo("_phone_screen", stringBuffer.toString());
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xq().xt() > 0) {
            updateClientInfoMessage.addUserInfo("_msg_status", "0");
        } else {
            updateClientInfoMessage.addUserInfo("_msg_status", "1");
        }
        updateClientInfoMessage.addUserInfo("_pic_quality", String.valueOf(TbadkCoreApplication.m411getInst().getViewImageQuality()));
        try {
            if (TbadkCoreApplication.isLogin()) {
                a.b ca = com.baidu.tbadk.core.a.a.rj().ca(TbadkCoreApplication.getCurrentBduss());
                if (ca != null) {
                    updateClientInfoMessage.setBduss(ca.wt);
                } else {
                    updateClientInfoMessage.setBduss(TbadkCoreApplication.getCurrentBduss());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int dip2px = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getContext(), 70.0f);
        updateClientInfoMessage.setHeight(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getContext(), 70.0f));
        updateClientInfoMessage.setWidth(dip2px);
        if (com.baidu.tbadk.coreExtra.a.a.wl().wm()) {
            updateClientInfoMessage.setPub_env(3);
        }
        updateClientInfoMessage.setSecretKey(com.baidu.adp.framework.client.socket.coder.d.eM().eN());
        updateClientInfoMessage.addUserInfo("pversion", TiebaIMConfig.PROTOBUF_VERSION);
        if (TbadkCoreApplication.m411getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.m411getInst().getCustomizedFilter().a(updateClientInfoMessage);
        }
        return updateClientInfoMessage;
    }

    public boolean zN() {
        return this.amO >= 5;
    }

    public void zO() {
        this.amO++;
        if (zN()) {
            BdSocketLinkService.setAvailable(false);
            NoNetworkView.vz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zP() {
        this.amO = 0;
        MessageManager.getInstance().getSocketClient().ex();
        NoNetworkView.vz();
        BdSocketLinkService.stopReConnStrategy("online succ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, String str) {
        zO();
        BdSocketLinkService.close(8, "online error = " + i2);
    }

    public void a(com.baidu.adp.framework.client.socket.link.e eVar) {
        this.amP = eVar;
    }
}
