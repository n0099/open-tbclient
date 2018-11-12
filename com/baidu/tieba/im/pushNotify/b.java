package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ng.ai.apps.system.bluetooth.utils.AiAppsBluetoothConstants;
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
    private static b eQY = null;
    private String eRa;
    private ArrayList<CustomMessageListener> eQZ = new ArrayList<>();
    private c eAl = new c(202006) { // from class: com.baidu.tieba.im.pushNotify.b.1
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
    private CustomMessageListener eRb = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.pushNotify.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo imMessageCenterPojo;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016014 && (imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData()) != null) {
                if (imMessageCenterPojo.getCustomGroupType() == 1) {
                    MessageManager.getInstance().dispatchResponsedMessage(new RequestGetGroupInfoMessage(Long.valueOf(com.baidu.adp.lib.g.b.d(imMessageCenterPojo.getGid(), 0L))));
                }
                com.baidu.tieba.im.a.b.aRy().a(com.baidu.adp.lib.g.b.d(imMessageCenterPojo.getGid(), 0L), d.cw(imMessageCenterPojo.getPulled_msgId()), 0L, true);
            }
        }
    };

    public static synchronized b aRY() {
        b bVar;
        synchronized (b.class) {
            if (eQY == null) {
                eQY = new b();
            }
            bVar = eQY;
        }
        return bVar;
    }

    public void open() {
        aRZ();
    }

    private b() {
    }

    private void aRZ() {
        MessageManager.getInstance().registerListener(this.eAl);
        MessageManager.getInstance().registerListener(2016014, this.eRb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PushNotifyMessage pushNotifyMessage) {
        if (pushNotifyMessage != null) {
            if (pushNotifyMessage.getType() == 3) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SyncServiceConfig(TbadkCoreApplication.getInst())));
            } else if (pushNotifyMessage.getType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010001, pushNotifyMessage.getContent()));
            } else if (com.baidu.tieba.im.memorycache.b.aQV().qp()) {
                String valueOf = String.valueOf(pushNotifyMessage.getGroupId());
                com.baidu.tbadk.core.d.a.a("im", -1L, 202006, AiAppsBluetoothConstants.KEY_CHARACTERISTICS_NOTIFY, 0, null, ClientCookie.COMMENT_ATTR, "gid-" + valueOf + "-gType-" + pushNotifyMessage.getGroupType() + "-mid-" + pushNotifyMessage.getNewestMsgId());
                if (!TextUtils.isEmpty(valueOf)) {
                    BdLog.e("pushNotifyManager groupType = " + pushNotifyMessage.getGroupType() + " gid = " + valueOf + "msgid = " + pushNotifyMessage.getNewestMsgId());
                    if (pushNotifyMessage.getGroupType() == 0) {
                        com.baidu.tieba.im.a.b.aRy().d(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                        return;
                    }
                    int pQ = com.baidu.tieba.im.a.a.pQ(pushNotifyMessage.getGroupType());
                    if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().ci(pQ)) {
                        if (com.baidu.tieba.im.memorycache.b.aQV().aw(String.valueOf(pushNotifyMessage.getGroupId()), pQ) != null) {
                            com.baidu.tieba.im.a.b.aRy().d(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                        } else {
                            c(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pQ);
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
            imMessageCenterPojo.setPulled_msgId(d.cv(j2 - 1));
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryNotifyUpdataGroupMessage(imMessageCenterPojo));
        }
    }

    public String aSa() {
        return this.eRa;
    }

    public void pR(String str) {
        this.eRa = str;
    }
}
