package com.baidu.tieba.im.message.chat;

import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.a {
    private long createTime;
    private boolean kgw;
    private a.C0750a kgx;
    private com.baidu.tieba.im.db.pojo.a kgy;
    private int kgz;

    public static b a(ChatMessage chatMessage, a.C0750a c0750a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c0750a.kgt /= 100;
        bVar.CZ(chatMessage.getReadCountPv());
        bVar.a(c0750a);
        bVar.setCreateTime(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof com.baidu.tieba.im.db.pojo.a) {
            bVar.a((com.baidu.tieba.im.db.pojo.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public boolean cRG() {
        return this.kgw;
    }

    public void sc(boolean z) {
        this.kgw = z;
    }

    public a.C0750a cRH() {
        return this.kgx;
    }

    public void a(a.C0750a c0750a) {
        this.kgx = c0750a;
    }

    public com.baidu.tieba.im.db.pojo.a cRI() {
        return this.kgy;
    }

    public void a(com.baidu.tieba.im.db.pojo.a aVar) {
        this.kgy = aVar;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int cRJ() {
        return this.kgz;
    }

    public void CZ(int i) {
        this.kgz = i;
    }
}
