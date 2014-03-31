package com.baidu.tieba.im.model;

import com.baidu.tieba.im.chat.MsglistActivity;
/* loaded from: classes.dex */
public class GroupMsglistModel extends CommonGroupMsglistModel {
    private final int e;
    private com.baidu.adp.framework.c.a f;

    public GroupMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.e = 20;
        this.f = new n(this, 0);
        com.baidu.adp.framework.c.a().a(2013005, this.f);
        com.baidu.adp.framework.c.a().a(2001146, this.f);
        com.baidu.adp.framework.c.a().a(2001149, this.f);
    }

    @Override // com.baidu.tieba.im.model.CommonGroupMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public final void a() {
        super.a();
        com.baidu.adp.framework.c.a().b(this.f);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public final boolean d_() {
        if (this.a == null) {
            return false;
        }
        com.baidu.tieba.im.message.m mVar = new com.baidu.tieba.im.message.m();
        mVar.c = 20;
        mVar.a = null;
        mVar.b = null;
        mVar.d = new StringBuilder(String.valueOf(this.a.getGroupId())).toString();
        super.sendMessage(new com.baidu.tieba.im.message.k(mVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public final boolean d() {
        long j;
        long j2 = 0;
        if (this.a != null) {
            com.baidu.tieba.im.message.m mVar = new com.baidu.tieba.im.message.m();
            mVar.c = 20;
            if (this.b == null || this.b.getChatMessages() == null || this.b.getChatMessages().size() <= 0 || this.b.getChatMessages().get(0) == null) {
                j = 0;
            } else {
                j = this.b.getChatMessages().get(0).w();
                j2 = this.b.getChatMessages().get(0).u();
            }
            mVar.a = String.valueOf(j);
            mVar.b = String.valueOf(j2);
            mVar.d = new StringBuilder(String.valueOf(this.a.getGroupId())).toString();
            super.sendMessage(new com.baidu.tieba.im.message.k(mVar));
        }
        return false;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public final boolean e() {
        if (this.a == null) {
            return false;
        }
        com.baidu.tieba.im.message.h hVar = new com.baidu.tieba.im.message.h();
        hVar.a = new StringBuilder(String.valueOf(this.a.getGroupId())).toString();
        super.sendMessage(new com.baidu.tieba.im.message.j(hVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public final boolean a(String str) {
        com.baidu.tieba.im.message.bn bnVar = new com.baidu.tieba.im.message.bn();
        if (this.a == null || this.a.getGroupId() == 0) {
            return false;
        }
        bnVar.b = String.valueOf(this.a.getGroupId());
        bnVar.a = str;
        super.sendMessage(new com.baidu.tieba.im.message.c(bnVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected final com.baidu.tieba.im.message.a.a f() {
        com.baidu.tieba.im.message.a.c cVar = new com.baidu.tieba.im.message.a.c();
        cVar.b(System.currentTimeMillis());
        if (b() == null) {
            return null;
        }
        cVar.a(String.valueOf(b().getGroupId()));
        return cVar;
    }
}
