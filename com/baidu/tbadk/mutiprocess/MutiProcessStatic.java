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
        aYC();
    }

    private static void aYC() {
        try {
            g aYB = g.aYB();
            aYB.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            aYB.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            aYB.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            aYB.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            aYB.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            aYB.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            aYB.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
