package com.baidu.tieba.im.push;

import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.MessageUtils;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ a coI;
    private final /* synthetic */ long coJ;
    private final /* synthetic */ long coK;
    private final /* synthetic */ int coL;
    private final /* synthetic */ long coM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, long j, long j2, int i, long j3) {
        this.coI = aVar;
        this.coJ = j;
        this.coK = j2;
        this.coL = i;
        this.coM = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        long j;
        ConcurrentHashMap concurrentHashMap2;
        Vector vector;
        concurrentHashMap = this.coI.coE;
        GroupMsgData groupMsgData = (GroupMsgData) concurrentHashMap.get(Long.valueOf(this.coJ));
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
            this.coI.bg(this.coJ);
            if (j > this.coK) {
                concurrentHashMap2 = this.coI.coF;
                concurrentHashMap2.put(Long.valueOf(this.coJ), MessageUtils.makeNewpushGroupRepair(this.coJ, this.coL, this.coK, j, this.coM));
                com.baidu.tieba.im.b.b.aht().a(this.coJ, 1L, 0L, true);
                vector = this.coI.coH;
                vector.add(Long.valueOf(this.coJ));
                this.coI.be(this.coJ);
                return;
            }
            return;
        }
        this.coI.bg(this.coJ);
    }
}
