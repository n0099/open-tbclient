package com.baidu.tieba.im.message.chat;

import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.a {
    private long createTime;
    private boolean kFP;
    private a.C0775a kFQ;
    private com.baidu.tieba.im.db.pojo.a kFR;
    private int kFS;

    public static b a(ChatMessage chatMessage, a.C0775a c0775a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c0775a.kFM /= 100;
        bVar.Es(chatMessage.getReadCountPv());
        bVar.a(c0775a);
        bVar.setCreateTime(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof com.baidu.tieba.im.db.pojo.a) {
            bVar.a((com.baidu.tieba.im.db.pojo.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public boolean cYN() {
        return this.kFP;
    }

    public void sQ(boolean z) {
        this.kFP = z;
    }

    public a.C0775a cYO() {
        return this.kFQ;
    }

    public void a(a.C0775a c0775a) {
        this.kFQ = c0775a;
    }

    public com.baidu.tieba.im.db.pojo.a cYP() {
        return this.kFR;
    }

    public void a(com.baidu.tieba.im.db.pojo.a aVar) {
        this.kFR = aVar;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int cYQ() {
        return this.kFS;
    }

    public void Es(int i) {
        this.kFS = i;
    }
}
