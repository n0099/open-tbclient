package com.baidu.tieba.im.model;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.gson.Gson;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.snapGroup.SnapGroupChatActivity;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class OfficialBarMsglistModel extends CommonPersonalMsglistModel {
    private final int e;
    private boolean f;
    private com.baidu.adp.framework.c.a g;

    public OfficialBarMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.e = 10;
        this.f = false;
        this.g = new az(this, 0);
        com.baidu.adp.framework.c.a().a(2013003, this.g);
        com.baidu.adp.framework.c.a().a(2001148, this.g);
        com.baidu.adp.framework.c.a().a(2001151, this.g);
        com.baidu.adp.framework.c.a().a(2001155, this.g);
    }

    @Override // com.baidu.tieba.im.model.CommonPersonalMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public final void a() {
        super.a();
        com.baidu.adp.framework.c.a().b(this.g);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected final com.baidu.tieba.im.message.a.a f() {
        if (this.a == null) {
            return null;
        }
        com.baidu.tieba.im.message.a.e eVar = new com.baidu.tieba.im.message.a.e();
        eVar.b(System.currentTimeMillis());
        eVar.c(this.a.getUserIdLong());
        UserData userData = new UserData();
        userData.setUserId(String.valueOf(this.a.getUserId()));
        userData.setUserName(this.a.getUserName());
        userData.setPortrait(this.a.getPortrait());
        userData.setUserType(1);
        eVar.b(userData);
        return eVar;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public final boolean f_() {
        if (this.a == null) {
            return false;
        }
        com.baidu.tieba.im.message.m mVar = new com.baidu.tieba.im.message.m();
        mVar.c = 10;
        mVar.a = null;
        mVar.b = null;
        mVar.d = new StringBuilder(String.valueOf(this.a.getUserIdLong())).toString();
        super.sendMessage(new com.baidu.tieba.im.message.p(mVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public final boolean d() {
        long j;
        long j2 = 0;
        if (this.a == null) {
            return false;
        }
        com.baidu.tieba.im.message.m mVar = new com.baidu.tieba.im.message.m();
        mVar.c = 10;
        if (this.b == null || this.b.getChatMessages() == null || this.b.getChatMessages().size() <= 0 || this.b.getChatMessages().get(0) == null) {
            j = 0;
        } else {
            j = this.b.getChatMessages().get(0).w();
            j2 = this.b.getChatMessages().get(0).u();
        }
        mVar.a = String.valueOf(j);
        mVar.b = String.valueOf(j2);
        mVar.d = new StringBuilder(String.valueOf(this.a.getUserIdLong())).toString();
        super.sendMessage(new com.baidu.tieba.im.message.p(mVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public final boolean e() {
        if (this.a == null) {
            return false;
        }
        com.baidu.tieba.im.message.h hVar = new com.baidu.tieba.im.message.h();
        hVar.a = this.a.getUserId();
        super.sendMessage(new com.baidu.tieba.im.message.o(hVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public final boolean a(String str) {
        com.baidu.tieba.im.message.bm bmVar = new com.baidu.tieba.im.message.bm();
        if (this.a == null) {
            return false;
        }
        bmVar.b = String.valueOf(String.valueOf(this.a.getUserId()));
        bmVar.a = str;
        super.sendMessage(new com.baidu.tieba.im.message.t(bmVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected final ImMessageCenterPojo a(com.baidu.tieba.im.db.e eVar) {
        return null;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public final void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.db.i.a();
        com.baidu.tieba.im.db.i.c(SnapGroupChatActivity.b);
        aVar.a(null);
        com.baidu.tieba.im.r.a(new ba(this), aVar);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected final void a(com.baidu.tieba.im.message.a.a aVar) {
        if (this.a != null && aVar != null) {
            com.baidu.tieba.im.r.a(new bb(this, aVar), null);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected final void b(com.baidu.tieba.im.message.a.a aVar) {
        if (this.a != null && aVar != null) {
            com.baidu.tieba.im.r.a(new bc(this, aVar), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(OfficialBarMsglistModel officialBarMsglistModel, CustomResponsedMessage customResponsedMessage) {
        com.baidu.tieba.im.message.a.a a;
        if (customResponsedMessage == null || !(customResponsedMessage instanceof LoadHistoryResponsedMessage)) {
            return;
        }
        LoadHistoryResponsedMessage loadHistoryResponsedMessage = (LoadHistoryResponsedMessage) customResponsedMessage;
        if (loadHistoryResponsedMessage.a() != null) {
            List list = loadHistoryResponsedMessage.a().b;
            if (list == null) {
                list = new LinkedList();
            }
            if (list.size() < 10 && !officialBarMsglistModel.f) {
                if (officialBarMsglistModel.a == null) {
                    a = null;
                } else {
                    String format = String.format(officialBarMsglistModel.c.getString(com.baidu.tieba.im.j.official_fake_message), officialBarMsglistModel.a.getUserName());
                    HashMap hashMap = new HashMap();
                    hashMap.put("eventId", "-10001");
                    hashMap.put("userMsg", format);
                    a = officialBarMsglistModel.a((short) 11, new Gson().toJson(hashMap));
                }
                a.e(-1L);
                a.f(-1L);
                list.add(0, a);
                officialBarMsglistModel.f = true;
            }
            officialBarMsglistModel.a(loadHistoryResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(OfficialBarMsglistModel officialBarMsglistModel, CustomResponsedMessage customResponsedMessage) {
        if (customResponsedMessage instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
            if (officialBarMsglistModel.c() != null) {
                LinkedList<com.baidu.tieba.im.message.a.a> c = groupMsgData.c();
                LinkedList linkedList = new LinkedList();
                for (com.baidu.tieba.im.message.a.a aVar : c) {
                    if (aVar instanceof com.baidu.tieba.im.message.a.e) {
                        if (aVar.l() == officialBarMsglistModel.c().getUserIdLong()) {
                            linkedList.add(aVar);
                        } else if (aVar.x() == officialBarMsglistModel.c().getUserIdLong()) {
                            linkedList.add(aVar);
                        }
                    }
                }
                officialBarMsglistModel.a(linkedList);
            }
        }
    }
}
