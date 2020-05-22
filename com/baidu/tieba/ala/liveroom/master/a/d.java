package com.baidu.tieba.ala.liveroom.master.a;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
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
    private f fNl = new f();
    private com.baidu.tieba.ala.liveroom.data.e fXX;
    private a fZB;
    private com.baidu.live.liveroom.middleware.a fZC;
    private AlaMasterLiveRoomOpearator fZy;
    private b fZz;

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, com.baidu.live.tieba.e.b bVar, String str) {
        this.fNl.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.fNl.fTB = alaLiveRecorder;
        this.fNl.fTC = frameLayout;
        this.fNl.fTc = alaLiveView;
        this.fNl.rootView = viewGroup;
        this.fNl.fTG = bVar;
        this.fNl.fTD = this;
        this.fNl.fTF = new AlaLiveRecorderPerfData();
        this.fZy = new AlaMasterLiveRoomOpearator(this.fNl, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fZC = k.EU().EV();
            this.fNl.fTH = this.fZC;
            this.fZC.q(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.m.c cVar) {
        this.fNl.fTb = cVar;
    }

    public void setArModel(com.baidu.live.ar.f fVar) {
        this.fNl.fTE = fVar;
    }

    public void a(b bVar) {
        this.fZz = bVar;
        if (this.fZB != null) {
            this.fZB.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.fZy != null) {
            g gVar = null;
            if (obj instanceof g) {
                gVar = (g) obj;
            }
            int a = this.fZy.a(gVar);
            if (a == 1 || a == 2) {
                this.fNl.qT(a);
            } else {
                return;
            }
        }
        if (this.fZB != null) {
            this.fZB.a(s, obj);
        }
    }

    public void b(g gVar) {
        a((short) 1, gVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.fXX = eVar;
        if (this.fZB != null) {
            this.fZB.c(eVar);
        }
    }

    public void aQ(int i, String str) {
        if (this.fZB != null) {
            this.fZB.aQ(i, str);
        }
    }

    public void c(h hVar) {
        if (this.fZB != null) {
            this.fZB.c(hVar);
        }
    }

    public void aR(int i, String str) {
        if (this.fZB != null) {
            this.fZB.aR(i, str);
        }
    }

    public void i(short s) {
        if (this.fZB != null) {
            this.fZB.i(s);
        }
        if (this.fZC != null) {
            this.fZC.EQ();
        }
    }

    public void bEw() {
        if (this.fZB != null) {
            this.fZB.bEw();
        }
        if (this.fZC != null) {
            this.fZC.onStop();
        }
    }

    public void bEx() {
        if (this.fZB != null) {
            this.fZB.bEx();
        }
        if (this.fZy != null) {
            this.fZy.onResume();
        }
        if (this.fZC != null) {
            this.fZC.onResume();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.fZB != null) {
            this.fZB.onPause();
        }
        if (this.fZC != null) {
            this.fZC.onPause();
        }
    }

    public boolean bEy() {
        if (this.fZB != null) {
            return this.fZB.bEy();
        }
        return false;
    }

    public void bEz() {
        if (this.fZB != null) {
            this.fZB.bEz();
        }
    }

    public void rr(int i) {
        if (i == 1 && !(this.fZB instanceof c)) {
            this.fZB = new c(this.fNl);
        } else if (i == 2 && !(this.fZB instanceof e)) {
            this.fZB = new e(this.fNl);
        } else {
            return;
        }
        this.fZB.ai(this.fZy);
        this.fZB.a(this.fZz);
    }

    public void l(int i, int i2, int i3) {
        if (this.fZy != null) {
            this.fZy.l(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fZy != null) {
            this.fZy.onKeyboardVisibilityChanged(z);
        }
        if (this.fZC != null) {
            this.fZC.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fZy != null) {
            this.fZy.onActivityResult(i, i2, intent);
        }
        if (this.fZC != null) {
            this.fZC.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.fZC != null) {
            this.fZC.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData bEB() {
        return this.fNl.fTF;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fZy != null) {
            return this.fZy.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.fZy != null) {
            this.fZy.streamStateReceived(i, z, i2, z2);
        }
    }

    public void bDK() {
        if (this.fZy != null) {
            this.fZy.bDK();
        }
    }

    public void bDW() {
        if (this.fZy != null) {
            this.fZy.bDW();
        }
    }

    public void bBe() {
        if (this.fZy != null) {
            this.fZy.bBe();
        }
    }

    public void kL(boolean z) {
        if (this.fZy != null) {
            this.fZy.kL(z);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.e bEC() {
        return this.fXX;
    }

    public boolean bEA() {
        if (this.fZB != null) {
            return this.fZB.bEA();
        }
        return false;
    }

    public int bBg() {
        if (this.fNl != null) {
            return this.fNl.bBg();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.fZy != null) {
            this.fZy.onDestroy();
        }
        if (this.fZC != null) {
            this.fZC.bR(false);
        }
    }

    public void f(short s) {
        if (this.fZz != null) {
            this.fZz.f(s);
        }
    }

    public void Jh() {
        if (this.fZz != null) {
            this.fZz.Jh();
        }
    }

    public void aKz() {
        if (this.fZz != null) {
            this.fZz.aKz();
        }
    }

    public void bBh() {
        if (this.fZz != null) {
            this.fZz.bBh();
        }
    }

    public void bBi() {
        if (this.fZz != null) {
            this.fZz.bBi();
        }
    }

    public void bBj() {
        if (this.fZz != null) {
            this.fZz.bBj();
        }
    }

    public void onRtcConnected(int i) {
        if (this.fZy != null) {
            this.fZy.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.fZy != null) {
            this.fZy.onPKPlayerFirstFrame();
        }
    }
}
