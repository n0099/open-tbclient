package com.baidu.tbadk.mutiprocess;

import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mutiprocess.backbaidubox.BackBaiduBoxViewEvent;
import com.baidu.tbadk.mutiprocess.competetask.CompeteTaskEvent;
import com.baidu.tbadk.mutiprocess.history.HistoryEvent;
import com.baidu.tbadk.mutiprocess.location.LocationEvent;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import com.baidu.tbadk.mutiprocess.showreplyinpb.ShowReplyInPbEvent;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
/* loaded from: classes.dex */
public class MutiProcessStatic {
    static {
        bDj();
    }

    private static void bDj() {
        try {
            g bDi = g.bDi();
            bDi.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            bDi.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            bDi.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            bDi.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            bDi.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            bDi.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            bDi.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
            bDi.a(ShowReplyInPbEvent.class, new com.baidu.tbadk.mutiprocess.showreplyinpb.a());
            bDi.a(LocationEvent.class, new com.baidu.tbadk.mutiprocess.location.a());
            bDi.a(PrePageKeyEvent.class, new com.baidu.tbadk.mutiprocess.prePageKey.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
