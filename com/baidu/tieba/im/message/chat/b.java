package com.baidu.tieba.im.message.chat;

import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.mvc.b.a {
    private long createTime;
    private boolean jEZ;
    private a.C0716a jFa;
    private com.baidu.tieba.im.db.pojo.a jFb;
    private int jFc;

    public static b a(ChatMessage chatMessage, a.C0716a c0716a) {
        b bVar = new b();
        if (chatMessage == null) {
            return bVar;
        }
        c0716a.jEW /= 100;
        bVar.Ca(chatMessage.getReadCountPv());
        bVar.a(c0716a);
        bVar.setCreateTime(chatMessage.getTime());
        if (chatMessage.getObjContent() instanceof com.baidu.tieba.im.db.pojo.a) {
            bVar.a((com.baidu.tieba.im.db.pojo.a) chatMessage.getObjContent());
        }
        return bVar;
    }

    public boolean cKQ() {
        return this.jEZ;
    }

    public void re(boolean z) {
        this.jEZ = z;
    }

    public a.C0716a cKR() {
        return this.jFa;
    }

    public void a(a.C0716a c0716a) {
        this.jFa = c0716a;
    }

    public com.baidu.tieba.im.db.pojo.a cKS() {
        return this.jFb;
    }

    public void a(com.baidu.tieba.im.db.pojo.a aVar) {
        this.jFb = aVar;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int cKT() {
        return this.jFc;
    }

    public void Ca(int i) {
        this.jFc = i;
    }
}
