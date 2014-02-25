package com.baidu.tieba.im.model;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.bc;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.br;
import com.baidu.tieba.im.message.bs;
import com.baidu.tieba.util.cb;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements bc {
    final /* synthetic */ MsglistModel a;

    private ah(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ah(MsglistModel msglistModel, ah ahVar) {
        this(msglistModel);
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.im.chat.bc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.baidu.tieba.im.message.s sVar) {
        br brVar;
        String d;
        String d2;
        MsglistActivity msglistActivity;
        boolean q;
        boolean r;
        int i;
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
        boolean q2;
        GroupData groupData3;
        GroupData groupData4;
        com.baidu.adp.a.g gVar3;
        boolean r2;
        UserData userData3;
        UserData userData4;
        boolean q3;
        GroupData groupData5;
        MsgPageData msgPageData9;
        MsgPageData msgPageData10;
        int a2;
        MsgPageData msgPageData11;
        MsgPageData msgPageData12;
        MsgPageData msgPageData13;
        MsgPageData msgPageData14;
        com.baidu.adp.a.g gVar4;
        MsgPageData msgPageData15;
        boolean r3;
        if (sVar != null) {
            if (sVar.w() == -100) {
                com.baidu.tieba.im.data.c cVar = (com.baidu.tieba.im.data.c) sVar;
                com.baidu.tieba.im.data.f fVar = null;
                q3 = this.a.q();
                if (!q3) {
                    r3 = this.a.r();
                    if (!r3) {
                        if (this.a.b() != null && cVar.a() != null && cVar.a().getGroupType() == 6) {
                            List<com.baidu.tieba.im.message.b> a3 = cVar.b().a();
                            LinkedList linkedList = new LinkedList();
                            for (com.baidu.tieba.im.message.b bVar : a3) {
                                if (bVar instanceof com.baidu.tieba.im.message.g) {
                                    if (bVar.c() == this.a.b().getUserIdLong()) {
                                        linkedList.add(bVar);
                                    } else if (bVar.m() == this.a.b().getUserIdLong()) {
                                        linkedList.add(bVar);
                                    }
                                }
                            }
                            fVar = new com.baidu.tieba.im.data.f();
                            fVar.a(linkedList);
                        }
                        if (fVar == null) {
                            List<com.baidu.tieba.im.message.b> a4 = fVar.a();
                            this.a.b(a4);
                            MsglistModel msglistModel = this.a;
                            msgPageData9 = this.a.j;
                            msglistModel.b(msgPageData9.getChatMessages(), a4);
                            Collections.sort(a4, new ag(this.a, null));
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
                            return;
                        }
                        return;
                    }
                }
                if (cVar.a() != null) {
                    int groupId = cVar.a().getGroupId();
                    groupData5 = this.a.f;
                    if (groupId == groupData5.getGroupId()) {
                        fVar = cVar.b();
                    }
                }
                if (fVar == null) {
                }
            } else if (sVar.w() == 202001 || sVar.w() == 205001) {
                if ((sVar instanceof br) && (brVar = (br) sVar) != null) {
                    if (brVar.o() == null || !(brVar.o() instanceof com.baidu.tieba.im.message.b)) {
                        cb.a(brVar.w(), 0, "chatResMessage.getOrginalMessage()==null", "return", null, 0, null);
                        return;
                    }
                    if ((brVar instanceof bs) && brVar.m() == 2230303) {
                        this.a.o();
                    }
                    com.baidu.tieba.im.message.b bVar2 = (com.baidu.tieba.im.message.b) brVar.o();
                    if (brVar.l()) {
                        long currentTimeMillis = System.currentTimeMillis() - bVar2.t();
                        long j2 = bVar2.j();
                        d2 = this.a.d(bVar2);
                        cb.a(brVar.w(), 0, "", "", String.valueOf(d2) + "rid" + j2, brVar.m(), brVar.n(), currentTimeMillis);
                        this.a.c(bVar2);
                        if (brVar.m() > 0) {
                            msglistActivity = this.a.p;
                            msglistActivity.showToast(brVar.n());
                            if (bVar2.j() != brVar.b()) {
                                brVar.b(bVar2.j());
                                cb.a(brVar.w(), 0, "orginalRecordId != serverRecordId", "", null, brVar.m(), brVar.n());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - bVar2.t();
                    long b = brVar.b();
                    long a5 = brVar.a();
                    d = this.a.d(bVar2);
                    cb.a(brVar.w(), 0, "", "", "rid = " + b + "msgId = " + a5 + d, brVar.m(), brVar.n(), currentTimeMillis2);
                    if (bVar2.j() != brVar.b()) {
                        brVar.b(bVar2.j());
                        cb.a(brVar.w(), 0, "orginalRecordId != serverRecordId", "", null, brVar.m(), brVar.n());
                    }
                    this.a.a(brVar);
                }
            } else if (sVar.w() == -103) {
                if (!(sVar instanceof com.baidu.tieba.im.message.p)) {
                    com.baidu.adp.lib.util.f.b("transform to LoadDraftResponsedMessage error");
                    return;
                }
                com.baidu.tieba.im.message.p pVar = (com.baidu.tieba.im.message.p) sVar;
                if (pVar.l()) {
                    com.baidu.adp.lib.util.f.b("LoadDraftResponedMessage hasError");
                    return;
                }
                q2 = this.a.q();
                if (!q2) {
                    r2 = this.a.r();
                    if (!r2) {
                        userData3 = this.a.g;
                        if (userData3 == null) {
                            com.baidu.adp.lib.util.f.b("user == null");
                            return;
                        }
                        String b2 = pVar.b();
                        userData4 = this.a.g;
                        if (!b2.equals(String.valueOf(userData4.getUserId()))) {
                            return;
                        }
                        this.a.mLoadDataMode = 8;
                        gVar3 = this.a.mLoadDataCallBack;
                        gVar3.a(pVar.a());
                    }
                }
                groupData3 = this.a.f;
                if (groupData3 == null) {
                    com.baidu.adp.lib.util.f.b("group ==null");
                    return;
                }
                String b3 = pVar.b();
                groupData4 = this.a.f;
                if (!b3.equals(String.valueOf(groupData4.getGroupId()))) {
                    return;
                }
                this.a.mLoadDataMode = 8;
                gVar3 = this.a.mLoadDataCallBack;
                gVar3.a(pVar.a());
            } else if (sVar.w() == -105) {
                if (!(sVar instanceof com.baidu.tieba.im.message.r)) {
                    com.baidu.adp.lib.util.f.b("transform to LoadHistoryResponsedMessage error");
                    return;
                }
                com.baidu.tieba.im.message.r rVar = (com.baidu.tieba.im.message.r) sVar;
                if (rVar.l()) {
                    com.baidu.adp.lib.util.f.b("LoadHistoryResponsedMessage hasError");
                    return;
                }
                LinkedList linkedList2 = (LinkedList) rVar.b();
                q = this.a.q();
                if (!q || rVar.e() != 0) {
                    r = this.a.r();
                    if (!r || rVar.e() != 2) {
                        i = this.a.e;
                        if (i == 1 && rVar.e() == 1) {
                            userData = this.a.g;
                            if (userData == null) {
                                com.baidu.adp.lib.util.f.b("user ==null or LoadHistoryResponsedMessage == null");
                                return;
                            }
                            long d3 = rVar.d();
                            userData2 = this.a.g;
                            if (d3 == userData2.getUserIdLong()) {
                                try {
                                    j = Long.parseLong(TiebaApplication.A());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    j = 0;
                                }
                                Iterator it = linkedList2.iterator();
                                while (it.hasNext()) {
                                    com.baidu.tieba.im.message.b bVar3 = (com.baidu.tieba.im.message.b) it.next();
                                    if (bVar3.m() == 0) {
                                        bVar3.e(j);
                                    } else if (bVar3.c() == 0) {
                                        bVar3.b(j);
                                    }
                                }
                            } else {
                                return;
                            }
                        }
                        msgPageData = this.a.j;
                        a = this.a.a(msgPageData.getChatMessages(), linkedList2);
                        if (a <= 0) {
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
                        if (!rVar.c()) {
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
                            return;
                        }
                        return;
                    }
                }
                groupData = this.a.f;
                if (groupData == null) {
                    com.baidu.adp.lib.util.f.b("group ==null or LoadHistoryResponsedMessage == null");
                } else if (rVar.a() != null) {
                    String a6 = rVar.a();
                    groupData2 = this.a.f;
                    if (!a6.equals(String.valueOf(groupData2.getGroupId()))) {
                        return;
                    }
                    msgPageData = this.a.j;
                    a = this.a.a(msgPageData.getChatMessages(), linkedList2);
                    if (a <= 0) {
                    }
                    MsglistModel msglistModel32 = this.a;
                    msgPageData4 = this.a.j;
                    msglistModel32.a(msgPageData4.getChatMessages());
                    if (!rVar.c()) {
                    }
                }
            }
        }
    }
}
