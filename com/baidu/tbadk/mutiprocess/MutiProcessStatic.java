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
        bto();
    }

    private static void bto() {
        try {
            g btn = g.btn();
            btn.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            btn.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            btn.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            btn.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            btn.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            btn.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            btn.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
            btn.a(ShowReplyInPbEvent.class, new com.baidu.tbadk.mutiprocess.showreplyinpb.a());
            btn.a(LocationEvent.class, new com.baidu.tbadk.mutiprocess.location.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
