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
    final /* synthetic */ a dfS;
    private final /* synthetic */ long dfT;
    private final /* synthetic */ long dfU;
    private final /* synthetic */ int dfV;
    private final /* synthetic */ long dfW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, long j, long j2, int i, long j3) {
        this.dfS = aVar;
        this.dfT = j;
        this.dfU = j2;
        this.dfV = i;
        this.dfW = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        long j;
        ConcurrentHashMap concurrentHashMap2;
        Vector vector;
        concurrentHashMap = this.dfS.dfO;
        GroupMsgData groupMsgData = (GroupMsgData) concurrentHashMap.get(Long.valueOf(this.dfT));
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
            this.dfS.bI(this.dfT);
            if (j > this.dfU) {
                concurrentHashMap2 = this.dfS.dfP;
                concurrentHashMap2.put(Long.valueOf(this.dfT), MessageUtils.makeNewpushGroupRepair(this.dfT, this.dfV, this.dfU, j, this.dfW));
                com.baidu.tieba.im.b.b.atF().a(this.dfT, 1L, 0L, true);
                vector = this.dfS.dfR;
                vector.add(Long.valueOf(this.dfT));
                this.dfS.bG(this.dfT);
                return;
            }
            return;
        }
        this.dfS.bI(this.dfT);
    }
}
