package com.baidu.tieba.ala.liveroom.master.a;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.ar.h;
import com.baidu.live.data.ag;
import com.baidu.live.liveroom.middleware.k;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes7.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.data.e gDf;
    private AlaMasterLiveRoomOpearator gED;
    private b gEE;
    private a gEG;
    private com.baidu.live.liveroom.middleware.a gEH;
    private f gqf = new f();

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, ViewGroup viewGroup2, com.baidu.live.tieba.e.b bVar, String str) {
        this.gqf.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.gqf.gxI = alaLiveRecorder;
        this.gqf.gxJ = frameLayout;
        this.gqf.gxj = alaLiveView;
        this.gqf.rootView = viewGroup;
        this.gqf.gxK = viewGroup2;
        this.gqf.gxO = bVar;
        this.gqf.gxL = this;
        this.gqf.gxN = new AlaLiveRecorderPerfData();
        this.gED = new AlaMasterLiveRoomOpearator(this.gqf, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gEH = k.Le().Lf();
            this.gqf.gxP = this.gEH;
            this.gEH.r(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.p.d dVar) {
        this.gqf.gxi = dVar;
    }

    public void setArModel(h hVar) {
        this.gqf.gxM = hVar;
    }

    public void a(b bVar) {
        this.gEE = bVar;
        if (this.gEG != null) {
            this.gEG.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.gED != null) {
            g gVar = null;
            if (obj instanceof g) {
                gVar = (g) obj;
            }
            int a = this.gED.a(gVar);
            if (a == 1 || a == 2) {
                this.gqf.tW(a);
            } else {
                return;
            }
        }
        if (this.gEG != null) {
            this.gEG.a(s, obj);
        }
    }

    public void b(g gVar) {
        a((short) 1, gVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.gDf = eVar;
        if (this.gEG != null) {
            this.gEG.c(eVar);
        }
    }

    public void aT(int i, String str) {
        if (this.gEG != null) {
            this.gEG.aT(i, str);
        }
    }

    public void c(ag agVar) {
        if (this.gEG != null) {
            this.gEG.c(agVar);
        }
    }

    public void aU(int i, String str) {
        if (this.gEG != null) {
            this.gEG.aU(i, str);
        }
    }

    public void i(short s) {
        if (this.gEG != null) {
            this.gEG.i(s);
        }
        if (this.gEH != null) {
            this.gEH.La();
        }
    }

    public void bUP() {
        if (this.gEG != null) {
            this.gEG.bUP();
        }
        if (this.gEH != null) {
            this.gEH.onStop();
        }
    }

    public void bUQ() {
        if (this.gEG != null) {
            this.gEG.bUQ();
        }
        if (this.gED != null) {
            this.gED.onResume();
        }
        if (this.gEH != null) {
            this.gEH.onResume();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.gEG != null) {
            this.gEG.onPause();
        }
        if (this.gEH != null) {
            this.gEH.onPause();
        }
    }

    public boolean bUR() {
        if (this.gEG != null) {
            return this.gEG.bUR();
        }
        return false;
    }

    public void bUS() {
        if (this.gEG != null) {
            this.gEG.bUS();
        }
    }

    public void uy(int i) {
        if (i == 1 && !(this.gEG instanceof c)) {
            this.gEG = new c(this.gqf);
        } else if (i == 2 && !(this.gEG instanceof e)) {
            this.gEG = new e(this.gqf);
        } else {
            return;
        }
        this.gEG.ai(this.gED);
        this.gEG.a(this.gEE);
    }

    public void l(int i, int i2, int i3) {
        if (this.gED != null) {
            this.gED.l(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gED != null) {
            this.gED.onKeyboardVisibilityChanged(z);
        }
        if (this.gEH != null) {
            this.gEH.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gED != null) {
            this.gED.onActivityResult(i, i2, intent);
        }
        if (this.gEH != null) {
            this.gEH.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.gEH != null) {
            this.gEH.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData bUU() {
        return this.gqf.gxN;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.gED != null) {
            return this.gED.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.gED != null) {
            this.gED.streamStateReceived(i, z, i2, z2);
        }
    }

    public void bUf() {
        if (this.gED != null) {
            this.gED.bUf();
        }
    }

    public void bUr() {
        if (this.gED != null) {
            this.gED.bUr();
        }
    }

    public void bQZ() {
        if (this.gED != null) {
            this.gED.bQZ();
        }
    }

    public void mc(boolean z) {
        if (this.gED != null) {
            this.gED.mc(z);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.e bUV() {
        return this.gDf;
    }

    public boolean bUT() {
        if (this.gEG != null) {
            return this.gEG.bUT();
        }
        return false;
    }

    public int bRb() {
        if (this.gqf != null) {
            return this.gqf.bRb();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.gED != null) {
            this.gED.onDestroy();
        }
        if (this.gEH != null) {
            this.gEH.cb(false);
        }
    }

    public void f(short s) {
        if (this.gEE != null) {
            this.gEE.f(s);
        }
    }

    public void Qt() {
        if (this.gEE != null) {
            this.gEE.Qt();
        }
    }

    public void aXJ() {
        if (this.gEE != null) {
            this.gEE.aXJ();
        }
    }

    public void bRc() {
        if (this.gEE != null) {
            this.gEE.bRc();
        }
    }

    public void bRd() {
        if (this.gEE != null) {
            this.gEE.bRd();
        }
    }

    public void bRe() {
        if (this.gEE != null) {
            this.gEE.bRe();
        }
    }

    public void onRtcConnected(int i) {
        if (this.gED != null) {
            this.gED.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.gED != null) {
            this.gED.onPKPlayerFirstFrame();
        }
    }
}
