package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tieba.im.data.GroupLevelInfo;
import com.baidu.tieba.im.message.bi;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
class h implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ GroupLevelActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(GroupLevelActivity groupLevelActivity) {
        this.a = groupLevelActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.o oVar) {
        i iVar;
        i iVar2;
        i iVar3;
        i iVar4;
        i iVar5;
        iVar = this.a.b;
        iVar.a(false);
        if (oVar == null) {
            this.a.showToast(R.string.neterror);
            return;
        }
        bi biVar = (bi) oVar;
        if (biVar.i()) {
            if (biVar.j() > 0) {
                if (!TextUtils.isEmpty(biVar.k())) {
                    this.a.showToast(biVar.k());
                    return;
                }
                return;
            }
            this.a.showToast(R.string.neterror);
            return;
        }
        GroupLevelInfo a = biVar.a();
        if (a != null) {
            int grade = a.getGrade();
            List<GroupLevelInfo.LevelInfo> levelInfos = a.getLevelInfos();
            if (levelInfos.size() >= 4) {
                GroupLevelInfo.LevelInfo levelInfo = levelInfos.get(grade);
                int activeDay = a.getActiveDay();
                int thresholdDay = levelInfo.getThresholdDay();
                String intro = levelInfo.getIntro();
                iVar2 = this.a.b;
                iVar2.b(grade);
                iVar3 = this.a.b;
                iVar3.f().setText(intro);
                iVar4 = this.a.b;
                iVar4.a(grade, activeDay, thresholdDay);
                for (int i = 1; i < levelInfos.size(); i++) {
                    int maxMemberNum = levelInfos.get(i).getMaxMemberNum();
                    iVar5 = this.a.b;
                    TextView[] e = iVar5.e();
                    if (i <= e.length) {
                        e[i].setText(this.a.getString(R.string.grouplevel_level_condition, new Object[]{String.valueOf(maxMemberNum)}));
                    }
                }
            }
        }
    }
}
