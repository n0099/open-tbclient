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
    private f eTZ = new f();
    private com.baidu.tieba.ala.liveroom.data.e feZ;
    private com.baidu.live.liveroom.middleware.a fgA;
    private AlaMasterLiveRoomOpearator fgw;
    private b fgx;
    private a fgz;

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, com.baidu.live.tieba.e.b bVar, String str) {
        this.eTZ.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.eTZ.faH = alaLiveRecorder;
        this.eTZ.faI = frameLayout;
        this.eTZ.fai = alaLiveView;
        this.eTZ.rootView = viewGroup;
        this.eTZ.faM = bVar;
        this.eTZ.faJ = this;
        this.eTZ.faL = new AlaLiveRecorderPerfData();
        this.fgw = new AlaMasterLiveRoomOpearator(this.eTZ, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fgA = k.yy().yz();
            this.eTZ.faN = this.fgA;
            this.fgA.u(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.m.c cVar) {
        this.eTZ.fah = cVar;
    }

    public void setArModel(com.baidu.live.ar.c cVar) {
        this.eTZ.faK = cVar;
    }

    public void a(b bVar) {
        this.fgx = bVar;
        if (this.fgz != null) {
            this.fgz.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.fgw != null) {
            g gVar = null;
            if (obj instanceof g) {
                gVar = (g) obj;
            }
            int a = this.fgw.a(gVar);
            if (a == 1 || a == 2) {
                this.eTZ.pX(a);
            } else {
                return;
            }
        }
        if (this.fgz != null) {
            this.fgz.a(s, obj);
        }
    }

    public void b(g gVar) {
        a((short) 1, gVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.feZ = eVar;
        if (this.fgz != null) {
            this.fgz.c(eVar);
        }
    }

    public void aw(int i, String str) {
        if (this.fgz != null) {
            this.fgz.aw(i, str);
        }
    }

    public void c(h hVar) {
        if (this.fgz != null) {
            this.fgz.c(hVar);
        }
    }

    public void ax(int i, String str) {
        if (this.fgz != null) {
            this.fgz.ax(i, str);
        }
    }

    public void i(short s) {
        if (this.fgz != null) {
            this.fgz.i(s);
        }
        if (this.fgA != null) {
            this.fgA.yu();
        }
    }

    public void boT() {
        if (this.fgz != null) {
            this.fgz.boT();
        }
        if (this.fgA != null) {
            this.fgA.onStop();
        }
    }

    public void boU() {
        if (this.fgz != null) {
            this.fgz.boU();
        }
        if (this.fgw != null) {
            this.fgw.onResume();
        }
        if (this.fgA != null) {
            this.fgA.onResume();
        }
    }

    public void onPause() {
        if (this.fgz != null) {
            this.fgz.onPause();
        }
        if (this.fgA != null) {
            this.fgA.onPause();
        }
    }

    public boolean boV() {
        if (this.fgz != null) {
            return this.fgz.boV();
        }
        return false;
    }

    public void boW() {
        if (this.fgz != null) {
            this.fgz.boW();
        }
    }

    public void qv(int i) {
        if (i == 1 && !(this.fgz instanceof c)) {
            this.fgz = new c(this.eTZ);
        } else if (i == 2 && !(this.fgz instanceof e)) {
            this.fgz = new e(this.eTZ);
        } else {
            return;
        }
        this.fgz.ac(this.fgw);
        this.fgz.a(this.fgx);
    }

    public void j(int i, int i2, int i3) {
        if (this.fgw != null) {
            this.fgw.j(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fgw != null) {
            this.fgw.onKeyboardVisibilityChanged(z);
        }
        if (this.fgA != null) {
            this.fgA.d(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fgw != null) {
            this.fgw.onActivityResult(i, i2, intent);
        }
        if (this.fgA != null) {
            this.fgA.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.fgA != null) {
            this.fgA.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData boY() {
        return this.eTZ.faL;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fgw != null) {
            return this.fgw.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.fgw != null) {
            this.fgw.streamStateReceived(i, z, i2, z2);
        }
    }

    public void boj() {
        if (this.fgw != null) {
            this.fgw.boj();
        }
    }

    public void bov() {
        if (this.fgw != null) {
            this.fgw.bov();
        }
    }

    public void blI() {
        if (this.fgw != null) {
            this.fgw.blI();
        }
    }

    public com.baidu.tieba.ala.liveroom.data.e boZ() {
        return this.feZ;
    }

    public boolean boX() {
        if (this.fgz != null) {
            return this.fgz.boX();
        }
        return false;
    }

    public int blK() {
        if (this.eTZ != null) {
            return this.eTZ.blK();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.fgw != null) {
            this.fgw.onDestroy();
        }
        if (this.fgA != null) {
            this.fgA.be(false);
        }
    }

    public void f(short s) {
        if (this.fgx != null) {
            this.fgx.f(s);
        }
    }

    public void blL() {
        if (this.fgx != null) {
            this.fgx.blL();
        }
    }

    public void awO() {
        if (this.fgx != null) {
            this.fgx.awO();
        }
    }

    public void blM() {
        if (this.fgx != null) {
            this.fgx.blM();
        }
    }

    public void blN() {
        if (this.fgx != null) {
            this.fgx.blN();
        }
    }

    public void blO() {
        if (this.fgx != null) {
            this.fgx.blO();
        }
    }

    public void onRtcConnected(int i) {
        if (this.fgw != null) {
            this.fgw.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.fgw != null) {
            this.fgw.onPKPlayerFirstFrame();
        }
    }
}
