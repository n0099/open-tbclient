package com.baidu.tieba.ala.liveroom.master.a;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.ar.j;
import com.baidu.live.data.aq;
import com.baidu.live.liveroom.middleware.k;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes4.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.data.e hjc = new com.baidu.tieba.ala.liveroom.data.e();
    private com.baidu.tieba.ala.liveroom.data.d hwb;
    private a hxA;
    private com.baidu.live.liveroom.middleware.a hxB;
    private AlaMasterLiveRoomOpearator hxx;
    private b hxy;

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, ViewGroup viewGroup2, com.baidu.live.tieba.e.b bVar, String str, View view) {
        this.hjc.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.hjc.hqk = alaLiveRecorder;
        this.hjc.hql = view;
        this.hjc.hqm = frameLayout;
        this.hjc.hpU = alaLiveView;
        this.hjc.rootView = viewGroup;
        this.hjc.hqn = viewGroup2;
        this.hjc.hqr = bVar;
        this.hjc.hqo = this;
        this.hjc.hqq = new AlaLiveRecorderPerfData();
        this.hxx = new AlaMasterLiveRoomOpearator(this.hjc, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hxB = k.Po().Pp();
            this.hjc.hqs = this.hxB;
            this.hxB.r(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.p.d dVar) {
        this.hjc.hpT = dVar;
    }

    public void setArModel(j jVar) {
        this.hjc.hqp = jVar;
    }

    public void a(b bVar) {
        this.hxy = bVar;
        if (this.hxA != null) {
            this.hxA.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.hxx != null) {
            f fVar = null;
            if (obj instanceof f) {
                fVar = (f) obj;
            }
            int a2 = this.hxx.a(fVar);
            if (a2 == 1 || a2 == 2) {
                this.hjc.wE(a2);
            } else {
                return;
            }
        }
        if (this.hxA != null) {
            this.hxA.a(s, obj);
        }
    }

    public void b(f fVar) {
        a((short) 1, fVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.hwb = dVar;
        if (this.hxA != null) {
            this.hxA.c(dVar);
        }
    }

    public void bi(int i, String str) {
        if (this.hxA != null) {
            this.hxA.bi(i, str);
        }
    }

    public void c(aq aqVar) {
        if (this.hxA != null) {
            this.hxA.c(aqVar);
        }
    }

    public void bj(int i, String str) {
        if (this.hxA != null) {
            this.hxA.bj(i, str);
        }
    }

    public void j(short s) {
        if (this.hxA != null) {
            this.hxA.j(s);
        }
        if (this.hxB != null) {
            this.hxB.Pk();
        }
    }

    public void markEnterBackground() {
        if (this.hxA != null) {
            this.hxA.markEnterBackground();
        }
        if (this.hxB != null) {
            this.hxB.onStop();
        }
    }

    public void markEnterForeground() {
        if (this.hxA != null) {
            this.hxA.markEnterForeground();
        }
        if (this.hxx != null) {
            this.hxx.onResume();
        }
        if (this.hxB != null) {
            this.hxB.onResume();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.hxA != null) {
            this.hxA.onPause();
        }
        if (this.hxB != null) {
            this.hxB.onPause();
        }
    }

    public boolean ciP() {
        if (this.hxA != null) {
            return this.hxA.ciP();
        }
        return false;
    }

    public void ciQ() {
        if (this.hxA != null) {
            this.hxA.ciQ();
        }
    }

    public void xg(int i) {
        if (i == 1 && !(this.hxA instanceof c)) {
            this.hxA = new c(this.hjc);
        } else if (i == 2 && !(this.hxA instanceof e)) {
            this.hxA = new e(this.hjc);
        } else {
            return;
        }
        this.hxA.ar(this.hxx);
        this.hxA.a(this.hxy);
    }

    public void l(int i, int i2, int i3) {
        if (this.hxx != null) {
            this.hxx.l(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hxx != null) {
            this.hxx.onKeyboardVisibilityChanged(z);
        }
        if (this.hxB != null) {
            this.hxB.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hxx != null) {
            this.hxx.onActivityResult(i, i2, intent);
        }
        if (this.hxB != null) {
            this.hxB.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hxB != null) {
            this.hxB.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData ciS() {
        return this.hjc.hqq;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hxx != null) {
            return this.hxx.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.hxx != null) {
            this.hxx.streamStateReceived(i, z, i2, z2);
        }
    }

    public void sendBufferChanged(int i) {
        if (this.hxx != null) {
            this.hxx.sendBufferChanged(i);
        }
    }

    public void cid() {
        if (this.hxx != null) {
            this.hxx.cid();
        }
    }

    public void cip() {
        if (this.hxx != null) {
            this.hxx.cip();
        }
    }

    public void ceE() {
        if (this.hxx != null) {
            this.hxx.ceE();
        }
    }

    public void nC(boolean z) {
        if (this.hxx != null) {
            this.hxx.nC(z);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.d ciT() {
        return this.hwb;
    }

    public boolean ciR() {
        if (this.hxA != null) {
            return this.hxA.ciR();
        }
        return false;
    }

    public int ceG() {
        if (this.hjc != null) {
            return this.hjc.ceG();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.hxx != null) {
            this.hxx.onDestroy();
        }
        if (this.hxB != null) {
            this.hxB.cx(false);
        }
    }

    public void g(short s) {
        if (this.hxy != null) {
            this.hxy.g(s);
        }
        if (this.hxx != null) {
            this.hxx.b(s);
        }
    }

    public void Yj() {
        if (this.hxy != null) {
            this.hxy.Yj();
        }
    }

    public void bhU() {
        if (this.hxy != null) {
            this.hxy.bhU();
        }
    }

    public void ceH() {
        if (this.hxy != null) {
            this.hxy.ceH();
        }
    }

    public void ceI() {
        if (this.hxy != null) {
            this.hxy.ceI();
        }
    }

    public void ceJ() {
        if (this.hxy != null) {
            this.hxy.ceJ();
        }
    }

    public void onRtcConnected(int i) {
        if (this.hxx != null) {
            this.hxx.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.hxx != null) {
            this.hxx.onPKPlayerFirstFrame();
        }
    }
}
