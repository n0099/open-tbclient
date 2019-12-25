package com.baidu.tbadk.mutiprocess;

import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mutiprocess.backbaidubox.BackBaiduBoxViewEvent;
import com.baidu.tbadk.mutiprocess.competetask.CompeteTaskEvent;
import com.baidu.tbadk.mutiprocess.history.HistoryEvent;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
/* loaded from: classes.dex */
public class MutiProcessStatic {
    static {
        aNr();
    }

    private static void aNr() {
        try {
            g aNq = g.aNq();
            aNq.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            aNq.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            aNq.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            aNq.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            aNq.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            aNq.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
