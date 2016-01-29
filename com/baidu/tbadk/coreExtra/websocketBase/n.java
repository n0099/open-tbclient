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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
/* loaded from: classes.dex */
public class n {
    private static n arw = null;
    private int art;
    private com.baidu.adp.framework.client.socket.link.e aru = null;
    private UpdateClientInfoMessage arv = null;
    private final com.baidu.adp.framework.client.socket.link.e oR = new o(this);

    public static synchronized n BR() {
        n nVar;
        synchronized (n.class) {
            if (arw == null) {
                synchronized (n.class) {
                    if (arw == null) {
                        arw = new n();
                    }
                }
            }
            nVar = arw;
        }
        return nVar;
    }

    private n() {
        MessageManager.getInstance().addResponsedMessageRule(new p(this, BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES));
    }

    public void init() {
        MessageManager.getInstance().getSocketClient().a(this.oR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UpdateClientInfoMessage BS() {
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
        String str = new aa().vB().wv().wy().mNetType;
        if (str != null) {
            updateClientInfoMessage.addUserInfo("net_type", str);
        }
        String valueOf = String.valueOf(com.baidu.adp.lib.util.i.jf());
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
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().zn() > 0) {
            updateClientInfoMessage.addUserInfo("_msg_status", "0");
        } else {
            updateClientInfoMessage.addUserInfo("_msg_status", "1");
        }
        updateClientInfoMessage.addUserInfo("_pic_quality", String.valueOf(TbadkCoreApplication.m411getInst().getViewImageQuality()));
        try {
            if (TbadkCoreApplication.isLogin()) {
                a.b ci = com.baidu.tbadk.core.a.a.rv().ci(TbadkCoreApplication.getCurrentBduss());
                if (ci != null) {
                    updateClientInfoMessage.setBduss(ci.wJ);
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
        if (com.baidu.tbadk.coreExtra.b.a.xQ().xR()) {
            updateClientInfoMessage.setPub_env(Integer.valueOf(com.baidu.tbadk.coreExtra.b.a.xQ().xS()));
        }
        updateClientInfoMessage.setSecretKey(com.baidu.adp.framework.client.socket.coder.d.eP().eQ());
        updateClientInfoMessage.addUserInfo("pversion", TiebaIMConfig.PROTOBUF_VERSION);
        if (TbadkCoreApplication.m411getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.m411getInst().getCustomizedFilter().a(updateClientInfoMessage);
        }
        return updateClientInfoMessage;
    }

    public boolean BT() {
        return this.art >= 5;
    }

    public void BU() {
        this.art++;
        if (BT()) {
            BdSocketLinkService.setAvailable(false);
            NoNetworkView.wV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BV() {
        this.art = 0;
        MessageManager.getInstance().getSocketClient().eA();
        NoNetworkView.wV();
        BdSocketLinkService.stopReConnStrategy("online succ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, String str) {
        BU();
        BdSocketLinkService.close(8, "online error = " + i2);
    }

    public void a(com.baidu.adp.framework.client.socket.link.e eVar) {
        this.aru = eVar;
    }
}
