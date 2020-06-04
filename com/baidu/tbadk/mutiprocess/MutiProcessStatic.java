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
        beL();
    }

    private static void beL() {
        try {
            g beK = g.beK();
            beK.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            beK.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            beK.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            beK.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            beK.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            beK.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            beK.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
