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
    final /* synthetic */ a dcL;
    private final /* synthetic */ long dcM;
    private final /* synthetic */ long dcN;
    private final /* synthetic */ int dcO;
    private final /* synthetic */ long dcP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, long j, long j2, int i, long j3) {
        this.dcL = aVar;
        this.dcM = j;
        this.dcN = j2;
        this.dcO = i;
        this.dcP = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        long j;
        ConcurrentHashMap concurrentHashMap2;
        Vector vector;
        concurrentHashMap = this.dcL.dcH;
        GroupMsgData groupMsgData = (GroupMsgData) concurrentHashMap.get(Long.valueOf(this.dcM));
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
            this.dcL.bH(this.dcM);
            if (j > this.dcN) {
                concurrentHashMap2 = this.dcL.dcI;
                concurrentHashMap2.put(Long.valueOf(this.dcM), MessageUtils.makeNewpushGroupRepair(this.dcM, this.dcO, this.dcN, j, this.dcP));
                com.baidu.tieba.im.b.b.atq().a(this.dcM, 1L, 0L, true);
                vector = this.dcL.dcK;
                vector.add(Long.valueOf(this.dcM));
                this.dcL.bF(this.dcM);
                return;
            }
            return;
        }
        this.dcL.bH(this.dcM);
    }
}
