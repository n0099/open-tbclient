package com.baidu.tieba.ala.liveroom.master.a;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.aw;
import com.baidu.live.liveroom.middleware.k;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes11.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.data.d hHU;
    private AlaMasterLiveRoomOpearator hJp;
    private b hJq;
    private a hJs;
    private com.baidu.live.liveroom.middleware.a hJt;
    private com.baidu.tieba.ala.liveroom.data.e huP = new com.baidu.tieba.ala.liveroom.data.e();

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, ViewGroup viewGroup2, com.baidu.live.tieba.e.b bVar, String str, View view) {
        this.huP.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.huP.hBY = alaLiveRecorder;
        this.huP.hBZ = view;
        this.huP.hCa = frameLayout;
        this.huP.hBI = alaLiveView;
        this.huP.rootView = viewGroup;
        this.huP.hCb = viewGroup2;
        this.huP.hCf = bVar;
        this.huP.hCc = this;
        this.huP.hCe = new AlaLiveRecorderPerfData();
        this.hJp = new AlaMasterLiveRoomOpearator(this.huP, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hJt = k.MF().MG();
            this.huP.hCg = this.hJt;
            this.hJt.q(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.n.d dVar) {
        this.huP.hBH = dVar;
    }

    public void setArModel(com.baidu.live.ar.k kVar) {
        this.huP.hCd = kVar;
    }

    public void a(b bVar) {
        this.hJq = bVar;
        if (this.hJs != null) {
            this.hJs.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.hJp != null) {
            f fVar = null;
            if (obj instanceof f) {
                fVar = (f) obj;
            }
            int a2 = this.hJp.a(fVar);
            if (a2 == 1 || a2 == 2) {
                this.huP.vu(a2);
            } else {
                return;
            }
        }
        if (this.hJs != null) {
            this.hJs.a(s, obj);
        }
    }

    public void b(f fVar) {
        a((short) 1, fVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.hHU = dVar;
        if (this.hJs != null) {
            this.hJs.c(dVar);
        }
    }

    public void bq(int i, String str) {
        if (this.hJs != null) {
            this.hJs.bq(i, str);
        }
    }

    public void c(aw awVar) {
        if (this.hJs != null) {
            this.hJs.c(awVar);
        }
    }

    public void br(int i, String str) {
        if (this.hJs != null) {
            this.hJs.br(i, str);
        }
    }

    public void j(short s) {
        if (this.hJs != null) {
            this.hJs.j(s);
        }
        if (this.hJt != null) {
            this.hJt.MB();
        }
    }

    public void markEnterBackground() {
        if (this.hJs != null) {
            this.hJs.markEnterBackground();
        }
        if (this.hJt != null) {
            this.hJt.onStop();
        }
    }

    public void markEnterForeground() {
        if (this.hJs != null) {
            this.hJs.markEnterForeground();
        }
        if (this.hJp != null) {
            this.hJp.onResume();
        }
        if (this.hJt != null) {
            this.hJt.onResume();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.hJs != null) {
            this.hJs.onPause();
        }
        if (this.hJt != null) {
            this.hJt.onPause();
        }
    }

    public boolean ciK() {
        if (this.hJs != null) {
            return this.hJs.ciK();
        }
        return false;
    }

    public void ciL() {
        if (this.hJs != null) {
            this.hJs.ciL();
        }
    }

    public void vW(int i) {
        if (i == 1 && !(this.hJs instanceof c)) {
            this.hJs = new c(this.huP);
        } else if (i == 2 && !(this.hJs instanceof e)) {
            this.hJs = new e(this.huP);
        } else {
            return;
        }
        this.hJs.ao(this.hJp);
        this.hJs.a(this.hJq);
    }

    public void l(int i, int i2, int i3) {
        if (this.hJp != null) {
            this.hJp.l(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hJp != null) {
            this.hJp.onKeyboardVisibilityChanged(z);
        }
        if (this.hJt != null) {
            this.hJt.e(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hJp != null) {
            this.hJp.onActivityResult(i, i2, intent);
        }
        if (this.hJt != null) {
            this.hJt.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hJt != null) {
            this.hJt.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData ciN() {
        return this.huP.hCe;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hJp != null) {
            return this.hJp.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.hJp != null) {
            this.hJp.streamStateReceived(i, z, i2, z2);
        }
    }

    public void sendBufferChanged(int i) {
        if (this.hJp != null) {
            this.hJp.sendBufferChanged(i);
        }
    }

    public void chZ() {
        if (this.hJp != null) {
            this.hJp.chZ();
        }
    }

    public void cil() {
        if (this.hJp != null) {
            this.hJp.cil();
        }
    }

    public void ceF() {
        if (this.hJp != null) {
            this.hJp.ceF();
        }
    }

    public void oj(boolean z) {
        if (this.hJp != null) {
            this.hJp.oj(z);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.d ciO() {
        return this.hHU;
    }

    public boolean ciM() {
        if (this.hJs != null) {
            return this.hJs.ciM();
        }
        return false;
    }

    public int bRf() {
        if (this.huP != null) {
            return this.huP.bRf();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.hJp != null) {
            this.hJp.onDestroy();
        }
        if (this.hJt != null) {
            this.hJt.cF(false);
        }
    }

    public void g(short s) {
        if (this.hJq != null) {
            this.hJq.g(s);
        }
        if (this.hJp != null) {
            this.hJp.b(s);
        }
    }

    public void Xi() {
        if (this.hJq != null) {
            this.hJq.Xi();
        }
    }

    public void ceH() {
        if (this.hJq != null) {
            this.hJq.ceH();
        }
    }

    public void ceI() {
        if (this.hJq != null) {
            this.hJq.ceI();
        }
    }

    public void ceJ() {
        if (this.hJq != null) {
            this.hJq.ceJ();
        }
    }

    public void ceK() {
        if (this.hJq != null) {
            this.hJq.ceK();
        }
    }

    public void onRtcConnected(int i) {
        if (this.hJp != null) {
            this.hJp.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.hJp != null) {
            this.hJp.onPKPlayerFirstFrame();
        }
    }

    public void VC() {
        if (this.hJp != null) {
            this.hJp.VC();
        }
    }
}
