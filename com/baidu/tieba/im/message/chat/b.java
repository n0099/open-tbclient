package com.baidu.tieba.im.message.chat;

import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.a {
    private long createTime;
    private boolean kmt;
    private a.C0764a kmu;
    private com.baidu.tieba.im.db.pojo.a kmv;
    private int kmw;

    public static b a(ChatMessage chatMessage, a.C0764a c0764a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c0764a.kmq /= 100;
        bVar.Dm(chatMessage.getReadCountPv());
        bVar.a(c0764a);
        bVar.setCreateTime(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof com.baidu.tieba.im.db.pojo.a) {
            bVar.a((com.baidu.tieba.im.db.pojo.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public boolean cUh() {
        return this.kmt;
    }

    public void sl(boolean z) {
        this.kmt = z;
    }

    public a.C0764a cUi() {
        return this.kmu;
    }

    public void a(a.C0764a c0764a) {
        this.kmu = c0764a;
    }

    public com.baidu.tieba.im.db.pojo.a cUj() {
        return this.kmv;
    }

    public void a(com.baidu.tieba.im.db.pojo.a aVar) {
        this.kmv = aVar;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int cUk() {
        return this.kmw;
    }

    public void Dm(int i) {
        this.kmw = i;
    }
}
