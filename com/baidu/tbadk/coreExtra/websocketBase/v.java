package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
/* loaded from: classes.dex */
public class v {
    private static v Qf = null;
    private int Qc;
    private com.baidu.adp.framework.client.socket.link.g Qd = null;
    private UpdateClientInfoMessage Qe = null;
    private final com.baidu.adp.framework.client.socket.link.g bn = new w(this);

    public static synchronized v qL() {
        v vVar;
        synchronized (v.class) {
            if (Qf == null) {
                synchronized (v.class) {
                    if (Qf == null) {
                        Qf = new v();
                    }
                }
            }
            vVar = Qf;
        }
        return vVar;
    }

    private v() {
        MessageManager.getInstance().addResponsedMessageRule(new x(this, 1001));
    }

    public void init() {
        MessageManager.getInstance().getSocketClient().a(this.bn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UpdateClientInfoMessage qM() {
        UpdateClientInfoMessage updateClientInfoMessage = new UpdateClientInfoMessage();
        updateClientInfoMessage.addUserInfo("_client_type", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
        updateClientInfoMessage.addUserInfo("_client_version", TbConfig.getVersion());
        if (TbadkApplication.m251getInst().getImei() != null) {
            updateClientInfoMessage.addUserInfo("_phone_imei", TbadkApplication.m251getInst().getImei());
        }
        String clientId = TbadkApplication.getClientId();
        if (clientId != null) {
            updateClientInfoMessage.addUserInfo("_client_id", clientId);
        }
        String from = TbadkApplication.getFrom();
        if (from != null && from.length() > 0) {
            updateClientInfoMessage.addUserInfo("from", from);
        }
        String str = new ac().mc().na().nd().mNetType;
        if (str != null) {
            updateClientInfoMessage.addUserInfo("net_type", str);
        }
        String valueOf = String.valueOf(com.baidu.adp.lib.util.j.fm());
        if (valueOf != null) {
            updateClientInfoMessage.addUserInfo("net", valueOf);
        }
        updateClientInfoMessage.addUserInfo("cuid", TbadkApplication.m251getInst().getCuid());
        updateClientInfoMessage.addUserInfo("timestamp", Long.toString(System.currentTimeMillis()));
        updateClientInfoMessage.addUserInfo("model", Build.MODEL);
        updateClientInfoMessage.addUserInfo("_os_version", Build.VERSION.RELEASE);
        StringBuffer stringBuffer = new StringBuffer(15);
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.m.n(TbadkApplication.m251getInst().getApp())));
        stringBuffer.append(",");
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.m.o(TbadkApplication.m251getInst().getApp())));
        updateClientInfoMessage.addUserInfo("_phone_screen", stringBuffer.toString());
        if (TbadkApplication.m251getInst().getMsgFrequency() > 0) {
            updateClientInfoMessage.addUserInfo("_msg_status", "0");
        } else {
            updateClientInfoMessage.addUserInfo("_msg_status", "1");
        }
        updateClientInfoMessage.addUserInfo("_pic_quality", String.valueOf(TbadkApplication.m251getInst().getViewImageQuality()));
        try {
            if (TbadkApplication.isLogin()) {
                AccountLoginHelper.OurToken parseBDUSS = AccountLoginHelper.parseBDUSS(TbadkApplication.getCurrentBduss());
                if (parseBDUSS != null) {
                    updateClientInfoMessage.setBduss(parseBDUSS.mBduss);
                } else {
                    updateClientInfoMessage.setBduss(TbadkApplication.getCurrentBduss());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int dip2px = com.baidu.adp.lib.util.m.dip2px(TbadkApplication.m251getInst().getContext(), 70.0f);
        updateClientInfoMessage.setHeight(com.baidu.adp.lib.util.m.dip2px(TbadkApplication.m251getInst().getContext(), 70.0f));
        updateClientInfoMessage.setWidth(dip2px);
        if (com.baidu.tbadk.coreExtra.a.a.or().os()) {
            updateClientInfoMessage.setPub_env(3);
        }
        updateClientInfoMessage.setSecretKey(com.baidu.adp.framework.client.socket.coder.d.aL().aM());
        updateClientInfoMessage.addUserInfo("pversion", TiebaIMConfig.PROTOBUF_VERSION);
        return updateClientInfoMessage;
    }

    public boolean qN() {
        return this.Qc >= 5;
    }

    public void qO() {
        this.Qc++;
        if (qN()) {
            BdSocketLinkService.setAvailable(false);
            NoNetworkView.nx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qP() {
        this.Qc = 0;
        MessageManager.getInstance().getSocketClient().aw();
        NoNetworkView.nx();
        BdSocketLinkService.stopReConnStrategy("online succ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str) {
        qO();
        BdSocketLinkService.close(8, "online error = " + i2);
    }

    public void a(com.baidu.adp.framework.client.socket.link.g gVar) {
        this.Qd = gVar;
    }
}
