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
        aQh();
    }

    private static void aQh() {
        try {
            g aQg = g.aQg();
            aQg.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            aQg.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            aQg.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            aQg.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            aQg.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            aQg.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            aQg.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
