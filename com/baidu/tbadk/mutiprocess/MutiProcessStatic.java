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
        bDg();
    }

    private static void bDg() {
        try {
            g bDf = g.bDf();
            bDf.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            bDf.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            bDf.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            bDf.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            bDf.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            bDf.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            bDf.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
            bDf.a(ShowReplyInPbEvent.class, new com.baidu.tbadk.mutiprocess.showreplyinpb.a());
            bDf.a(LocationEvent.class, new com.baidu.tbadk.mutiprocess.location.a());
            bDf.a(PrePageKeyEvent.class, new com.baidu.tbadk.mutiprocess.prePageKey.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
