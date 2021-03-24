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
import d.b.h0.f0.g;
import d.b.h0.f0.k.a;
/* loaded from: classes3.dex */
public class MutiProcessStatic {
    static {
        a();
    }

    public static void a() {
        try {
            g e2 = g.e();
            e2.j(AgreeEvent.class, new a());
            e2.j(MissionEvent.class, new d.b.h0.f0.p.a());
            e2.j(CompeteTaskEvent.class, new d.b.h0.f0.m.a());
            e2.j(ShareEvent.class, new d.b.h0.f0.r.a());
            e2.j(HistoryEvent.class, new d.b.h0.f0.n.a());
            e2.j(BackBaiduBoxViewEvent.class, new d.b.h0.f0.l.a());
            e2.j(SyncDataEvent.class, new d.b.h0.f0.t.a());
            e2.j(ShowReplyInPbEvent.class, new d.b.h0.f0.s.a());
            e2.j(LocationEvent.class, new d.b.h0.f0.o.a());
            e2.j(PrePageKeyEvent.class, new d.b.h0.f0.q.a());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
