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
        bEm();
    }

    private static void bEm() {
        try {
            g bEl = g.bEl();
            bEl.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            bEl.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            bEl.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            bEl.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            bEl.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            bEl.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
            bEl.a(SyncDataEvent.class, new com.baidu.tbadk.mutiprocess.sync.a());
            bEl.a(ShowReplyInPbEvent.class, new com.baidu.tbadk.mutiprocess.showreplyinpb.a());
            bEl.a(LocationEvent.class, new com.baidu.tbadk.mutiprocess.location.a());
            bEl.a(PrePageKeyEvent.class, new com.baidu.tbadk.mutiprocess.prePageKey.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
