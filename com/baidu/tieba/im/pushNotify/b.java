package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SyncServiceConfig;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryNotifyUpdataGroupMessage;
import com.baidu.tieba.im.message.RequestGetGroupInfoMessage;
import com.baidu.tieba.im.util.d;
import java.util.ArrayList;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes.dex */
public class b {
    private static b ewQ = null;
    private String ewS;
    private ArrayList<CustomMessageListener> ewR = new ArrayList<>();
    private c efV = new c(202006) { // from class: com.baidu.tieba.im.pushNotify.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                switch (socketResponsedMessage.getCmd()) {
                    case 202006:
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
    private CustomMessageListener ewT = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.pushNotify.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo imMessageCenterPojo;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016014 && (imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData()) != null) {
                if (imMessageCenterPojo.getCustomGroupType() == 1) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestGetGroupInfoMessage(Long.valueOf(com.baidu.adp.lib.g.b.c(imMessageCenterPojo.getGid(), 0L))));
                }
                com.baidu.tieba.im.a.b.aLA().a(com.baidu.adp.lib.g.b.c(imMessageCenterPojo.getGid(), 0L), d.cl(imMessageCenterPojo.getPulled_msgId()), 0L, true);
            }
        }
    };

    public static synchronized b aMb() {
        b bVar;
        synchronized (b.class) {
            if (ewQ == null) {
                ewQ = new b();
            }
            bVar = ewQ;
        }
        return bVar;
    }

    public void open() {
        aMc();
    }

    private b() {
    }

    private void aMc() {
        MessageManager.getInstance().registerListener(this.efV);
        MessageManager.getInstance().registerListener(2016014, this.ewT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PushNotifyMessage pushNotifyMessage) {
        if (pushNotifyMessage != null) {
            if (pushNotifyMessage.getType() == 3) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SyncServiceConfig(TbadkCoreApplication.getInst())));
            } else if (pushNotifyMessage.getType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010001, pushNotifyMessage.getContent()));
            } else if (com.baidu.tieba.im.memorycache.b.aKX().aKW()) {
                String valueOf = String.valueOf(pushNotifyMessage.getGroupId());
                com.baidu.tbadk.core.d.a.a("im", -1L, 202006, "notify", 0, null, ClientCookie.COMMENT_ATTR, "gid-" + valueOf + "-gType-" + pushNotifyMessage.getGroupType() + "-mid-" + pushNotifyMessage.getNewestMsgId());
                if (!TextUtils.isEmpty(valueOf)) {
                    BdLog.e("pushNotifyManager groupType = " + pushNotifyMessage.getGroupType() + " gid = " + valueOf + "msgid = " + pushNotifyMessage.getNewestMsgId());
                    if (pushNotifyMessage.getGroupType() == 0) {
                        com.baidu.tieba.im.a.b.aLA().d(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                        return;
                    }
                    int oh = com.baidu.tieba.im.a.a.oh(pushNotifyMessage.getGroupType());
                    if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().bw(oh)) {
                        if (com.baidu.tieba.im.memorycache.b.aKX().ar(String.valueOf(pushNotifyMessage.getGroupId()), oh) != null) {
                            com.baidu.tieba.im.a.b.aLA().d(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                        } else {
                            c(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), oh);
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
            imMessageCenterPojo.setPulled_msgId(d.ck(j2 - 1));
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryNotifyUpdataGroupMessage(imMessageCenterPojo));
        }
    }

    public String aMd() {
        return this.ewS;
    }

    public void oF(String str) {
        this.ewS = str;
    }
}
