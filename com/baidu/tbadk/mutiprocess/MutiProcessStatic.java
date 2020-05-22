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
        beK();
    }

    private static void beK() {
        try {
            g beJ = g.beJ();
            beJ.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            beJ.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            beJ.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            beJ.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            beJ.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            beJ.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            beJ.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
