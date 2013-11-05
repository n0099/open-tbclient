package com.baidu.tieba.im.groupInfo;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupInfoActivity f1607a;

    private l(GroupInfoActivity groupInfoActivity) {
        this.f1607a = groupInfoActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(GroupInfoActivity groupInfoActivity, i iVar) {
        this(groupInfoActivity);
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        Message orginalMessage;
        com.baidu.tieba.im.model.c cVar;
        String[] split;
        com.baidu.tieba.im.model.c cVar2;
        com.baidu.tieba.im.model.c cVar3;
        n nVar;
        com.baidu.tieba.im.model.c cVar4;
        n nVar2;
        com.baidu.tieba.im.model.c cVar5;
        n nVar3;
        n nVar4;
        int i;
        com.baidu.tieba.im.model.x xVar;
        n nVar5;
        com.baidu.tieba.im.model.c cVar6;
        com.baidu.tieba.im.model.c cVar7;
        com.baidu.tieba.im.model.x xVar2;
        n nVar6;
        com.baidu.tieba.im.model.c cVar8;
        com.baidu.tieba.im.model.c cVar9;
        com.baidu.tieba.im.model.c cVar10;
        com.baidu.tieba.im.model.c cVar11;
        n nVar7;
        com.baidu.tieba.im.model.c cVar12;
        Message orginalMessage2;
        com.baidu.tieba.im.model.c cVar13;
        n nVar8;
        com.baidu.tieba.im.model.c cVar14;
        n nVar9;
        com.baidu.tieba.im.model.c cVar15;
        com.baidu.tieba.im.model.c cVar16;
        n nVar10;
        com.baidu.tieba.im.model.c cVar17;
        com.baidu.tieba.im.model.c cVar18;
        com.baidu.tieba.im.model.c cVar19;
        n nVar11;
        com.baidu.tieba.im.model.c cVar20;
        com.baidu.tieba.im.model.c cVar21;
        com.baidu.tieba.im.model.c cVar22;
        com.baidu.tieba.im.model.c cVar23;
        com.baidu.tieba.im.model.c cVar24;
        com.baidu.tieba.im.model.c cVar25;
        com.baidu.tieba.im.model.c cVar26;
        com.baidu.tieba.im.model.c cVar27;
        com.baidu.tieba.im.model.c cVar28;
        n nVar12;
        if (message == null) {
            nVar12 = this.f1607a.f;
            nVar12.p();
            this.f1607a.b(R.string.neterror);
        } else if (message.getCmd() == -102) {
            if (!(message instanceof ResponseGroupInfoMessage)) {
                cVar26 = this.f1607a.g;
                cVar27 = this.f1607a.g;
                long a2 = cVar27.a();
                cVar28 = this.f1607a.g;
                cVar26.a(a2, cVar28.b());
                return;
            }
            ResponseGroupInfoMessage responseGroupInfoMessage = (ResponseGroupInfoMessage) message;
            cVar18 = this.f1607a.g;
            if (cVar18.i() == responseGroupInfoMessage.getOrginalMessage()) {
                if (responseGroupInfoMessage.hasError()) {
                    cVar23 = this.f1607a.g;
                    cVar24 = this.f1607a.g;
                    long a3 = cVar24.a();
                    cVar25 = this.f1607a.g;
                    cVar23.a(a3, cVar25.b());
                    return;
                }
                this.f1607a.e();
                cVar19 = this.f1607a.g;
                cVar19.a(responseGroupInfoMessage);
                nVar11 = this.f1607a.f;
                nVar11.a(responseGroupInfoMessage);
                cVar20 = this.f1607a.g;
                cVar21 = this.f1607a.g;
                long a4 = cVar21.a();
                cVar22 = this.f1607a.g;
                cVar20.a(a4, cVar22.b());
            }
        } else if (message.getCmd() == 103004) {
            nVar9 = this.f1607a.f;
            nVar9.p();
            if (!(message instanceof ResponseGroupInfoMessage)) {
                this.f1607a.b(R.string.neterror);
                return;
            }
            ResponseGroupInfoMessage responseGroupInfoMessage2 = (ResponseGroupInfoMessage) message;
            cVar15 = this.f1607a.g;
            if (cVar15.j() == responseGroupInfoMessage2.getOrginalMessage()) {
                if (!responseGroupInfoMessage2.hasError()) {
                    this.f1607a.e();
                    cVar16 = this.f1607a.g;
                    cVar16.a(responseGroupInfoMessage2);
                    if (responseGroupInfoMessage2 == null || responseGroupInfoMessage2.isJoin()) {
                        nVar10 = this.f1607a.f;
                        nVar10.a(responseGroupInfoMessage2, false);
                        return;
                    }
                    String C = TiebaApplication.C();
                    cVar17 = this.f1607a.g;
                    v.a(C, String.valueOf(cVar17.a()), Util.MILLSECONDS_OF_MINUTE, new m(this, responseGroupInfoMessage2));
                    return;
                }
                this.f1607a.b(R.string.neterror);
            }
        } else if (message.getCmd() == 103110) {
            if (message instanceof ResponseJoinGroupMessage) {
                ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) message;
                if (!responseJoinGroupMessage.hasError() && (orginalMessage2 = responseJoinGroupMessage.getOrginalMessage()) != null && (orginalMessage2 instanceof RequestJoinGroupMessage)) {
                    RequestJoinGroupMessage requestJoinGroupMessage = (RequestJoinGroupMessage) orginalMessage2;
                    if (requestJoinGroupMessage.getGroupId() != null) {
                        String groupId = requestJoinGroupMessage.getGroupId();
                        cVar13 = this.f1607a.g;
                        if (groupId.equals(String.valueOf(cVar13.a()))) {
                            nVar8 = this.f1607a.f;
                            nVar8.x();
                            cVar14 = this.f1607a.g;
                            cVar14.a(true);
                        }
                    }
                }
            }
        } else if (message.getCmd() == 103102) {
            nVar4 = this.f1607a.f;
            nVar4.p();
            if (!(message instanceof ResponseUpdateGroupMessage)) {
                this.f1607a.b(R.string.neterror);
                return;
            }
            ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) message;
            if (responseUpdateGroupMessage.getErrNo() == 0) {
                i = this.f1607a.e;
                switch (i) {
                    case 1:
                        cVar11 = this.f1607a.g;
                        cVar11.g();
                        break;
                    case 2:
                        cVar10 = this.f1607a.g;
                        cVar10.f();
                        break;
                    case 3:
                        cVar9 = this.f1607a.g;
                        cVar9.h();
                        break;
                    case 4:
                        xVar = this.f1607a.j;
                        if ((xVar.f() & 1) == 1) {
                            nVar6 = this.f1607a.f;
                            cVar8 = this.f1607a.g;
                            nVar6.b(cVar8.d().isGroupManager());
                        } else {
                            nVar5 = this.f1607a.f;
                            cVar6 = this.f1607a.g;
                            nVar5.a(cVar6.d().isGroupManager());
                        }
                        cVar7 = this.f1607a.g;
                        GroupData group = cVar7.d().getGroup();
                        xVar2 = this.f1607a.j;
                        group.setFlag(xVar2.f());
                        this.f1607a.b(R.string.group_address_success);
                        break;
                }
                nVar7 = this.f1607a.f;
                cVar12 = this.f1607a.g;
                nVar7.b(cVar12.d());
                return;
            }
            this.f1607a.a(responseUpdateGroupMessage.getErrMsg());
        } else if (message.getCmd() == 103112 && (message instanceof ResponseRemoveMembersMessage)) {
            ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) message;
            if (!responseRemoveMembersMessage.hasError() && (orginalMessage = responseRemoveMembersMessage.getOrginalMessage()) != null && (orginalMessage instanceof RequestRemoveMembersMessage)) {
                RequestRemoveMembersMessage requestRemoveMembersMessage = (RequestRemoveMembersMessage) orginalMessage;
                long groupId2 = requestRemoveMembersMessage.getGroupId();
                cVar = this.f1607a.g;
                if (groupId2 == cVar.a()) {
                    String userIds = requestRemoveMembersMessage.getUserIds();
                    if (!TextUtils.isEmpty(userIds) && (split = userIds.split(",")) != null && split.length != 0) {
                        String id = TiebaApplication.G().getID();
                        if (!TextUtils.isEmpty(id)) {
                            for (String str : split) {
                                if (id.equals(str)) {
                                    cVar2 = this.f1607a.g;
                                    cVar2.d().setJoin(false);
                                    cVar3 = this.f1607a.g;
                                    cVar3.a(false);
                                    nVar = this.f1607a.f;
                                    cVar4 = this.f1607a.g;
                                    nVar.a(cVar4.d());
                                    nVar2 = this.f1607a.f;
                                    nVar2.c(str);
                                    return;
                                }
                                cVar5 = this.f1607a.g;
                                if (cVar5.a(str)) {
                                    nVar3 = this.f1607a.f;
                                    nVar3.c(str);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
