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
    final /* synthetic */ a cXQ;
    private final /* synthetic */ long cXR;
    private final /* synthetic */ long cXS;
    private final /* synthetic */ int cXT;
    private final /* synthetic */ long cXU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, long j, long j2, int i, long j3) {
        this.cXQ = aVar;
        this.cXR = j;
        this.cXS = j2;
        this.cXT = i;
        this.cXU = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        long j;
        ConcurrentHashMap concurrentHashMap2;
        Vector vector;
        concurrentHashMap = this.cXQ.cXM;
        GroupMsgData groupMsgData = (GroupMsgData) concurrentHashMap.get(Long.valueOf(this.cXR));
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
            this.cXQ.bD(this.cXR);
            if (j > this.cXS) {
                concurrentHashMap2 = this.cXQ.cXN;
                concurrentHashMap2.put(Long.valueOf(this.cXR), MessageUtils.makeNewpushGroupRepair(this.cXR, this.cXT, this.cXS, j, this.cXU));
                com.baidu.tieba.im.b.b.aqB().a(this.cXR, 1L, 0L, true);
                vector = this.cXQ.cXP;
                vector.add(Long.valueOf(this.cXR));
                this.cXQ.bB(this.cXR);
                return;
            }
            return;
        }
        this.cXQ.bD(this.cXR);
    }
}
