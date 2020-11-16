package com.baidu.tieba.im.message.chat;

import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.a {
    private long createTime;
    private boolean knd;
    private a.C0766a kne;
    private com.baidu.tieba.im.db.pojo.a knf;
    private int kng;

    public static b a(ChatMessage chatMessage, a.C0766a c0766a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c0766a.kna /= 100;
        bVar.DK(chatMessage.getReadCountPv());
        bVar.a(c0766a);
        bVar.setCreateTime(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof com.baidu.tieba.im.db.pojo.a) {
            bVar.a((com.baidu.tieba.im.db.pojo.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public boolean cTN() {
        return this.knd;
    }

    public void so(boolean z) {
        this.knd = z;
    }

    public a.C0766a cTO() {
        return this.kne;
    }

    public void a(a.C0766a c0766a) {
        this.kne = c0766a;
    }

    public com.baidu.tieba.im.db.pojo.a cTP() {
        return this.knf;
    }

    public void a(com.baidu.tieba.im.db.pojo.a aVar) {
        this.knf = aVar;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int cTQ() {
        return this.kng;
    }

    public void DK(int i) {
        this.kng = i;
    }
}
