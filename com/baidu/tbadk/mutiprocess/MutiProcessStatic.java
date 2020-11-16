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
        bAK();
    }

    private static void bAK() {
        try {
            g bAJ = g.bAJ();
            bAJ.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            bAJ.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            bAJ.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            bAJ.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            bAJ.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            bAJ.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            bAJ.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
            bAJ.a(ShowReplyInPbEvent.class, new com.baidu.tbadk.mutiprocess.showreplyinpb.a());
            bAJ.a(LocationEvent.class, new com.baidu.tbadk.mutiprocess.location.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
