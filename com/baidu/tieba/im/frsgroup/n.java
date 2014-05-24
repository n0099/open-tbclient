package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.data.GroupLevelInfo;
import com.baidu.tieba.im.message.ResponseGroupLevelMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import java.util.List;
/* loaded from: classes.dex */
class n extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ GroupLevelActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(GroupLevelActivity groupLevelActivity, int i) {
        super(i);
        this.a = groupLevelActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        o oVar;
        GroupLevelInfo.LevelInfo levelInfo;
        o oVar2;
        o oVar3;
        o oVar4;
        o oVar5;
        o oVar6;
        o oVar7;
        oVar = this.a.b;
        oVar.a(false);
        if (socketResponsedMessage == null) {
            this.a.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        BdLog.d("msg:" + socketResponsedMessage.getCmd());
        if (socketResponsedMessage instanceof ResponseGroupLevelMessage) {
            ResponseGroupLevelMessage responseGroupLevelMessage = (ResponseGroupLevelMessage) socketResponsedMessage;
            if (responseGroupLevelMessage.getError() != 0) {
                if (responseGroupLevelMessage.getError() > 0) {
                    if (!TextUtils.isEmpty(responseGroupLevelMessage.getErrorString())) {
                        this.a.showToast(responseGroupLevelMessage.getErrorString());
                        return;
                    }
                    return;
                }
                this.a.showToast(com.baidu.tieba.y.neterror);
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
                    oVar2 = this.a.b;
                    oVar2.a(grade, groupLevelInfo.isMemGroup());
                    oVar3 = this.a.b;
                    oVar3.e().setText(intro);
                    oVar4 = this.a.b;
                    oVar4.a(grade, activeDay, thresholdDay);
                    BdLog.d("isMemGroup:" + groupLevelInfo.isMemGroup() + " ahthor:" + groupLevelInfo.isGroupAuthor() + " canCreate:" + groupLevelInfo.isCanCreateMember() + " leftNum:" + groupLevelInfo.getLeftCreateMemGroup());
                    oVar5 = this.a.b;
                    oVar5.a(groupLevelInfo.isMemGroup(), groupLevelInfo.isGroupAuthor(), groupLevelInfo.isCanCreateMember(), groupLevelInfo.getLeftCreateMemGroup());
                    oVar6 = this.a.b;
                    TextView[] c = oVar6.c();
                    for (int i = 1; i < levelInfos.size(); i++) {
                        int maxMemberNum = levelInfos.get(i).getMaxMemberNum();
                        if (i <= c.length) {
                            c[i].setText(this.a.getString(com.baidu.tieba.y.grouplevel_level_condition, new Object[]{String.valueOf(maxMemberNum)}));
                        }
                    }
                    oVar7 = this.a.b;
                    TextView[] d = oVar7.d();
                    for (int i2 = 1; i2 < vipLevelInfos.size(); i2++) {
                        int maxMemberNum2 = vipLevelInfos.get(i2).getMaxMemberNum();
                        if (i2 <= d.length) {
                            d[i2].setText(this.a.getString(com.baidu.tieba.y.grouplevel_level_condition, new Object[]{String.valueOf(maxMemberNum2)}));
                        }
                    }
                }
            }
        } else if (socketResponsedMessage instanceof ResponseUpgradeMemberGroupMessage) {
            ResponseUpgradeMemberGroupMessage responseUpgradeMemberGroupMessage = (ResponseUpgradeMemberGroupMessage) socketResponsedMessage;
            BdLog.d("get upgrade mem group msg:" + responseUpgradeMemberGroupMessage.getCmd() + " err:" + String.valueOf(responseUpgradeMemberGroupMessage.getError()));
            if (responseUpgradeMemberGroupMessage.getError() == 0) {
                this.a.a();
            } else if (responseUpgradeMemberGroupMessage.getError() == 2230110) {
                this.a.showToast(responseUpgradeMemberGroupMessage.getErrorString());
                this.a.a();
            } else {
                this.a.showToast(responseUpgradeMemberGroupMessage.getErrorString());
            }
        }
    }
}
