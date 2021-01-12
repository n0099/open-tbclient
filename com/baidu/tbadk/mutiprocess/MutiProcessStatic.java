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
        bCO();
    }

    private static void bCO() {
        try {
            g bCN = g.bCN();
            bCN.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            bCN.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            bCN.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            bCN.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            bCN.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            bCN.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            bCN.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
            bCN.a(ShowReplyInPbEvent.class, new com.baidu.tbadk.mutiprocess.showreplyinpb.a());
            bCN.a(LocationEvent.class, new com.baidu.tbadk.mutiprocess.location.a());
            bCN.a(PrePageKeyEvent.class, new com.baidu.tbadk.mutiprocess.prePageKey.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
