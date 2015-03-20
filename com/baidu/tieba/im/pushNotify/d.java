package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SyncServiceConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryNotifyUpdataGroupMessage;
import com.baidu.tieba.im.util.h;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {
    private static d blP = null;
    private String blR;
    private ArrayList<CustomMessageListener> blQ = new ArrayList<>();
    private com.baidu.adp.framework.listener.e mListener = new e(this, 202006);
    private CustomMessageListener blS = new f(this, 0);

    public static synchronized d SY() {
        d dVar;
        synchronized (d.class) {
            if (blP == null) {
                blP = new d();
            }
            dVar = blP;
        }
        return dVar;
    }

    public void open() {
        SZ();
    }

    private d() {
    }

    private void SZ() {
        MessageManager.getInstance().registerListener(this.mListener);
        MessageManager.getInstance().registerListener(2016014, this.blS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PushNotifyMessage pushNotifyMessage) {
        if (pushNotifyMessage != null) {
            if (pushNotifyMessage.getType() == 3) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SyncServiceConfig(TbadkCoreApplication.m411getInst())));
            } else if (pushNotifyMessage.getType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010001, pushNotifyMessage.getContent()));
            } else if (com.baidu.tieba.im.memorycache.c.Sd().isInit()) {
                String valueOf = String.valueOf(pushNotifyMessage.getGroupId());
                TiebaStatic.imLog(202006, 0, "server push new", "PushNotifyManager-push_notify", "succ", 0, "", 0L, 0, "gid:" + valueOf);
                if (!TextUtils.isEmpty(valueOf)) {
                    BdLog.i("pushNotifyManager groupType = " + pushNotifyMessage.getGroupType() + " gid = " + valueOf + "msgid = " + pushNotifyMessage.getNewestMsgId());
                    if (pushNotifyMessage.getGroupType() == 0) {
                        com.baidu.tieba.im.b.b.SF().a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime(), 0);
                        return;
                    }
                    int gc = com.baidu.tieba.im.b.a.gc(pushNotifyMessage.getGroupType());
                    if (TbadkCoreApplication.m411getInst().getCustomizedFilter() == null || TbadkCoreApplication.m411getInst().getCustomizedFilter().bh(gc)) {
                        if (com.baidu.tieba.im.memorycache.c.Sd().D(String.valueOf(pushNotifyMessage.getGroupId()), gc) != null) {
                            com.baidu.tieba.im.b.b.SF().a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime(), gc);
                        } else {
                            a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), gc);
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
            imMessageCenterPojo.setPulled_msgId(h.af(j2 - 1));
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryNotifyUpdataGroupMessage(imMessageCenterPojo));
        }
    }

    public String Ta() {
        return this.blR;
    }

    public void gM(String str) {
        this.blR = str;
    }
}
