package com.baidu.tieba.im.model;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class PersonalMsglistModel extends CommonPersonalMsglistModel {
    private final int e;
    private com.baidu.adp.framework.c.a f;

    public PersonalMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.e = 20;
        this.f = new bi(this, 0);
        com.baidu.adp.framework.c.a().a(2013001, this.f);
        com.baidu.adp.framework.c.a().a(2001147, this.f);
        com.baidu.adp.framework.c.a().a(2001150, this.f);
    }

    @Override // com.baidu.tieba.im.model.CommonPersonalMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public final void a() {
        super.a();
        com.baidu.adp.framework.c.a().b(this.f);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected final com.baidu.tieba.im.message.a.a f() {
        if (this.a == null) {
            return null;
        }
        com.baidu.tieba.im.message.a.f fVar = new com.baidu.tieba.im.message.a.f();
        fVar.b(System.currentTimeMillis());
        fVar.c(this.a.getUserIdLong());
        UserData userData = new UserData();
        userData.setUserId(String.valueOf(this.a.getUserId()));
        userData.setUserName(this.a.getUserName());
        userData.setPortrait(this.a.getPortrait());
        fVar.b(userData);
        return fVar;
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
        mVar.d = new StringBuilder(String.valueOf(this.a.getUserIdLong())).toString();
        super.sendMessage(new com.baidu.tieba.im.message.r(mVar));
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
            mVar.d = new StringBuilder(String.valueOf(this.a.getUserIdLong())).toString();
            super.sendMessage(new com.baidu.tieba.im.message.r(mVar));
        }
        return false;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public final boolean e() {
        if (this.a == null) {
            return false;
        }
        com.baidu.tieba.im.message.h hVar = new com.baidu.tieba.im.message.h();
        hVar.a = this.a.getUserId();
        super.sendMessage(new com.baidu.tieba.im.message.q(hVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public final boolean a(String str) {
        com.baidu.tieba.im.message.bn bnVar = new com.baidu.tieba.im.message.bn();
        if (this.a == null) {
            return false;
        }
        bnVar.b = String.valueOf(String.valueOf(this.a.getUserId()));
        bnVar.a = str;
        super.sendMessage(new com.baidu.tieba.im.message.u(bnVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected final void a(com.baidu.tieba.im.message.a.a aVar) {
        if (this.a != null && aVar != null) {
            com.baidu.tieba.im.s.a(new bj(this, aVar), null);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected final void b(com.baidu.tieba.im.message.a.a aVar) {
        if (this.a != null && aVar != null) {
            com.baidu.tieba.im.s.a(new bk(this, aVar), null);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected final ImMessageCenterPojo a(com.baidu.tieba.im.db.e eVar) {
        return null;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public final void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.db.h.a();
        com.baidu.tieba.im.db.h.c(PersonalChatActivity.b);
        aVar.a(null);
        com.baidu.tieba.im.s.a(new bl(this), aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
            if (c() != null) {
                LinkedList<com.baidu.tieba.im.message.a.a> c = groupMsgData.c();
                LinkedList linkedList = new LinkedList();
                for (com.baidu.tieba.im.message.a.a aVar : c) {
                    if (aVar instanceof com.baidu.tieba.im.message.a.f) {
                        if (aVar.l() == c().getUserIdLong()) {
                            linkedList.add(aVar);
                        } else if (aVar.x() == c().getUserIdLong()) {
                            linkedList.add(aVar);
                        }
                    }
                }
                a(linkedList);
            }
        }
    }
}
