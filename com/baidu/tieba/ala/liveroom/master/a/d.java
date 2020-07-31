package com.baidu.tieba.ala.liveroom.master.a;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.ar.h;
import com.baidu.live.data.ae;
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
    private f gdS = new f();
    private com.baidu.tieba.ala.liveroom.data.e gqi;
    private AlaMasterLiveRoomOpearator grF;
    private b grG;
    private a grI;
    private com.baidu.live.liveroom.middleware.a grJ;

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, ViewGroup viewGroup2, com.baidu.live.tieba.e.b bVar, String str) {
        this.gdS.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.gdS.glA = alaLiveRecorder;
        this.gdS.glB = frameLayout;
        this.gdS.glb = alaLiveView;
        this.gdS.rootView = viewGroup;
        this.gdS.glC = viewGroup2;
        this.gdS.glG = bVar;
        this.gdS.glD = this;
        this.gdS.glF = new AlaLiveRecorderPerfData();
        this.grF = new AlaMasterLiveRoomOpearator(this.gdS, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.grJ = k.Fx().Fy();
            this.gdS.glH = this.grJ;
            this.grJ.r(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.o.c cVar) {
        this.gdS.gla = cVar;
    }

    public void setArModel(h hVar) {
        this.gdS.glE = hVar;
    }

    public void a(b bVar) {
        this.grG = bVar;
        if (this.grI != null) {
            this.grI.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.grF != null) {
            g gVar = null;
            if (obj instanceof g) {
                gVar = (g) obj;
            }
            int a = this.grF.a(gVar);
            if (a == 1 || a == 2) {
                this.gdS.rK(a);
            } else {
                return;
            }
        }
        if (this.grI != null) {
            this.grI.a(s, obj);
        }
    }

    public void b(g gVar) {
        a((short) 1, gVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.gqi = eVar;
        if (this.grI != null) {
            this.grI.c(eVar);
        }
    }

    public void aW(int i, String str) {
        if (this.grI != null) {
            this.grI.aW(i, str);
        }
    }

    public void c(ae aeVar) {
        if (this.grI != null) {
            this.grI.c(aeVar);
        }
    }

    public void aX(int i, String str) {
        if (this.grI != null) {
            this.grI.aX(i, str);
        }
    }

    public void i(short s) {
        if (this.grI != null) {
            this.grI.i(s);
        }
        if (this.grJ != null) {
            this.grJ.Ft();
        }
    }

    public void bKL() {
        if (this.grI != null) {
            this.grI.bKL();
        }
        if (this.grJ != null) {
            this.grJ.onStop();
        }
    }

    public void bKM() {
        if (this.grI != null) {
            this.grI.bKM();
        }
        if (this.grF != null) {
            this.grF.onResume();
        }
        if (this.grJ != null) {
            this.grJ.onResume();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.grI != null) {
            this.grI.onPause();
        }
        if (this.grJ != null) {
            this.grJ.onPause();
        }
    }

    public boolean bKN() {
        if (this.grI != null) {
            return this.grI.bKN();
        }
        return false;
    }

    public void bKO() {
        if (this.grI != null) {
            this.grI.bKO();
        }
    }

    public void si(int i) {
        if (i == 1 && !(this.grI instanceof c)) {
            this.grI = new c(this.gdS);
        } else if (i == 2 && !(this.grI instanceof e)) {
            this.grI = new e(this.gdS);
        } else {
            return;
        }
        this.grI.ag(this.grF);
        this.grI.a(this.grG);
    }

    public void l(int i, int i2, int i3) {
        if (this.grF != null) {
            this.grF.l(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.grF != null) {
            this.grF.onKeyboardVisibilityChanged(z);
        }
        if (this.grJ != null) {
            this.grJ.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.grF != null) {
            this.grF.onActivityResult(i, i2, intent);
        }
        if (this.grJ != null) {
            this.grJ.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.grJ != null) {
            this.grJ.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData bKQ() {
        return this.gdS.glF;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.grF != null) {
            return this.grF.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.grF != null) {
            this.grF.streamStateReceived(i, z, i2, z2);
        }
    }

    public void bKb() {
        if (this.grF != null) {
            this.grF.bKb();
        }
    }

    public void bKn() {
        if (this.grF != null) {
            this.grF.bKn();
        }
    }

    public void bHu() {
        if (this.grF != null) {
            this.grF.bHu();
        }
    }

    public void lz(boolean z) {
        if (this.grF != null) {
            this.grF.lz(z);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.e bKR() {
        return this.gqi;
    }

    public boolean bKP() {
        if (this.grI != null) {
            return this.grI.bKP();
        }
        return false;
    }

    public int bHw() {
        if (this.gdS != null) {
            return this.gdS.bHw();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.grF != null) {
            this.grF.onDestroy();
        }
        if (this.grJ != null) {
            this.grJ.bU(false);
        }
    }

    public void f(short s) {
        if (this.grG != null) {
            this.grG.f(s);
        }
    }

    public void KB() {
        if (this.grG != null) {
            this.grG.KB();
        }
    }

    public void aPt() {
        if (this.grG != null) {
            this.grG.aPt();
        }
    }

    public void bHx() {
        if (this.grG != null) {
            this.grG.bHx();
        }
    }

    public void bHy() {
        if (this.grG != null) {
            this.grG.bHy();
        }
    }

    public void bHz() {
        if (this.grG != null) {
            this.grG.bHz();
        }
    }

    public void onRtcConnected(int i) {
        if (this.grF != null) {
            this.grF.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.grF != null) {
            this.grF.onPKPlayerFirstFrame();
        }
    }
}
