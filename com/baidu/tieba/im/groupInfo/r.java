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
public class r extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ GroupInfoActivity baC;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(GroupInfoActivity groupInfoActivity) {
        super(0);
        this.baC = groupInfoActivity;
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
        t tVar;
        t tVar2;
        GroupInfoModel groupInfoModel5;
        t tVar3;
        GroupInfoModel groupInfoModel6;
        t tVar4;
        GroupInfoModel groupInfoModel7;
        t tVar5;
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
        t tVar6;
        GroupInfoModel groupInfoModel14;
        t tVar7;
        GroupInfoModel groupInfoModel15;
        GroupInfoModel groupInfoModel16;
        t tVar8;
        GroupInfoModel groupInfoModel17;
        GroupInfoModel groupInfoModel18;
        t tVar9;
        GroupInfoModel groupInfoModel19;
        GroupInfoModel groupInfoModel20;
        t tVar10;
        GroupInfoModel groupInfoModel21;
        Message<?> orginalMessage2;
        GroupInfoModel groupInfoModel22;
        t tVar11;
        GroupInfoModel groupInfoModel23;
        t tVar12;
        GroupInfoModel groupInfoModel24;
        GroupInfoModel groupInfoModel25;
        t tVar13;
        t tVar14;
        GroupInfoModel groupInfoModel26;
        t tVar15;
        if (socketResponsedMessage == null) {
            tVar15 = this.baC.bax;
            tVar15.OW();
            this.baC.showToast(com.baidu.tieba.y.neterror);
        } else if (socketResponsedMessage.getCmd() == 103004) {
            tVar12 = this.baC.bax;
            tVar12.OW();
            ResponseGroupInfoMessage responseGroupInfoMessage = (ResponseGroupInfoMessage) socketResponsedMessage;
            groupInfoModel24 = this.baC.bay;
            if (groupInfoModel24.getSendMsg() == responseGroupInfoMessage.getOrginalMessage()) {
                if (responseGroupInfoMessage.getError() == 2230101) {
                    this.baC.showToast(responseGroupInfoMessage.getErrorString(), false);
                    this.baC.finish();
                } else if (responseGroupInfoMessage.getData() != null && responseGroupInfoMessage.getError() == 0) {
                    this.baC.Dg();
                    groupInfoModel25 = this.baC.bay;
                    groupInfoModel25.setData(responseGroupInfoMessage.getData());
                    if (responseGroupInfoMessage == null || responseGroupInfoMessage.getData().Qf()) {
                        tVar13 = this.baC.bax;
                        tVar13.a(responseGroupInfoMessage.getData(), false);
                        return;
                    }
                    tVar14 = this.baC.bax;
                    tVar14.OX();
                    aa Pe = aa.Pe();
                    String currentAccount = TbadkApplication.getCurrentAccount();
                    groupInfoModel26 = this.baC.bay;
                    Pe.a(currentAccount, String.valueOf(groupInfoModel26.getGroupId()), TbConfig.USE_TIME_INTERVAL, new s(this, responseGroupInfoMessage));
                } else {
                    this.baC.showToast(com.baidu.tieba.y.neterror);
                }
            }
        } else if (socketResponsedMessage.getCmd() == 103110) {
            if (socketResponsedMessage instanceof ResponseJoinGroupMessage) {
                ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage;
                if (responseJoinGroupMessage.getError() == 0 && (orginalMessage2 = responseJoinGroupMessage.getOrginalMessage()) != null && (orginalMessage2 instanceof RequestJoinGroupMessage)) {
                    groupInfoModel22 = this.baC.bay;
                    if (((RequestJoinGroupMessage) orginalMessage2).getGroupId() == groupInfoModel22.getGroupId()) {
                        tVar11 = this.baC.bax;
                        tVar11.Pd();
                        groupInfoModel23 = this.baC.bay;
                        groupInfoModel23.setHasRecentJoin(true);
                        this.baC.OE();
                    }
                }
            }
        } else if (socketResponsedMessage.getCmd() == 103102) {
            tVar5 = this.baC.bax;
            tVar5.OW();
            if (socketResponsedMessage.getError() != 0) {
                this.baC.showToast(com.baidu.tieba.y.neterror);
                return;
            }
            ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) socketResponsedMessage;
            if (responseUpdateGroupMessage.getError() != 0) {
                this.baC.showToast(responseUpdateGroupMessage.getErrorString());
            } else if (responseUpdateGroupMessage.getOrginalMessage() instanceof RequestUpdateGroupMessage) {
                int type = ((RequestUpdateGroupMessage) responseUpdateGroupMessage.getOrginalMessage()).getType();
                i = this.baC.type;
                switch (i) {
                    case 1:
                        if (type == 3) {
                            groupInfoModel20 = this.baC.bay;
                            groupInfoModel20.addPhotoData();
                            tVar10 = this.baC.bax;
                            groupInfoModel21 = this.baC.bay;
                            tVar10.a(groupInfoModel21.getData());
                            return;
                        }
                        return;
                    case 2:
                        if (type == 3) {
                            groupInfoModel18 = this.baC.bay;
                            groupInfoModel18.delePhotoData();
                            tVar9 = this.baC.bax;
                            groupInfoModel19 = this.baC.bay;
                            tVar9.a(groupInfoModel19.getData());
                            return;
                        }
                        return;
                    case 3:
                        if (type == 4) {
                            groupInfoModel16 = this.baC.bay;
                            groupInfoModel16.updataPortraitData();
                            tVar8 = this.baC.bax;
                            groupInfoModel17 = this.baC.bay;
                            tVar8.a(groupInfoModel17.getData());
                            return;
                        }
                        return;
                    case 4:
                        groupInfoModel8 = this.baC.bay;
                        GroupData group = groupInfoModel8.getData().getGroup();
                        updateGroupModel = this.baC.aOx;
                        group.setFlag(updateGroupModel.getFlag());
                        groupInfoModel9 = this.baC.bay;
                        GroupData group2 = groupInfoModel9.getData().getGroup();
                        updateGroupModel2 = this.baC.aOx;
                        group2.setPosition(updateGroupModel2.getPosition());
                        groupInfoModel10 = this.baC.bay;
                        GroupData group3 = groupInfoModel10.getData().getGroup();
                        updateGroupModel3 = this.baC.aOx;
                        group3.setBusiness(updateGroupModel3.getBusiness());
                        groupInfoModel11 = this.baC.bay;
                        if ((groupInfoModel11.getData().getGroup().getFlag() & 1) == 1) {
                            tVar7 = this.baC.bax;
                            groupInfoModel15 = this.baC.bay;
                            tVar7.dd(groupInfoModel15.getData().Qg());
                        } else {
                            groupInfoModel12 = this.baC.bay;
                            String position = groupInfoModel12.getData().getGroup().getPosition();
                            groupInfoModel13 = this.baC.bay;
                            String business = groupInfoModel13.getData().getGroup().getBusiness();
                            StringBuffer stringBuffer = new StringBuffer();
                            if (position != null) {
                                stringBuffer.append(position);
                            }
                            if (business != null) {
                                stringBuffer.append(business);
                            }
                            tVar6 = this.baC.bax;
                            groupInfoModel14 = this.baC.bay;
                            tVar6.e(groupInfoModel14.getData().Qg(), stringBuffer.toString());
                        }
                        this.baC.showToast(com.baidu.tieba.y.group_address_success);
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
                    groupInfoModel2 = this.baC.bay;
                    if (groupId == groupInfoModel2.getGroupId()) {
                        String userIds = requestRemoveMembersMessage.getUserIds();
                        if (!TextUtils.isEmpty(userIds) && (split = userIds.split(",")) != null && split.length != 0) {
                            String id = TbadkApplication.getCurrentAccountObj().getID();
                            if (!TextUtils.isEmpty(id)) {
                                for (String str : split) {
                                    if (id.equals(str)) {
                                        groupInfoModel3 = this.baC.bay;
                                        com.baidu.tieba.im.message.i data = groupInfoModel3.getData();
                                        data.fW(data.Qe() + 1);
                                        data.dj(false);
                                        groupInfoModel4 = this.baC.bay;
                                        groupInfoModel4.setHasRecentJoin(false);
                                        tVar = this.baC.bax;
                                        tVar.a(data, true);
                                        tVar2 = this.baC.bax;
                                        tVar2.gk(str);
                                        this.baC.OE();
                                        return;
                                    }
                                    groupInfoModel5 = this.baC.bay;
                                    if (groupInfoModel5.removeMemberByUid(str)) {
                                        tVar3 = this.baC.bax;
                                        tVar3.gk(str);
                                        groupInfoModel6 = this.baC.bay;
                                        GroupData group4 = groupInfoModel6.getData().getGroup();
                                        if (group4 != null && group4.getMemberNum() > 1) {
                                            group4.setMemberNum(group4.getMemberNum() - 1);
                                        }
                                        tVar4 = this.baC.bax;
                                        groupInfoModel7 = this.baC.bay;
                                        tVar4.setData(groupInfoModel7.getData());
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
                    groupInfoModel = this.baC.bay;
                    if (groupInfoModel.getGroupId() == responseDismissGroupMessage.getGroupId()) {
                        this.baC.finish();
                    }
                }
            }
        } else if (socketResponsedMessage.getCmd() == 103105) {
            if (socketResponsedMessage instanceof ResponseUpgradeMemberGroupMessage) {
                ResponseUpgradeMemberGroupMessage responseUpgradeMemberGroupMessage = (ResponseUpgradeMemberGroupMessage) socketResponsedMessage;
                if (responseUpgradeMemberGroupMessage.getError() == 0 || responseUpgradeMemberGroupMessage.getError() == 2230110) {
                    this.baC.startLoading();
                }
            }
        } else if (socketResponsedMessage.getCmd() == 103120) {
            if (socketResponsedMessage instanceof ResponseCreateGroupActivityMessage) {
                this.baC.startLoading();
            }
        } else if (socketResponsedMessage.getCmd() == 103121 && (socketResponsedMessage instanceof ResponseDelGroupActivityMessage)) {
            this.baC.startLoading();
        }
    }
}
