package com.baidu.tieba.im.message.chat;

import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.a {
    private long createTime;
    private a.C0782a kAA;
    private com.baidu.tieba.im.db.pojo.a kAB;
    private int kAC;
    private boolean kAz;

    public static b a(ChatMessage chatMessage, a.C0782a c0782a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c0782a.kAw /= 100;
        bVar.Ez(chatMessage.getReadCountPv());
        bVar.a(c0782a);
        bVar.setCreateTime(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof com.baidu.tieba.im.db.pojo.a) {
            bVar.a((com.baidu.tieba.im.db.pojo.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public boolean cYZ() {
        return this.kAz;
    }

    public void sQ(boolean z) {
        this.kAz = z;
    }

    public a.C0782a cZa() {
        return this.kAA;
    }

    public void a(a.C0782a c0782a) {
        this.kAA = c0782a;
    }

    public com.baidu.tieba.im.db.pojo.a cZb() {
        return this.kAB;
    }

    public void a(com.baidu.tieba.im.db.pojo.a aVar) {
        this.kAB = aVar;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int cZc() {
        return this.kAC;
    }

    public void Ez(int i) {
        this.kAC = i;
    }
}
