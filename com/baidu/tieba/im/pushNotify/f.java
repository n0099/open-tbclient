package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.SyncServiceConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.bu;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryNotifyUpdataGroupMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    private static f bhn = null;
    private String bhp;
    private ArrayList<CustomMessageListener> bho = new ArrayList<>();
    private com.baidu.adp.framework.listener.e ayJ = new g(this, 202006);
    private CustomMessageListener bhq = new h(this, 0);

    public static synchronized f Rn() {
        f fVar;
        synchronized (f.class) {
            if (bhn == null) {
                bhn = new f();
            }
            fVar = bhn;
        }
        return fVar;
    }

    public void open() {
        Ro();
    }

    private f() {
    }

    private void Ro() {
        MessageManager.getInstance().registerListener(this.ayJ);
        MessageManager.getInstance().registerListener(2016014, this.bhq);
        MessageManager.getInstance().registerListener(103004, this.bhq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PushNotifyMessage pushNotifyMessage) {
        if (pushNotifyMessage != null) {
            if (pushNotifyMessage.getType() == 3) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SyncServiceConfig(TbadkApplication.m251getInst())));
            } else if (pushNotifyMessage.getType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010001, pushNotifyMessage.getContent()));
            } else {
                String valueOf = String.valueOf(pushNotifyMessage.getGroupId());
                TiebaStatic.imLog(202006, 0, "server push new", "PushNotifyManager-push_notify", "succ", 0, "", 0L, 0, "gid:" + valueOf);
                if (!TextUtils.isEmpty(valueOf)) {
                    if (pushNotifyMessage.getGroupType() == 0) {
                        com.baidu.tieba.im.c.b.Qv().b(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                        return;
                    }
                    int fX = com.baidu.tieba.im.c.a.fX(pushNotifyMessage.getGroupType());
                    if (com.baidu.tieba.im.memorycache.c.PK().B(String.valueOf(pushNotifyMessage.getGroupId()), fX) != null) {
                        com.baidu.tieba.im.c.b.Qv().b(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                    } else {
                        a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), fX);
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
            imMessageCenterPojo.setPulled_msgId(bu.F(j2 - 1));
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryNotifyUpdataGroupMessage(imMessageCenterPojo));
        }
    }

    public String Rp() {
        return this.bhp;
    }

    public void gz(String str) {
        this.bhp = str;
    }
}
