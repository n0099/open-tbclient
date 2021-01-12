package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SyncServiceConfig;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryNotifyUpdataGroupMessage;
import com.baidu.tieba.im.message.RequestGetGroupInfoMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private static b kCQ = null;
    private String kCS;
    private ArrayList<CustomMessageListener> kCR = new ArrayList<>();
    private c krM = new c(CmdConfigSocket.CMD_PUSH_NOTIFY) { // from class: com.baidu.tieba.im.pushNotify.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                switch (socketResponsedMessage.getCmd()) {
                    case CmdConfigSocket.CMD_PUSH_NOTIFY /* 202006 */:
                        if (socketResponsedMessage instanceof PushNotifyMessage) {
                            b.this.a((PushNotifyMessage) socketResponsedMessage);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    };
    private CustomMessageListener kCT = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.pushNotify.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo imMessageCenterPojo;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016014 && (imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData()) != null) {
                if (imMessageCenterPojo.getCustomGroupType() == 1) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestGetGroupInfoMessage(Long.valueOf(com.baidu.adp.lib.f.b.toLong(imMessageCenterPojo.getGid(), 0L))));
                }
                com.baidu.tieba.im.a.b.cVc().c(com.baidu.adp.lib.f.b.toLong(imMessageCenterPojo.getGid(), 0L), com.baidu.tieba.im.util.b.gZ(imMessageCenterPojo.getPulled_msgId()), 0L, true);
            }
        }
    };

    public static synchronized b cVB() {
        b bVar;
        synchronized (b.class) {
            if (kCQ == null) {
                kCQ = new b();
            }
            bVar = kCQ;
        }
        return bVar;
    }

    public void open() {
        cVC();
    }

    private b() {
    }

    private void cVC() {
        MessageManager.getInstance().registerListener(this.krM);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_RESPONSE_NOTIFY_UPDATA_GROUP, this.kCT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PushNotifyMessage pushNotifyMessage) {
        if (pushNotifyMessage != null) {
            if (pushNotifyMessage.getType() == 3) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SyncServiceConfig(TbadkCoreApplication.getInst())));
            } else if (pushNotifyMessage.getType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEBUGLOG_SPECIFIED, pushNotifyMessage.getContent()));
            } else if (com.baidu.tieba.im.memorycache.b.cUG().isInit()) {
                String valueOf = String.valueOf(pushNotifyMessage.getGroupId());
                com.baidu.tbadk.core.d.a.a("im", -1L, CmdConfigSocket.CMD_PUSH_NOTIFY, "notify", 0, null, "comment", "gid-" + valueOf + "-gType-" + pushNotifyMessage.getGroupType() + "-mid-" + pushNotifyMessage.getNewestMsgId());
                if (!TextUtils.isEmpty(valueOf)) {
                    BdLog.e("pushNotifyManager groupType = " + pushNotifyMessage.getGroupType() + " gid = " + valueOf + "msgid = " + pushNotifyMessage.getNewestMsgId());
                    if (pushNotifyMessage.getGroupType() == 0) {
                        com.baidu.tieba.im.a.b.cVc().g(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                        return;
                    }
                    int CN = com.baidu.tieba.im.a.a.CN(pushNotifyMessage.getGroupType());
                    if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().mK(CN)) {
                        if (com.baidu.tieba.im.memorycache.b.cUG().br(String.valueOf(pushNotifyMessage.getGroupId()), CN) != null) {
                            com.baidu.tieba.im.a.b.cVc().g(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                        } else {
                            e(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), CN);
                        }
                    }
                }
            }
        }
    }

    private void e(long j, long j2, int i) {
        if (j2 > 0) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setCustomGroupType(i);
            imMessageCenterPojo.setGid(String.valueOf(j));
            imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.b.gY(j2 - 1));
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryNotifyUpdataGroupMessage(imMessageCenterPojo));
        }
    }

    public String cVD() {
        return this.kCS;
    }

    public void Ml(String str) {
        this.kCS = str;
    }
}
