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
    final /* synthetic */ a dqG;
    private final /* synthetic */ long dqH;
    private final /* synthetic */ long dqI;
    private final /* synthetic */ int dqJ;
    private final /* synthetic */ long dqK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, long j, long j2, int i, long j3) {
        this.dqG = aVar;
        this.dqH = j;
        this.dqI = j2;
        this.dqJ = i;
        this.dqK = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        long j;
        ConcurrentHashMap concurrentHashMap2;
        Vector vector;
        concurrentHashMap = this.dqG.dqC;
        GroupMsgData groupMsgData = (GroupMsgData) concurrentHashMap.get(Long.valueOf(this.dqH));
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
            this.dqG.bY(this.dqH);
            if (j > this.dqI) {
                concurrentHashMap2 = this.dqG.dqD;
                concurrentHashMap2.put(Long.valueOf(this.dqH), MessageUtils.makeNewpushGroupRepair(this.dqH, this.dqJ, this.dqI, j, this.dqK));
                com.baidu.tieba.im.b.b.axL().a(this.dqH, 1L, 0L, true);
                vector = this.dqG.dqF;
                vector.add(Long.valueOf(this.dqH));
                this.dqG.bW(this.dqH);
                return;
            }
            return;
        }
        this.dqG.bY(this.dqH);
    }
}
