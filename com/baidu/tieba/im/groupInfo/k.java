package com.baidu.tieba.im.groupInfo;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.tieba.im.messageCenter.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupInfoActivity f1752a;

    private k(GroupInfoActivity groupInfoActivity) {
        this.f1752a = groupInfoActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(GroupInfoActivity groupInfoActivity, i iVar) {
        this(groupInfoActivity);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        com.baidu.tieba.im.model.c cVar;
        Message orginalMessage;
        com.baidu.tieba.im.model.c cVar2;
        String[] split;
        com.baidu.tieba.im.model.c cVar3;
        com.baidu.tieba.im.model.c cVar4;
        m mVar;
        com.baidu.tieba.im.model.c cVar5;
        m mVar2;
        com.baidu.tieba.im.model.c cVar6;
        m mVar3;
        com.baidu.tieba.im.model.c cVar7;
        m mVar4;
        com.baidu.tieba.im.model.c cVar8;
        m mVar5;
        int i;
        com.baidu.tieba.im.model.c cVar9;
        com.baidu.tieba.im.model.ab abVar;
        com.baidu.tieba.im.model.c cVar10;
        com.baidu.tieba.im.model.ab abVar2;
        com.baidu.tieba.im.model.c cVar11;
        com.baidu.tieba.im.model.ab abVar3;
        com.baidu.tieba.im.model.c cVar12;
        com.baidu.tieba.im.model.c cVar13;
        com.baidu.tieba.im.model.c cVar14;
        m mVar6;
        com.baidu.tieba.im.model.c cVar15;
        m mVar7;
        com.baidu.tieba.im.model.c cVar16;
        com.baidu.tieba.im.model.c cVar17;
        m mVar8;
        com.baidu.tieba.im.model.c cVar18;
        com.baidu.tieba.im.model.c cVar19;
        m mVar9;
        com.baidu.tieba.im.model.c cVar20;
        com.baidu.tieba.im.model.c cVar21;
        m mVar10;
        com.baidu.tieba.im.model.c cVar22;
        Message orginalMessage2;
        com.baidu.tieba.im.model.c cVar23;
        m mVar11;
        com.baidu.tieba.im.model.c cVar24;
        m mVar12;
        com.baidu.tieba.im.model.c cVar25;
        com.baidu.tieba.im.model.c cVar26;
        m mVar13;
        com.baidu.tieba.im.model.c cVar27;
        com.baidu.tieba.im.model.c cVar28;
        com.baidu.tieba.im.model.c cVar29;
        m mVar14;
        com.baidu.tieba.im.model.c cVar30;
        com.baidu.tieba.im.model.c cVar31;
        com.baidu.tieba.im.model.c cVar32;
        com.baidu.tieba.im.model.c cVar33;
        com.baidu.tieba.im.model.c cVar34;
        com.baidu.tieba.im.model.c cVar35;
        com.baidu.tieba.im.model.c cVar36;
        com.baidu.tieba.im.model.c cVar37;
        com.baidu.tieba.im.model.c cVar38;
        m mVar15;
        if (message == null) {
            mVar15 = this.f1752a.f;
            mVar15.p();
            this.f1752a.showToast(R.string.neterror);
        } else if (message.getCmd() == -102) {
            if (!(message instanceof ResponseGroupInfoMessage)) {
                cVar36 = this.f1752a.g;
                cVar37 = this.f1752a.g;
                long a2 = cVar37.a();
                cVar38 = this.f1752a.g;
                cVar36.a(a2, cVar38.b());
                return;
            }
            ResponseGroupInfoMessage responseGroupInfoMessage = (ResponseGroupInfoMessage) message;
            cVar28 = this.f1752a.g;
            if (cVar28.i() == responseGroupInfoMessage.getOrginalMessage()) {
                if (responseGroupInfoMessage.hasError()) {
                    cVar33 = this.f1752a.g;
                    cVar34 = this.f1752a.g;
                    long a3 = cVar34.a();
                    cVar35 = this.f1752a.g;
                    cVar33.a(a3, cVar35.b());
                    return;
                }
                this.f1752a.d();
                cVar29 = this.f1752a.g;
                cVar29.a(responseGroupInfoMessage);
                mVar14 = this.f1752a.f;
                mVar14.a(responseGroupInfoMessage);
                cVar30 = this.f1752a.g;
                cVar31 = this.f1752a.g;
                long a4 = cVar31.a();
                cVar32 = this.f1752a.g;
                cVar30.a(a4, cVar32.b());
            }
        } else if (message.getCmd() == 103004) {
            mVar12 = this.f1752a.f;
            mVar12.p();
            if (!(message instanceof ResponseGroupInfoMessage)) {
                this.f1752a.showToast(R.string.neterror);
                return;
            }
            ResponseGroupInfoMessage responseGroupInfoMessage2 = (ResponseGroupInfoMessage) message;
            cVar25 = this.f1752a.g;
            if (cVar25.j() == responseGroupInfoMessage2.getOrginalMessage()) {
                if (responseGroupInfoMessage2.getErrNo() == 2230101) {
                    this.f1752a.showToast(responseGroupInfoMessage2.getErrMsg(), false);
                    this.f1752a.finish();
                } else if (!responseGroupInfoMessage2.hasError()) {
                    this.f1752a.d();
                    cVar26 = this.f1752a.g;
                    cVar26.a(responseGroupInfoMessage2);
                    if (responseGroupInfoMessage2 == null || responseGroupInfoMessage2.isJoin()) {
                        mVar13 = this.f1752a.f;
                        mVar13.a(responseGroupInfoMessage2, false);
                        return;
                    }
                    String B = TiebaApplication.B();
                    cVar27 = this.f1752a.g;
                    u.a(B, String.valueOf(cVar27.a()), Util.MILLSECONDS_OF_MINUTE, new l(this, responseGroupInfoMessage2));
                } else {
                    this.f1752a.showToast(R.string.neterror);
                }
            }
        } else if (message.getCmd() == 103110) {
            if (message instanceof ResponseJoinGroupMessage) {
                ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) message;
                if (!responseJoinGroupMessage.hasError() && (orginalMessage2 = responseJoinGroupMessage.getOrginalMessage()) != null && (orginalMessage2 instanceof RequestJoinGroupMessage)) {
                    RequestJoinGroupMessage requestJoinGroupMessage = (RequestJoinGroupMessage) orginalMessage2;
                    if (requestJoinGroupMessage.getGroupId() != null) {
                        String groupId = requestJoinGroupMessage.getGroupId();
                        cVar23 = this.f1752a.g;
                        if (groupId.equals(String.valueOf(cVar23.a()))) {
                            mVar11 = this.f1752a.f;
                            mVar11.w();
                            cVar24 = this.f1752a.g;
                            cVar24.a(true);
                            this.f1752a.e();
                        }
                    }
                }
            }
        } else if (message.getCmd() == 103102) {
            mVar5 = this.f1752a.f;
            mVar5.p();
            if (!(message instanceof ResponseUpdateGroupMessage)) {
                this.f1752a.showToast(R.string.neterror);
                return;
            }
            ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) message;
            if (responseUpdateGroupMessage.getErrNo() != 0) {
                this.f1752a.showToast(responseUpdateGroupMessage.getErrMsg());
            } else if (responseUpdateGroupMessage.getOrginalMessage() instanceof RequestUpdateGroupMessage) {
                int type = ((RequestUpdateGroupMessage) responseUpdateGroupMessage.getOrginalMessage()).getType();
                i = this.f1752a.e;
                switch (i) {
                    case 1:
                        if (type == 3) {
                            cVar21 = this.f1752a.g;
                            cVar21.g();
                            mVar10 = this.f1752a.f;
                            cVar22 = this.f1752a.g;
                            mVar10.b(cVar22.d());
                            return;
                        }
                        return;
                    case 2:
                        if (type == 3) {
                            cVar19 = this.f1752a.g;
                            cVar19.f();
                            mVar9 = this.f1752a.f;
                            cVar20 = this.f1752a.g;
                            mVar9.b(cVar20.d());
                            return;
                        }
                        return;
                    case 3:
                        if (type == 4) {
                            cVar17 = this.f1752a.g;
                            cVar17.h();
                            mVar8 = this.f1752a.f;
                            cVar18 = this.f1752a.g;
                            mVar8.b(cVar18.d());
                            return;
                        }
                        return;
                    case 4:
                        cVar9 = this.f1752a.g;
                        GroupData group = cVar9.d().getGroup();
                        abVar = this.f1752a.h;
                        group.setFlag(abVar.h());
                        cVar10 = this.f1752a.g;
                        GroupData group2 = cVar10.d().getGroup();
                        abVar2 = this.f1752a.h;
                        group2.setPosition(abVar2.e());
                        cVar11 = this.f1752a.g;
                        GroupData group3 = cVar11.d().getGroup();
                        abVar3 = this.f1752a.h;
                        group3.setBusiness(abVar3.f());
                        cVar12 = this.f1752a.g;
                        if ((cVar12.d().getGroup().getFlag() & 1) == 1) {
                            mVar7 = this.f1752a.f;
                            cVar16 = this.f1752a.g;
                            mVar7.a(cVar16.d().isGroupManager());
                        } else {
                            cVar13 = this.f1752a.g;
                            String position = cVar13.d().getGroup().getPosition();
                            cVar14 = this.f1752a.g;
                            String business = cVar14.d().getGroup().getBusiness();
                            StringBuffer stringBuffer = new StringBuffer();
                            if (position != null) {
                                stringBuffer.append(position);
                            }
                            if (business != null) {
                                stringBuffer.append(business);
                            }
                            mVar6 = this.f1752a.f;
                            cVar15 = this.f1752a.g;
                            mVar6.a(cVar15.d().isGroupManager(), stringBuffer.toString());
                        }
                        this.f1752a.showToast(R.string.group_address_success);
                        return;
                    default:
                        return;
                }
            }
        } else if (message.getCmd() == 103112) {
            if (message instanceof ResponseRemoveMembersMessage) {
                ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) message;
                if (!responseRemoveMembersMessage.hasError() && (orginalMessage = responseRemoveMembersMessage.getOrginalMessage()) != null && (orginalMessage instanceof RequestRemoveMembersMessage)) {
                    RequestRemoveMembersMessage requestRemoveMembersMessage = (RequestRemoveMembersMessage) orginalMessage;
                    long groupId2 = requestRemoveMembersMessage.getGroupId();
                    cVar2 = this.f1752a.g;
                    if (groupId2 == cVar2.a()) {
                        String userIds = requestRemoveMembersMessage.getUserIds();
                        if (!TextUtils.isEmpty(userIds) && (split = userIds.split(",")) != null && split.length != 0) {
                            String id = TiebaApplication.F().getID();
                            if (!TextUtils.isEmpty(id)) {
                                for (String str : split) {
                                    if (id.equals(str)) {
                                        cVar3 = this.f1752a.g;
                                        cVar3.d().setJoin(false);
                                        cVar4 = this.f1752a.g;
                                        cVar4.a(false);
                                        mVar = this.f1752a.f;
                                        cVar5 = this.f1752a.g;
                                        mVar.a(cVar5.d(), true);
                                        mVar2 = this.f1752a.f;
                                        mVar2.c(str);
                                        this.f1752a.e();
                                        return;
                                    }
                                    cVar6 = this.f1752a.g;
                                    if (cVar6.a(str)) {
                                        mVar3 = this.f1752a.f;
                                        mVar3.c(str);
                                        cVar7 = this.f1752a.g;
                                        GroupData group4 = cVar7.d().getGroup();
                                        if (group4 != null && group4.getMemberNum() > 1) {
                                            group4.setMemberNum(group4.getMemberNum() - 1);
                                        }
                                        mVar4 = this.f1752a.f;
                                        cVar8 = this.f1752a.g;
                                        mVar4.a(cVar8.d());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (message.getCmd() == 103104 && (message instanceof ResponseDismissGroupMessage)) {
            ResponseDismissGroupMessage responseDismissGroupMessage = (ResponseDismissGroupMessage) message;
            if (!responseDismissGroupMessage.hasError()) {
                cVar = this.f1752a.g;
                if (cVar.a() == responseDismissGroupMessage.getGroupId()) {
                    this.f1752a.finish();
                }
            }
        }
    }
}
