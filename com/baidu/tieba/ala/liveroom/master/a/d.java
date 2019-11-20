package com.baidu.tieba.ala.liveroom.master.a;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.ala.liveRecorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes6.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.data.e dYK = new com.baidu.tieba.ala.liveroom.data.e();
    private com.baidu.tieba.ala.liveroom.data.d eja;
    private AlaMasterLiveRoomOpearator ekk;
    private b ekl;
    private a ekn;

    public d(TbPageContext tbPageContext, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, ViewGroup viewGroup, com.baidu.live.tieba.e.b bVar) {
        this.dYK.pageContext = tbPageContext;
        this.dYK.efe = alaLiveRecorder;
        this.dYK.eeM = alaLiveView;
        this.dYK.AE = viewGroup;
        this.dYK.efh = bVar;
        this.dYK.eff = this;
        this.dYK.efg = new AlaLiveRecorderPerfData();
        this.ekk = new AlaMasterLiveRoomOpearator(this.dYK);
    }

    public void a(com.baidu.tieba.ala.liveroom.m.c cVar) {
        this.dYK.eeL = cVar;
    }

    public void a(b bVar) {
        this.ekl = bVar;
        if (this.ekn != null) {
            this.ekn.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        if (s == 1 && this.ekk != null) {
            f fVar = null;
            if (obj instanceof f) {
                fVar = (f) obj;
            }
            int a = this.ekk.a(fVar);
            if (a == 1 || a == 2) {
                this.dYK.nw(a);
            } else {
                return;
            }
        }
        if (this.ekn != null) {
            this.ekn.a(s, obj);
        }
    }

    public void b(f fVar) {
        a((short) 1, fVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.eja = dVar;
        if (this.ekn != null) {
            this.ekn.c(dVar);
        }
    }

    public void ab(int i, String str) {
        if (this.ekn != null) {
            this.ekn.ab(i, str);
        }
    }

    public void c(g gVar) {
        if (this.ekn != null) {
            this.ekn.c(gVar);
        }
    }

    public void ac(int i, String str) {
        if (this.ekn != null) {
            this.ekn.ac(i, str);
        }
    }

    public void f(short s) {
        if (this.ekn != null) {
            this.ekn.f(s);
        }
    }

    public void aUu() {
        if (this.ekn != null) {
            this.ekn.aUu();
        }
    }

    public void aUv() {
        if (this.ekn != null) {
            this.ekn.aUv();
        }
        if (this.ekk != null) {
            this.ekk.onResume();
        }
    }

    public void onPause() {
        if (this.ekn != null) {
            this.ekn.onPause();
        }
    }

    public boolean aUw() {
        if (this.ekn != null) {
            return this.ekn.aUw();
        }
        return false;
    }

    public void aUx() {
        if (this.ekn != null) {
            this.ekn.aUx();
        }
    }

    public void nS(int i) {
        if (i == 1 && !(this.ekn instanceof c)) {
            this.ekn = new c(this.dYK);
        } else if (i == 2 && !(this.ekn instanceof e)) {
            this.ekn = new e(this.dYK);
        } else {
            return;
        }
        this.ekn.S(this.ekk);
        this.ekn.a(this.ekl);
    }

    public void E(int i, int i2, int i3) {
        if (this.ekk != null) {
            this.ekk.E(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.ekk != null) {
            this.ekk.onKeyboardVisibilityChanged(z);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.ekk != null) {
            this.ekk.onActivityResult(i, i2, intent);
        }
    }

    public AlaLiveRecorderPerfData aUz() {
        return this.dYK.efg;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.ekk != null) {
            return this.ekk.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.ekk != null) {
            this.ekk.streamStateReceived(i, z, i2, z2);
        }
    }

    public void aTM() {
        if (this.ekk != null) {
            this.ekk.aTM();
        }
    }

    public void aTY() {
        if (this.ekk != null) {
            this.ekk.aTY();
        }
    }

    public void aRH() {
        if (this.ekk != null) {
            this.ekk.aRH();
        }
    }

    public com.baidu.tieba.ala.liveroom.data.d aUA() {
        return this.eja;
    }

    public boolean aUy() {
        if (this.ekn != null) {
            return this.ekn.aUy();
        }
        return false;
    }

    public int aRJ() {
        if (this.dYK != null) {
            return this.dYK.aRJ();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.ekk != null) {
            this.ekk.onDestroy();
        }
    }

    public void c(short s) {
        if (this.ekl != null) {
            this.ekl.c(s);
        }
    }

    public void aRK() {
        if (this.ekl != null) {
            this.ekl.aRK();
        }
    }

    public void aRL() {
        if (this.ekl != null) {
            this.ekl.aRL();
        }
    }

    public void aRM() {
        if (this.ekl != null) {
            this.ekl.aRM();
        }
    }

    public void aRN() {
        if (this.ekl != null) {
            this.ekl.aRN();
        }
    }

    public void aRO() {
        if (this.ekl != null) {
            this.ekl.aRO();
        }
    }

    public void onRtcConnected(int i) {
        if (this.ekk != null) {
            this.ekk.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.ekk != null) {
            this.ekk.onPKPlayerFirstFrame();
        }
    }
}
