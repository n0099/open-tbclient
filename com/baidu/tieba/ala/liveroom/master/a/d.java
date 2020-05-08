package com.baidu.tieba.ala.liveroom.master.a;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
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
    private com.baidu.tieba.ala.liveroom.data.e fJZ;
    private AlaMasterLiveRoomOpearator fLA;
    private b fLB;
    private a fLD;
    private com.baidu.live.liveroom.middleware.a fLE;
    private f fzj = new f();

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, com.baidu.live.tieba.e.b bVar, String str) {
        this.fzj.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.fzj.fFH = alaLiveRecorder;
        this.fzj.fFI = frameLayout;
        this.fzj.fFi = alaLiveView;
        this.fzj.rootView = viewGroup;
        this.fzj.fFM = bVar;
        this.fzj.fFJ = this;
        this.fzj.fFL = new AlaLiveRecorderPerfData();
        this.fLA = new AlaMasterLiveRoomOpearator(this.fzj, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fLE = k.Dw().Dx();
            this.fzj.fFN = this.fLE;
            this.fLE.q(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.m.c cVar) {
        this.fzj.fFh = cVar;
    }

    public void setArModel(com.baidu.live.ar.f fVar) {
        this.fzj.fFK = fVar;
    }

    public void a(b bVar) {
        this.fLB = bVar;
        if (this.fLD != null) {
            this.fLD.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.fLA != null) {
            g gVar = null;
            if (obj instanceof g) {
                gVar = (g) obj;
            }
            int a = this.fLA.a(gVar);
            if (a == 1 || a == 2) {
                this.fzj.qs(a);
            } else {
                return;
            }
        }
        if (this.fLD != null) {
            this.fLD.a(s, obj);
        }
    }

    public void b(g gVar) {
        a((short) 1, gVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.fJZ = eVar;
        if (this.fLD != null) {
            this.fLD.c(eVar);
        }
    }

    public void aL(int i, String str) {
        if (this.fLD != null) {
            this.fLD.aL(i, str);
        }
    }

    public void c(h hVar) {
        if (this.fLD != null) {
            this.fLD.c(hVar);
        }
    }

    public void aM(int i, String str) {
        if (this.fLD != null) {
            this.fLD.aM(i, str);
        }
    }

    public void i(short s) {
        if (this.fLD != null) {
            this.fLD.i(s);
        }
        if (this.fLE != null) {
            this.fLE.Ds();
        }
    }

    public void byt() {
        if (this.fLD != null) {
            this.fLD.byt();
        }
        if (this.fLE != null) {
            this.fLE.onStop();
        }
    }

    public void byu() {
        if (this.fLD != null) {
            this.fLD.byu();
        }
        if (this.fLA != null) {
            this.fLA.onResume();
        }
        if (this.fLE != null) {
            this.fLE.onResume();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.fLD != null) {
            this.fLD.onPause();
        }
        if (this.fLE != null) {
            this.fLE.onPause();
        }
    }

    public boolean byv() {
        if (this.fLD != null) {
            return this.fLD.byv();
        }
        return false;
    }

    public void byw() {
        if (this.fLD != null) {
            this.fLD.byw();
        }
    }

    public void qQ(int i) {
        if (i == 1 && !(this.fLD instanceof c)) {
            this.fLD = new c(this.fzj);
        } else if (i == 2 && !(this.fLD instanceof e)) {
            this.fLD = new e(this.fzj);
        } else {
            return;
        }
        this.fLD.ai(this.fLA);
        this.fLD.a(this.fLB);
    }

    public void l(int i, int i2, int i3) {
        if (this.fLA != null) {
            this.fLA.l(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fLA != null) {
            this.fLA.onKeyboardVisibilityChanged(z);
        }
        if (this.fLE != null) {
            this.fLE.e(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fLA != null) {
            this.fLA.onActivityResult(i, i2, intent);
        }
        if (this.fLE != null) {
            this.fLE.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.fLE != null) {
            this.fLE.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData byy() {
        return this.fzj.fFL;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fLA != null) {
            return this.fLA.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.fLA != null) {
            this.fLA.streamStateReceived(i, z, i2, z2);
        }
    }

    public void bxH() {
        if (this.fLA != null) {
            this.fLA.bxH();
        }
    }

    public void bxT() {
        if (this.fLA != null) {
            this.fLA.bxT();
        }
    }

    public void bvf() {
        if (this.fLA != null) {
            this.fLA.bvf();
        }
    }

    public com.baidu.tieba.ala.liveroom.data.e byz() {
        return this.fJZ;
    }

    public boolean byx() {
        if (this.fLD != null) {
            return this.fLD.byx();
        }
        return false;
    }

    public int bvh() {
        if (this.fzj != null) {
            return this.fzj.bvh();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.fLA != null) {
            this.fLA.onDestroy();
        }
        if (this.fLE != null) {
            this.fLE.bI(false);
        }
    }

    public void f(short s) {
        if (this.fLB != null) {
            this.fLB.f(s);
        }
    }

    public void Ho() {
        if (this.fLB != null) {
            this.fLB.Ho();
        }
    }

    public void aFe() {
        if (this.fLB != null) {
            this.fLB.aFe();
        }
    }

    public void bvi() {
        if (this.fLB != null) {
            this.fLB.bvi();
        }
    }

    public void bvj() {
        if (this.fLB != null) {
            this.fLB.bvj();
        }
    }

    public void bvk() {
        if (this.fLB != null) {
            this.fLB.bvk();
        }
    }

    public void onRtcConnected(int i) {
        if (this.fLA != null) {
            this.fLA.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.fLA != null) {
            this.fLA.onPKPlayerFirstFrame();
        }
    }
}
