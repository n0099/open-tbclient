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
        byV();
    }

    private static void byV() {
        try {
            g byU = g.byU();
            byU.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            byU.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            byU.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            byU.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            byU.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            byU.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            byU.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
            byU.a(ShowReplyInPbEvent.class, new com.baidu.tbadk.mutiprocess.showreplyinpb.a());
            byU.a(LocationEvent.class, new com.baidu.tbadk.mutiprocess.location.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
