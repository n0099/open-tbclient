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
public class c {
    private static c dny = null;
    private String dnA;
    private ArrayList<CustomMessageListener> dnz = new ArrayList<>();
    private com.baidu.adp.framework.listener.e cWs = new d(this, 202006);
    private CustomMessageListener dnB = new e(this, 0);

    public static synchronized c avM() {
        c cVar;
        synchronized (c.class) {
            if (dny == null) {
                dny = new c();
            }
            cVar = dny;
        }
        return cVar;
    }

    public void open() {
        avN();
    }

    private c() {
    }

    private void avN() {
        MessageManager.getInstance().registerListener(this.cWs);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_RESPONSE_NOTIFY_UPDATA_GROUP, this.dnB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PushNotifyMessage pushNotifyMessage) {
        if (pushNotifyMessage != null) {
            if (pushNotifyMessage.getType() == 3) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SyncServiceConfig(TbadkCoreApplication.m9getInst())));
            } else if (pushNotifyMessage.getType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEBUGLOG_SPECIFIED, pushNotifyMessage.getContent()));
            } else if (com.baidu.tieba.im.memorycache.b.auI().auH()) {
                String valueOf = String.valueOf(pushNotifyMessage.getGroupId());
                com.baidu.tbadk.core.d.a.a("im", -1L, 202006, "notify", 0, null, "comment", "gid-" + valueOf + "-gType-" + pushNotifyMessage.getGroupType() + "-mid-" + pushNotifyMessage.getNewestMsgId());
                if (!TextUtils.isEmpty(valueOf)) {
                    BdLog.e("pushNotifyManager groupType = " + pushNotifyMessage.getGroupType() + " gid = " + valueOf + "msgid = " + pushNotifyMessage.getNewestMsgId());
                    if (pushNotifyMessage.getGroupType() == 0) {
                        com.baidu.tieba.im.b.b.avk().a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                        return;
                    }
                    int mj = com.baidu.tieba.im.b.a.mj(pushNotifyMessage.getGroupType());
                    if (TbadkCoreApplication.m9getInst().getCustomizedFilter() == null || TbadkCoreApplication.m9getInst().getCustomizedFilter().bu(mj)) {
                        if (com.baidu.tieba.im.memorycache.b.auI().ab(String.valueOf(pushNotifyMessage.getGroupId()), mj) != null) {
                            com.baidu.tieba.im.b.b.avk().a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                        } else {
                            c(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), mj);
                        }
                    }
                }
            }
        }
    }

    private void c(long j, long j2, int i) {
        if (j2 > 0) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setCustomGroupType(i);
            imMessageCenterPojo.setGid(String.valueOf(j));
            imMessageCenterPojo.setPulled_msgId(g.bO(j2 - 1));
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryNotifyUpdataGroupMessage(imMessageCenterPojo));
        }
    }

    public String avO() {
        return this.dnA;
    }

    public void lZ(String str) {
        this.dnA = str;
    }
}
