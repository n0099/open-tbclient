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
    final /* synthetic */ a dfq;
    private final /* synthetic */ long dfr;
    private final /* synthetic */ long dfs;
    private final /* synthetic */ int dft;
    private final /* synthetic */ long dfu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, long j, long j2, int i, long j3) {
        this.dfq = aVar;
        this.dfr = j;
        this.dfs = j2;
        this.dft = i;
        this.dfu = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        long j;
        ConcurrentHashMap concurrentHashMap2;
        Vector vector;
        concurrentHashMap = this.dfq.dfm;
        GroupMsgData groupMsgData = (GroupMsgData) concurrentHashMap.get(Long.valueOf(this.dfr));
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
            this.dfq.bw(this.dfr);
            if (j > this.dfs) {
                concurrentHashMap2 = this.dfq.dfn;
                concurrentHashMap2.put(Long.valueOf(this.dfr), MessageUtils.makeNewpushGroupRepair(this.dfr, this.dft, this.dfs, j, this.dfu));
                com.baidu.tieba.im.b.b.arz().a(this.dfr, 1L, 0L, true);
                vector = this.dfq.dfp;
                vector.add(Long.valueOf(this.dfr));
                this.dfq.bu(this.dfr);
                return;
            }
            return;
        }
        this.dfq.bw(this.dfr);
    }
}
