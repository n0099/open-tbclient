package com.baidu.tieba.ala.liveroom.master.a;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.ar.h;
import com.baidu.live.liveroom.middleware.k;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes3.dex */
public class d {
    private f fYL = new f();
    private com.baidu.tieba.ala.liveroom.data.e glk;
    private AlaMasterLiveRoomOpearator gmH;
    private b gmI;
    private a gmK;
    private com.baidu.live.liveroom.middleware.a gmL;

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, ViewGroup viewGroup2, com.baidu.live.tieba.e.b bVar, String str) {
        this.fYL.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.fYL.ggs = alaLiveRecorder;
        this.fYL.ggt = frameLayout;
        this.fYL.gfT = alaLiveView;
        this.fYL.rootView = viewGroup;
        this.fYL.ggu = viewGroup2;
        this.fYL.ggy = bVar;
        this.fYL.ggv = this;
        this.fYL.ggx = new AlaLiveRecorderPerfData();
        this.gmH = new AlaMasterLiveRoomOpearator(this.fYL, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gmL = k.FD().FE();
            this.fYL.ggz = this.gmL;
            this.gmL.q(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.n.c cVar) {
        this.fYL.gfS = cVar;
    }

    public void setArModel(h hVar) {
        this.fYL.ggw = hVar;
    }

    public void a(b bVar) {
        this.gmI = bVar;
        if (this.gmK != null) {
            this.gmK.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.gmH != null) {
            g gVar = null;
            if (obj instanceof g) {
                gVar = (g) obj;
            }
            int a = this.gmH.a(gVar);
            if (a == 1 || a == 2) {
                this.fYL.ru(a);
            } else {
                return;
            }
        }
        if (this.gmK != null) {
            this.gmK.a(s, obj);
        }
    }

    public void b(g gVar) {
        a((short) 1, gVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.glk = eVar;
        if (this.gmK != null) {
            this.gmK.c(eVar);
        }
    }

    public void aU(int i, String str) {
        if (this.gmK != null) {
            this.gmK.aU(i, str);
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.h hVar) {
        if (this.gmK != null) {
            this.gmK.c(hVar);
        }
    }

    public void aV(int i, String str) {
        if (this.gmK != null) {
            this.gmK.aV(i, str);
        }
    }

    public void i(short s) {
        if (this.gmK != null) {
            this.gmK.i(s);
        }
        if (this.gmL != null) {
            this.gmL.Fz();
        }
    }

    public void bHF() {
        if (this.gmK != null) {
            this.gmK.bHF();
        }
        if (this.gmL != null) {
            this.gmL.onStop();
        }
    }

    public void bHG() {
        if (this.gmK != null) {
            this.gmK.bHG();
        }
        if (this.gmH != null) {
            this.gmH.onResume();
        }
        if (this.gmL != null) {
            this.gmL.onResume();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.gmK != null) {
            this.gmK.onPause();
        }
        if (this.gmL != null) {
            this.gmL.onPause();
        }
    }

    public boolean bHH() {
        if (this.gmK != null) {
            return this.gmK.bHH();
        }
        return false;
    }

    public void bHI() {
        if (this.gmK != null) {
            this.gmK.bHI();
        }
    }

    public void rR(int i) {
        if (i == 1 && !(this.gmK instanceof c)) {
            this.gmK = new c(this.fYL);
        } else if (i == 2 && !(this.gmK instanceof e)) {
            this.gmK = new e(this.fYL);
        } else {
            return;
        }
        this.gmK.aj(this.gmH);
        this.gmK.a(this.gmI);
    }

    public void l(int i, int i2, int i3) {
        if (this.gmH != null) {
            this.gmH.l(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gmH != null) {
            this.gmH.onKeyboardVisibilityChanged(z);
        }
        if (this.gmL != null) {
            this.gmL.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gmH != null) {
            this.gmH.onActivityResult(i, i2, intent);
        }
        if (this.gmL != null) {
            this.gmL.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.gmL != null) {
            this.gmL.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData bHK() {
        return this.fYL.ggx;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.gmH != null) {
            return this.gmH.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.gmH != null) {
            this.gmH.streamStateReceived(i, z, i2, z2);
        }
    }

    public void bGV() {
        if (this.gmH != null) {
            this.gmH.bGV();
        }
    }

    public void bHh() {
        if (this.gmH != null) {
            this.gmH.bHh();
        }
    }

    public void bEj() {
        if (this.gmH != null) {
            this.gmH.bEj();
        }
    }

    public void kW(boolean z) {
        if (this.gmH != null) {
            this.gmH.kW(z);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.e bHL() {
        return this.glk;
    }

    public boolean bHJ() {
        if (this.gmK != null) {
            return this.gmK.bHJ();
        }
        return false;
    }

    public int bEl() {
        if (this.fYL != null) {
            return this.fYL.bEl();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.gmH != null) {
            this.gmH.onDestroy();
        }
        if (this.gmL != null) {
            this.gmL.bT(false);
        }
    }

    public void f(short s) {
        if (this.gmI != null) {
            this.gmI.f(s);
        }
    }

    public void Ku() {
        if (this.gmI != null) {
            this.gmI.Ku();
        }
    }

    public void aLF() {
        if (this.gmI != null) {
            this.gmI.aLF();
        }
    }

    public void bEm() {
        if (this.gmI != null) {
            this.gmI.bEm();
        }
    }

    public void bEn() {
        if (this.gmI != null) {
            this.gmI.bEn();
        }
    }

    public void bEo() {
        if (this.gmI != null) {
            this.gmI.bEo();
        }
    }

    public void onRtcConnected(int i) {
        if (this.gmH != null) {
            this.gmH.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.gmH != null) {
            this.gmH.onPKPlayerFirstFrame();
        }
    }
}
