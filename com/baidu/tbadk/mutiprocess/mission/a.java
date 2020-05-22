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
            c.aLi().m(i, j);
            c.aLi().o(i2, j);
            return true;
        } else if (MissionEvent.MESSAGE_PAUSE.equals(str)) {
            c.aLi().aLn();
            return true;
        } else if (MissionEvent.MESSAGE_TOUCH.equals(str)) {
            c.aLi().aLp();
            return true;
        } else if (MissionEvent.MESSAGE_ACTIVITY.equals(str)) {
            c.aLi().m(i, j);
            return true;
        } else {
            return true;
        }
    }
}
