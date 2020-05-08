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
        aYA();
    }

    private static void aYA() {
        try {
            g aYz = g.aYz();
            aYz.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            aYz.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            aYz.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            aYz.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            aYz.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            aYz.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            aYz.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
