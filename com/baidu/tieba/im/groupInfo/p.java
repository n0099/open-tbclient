package com.baidu.tieba.im.groupInfo;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupMessage;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseDelGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import com.baidu.tieba.im.model.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ GroupInfoActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(GroupInfoActivity groupInfoActivity) {
        super(0);
        this.a = groupInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.tieba.im.model.k kVar;
        Message<?> orginalMessage;
        com.baidu.tieba.im.model.k kVar2;
        String[] split;
        com.baidu.tieba.im.model.k kVar3;
        com.baidu.tieba.im.model.k kVar4;
        r rVar;
        com.baidu.tieba.im.model.k kVar5;
        r rVar2;
        com.baidu.tieba.im.model.k kVar6;
        r rVar3;
        com.baidu.tieba.im.model.k kVar7;
        r rVar4;
        com.baidu.tieba.im.model.k kVar8;
        r rVar5;
        int i;
        com.baidu.tieba.im.model.k kVar9;
        bx bxVar;
        com.baidu.tieba.im.model.k kVar10;
        bx bxVar2;
        com.baidu.tieba.im.model.k kVar11;
        bx bxVar3;
        com.baidu.tieba.im.model.k kVar12;
        com.baidu.tieba.im.model.k kVar13;
        com.baidu.tieba.im.model.k kVar14;
        r rVar6;
        com.baidu.tieba.im.model.k kVar15;
        r rVar7;
        com.baidu.tieba.im.model.k kVar16;
        com.baidu.tieba.im.model.k kVar17;
        r rVar8;
        com.baidu.tieba.im.model.k kVar18;
        com.baidu.tieba.im.model.k kVar19;
        r rVar9;
        com.baidu.tieba.im.model.k kVar20;
        com.baidu.tieba.im.model.k kVar21;
        r rVar10;
        com.baidu.tieba.im.model.k kVar22;
        Message<?> orginalMessage2;
        com.baidu.tieba.im.model.k kVar23;
        r rVar11;
        com.baidu.tieba.im.model.k kVar24;
        r rVar12;
        com.baidu.tieba.im.model.k kVar25;
        com.baidu.tieba.im.model.k kVar26;
        r rVar13;
        r rVar14;
        com.baidu.tieba.im.model.k kVar27;
        r rVar15;
        if (socketResponsedMessage == null) {
            rVar15 = this.a.f;
            rVar15.p();
            this.a.showToast(com.baidu.tieba.y.neterror);
        } else if (socketResponsedMessage.getCmd() == 103004) {
            rVar12 = this.a.f;
            rVar12.p();
            if (socketResponsedMessage.getError() != 0) {
                this.a.showToast(com.baidu.tieba.y.neterror);
                return;
            }
            ResponseGroupInfoMessage responseGroupInfoMessage = (ResponseGroupInfoMessage) socketResponsedMessage;
            kVar25 = this.a.g;
            if (kVar25.k() == responseGroupInfoMessage.getOrginalMessage()) {
                if (responseGroupInfoMessage.getError() == 2230101) {
                    this.a.showToast(responseGroupInfoMessage.getErrorString(), false);
                    this.a.finish();
                } else if (responseGroupInfoMessage.getData() != null && responseGroupInfoMessage.getError() == 0) {
                    this.a.f();
                    kVar26 = this.a.g;
                    kVar26.a(responseGroupInfoMessage.getData());
                    if (responseGroupInfoMessage == null || responseGroupInfoMessage.getData().g()) {
                        rVar13 = this.a.f;
                        rVar13.a(responseGroupInfoMessage.getData(), false);
                        return;
                    }
                    rVar14 = this.a.f;
                    rVar14.q();
                    y a = y.a();
                    String currentAccount = TbadkApplication.getCurrentAccount();
                    kVar27 = this.a.g;
                    a.a(currentAccount, String.valueOf(kVar27.d()), TbConfig.USE_TIME_INTERVAL, new q(this, responseGroupInfoMessage));
                } else {
                    this.a.showToast(com.baidu.tieba.y.neterror);
                }
            }
        } else if (socketResponsedMessage.getCmd() == 103110) {
            if (socketResponsedMessage instanceof ResponseJoinGroupMessage) {
                ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage;
                if (responseJoinGroupMessage.getError() == 0 && (orginalMessage2 = responseJoinGroupMessage.getOrginalMessage()) != null && (orginalMessage2 instanceof RequestJoinGroupMessage)) {
                    kVar23 = this.a.g;
                    if (((RequestJoinGroupMessage) orginalMessage2).getGroupId() == kVar23.d()) {
                        rVar11 = this.a.f;
                        rVar11.w();
                        kVar24 = this.a.g;
                        kVar24.a(true);
                        this.a.g();
                    }
                }
            }
        } else if (socketResponsedMessage.getCmd() == 103102) {
            rVar5 = this.a.f;
            rVar5.p();
            if (socketResponsedMessage.getError() != 0) {
                this.a.showToast(com.baidu.tieba.y.neterror);
                return;
            }
            ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) socketResponsedMessage;
            if (responseUpdateGroupMessage.getError() != 0) {
                this.a.showToast(responseUpdateGroupMessage.getErrorString());
            } else if (responseUpdateGroupMessage.getOrginalMessage() instanceof RequestUpdateGroupMessage) {
                int type = ((RequestUpdateGroupMessage) responseUpdateGroupMessage.getOrginalMessage()).getType();
                i = this.a.e;
                switch (i) {
                    case 1:
                        if (type == 3) {
                            kVar21 = this.a.g;
                            kVar21.i();
                            rVar10 = this.a.f;
                            kVar22 = this.a.g;
                            rVar10.b(kVar22.f());
                            return;
                        }
                        return;
                    case 2:
                        if (type == 3) {
                            kVar19 = this.a.g;
                            kVar19.h();
                            rVar9 = this.a.f;
                            kVar20 = this.a.g;
                            rVar9.b(kVar20.f());
                            return;
                        }
                        return;
                    case 3:
                        if (type == 4) {
                            kVar17 = this.a.g;
                            kVar17.j();
                            rVar8 = this.a.f;
                            kVar18 = this.a.g;
                            rVar8.b(kVar18.f());
                            return;
                        }
                        return;
                    case 4:
                        kVar9 = this.a.g;
                        GroupData b = kVar9.f().b();
                        bxVar = this.a.h;
                        b.setFlag(bxVar.h());
                        kVar10 = this.a.g;
                        GroupData b2 = kVar10.f().b();
                        bxVar2 = this.a.h;
                        b2.setPosition(bxVar2.e());
                        kVar11 = this.a.g;
                        GroupData b3 = kVar11.f().b();
                        bxVar3 = this.a.h;
                        b3.setBusiness(bxVar3.f());
                        kVar12 = this.a.g;
                        if ((kVar12.f().b().getFlag() & 1) == 1) {
                            rVar7 = this.a.f;
                            kVar16 = this.a.g;
                            rVar7.a(kVar16.f().h());
                        } else {
                            kVar13 = this.a.g;
                            String position = kVar13.f().b().getPosition();
                            kVar14 = this.a.g;
                            String business = kVar14.f().b().getBusiness();
                            StringBuffer stringBuffer = new StringBuffer();
                            if (position != null) {
                                stringBuffer.append(position);
                            }
                            if (business != null) {
                                stringBuffer.append(business);
                            }
                            rVar6 = this.a.f;
                            kVar15 = this.a.g;
                            rVar6.a(kVar15.f().h(), stringBuffer.toString());
                        }
                        this.a.showToast(com.baidu.tieba.y.group_address_success);
                        return;
                    default:
                        return;
                }
            }
        } else if (socketResponsedMessage.getCmd() == 103112) {
            if (socketResponsedMessage instanceof ResponseRemoveMembersMessage) {
                ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) socketResponsedMessage;
                if (responseRemoveMembersMessage.getError() == 0 && (orginalMessage = responseRemoveMembersMessage.getOrginalMessage()) != null && (orginalMessage instanceof RequestRemoveMembersMessage)) {
                    RequestRemoveMembersMessage requestRemoveMembersMessage = (RequestRemoveMembersMessage) orginalMessage;
                    long groupId = requestRemoveMembersMessage.getGroupId();
                    kVar2 = this.a.g;
                    if (groupId == kVar2.d()) {
                        String userIds = requestRemoveMembersMessage.getUserIds();
                        if (!TextUtils.isEmpty(userIds) && (split = userIds.split(",")) != null && split.length != 0) {
                            String id = TbadkApplication.getCurrentAccountObj().getID();
                            if (!TextUtils.isEmpty(id)) {
                                for (String str : split) {
                                    if (id.equals(str)) {
                                        kVar3 = this.a.g;
                                        kVar3.f().a(false);
                                        kVar4 = this.a.g;
                                        kVar4.a(false);
                                        rVar = this.a.f;
                                        kVar5 = this.a.g;
                                        rVar.a(kVar5.f(), true);
                                        rVar2 = this.a.f;
                                        rVar2.c(str);
                                        this.a.g();
                                        return;
                                    }
                                    kVar6 = this.a.g;
                                    if (kVar6.a(str)) {
                                        rVar3 = this.a.f;
                                        rVar3.c(str);
                                        kVar7 = this.a.g;
                                        GroupData b4 = kVar7.f().b();
                                        if (b4 != null && b4.getMemberNum() > 1) {
                                            b4.setMemberNum(b4.getMemberNum() - 1);
                                        }
                                        rVar4 = this.a.f;
                                        kVar8 = this.a.g;
                                        rVar4.a(kVar8.f());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (socketResponsedMessage.getCmd() == 103104) {
            if (socketResponsedMessage instanceof ResponseDismissGroupMessage) {
                ResponseDismissGroupMessage responseDismissGroupMessage = (ResponseDismissGroupMessage) socketResponsedMessage;
                if (responseDismissGroupMessage.getError() == 0) {
                    kVar = this.a.g;
                    if (kVar.d() == responseDismissGroupMessage.getGroupId()) {
                        this.a.finish();
                    }
                }
            }
        } else if (socketResponsedMessage.getCmd() == 103105) {
            if (socketResponsedMessage instanceof ResponseUpgradeMemberGroupMessage) {
                ResponseUpgradeMemberGroupMessage responseUpgradeMemberGroupMessage = (ResponseUpgradeMemberGroupMessage) socketResponsedMessage;
                if (responseUpgradeMemberGroupMessage.getError() == 0 || responseUpgradeMemberGroupMessage.getError() == 2230110) {
                    this.a.e();
                }
            }
        } else if (socketResponsedMessage.getCmd() == 103120) {
            if (socketResponsedMessage instanceof ResponseCreateGroupActivityMessage) {
                this.a.e();
            }
        } else if (socketResponsedMessage.getCmd() == 103121 && (socketResponsedMessage instanceof ResponseDelGroupActivityMessage)) {
            this.a.e();
        }
    }
}
