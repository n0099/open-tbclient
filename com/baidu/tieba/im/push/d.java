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
    final /* synthetic */ a cVA;
    private final /* synthetic */ long cVB;
    private final /* synthetic */ long cVC;
    private final /* synthetic */ int cVD;
    private final /* synthetic */ long cVE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, long j, long j2, int i, long j3) {
        this.cVA = aVar;
        this.cVB = j;
        this.cVC = j2;
        this.cVD = i;
        this.cVE = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        long j;
        ConcurrentHashMap concurrentHashMap2;
        Vector vector;
        concurrentHashMap = this.cVA.cVw;
        GroupMsgData groupMsgData = (GroupMsgData) concurrentHashMap.get(Long.valueOf(this.cVB));
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
            this.cVA.bM(this.cVB);
            if (j > this.cVC) {
                concurrentHashMap2 = this.cVA.cVx;
                concurrentHashMap2.put(Long.valueOf(this.cVB), MessageUtils.makeNewpushGroupRepair(this.cVB, this.cVD, this.cVC, j, this.cVE));
                com.baidu.tieba.im.b.b.ask().a(this.cVB, 1L, 0L, true);
                vector = this.cVA.cVz;
                vector.add(Long.valueOf(this.cVB));
                this.cVA.bK(this.cVB);
                return;
            }
            return;
        }
        this.cVA.bM(this.cVB);
    }
}
