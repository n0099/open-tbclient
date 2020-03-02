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
        aQg();
    }

    private static void aQg() {
        try {
            g aQf = g.aQf();
            aQf.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            aQf.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            aQf.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            aQf.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            aQf.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            aQf.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            aQf.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
