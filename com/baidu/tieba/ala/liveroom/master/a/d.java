package com.baidu.tieba.ala.liveroom.master.a;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.liveroom.middleware.k;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.data.h;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes3.dex */
public class d {
    private f eUL = new f();
    private com.baidu.tieba.ala.liveroom.data.e ffM;
    private AlaMasterLiveRoomOpearator fhj;
    private b fhk;
    private a fhm;
    private com.baidu.live.liveroom.middleware.a fhn;

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, com.baidu.live.tieba.e.b bVar, String str) {
        this.eUL.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.eUL.fbt = alaLiveRecorder;
        this.eUL.fbu = frameLayout;
        this.eUL.faU = alaLiveView;
        this.eUL.rootView = viewGroup;
        this.eUL.fby = bVar;
        this.eUL.fbv = this;
        this.eUL.fbx = new AlaLiveRecorderPerfData();
        this.fhj = new AlaMasterLiveRoomOpearator(this.eUL, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fhn = k.yD().yE();
            this.eUL.fbz = this.fhn;
            this.fhn.u(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.m.c cVar) {
        this.eUL.faT = cVar;
    }

    public void setArModel(com.baidu.live.ar.c cVar) {
        this.eUL.fbw = cVar;
    }

    public void a(b bVar) {
        this.fhk = bVar;
        if (this.fhm != null) {
            this.fhm.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.fhj != null) {
            g gVar = null;
            if (obj instanceof g) {
                gVar = (g) obj;
            }
            int a = this.fhj.a(gVar);
            if (a == 1 || a == 2) {
                this.eUL.pZ(a);
            } else {
                return;
            }
        }
        if (this.fhm != null) {
            this.fhm.a(s, obj);
        }
    }

    public void b(g gVar) {
        a((short) 1, gVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.ffM = eVar;
        if (this.fhm != null) {
            this.fhm.c(eVar);
        }
    }

    public void aw(int i, String str) {
        if (this.fhm != null) {
            this.fhm.aw(i, str);
        }
    }

    public void c(h hVar) {
        if (this.fhm != null) {
            this.fhm.c(hVar);
        }
    }

    public void ax(int i, String str) {
        if (this.fhm != null) {
            this.fhm.ax(i, str);
        }
    }

    public void i(short s) {
        if (this.fhm != null) {
            this.fhm.i(s);
        }
        if (this.fhn != null) {
            this.fhn.yz();
        }
    }

    public void bpb() {
        if (this.fhm != null) {
            this.fhm.bpb();
        }
        if (this.fhn != null) {
            this.fhn.onStop();
        }
    }

    public void bpc() {
        if (this.fhm != null) {
            this.fhm.bpc();
        }
        if (this.fhj != null) {
            this.fhj.onResume();
        }
        if (this.fhn != null) {
            this.fhn.onResume();
        }
    }

    public void onPause() {
        if (this.fhm != null) {
            this.fhm.onPause();
        }
        if (this.fhn != null) {
            this.fhn.onPause();
        }
    }

    public boolean bpd() {
        if (this.fhm != null) {
            return this.fhm.bpd();
        }
        return false;
    }

    public void bpe() {
        if (this.fhm != null) {
            this.fhm.bpe();
        }
    }

    public void qx(int i) {
        if (i == 1 && !(this.fhm instanceof c)) {
            this.fhm = new c(this.eUL);
        } else if (i == 2 && !(this.fhm instanceof e)) {
            this.fhm = new e(this.eUL);
        } else {
            return;
        }
        this.fhm.ac(this.fhj);
        this.fhm.a(this.fhk);
    }

    public void j(int i, int i2, int i3) {
        if (this.fhj != null) {
            this.fhj.j(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fhj != null) {
            this.fhj.onKeyboardVisibilityChanged(z);
        }
        if (this.fhn != null) {
            this.fhn.d(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fhj != null) {
            this.fhj.onActivityResult(i, i2, intent);
        }
        if (this.fhn != null) {
            this.fhn.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.fhn != null) {
            this.fhn.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData bpg() {
        return this.eUL.fbx;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fhj != null) {
            return this.fhj.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.fhj != null) {
            this.fhj.streamStateReceived(i, z, i2, z2);
        }
    }

    public void bor() {
        if (this.fhj != null) {
            this.fhj.bor();
        }
    }

    public void boD() {
        if (this.fhj != null) {
            this.fhj.boD();
        }
    }

    public void blQ() {
        if (this.fhj != null) {
            this.fhj.blQ();
        }
    }

    public com.baidu.tieba.ala.liveroom.data.e bph() {
        return this.ffM;
    }

    public boolean bpf() {
        if (this.fhm != null) {
            return this.fhm.bpf();
        }
        return false;
    }

    public int blS() {
        if (this.eUL != null) {
            return this.eUL.blS();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.fhj != null) {
            this.fhj.onDestroy();
        }
        if (this.fhn != null) {
            this.fhn.be(false);
        }
    }

    public void f(short s) {
        if (this.fhk != null) {
            this.fhk.f(s);
        }
    }

    public void blT() {
        if (this.fhk != null) {
            this.fhk.blT();
        }
    }

    public void awT() {
        if (this.fhk != null) {
            this.fhk.awT();
        }
    }

    public void blU() {
        if (this.fhk != null) {
            this.fhk.blU();
        }
    }

    public void blV() {
        if (this.fhk != null) {
            this.fhk.blV();
        }
    }

    public void blW() {
        if (this.fhk != null) {
            this.fhk.blW();
        }
    }

    public void onRtcConnected(int i) {
        if (this.fhj != null) {
            this.fhj.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.fhj != null) {
            this.fhj.onPKPlayerFirstFrame();
        }
    }
}
