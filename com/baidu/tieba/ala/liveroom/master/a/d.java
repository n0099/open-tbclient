package com.baidu.tieba.ala.liveroom.master.a;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
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
    private f eUn = new f();
    private com.baidu.tieba.ala.liveroom.data.e ffn;
    private AlaMasterLiveRoomOpearator fgK;
    private b fgL;
    private a fgN;
    private com.baidu.live.liveroom.middleware.a fgO;

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, com.baidu.live.tieba.e.b bVar, String str) {
        this.eUn.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.eUn.faV = alaLiveRecorder;
        this.eUn.faW = frameLayout;
        this.eUn.faw = alaLiveView;
        this.eUn.rootView = viewGroup;
        this.eUn.fba = bVar;
        this.eUn.faX = this;
        this.eUn.faZ = new AlaLiveRecorderPerfData();
        this.fgK = new AlaMasterLiveRoomOpearator(this.eUn, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fgO = k.yy().yz();
            this.eUn.fbb = this.fgO;
            this.fgO.u(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.m.c cVar) {
        this.eUn.fav = cVar;
    }

    public void setArModel(com.baidu.live.ar.c cVar) {
        this.eUn.faY = cVar;
    }

    public void a(b bVar) {
        this.fgL = bVar;
        if (this.fgN != null) {
            this.fgN.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.fgK != null) {
            g gVar = null;
            if (obj instanceof g) {
                gVar = (g) obj;
            }
            int a = this.fgK.a(gVar);
            if (a == 1 || a == 2) {
                this.eUn.pX(a);
            } else {
                return;
            }
        }
        if (this.fgN != null) {
            this.fgN.a(s, obj);
        }
    }

    public void b(g gVar) {
        a((short) 1, gVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.ffn = eVar;
        if (this.fgN != null) {
            this.fgN.c(eVar);
        }
    }

    public void aw(int i, String str) {
        if (this.fgN != null) {
            this.fgN.aw(i, str);
        }
    }

    public void c(h hVar) {
        if (this.fgN != null) {
            this.fgN.c(hVar);
        }
    }

    public void ax(int i, String str) {
        if (this.fgN != null) {
            this.fgN.ax(i, str);
        }
    }

    public void i(short s) {
        if (this.fgN != null) {
            this.fgN.i(s);
        }
        if (this.fgO != null) {
            this.fgO.yu();
        }
    }

    public void boW() {
        if (this.fgN != null) {
            this.fgN.boW();
        }
        if (this.fgO != null) {
            this.fgO.onStop();
        }
    }

    public void boX() {
        if (this.fgN != null) {
            this.fgN.boX();
        }
        if (this.fgK != null) {
            this.fgK.onResume();
        }
        if (this.fgO != null) {
            this.fgO.onResume();
        }
    }

    public void onPause() {
        if (this.fgN != null) {
            this.fgN.onPause();
        }
        if (this.fgO != null) {
            this.fgO.onPause();
        }
    }

    public boolean boY() {
        if (this.fgN != null) {
            return this.fgN.boY();
        }
        return false;
    }

    public void boZ() {
        if (this.fgN != null) {
            this.fgN.boZ();
        }
    }

    public void qv(int i) {
        if (i == 1 && !(this.fgN instanceof c)) {
            this.fgN = new c(this.eUn);
        } else if (i == 2 && !(this.fgN instanceof e)) {
            this.fgN = new e(this.eUn);
        } else {
            return;
        }
        this.fgN.ac(this.fgK);
        this.fgN.a(this.fgL);
    }

    public void j(int i, int i2, int i3) {
        if (this.fgK != null) {
            this.fgK.j(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fgK != null) {
            this.fgK.onKeyboardVisibilityChanged(z);
        }
        if (this.fgO != null) {
            this.fgO.d(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fgK != null) {
            this.fgK.onActivityResult(i, i2, intent);
        }
        if (this.fgO != null) {
            this.fgO.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.fgO != null) {
            this.fgO.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData bpb() {
        return this.eUn.faZ;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fgK != null) {
            return this.fgK.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.fgK != null) {
            this.fgK.streamStateReceived(i, z, i2, z2);
        }
    }

    public void bom() {
        if (this.fgK != null) {
            this.fgK.bom();
        }
    }

    public void boy() {
        if (this.fgK != null) {
            this.fgK.boy();
        }
    }

    public void blL() {
        if (this.fgK != null) {
            this.fgK.blL();
        }
    }

    public com.baidu.tieba.ala.liveroom.data.e bpc() {
        return this.ffn;
    }

    public boolean bpa() {
        if (this.fgN != null) {
            return this.fgN.bpa();
        }
        return false;
    }

    public int blN() {
        if (this.eUn != null) {
            return this.eUn.blN();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.fgK != null) {
            this.fgK.onDestroy();
        }
        if (this.fgO != null) {
            this.fgO.be(false);
        }
    }

    public void f(short s) {
        if (this.fgL != null) {
            this.fgL.f(s);
        }
    }

    public void blO() {
        if (this.fgL != null) {
            this.fgL.blO();
        }
    }

    public void awQ() {
        if (this.fgL != null) {
            this.fgL.awQ();
        }
    }

    public void blP() {
        if (this.fgL != null) {
            this.fgL.blP();
        }
    }

    public void blQ() {
        if (this.fgL != null) {
            this.fgL.blQ();
        }
    }

    public void blR() {
        if (this.fgL != null) {
            this.fgL.blR();
        }
    }

    public void onRtcConnected(int i) {
        if (this.fgK != null) {
            this.fgK.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.fgK != null) {
            this.fgK.onPKPlayerFirstFrame();
        }
    }
}
