package com.baidu.tieba.im.message.chat;

import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.a {
    private long createTime;
    private boolean kLF;
    private a.C0767a kLG;
    private com.baidu.tieba.im.db.pojo.a kLH;
    private int kLI;

    public static b a(ChatMessage chatMessage, a.C0767a c0767a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c0767a.kLC /= 100;
        bVar.Dg(chatMessage.getReadCountPv());
        bVar.a(c0767a);
        bVar.setCreateTime(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof com.baidu.tieba.im.db.pojo.a) {
            bVar.a((com.baidu.tieba.im.db.pojo.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public boolean cXh() {
        return this.kLF;
    }

    public void sZ(boolean z) {
        this.kLF = z;
    }

    public a.C0767a cXi() {
        return this.kLG;
    }

    public void a(a.C0767a c0767a) {
        this.kLG = c0767a;
    }

    public com.baidu.tieba.im.db.pojo.a cXj() {
        return this.kLH;
    }

    public void a(com.baidu.tieba.im.db.pojo.a aVar) {
        this.kLH = aVar;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int cXk() {
        return this.kLI;
    }

    public void Dg(int i) {
        this.kLI = i;
    }
}
