package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SyncServiceConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryNotifyUpdataGroupMessage;
import com.baidu.tieba.im.util.h;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {
    private static d bkt = null;
    private String bkv;
    private ArrayList<CustomMessageListener> bku = new ArrayList<>();
    private com.baidu.adp.framework.listener.e mListener = new e(this, 202006);
    private CustomMessageListener bkw = new f(this, 0);

    public static synchronized d RK() {
        d dVar;
        synchronized (d.class) {
            if (bkt == null) {
                bkt = new d();
            }
            dVar = bkt;
        }
        return dVar;
    }

    public void open() {
        RL();
    }

    private d() {
    }

    private void RL() {
        MessageManager.getInstance().registerListener(this.mListener);
        MessageManager.getInstance().registerListener(2016014, this.bkw);
        MessageManager.getInstance().registerListener(103004, this.bkw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PushNotifyMessage pushNotifyMessage) {
        if (pushNotifyMessage != null) {
            if (pushNotifyMessage.getType() == 3) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SyncServiceConfig(TbadkCoreApplication.m255getInst())));
            } else if (pushNotifyMessage.getType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010001, pushNotifyMessage.getContent()));
            } else {
                String valueOf = String.valueOf(pushNotifyMessage.getGroupId());
                TiebaStatic.imLog(202006, 0, "server push new", "PushNotifyManager-push_notify", "succ", 0, "", 0L, 0, "gid:" + valueOf);
                if (!TextUtils.isEmpty(valueOf)) {
                    if (pushNotifyMessage.getGroupType() == 0) {
                        com.baidu.tieba.im.b.b.QX().a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                        return;
                    }
                    int gg = com.baidu.tieba.im.b.a.gg(pushNotifyMessage.getGroupType());
                    if (com.baidu.tieba.im.memorycache.c.Qs().H(String.valueOf(pushNotifyMessage.getGroupId()), gg) != null) {
                        com.baidu.tieba.im.b.b.QX().a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                    } else {
                        a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), gg);
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

    public String RM() {
        return this.bkv;
    }

    public void ha(String str) {
        this.bkv = str;
    }
}
