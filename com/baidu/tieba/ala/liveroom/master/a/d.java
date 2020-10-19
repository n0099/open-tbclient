package com.baidu.tieba.ala.liveroom.master.a;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.ar.h;
import com.baidu.live.data.al;
import com.baidu.live.liveroom.middleware.k;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes4.dex */
public class d {
    private f gHQ = new f();
    private com.baidu.tieba.ala.liveroom.data.e gVf;
    private AlaMasterLiveRoomOpearator gWA;
    private b gWB;
    private a gWE;
    private com.baidu.live.liveroom.middleware.a gWF;

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, ViewGroup viewGroup2, com.baidu.live.tieba.e.b bVar, String str) {
        this.gHQ.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.gHQ.gPm = alaLiveRecorder;
        this.gHQ.gPn = frameLayout;
        this.gHQ.gOO = alaLiveView;
        this.gHQ.rootView = viewGroup;
        this.gHQ.gPo = viewGroup2;
        this.gHQ.gPs = bVar;
        this.gHQ.gPp = this;
        this.gHQ.gPr = new AlaLiveRecorderPerfData();
        this.gWA = new AlaMasterLiveRoomOpearator(this.gHQ, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gWF = k.ML().MM();
            this.gHQ.gPt = this.gWF;
            this.gWF.s(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.q.d dVar) {
        this.gHQ.gON = dVar;
    }

    public void setArModel(h hVar) {
        this.gHQ.gPq = hVar;
    }

    public void a(b bVar) {
        this.gWB = bVar;
        if (this.gWE != null) {
            this.gWE.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.gWA != null) {
            g gVar = null;
            if (obj instanceof g) {
                gVar = (g) obj;
            }
            int a2 = this.gWA.a(gVar);
            if (a2 == 1 || a2 == 2) {
                this.gHQ.uU(a2);
            } else {
                return;
            }
        }
        if (this.gWE != null) {
            this.gWE.a(s, obj);
        }
    }

    public void b(g gVar) {
        a((short) 1, gVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.gVf = eVar;
        if (this.gWE != null) {
            this.gWE.c(eVar);
        }
    }

    public void be(int i, String str) {
        if (this.gWE != null) {
            this.gWE.be(i, str);
        }
    }

    public void c(al alVar) {
        if (this.gWE != null) {
            this.gWE.c(alVar);
        }
    }

    public void bf(int i, String str) {
        if (this.gWE != null) {
            this.gWE.bf(i, str);
        }
    }

    public void i(short s) {
        if (this.gWE != null) {
            this.gWE.i(s);
        }
        if (this.gWF != null) {
            this.gWF.MH();
        }
    }

    public void bZU() {
        if (this.gWE != null) {
            this.gWE.bZU();
        }
        if (this.gWF != null) {
            this.gWF.onStop();
        }
    }

    public void bZV() {
        if (this.gWE != null) {
            this.gWE.bZV();
        }
        if (this.gWA != null) {
            this.gWA.onResume();
        }
        if (this.gWF != null) {
            this.gWF.onResume();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.gWE != null) {
            this.gWE.onPause();
        }
        if (this.gWF != null) {
            this.gWF.onPause();
        }
    }

    public boolean bZW() {
        if (this.gWE != null) {
            return this.gWE.bZW();
        }
        return false;
    }

    public void bZX() {
        if (this.gWE != null) {
            this.gWE.bZX();
        }
    }

    public void vw(int i) {
        if (i == 1 && !(this.gWE instanceof c)) {
            this.gWE = new c(this.gHQ);
        } else if (i == 2 && !(this.gWE instanceof e)) {
            this.gWE = new e(this.gHQ);
        } else {
            return;
        }
        this.gWE.ak(this.gWA);
        this.gWE.a(this.gWB);
    }

    public void l(int i, int i2, int i3) {
        if (this.gWA != null) {
            this.gWA.l(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gWA != null) {
            this.gWA.onKeyboardVisibilityChanged(z);
        }
        if (this.gWF != null) {
            this.gWF.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gWA != null) {
            this.gWA.onActivityResult(i, i2, intent);
        }
        if (this.gWF != null) {
            this.gWF.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.gWF != null) {
            this.gWF.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData bZZ() {
        return this.gHQ.gPr;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.gWA != null) {
            return this.gWA.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.gWA != null) {
            this.gWA.streamStateReceived(i, z, i2, z2);
        }
    }

    public void bZk() {
        if (this.gWA != null) {
            this.gWA.bZk();
        }
    }

    public void bZw() {
        if (this.gWA != null) {
            this.gWA.bZw();
        }
    }

    public void bVO() {
        if (this.gWA != null) {
            this.gWA.bVO();
        }
    }

    public void mH(boolean z) {
        if (this.gWA != null) {
            this.gWA.mH(z);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.e caa() {
        return this.gVf;
    }

    public boolean bZY() {
        if (this.gWE != null) {
            return this.gWE.bZY();
        }
        return false;
    }

    public int bVQ() {
        if (this.gHQ != null) {
            return this.gHQ.bVQ();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.gWA != null) {
            this.gWA.onDestroy();
            this.gWE.onDestroy();
        }
        if (this.gWF != null) {
            this.gWF.ce(false);
        }
    }

    public void f(short s) {
        if (this.gWB != null) {
            this.gWB.f(s);
        }
    }

    public void ST() {
        if (this.gWB != null) {
            this.gWB.ST();
        }
    }

    public void bbd() {
        if (this.gWB != null) {
            this.gWB.bbd();
        }
    }

    public void bVR() {
        if (this.gWB != null) {
            this.gWB.bVR();
        }
    }

    public void bVS() {
        if (this.gWB != null) {
            this.gWB.bVS();
        }
    }

    public void bVT() {
        if (this.gWB != null) {
            this.gWB.bVT();
        }
    }

    public void onRtcConnected(int i) {
        if (this.gWA != null) {
            this.gWA.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.gWA != null) {
            this.gWA.onPKPlayerFirstFrame();
        }
    }
}
