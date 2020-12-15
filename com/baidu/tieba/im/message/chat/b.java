package com.baidu.tieba.im.message.chat;

import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.a {
    private long createTime;
    private boolean kAB;
    private a.C0782a kAC;
    private com.baidu.tieba.im.db.pojo.a kAD;
    private int kAE;

    public static b a(ChatMessage chatMessage, a.C0782a c0782a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c0782a.kAy /= 100;
        bVar.Ez(chatMessage.getReadCountPv());
        bVar.a(c0782a);
        bVar.setCreateTime(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof com.baidu.tieba.im.db.pojo.a) {
            bVar.a((com.baidu.tieba.im.db.pojo.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public boolean cZa() {
        return this.kAB;
    }

    public void sQ(boolean z) {
        this.kAB = z;
    }

    public a.C0782a cZb() {
        return this.kAC;
    }

    public void a(a.C0782a c0782a) {
        this.kAC = c0782a;
    }

    public com.baidu.tieba.im.db.pojo.a cZc() {
        return this.kAD;
    }

    public void a(com.baidu.tieba.im.db.pojo.a aVar) {
        this.kAD = aVar;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int cZd() {
        return this.kAE;
    }

    public void Ez(int i) {
        this.kAE = i;
    }
}
