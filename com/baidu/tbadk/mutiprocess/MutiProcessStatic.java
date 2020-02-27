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
        aQe();
    }

    private static void aQe() {
        try {
            g aQd = g.aQd();
            aQd.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            aQd.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            aQd.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            aQd.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            aQd.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            aQd.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            aQd.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
