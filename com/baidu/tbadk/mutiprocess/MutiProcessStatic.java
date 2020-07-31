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
        bkB();
    }

    private static void bkB() {
        try {
            g bkA = g.bkA();
            bkA.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            bkA.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            bkA.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            bkA.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            bkA.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            bkA.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            bkA.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
