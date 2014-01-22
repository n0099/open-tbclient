package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tieba.im.data.GroupLevelInfo;
import com.baidu.tieba.im.message.bs;
import com.baidu.tieba.im.message.cp;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ GroupLevelActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(GroupLevelActivity groupLevelActivity) {
        this.a = groupLevelActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
        k kVar;
        GroupLevelInfo.LevelInfo levelInfo;
        k kVar2;
        k kVar3;
        k kVar4;
        k kVar5;
        k kVar6;
        k kVar7;
        kVar = this.a.b;
        kVar.a(false);
        if (qVar == null) {
            this.a.showToast(R.string.neterror);
            return;
        }
        com.baidu.adp.lib.g.e.d("msg:" + qVar.w());
        if (qVar instanceof bs) {
            bs bsVar = (bs) qVar;
            if (bsVar.k()) {
                if (bsVar.l() > 0) {
                    if (!TextUtils.isEmpty(bsVar.m())) {
                        this.a.showToast(bsVar.m());
                        return;
                    }
                    return;
                }
                this.a.showToast(R.string.neterror);
                return;
            }
            GroupLevelInfo a = bsVar.a();
            if (a != null) {
                int grade = a.getGrade();
                List<GroupLevelInfo.LevelInfo> levelInfos = a.getLevelInfos();
                List<GroupLevelInfo.LevelInfo> vipLevelInfos = a.getVipLevelInfos();
                if (levelInfos.size() >= 4 && vipLevelInfos.size() >= 4) {
                    if (a.isMemGroup()) {
                        levelInfo = vipLevelInfos.get(grade);
                    } else {
                        levelInfo = levelInfos.get(grade);
                    }
                    int activeDay = a.getActiveDay();
                    int thresholdDay = levelInfo.getThresholdDay();
                    String intro = levelInfo.getIntro();
                    kVar2 = this.a.b;
                    kVar2.a(grade, a.isMemGroup());
                    kVar3 = this.a.b;
                    kVar3.h().setText(intro);
                    kVar4 = this.a.b;
                    kVar4.a(grade, activeDay, thresholdDay);
                    com.baidu.adp.lib.g.e.d("isMemGroup:" + a.isMemGroup() + " ahthor:" + a.isGroupAuthor() + " canCreate:" + a.isCanCreateMember() + " leftNum:" + a.getLeftCreateMemGroup());
                    kVar5 = this.a.b;
                    kVar5.a(a.isMemGroup(), a.isGroupAuthor(), a.isCanCreateMember(), a.getLeftCreateMemGroup());
                    kVar6 = this.a.b;
                    TextView[] f = kVar6.f();
                    for (int i = 1; i < levelInfos.size(); i++) {
                        int maxMemberNum = levelInfos.get(i).getMaxMemberNum();
                        if (i <= f.length) {
                            f[i].setText(this.a.getString(R.string.grouplevel_level_condition, new Object[]{String.valueOf(maxMemberNum)}));
                        }
                    }
                    kVar7 = this.a.b;
                    TextView[] g = kVar7.g();
                    for (int i2 = 1; i2 < vipLevelInfos.size(); i2++) {
                        int maxMemberNum2 = vipLevelInfos.get(i2).getMaxMemberNum();
                        if (i2 <= g.length) {
                            g[i2].setText(this.a.getString(R.string.grouplevel_level_condition, new Object[]{String.valueOf(maxMemberNum2)}));
                        }
                    }
                }
            }
        } else if (qVar instanceof cp) {
            cp cpVar = (cp) qVar;
            com.baidu.adp.lib.g.e.d("get upgrade mem group msg:" + cpVar.w() + " err:" + String.valueOf(cpVar.l()));
            if (!cpVar.k()) {
                this.a.a();
            } else if (cpVar.l() == 2230110) {
                this.a.showToast(cpVar.m());
                this.a.a();
            } else {
                this.a.showToast(cpVar.m());
            }
        }
    }
}
