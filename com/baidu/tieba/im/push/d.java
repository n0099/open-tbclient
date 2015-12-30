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
    final /* synthetic */ a bZI;
    private final /* synthetic */ long bZJ;
    private final /* synthetic */ long bZK;
    private final /* synthetic */ int bZL;
    private final /* synthetic */ long bZM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, long j, long j2, int i, long j3) {
        this.bZI = aVar;
        this.bZJ = j;
        this.bZK = j2;
        this.bZL = i;
        this.bZM = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        long j;
        ConcurrentHashMap concurrentHashMap2;
        Vector vector;
        concurrentHashMap = this.bZI.bZE;
        GroupMsgData groupMsgData = (GroupMsgData) concurrentHashMap.get(Long.valueOf(this.bZJ));
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
            BdLog.e("sid " + j + ", lastSid " + this.bZK + ", groupId " + this.bZJ + ", userType " + this.bZL);
            this.bZI.aZ(this.bZJ);
            if (j > this.bZK) {
                concurrentHashMap2 = this.bZI.bZF;
                concurrentHashMap2.put(Long.valueOf(this.bZJ), MessageUtils.makeNewpushGroupRepair(this.bZJ, this.bZL, this.bZK, j, this.bZM));
                com.baidu.tieba.im.b.b.aba().a(this.bZJ, 1L, 0L, true);
                vector = this.bZI.bZH;
                vector.add(Long.valueOf(this.bZJ));
                this.bZI.aX(this.bZJ);
                return;
            }
            return;
        }
        this.bZI.aZ(this.bZJ);
    }
}
