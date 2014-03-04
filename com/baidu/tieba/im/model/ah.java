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
public final class ah implements bc {
    final /* synthetic */ MsglistModel a;

    private ah(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ah(MsglistModel msglistModel, byte b) {
        this(msglistModel);
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.im.chat.bc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.baidu.tieba.im.message.s sVar) {
        br brVar;
        MsglistActivity msglistActivity;
        boolean m;
        boolean n;
        int i;
        UserData userData;
        UserData userData2;
        long j;
        MsgPageData msgPageData;
        int b;
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
        boolean m2;
        GroupData groupData3;
        GroupData groupData4;
        com.baidu.adp.a.g gVar3;
        boolean n2;
        UserData userData3;
        UserData userData4;
        boolean m3;
        GroupData groupData5;
        MsgPageData msgPageData9;
        MsgPageData msgPageData10;
        MsgPageData msgPageData11;
        MsgPageData msgPageData12;
        MsgPageData msgPageData13;
        MsgPageData msgPageData14;
        com.baidu.adp.a.g gVar4;
        MsgPageData msgPageData15;
        boolean n3;
        if (sVar != null) {
            if (sVar.v() == -100) {
                com.baidu.tieba.im.data.c cVar = (com.baidu.tieba.im.data.c) sVar;
                com.baidu.tieba.im.data.f fVar = null;
                m3 = this.a.m();
                if (!m3) {
                    n3 = this.a.n();
                    if (!n3) {
                        if (this.a.b() != null && cVar.a() != null && cVar.a().getGroupType() == 6) {
                            List<com.baidu.tieba.im.message.b> a = cVar.b().a();
                            LinkedList linkedList = new LinkedList();
                            for (com.baidu.tieba.im.message.b bVar : a) {
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
                            List<com.baidu.tieba.im.message.b> a2 = fVar.a();
                            MsglistModel.a(this.a, a2);
                            MsglistModel msglistModel = this.a;
                            msgPageData9 = this.a.j;
                            MsglistModel.a(msglistModel, msgPageData9.getChatMessages(), a2);
                            Collections.sort(a2, new ag(this.a, (byte) 0));
                            MsglistModel msglistModel2 = this.a;
                            msgPageData10 = this.a.j;
                            int b2 = MsglistModel.b(msglistModel2, msgPageData10.getChatMessages(), a2);
                            if (b2 > 0) {
                                msgPageData13 = this.a.j;
                                msgPageData13.setIsNewAdd(true);
                                msgPageData14 = this.a.j;
                                msgPageData14.setNewAddNum(b2);
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
            } else if (sVar.v() == 202001 || sVar.v() == 205001) {
                if ((sVar instanceof br) && (brVar = (br) sVar) != null) {
                    if (brVar.o() == null || !(brVar.o() instanceof com.baidu.tieba.im.message.b)) {
                        cb.a(brVar.v(), 0, "chatResMessage.getOrginalMessage()==null", "return", null, 0, null);
                        return;
                    }
                    if ((brVar instanceof bs) && brVar.m() == 2230303) {
                        this.a.l();
                    }
                    com.baidu.tieba.im.message.b bVar2 = (com.baidu.tieba.im.message.b) brVar.o();
                    if (brVar.l()) {
                        cb.a(brVar.v(), 0, "", "", String.valueOf(MsglistModel.b(this.a, bVar2)) + "rid" + bVar2.j(), brVar.m(), brVar.n(), System.currentTimeMillis() - bVar2.t());
                        this.a.b(bVar2);
                        if (brVar.m() > 0) {
                            msglistActivity = this.a.p;
                            msglistActivity.showToast(brVar.n());
                            if (bVar2.j() != brVar.b()) {
                                brVar.b(bVar2.j());
                                cb.a(brVar.v(), 0, "orginalRecordId != serverRecordId", "", null, brVar.m(), brVar.n());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    cb.a(brVar.v(), 0, "", "", "rid = " + brVar.b() + "msgId = " + brVar.a() + MsglistModel.b(this.a, bVar2), brVar.m(), brVar.n(), System.currentTimeMillis() - bVar2.t());
                    if (bVar2.j() != brVar.b()) {
                        brVar.b(bVar2.j());
                        cb.a(brVar.v(), 0, "orginalRecordId != serverRecordId", "", null, brVar.m(), brVar.n());
                    }
                    MsglistModel.a(this.a, brVar);
                }
            } else if (sVar.v() == -103) {
                if (!(sVar instanceof com.baidu.tieba.im.message.p)) {
                    com.baidu.adp.lib.util.e.b("transform to LoadDraftResponsedMessage error");
                    return;
                }
                com.baidu.tieba.im.message.p pVar = (com.baidu.tieba.im.message.p) sVar;
                if (pVar.l()) {
                    com.baidu.adp.lib.util.e.b("LoadDraftResponedMessage hasError");
                    return;
                }
                m2 = this.a.m();
                if (!m2) {
                    n2 = this.a.n();
                    if (!n2) {
                        userData3 = this.a.g;
                        if (userData3 == null) {
                            com.baidu.adp.lib.util.e.b("user == null");
                            return;
                        }
                        String b3 = pVar.b();
                        userData4 = this.a.g;
                        if (!b3.equals(String.valueOf(userData4.getUserId()))) {
                            return;
                        }
                        this.a.mLoadDataMode = 8;
                        gVar3 = this.a.mLoadDataCallBack;
                        gVar3.a(pVar.a());
                    }
                }
                groupData3 = this.a.f;
                if (groupData3 == null) {
                    com.baidu.adp.lib.util.e.b("group ==null");
                    return;
                }
                String b4 = pVar.b();
                groupData4 = this.a.f;
                if (!b4.equals(String.valueOf(groupData4.getGroupId()))) {
                    return;
                }
                this.a.mLoadDataMode = 8;
                gVar3 = this.a.mLoadDataCallBack;
                gVar3.a(pVar.a());
            } else if (sVar.v() == -105) {
                if (!(sVar instanceof com.baidu.tieba.im.message.r)) {
                    com.baidu.adp.lib.util.e.b("transform to LoadHistoryResponsedMessage error");
                    return;
                }
                com.baidu.tieba.im.message.r rVar = (com.baidu.tieba.im.message.r) sVar;
                if (rVar.l()) {
                    com.baidu.adp.lib.util.e.b("LoadHistoryResponsedMessage hasError");
                    return;
                }
                LinkedList linkedList2 = (LinkedList) rVar.b();
                m = this.a.m();
                if (!m || rVar.e() != 0) {
                    n = this.a.n();
                    if (!n || rVar.e() != 2) {
                        i = this.a.e;
                        if (i == 1 && rVar.e() == 1) {
                            userData = this.a.g;
                            if (userData == null) {
                                com.baidu.adp.lib.util.e.b("user ==null or LoadHistoryResponsedMessage == null");
                                return;
                            }
                            long d = rVar.d();
                            userData2 = this.a.g;
                            if (d == userData2.getUserIdLong()) {
                                try {
                                    j = Long.parseLong(TiebaApplication.v());
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
                        b = MsglistModel.b(this.a, msgPageData.getChatMessages(), linkedList2);
                        if (b <= 0) {
                            msgPageData7 = this.a.j;
                            msgPageData7.setIsNewAdd(true);
                            msgPageData8 = this.a.j;
                            msgPageData8.setNewAddNum(b);
                        } else {
                            msgPageData2 = this.a.j;
                            msgPageData2.setIsNewAdd(false);
                            msgPageData3 = this.a.j;
                            msgPageData3.setNewAddNum(0);
                        }
                        MsglistModel msglistModel3 = this.a;
                        msgPageData4 = this.a.j;
                        MsglistModel.b(msglistModel3, msgPageData4.getChatMessages());
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
                    com.baidu.adp.lib.util.e.b("group ==null or LoadHistoryResponsedMessage == null");
                } else if (rVar.a() != null) {
                    String a3 = rVar.a();
                    groupData2 = this.a.f;
                    if (!a3.equals(String.valueOf(groupData2.getGroupId()))) {
                        return;
                    }
                    msgPageData = this.a.j;
                    b = MsglistModel.b(this.a, msgPageData.getChatMessages(), linkedList2);
                    if (b <= 0) {
                    }
                    MsglistModel msglistModel32 = this.a;
                    msgPageData4 = this.a.j;
                    MsglistModel.b(msglistModel32, msgPageData4.getChatMessages());
                    if (!rVar.c()) {
                    }
                }
            }
        }
    }
}
