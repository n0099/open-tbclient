package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.GroupLevelInfo;
import com.baidu.tieba.im.message.ResponseGroupLevelMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import java.util.List;
/* loaded from: classes.dex */
class p extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ GroupLevelActivity aXB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(GroupLevelActivity groupLevelActivity, int i) {
        super(i);
        this.aXB = groupLevelActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        q qVar;
        GroupLevelInfo.LevelInfo levelInfo;
        q qVar2;
        q qVar3;
        q qVar4;
        q qVar5;
        q qVar6;
        q qVar7;
        qVar = this.aXB.aXx;
        qVar.cX(false);
        if (socketResponsedMessage == null) {
            this.aXB.showToast(com.baidu.tieba.y.neterror);
        } else if (socketResponsedMessage instanceof ResponseGroupLevelMessage) {
            ResponseGroupLevelMessage responseGroupLevelMessage = (ResponseGroupLevelMessage) socketResponsedMessage;
            if (responseGroupLevelMessage.getError() != 0) {
                if (responseGroupLevelMessage.getError() > 0) {
                    if (!TextUtils.isEmpty(responseGroupLevelMessage.getErrorString())) {
                        this.aXB.showToast(responseGroupLevelMessage.getErrorString());
                        return;
                    }
                    return;
                }
                this.aXB.showToast(com.baidu.tieba.y.neterror);
                return;
            }
            GroupLevelInfo groupLevelInfo = responseGroupLevelMessage.getGroupLevelInfo();
            if (groupLevelInfo != null) {
                int grade = groupLevelInfo.getGrade();
                List<GroupLevelInfo.LevelInfo> levelInfos = groupLevelInfo.getLevelInfos();
                List<GroupLevelInfo.LevelInfo> vipLevelInfos = groupLevelInfo.getVipLevelInfos();
                if (levelInfos.size() >= 4 && vipLevelInfos.size() >= 4) {
                    if (groupLevelInfo.isMemGroup()) {
                        levelInfo = vipLevelInfos.get(grade);
                    } else {
                        levelInfo = levelInfos.get(grade);
                    }
                    int activeDay = groupLevelInfo.getActiveDay();
                    int thresholdDay = levelInfo.getThresholdDay();
                    String intro = levelInfo.getIntro();
                    qVar2 = this.aXB.aXx;
                    qVar2.r(grade, groupLevelInfo.isMemGroup());
                    qVar3 = this.aXB.aXx;
                    qVar3.NE().setText(intro);
                    qVar4 = this.aXB.aXx;
                    qVar4.o(grade, activeDay, thresholdDay);
                    qVar5 = this.aXB.aXx;
                    qVar5.a(groupLevelInfo.isMemGroup(), groupLevelInfo.isGroupAuthor(), groupLevelInfo.isCanCreateMember(), groupLevelInfo.getLeftCreateMemGroup());
                    qVar6 = this.aXB.aXx;
                    TextView[] NC = qVar6.NC();
                    for (int i = 1; i < levelInfos.size(); i++) {
                        int maxMemberNum = levelInfos.get(i).getMaxMemberNum();
                        if (i <= NC.length) {
                            NC[i].setText(this.aXB.getString(com.baidu.tieba.y.grouplevel_level_condition, new Object[]{String.valueOf(maxMemberNum)}));
                        }
                    }
                    qVar7 = this.aXB.aXx;
                    TextView[] ND = qVar7.ND();
                    for (int i2 = 1; i2 < vipLevelInfos.size(); i2++) {
                        int maxMemberNum2 = vipLevelInfos.get(i2).getMaxMemberNum();
                        if (i2 <= ND.length) {
                            ND[i2].setText(this.aXB.getString(com.baidu.tieba.y.grouplevel_level_condition, new Object[]{String.valueOf(maxMemberNum2)}));
                        }
                    }
                }
            }
        } else if (socketResponsedMessage instanceof ResponseUpgradeMemberGroupMessage) {
            ResponseUpgradeMemberGroupMessage responseUpgradeMemberGroupMessage = (ResponseUpgradeMemberGroupMessage) socketResponsedMessage;
            if (responseUpgradeMemberGroupMessage.getError() == 0) {
                this.aXB.startLoading();
            } else if (responseUpgradeMemberGroupMessage.getError() == 2230110) {
                this.aXB.showToast(responseUpgradeMemberGroupMessage.getErrorString());
                this.aXB.startLoading();
            } else {
                this.aXB.showToast(responseUpgradeMemberGroupMessage.getErrorString());
            }
        }
    }
}
