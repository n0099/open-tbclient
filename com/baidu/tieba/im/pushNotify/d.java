package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SyncServiceConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryNotifyUpdataGroupMessage;
import com.baidu.tieba.im.util.g;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {
    private static d bGM = null;
    private String bGO;
    private ArrayList<CustomMessageListener> bGN = new ArrayList<>();
    private com.baidu.adp.framework.listener.e mListener = new e(this, 202006);
    private CustomMessageListener bGP = new f(this, 0);

    public static synchronized d Xi() {
        d dVar;
        synchronized (d.class) {
            if (bGM == null) {
                bGM = new d();
            }
            dVar = bGM;
        }
        return dVar;
    }

    public void open() {
        Xj();
    }

    private d() {
    }

    private void Xj() {
        MessageManager.getInstance().registerListener(this.mListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_RESPONSE_NOTIFY_UPDATA_GROUP, this.bGP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PushNotifyMessage pushNotifyMessage) {
        if (pushNotifyMessage != null) {
            if (pushNotifyMessage.getType() == 3) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SyncServiceConfig(TbadkCoreApplication.m411getInst())));
            } else if (pushNotifyMessage.getType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEBUGLOG_SPECIFIED, pushNotifyMessage.getContent()));
            } else if (com.baidu.tieba.im.memorycache.b.Wn().isInit()) {
                String valueOf = String.valueOf(pushNotifyMessage.getGroupId());
                com.baidu.tbadk.core.log.b.a("im", -1L, 202006, "notify", 0, null, "comment", "gid-" + valueOf + "-gType-" + pushNotifyMessage.getGroupType() + "-mid-" + pushNotifyMessage.getNewestMsgId());
                if (!TextUtils.isEmpty(valueOf)) {
                    BdLog.i("pushNotifyManager groupType = " + pushNotifyMessage.getGroupType() + " gid = " + valueOf + "msgid = " + pushNotifyMessage.getNewestMsgId());
                    if (pushNotifyMessage.getGroupType() == 0) {
                        com.baidu.tieba.im.b.b.WO().b(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                        return;
                    }
                    int hC = com.baidu.tieba.im.b.a.hC(pushNotifyMessage.getGroupType());
                    if (TbadkCoreApplication.m411getInst().getCustomizedFilter() == null || TbadkCoreApplication.m411getInst().getCustomizedFilter().bn(hC)) {
                        if (com.baidu.tieba.im.memorycache.b.Wn().J(String.valueOf(pushNotifyMessage.getGroupId()), hC) != null) {
                            com.baidu.tieba.im.b.b.WO().b(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                        } else {
                            a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), hC);
                        }
                    }
                }
            }
        }
    }

    private void a(long j, long j2, int i) {
        if (j2 > 0) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setCustomGroupType(i);
            imMessageCenterPojo.setGid(String.valueOf(j));
            imMessageCenterPojo.setPulled_msgId(g.aJ(j2 - 1));
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryNotifyUpdataGroupMessage(imMessageCenterPojo));
        }
    }

    public String Xk() {
        return this.bGO;
    }

    public void ik(String str) {
        this.bGO = str;
    }
}
