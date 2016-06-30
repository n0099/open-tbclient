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
    final /* synthetic */ a cUV;
    private final /* synthetic */ long cUW;
    private final /* synthetic */ long cUX;
    private final /* synthetic */ int cUY;
    private final /* synthetic */ long cUZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, long j, long j2, int i, long j3) {
        this.cUV = aVar;
        this.cUW = j;
        this.cUX = j2;
        this.cUY = i;
        this.cUZ = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        long j;
        ConcurrentHashMap concurrentHashMap2;
        Vector vector;
        concurrentHashMap = this.cUV.cUR;
        GroupMsgData groupMsgData = (GroupMsgData) concurrentHashMap.get(Long.valueOf(this.cUW));
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
            this.cUV.bI(this.cUW);
            if (j > this.cUX) {
                concurrentHashMap2 = this.cUV.cUS;
                concurrentHashMap2.put(Long.valueOf(this.cUW), MessageUtils.makeNewpushGroupRepair(this.cUW, this.cUY, this.cUX, j, this.cUZ));
                com.baidu.tieba.im.b.b.apP().a(this.cUW, 1L, 0L, true);
                vector = this.cUV.cUU;
                vector.add(Long.valueOf(this.cUW));
                this.cUV.bG(this.cUW);
                return;
            }
            return;
        }
        this.cUV.bI(this.cUW);
    }
}
