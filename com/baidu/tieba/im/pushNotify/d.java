package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SyncServiceConfig;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryNotifyUpdataGroupMessage;
import com.baidu.tieba.im.util.h;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {
    private static d boJ = null;
    private String boL;
    private ArrayList<CustomMessageListener> boK = new ArrayList<>();
    private com.baidu.adp.framework.listener.e mListener = new e(this, 202006);
    private CustomMessageListener boM = new f(this, 0);

    public static synchronized d Uy() {
        d dVar;
        synchronized (d.class) {
            if (boJ == null) {
                boJ = new d();
            }
            dVar = boJ;
        }
        return dVar;
    }

    public void open() {
        Uz();
    }

    private d() {
    }

    private void Uz() {
        MessageManager.getInstance().registerListener(this.mListener);
        MessageManager.getInstance().registerListener(2016014, this.boM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PushNotifyMessage pushNotifyMessage) {
        if (pushNotifyMessage != null) {
            if (pushNotifyMessage.getType() == 3) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SyncServiceConfig(TbadkCoreApplication.m411getInst())));
            } else if (pushNotifyMessage.getType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010001, pushNotifyMessage.getContent()));
            } else if (com.baidu.tieba.im.memorycache.c.TD().isInit()) {
                String valueOf = String.valueOf(pushNotifyMessage.getGroupId());
                com.baidu.tbadk.core.log.b.a("im", -1L, 202006, "notify", 0, null, "comment", "gid-" + valueOf + "-gType-" + pushNotifyMessage.getGroupType() + "-mid-" + pushNotifyMessage.getNewestMsgId());
                if (!TextUtils.isEmpty(valueOf)) {
                    BdLog.i("pushNotifyManager groupType = " + pushNotifyMessage.getGroupType() + " gid = " + valueOf + "msgid = " + pushNotifyMessage.getNewestMsgId());
                    if (pushNotifyMessage.getGroupType() == 0) {
                        com.baidu.tieba.im.b.b.Uf().a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime(), 0);
                        return;
                    }
                    int gv = com.baidu.tieba.im.b.a.gv(pushNotifyMessage.getGroupType());
                    if (TbadkCoreApplication.m411getInst().getCustomizedFilter() == null || TbadkCoreApplication.m411getInst().getCustomizedFilter().be(gv)) {
                        if (com.baidu.tieba.im.memorycache.c.TD().D(String.valueOf(pushNotifyMessage.getGroupId()), gv) != null) {
                            com.baidu.tieba.im.b.b.Uf().a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime(), gv);
                        } else {
                            a(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), gv);
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
            imMessageCenterPojo.setPulled_msgId(h.ag(j2 - 1));
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryNotifyUpdataGroupMessage(imMessageCenterPojo));
        }
    }

    public String UA() {
        return this.boL;
    }

    public void hs(String str) {
        this.boL = str;
    }
}
