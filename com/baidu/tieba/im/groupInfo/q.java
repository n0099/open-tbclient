package com.baidu.tieba.im.groupInfo;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.live.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupMessage;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseDelGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import com.baidu.tieba.im.model.GroupInfoModel;
import com.baidu.tieba.im.model.UpdateGroupModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ GroupInfoActivity ban;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(GroupInfoActivity groupInfoActivity) {
        super(0);
        this.ban = groupInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        GroupInfoModel groupInfoModel;
        Message<?> orginalMessage;
        GroupInfoModel groupInfoModel2;
        String[] split;
        GroupInfoModel groupInfoModel3;
        GroupInfoModel groupInfoModel4;
        s sVar;
        s sVar2;
        GroupInfoModel groupInfoModel5;
        s sVar3;
        GroupInfoModel groupInfoModel6;
        s sVar4;
        GroupInfoModel groupInfoModel7;
        s sVar5;
        int i;
        GroupInfoModel groupInfoModel8;
        UpdateGroupModel updateGroupModel;
        GroupInfoModel groupInfoModel9;
        UpdateGroupModel updateGroupModel2;
        GroupInfoModel groupInfoModel10;
        UpdateGroupModel updateGroupModel3;
        GroupInfoModel groupInfoModel11;
        GroupInfoModel groupInfoModel12;
        GroupInfoModel groupInfoModel13;
        s sVar6;
        GroupInfoModel groupInfoModel14;
        s sVar7;
        GroupInfoModel groupInfoModel15;
        GroupInfoModel groupInfoModel16;
        s sVar8;
        GroupInfoModel groupInfoModel17;
        GroupInfoModel groupInfoModel18;
        s sVar9;
        GroupInfoModel groupInfoModel19;
        GroupInfoModel groupInfoModel20;
        s sVar10;
        GroupInfoModel groupInfoModel21;
        Message<?> orginalMessage2;
        GroupInfoModel groupInfoModel22;
        s sVar11;
        GroupInfoModel groupInfoModel23;
        s sVar12;
        GroupInfoModel groupInfoModel24;
        GroupInfoModel groupInfoModel25;
        s sVar13;
        s sVar14;
        GroupInfoModel groupInfoModel26;
        s sVar15;
        if (socketResponsedMessage == null) {
            sVar15 = this.ban.bai;
            sVar15.OT();
            this.ban.showToast(com.baidu.tieba.y.neterror);
        } else if (socketResponsedMessage.getCmd() == 103004) {
            sVar12 = this.ban.bai;
            sVar12.OT();
            ResponseGroupInfoMessage responseGroupInfoMessage = (ResponseGroupInfoMessage) socketResponsedMessage;
            groupInfoModel24 = this.ban.baj;
            if (groupInfoModel24.getSendMsg() == responseGroupInfoMessage.getOrginalMessage()) {
                if (responseGroupInfoMessage.getError() == 2230101) {
                    this.ban.showToast(responseGroupInfoMessage.getErrorString(), false);
                    this.ban.finish();
                } else if (responseGroupInfoMessage.getData() != null && responseGroupInfoMessage.getError() == 0) {
                    this.ban.De();
                    groupInfoModel25 = this.ban.baj;
                    groupInfoModel25.setData(responseGroupInfoMessage.getData());
                    if (responseGroupInfoMessage == null || responseGroupInfoMessage.getData().Qc()) {
                        sVar13 = this.ban.bai;
                        sVar13.a(responseGroupInfoMessage.getData(), false);
                        return;
                    }
                    sVar14 = this.ban.bai;
                    sVar14.OU();
                    z Pb = z.Pb();
                    String currentAccount = TbadkApplication.getCurrentAccount();
                    groupInfoModel26 = this.ban.baj;
                    Pb.a(currentAccount, String.valueOf(groupInfoModel26.getGroupId()), TbConfig.USE_TIME_INTERVAL, new r(this, responseGroupInfoMessage));
                } else {
                    this.ban.showToast(com.baidu.tieba.y.neterror);
                }
            }
        } else if (socketResponsedMessage.getCmd() == 103110) {
            if (socketResponsedMessage instanceof ResponseJoinGroupMessage) {
                ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage;
                if (responseJoinGroupMessage.getError() == 0 && (orginalMessage2 = responseJoinGroupMessage.getOrginalMessage()) != null && (orginalMessage2 instanceof RequestJoinGroupMessage)) {
                    groupInfoModel22 = this.ban.baj;
                    if (((RequestJoinGroupMessage) orginalMessage2).getGroupId() == groupInfoModel22.getGroupId()) {
                        sVar11 = this.ban.bai;
                        sVar11.Pa();
                        groupInfoModel23 = this.ban.baj;
                        groupInfoModel23.setHasRecentJoin(true);
                        this.ban.OB();
                    }
                }
            }
        } else if (socketResponsedMessage.getCmd() == 103102) {
            sVar5 = this.ban.bai;
            sVar5.OT();
            if (socketResponsedMessage.getError() != 0) {
                this.ban.showToast(com.baidu.tieba.y.neterror);
                return;
            }
            ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) socketResponsedMessage;
            if (responseUpdateGroupMessage.getError() != 0) {
                this.ban.showToast(responseUpdateGroupMessage.getErrorString());
            } else if (responseUpdateGroupMessage.getOrginalMessage() instanceof RequestUpdateGroupMessage) {
                int type = ((RequestUpdateGroupMessage) responseUpdateGroupMessage.getOrginalMessage()).getType();
                i = this.ban.type;
                switch (i) {
                    case 1:
                        if (type == 3) {
                            groupInfoModel20 = this.ban.baj;
                            groupInfoModel20.addPhotoData();
                            sVar10 = this.ban.bai;
                            groupInfoModel21 = this.ban.baj;
                            sVar10.a(groupInfoModel21.getData());
                            return;
                        }
                        return;
                    case 2:
                        if (type == 3) {
                            groupInfoModel18 = this.ban.baj;
                            groupInfoModel18.delePhotoData();
                            sVar9 = this.ban.bai;
                            groupInfoModel19 = this.ban.baj;
                            sVar9.a(groupInfoModel19.getData());
                            return;
                        }
                        return;
                    case 3:
                        if (type == 4) {
                            groupInfoModel16 = this.ban.baj;
                            groupInfoModel16.updataPortraitData();
                            sVar8 = this.ban.bai;
                            groupInfoModel17 = this.ban.baj;
                            sVar8.a(groupInfoModel17.getData());
                            return;
                        }
                        return;
                    case 4:
                        groupInfoModel8 = this.ban.baj;
                        GroupData group = groupInfoModel8.getData().getGroup();
                        updateGroupModel = this.ban.aOj;
                        group.setFlag(updateGroupModel.getFlag());
                        groupInfoModel9 = this.ban.baj;
                        GroupData group2 = groupInfoModel9.getData().getGroup();
                        updateGroupModel2 = this.ban.aOj;
                        group2.setPosition(updateGroupModel2.getPosition());
                        groupInfoModel10 = this.ban.baj;
                        GroupData group3 = groupInfoModel10.getData().getGroup();
                        updateGroupModel3 = this.ban.aOj;
                        group3.setBusiness(updateGroupModel3.getBusiness());
                        groupInfoModel11 = this.ban.baj;
                        if ((groupInfoModel11.getData().getGroup().getFlag() & 1) == 1) {
                            sVar7 = this.ban.bai;
                            groupInfoModel15 = this.ban.baj;
                            sVar7.dd(groupInfoModel15.getData().Qd());
                        } else {
                            groupInfoModel12 = this.ban.baj;
                            String position = groupInfoModel12.getData().getGroup().getPosition();
                            groupInfoModel13 = this.ban.baj;
                            String business = groupInfoModel13.getData().getGroup().getBusiness();
                            StringBuffer stringBuffer = new StringBuffer();
                            if (position != null) {
                                stringBuffer.append(position);
                            }
                            if (business != null) {
                                stringBuffer.append(business);
                            }
                            sVar6 = this.ban.bai;
                            groupInfoModel14 = this.ban.baj;
                            sVar6.e(groupInfoModel14.getData().Qd(), stringBuffer.toString());
                        }
                        this.ban.showToast(com.baidu.tieba.y.group_address_success);
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
                    groupInfoModel2 = this.ban.baj;
                    if (groupId == groupInfoModel2.getGroupId()) {
                        String userIds = requestRemoveMembersMessage.getUserIds();
                        if (!TextUtils.isEmpty(userIds) && (split = userIds.split(",")) != null && split.length != 0) {
                            String id = TbadkApplication.getCurrentAccountObj().getID();
                            if (!TextUtils.isEmpty(id)) {
                                for (String str : split) {
                                    if (id.equals(str)) {
                                        groupInfoModel3 = this.ban.baj;
                                        com.baidu.tieba.im.message.i data = groupInfoModel3.getData();
                                        data.fW(data.Qb() + 1);
                                        data.dj(false);
                                        groupInfoModel4 = this.ban.baj;
                                        groupInfoModel4.setHasRecentJoin(false);
                                        sVar = this.ban.bai;
                                        sVar.a(data, true);
                                        sVar2 = this.ban.bai;
                                        sVar2.gk(str);
                                        this.ban.OB();
                                        return;
                                    }
                                    groupInfoModel5 = this.ban.baj;
                                    if (groupInfoModel5.removeMemberByUid(str)) {
                                        sVar3 = this.ban.bai;
                                        sVar3.gk(str);
                                        groupInfoModel6 = this.ban.baj;
                                        GroupData group4 = groupInfoModel6.getData().getGroup();
                                        if (group4 != null && group4.getMemberNum() > 1) {
                                            group4.setMemberNum(group4.getMemberNum() - 1);
                                        }
                                        sVar4 = this.ban.bai;
                                        groupInfoModel7 = this.ban.baj;
                                        sVar4.setData(groupInfoModel7.getData());
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
                    groupInfoModel = this.ban.baj;
                    if (groupInfoModel.getGroupId() == responseDismissGroupMessage.getGroupId()) {
                        this.ban.finish();
                    }
                }
            }
        } else if (socketResponsedMessage.getCmd() == 103105) {
            if (socketResponsedMessage instanceof ResponseUpgradeMemberGroupMessage) {
                ResponseUpgradeMemberGroupMessage responseUpgradeMemberGroupMessage = (ResponseUpgradeMemberGroupMessage) socketResponsedMessage;
                if (responseUpgradeMemberGroupMessage.getError() == 0 || responseUpgradeMemberGroupMessage.getError() == 2230110) {
                    this.ban.startLoading();
                }
            }
        } else if (socketResponsedMessage.getCmd() == 103120) {
            if (socketResponsedMessage instanceof ResponseCreateGroupActivityMessage) {
                this.ban.startLoading();
            }
        } else if (socketResponsedMessage.getCmd() == 103121 && (socketResponsedMessage instanceof ResponseDelGroupActivityMessage)) {
            this.ban.startLoading();
        }
    }
}
