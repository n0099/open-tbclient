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
    final /* synthetic */ a cZR;
    private final /* synthetic */ long cZS;
    private final /* synthetic */ long cZT;
    private final /* synthetic */ int cZU;
    private final /* synthetic */ long cZV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, long j, long j2, int i, long j3) {
        this.cZR = aVar;
        this.cZS = j;
        this.cZT = j2;
        this.cZU = i;
        this.cZV = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        long j;
        ConcurrentHashMap concurrentHashMap2;
        Vector vector;
        concurrentHashMap = this.cZR.cZN;
        GroupMsgData groupMsgData = (GroupMsgData) concurrentHashMap.get(Long.valueOf(this.cZS));
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
            this.cZR.bt(this.cZS);
            if (j > this.cZT) {
                concurrentHashMap2 = this.cZR.cZO;
                concurrentHashMap2.put(Long.valueOf(this.cZS), MessageUtils.makeNewpushGroupRepair(this.cZS, this.cZU, this.cZT, j, this.cZV));
                com.baidu.tieba.im.b.b.aqz().a(this.cZS, 1L, 0L, true);
                vector = this.cZR.cZQ;
                vector.add(Long.valueOf(this.cZS));
                this.cZR.br(this.cZS);
                return;
            }
            return;
        }
        this.cZR.bt(this.cZS);
    }
}
