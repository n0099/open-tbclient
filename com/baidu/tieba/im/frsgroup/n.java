package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.GroupLevelInfo;
import com.baidu.tieba.im.message.ResponseGroupLevelMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import java.util.List;
/* loaded from: classes.dex */
final class n extends com.baidu.adp.framework.c.g {
    final /* synthetic */ GroupLevelActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(GroupLevelActivity groupLevelActivity, int i) {
        super(0);
        this.a = groupLevelActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        o oVar;
        o oVar2;
        o oVar3;
        o oVar4;
        o oVar5;
        o oVar6;
        o oVar7;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        oVar = this.a.b;
        oVar.a(false);
        if (socketResponsedMessage2 == null) {
            this.a.showToast(com.baidu.tieba.im.j.neterror);
            return;
        }
        com.baidu.adp.lib.util.f.e("msg:" + socketResponsedMessage2.g());
        if (!(socketResponsedMessage2 instanceof ResponseGroupLevelMessage)) {
            if (socketResponsedMessage2 instanceof ResponseUpgradeMemberGroupMessage) {
                ResponseUpgradeMemberGroupMessage responseUpgradeMemberGroupMessage = (ResponseUpgradeMemberGroupMessage) socketResponsedMessage2;
                com.baidu.adp.lib.util.f.e("get upgrade mem group msg:" + responseUpgradeMemberGroupMessage.g() + " err:" + String.valueOf(responseUpgradeMemberGroupMessage.e()));
                if (responseUpgradeMemberGroupMessage.e() == 0) {
                    this.a.a();
                    return;
                } else if (responseUpgradeMemberGroupMessage.e() != 2230110) {
                    this.a.showToast(responseUpgradeMemberGroupMessage.f());
                    return;
                } else {
                    this.a.showToast(responseUpgradeMemberGroupMessage.f());
                    this.a.a();
                    return;
                }
            }
            return;
        }
        ResponseGroupLevelMessage responseGroupLevelMessage = (ResponseGroupLevelMessage) socketResponsedMessage2;
        if (responseGroupLevelMessage.e() != 0) {
            if (responseGroupLevelMessage.e() <= 0) {
                this.a.showToast(com.baidu.tieba.im.j.neterror);
                return;
            } else if (TextUtils.isEmpty(responseGroupLevelMessage.f())) {
                return;
            } else {
                this.a.showToast(responseGroupLevelMessage.f());
                return;
            }
        }
        GroupLevelInfo d = responseGroupLevelMessage.d();
        if (d != null) {
            int grade = d.getGrade();
            List<GroupLevelInfo.LevelInfo> levelInfos = d.getLevelInfos();
            List<GroupLevelInfo.LevelInfo> vipLevelInfos = d.getVipLevelInfos();
            if (levelInfos.size() < 4 || vipLevelInfos.size() < 4) {
                return;
            }
            GroupLevelInfo.LevelInfo levelInfo = d.isMemGroup() ? vipLevelInfos.get(grade) : levelInfos.get(grade);
            int activeDay = d.getActiveDay();
            int thresholdDay = levelInfo.getThresholdDay();
            String intro = levelInfo.getIntro();
            oVar2 = this.a.b;
            oVar2.a(grade, d.isMemGroup());
            oVar3 = this.a.b;
            oVar3.g().setText(intro);
            oVar4 = this.a.b;
            oVar4.a(grade, activeDay, thresholdDay);
            com.baidu.adp.lib.util.f.e("isMemGroup:" + d.isMemGroup() + " ahthor:" + d.isGroupAuthor() + " canCreate:" + d.isCanCreateMember() + " leftNum:" + d.getLeftCreateMemGroup());
            oVar5 = this.a.b;
            oVar5.a(d.isMemGroup(), d.isGroupAuthor(), d.isCanCreateMember(), d.getLeftCreateMemGroup());
            oVar6 = this.a.b;
            TextView[] e = oVar6.e();
            for (int i = 1; i < levelInfos.size(); i++) {
                int maxMemberNum = levelInfos.get(i).getMaxMemberNum();
                if (i <= e.length) {
                    e[i].setText(this.a.getString(com.baidu.tieba.im.j.grouplevel_level_condition, new Object[]{String.valueOf(maxMemberNum)}));
                }
            }
            oVar7 = this.a.b;
            TextView[] f = oVar7.f();
            for (int i2 = 1; i2 < vipLevelInfos.size(); i2++) {
                int maxMemberNum2 = vipLevelInfos.get(i2).getMaxMemberNum();
                if (i2 <= f.length) {
                    f[i2].setText(this.a.getString(com.baidu.tieba.im.j.grouplevel_level_condition, new Object[]{String.valueOf(maxMemberNum2)}));
                }
            }
        }
    }
}
