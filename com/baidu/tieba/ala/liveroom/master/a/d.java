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
    private f eUa = new f();
    private com.baidu.tieba.ala.liveroom.data.e ffa;
    private a fgA;
    private com.baidu.live.liveroom.middleware.a fgB;
    private AlaMasterLiveRoomOpearator fgx;
    private b fgy;

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, com.baidu.live.tieba.e.b bVar, String str) {
        this.eUa.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.eUa.faI = alaLiveRecorder;
        this.eUa.faJ = frameLayout;
        this.eUa.faj = alaLiveView;
        this.eUa.rootView = viewGroup;
        this.eUa.faN = bVar;
        this.eUa.faK = this;
        this.eUa.faM = new AlaLiveRecorderPerfData();
        this.fgx = new AlaMasterLiveRoomOpearator(this.eUa, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fgB = k.yy().yz();
            this.eUa.faO = this.fgB;
            this.fgB.u(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.m.c cVar) {
        this.eUa.fai = cVar;
    }

    public void setArModel(com.baidu.live.ar.c cVar) {
        this.eUa.faL = cVar;
    }

    public void a(b bVar) {
        this.fgy = bVar;
        if (this.fgA != null) {
            this.fgA.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.fgx != null) {
            g gVar = null;
            if (obj instanceof g) {
                gVar = (g) obj;
            }
            int a = this.fgx.a(gVar);
            if (a == 1 || a == 2) {
                this.eUa.pX(a);
            } else {
                return;
            }
        }
        if (this.fgA != null) {
            this.fgA.a(s, obj);
        }
    }

    public void b(g gVar) {
        a((short) 1, gVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.ffa = eVar;
        if (this.fgA != null) {
            this.fgA.c(eVar);
        }
    }

    public void aw(int i, String str) {
        if (this.fgA != null) {
            this.fgA.aw(i, str);
        }
    }

    public void c(h hVar) {
        if (this.fgA != null) {
            this.fgA.c(hVar);
        }
    }

    public void ax(int i, String str) {
        if (this.fgA != null) {
            this.fgA.ax(i, str);
        }
    }

    public void i(short s) {
        if (this.fgA != null) {
            this.fgA.i(s);
        }
        if (this.fgB != null) {
            this.fgB.yu();
        }
    }

    public void boV() {
        if (this.fgA != null) {
            this.fgA.boV();
        }
        if (this.fgB != null) {
            this.fgB.onStop();
        }
    }

    public void boW() {
        if (this.fgA != null) {
            this.fgA.boW();
        }
        if (this.fgx != null) {
            this.fgx.onResume();
        }
        if (this.fgB != null) {
            this.fgB.onResume();
        }
    }

    public void onPause() {
        if (this.fgA != null) {
            this.fgA.onPause();
        }
        if (this.fgB != null) {
            this.fgB.onPause();
        }
    }

    public boolean boX() {
        if (this.fgA != null) {
            return this.fgA.boX();
        }
        return false;
    }

    public void boY() {
        if (this.fgA != null) {
            this.fgA.boY();
        }
    }

    public void qv(int i) {
        if (i == 1 && !(this.fgA instanceof c)) {
            this.fgA = new c(this.eUa);
        } else if (i == 2 && !(this.fgA instanceof e)) {
            this.fgA = new e(this.eUa);
        } else {
            return;
        }
        this.fgA.ac(this.fgx);
        this.fgA.a(this.fgy);
    }

    public void j(int i, int i2, int i3) {
        if (this.fgx != null) {
            this.fgx.j(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fgx != null) {
            this.fgx.onKeyboardVisibilityChanged(z);
        }
        if (this.fgB != null) {
            this.fgB.d(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fgx != null) {
            this.fgx.onActivityResult(i, i2, intent);
        }
        if (this.fgB != null) {
            this.fgB.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.fgB != null) {
            this.fgB.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData bpa() {
        return this.eUa.faM;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fgx != null) {
            return this.fgx.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.fgx != null) {
            this.fgx.streamStateReceived(i, z, i2, z2);
        }
    }

    public void bol() {
        if (this.fgx != null) {
            this.fgx.bol();
        }
    }

    public void box() {
        if (this.fgx != null) {
            this.fgx.box();
        }
    }

    public void blK() {
        if (this.fgx != null) {
            this.fgx.blK();
        }
    }

    public com.baidu.tieba.ala.liveroom.data.e bpb() {
        return this.ffa;
    }

    public boolean boZ() {
        if (this.fgA != null) {
            return this.fgA.boZ();
        }
        return false;
    }

    public int blM() {
        if (this.eUa != null) {
            return this.eUa.blM();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.fgx != null) {
            this.fgx.onDestroy();
        }
        if (this.fgB != null) {
            this.fgB.be(false);
        }
    }

    public void f(short s) {
        if (this.fgy != null) {
            this.fgy.f(s);
        }
    }

    public void blN() {
        if (this.fgy != null) {
            this.fgy.blN();
        }
    }

    public void awQ() {
        if (this.fgy != null) {
            this.fgy.awQ();
        }
    }

    public void blO() {
        if (this.fgy != null) {
            this.fgy.blO();
        }
    }

    public void blP() {
        if (this.fgy != null) {
            this.fgy.blP();
        }
    }

    public void blQ() {
        if (this.fgy != null) {
            this.fgy.blQ();
        }
    }

    public void onRtcConnected(int i) {
        if (this.fgx != null) {
            this.fgx.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.fgx != null) {
            this.fgx.onPKPlayerFirstFrame();
        }
    }
}
