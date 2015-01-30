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
    private static d blQ = null;
    private String blS;
    private ArrayList<CustomMessageListener> blR = new ArrayList<>();
    private com.baidu.adp.framework.listener.e mListener = new e(this, 202006);
    private CustomMessageListener blT = new f(this, 0);

    public static synchronized d Sg() {
        d dVar;
        synchronized (d.class) {
            if (blQ == null) {
                blQ = new d();
            }
            dVar = blQ;
        }
        return dVar;
    }

    public void open() {
        Sh();
    }

    private d() {
    }

    private void Sh() {
        MessageManager.getInstance().registerListener(this.mListener);
        MessageManager.getInstance().registerListener(2016014, this.blT);
        MessageManager.getInstance().registerListener(103004, this.blT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PushNotifyMessage pushNotifyMessage) {
        if (pushNotifyMessage != null) {
            if (pushNotifyMessage.getType() == 3) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SyncServiceConfig(TbadkCoreApplication.m255getInst())));
            } else if (pushNotifyMessage.getType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010001, pushNotifyMessage.getContent()));
            } else if (com.baidu.tieba.im.memorycache.c.QO().isInit()) {
                String valueOf = String.valueOf(pushNotifyMessage.getGroupId());
                TiebaStatic.imLog(202006, 0, "server push new", "PushNotifyManager-push_notify", "succ", 0, "", 0L, 0, "gid:" + valueOf);
                if (!TextUtils.isEmpty(valueOf)) {
                    if (pushNotifyMessage.getGroupType() == 0) {
                        com.baidu.tieba.im.b.b.Rt().a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime(), 0);
                        return;
                    }
                    int gn = com.baidu.tieba.im.b.a.gn(pushNotifyMessage.getGroupType());
                    if (com.baidu.tieba.im.memorycache.c.QO().H(String.valueOf(pushNotifyMessage.getGroupId()), gn) != null) {
                        com.baidu.tieba.im.b.b.Rt().a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime(), gn);
                    } else {
                        a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), gn);
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

    public String Si() {
        return this.blS;
    }

    public void hf(String str) {
        this.blS = str;
    }
}
