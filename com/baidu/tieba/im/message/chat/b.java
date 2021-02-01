package com.baidu.tieba.im.message.chat;

import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.a {
    private long createTime;
    private boolean kJp;
    private a.C0760a kJq;
    private com.baidu.tieba.im.db.pojo.a kJr;
    private int kJs;

    public static b a(ChatMessage chatMessage, a.C0760a c0760a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c0760a.kJm /= 100;
        bVar.Dd(chatMessage.getReadCountPv());
        bVar.a(c0760a);
        bVar.setCreateTime(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof com.baidu.tieba.im.db.pojo.a) {
            bVar.a((com.baidu.tieba.im.db.pojo.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public boolean cWT() {
        return this.kJp;
    }

    public void sZ(boolean z) {
        this.kJp = z;
    }

    public a.C0760a cWU() {
        return this.kJq;
    }

    public void a(a.C0760a c0760a) {
        this.kJq = c0760a;
    }

    public com.baidu.tieba.im.db.pojo.a cWV() {
        return this.kJr;
    }

    public void a(com.baidu.tieba.im.db.pojo.a aVar) {
        this.kJr = aVar;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int cWW() {
        return this.kJs;
    }

    public void Dd(int i) {
        this.kJs = i;
    }
}
