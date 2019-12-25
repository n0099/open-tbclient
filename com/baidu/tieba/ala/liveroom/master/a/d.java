package com.baidu.tieba.ala.liveroom.master.a;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes2.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.data.e eOH = new com.baidu.tieba.ala.liveroom.data.e();
    private com.baidu.tieba.ala.liveroom.data.d eZl;
    private b faA;
    private a faC;
    private AlaMasterLiveRoomOpearator faz;

    public d(TbPageContext tbPageContext, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, ViewGroup viewGroup, com.baidu.live.tieba.e.b bVar) {
        this.eOH.pageContext = tbPageContext;
        this.eOH.eUY = alaLiveRecorder;
        this.eOH.eUG = alaLiveView;
        this.eOH.rootView = viewGroup;
        this.eOH.eVb = bVar;
        this.eOH.eUZ = this;
        this.eOH.eVa = new AlaLiveRecorderPerfData();
        this.faz = new AlaMasterLiveRoomOpearator(this.eOH);
    }

    public void a(com.baidu.tieba.ala.liveroom.m.c cVar) {
        this.eOH.eUF = cVar;
    }

    public void a(b bVar) {
        this.faA = bVar;
        if (this.faC != null) {
            this.faC.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        if (s == 1 && this.faz != null) {
            f fVar = null;
            if (obj instanceof f) {
                fVar = (f) obj;
            }
            int a = this.faz.a(fVar);
            if (a == 1 || a == 2) {
                this.eOH.pN(a);
            } else {
                return;
            }
        }
        if (this.faC != null) {
            this.faC.a(s, obj);
        }
    }

    public void b(f fVar) {
        a((short) 1, fVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.eZl = dVar;
        if (this.faC != null) {
            this.faC.c(dVar);
        }
    }

    public void aq(int i, String str) {
        if (this.faC != null) {
            this.faC.aq(i, str);
        }
    }

    public void c(g gVar) {
        if (this.faC != null) {
            this.faC.c(gVar);
        }
    }

    public void ar(int i, String str) {
        if (this.faC != null) {
            this.faC.ar(i, str);
        }
    }

    public void g(short s) {
        if (this.faC != null) {
            this.faC.g(s);
        }
    }

    public void bml() {
        if (this.faC != null) {
            this.faC.bml();
        }
    }

    public void bmm() {
        if (this.faC != null) {
            this.faC.bmm();
        }
        if (this.faz != null) {
            this.faz.onResume();
        }
    }

    public void onPause() {
        if (this.faC != null) {
            this.faC.onPause();
        }
    }

    public boolean bmn() {
        if (this.faC != null) {
            return this.faC.bmn();
        }
        return false;
    }

    public void bmo() {
        if (this.faC != null) {
            this.faC.bmo();
        }
    }

    public void qj(int i) {
        if (i == 1 && !(this.faC instanceof c)) {
            this.faC = new c(this.eOH);
        } else if (i == 2 && !(this.faC instanceof e)) {
            this.faC = new e(this.eOH);
        } else {
            return;
        }
        this.faC.U(this.faz);
        this.faC.a(this.faA);
    }

    public void E(int i, int i2, int i3) {
        if (this.faz != null) {
            this.faz.E(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.faz != null) {
            this.faz.onKeyboardVisibilityChanged(z);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.faz != null) {
            this.faz.onActivityResult(i, i2, intent);
        }
    }

    public AlaLiveRecorderPerfData bmq() {
        return this.eOH.eVa;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.faz != null) {
            return this.faz.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.faz != null) {
            this.faz.streamStateReceived(i, z, i2, z2);
        }
    }

    public void blD() {
        if (this.faz != null) {
            this.faz.blD();
        }
    }

    public void blP() {
        if (this.faz != null) {
            this.faz.blP();
        }
    }

    public void bji() {
        if (this.faz != null) {
            this.faz.bji();
        }
    }

    public com.baidu.tieba.ala.liveroom.data.d bmr() {
        return this.eZl;
    }

    public boolean bmp() {
        if (this.faC != null) {
            return this.faC.bmp();
        }
        return false;
    }

    public int bjk() {
        if (this.eOH != null) {
            return this.eOH.bjk();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.faz != null) {
            this.faz.onDestroy();
        }
    }

    public void d(short s) {
        if (this.faA != null) {
            this.faA.d(s);
        }
    }

    public void bjl() {
        if (this.faA != null) {
            this.faA.bjl();
        }
    }

    public void auh() {
        if (this.faA != null) {
            this.faA.auh();
        }
    }

    public void bjm() {
        if (this.faA != null) {
            this.faA.bjm();
        }
    }

    public void bjn() {
        if (this.faA != null) {
            this.faA.bjn();
        }
    }

    public void bjo() {
        if (this.faA != null) {
            this.faA.bjo();
        }
    }

    public void onRtcConnected(int i) {
        if (this.faz != null) {
            this.faz.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.faz != null) {
            this.faz.onPKPlayerFirstFrame();
        }
    }
}
