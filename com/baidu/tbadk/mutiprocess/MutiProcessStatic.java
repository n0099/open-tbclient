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
        bGG();
    }

    private static void bGG() {
        try {
            g bGF = g.bGF();
            bGF.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            bGF.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            bGF.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            bGF.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            bGF.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            bGF.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            bGF.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
            bGF.a(ShowReplyInPbEvent.class, new com.baidu.tbadk.mutiprocess.showreplyinpb.a());
            bGF.a(LocationEvent.class, new com.baidu.tbadk.mutiprocess.location.a());
            bGF.a(PrePageKeyEvent.class, new com.baidu.tbadk.mutiprocess.prePageKey.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
