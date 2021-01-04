package com.baidu.tieba.im.message.chat;

import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.a {
    private long createTime;
    private boolean kFP;
    private a.C0766a kFQ;
    private com.baidu.tieba.im.db.pojo.a kFR;
    private int kFS;

    public static b a(ChatMessage chatMessage, a.C0766a c0766a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c0766a.kFM /= 100;
        bVar.Es(chatMessage.getReadCountPv());
        bVar.a(c0766a);
        bVar.setCreateTime(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof com.baidu.tieba.im.db.pojo.a) {
            bVar.a((com.baidu.tieba.im.db.pojo.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public boolean cYM() {
        return this.kFP;
    }

    public void sQ(boolean z) {
        this.kFP = z;
    }

    public a.C0766a cYN() {
        return this.kFQ;
    }

    public void a(a.C0766a c0766a) {
        this.kFQ = c0766a;
    }

    public com.baidu.tieba.im.db.pojo.a cYO() {
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

    public int cYP() {
        return this.kFS;
    }

    public void Es(int i) {
        this.kFS = i;
    }
}
