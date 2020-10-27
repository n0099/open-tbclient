package com.baidu.tieba.ala.liveroom.master.a;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.ar.i;
import com.baidu.live.data.ao;
import com.baidu.live.liveroom.middleware.k;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes4.dex */
public class d {
    private f gTF = new f();
    private com.baidu.tieba.ala.liveroom.data.e hgT;
    private AlaMasterLiveRoomOpearator hiq;
    private b hir;
    private a hiu;
    private com.baidu.live.liveroom.middleware.a hiv;

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, ViewGroup viewGroup2, com.baidu.live.tieba.e.b bVar, String str) {
        this.gTF.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.gTF.hba = alaLiveRecorder;
        this.gTF.hbb = frameLayout;
        this.gTF.haC = alaLiveView;
        this.gTF.rootView = viewGroup;
        this.gTF.hbc = viewGroup2;
        this.gTF.hbg = bVar;
        this.gTF.hbd = this;
        this.gTF.hbf = new AlaLiveRecorderPerfData();
        this.hiq = new AlaMasterLiveRoomOpearator(this.gTF, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hiv = k.Nf().Ng();
            this.gTF.hbh = this.hiv;
            this.hiv.s(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.q.d dVar) {
        this.gTF.haB = dVar;
    }

    public void setArModel(i iVar) {
        this.gTF.hbe = iVar;
    }

    public void a(b bVar) {
        this.hir = bVar;
        if (this.hiu != null) {
            this.hiu.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.hiq != null) {
            g gVar = null;
            if (obj instanceof g) {
                gVar = (g) obj;
            }
            int a2 = this.hiq.a(gVar);
            if (a2 == 1 || a2 == 2) {
                this.gTF.vo(a2);
            } else {
                return;
            }
        }
        if (this.hiu != null) {
            this.hiu.a(s, obj);
        }
    }

    public void b(g gVar) {
        a((short) 1, gVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.hgT = eVar;
        if (this.hiu != null) {
            this.hiu.c(eVar);
        }
    }

    public void bg(int i, String str) {
        if (this.hiu != null) {
            this.hiu.bg(i, str);
        }
    }

    public void c(ao aoVar) {
        if (this.hiu != null) {
            this.hiu.c(aoVar);
        }
    }

    public void bh(int i, String str) {
        if (this.hiu != null) {
            this.hiu.bh(i, str);
        }
    }

    public void j(short s) {
        if (this.hiu != null) {
            this.hiu.j(s);
        }
        if (this.hiv != null) {
            this.hiv.Nb();
        }
    }

    public void ccY() {
        if (this.hiu != null) {
            this.hiu.ccY();
        }
        if (this.hiv != null) {
            this.hiv.onStop();
        }
    }

    public void ccZ() {
        if (this.hiu != null) {
            this.hiu.ccZ();
        }
        if (this.hiq != null) {
            this.hiq.onResume();
        }
        if (this.hiv != null) {
            this.hiv.onResume();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.hiu != null) {
            this.hiu.onPause();
        }
        if (this.hiv != null) {
            this.hiv.onPause();
        }
    }

    public boolean cda() {
        if (this.hiu != null) {
            return this.hiu.cda();
        }
        return false;
    }

    public void cdb() {
        if (this.hiu != null) {
            this.hiu.cdb();
        }
    }

    public void vQ(int i) {
        if (i == 1 && !(this.hiu instanceof c)) {
            this.hiu = new c(this.gTF);
        } else if (i == 2 && !(this.hiu instanceof e)) {
            this.hiu = new e(this.gTF);
        } else {
            return;
        }
        this.hiu.ak(this.hiq);
        this.hiu.a(this.hir);
    }

    public void l(int i, int i2, int i3) {
        if (this.hiq != null) {
            this.hiq.l(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hiq != null) {
            this.hiq.onKeyboardVisibilityChanged(z);
        }
        if (this.hiv != null) {
            this.hiv.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hiq != null) {
            this.hiq.onActivityResult(i, i2, intent);
        }
        if (this.hiv != null) {
            this.hiv.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hiv != null) {
            this.hiv.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData cdd() {
        return this.gTF.hbf;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hiq != null) {
            return this.hiq.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.hiq != null) {
            this.hiq.streamStateReceived(i, z, i2, z2);
        }
    }

    public void cco() {
        if (this.hiq != null) {
            this.hiq.cco();
        }
    }

    public void ccA() {
        if (this.hiq != null) {
            this.hiq.ccA();
        }
    }

    public void bYN() {
        if (this.hiq != null) {
            this.hiq.bYN();
        }
    }

    public void mX(boolean z) {
        if (this.hiq != null) {
            this.hiq.mX(z);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.e cde() {
        return this.hgT;
    }

    public boolean cdc() {
        if (this.hiu != null) {
            return this.hiu.cdc();
        }
        return false;
    }

    public int bYP() {
        if (this.gTF != null) {
            return this.gTF.bYP();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.hiq != null) {
            this.hiq.onDestroy();
            this.hiu.onDestroy();
        }
        if (this.hiv != null) {
            this.hiv.cg(false);
        }
    }

    public void g(short s) {
        if (this.hir != null) {
            this.hir.g(s);
        }
        if (this.hiq != null) {
            this.hiq.b(s);
        }
    }

    public void TS() {
        if (this.hir != null) {
            this.hir.TS();
        }
    }

    public void bcW() {
        if (this.hir != null) {
            this.hir.bcW();
        }
    }

    public void bYQ() {
        if (this.hir != null) {
            this.hir.bYQ();
        }
    }

    public void bYR() {
        if (this.hir != null) {
            this.hir.bYR();
        }
    }

    public void bYS() {
        if (this.hir != null) {
            this.hir.bYS();
        }
    }

    public void onRtcConnected(int i) {
        if (this.hiq != null) {
            this.hiq.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.hiq != null) {
            this.hiq.onPKPlayerFirstFrame();
        }
    }
}
