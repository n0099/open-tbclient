package com.baidu.tieba.im.frsgroup;

import android.widget.TextView;
import com.baidu.tieba.im.data.GroupLevelInfo;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseGroupLevelMessage;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
class l implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupLevelActivity f1567a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(GroupLevelActivity groupLevelActivity) {
        this.f1567a = groupLevelActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        m mVar;
        m mVar2;
        m mVar3;
        m mVar4;
        m mVar5;
        mVar = this.f1567a.b;
        mVar.a(false);
        if (message == null) {
            this.f1567a.b(R.string.neterror);
            return;
        }
        ResponseGroupLevelMessage responseGroupLevelMessage = (ResponseGroupLevelMessage) message;
        if (responseGroupLevelMessage.hasError()) {
            this.f1567a.a(responseGroupLevelMessage.getErrMsg());
            return;
        }
        GroupLevelInfo groupLevelInfo = responseGroupLevelMessage.getGroupLevelInfo();
        if (groupLevelInfo != null) {
            int grade = groupLevelInfo.getGrade();
            List<GroupLevelInfo.LevelInfo> levelInfos = groupLevelInfo.getLevelInfos();
            if (levelInfos.size() >= 4) {
                GroupLevelInfo.LevelInfo levelInfo = levelInfos.get(grade);
                int activeDay = groupLevelInfo.getActiveDay();
                int thresholdDay = levelInfo.getThresholdDay();
                String intro = levelInfo.getIntro();
                mVar2 = this.f1567a.b;
                mVar2.a(grade);
                mVar3 = this.f1567a.b;
                mVar3.f().setText(intro);
                mVar4 = this.f1567a.b;
                mVar4.a(grade, activeDay, thresholdDay);
                for (int i = 1; i < levelInfos.size(); i++) {
                    int maxMemberNum = levelInfos.get(i).getMaxMemberNum();
                    mVar5 = this.f1567a.b;
                    TextView[] e = mVar5.e();
                    if (i <= e.length) {
                        e[i].setText(this.f1567a.getString(R.string.grouplevel_level_condition, new Object[]{String.valueOf(maxMemberNum)}));
                    }
                }
            }
        }
    }
}
