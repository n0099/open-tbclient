package com.baidu.tieba.ala.liveroom.master.a;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.as;
import com.baidu.live.liveroom.middleware.k;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes10.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.data.d hDt;
    private AlaMasterLiveRoomOpearator hEP;
    private b hEQ;
    private a hES;
    private com.baidu.live.liveroom.middleware.a hET;
    private com.baidu.tieba.ala.liveroom.data.e hqr = new com.baidu.tieba.ala.liveroom.data.e();

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, ViewGroup viewGroup2, com.baidu.live.tieba.e.b bVar, String str, View view) {
        this.hqr.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.hqr.hxA = alaLiveRecorder;
        this.hqr.hxB = view;
        this.hqr.hxC = frameLayout;
        this.hqr.hxk = alaLiveView;
        this.hqr.rootView = viewGroup;
        this.hqr.hxD = viewGroup2;
        this.hqr.hxH = bVar;
        this.hqr.hxE = this;
        this.hqr.hxG = new AlaLiveRecorderPerfData();
        this.hEP = new AlaMasterLiveRoomOpearator(this.hqr, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hET = k.Lh().Li();
            this.hqr.hxI = this.hET;
            this.hET.q(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.p.d dVar) {
        this.hqr.hxj = dVar;
    }

    public void setArModel(com.baidu.live.ar.k kVar) {
        this.hqr.hxF = kVar;
    }

    public void a(b bVar) {
        this.hEQ = bVar;
        if (this.hES != null) {
            this.hES.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.hEP != null) {
            f fVar = null;
            if (obj instanceof f) {
                fVar = (f) obj;
            }
            int a2 = this.hEP.a(fVar);
            if (a2 == 1 || a2 == 2) {
                this.hqr.vj(a2);
            } else {
                return;
            }
        }
        if (this.hES != null) {
            this.hES.a(s, obj);
        }
    }

    public void b(f fVar) {
        a((short) 1, fVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.hDt = dVar;
        if (this.hES != null) {
            this.hES.c(dVar);
        }
    }

    public void bl(int i, String str) {
        if (this.hES != null) {
            this.hES.bl(i, str);
        }
    }

    public void c(as asVar) {
        if (this.hES != null) {
            this.hES.c(asVar);
        }
    }

    public void bm(int i, String str) {
        if (this.hES != null) {
            this.hES.bm(i, str);
        }
    }

    public void j(short s) {
        if (this.hES != null) {
            this.hES.j(s);
        }
        if (this.hET != null) {
            this.hET.Ld();
        }
    }

    public void markEnterBackground() {
        if (this.hES != null) {
            this.hES.markEnterBackground();
        }
        if (this.hET != null) {
            this.hET.onStop();
        }
    }

    public void markEnterForeground() {
        if (this.hES != null) {
            this.hES.markEnterForeground();
        }
        if (this.hEP != null) {
            this.hEP.onResume();
        }
        if (this.hET != null) {
            this.hET.onResume();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.hES != null) {
            this.hES.onPause();
        }
        if (this.hET != null) {
            this.hET.onPause();
        }
    }

    public boolean chK() {
        if (this.hES != null) {
            return this.hES.chK();
        }
        return false;
    }

    public void chL() {
        if (this.hES != null) {
            this.hES.chL();
        }
    }

    public void vL(int i) {
        if (i == 1 && !(this.hES instanceof c)) {
            this.hES = new c(this.hqr);
        } else if (i == 2 && !(this.hES instanceof e)) {
            this.hES = new e(this.hqr);
        } else {
            return;
        }
        this.hES.aq(this.hEP);
        this.hES.a(this.hEQ);
    }

    public void l(int i, int i2, int i3) {
        if (this.hEP != null) {
            this.hEP.l(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hEP != null) {
            this.hEP.onKeyboardVisibilityChanged(z);
        }
        if (this.hET != null) {
            this.hET.e(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hEP != null) {
            this.hEP.onActivityResult(i, i2, intent);
        }
        if (this.hET != null) {
            this.hET.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hET != null) {
            this.hET.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData chN() {
        return this.hqr.hxG;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hEP != null) {
            return this.hEP.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.hEP != null) {
            this.hEP.streamStateReceived(i, z, i2, z2);
        }
    }

    public void sendBufferChanged(int i) {
        if (this.hEP != null) {
            this.hEP.sendBufferChanged(i);
        }
    }

    public void cgZ() {
        if (this.hEP != null) {
            this.hEP.cgZ();
        }
    }

    public void chl() {
        if (this.hEP != null) {
            this.hEP.chl();
        }
    }

    public void cdD() {
        if (this.hEP != null) {
            this.hEP.cdD();
        }
    }

    public void nY(boolean z) {
        if (this.hEP != null) {
            this.hEP.nY(z);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.d chO() {
        return this.hDt;
    }

    public boolean chM() {
        if (this.hES != null) {
            return this.hES.chM();
        }
        return false;
    }

    public int bQu() {
        if (this.hqr != null) {
            return this.hqr.bQu();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.hEP != null) {
            this.hEP.onDestroy();
        }
        if (this.hET != null) {
            this.hET.cw(false);
        }
    }

    public void g(short s) {
        if (this.hEQ != null) {
            this.hEQ.g(s);
        }
        if (this.hEP != null) {
            this.hEP.b(s);
        }
    }

    public void Vz() {
        if (this.hEQ != null) {
            this.hEQ.Vz();
        }
    }

    public void cdF() {
        if (this.hEQ != null) {
            this.hEQ.cdF();
        }
    }

    public void cdG() {
        if (this.hEQ != null) {
            this.hEQ.cdG();
        }
    }

    public void cdH() {
        if (this.hEQ != null) {
            this.hEQ.cdH();
        }
    }

    public void cdI() {
        if (this.hEQ != null) {
            this.hEQ.cdI();
        }
    }

    public void onRtcConnected(int i) {
        if (this.hEP != null) {
            this.hEP.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.hEP != null) {
            this.hEP.onPKPlayerFirstFrame();
        }
    }
}
