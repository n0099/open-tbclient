package com.baidu.tieba.im.message.chat;

import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.a {
    private long createTime;
    private boolean jTW;
    private a.C0734a jTX;
    private com.baidu.tieba.im.db.pojo.a jTY;
    private int jTZ;

    public static b a(ChatMessage chatMessage, a.C0734a c0734a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c0734a.jTT /= 100;
        bVar.CG(chatMessage.getReadCountPv());
        bVar.a(c0734a);
        bVar.setCreateTime(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof com.baidu.tieba.im.db.pojo.a) {
            bVar.a((com.baidu.tieba.im.db.pojo.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public boolean cOz() {
        return this.jTW;
    }

    public void rK(boolean z) {
        this.jTW = z;
    }

    public a.C0734a cOA() {
        return this.jTX;
    }

    public void a(a.C0734a c0734a) {
        this.jTX = c0734a;
    }

    public com.baidu.tieba.im.db.pojo.a cOB() {
        return this.jTY;
    }

    public void a(com.baidu.tieba.im.db.pojo.a aVar) {
        this.jTY = aVar;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int cOC() {
        return this.jTZ;
    }

    public void CG(int i) {
        this.jTZ = i;
    }
}
