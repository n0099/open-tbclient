package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.GroupLevelInfo;
import com.baidu.tieba.im.message.ResponseGroupLevelMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import java.util.List;
/* loaded from: classes.dex */
class m extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ GroupLevelActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(GroupLevelActivity groupLevelActivity, int i) {
        super(i);
        this.a = groupLevelActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        n nVar;
        GroupLevelInfo.LevelInfo levelInfo;
        n nVar2;
        n nVar3;
        n nVar4;
        n nVar5;
        n nVar6;
        n nVar7;
        nVar = this.a.b;
        nVar.a(false);
        if (socketResponsedMessage == null) {
            this.a.showToast(com.baidu.tieba.x.neterror);
        } else if (socketResponsedMessage instanceof ResponseGroupLevelMessage) {
            ResponseGroupLevelMessage responseGroupLevelMessage = (ResponseGroupLevelMessage) socketResponsedMessage;
            if (responseGroupLevelMessage.getError() != 0) {
                if (responseGroupLevelMessage.getError() > 0) {
                    if (!TextUtils.isEmpty(responseGroupLevelMessage.getErrorString())) {
                        this.a.showToast(responseGroupLevelMessage.getErrorString());
                        return;
                    }
                    return;
                }
                this.a.showToast(com.baidu.tieba.x.neterror);
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
                    nVar2 = this.a.b;
                    nVar2.a(grade, groupLevelInfo.isMemGroup());
                    nVar3 = this.a.b;
                    nVar3.e().setText(intro);
                    nVar4 = this.a.b;
                    nVar4.a(grade, activeDay, thresholdDay);
                    nVar5 = this.a.b;
                    nVar5.a(groupLevelInfo.isMemGroup(), groupLevelInfo.isGroupAuthor(), groupLevelInfo.isCanCreateMember(), groupLevelInfo.getLeftCreateMemGroup());
                    nVar6 = this.a.b;
                    TextView[] c = nVar6.c();
                    for (int i = 1; i < levelInfos.size(); i++) {
                        int maxMemberNum = levelInfos.get(i).getMaxMemberNum();
                        if (i <= c.length) {
                            c[i].setText(this.a.getString(com.baidu.tieba.x.grouplevel_level_condition, new Object[]{String.valueOf(maxMemberNum)}));
                        }
                    }
                    nVar7 = this.a.b;
                    TextView[] d = nVar7.d();
                    for (int i2 = 1; i2 < vipLevelInfos.size(); i2++) {
                        int maxMemberNum2 = vipLevelInfos.get(i2).getMaxMemberNum();
                        if (i2 <= d.length) {
                            d[i2].setText(this.a.getString(com.baidu.tieba.x.grouplevel_level_condition, new Object[]{String.valueOf(maxMemberNum2)}));
                        }
                    }
                }
            }
        } else if (socketResponsedMessage instanceof ResponseUpgradeMemberGroupMessage) {
            ResponseUpgradeMemberGroupMessage responseUpgradeMemberGroupMessage = (ResponseUpgradeMemberGroupMessage) socketResponsedMessage;
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
