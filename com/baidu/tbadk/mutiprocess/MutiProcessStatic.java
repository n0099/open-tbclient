package com.baidu.tbadk.mutiprocess;

import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mutiprocess.backbaidubox.BackBaiduBoxViewEvent;
import com.baidu.tbadk.mutiprocess.competetask.CompeteTaskEvent;
import com.baidu.tbadk.mutiprocess.history.HistoryEvent;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
/* loaded from: classes.dex */
public class MutiProcessStatic {
    static {
        bgQ();
    }

    private static void bgQ() {
        try {
            g bgP = g.bgP();
            bgP.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            bgP.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            bgP.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            bgP.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            bgP.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            bgP.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            bgP.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
