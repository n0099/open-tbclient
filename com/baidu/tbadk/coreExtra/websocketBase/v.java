package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
/* loaded from: classes.dex */
public class v {
    private static v Wz = null;
    private int Ww;
    private com.baidu.adp.framework.client.socket.link.g Wx = null;
    private UpdateClientInfoMessage Wy = null;
    private final com.baidu.adp.framework.client.socket.link.g du = new w(this);

    public static synchronized v uw() {
        v vVar;
        synchronized (v.class) {
            if (Wz == null) {
                synchronized (v.class) {
                    if (Wz == null) {
                        Wz = new v();
                    }
                }
            }
            vVar = Wz;
        }
        return vVar;
    }

    private v() {
        MessageManager.getInstance().addResponsedMessageRule(new x(this, 1001));
    }

    public void init() {
        MessageManager.getInstance().getSocketClient().a(this.du);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UpdateClientInfoMessage ux() {
        UpdateClientInfoMessage updateClientInfoMessage = new UpdateClientInfoMessage();
        updateClientInfoMessage.addUserInfo("_client_type", "2");
        updateClientInfoMessage.addUserInfo("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.m255getInst().getImei() != null) {
            updateClientInfoMessage.addUserInfo("_phone_imei", TbadkCoreApplication.m255getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            updateClientInfoMessage.addUserInfo("_client_id", clientId);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            updateClientInfoMessage.addUserInfo("from", from);
        }
        String str = new ad().oZ().qg().qj().mNetType;
        if (str != null) {
            updateClientInfoMessage.addUserInfo("net_type", str);
        }
        String valueOf = String.valueOf(com.baidu.adp.lib.util.i.fk());
        if (valueOf != null) {
            updateClientInfoMessage.addUserInfo("net", valueOf);
        }
        updateClientInfoMessage.addUserInfo("cuid", TbadkCoreApplication.m255getInst().getCuid());
        updateClientInfoMessage.addUserInfo("timestamp", Long.toString(System.currentTimeMillis()));
        updateClientInfoMessage.addUserInfo("model", Build.MODEL);
        updateClientInfoMessage.addUserInfo("_os_version", Build.VERSION.RELEASE);
        StringBuffer stringBuffer = new StringBuffer(15);
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.l.M(TbadkCoreApplication.m255getInst().getApp())));
        stringBuffer.append(",");
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getApp())));
        updateClientInfoMessage.addUserInfo("_phone_screen", stringBuffer.toString());
        if (TbadkCoreApplication.m255getInst().getMsgFrequency() > 0) {
            updateClientInfoMessage.addUserInfo("_msg_status", "0");
        } else {
            updateClientInfoMessage.addUserInfo("_msg_status", "1");
        }
        updateClientInfoMessage.addUserInfo("_pic_quality", String.valueOf(TbadkCoreApplication.m255getInst().getViewImageQuality()));
        try {
            if (TbadkCoreApplication.isLogin()) {
                AccountLoginHelper.OurToken parseBDUSS = AccountLoginHelper.parseBDUSS(TbadkCoreApplication.getCurrentBduss());
                if (parseBDUSS != null) {
                    updateClientInfoMessage.setBduss(parseBDUSS.mBduss);
                } else {
                    updateClientInfoMessage.setBduss(TbadkCoreApplication.getCurrentBduss());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int dip2px = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.m255getInst().getContext(), 70.0f);
        updateClientInfoMessage.setHeight(com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.m255getInst().getContext(), 70.0f));
        updateClientInfoMessage.setWidth(dip2px);
        if (com.baidu.tbadk.coreExtra.a.a.rD().rE()) {
            updateClientInfoMessage.setPub_env(3);
        }
        updateClientInfoMessage.setSecretKey(com.baidu.adp.framework.client.socket.coder.d.bl().bm());
        updateClientInfoMessage.addUserInfo("pversion", TiebaIMConfig.PROTOBUF_VERSION);
        return updateClientInfoMessage;
    }

    public boolean uy() {
        return this.Ww >= 5;
    }

    public void uz() {
        this.Ww++;
        if (uy()) {
            BdSocketLinkService.setAvailable(false);
            NoNetworkView.qH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uA() {
        this.Ww = 0;
        MessageManager.getInstance().getSocketClient().aW();
        NoNetworkView.qH();
        BdSocketLinkService.stopReConnStrategy("online succ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str) {
        uz();
        BdSocketLinkService.close(8, "online error = " + i2);
    }

    public void a(com.baidu.adp.framework.client.socket.link.g gVar) {
        this.Wx = gVar;
    }
}
