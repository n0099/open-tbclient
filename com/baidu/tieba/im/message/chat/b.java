package com.baidu.tieba.im.message.chat;

import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.a {
    private long createTime;
    private boolean jhp;
    private a.C0667a jhq;
    private com.baidu.tieba.im.db.pojo.a jhr;
    private int jhs;

    public static b a(ChatMessage chatMessage, a.C0667a c0667a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c0667a.jhm /= 100;
        bVar.zg(chatMessage.getReadCountPv());
        bVar.a(c0667a);
        bVar.setCreateTime(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof com.baidu.tieba.im.db.pojo.a) {
            bVar.a((com.baidu.tieba.im.db.pojo.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public boolean cws() {
        return this.jhp;
    }

    public void qo(boolean z) {
        this.jhp = z;
    }

    public a.C0667a cwt() {
        return this.jhq;
    }

    public void a(a.C0667a c0667a) {
        this.jhq = c0667a;
    }

    public com.baidu.tieba.im.db.pojo.a cwu() {
        return this.jhr;
    }

    public void a(com.baidu.tieba.im.db.pojo.a aVar) {
        this.jhr = aVar;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int cwv() {
        return this.jhs;
    }

    public void zg(int i) {
        this.jhs = i;
    }
}
