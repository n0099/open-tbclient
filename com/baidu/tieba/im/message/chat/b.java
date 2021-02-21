package com.baidu.tieba.im.message.chat;

import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.a {
    private long createTime;
    private boolean kJD;
    private a.C0761a kJE;
    private com.baidu.tieba.im.db.pojo.a kJF;
    private int kJG;

    public static b a(ChatMessage chatMessage, a.C0761a c0761a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c0761a.kJA /= 100;
        bVar.Dd(chatMessage.getReadCountPv());
        bVar.a(c0761a);
        bVar.setCreateTime(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof com.baidu.tieba.im.db.pojo.a) {
            bVar.a((com.baidu.tieba.im.db.pojo.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public boolean cXa() {
        return this.kJD;
    }

    public void sZ(boolean z) {
        this.kJD = z;
    }

    public a.C0761a cXb() {
        return this.kJE;
    }

    public void a(a.C0761a c0761a) {
        this.kJE = c0761a;
    }

    public com.baidu.tieba.im.db.pojo.a cXc() {
        return this.kJF;
    }

    public void a(com.baidu.tieba.im.db.pojo.a aVar) {
        this.kJF = aVar;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int cXd() {
        return this.kJG;
    }

    public void Dd(int i) {
        this.kJG = i;
    }
}
