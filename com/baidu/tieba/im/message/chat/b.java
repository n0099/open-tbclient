package com.baidu.tieba.im.message.chat;

import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes2.dex */
public class b implements com.baidu.tbadk.mvc.b.a {
    private long createTime;
    private boolean jwr;
    private a.C0719a jws;
    private com.baidu.tieba.im.db.pojo.a jwt;
    private int jwu;

    public static b a(ChatMessage chatMessage, a.C0719a c0719a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c0719a.jwo /= 100;
        bVar.Bz(chatMessage.getReadCountPv());
        bVar.a(c0719a);
        bVar.setCreateTime(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof com.baidu.tieba.im.db.pojo.a) {
            bVar.a((com.baidu.tieba.im.db.pojo.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public boolean cHj() {
        return this.jwr;
    }

    public void qU(boolean z) {
        this.jwr = z;
    }

    public a.C0719a cHk() {
        return this.jws;
    }

    public void a(a.C0719a c0719a) {
        this.jws = c0719a;
    }

    public com.baidu.tieba.im.db.pojo.a cHl() {
        return this.jwt;
    }

    public void a(com.baidu.tieba.im.db.pojo.a aVar) {
        this.jwt = aVar;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int cHm() {
        return this.jwu;
    }

    public void Bz(int i) {
        this.jwu = i;
    }
}
