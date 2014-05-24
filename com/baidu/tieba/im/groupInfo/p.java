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
import com.baidu.tieba.im.model.by;
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
        com.baidu.tieba.im.model.m mVar;
        Message<?> orginalMessage;
        com.baidu.tieba.im.model.m mVar2;
        String[] split;
        com.baidu.tieba.im.model.m mVar3;
        com.baidu.tieba.im.model.m mVar4;
        r rVar;
        com.baidu.tieba.im.model.m mVar5;
        r rVar2;
        com.baidu.tieba.im.model.m mVar6;
        r rVar3;
        com.baidu.tieba.im.model.m mVar7;
        r rVar4;
        com.baidu.tieba.im.model.m mVar8;
        r rVar5;
        int i;
        com.baidu.tieba.im.model.m mVar9;
        by byVar;
        com.baidu.tieba.im.model.m mVar10;
        by byVar2;
        com.baidu.tieba.im.model.m mVar11;
        by byVar3;
        com.baidu.tieba.im.model.m mVar12;
        com.baidu.tieba.im.model.m mVar13;
        com.baidu.tieba.im.model.m mVar14;
        r rVar6;
        com.baidu.tieba.im.model.m mVar15;
        r rVar7;
        com.baidu.tieba.im.model.m mVar16;
        com.baidu.tieba.im.model.m mVar17;
        r rVar8;
        com.baidu.tieba.im.model.m mVar18;
        com.baidu.tieba.im.model.m mVar19;
        r rVar9;
        com.baidu.tieba.im.model.m mVar20;
        com.baidu.tieba.im.model.m mVar21;
        r rVar10;
        com.baidu.tieba.im.model.m mVar22;
        Message<?> orginalMessage2;
        com.baidu.tieba.im.model.m mVar23;
        r rVar11;
        com.baidu.tieba.im.model.m mVar24;
        r rVar12;
        com.baidu.tieba.im.model.m mVar25;
        com.baidu.tieba.im.model.m mVar26;
        r rVar13;
        com.baidu.tieba.im.model.m mVar27;
        r rVar14;
        if (socketResponsedMessage == null) {
            rVar14 = this.a.f;
            rVar14.p();
            this.a.showToast(com.baidu.tieba.y.neterror);
        } else if (socketResponsedMessage.getCmd() == 103004) {
            rVar12 = this.a.f;
            rVar12.p();
            if (socketResponsedMessage.getError() != 0) {
                this.a.showToast(com.baidu.tieba.y.neterror);
                return;
            }
            ResponseGroupInfoMessage responseGroupInfoMessage = (ResponseGroupInfoMessage) socketResponsedMessage;
            mVar25 = this.a.g;
            if (mVar25.k() == responseGroupInfoMessage.getOrginalMessage()) {
                if (responseGroupInfoMessage.getError() == 2230101) {
                    this.a.showToast(responseGroupInfoMessage.getErrorString(), false);
                    this.a.finish();
                } else if (responseGroupInfoMessage.getData() != null && responseGroupInfoMessage.getError() == 0) {
                    this.a.f();
                    mVar26 = this.a.g;
                    mVar26.a(responseGroupInfoMessage.getData());
                    if (responseGroupInfoMessage == null || responseGroupInfoMessage.getData().g()) {
                        rVar13 = this.a.f;
                        rVar13.a(responseGroupInfoMessage.getData(), false);
                        return;
                    }
                    aa a = aa.a();
                    String currentAccount = TbadkApplication.getCurrentAccount();
                    mVar27 = this.a.g;
                    a.a(currentAccount, String.valueOf(mVar27.d()), TbConfig.USE_TIME_INTERVAL, new q(this, responseGroupInfoMessage));
                } else {
                    this.a.showToast(com.baidu.tieba.y.neterror);
                }
            }
        } else if (socketResponsedMessage.getCmd() == 103110) {
            if (socketResponsedMessage instanceof ResponseJoinGroupMessage) {
                ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage;
                if (responseJoinGroupMessage.getError() == 0 && (orginalMessage2 = responseJoinGroupMessage.getOrginalMessage()) != null && (orginalMessage2 instanceof RequestJoinGroupMessage)) {
                    mVar23 = this.a.g;
                    if (((RequestJoinGroupMessage) orginalMessage2).getGroupId() == mVar23.d()) {
                        rVar11 = this.a.f;
                        rVar11.w();
                        mVar24 = this.a.g;
                        mVar24.a(true);
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
                            mVar21 = this.a.g;
                            mVar21.i();
                            rVar10 = this.a.f;
                            mVar22 = this.a.g;
                            rVar10.b(mVar22.f());
                            return;
                        }
                        return;
                    case 2:
                        if (type == 3) {
                            mVar19 = this.a.g;
                            mVar19.h();
                            rVar9 = this.a.f;
                            mVar20 = this.a.g;
                            rVar9.b(mVar20.f());
                            return;
                        }
                        return;
                    case 3:
                        if (type == 4) {
                            mVar17 = this.a.g;
                            mVar17.j();
                            rVar8 = this.a.f;
                            mVar18 = this.a.g;
                            rVar8.b(mVar18.f());
                            return;
                        }
                        return;
                    case 4:
                        mVar9 = this.a.g;
                        GroupData b = mVar9.f().b();
                        byVar = this.a.h;
                        b.setFlag(byVar.h());
                        mVar10 = this.a.g;
                        GroupData b2 = mVar10.f().b();
                        byVar2 = this.a.h;
                        b2.setPosition(byVar2.e());
                        mVar11 = this.a.g;
                        GroupData b3 = mVar11.f().b();
                        byVar3 = this.a.h;
                        b3.setBusiness(byVar3.f());
                        mVar12 = this.a.g;
                        if ((mVar12.f().b().getFlag() & 1) == 1) {
                            rVar7 = this.a.f;
                            mVar16 = this.a.g;
                            rVar7.a(mVar16.f().h());
                        } else {
                            mVar13 = this.a.g;
                            String position = mVar13.f().b().getPosition();
                            mVar14 = this.a.g;
                            String business = mVar14.f().b().getBusiness();
                            StringBuffer stringBuffer = new StringBuffer();
                            if (position != null) {
                                stringBuffer.append(position);
                            }
                            if (business != null) {
                                stringBuffer.append(business);
                            }
                            rVar6 = this.a.f;
                            mVar15 = this.a.g;
                            rVar6.a(mVar15.f().h(), stringBuffer.toString());
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
                    mVar2 = this.a.g;
                    if (groupId == mVar2.d()) {
                        String userIds = requestRemoveMembersMessage.getUserIds();
                        if (!TextUtils.isEmpty(userIds) && (split = userIds.split(",")) != null && split.length != 0) {
                            String id = TbadkApplication.getCurrentAccountObj().getID();
                            if (!TextUtils.isEmpty(id)) {
                                for (String str : split) {
                                    if (id.equals(str)) {
                                        mVar3 = this.a.g;
                                        mVar3.f().a(false);
                                        mVar4 = this.a.g;
                                        mVar4.a(false);
                                        rVar = this.a.f;
                                        mVar5 = this.a.g;
                                        rVar.a(mVar5.f(), true);
                                        rVar2 = this.a.f;
                                        rVar2.c(str);
                                        this.a.g();
                                        return;
                                    }
                                    mVar6 = this.a.g;
                                    if (mVar6.a(str)) {
                                        rVar3 = this.a.f;
                                        rVar3.c(str);
                                        mVar7 = this.a.g;
                                        GroupData b4 = mVar7.f().b();
                                        if (b4 != null && b4.getMemberNum() > 1) {
                                            b4.setMemberNum(b4.getMemberNum() - 1);
                                        }
                                        rVar4 = this.a.f;
                                        mVar8 = this.a.g;
                                        rVar4.a(mVar8.f());
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
                    mVar = this.a.g;
                    if (mVar.d() == responseDismissGroupMessage.getGroupId()) {
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
