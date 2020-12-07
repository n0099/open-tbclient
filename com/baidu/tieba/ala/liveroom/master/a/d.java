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
import com.baidu.live.data.aq;
import com.baidu.live.liveroom.middleware.k;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes4.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.data.e hja = new com.baidu.tieba.ala.liveroom.data.e();
    private com.baidu.tieba.ala.liveroom.data.d hvZ;
    private AlaMasterLiveRoomOpearator hxv;
    private b hxw;
    private a hxy;
    private com.baidu.live.liveroom.middleware.a hxz;

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, ViewGroup viewGroup2, com.baidu.live.tieba.e.b bVar, String str, View view) {
        this.hja.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.hja.hqi = alaLiveRecorder;
        this.hja.hqj = view;
        this.hja.hqk = frameLayout;
        this.hja.hpS = alaLiveView;
        this.hja.rootView = viewGroup;
        this.hja.hql = viewGroup2;
        this.hja.hqp = bVar;
        this.hja.hqm = this;
        this.hja.hqo = new AlaLiveRecorderPerfData();
        this.hxv = new AlaMasterLiveRoomOpearator(this.hja, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hxz = k.Po().Pp();
            this.hja.hqq = this.hxz;
            this.hxz.r(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.p.d dVar) {
        this.hja.hpR = dVar;
    }

    public void setArModel(j jVar) {
        this.hja.hqn = jVar;
    }

    public void a(b bVar) {
        this.hxw = bVar;
        if (this.hxy != null) {
            this.hxy.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.hxv != null) {
            f fVar = null;
            if (obj instanceof f) {
                fVar = (f) obj;
            }
            int a2 = this.hxv.a(fVar);
            if (a2 == 1 || a2 == 2) {
                this.hja.wE(a2);
            } else {
                return;
            }
        }
        if (this.hxy != null) {
            this.hxy.a(s, obj);
        }
    }

    public void b(f fVar) {
        a((short) 1, fVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.hvZ = dVar;
        if (this.hxy != null) {
            this.hxy.c(dVar);
        }
    }

    public void bi(int i, String str) {
        if (this.hxy != null) {
            this.hxy.bi(i, str);
        }
    }

    public void c(aq aqVar) {
        if (this.hxy != null) {
            this.hxy.c(aqVar);
        }
    }

    public void bj(int i, String str) {
        if (this.hxy != null) {
            this.hxy.bj(i, str);
        }
    }

    public void j(short s) {
        if (this.hxy != null) {
            this.hxy.j(s);
        }
        if (this.hxz != null) {
            this.hxz.Pk();
        }
    }

    public void markEnterBackground() {
        if (this.hxy != null) {
            this.hxy.markEnterBackground();
        }
        if (this.hxz != null) {
            this.hxz.onStop();
        }
    }

    public void markEnterForeground() {
        if (this.hxy != null) {
            this.hxy.markEnterForeground();
        }
        if (this.hxv != null) {
            this.hxv.onResume();
        }
        if (this.hxz != null) {
            this.hxz.onResume();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.hxy != null) {
            this.hxy.onPause();
        }
        if (this.hxz != null) {
            this.hxz.onPause();
        }
    }

    public boolean ciO() {
        if (this.hxy != null) {
            return this.hxy.ciO();
        }
        return false;
    }

    public void ciP() {
        if (this.hxy != null) {
            this.hxy.ciP();
        }
    }

    public void xg(int i) {
        if (i == 1 && !(this.hxy instanceof c)) {
            this.hxy = new c(this.hja);
        } else if (i == 2 && !(this.hxy instanceof e)) {
            this.hxy = new e(this.hja);
        } else {
            return;
        }
        this.hxy.ar(this.hxv);
        this.hxy.a(this.hxw);
    }

    public void l(int i, int i2, int i3) {
        if (this.hxv != null) {
            this.hxv.l(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hxv != null) {
            this.hxv.onKeyboardVisibilityChanged(z);
        }
        if (this.hxz != null) {
            this.hxz.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hxv != null) {
            this.hxv.onActivityResult(i, i2, intent);
        }
        if (this.hxz != null) {
            this.hxz.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hxz != null) {
            this.hxz.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData ciR() {
        return this.hja.hqo;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hxv != null) {
            return this.hxv.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.hxv != null) {
            this.hxv.streamStateReceived(i, z, i2, z2);
        }
    }

    public void sendBufferChanged(int i) {
        if (this.hxv != null) {
            this.hxv.sendBufferChanged(i);
        }
    }

    public void cic() {
        if (this.hxv != null) {
            this.hxv.cic();
        }
    }

    public void cio() {
        if (this.hxv != null) {
            this.hxv.cio();
        }
    }

    public void ceD() {
        if (this.hxv != null) {
            this.hxv.ceD();
        }
    }

    public void nC(boolean z) {
        if (this.hxv != null) {
            this.hxv.nC(z);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.d ciS() {
        return this.hvZ;
    }

    public boolean ciQ() {
        if (this.hxy != null) {
            return this.hxy.ciQ();
        }
        return false;
    }

    public int ceF() {
        if (this.hja != null) {
            return this.hja.ceF();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.hxv != null) {
            this.hxv.onDestroy();
        }
        if (this.hxz != null) {
            this.hxz.cx(false);
        }
    }

    public void g(short s) {
        if (this.hxw != null) {
            this.hxw.g(s);
        }
        if (this.hxv != null) {
            this.hxv.b(s);
        }
    }

    public void Yj() {
        if (this.hxw != null) {
            this.hxw.Yj();
        }
    }

    public void bhU() {
        if (this.hxw != null) {
            this.hxw.bhU();
        }
    }

    public void ceG() {
        if (this.hxw != null) {
            this.hxw.ceG();
        }
    }

    public void ceH() {
        if (this.hxw != null) {
            this.hxw.ceH();
        }
    }

    public void ceI() {
        if (this.hxw != null) {
            this.hxw.ceI();
        }
    }

    public void onRtcConnected(int i) {
        if (this.hxv != null) {
            this.hxv.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.hxv != null) {
            this.hxv.onPKPlayerFirstFrame();
        }
    }
}
