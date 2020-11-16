package com.baidu.tieba.ala.liveroom.master.a;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.ar.j;
import com.baidu.live.data.ap;
import com.baidu.live.liveroom.middleware.k;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes4.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.data.e gZr = new com.baidu.tieba.ala.liveroom.data.e();
    private com.baidu.tieba.ala.liveroom.data.d hmx;
    private AlaMasterLiveRoomOpearator hnO;
    private b hnP;
    private a hnS;
    private com.baidu.live.liveroom.middleware.a hnT;

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, ViewGroup viewGroup2, com.baidu.live.tieba.e.b bVar, String str, View view) {
        this.gZr.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.gZr.hgB = alaLiveRecorder;
        this.gZr.hgC = view;
        this.gZr.hgD = frameLayout;
        this.gZr.hgl = alaLiveView;
        this.gZr.rootView = viewGroup;
        this.gZr.hgE = viewGroup2;
        this.gZr.hgI = bVar;
        this.gZr.hgF = this;
        this.gZr.hgH = new AlaLiveRecorderPerfData();
        this.hnO = new AlaMasterLiveRoomOpearator(this.gZr, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hnT = k.MW().MX();
            this.gZr.hgJ = this.hnT;
            this.hnT.r(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.q.d dVar) {
        this.gZr.hgk = dVar;
    }

    public void setArModel(j jVar) {
        this.gZr.hgG = jVar;
    }

    public void a(b bVar) {
        this.hnP = bVar;
        if (this.hnS != null) {
            this.hnS.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.hnO != null) {
            f fVar = null;
            if (obj instanceof f) {
                fVar = (f) obj;
            }
            int a2 = this.hnO.a(fVar);
            if (a2 == 1 || a2 == 2) {
                this.gZr.vZ(a2);
            } else {
                return;
            }
        }
        if (this.hnS != null) {
            this.hnS.a(s, obj);
        }
    }

    public void b(f fVar) {
        a((short) 1, fVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.hmx = dVar;
        if (this.hnS != null) {
            this.hnS.c(dVar);
        }
    }

    public void bi(int i, String str) {
        if (this.hnS != null) {
            this.hnS.bi(i, str);
        }
    }

    public void c(ap apVar) {
        if (this.hnS != null) {
            this.hnS.c(apVar);
        }
    }

    public void bj(int i, String str) {
        if (this.hnS != null) {
            this.hnS.bj(i, str);
        }
    }

    public void j(short s) {
        if (this.hnS != null) {
            this.hnS.j(s);
        }
        if (this.hnT != null) {
            this.hnT.MS();
        }
    }

    public void ceS() {
        if (this.hnS != null) {
            this.hnS.ceS();
        }
        if (this.hnT != null) {
            this.hnT.onStop();
        }
    }

    public void ceT() {
        if (this.hnS != null) {
            this.hnS.ceT();
        }
        if (this.hnO != null) {
            this.hnO.onResume();
        }
        if (this.hnT != null) {
            this.hnT.onResume();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.hnS != null) {
            this.hnS.onPause();
        }
        if (this.hnT != null) {
            this.hnT.onPause();
        }
    }

    public boolean ceU() {
        if (this.hnS != null) {
            return this.hnS.ceU();
        }
        return false;
    }

    public void ceV() {
        if (this.hnS != null) {
            this.hnS.ceV();
        }
    }

    public void wB(int i) {
        if (i == 1 && !(this.hnS instanceof c)) {
            this.hnS = new c(this.gZr);
        } else if (i == 2 && !(this.hnS instanceof e)) {
            this.hnS = new e(this.gZr);
        } else {
            return;
        }
        this.hnS.ak(this.hnO);
        this.hnS.a(this.hnP);
    }

    public void l(int i, int i2, int i3) {
        if (this.hnO != null) {
            this.hnO.l(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hnO != null) {
            this.hnO.onKeyboardVisibilityChanged(z);
        }
        if (this.hnT != null) {
            this.hnT.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hnO != null) {
            this.hnO.onActivityResult(i, i2, intent);
        }
        if (this.hnT != null) {
            this.hnT.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hnT != null) {
            this.hnT.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData ceX() {
        return this.gZr.hgH;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hnO != null) {
            return this.hnO.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.hnO != null) {
            this.hnO.streamStateReceived(i, z, i2, z2);
        }
    }

    public void cei() {
        if (this.hnO != null) {
            this.hnO.cei();
        }
    }

    public void ceu() {
        if (this.hnO != null) {
            this.hnO.ceu();
        }
    }

    public void caI() {
        if (this.hnO != null) {
            this.hnO.caI();
        }
    }

    public void nh(boolean z) {
        if (this.hnO != null) {
            this.hnO.nh(z);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.d ceY() {
        return this.hmx;
    }

    public boolean ceW() {
        if (this.hnS != null) {
            return this.hnS.ceW();
        }
        return false;
    }

    public int caK() {
        if (this.gZr != null) {
            return this.gZr.caK();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.hnO != null) {
            this.hnO.onDestroy();
            this.hnS.onDestroy();
        }
        if (this.hnT != null) {
            this.hnT.cj(false);
        }
    }

    public void g(short s) {
        if (this.hnP != null) {
            this.hnP.g(s);
        }
        if (this.hnO != null) {
            this.hnO.b(s);
        }
    }

    public void VJ() {
        if (this.hnP != null) {
            this.hnP.VJ();
        }
    }

    public void beP() {
        if (this.hnP != null) {
            this.hnP.beP();
        }
    }

    public void caL() {
        if (this.hnP != null) {
            this.hnP.caL();
        }
    }

    public void caM() {
        if (this.hnP != null) {
            this.hnP.caM();
        }
    }

    public void caN() {
        if (this.hnP != null) {
            this.hnP.caN();
        }
    }

    public void onRtcConnected(int i) {
        if (this.hnO != null) {
            this.hnO.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.hnO != null) {
            this.hnO.onPKPlayerFirstFrame();
        }
    }
}
