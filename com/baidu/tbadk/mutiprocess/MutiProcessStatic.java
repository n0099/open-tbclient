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
/* loaded from: classes2.dex */
public class MutiProcessStatic {
    static {
        btn();
    }

    private static void btn() {
        try {
            g btm = g.btm();
            btm.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            btm.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            btm.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            btm.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            btm.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            btm.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            btm.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
            btm.a(ShowReplyInPbEvent.class, new com.baidu.tbadk.mutiprocess.showreplyinpb.a());
            btm.a(LocationEvent.class, new com.baidu.tbadk.mutiprocess.location.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
