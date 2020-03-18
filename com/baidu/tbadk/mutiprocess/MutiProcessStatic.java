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
        aQl();
    }

    private static void aQl() {
        try {
            g aQk = g.aQk();
            aQk.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            aQk.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            aQk.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            aQk.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            aQk.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            aQk.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            aQk.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
