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
import d.a.m0.f0.h;
import d.a.m0.f0.l.a;
/* loaded from: classes3.dex */
public class MutiProcessStatic {
    static {
        a();
    }

    public static void a() {
        try {
            h f2 = h.f();
            f2.l(AgreeEvent.class, new a());
            f2.l(MissionEvent.class, new d.a.m0.f0.q.a());
            f2.l(CompeteTaskEvent.class, new d.a.m0.f0.n.a());
            f2.l(ShareEvent.class, new d.a.m0.f0.s.a());
            f2.l(HistoryEvent.class, new d.a.m0.f0.o.a());
            f2.l(BackBaiduBoxViewEvent.class, new d.a.m0.f0.m.a());
            f2.l(SyncDataEvent.class, new d.a.m0.f0.u.a());
            f2.l(ShowReplyInPbEvent.class, new d.a.m0.f0.t.a());
            f2.l(LocationEvent.class, new d.a.m0.f0.p.a());
            f2.l(PrePageKeyEvent.class, new d.a.m0.f0.r.a());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
