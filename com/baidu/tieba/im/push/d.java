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
    private final /* synthetic */ long djA;
    private final /* synthetic */ long djB;
    private final /* synthetic */ int djC;
    private final /* synthetic */ long djD;
    final /* synthetic */ a djz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, long j, long j2, int i, long j3) {
        this.djz = aVar;
        this.djA = j;
        this.djB = j2;
        this.djC = i;
        this.djD = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        long j;
        ConcurrentHashMap concurrentHashMap2;
        Vector vector;
        concurrentHashMap = this.djz.djv;
        GroupMsgData groupMsgData = (GroupMsgData) concurrentHashMap.get(Long.valueOf(this.djA));
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
            this.djz.bZ(this.djA);
            if (j > this.djB) {
                concurrentHashMap2 = this.djz.djw;
                concurrentHashMap2.put(Long.valueOf(this.djA), MessageUtils.makeNewpushGroupRepair(this.djA, this.djC, this.djB, j, this.djD));
                com.baidu.tieba.im.b.b.avp().a(this.djA, 1L, 0L, true);
                vector = this.djz.djy;
                vector.add(Long.valueOf(this.djA));
                this.djz.bX(this.djA);
                return;
            }
            return;
        }
        this.djz.bZ(this.djA);
    }
}
