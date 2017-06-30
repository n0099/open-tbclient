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
    final /* synthetic */ a dnl;
    private final /* synthetic */ long dnm;
    private final /* synthetic */ long dnn;
    private final /* synthetic */ int dno;
    private final /* synthetic */ long dnp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, long j, long j2, int i, long j3) {
        this.dnl = aVar;
        this.dnm = j;
        this.dnn = j2;
        this.dno = i;
        this.dnp = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        long j;
        ConcurrentHashMap concurrentHashMap2;
        Vector vector;
        concurrentHashMap = this.dnl.dnh;
        GroupMsgData groupMsgData = (GroupMsgData) concurrentHashMap.get(Long.valueOf(this.dnm));
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
            this.dnl.bK(this.dnm);
            if (j > this.dnn) {
                concurrentHashMap2 = this.dnl.dni;
                concurrentHashMap2.put(Long.valueOf(this.dnm), MessageUtils.makeNewpushGroupRepair(this.dnm, this.dno, this.dnn, j, this.dnp));
                com.baidu.tieba.im.b.b.avk().a(this.dnm, 1L, 0L, true);
                vector = this.dnl.dnk;
                vector.add(Long.valueOf(this.dnm));
                this.dnl.bI(this.dnm);
                return;
            }
            return;
        }
        this.dnl.bK(this.dnm);
    }
}
