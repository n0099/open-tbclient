package com.baidu.tieba.ala.liveroom.master.a;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.data.h;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes2.dex */
public class d {
    private f eQi = new f();
    private com.baidu.tieba.ala.liveroom.data.e fbR;
    private AlaMasterLiveRoomOpearator fdn;
    private b fdo;
    private a fdq;

    public d(TbPageContext tbPageContext, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, ViewGroup viewGroup, com.baidu.live.tieba.e.b bVar, String str) {
        this.eQi.pageContext = tbPageContext;
        this.eQi.eWS = alaLiveRecorder;
        this.eQi.eWs = alaLiveView;
        this.eQi.rootView = viewGroup;
        this.eQi.eWW = bVar;
        this.eQi.eWT = this;
        this.eQi.eWV = new AlaLiveRecorderPerfData();
        this.fdn = new AlaMasterLiveRoomOpearator(this.eQi, str);
    }

    public void a(com.baidu.tieba.ala.liveroom.o.c cVar) {
        this.eQi.eWr = cVar;
    }

    public void setArModel(com.baidu.live.ar.c cVar) {
        this.eQi.eWU = cVar;
    }

    public void a(b bVar) {
        this.fdo = bVar;
        if (this.fdq != null) {
            this.fdq.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        if (s == 1 && this.fdn != null) {
            g gVar = null;
            if (obj instanceof g) {
                gVar = (g) obj;
            }
            int a = this.fdn.a(gVar);
            if (a == 1 || a == 2) {
                this.eQi.pP(a);
            } else {
                return;
            }
        }
        if (this.fdq != null) {
            this.fdq.a(s, obj);
        }
    }

    public void b(g gVar) {
        a((short) 1, gVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.fbR = eVar;
        if (this.fdq != null) {
            this.fdq.c(eVar);
        }
    }

    public void av(int i, String str) {
        if (this.fdq != null) {
            this.fdq.av(i, str);
        }
    }

    public void c(h hVar) {
        if (this.fdq != null) {
            this.fdq.c(hVar);
        }
    }

    public void aw(int i, String str) {
        if (this.fdq != null) {
            this.fdq.aw(i, str);
        }
    }

    public void g(short s) {
        if (this.fdq != null) {
            this.fdq.g(s);
        }
    }

    public void bnj() {
        if (this.fdq != null) {
            this.fdq.bnj();
        }
    }

    public void bnk() {
        if (this.fdq != null) {
            this.fdq.bnk();
        }
        if (this.fdn != null) {
            this.fdn.onResume();
        }
    }

    public void onPause() {
        if (this.fdq != null) {
            this.fdq.onPause();
        }
    }

    public boolean bnl() {
        if (this.fdq != null) {
            return this.fdq.bnl();
        }
        return false;
    }

    public void bnm() {
        if (this.fdq != null) {
            this.fdq.bnm();
        }
    }

    public void qo(int i) {
        if (i == 1 && !(this.fdq instanceof c)) {
            this.fdq = new c(this.eQi);
        } else if (i == 2 && !(this.fdq instanceof e)) {
            this.fdq = new e(this.eQi);
        } else {
            return;
        }
        this.fdq.ae(this.fdn);
        this.fdq.a(this.fdo);
    }

    public void E(int i, int i2, int i3) {
        if (this.fdn != null) {
            this.fdn.E(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fdn != null) {
            this.fdn.onKeyboardVisibilityChanged(z);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fdn != null) {
            this.fdn.onActivityResult(i, i2, intent);
        }
    }

    public AlaLiveRecorderPerfData bno() {
        return this.eQi.eWV;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fdn != null) {
            return this.fdn.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.fdn != null) {
            this.fdn.streamStateReceived(i, z, i2, z2);
        }
    }

    public void bmB() {
        if (this.fdn != null) {
            this.fdn.bmB();
        }
    }

    public void bmN() {
        if (this.fdn != null) {
            this.fdn.bmN();
        }
    }

    public void bjU() {
        if (this.fdn != null) {
            this.fdn.bjU();
        }
    }

    public com.baidu.tieba.ala.liveroom.data.e bnp() {
        return this.fbR;
    }

    public boolean bnn() {
        if (this.fdq != null) {
            return this.fdq.bnn();
        }
        return false;
    }

    public int bjW() {
        if (this.eQi != null) {
            return this.eQi.bjW();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.fdn != null) {
            this.fdn.onDestroy();
        }
    }

    public void d(short s) {
        if (this.fdo != null) {
            this.fdo.d(s);
        }
    }

    public void bjX() {
        if (this.fdo != null) {
            this.fdo.bjX();
        }
    }

    public void auA() {
        if (this.fdo != null) {
            this.fdo.auA();
        }
    }

    public void bjY() {
        if (this.fdo != null) {
            this.fdo.bjY();
        }
    }

    public void bjZ() {
        if (this.fdo != null) {
            this.fdo.bjZ();
        }
    }

    public void bka() {
        if (this.fdo != null) {
            this.fdo.bka();
        }
    }

    public void onRtcConnected(int i) {
        if (this.fdn != null) {
            this.fdn.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.fdn != null) {
            this.fdn.onPKPlayerFirstFrame();
        }
    }
}
