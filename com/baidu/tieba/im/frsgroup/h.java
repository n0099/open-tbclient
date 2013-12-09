package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.tieba.im.data.GroupLevelInfo;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseGroupLevelMessage;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
class h implements com.baidu.tieba.im.messageCenter.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupLevelActivity f1710a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(GroupLevelActivity groupLevelActivity) {
        this.f1710a = groupLevelActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        i iVar;
        i iVar2;
        i iVar3;
        i iVar4;
        i iVar5;
        iVar = this.f1710a.b;
        iVar.a(false);
        if (message == null) {
            this.f1710a.showToast(R.string.neterror);
            return;
        }
        ResponseGroupLevelMessage responseGroupLevelMessage = (ResponseGroupLevelMessage) message;
        if (responseGroupLevelMessage.hasError()) {
            if (responseGroupLevelMessage.getErrNo() > 0) {
                if (!TextUtils.isEmpty(responseGroupLevelMessage.getErrMsg())) {
                    this.f1710a.showToast(responseGroupLevelMessage.getErrMsg());
                    return;
                }
                return;
            }
            this.f1710a.showToast(R.string.neterror);
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
                iVar2 = this.f1710a.b;
                iVar2.b(grade);
                iVar3 = this.f1710a.b;
                iVar3.f().setText(intro);
                iVar4 = this.f1710a.b;
                iVar4.a(grade, activeDay, thresholdDay);
                for (int i = 1; i < levelInfos.size(); i++) {
                    int maxMemberNum = levelInfos.get(i).getMaxMemberNum();
                    iVar5 = this.f1710a.b;
                    TextView[] e = iVar5.e();
                    if (i <= e.length) {
                        e[i].setText(this.f1710a.getString(R.string.grouplevel_level_condition, new Object[]{String.valueOf(maxMemberNum)}));
                    }
                }
            }
        }
    }
}
