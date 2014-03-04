package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tieba.im.data.GroupLevelInfo;
import com.baidu.tieba.im.message.cb;
import com.baidu.tieba.im.message.cy;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
final class l implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ GroupLevelActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(GroupLevelActivity groupLevelActivity) {
        this.a = groupLevelActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(com.baidu.tieba.im.message.s sVar) {
        m mVar;
        GroupLevelInfo.LevelInfo levelInfo;
        m mVar2;
        m mVar3;
        m mVar4;
        m mVar5;
        m mVar6;
        m mVar7;
        mVar = this.a.b;
        mVar.a(false);
        if (sVar == null) {
            this.a.showToast(R.string.neterror);
            return;
        }
        com.baidu.adp.lib.util.e.e("msg:" + sVar.v());
        if (sVar instanceof cb) {
            cb cbVar = (cb) sVar;
            if (cbVar.l()) {
                if (cbVar.m() > 0) {
                    if (!TextUtils.isEmpty(cbVar.n())) {
                        this.a.showToast(cbVar.n());
                        return;
                    }
                    return;
                }
                this.a.showToast(R.string.neterror);
                return;
            }
            GroupLevelInfo a = cbVar.a();
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
                    mVar2 = this.a.b;
                    mVar2.a(grade, a.isMemGroup());
                    mVar3 = this.a.b;
                    mVar3.g().setText(intro);
                    mVar4 = this.a.b;
                    mVar4.a(grade, activeDay, thresholdDay);
                    com.baidu.adp.lib.util.e.e("isMemGroup:" + a.isMemGroup() + " ahthor:" + a.isGroupAuthor() + " canCreate:" + a.isCanCreateMember() + " leftNum:" + a.getLeftCreateMemGroup());
                    mVar5 = this.a.b;
                    mVar5.a(a.isMemGroup(), a.isGroupAuthor(), a.isCanCreateMember(), a.getLeftCreateMemGroup());
                    mVar6 = this.a.b;
                    TextView[] e = mVar6.e();
                    for (int i = 1; i < levelInfos.size(); i++) {
                        int maxMemberNum = levelInfos.get(i).getMaxMemberNum();
                        if (i <= e.length) {
                            e[i].setText(this.a.getString(R.string.grouplevel_level_condition, new Object[]{String.valueOf(maxMemberNum)}));
                        }
                    }
                    mVar7 = this.a.b;
                    TextView[] f = mVar7.f();
                    for (int i2 = 1; i2 < vipLevelInfos.size(); i2++) {
                        int maxMemberNum2 = vipLevelInfos.get(i2).getMaxMemberNum();
                        if (i2 <= f.length) {
                            f[i2].setText(this.a.getString(R.string.grouplevel_level_condition, new Object[]{String.valueOf(maxMemberNum2)}));
                        }
                    }
                }
            }
        } else if (sVar instanceof cy) {
            cy cyVar = (cy) sVar;
            com.baidu.adp.lib.util.e.e("get upgrade mem group msg:" + cyVar.v() + " err:" + String.valueOf(cyVar.m()));
            if (!cyVar.l()) {
                this.a.a();
            } else if (cyVar.m() == 2230110) {
                this.a.showToast(cyVar.n());
                this.a.a();
            } else {
                this.a.showToast(cyVar.n());
            }
        }
    }
}
