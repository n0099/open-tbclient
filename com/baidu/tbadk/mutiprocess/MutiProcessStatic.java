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
        aNK();
    }

    private static void aNK() {
        try {
            g aNJ = g.aNJ();
            aNJ.a(AgreeEvent.class, new com.baidu.tbadk.mutiprocess.agree.a());
            aNJ.a(MissionEvent.class, new com.baidu.tbadk.mutiprocess.mission.a());
            aNJ.a(CompeteTaskEvent.class, new com.baidu.tbadk.mutiprocess.competetask.a());
            aNJ.a(ShareEvent.class, new com.baidu.tbadk.mutiprocess.share.a());
            aNJ.a(HistoryEvent.class, new com.baidu.tbadk.mutiprocess.history.a());
            aNJ.a(BackBaiduBoxViewEvent.class, new com.baidu.tbadk.mutiprocess.backbaidubox.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
