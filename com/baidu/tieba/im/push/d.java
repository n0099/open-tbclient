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
    final /* synthetic */ a dkW;
    private final /* synthetic */ long dkX;
    private final /* synthetic */ long dkY;
    private final /* synthetic */ int dkZ;
    private final /* synthetic */ long dla;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, long j, long j2, int i, long j3) {
        this.dkW = aVar;
        this.dkX = j;
        this.dkY = j2;
        this.dkZ = i;
        this.dla = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        long j;
        ConcurrentHashMap concurrentHashMap2;
        Vector vector;
        concurrentHashMap = this.dkW.dkS;
        GroupMsgData groupMsgData = (GroupMsgData) concurrentHashMap.get(Long.valueOf(this.dkX));
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
            this.dkW.bZ(this.dkX);
            if (j > this.dkY) {
                concurrentHashMap2 = this.dkW.dkT;
                concurrentHashMap2.put(Long.valueOf(this.dkX), MessageUtils.makeNewpushGroupRepair(this.dkX, this.dkZ, this.dkY, j, this.dla));
                com.baidu.tieba.im.b.b.avO().a(this.dkX, 1L, 0L, true);
                vector = this.dkW.dkV;
                vector.add(Long.valueOf(this.dkX));
                this.dkW.bX(this.dkX);
                return;
            }
            return;
        }
        this.dkW.bZ(this.dkX);
    }
}
