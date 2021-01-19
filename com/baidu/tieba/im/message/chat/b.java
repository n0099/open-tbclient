package com.baidu.tieba.im.message.chat;

import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.a {
    private long createTime;
    private boolean kBk;
    private a.C0758a kBl;
    private com.baidu.tieba.im.db.pojo.a kBm;
    private int kBn;

    public static b a(ChatMessage chatMessage, a.C0758a c0758a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c0758a.kBh /= 100;
        bVar.CL(chatMessage.getReadCountPv());
        bVar.a(c0758a);
        bVar.setCreateTime(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof com.baidu.tieba.im.db.pojo.a) {
            bVar.a((com.baidu.tieba.im.db.pojo.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public boolean cUV() {
        return this.kBk;
    }

    public void sM(boolean z) {
        this.kBk = z;
    }

    public a.C0758a cUW() {
        return this.kBl;
    }

    public void a(a.C0758a c0758a) {
        this.kBl = c0758a;
    }

    public com.baidu.tieba.im.db.pojo.a cUX() {
        return this.kBm;
    }

    public void a(com.baidu.tieba.im.db.pojo.a aVar) {
        this.kBm = aVar;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int cUY() {
        return this.kBn;
    }

    public void CL(int i) {
        this.kBn = i;
    }
}
