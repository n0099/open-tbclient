package com.baidu.tieba.im.model;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.ba;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.im.message.bc;
import com.baidu.tieba.im.message.bd;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tieba.im.chat.af {
    final /* synthetic */ MsglistModel a;

    private ab(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ab(MsglistModel msglistModel, n nVar) {
        this(msglistModel);
    }

    @Override // com.baidu.tieba.im.chat.af
    public void a(com.baidu.tieba.im.message.o oVar) {
        bc bcVar;
        String d;
        String d2;
        ba baVar;
        int i;
        int i2;
        UserData userData;
        UserData userData2;
        long j;
        MsgPageData msgPageData;
        int a;
        MsgPageData msgPageData2;
        MsgPageData msgPageData3;
        MsgPageData msgPageData4;
        MsgPageData msgPageData5;
        com.baidu.adp.a.g gVar;
        MsgPageData msgPageData6;
        com.baidu.adp.a.g gVar2;
        MsgPageData msgPageData7;
        MsgPageData msgPageData8;
        GroupData groupData;
        GroupData groupData2;
        int i3;
        UserData userData3;
        UserData userData4;
        com.baidu.adp.a.g gVar3;
        GroupData groupData3;
        GroupData groupData4;
        int i4;
        MsgPageData msgPageData9;
        MsgPageData msgPageData10;
        int a2;
        MsgPageData msgPageData11;
        MsgPageData msgPageData12;
        MsgPageData msgPageData13;
        MsgPageData msgPageData14;
        com.baidu.adp.a.g gVar4;
        MsgPageData msgPageData15;
        GroupData groupData5;
        if (oVar != null) {
            if (oVar.u() == -100) {
                com.baidu.tieba.im.data.b bVar = (com.baidu.tieba.im.data.b) oVar;
                com.baidu.tieba.im.data.e eVar = null;
                i4 = this.a.e;
                if (i4 == 0) {
                    if (bVar.a() != null) {
                        int groupId = bVar.a().getGroupId();
                        groupData5 = this.a.f;
                        if (groupId == groupData5.getGroupId()) {
                            eVar = bVar.b();
                        }
                    }
                } else if (this.a.b() != null && bVar.a() != null && bVar.a().getGroupType() == 6) {
                    List<com.baidu.tieba.im.message.b> a3 = bVar.b().a();
                    LinkedList linkedList = new LinkedList();
                    for (com.baidu.tieba.im.message.b bVar2 : a3) {
                        if (bVar2 instanceof com.baidu.tieba.im.message.e) {
                            if (bVar2.b() == this.a.b().getUserId()) {
                                linkedList.add(bVar2);
                            } else if (bVar2.l() == this.a.b().getUserId()) {
                                linkedList.add(bVar2);
                            }
                        }
                    }
                    eVar = new com.baidu.tieba.im.data.e();
                    eVar.a(linkedList);
                }
                if (eVar != null) {
                    List<com.baidu.tieba.im.message.b> a4 = eVar.a();
                    this.a.b(a4);
                    MsglistModel msglistModel = this.a;
                    msgPageData9 = this.a.j;
                    msglistModel.b(msgPageData9.getChatMessages(), a4);
                    Collections.sort(a4, new aa(this.a, null));
                    MsglistModel msglistModel2 = this.a;
                    msgPageData10 = this.a.j;
                    a2 = msglistModel2.a(msgPageData10.getChatMessages(), a4);
                    if (a2 > 0) {
                        msgPageData13 = this.a.j;
                        msgPageData13.setIsNewAdd(true);
                        msgPageData14 = this.a.j;
                        msgPageData14.setNewAddNum(a2);
                        this.a.mLoadDataMode = 3;
                        gVar4 = this.a.mLoadDataCallBack;
                        msgPageData15 = this.a.j;
                        gVar4.a(msgPageData15);
                        return;
                    }
                    msgPageData11 = this.a.j;
                    msgPageData11.setIsNewAdd(false);
                    msgPageData12 = this.a.j;
                    msgPageData12.setNewAddNum(0);
                }
            } else if (oVar.u() == 202001 || oVar.u() == 205001) {
                if ((oVar instanceof bc) && (bcVar = (bc) oVar) != null) {
                    if (bcVar.l() == null || !(bcVar.l() instanceof com.baidu.tieba.im.message.b)) {
                        com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(bcVar.u(), 0, "chatResMessage.getOrginalMessage()==null", "return", null, 0, null));
                        return;
                    }
                    if ((bcVar instanceof bd) && bcVar.j() == 2230303) {
                        this.a.o();
                    }
                    com.baidu.tieba.im.message.b bVar3 = (com.baidu.tieba.im.message.b) bcVar.l();
                    if (bcVar.i()) {
                        long currentTimeMillis = System.currentTimeMillis() - bVar3.s();
                        long i5 = bVar3.i();
                        d2 = this.a.d(bVar3);
                        com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(bcVar.u(), 0, "", "", d2 + "rid" + i5, bcVar.j(), bcVar.k(), currentTimeMillis));
                        this.a.c(bVar3);
                        if (bcVar.j() > 0) {
                            baVar = this.a.p;
                            baVar.showToast(bcVar.k());
                            if (bVar3.i() != bcVar.b()) {
                                bcVar.b(bVar3.i());
                                com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(bcVar.u(), 0, "orginalRecordId != serverRecordId", "", null, bcVar.j(), bcVar.k()));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - bVar3.s();
                    long b = bcVar.b();
                    long a5 = bcVar.a();
                    d = this.a.d(bVar3);
                    com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(bcVar.u(), 0, "", "", "rid = " + b + "msgId = " + a5 + d, bcVar.j(), bcVar.k(), currentTimeMillis2));
                    if (bVar3.i() != bcVar.b()) {
                        bcVar.b(bVar3.i());
                        com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(bcVar.u(), 0, "orginalRecordId != serverRecordId", "", null, bcVar.j(), bcVar.k()));
                    }
                    this.a.a(bcVar);
                }
            } else if (oVar.u() == -103) {
                if (!(oVar instanceof com.baidu.tieba.im.message.l)) {
                    com.baidu.adp.lib.h.e.a("transform to LoadDraftResponsedMessage error");
                    return;
                }
                com.baidu.tieba.im.message.l lVar = (com.baidu.tieba.im.message.l) oVar;
                if (!lVar.i()) {
                    i3 = this.a.e;
                    if (i3 == 0) {
                        groupData3 = this.a.f;
                        if (groupData3 == null) {
                            com.baidu.adp.lib.h.e.a("group ==null");
                            return;
                        }
                        String b2 = lVar.b();
                        groupData4 = this.a.f;
                        if (!b2.equals(String.valueOf(groupData4.getGroupId()))) {
                            return;
                        }
                    } else {
                        userData3 = this.a.g;
                        if (userData3 == null) {
                            com.baidu.adp.lib.h.e.a("user == null");
                            return;
                        }
                        String b3 = lVar.b();
                        userData4 = this.a.g;
                        if (!b3.equals(String.valueOf(userData4.getUserId()))) {
                            return;
                        }
                    }
                    this.a.mLoadDataMode = 8;
                    gVar3 = this.a.mLoadDataCallBack;
                    gVar3.a(lVar.a());
                    return;
                }
                com.baidu.adp.lib.h.e.a("LoadDraftResponedMessage hasError");
            } else if (oVar.u() == -105) {
                if (!(oVar instanceof com.baidu.tieba.im.message.n)) {
                    com.baidu.adp.lib.h.e.a("transform to LoadHistoryResponsedMessage error");
                    return;
                }
                com.baidu.tieba.im.message.n nVar = (com.baidu.tieba.im.message.n) oVar;
                if (nVar.i()) {
                    com.baidu.adp.lib.h.e.a("LoadHistoryResponsedMessage hasError");
                    return;
                }
                LinkedList linkedList2 = (LinkedList) nVar.b();
                i = this.a.e;
                if (i != 0 || nVar.e() != 0) {
                    i2 = this.a.e;
                    if (i2 == 1 && nVar.e() == 1) {
                        userData = this.a.g;
                        if (userData == null || nVar == null) {
                            com.baidu.adp.lib.h.e.a("user ==null or LoadHistoryResponsedMessage == null");
                            return;
                        }
                        long d3 = nVar.d();
                        userData2 = this.a.g;
                        if (d3 == userData2.getUserId()) {
                            try {
                                j = Long.parseLong(TiebaApplication.A());
                            } catch (Exception e) {
                                e.printStackTrace();
                                j = 0;
                            }
                            Iterator it = linkedList2.iterator();
                            while (it.hasNext()) {
                                com.baidu.tieba.im.message.b bVar4 = (com.baidu.tieba.im.message.b) it.next();
                                if (bVar4.l() == 0) {
                                    bVar4.d(j);
                                } else if (bVar4.b() == 0) {
                                    bVar4.a(j);
                                }
                            }
                        } else {
                            return;
                        }
                    }
                } else {
                    groupData = this.a.f;
                    if (groupData == null || nVar == null) {
                        com.baidu.adp.lib.h.e.a("group ==null or LoadHistoryResponsedMessage == null");
                        return;
                    } else if (nVar.a() != null) {
                        String a6 = nVar.a();
                        groupData2 = this.a.f;
                        if (!a6.equals(String.valueOf(groupData2.getGroupId()))) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                msgPageData = this.a.j;
                a = this.a.a(msgPageData.getChatMessages(), linkedList2);
                if (a > 0) {
                    msgPageData7 = this.a.j;
                    msgPageData7.setIsNewAdd(true);
                    msgPageData8 = this.a.j;
                    msgPageData8.setNewAddNum(a);
                } else {
                    msgPageData2 = this.a.j;
                    msgPageData2.setIsNewAdd(false);
                    msgPageData3 = this.a.j;
                    msgPageData3.setNewAddNum(0);
                }
                MsglistModel msglistModel3 = this.a;
                msgPageData4 = this.a.j;
                msglistModel3.a(msgPageData4.getChatMessages());
                if (nVar.c()) {
                    msgPageData6 = this.a.j;
                    if (msgPageData6.getIsNewAdd()) {
                        this.a.mLoadDataMode = 1;
                        gVar2 = this.a.mLoadDataCallBack;
                        gVar2.a(null);
                        return;
                    }
                    return;
                }
                msgPageData5 = this.a.j;
                if (msgPageData5.getIsNewAdd()) {
                    this.a.mLoadDataMode = 2;
                    gVar = this.a.mLoadDataCallBack;
                    gVar.a(null);
                }
            }
        }
    }
}
