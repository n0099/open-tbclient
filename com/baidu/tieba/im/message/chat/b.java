package com.baidu.tieba.im.message.chat;

import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.a {
    private long createTime;
    private int jwA;
    private boolean jwx;
    private a.C0719a jwy;
    private com.baidu.tieba.im.db.pojo.a jwz;

    public static b a(ChatMessage chatMessage, a.C0719a c0719a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c0719a.jwu /= 100;
        bVar.Bz(chatMessage.getReadCountPv());
        bVar.a(c0719a);
        bVar.setCreateTime(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof com.baidu.tieba.im.db.pojo.a) {
            bVar.a((com.baidu.tieba.im.db.pojo.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public boolean cHk() {
        return this.jwx;
    }

    public void qW(boolean z) {
        this.jwx = z;
    }

    public a.C0719a cHl() {
        return this.jwy;
    }

    public void a(a.C0719a c0719a) {
        this.jwy = c0719a;
    }

    public com.baidu.tieba.im.db.pojo.a cHm() {
        return this.jwz;
    }

    public void a(com.baidu.tieba.im.db.pojo.a aVar) {
        this.jwz = aVar;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int cHn() {
        return this.jwA;
    }

    public void Bz(int i) {
        this.jwA = i;
    }
}
