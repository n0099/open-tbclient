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
/* loaded from: classes10.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.data.d hJD;
    private AlaMasterLiveRoomOpearator hKY;
    private b hKZ;
    private a hLb;
    private com.baidu.live.liveroom.middleware.a hLc;
    private com.baidu.tieba.ala.liveroom.data.e hwy = new com.baidu.tieba.ala.liveroom.data.e();

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, ViewGroup viewGroup2, com.baidu.live.tieba.e.b bVar, String str, View view) {
        this.hwy.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.hwy.hDH = alaLiveRecorder;
        this.hwy.hDI = view;
        this.hwy.hDJ = frameLayout;
        this.hwy.hDr = alaLiveView;
        this.hwy.rootView = viewGroup;
        this.hwy.hDK = viewGroup2;
        this.hwy.hDO = bVar;
        this.hwy.hDL = this;
        this.hwy.hDN = new AlaLiveRecorderPerfData();
        this.hKY = new AlaMasterLiveRoomOpearator(this.hwy, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hLc = k.MI().MJ();
            this.hwy.hDP = this.hLc;
            this.hLc.q(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.n.d dVar) {
        this.hwy.hDq = dVar;
    }

    public void setArModel(com.baidu.live.ar.k kVar) {
        this.hwy.hDM = kVar;
    }

    public void a(b bVar) {
        this.hKZ = bVar;
        if (this.hLb != null) {
            this.hLb.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.hKY != null) {
            f fVar = null;
            if (obj instanceof f) {
                fVar = (f) obj;
            }
            int a2 = this.hKY.a(fVar);
            if (a2 == 1 || a2 == 2) {
                this.hwy.vw(a2);
            } else {
                return;
            }
        }
        if (this.hLb != null) {
            this.hLb.a(s, obj);
        }
    }

    public void b(f fVar) {
        a((short) 1, fVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.hJD = dVar;
        if (this.hLb != null) {
            this.hLb.c(dVar);
        }
    }

    public void bq(int i, String str) {
        if (this.hLb != null) {
            this.hLb.bq(i, str);
        }
    }

    public void c(aw awVar) {
        if (this.hLb != null) {
            this.hLb.c(awVar);
        }
    }

    public void br(int i, String str) {
        if (this.hLb != null) {
            this.hLb.br(i, str);
        }
    }

    public void j(short s) {
        if (this.hLb != null) {
            this.hLb.j(s);
        }
        if (this.hLc != null) {
            this.hLc.ME();
        }
    }

    public void markEnterBackground() {
        if (this.hLb != null) {
            this.hLb.markEnterBackground();
        }
        if (this.hLc != null) {
            this.hLc.onStop();
        }
    }

    public void markEnterForeground() {
        if (this.hLb != null) {
            this.hLb.markEnterForeground();
        }
        if (this.hKY != null) {
            this.hKY.onResume();
        }
        if (this.hLc != null) {
            this.hLc.onResume();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.hLb != null) {
            this.hLb.onPause();
        }
        if (this.hLc != null) {
            this.hLc.onPause();
        }
    }

    public boolean ciQ() {
        if (this.hLb != null) {
            return this.hLb.ciQ();
        }
        return false;
    }

    public void ciR() {
        if (this.hLb != null) {
            this.hLb.ciR();
        }
    }

    public void vY(int i) {
        if (i == 1 && !(this.hLb instanceof c)) {
            this.hLb = new c(this.hwy);
        } else if (i == 2 && !(this.hLb instanceof e)) {
            this.hLb = new e(this.hwy);
        } else {
            return;
        }
        this.hLb.ao(this.hKY);
        this.hLb.a(this.hKZ);
    }

    public void l(int i, int i2, int i3) {
        if (this.hKY != null) {
            this.hKY.l(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hKY != null) {
            this.hKY.onKeyboardVisibilityChanged(z);
        }
        if (this.hLc != null) {
            this.hLc.e(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hKY != null) {
            this.hKY.onActivityResult(i, i2, intent);
        }
        if (this.hLc != null) {
            this.hLc.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hLc != null) {
            this.hLc.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData ciT() {
        return this.hwy.hDN;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hKY != null) {
            return this.hKY.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.hKY != null) {
            this.hKY.streamStateReceived(i, z, i2, z2);
        }
    }

    public void sendBufferChanged(int i) {
        if (this.hKY != null) {
            this.hKY.sendBufferChanged(i);
        }
    }

    public void cif() {
        if (this.hKY != null) {
            this.hKY.cif();
        }
    }

    public void cir() {
        if (this.hKY != null) {
            this.hKY.cir();
        }
    }

    public void ceL() {
        if (this.hKY != null) {
            this.hKY.ceL();
        }
    }

    public void oj(boolean z) {
        if (this.hKY != null) {
            this.hKY.oj(z);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.d ciU() {
        return this.hJD;
    }

    public boolean ciS() {
        if (this.hLb != null) {
            return this.hLb.ciS();
        }
        return false;
    }

    public int bRl() {
        if (this.hwy != null) {
            return this.hwy.bRl();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.hKY != null) {
            this.hKY.onDestroy();
        }
        if (this.hLc != null) {
            this.hLc.cF(false);
        }
    }

    public void g(short s) {
        if (this.hKZ != null) {
            this.hKZ.g(s);
        }
        if (this.hKY != null) {
            this.hKY.b(s);
        }
    }

    public void Xl() {
        if (this.hKZ != null) {
            this.hKZ.Xl();
        }
    }

    public void ceN() {
        if (this.hKZ != null) {
            this.hKZ.ceN();
        }
    }

    public void ceO() {
        if (this.hKZ != null) {
            this.hKZ.ceO();
        }
    }

    public void ceP() {
        if (this.hKZ != null) {
            this.hKZ.ceP();
        }
    }

    public void ceQ() {
        if (this.hKZ != null) {
            this.hKZ.ceQ();
        }
    }

    public void onRtcConnected(int i) {
        if (this.hKY != null) {
            this.hKY.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.hKY != null) {
            this.hKY.onPKPlayerFirstFrame();
        }
    }

    public void VF() {
        if (this.hKY != null) {
            this.hKY.VF();
        }
    }
}
