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
    final /* synthetic */ a dfe;
    private final /* synthetic */ long dff;
    private final /* synthetic */ long dfg;
    private final /* synthetic */ int dfh;
    private final /* synthetic */ long dfi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, long j, long j2, int i, long j3) {
        this.dfe = aVar;
        this.dff = j;
        this.dfg = j2;
        this.dfh = i;
        this.dfi = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        long j;
        ConcurrentHashMap concurrentHashMap2;
        Vector vector;
        concurrentHashMap = this.dfe.dfa;
        GroupMsgData groupMsgData = (GroupMsgData) concurrentHashMap.get(Long.valueOf(this.dff));
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
            this.dfe.bI(this.dff);
            if (j > this.dfg) {
                concurrentHashMap2 = this.dfe.dfb;
                concurrentHashMap2.put(Long.valueOf(this.dff), MessageUtils.makeNewpushGroupRepair(this.dff, this.dfh, this.dfg, j, this.dfi));
                com.baidu.tieba.im.b.b.asL().a(this.dff, 1L, 0L, true);
                vector = this.dfe.dfd;
                vector.add(Long.valueOf(this.dff));
                this.dfe.bG(this.dff);
                return;
            }
            return;
        }
        this.dfe.bI(this.dff);
    }
}
