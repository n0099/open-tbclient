package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
/* loaded from: classes.dex */
public class n {
    private static n axi = null;
    private int axf;
    private com.baidu.adp.framework.client.socket.link.e axg = null;
    private UpdateClientInfoMessage axh = null;
    private int axj = 0;
    private final com.baidu.adp.framework.client.socket.link.e oR = new o(this);

    public static synchronized n BE() {
        n nVar;
        synchronized (n.class) {
            if (axi == null) {
                synchronized (n.class) {
                    if (axi == null) {
                        axi = new n();
                    }
                }
            }
            nVar = axi;
        }
        return nVar;
    }

    private n() {
        MessageManager.getInstance().addResponsedMessageRule(new p(this, 1001));
    }

    public void init() {
        MessageManager.getInstance().getSocketClient().a(this.oR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UpdateClientInfoMessage BF() {
        UpdateClientInfoMessage updateClientInfoMessage = new UpdateClientInfoMessage();
        updateClientInfoMessage.addUserInfo("_client_type", "2");
        updateClientInfoMessage.addUserInfo("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.m9getInst().getImei() != null) {
            updateClientInfoMessage.addUserInfo("_phone_imei", TbadkCoreApplication.m9getInst().getImei());
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
        String str = new z().uJ().vD().vG().mNetType;
        if (str != null) {
            updateClientInfoMessage.addUserInfo("net_type", str);
        }
        String valueOf = String.valueOf(com.baidu.adp.lib.util.i.hq());
        if (valueOf != null) {
            updateClientInfoMessage.addUserInfo("net", valueOf);
        }
        updateClientInfoMessage.addUserInfo("cuid", TbadkCoreApplication.m9getInst().getCuid());
        updateClientInfoMessage.addUserInfo("timestamp", Long.toString(System.currentTimeMillis()));
        updateClientInfoMessage.addUserInfo("model", Build.MODEL);
        updateClientInfoMessage.addUserInfo("_os_version", Build.VERSION.RELEASE);
        StringBuffer stringBuffer = new StringBuffer(15);
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp())));
        stringBuffer.append(",");
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp())));
        updateClientInfoMessage.addUserInfo("_phone_screen", stringBuffer.toString());
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yR().yU() > 0) {
            updateClientInfoMessage.addUserInfo("_msg_status", "0");
        } else {
            updateClientInfoMessage.addUserInfo("_msg_status", "1");
        }
        updateClientInfoMessage.addUserInfo("_pic_quality", String.valueOf(TbadkCoreApplication.m9getInst().getViewImageQuality()));
        try {
            if (TbadkCoreApplication.isLogin()) {
                a.b ce = com.baidu.tbadk.core.a.a.pd().ce(TbadkCoreApplication.getCurrentBduss());
                String d = com.baidu.tbadk.core.a.h.d(TbadkCoreApplication.getCurrentAccountInfo());
                if (ce != null) {
                    updateClientInfoMessage.setBduss(ce.mBduss, d);
                } else {
                    updateClientInfoMessage.setBduss(TbadkCoreApplication.getCurrentBduss(), d);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int dip2px = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getContext(), 70.0f);
        updateClientInfoMessage.setHeight(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getContext(), 70.0f));
        updateClientInfoMessage.setWidth(dip2px);
        if (com.baidu.tbadk.coreExtra.b.a.xm().xn()) {
            updateClientInfoMessage.setPub_env(Integer.valueOf(com.baidu.tbadk.coreExtra.b.a.xm().xo()));
        }
        updateClientInfoMessage.setSecretKey(com.baidu.adp.framework.client.socket.coder.d.dk().dl());
        updateClientInfoMessage.addUserInfo("pversion", TiebaIMConfig.PROTOBUF_VERSION);
        if (TbadkCoreApplication.m9getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.m9getInst().getCustomizedFilter().a(updateClientInfoMessage);
        }
        return updateClientInfoMessage;
    }

    public boolean BG() {
        return this.axf >= 5;
    }

    public void BH() {
        this.axf++;
        if (BG()) {
            BdSocketLinkService.setAvailable(false);
            NoNetworkView.wh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BI() {
        this.axf = 0;
        MessageManager.getInstance().getSocketClient().cS();
        NoNetworkView.wh();
        BdSocketLinkService.stopReConnStrategy("online succ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, String str) {
        BH();
        BdSocketLinkService.close(8, "online error = " + i2);
    }

    public void a(com.baidu.adp.framework.client.socket.link.e eVar) {
        this.axg = eVar;
    }
}
