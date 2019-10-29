package com.baidu.tieba.ala.liveroom.master.a;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.ala.liveRecorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes6.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.data.e dZB = new com.baidu.tieba.ala.liveroom.data.e();
    private com.baidu.tieba.ala.liveroom.data.d ejR;
    private AlaMasterLiveRoomOpearator elb;
    private b elc;
    private a ele;

    public d(TbPageContext tbPageContext, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, ViewGroup viewGroup, com.baidu.live.tieba.e.b bVar) {
        this.dZB.pageContext = tbPageContext;
        this.dZB.efV = alaLiveRecorder;
        this.dZB.efD = alaLiveView;
        this.dZB.Bg = viewGroup;
        this.dZB.efY = bVar;
        this.dZB.efW = this;
        this.dZB.efX = new AlaLiveRecorderPerfData();
        this.elb = new AlaMasterLiveRoomOpearator(this.dZB);
    }

    public void a(com.baidu.tieba.ala.liveroom.m.c cVar) {
        this.dZB.efC = cVar;
    }

    public void a(b bVar) {
        this.elc = bVar;
        if (this.ele != null) {
            this.ele.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        if (s == 1 && this.elb != null) {
            f fVar = null;
            if (obj instanceof f) {
                fVar = (f) obj;
            }
            int a = this.elb.a(fVar);
            if (a == 1 || a == 2) {
                this.dZB.nx(a);
            } else {
                return;
            }
        }
        if (this.ele != null) {
            this.ele.a(s, obj);
        }
    }

    public void b(f fVar) {
        a((short) 1, fVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.ejR = dVar;
        if (this.ele != null) {
            this.ele.c(dVar);
        }
    }

    public void ac(int i, String str) {
        if (this.ele != null) {
            this.ele.ac(i, str);
        }
    }

    public void c(g gVar) {
        if (this.ele != null) {
            this.ele.c(gVar);
        }
    }

    public void ad(int i, String str) {
        if (this.ele != null) {
            this.ele.ad(i, str);
        }
    }

    public void g(short s) {
        if (this.ele != null) {
            this.ele.g(s);
        }
    }

    public void aUw() {
        if (this.ele != null) {
            this.ele.aUw();
        }
    }

    public void aUx() {
        if (this.ele != null) {
            this.ele.aUx();
        }
        if (this.elb != null) {
            this.elb.onResume();
        }
    }

    public void onPause() {
        if (this.ele != null) {
            this.ele.onPause();
        }
    }

    public boolean aUy() {
        if (this.ele != null) {
            return this.ele.aUy();
        }
        return false;
    }

    public void aUz() {
        if (this.ele != null) {
            this.ele.aUz();
        }
    }

    public void nT(int i) {
        if (i == 1 && !(this.ele instanceof c)) {
            this.ele = new c(this.dZB);
        } else if (i == 2 && !(this.ele instanceof e)) {
            this.ele = new e(this.dZB);
        } else {
            return;
        }
        this.ele.S(this.elb);
        this.ele.a(this.elc);
    }

    public void E(int i, int i2, int i3) {
        if (this.elb != null) {
            this.elb.E(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.elb != null) {
            this.elb.onKeyboardVisibilityChanged(z);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.elb != null) {
            this.elb.onActivityResult(i, i2, intent);
        }
    }

    public AlaLiveRecorderPerfData aUB() {
        return this.dZB.efX;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.elb != null) {
            return this.elb.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.elb != null) {
            this.elb.streamStateReceived(i, z, i2, z2);
        }
    }

    public void aTO() {
        if (this.elb != null) {
            this.elb.aTO();
        }
    }

    public void aUa() {
        if (this.elb != null) {
            this.elb.aUa();
        }
    }

    public void aRJ() {
        if (this.elb != null) {
            this.elb.aRJ();
        }
    }

    public com.baidu.tieba.ala.liveroom.data.d aUC() {
        return this.ejR;
    }

    public boolean aUA() {
        if (this.ele != null) {
            return this.ele.aUA();
        }
        return false;
    }

    public int aRL() {
        if (this.dZB != null) {
            return this.dZB.aRL();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.elb != null) {
            this.elb.onDestroy();
        }
    }

    public void d(short s) {
        if (this.elc != null) {
            this.elc.d(s);
        }
    }

    public void aRM() {
        if (this.elc != null) {
            this.elc.aRM();
        }
    }

    public void aRN() {
        if (this.elc != null) {
            this.elc.aRN();
        }
    }

    public void aRO() {
        if (this.elc != null) {
            this.elc.aRO();
        }
    }

    public void aRP() {
        if (this.elc != null) {
            this.elc.aRP();
        }
    }

    public void aRQ() {
        if (this.elc != null) {
            this.elc.aRQ();
        }
    }

    public void onRtcConnected(int i) {
        if (this.elb != null) {
            this.elb.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.elb != null) {
            this.elb.onPKPlayerFirstFrame();
        }
    }
}
