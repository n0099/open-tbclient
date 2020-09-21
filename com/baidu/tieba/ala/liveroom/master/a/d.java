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
    private com.baidu.tieba.ala.liveroom.data.e gGG;
    private AlaMasterLiveRoomOpearator gIa;
    private b gIb;
    private a gIe;
    private com.baidu.live.liveroom.middleware.a gIf;
    private f gtv = new f();

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, ViewGroup viewGroup2, com.baidu.live.tieba.e.b bVar, String str) {
        this.gtv.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.gtv.gAT = alaLiveRecorder;
        this.gtv.gAU = frameLayout;
        this.gtv.gAv = alaLiveView;
        this.gtv.rootView = viewGroup;
        this.gtv.gAV = viewGroup2;
        this.gtv.gAZ = bVar;
        this.gtv.gAW = this;
        this.gtv.gAY = new AlaLiveRecorderPerfData();
        this.gIa = new AlaMasterLiveRoomOpearator(this.gtv, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gIf = k.LH().LI();
            this.gtv.gBa = this.gIf;
            this.gIf.r(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.q.d dVar) {
        this.gtv.gAu = dVar;
    }

    public void setArModel(h hVar) {
        this.gtv.gAX = hVar;
    }

    public void a(b bVar) {
        this.gIb = bVar;
        if (this.gIe != null) {
            this.gIe.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.gIa != null) {
            g gVar = null;
            if (obj instanceof g) {
                gVar = (g) obj;
            }
            int a = this.gIa.a(gVar);
            if (a == 1 || a == 2) {
                this.gtv.up(a);
            } else {
                return;
            }
        }
        if (this.gIe != null) {
            this.gIe.a(s, obj);
        }
    }

    public void b(g gVar) {
        a((short) 1, gVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.gGG = eVar;
        if (this.gIe != null) {
            this.gIe.c(eVar);
        }
    }

    public void aU(int i, String str) {
        if (this.gIe != null) {
            this.gIe.aU(i, str);
        }
    }

    public void c(al alVar) {
        if (this.gIe != null) {
            this.gIe.c(alVar);
        }
    }

    public void aV(int i, String str) {
        if (this.gIe != null) {
            this.gIe.aV(i, str);
        }
    }

    public void i(short s) {
        if (this.gIe != null) {
            this.gIe.i(s);
        }
        if (this.gIf != null) {
            this.gIf.LD();
        }
    }

    public void bWz() {
        if (this.gIe != null) {
            this.gIe.bWz();
        }
        if (this.gIf != null) {
            this.gIf.onStop();
        }
    }

    public void bWA() {
        if (this.gIe != null) {
            this.gIe.bWA();
        }
        if (this.gIa != null) {
            this.gIa.onResume();
        }
        if (this.gIf != null) {
            this.gIf.onResume();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.gIe != null) {
            this.gIe.onPause();
        }
        if (this.gIf != null) {
            this.gIf.onPause();
        }
    }

    public boolean bWB() {
        if (this.gIe != null) {
            return this.gIe.bWB();
        }
        return false;
    }

    public void bWC() {
        if (this.gIe != null) {
            this.gIe.bWC();
        }
    }

    public void uR(int i) {
        if (i == 1 && !(this.gIe instanceof c)) {
            this.gIe = new c(this.gtv);
        } else if (i == 2 && !(this.gIe instanceof e)) {
            this.gIe = new e(this.gtv);
        } else {
            return;
        }
        this.gIe.ah(this.gIa);
        this.gIe.a(this.gIb);
    }

    public void l(int i, int i2, int i3) {
        if (this.gIa != null) {
            this.gIa.l(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gIa != null) {
            this.gIa.onKeyboardVisibilityChanged(z);
        }
        if (this.gIf != null) {
            this.gIf.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gIa != null) {
            this.gIa.onActivityResult(i, i2, intent);
        }
        if (this.gIf != null) {
            this.gIf.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.gIf != null) {
            this.gIf.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData bWE() {
        return this.gtv.gAY;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.gIa != null) {
            return this.gIa.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.gIa != null) {
            this.gIa.streamStateReceived(i, z, i2, z2);
        }
    }

    public void bVP() {
        if (this.gIa != null) {
            this.gIa.bVP();
        }
    }

    public void bWb() {
        if (this.gIa != null) {
            this.gIa.bWb();
        }
    }

    public void bSv() {
        if (this.gIa != null) {
            this.gIa.bSv();
        }
    }

    public void mf(boolean z) {
        if (this.gIa != null) {
            this.gIa.mf(z);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.e bWF() {
        return this.gGG;
    }

    public boolean bWD() {
        if (this.gIe != null) {
            return this.gIe.bWD();
        }
        return false;
    }

    public int bSx() {
        if (this.gtv != null) {
            return this.gtv.bSx();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.gIa != null) {
            this.gIa.onDestroy();
            this.gIe.onDestroy();
        }
        if (this.gIf != null) {
            this.gIf.cb(false);
        }
    }

    public void f(short s) {
        if (this.gIb != null) {
            this.gIb.f(s);
        }
    }

    public void Rb() {
        if (this.gIb != null) {
            this.gIb.Rb();
        }
    }

    public void aYv() {
        if (this.gIb != null) {
            this.gIb.aYv();
        }
    }

    public void bSy() {
        if (this.gIb != null) {
            this.gIb.bSy();
        }
    }

    public void bSz() {
        if (this.gIb != null) {
            this.gIb.bSz();
        }
    }

    public void bSA() {
        if (this.gIb != null) {
            this.gIb.bSA();
        }
    }

    public void onRtcConnected(int i) {
        if (this.gIa != null) {
            this.gIa.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.gIa != null) {
            this.gIa.onPKPlayerFirstFrame();
        }
    }
}
