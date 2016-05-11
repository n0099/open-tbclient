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
    final /* synthetic */ a cpF;
    private final /* synthetic */ long cpG;
    private final /* synthetic */ long cpH;
    private final /* synthetic */ int cpI;
    private final /* synthetic */ long cpJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, long j, long j2, int i, long j3) {
        this.cpF = aVar;
        this.cpG = j;
        this.cpH = j2;
        this.cpI = i;
        this.cpJ = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        long j;
        ConcurrentHashMap concurrentHashMap2;
        Vector vector;
        concurrentHashMap = this.cpF.cpB;
        GroupMsgData groupMsgData = (GroupMsgData) concurrentHashMap.get(Long.valueOf(this.cpG));
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
            this.cpF.bg(this.cpG);
            if (j > this.cpH) {
                concurrentHashMap2 = this.cpF.cpC;
                concurrentHashMap2.put(Long.valueOf(this.cpG), MessageUtils.makeNewpushGroupRepair(this.cpG, this.cpI, this.cpH, j, this.cpJ));
                com.baidu.tieba.im.b.b.ahA().a(this.cpG, 1L, 0L, true);
                vector = this.cpF.cpE;
                vector.add(Long.valueOf(this.cpG));
                this.cpF.be(this.cpG);
                return;
            }
            return;
        }
        this.cpF.bg(this.cpG);
    }
}
