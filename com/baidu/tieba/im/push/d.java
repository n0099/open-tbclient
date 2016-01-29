package com.baidu.tieba.im.push;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.MessageUtils;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ a ced;
    private final /* synthetic */ long cee;
    private final /* synthetic */ long cef;
    private final /* synthetic */ int ceg;
    private final /* synthetic */ long ceh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, long j, long j2, int i, long j3) {
        this.ced = aVar;
        this.cee = j;
        this.cef = j2;
        this.ceg = i;
        this.ceh = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        long j;
        ConcurrentHashMap concurrentHashMap2;
        Vector vector;
        concurrentHashMap = this.ced.cdZ;
        GroupMsgData groupMsgData = (GroupMsgData) concurrentHashMap.get(Long.valueOf(this.cee));
        if (groupMsgData != null) {
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            if (listMessage == null || listMessage.size() <= 0) {
                j = -1;
            } else {
                int i = 0;
                long j2 = -1;
                while (true) {
                    int i2 = i;
                    if (i2 >= listMessage.size()) {
                        break;
                    }
                    if (j2 < listMessage.get(i2).getSid()) {
                        j2 = listMessage.get(i2).getSid();
                    }
                    i = i2 + 1;
                }
                listMessage.clear();
                j = j2;
            }
            BdLog.e("sid " + j + ", lastSid " + this.cef + ", groupId " + this.cee + ", userType " + this.ceg);
            this.ced.ba(this.cee);
            if (j > this.cef) {
                concurrentHashMap2 = this.ced.cea;
                concurrentHashMap2.put(Long.valueOf(this.cee), MessageUtils.makeNewpushGroupRepair(this.cee, this.ceg, this.cef, j, this.ceh));
                com.baidu.tieba.im.b.b.aea().a(this.cee, 1L, 0L, true);
                vector = this.ced.cec;
                vector.add(Long.valueOf(this.cee));
                this.ced.aY(this.cee);
                return;
            }
            return;
        }
        this.ced.ba(this.cee);
    }
}
