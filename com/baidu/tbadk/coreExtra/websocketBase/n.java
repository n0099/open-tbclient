package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
/* loaded from: classes.dex */
public class n {
    private static n asd = null;
    private int asa;
    private com.baidu.adp.framework.client.socket.link.e asb = null;
    private UpdateClientInfoMessage asc = null;
    private int ase = 0;
    private final com.baidu.adp.framework.client.socket.link.e hz = new o(this);

    public static synchronized n BJ() {
        n nVar;
        synchronized (n.class) {
            if (asd == null) {
                synchronized (n.class) {
                    if (asd == null) {
                        asd = new n();
                    }
                }
            }
            nVar = asd;
        }
        return nVar;
    }

    private n() {
        MessageManager.getInstance().addResponsedMessageRule(new p(this, 1001));
    }

    public void init() {
        MessageManager.getInstance().getSocketClient().a(this.hz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UpdateClientInfoMessage BK() {
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
        String str = new ab().uD().vz().vC().mNetType;
        if (str != null) {
            updateClientInfoMessage.addUserInfo("net_type", str);
        }
        String valueOf = String.valueOf(com.baidu.adp.lib.util.i.gs());
        if (valueOf != null) {
            updateClientInfoMessage.addUserInfo("net", valueOf);
        }
        updateClientInfoMessage.addUserInfo(SocialConstants.PARAM_CUID, TbadkCoreApplication.m9getInst().getCuid());
        updateClientInfoMessage.addUserInfo("timestamp", Long.toString(System.currentTimeMillis()));
        updateClientInfoMessage.addUserInfo("model", Build.MODEL);
        updateClientInfoMessage.addUserInfo("_os_version", Build.VERSION.RELEASE);
        StringBuffer stringBuffer = new StringBuffer(15);
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst().getApp())));
        stringBuffer.append(",");
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getApp())));
        updateClientInfoMessage.addUserInfo("_phone_screen", stringBuffer.toString());
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yX().za() > 0) {
            updateClientInfoMessage.addUserInfo("_msg_status", "0");
        } else {
            updateClientInfoMessage.addUserInfo("_msg_status", "1");
        }
        updateClientInfoMessage.addUserInfo("_pic_quality", String.valueOf(TbadkCoreApplication.m9getInst().getViewImageQuality()));
        try {
            if (TbadkCoreApplication.isLogin()) {
                a.b ce = com.baidu.tbadk.core.a.a.oO().ce(TbadkCoreApplication.getCurrentBduss());
                String d = com.baidu.tbadk.core.a.h.d(TbadkCoreApplication.getCurrentAccountInfo());
                if (ce != null) {
                    updateClientInfoMessage.setBduss(ce.pX, d);
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
        if (com.baidu.tbadk.coreExtra.b.a.xs().xt()) {
            updateClientInfoMessage.setPub_env(Integer.valueOf(com.baidu.tbadk.coreExtra.b.a.xs().xu()));
        }
        updateClientInfoMessage.setSecretKey(com.baidu.adp.framework.client.socket.coder.d.cb().cc());
        updateClientInfoMessage.addUserInfo("pversion", TiebaIMConfig.PROTOBUF_VERSION);
        if (TbadkCoreApplication.m9getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.m9getInst().getCustomizedFilter().a(updateClientInfoMessage);
        }
        return updateClientInfoMessage;
    }

    public boolean BL() {
        return this.asa >= 5;
    }

    public void BM() {
        this.asa++;
        if (BL()) {
            BdSocketLinkService.setAvailable(false);
            NoNetworkView.wc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BN() {
        this.asa = 0;
        MessageManager.getInstance().getSocketClient().bK();
        NoNetworkView.wc();
        BdSocketLinkService.stopReConnStrategy("online succ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, String str) {
        BM();
        BdSocketLinkService.close(8, "online error = " + i2);
    }

    public void a(com.baidu.adp.framework.client.socket.link.e eVar) {
        this.asb = eVar;
    }
}
