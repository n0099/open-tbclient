package com.baidu.tieba.im.message.chat;

import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.a {
    private long createTime;
    private boolean jhr;
    private a.C0667a jhs;
    private com.baidu.tieba.im.db.pojo.a jht;
    private int jhu;

    public static b a(ChatMessage chatMessage, a.C0667a c0667a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c0667a.jho /= 100;
        bVar.zg(chatMessage.getReadCountPv());
        bVar.a(c0667a);
        bVar.setCreateTime(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof com.baidu.tieba.im.db.pojo.a) {
            bVar.a((com.baidu.tieba.im.db.pojo.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public boolean cws() {
        return this.jhr;
    }

    public void qo(boolean z) {
        this.jhr = z;
    }

    public a.C0667a cwt() {
        return this.jhs;
    }

    public void a(a.C0667a c0667a) {
        this.jhs = c0667a;
    }

    public com.baidu.tieba.im.db.pojo.a cwu() {
        return this.jht;
    }

    public void a(com.baidu.tieba.im.db.pojo.a aVar) {
        this.jht = aVar;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int cwv() {
        return this.jhu;
    }

    public void zg(int i) {
        this.jhu = i;
    }
}
