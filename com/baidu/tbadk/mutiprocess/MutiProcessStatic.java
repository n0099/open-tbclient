package com.baidu.tbadk.mutiprocess;

import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mutiprocess.backbaidubox.BackBaiduBoxViewEvent;
import com.baidu.tbadk.mutiprocess.competetask.CompeteTaskEvent;
import com.baidu.tbadk.mutiprocess.history.HistoryEvent;
import com.baidu.tbadk.mutiprocess.location.LocationEvent;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import com.baidu.tbadk.mutiprocess.showreplyinpb.ShowReplyInPbEvent;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
/* loaded from: classes.dex */
public class MutiProcessStatic {
    static {
        bus();
    }

    private static void bus() {
        try {
            g bur = g.bur();
            bur.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            bur.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            bur.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            bur.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            bur.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            bur.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            bur.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
            bur.a(ShowReplyInPbEvent.class, new com.baidu.tbadk.mutiprocess.showreplyinpb.a());
            bur.a(LocationEvent.class, new com.baidu.tbadk.mutiprocess.location.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
