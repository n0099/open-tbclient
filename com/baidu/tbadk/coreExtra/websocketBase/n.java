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
    private static n aoh = null;
    private int aoe;
    private com.baidu.adp.framework.client.socket.link.e aof = null;
    private UpdateClientInfoMessage aog = null;
    private int aoi = 0;
    private final com.baidu.adp.framework.client.socket.link.e eK = new o(this);

    public static synchronized n Au() {
        n nVar;
        synchronized (n.class) {
            if (aoh == null) {
                synchronized (n.class) {
                    if (aoh == null) {
                        aoh = new n();
                    }
                }
            }
            nVar = aoh;
        }
        return nVar;
    }

    private n() {
        MessageManager.getInstance().addResponsedMessageRule(new p(this, 1001));
    }

    public void init() {
        MessageManager.getInstance().getSocketClient().a(this.eK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UpdateClientInfoMessage Av() {
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
        String str = new ab().ty().uu().ux().mNetType;
        if (str != null) {
            updateClientInfoMessage.addUserInfo("net_type", str);
        }
        String valueOf = String.valueOf(com.baidu.adp.lib.util.i.fx());
        if (valueOf != null) {
            updateClientInfoMessage.addUserInfo("net", valueOf);
        }
        updateClientInfoMessage.addUserInfo(SocialConstants.PARAM_CUID, TbadkCoreApplication.m9getInst().getCuid());
        updateClientInfoMessage.addUserInfo("timestamp", Long.toString(System.currentTimeMillis()));
        updateClientInfoMessage.addUserInfo("model", Build.MODEL);
        updateClientInfoMessage.addUserInfo("_os_version", Build.VERSION.RELEASE);
        StringBuffer stringBuffer = new StringBuffer(15);
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.k.A(TbadkCoreApplication.m9getInst().getApp())));
        stringBuffer.append(",");
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m9getInst().getApp())));
        updateClientInfoMessage.addUserInfo("_phone_screen", stringBuffer.toString());
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xK().xN() > 0) {
            updateClientInfoMessage.addUserInfo("_msg_status", "0");
        } else {
            updateClientInfoMessage.addUserInfo("_msg_status", "1");
        }
        updateClientInfoMessage.addUserInfo("_pic_quality", String.valueOf(TbadkCoreApplication.m9getInst().getViewImageQuality()));
        try {
            if (TbadkCoreApplication.isLogin()) {
                a.b cc = com.baidu.tbadk.core.a.a.oe().cc(TbadkCoreApplication.getCurrentBduss());
                if (cc != null) {
                    updateClientInfoMessage.setBduss(cc.mZ);
                } else {
                    updateClientInfoMessage.setBduss(TbadkCoreApplication.getCurrentBduss());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int dip2px = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getContext(), 70.0f);
        updateClientInfoMessage.setHeight(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getContext(), 70.0f));
        updateClientInfoMessage.setWidth(dip2px);
        if (com.baidu.tbadk.coreExtra.b.a.wo().wp()) {
            updateClientInfoMessage.setPub_env(Integer.valueOf(com.baidu.tbadk.coreExtra.b.a.wo().wq()));
        }
        updateClientInfoMessage.setSecretKey(com.baidu.adp.framework.client.socket.coder.d.bh().bi());
        updateClientInfoMessage.addUserInfo("pversion", TiebaIMConfig.PROTOBUF_VERSION);
        if (TbadkCoreApplication.m9getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.m9getInst().getCustomizedFilter().a(updateClientInfoMessage);
        }
        return updateClientInfoMessage;
    }

    public boolean Aw() {
        return this.aoe >= 5;
    }

    public void Ax() {
        this.aoe++;
        if (Aw()) {
            BdSocketLinkService.setAvailable(false);
            NoNetworkView.uY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ay() {
        this.aoe = 0;
        MessageManager.getInstance().getSocketClient().aQ();
        NoNetworkView.uY();
        BdSocketLinkService.stopReConnStrategy("online succ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, String str) {
        Ax();
        BdSocketLinkService.close(8, "online error = " + i2);
    }

    public void a(com.baidu.adp.framework.client.socket.link.e eVar) {
        this.aof = eVar;
    }
}
