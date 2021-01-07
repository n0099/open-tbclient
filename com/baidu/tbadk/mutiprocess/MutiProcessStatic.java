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
        bGH();
    }

    private static void bGH() {
        try {
            g bGG = g.bGG();
            bGG.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            bGG.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            bGG.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            bGG.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            bGG.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            bGG.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            bGG.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
            bGG.a(ShowReplyInPbEvent.class, new com.baidu.tbadk.mutiprocess.showreplyinpb.a());
            bGG.a(LocationEvent.class, new com.baidu.tbadk.mutiprocess.location.a());
            bGG.a(PrePageKeyEvent.class, new com.baidu.tbadk.mutiprocess.prePageKey.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
