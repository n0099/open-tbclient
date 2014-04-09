package com.baidu.tieba.im.model;

import com.baidu.tieba.im.chat.MsglistActivity;
/* loaded from: classes.dex */
public class SnapGroupMsglistModel extends CommonGroupMsglistModel {
    private com.baidu.adp.framework.c.a e;

    public SnapGroupMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.e = new br(this, 0);
        com.baidu.adp.framework.c.a().a(2013002, this.e);
    }

    @Override // com.baidu.tieba.im.model.CommonGroupMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public final void a() {
        super.a();
        com.baidu.adp.framework.c.a().b(this.e);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected final com.baidu.tieba.im.message.a.a f() {
        com.baidu.tieba.im.message.a.g gVar = new com.baidu.tieba.im.message.a.g();
        gVar.b(System.currentTimeMillis());
        if (b() == null) {
            return null;
        }
        gVar.a(String.valueOf(b().getGroupId()));
        return gVar;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public final boolean f_() {
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public final boolean d() {
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public final boolean e() {
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public final boolean a(String str) {
        return true;
    }
}
