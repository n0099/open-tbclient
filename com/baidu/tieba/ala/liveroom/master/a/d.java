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
    private com.baidu.tieba.ala.liveroom.data.e gZK = new com.baidu.tieba.ala.liveroom.data.e();
    private com.baidu.tieba.ala.liveroom.data.d hmQ;
    private AlaMasterLiveRoomOpearator hoh;
    private b hoi;
    private a hol;
    private com.baidu.live.liveroom.middleware.a hom;

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, ViewGroup viewGroup2, com.baidu.live.tieba.e.b bVar, String str, View view) {
        this.gZK.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.gZK.hgU = alaLiveRecorder;
        this.gZK.hgV = view;
        this.gZK.hgW = frameLayout;
        this.gZK.hgE = alaLiveView;
        this.gZK.rootView = viewGroup;
        this.gZK.hgX = viewGroup2;
        this.gZK.hhb = bVar;
        this.gZK.hgY = this;
        this.gZK.hha = new AlaLiveRecorderPerfData();
        this.hoh = new AlaMasterLiveRoomOpearator(this.gZK, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hom = k.NF().NG();
            this.gZK.hhc = this.hom;
            this.hom.s(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.q.d dVar) {
        this.gZK.hgD = dVar;
    }

    public void setArModel(j jVar) {
        this.gZK.hgZ = jVar;
    }

    public void a(b bVar) {
        this.hoi = bVar;
        if (this.hol != null) {
            this.hol.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.hoh != null) {
            f fVar = null;
            if (obj instanceof f) {
                fVar = (f) obj;
            }
            int a2 = this.hoh.a(fVar);
            if (a2 == 1 || a2 == 2) {
                this.gZK.vB(a2);
            } else {
                return;
            }
        }
        if (this.hol != null) {
            this.hol.a(s, obj);
        }
    }

    public void b(f fVar) {
        a((short) 1, fVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.hmQ = dVar;
        if (this.hol != null) {
            this.hol.c(dVar);
        }
    }

    public void bk(int i, String str) {
        if (this.hol != null) {
            this.hol.bk(i, str);
        }
    }

    public void c(ap apVar) {
        if (this.hol != null) {
            this.hol.c(apVar);
        }
    }

    public void bl(int i, String str) {
        if (this.hol != null) {
            this.hol.bl(i, str);
        }
    }

    public void j(short s) {
        if (this.hol != null) {
            this.hol.j(s);
        }
        if (this.hom != null) {
            this.hom.NB();
        }
    }

    public void cfz() {
        if (this.hol != null) {
            this.hol.cfz();
        }
        if (this.hom != null) {
            this.hom.onStop();
        }
    }

    public void cfA() {
        if (this.hol != null) {
            this.hol.cfA();
        }
        if (this.hoh != null) {
            this.hoh.onResume();
        }
        if (this.hom != null) {
            this.hom.onResume();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.hol != null) {
            this.hol.onPause();
        }
        if (this.hom != null) {
            this.hom.onPause();
        }
    }

    public boolean cfB() {
        if (this.hol != null) {
            return this.hol.cfB();
        }
        return false;
    }

    public void cfC() {
        if (this.hol != null) {
            this.hol.cfC();
        }
    }

    public void wd(int i) {
        if (i == 1 && !(this.hol instanceof c)) {
            this.hol = new c(this.gZK);
        } else if (i == 2 && !(this.hol instanceof e)) {
            this.hol = new e(this.gZK);
        } else {
            return;
        }
        this.hol.ak(this.hoh);
        this.hol.a(this.hoi);
    }

    public void l(int i, int i2, int i3) {
        if (this.hoh != null) {
            this.hoh.l(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hoh != null) {
            this.hoh.onKeyboardVisibilityChanged(z);
        }
        if (this.hom != null) {
            this.hom.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hoh != null) {
            this.hoh.onActivityResult(i, i2, intent);
        }
        if (this.hom != null) {
            this.hom.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hom != null) {
            this.hom.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData cfE() {
        return this.gZK.hha;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hoh != null) {
            return this.hoh.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.hoh != null) {
            this.hoh.streamStateReceived(i, z, i2, z2);
        }
    }

    public void ceP() {
        if (this.hoh != null) {
            this.hoh.ceP();
        }
    }

    public void cfb() {
        if (this.hoh != null) {
            this.hoh.cfb();
        }
    }

    public void cbp() {
        if (this.hoh != null) {
            this.hoh.cbp();
        }
    }

    public void ng(boolean z) {
        if (this.hoh != null) {
            this.hoh.ng(z);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.d cfF() {
        return this.hmQ;
    }

    public boolean cfD() {
        if (this.hol != null) {
            return this.hol.cfD();
        }
        return false;
    }

    public int cbr() {
        if (this.gZK != null) {
            return this.gZK.cbr();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.hoh != null) {
            this.hoh.onDestroy();
            this.hol.onDestroy();
        }
        if (this.hom != null) {
            this.hom.ch(false);
        }
    }

    public void g(short s) {
        if (this.hoi != null) {
            this.hoi.g(s);
        }
        if (this.hoh != null) {
            this.hoh.b(s);
        }
    }

    public void Ws() {
        if (this.hoi != null) {
            this.hoi.Ws();
        }
    }

    public void bfw() {
        if (this.hoi != null) {
            this.hoi.bfw();
        }
    }

    public void cbs() {
        if (this.hoi != null) {
            this.hoi.cbs();
        }
    }

    public void cbt() {
        if (this.hoi != null) {
            this.hoi.cbt();
        }
    }

    public void cbu() {
        if (this.hoi != null) {
            this.hoi.cbu();
        }
    }

    public void onRtcConnected(int i) {
        if (this.hoh != null) {
            this.hoh.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.hoh != null) {
            this.hoh.onPKPlayerFirstFrame();
        }
    }
}
