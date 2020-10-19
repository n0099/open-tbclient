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
        bxc();
    }

    private static void bxc() {
        try {
            g bxb = g.bxb();
            bxb.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            bxb.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            bxb.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            bxb.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            bxb.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            bxb.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            bxb.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
            bxb.a(ShowReplyInPbEvent.class, new com.baidu.tbadk.mutiprocess.showreplyinpb.a());
            bxb.a(LocationEvent.class, new com.baidu.tbadk.mutiprocess.location.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
