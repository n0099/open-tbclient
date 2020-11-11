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
        bBu();
    }

    private static void bBu() {
        try {
            g bBt = g.bBt();
            bBt.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            bBt.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            bBt.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            bBt.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            bBt.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            bBt.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            bBt.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
            bBt.a(ShowReplyInPbEvent.class, new com.baidu.tbadk.mutiprocess.showreplyinpb.a());
            bBt.a(LocationEvent.class, new com.baidu.tbadk.mutiprocess.location.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
