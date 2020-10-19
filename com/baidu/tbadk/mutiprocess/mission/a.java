package com.baidu.tbadk.mutiprocess.mission;

import com.baidu.tbadk.BdToken.c;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.b;
/* loaded from: classes.dex */
public class a implements b<MissionEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mutiprocess.b
    public boolean a(MissionEvent missionEvent) {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return false;
        }
        int i = missionEvent.pageId;
        int i2 = missionEvent.pageType;
        long j = missionEvent.tid;
        String str = missionEvent.actionType;
        if (MissionEvent.MESSAGE_RESUME.equals(str)) {
            c.bbM().o(i, j);
            c.bbM().q(i2, j);
            return true;
        } else if (MissionEvent.MESSAGE_PAUSE.equals(str)) {
            c.bbM().bbX();
            return true;
        } else if (MissionEvent.MESSAGE_TOUCH.equals(str)) {
            c.bbM().bbZ();
            return true;
        } else if (MissionEvent.MESSAGE_ACTIVITY.equals(str)) {
            c.bbM().o(i, j);
            return true;
        } else {
            return true;
        }
    }
}
