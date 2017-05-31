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
    private static c dfD = null;
    private String dfF;
    private ArrayList<CustomMessageListener> dfE = new ArrayList<>();
    private com.baidu.adp.framework.listener.e cOw = new d(this, 202006);
    private CustomMessageListener dfG = new e(this, 0);

    public static synchronized c asb() {
        c cVar;
        synchronized (c.class) {
            if (dfD == null) {
                dfD = new c();
            }
            cVar = dfD;
        }
        return cVar;
    }

    public void open() {
        asc();
    }

    private c() {
    }

    private void asc() {
        MessageManager.getInstance().registerListener(this.cOw);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_RESPONSE_NOTIFY_UPDATA_GROUP, this.dfG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PushNotifyMessage pushNotifyMessage) {
        if (pushNotifyMessage != null) {
            if (pushNotifyMessage.getType() == 3) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SyncServiceConfig(TbadkCoreApplication.m9getInst())));
            } else if (pushNotifyMessage.getType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEBUGLOG_SPECIFIED, pushNotifyMessage.getContent()));
            } else if (com.baidu.tieba.im.memorycache.b.aqX().aqW()) {
                String valueOf = String.valueOf(pushNotifyMessage.getGroupId());
                com.baidu.tbadk.core.e.a.a("im", -1L, 202006, "notify", 0, null, "comment", "gid-" + valueOf + "-gType-" + pushNotifyMessage.getGroupType() + "-mid-" + pushNotifyMessage.getNewestMsgId());
                if (!TextUtils.isEmpty(valueOf)) {
                    BdLog.e("pushNotifyManager groupType = " + pushNotifyMessage.getGroupType() + " gid = " + valueOf + "msgid = " + pushNotifyMessage.getNewestMsgId());
                    if (pushNotifyMessage.getGroupType() == 0) {
                        com.baidu.tieba.im.b.b.arz().a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                        return;
                    }
                    int lY = com.baidu.tieba.im.b.a.lY(pushNotifyMessage.getGroupType());
                    if (TbadkCoreApplication.m9getInst().getCustomizedFilter() == null || TbadkCoreApplication.m9getInst().getCustomizedFilter().bu(lY)) {
                        if (com.baidu.tieba.im.memorycache.b.aqX().Z(String.valueOf(pushNotifyMessage.getGroupId()), lY) != null) {
                            com.baidu.tieba.im.b.b.arz().a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                        } else {
                            a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), lY);
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
            imMessageCenterPojo.setPulled_msgId(g.bA(j2 - 1));
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryNotifyUpdataGroupMessage(imMessageCenterPojo));
        }
    }

    public String asd() {
        return this.dfF;
    }

    public void la(String str) {
        this.dfF = str;
    }
}
