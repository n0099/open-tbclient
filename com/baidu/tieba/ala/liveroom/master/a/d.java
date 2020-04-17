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
    private com.baidu.tieba.ala.liveroom.data.e fJU;
    private AlaMasterLiveRoomOpearator fLv;
    private b fLw;
    private a fLy;
    private com.baidu.live.liveroom.middleware.a fLz;
    private f fze = new f();

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, com.baidu.live.tieba.e.b bVar, String str) {
        this.fze.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.fze.fFC = alaLiveRecorder;
        this.fze.fFD = frameLayout;
        this.fze.fFd = alaLiveView;
        this.fze.rootView = viewGroup;
        this.fze.fFH = bVar;
        this.fze.fFE = this;
        this.fze.fFG = new AlaLiveRecorderPerfData();
        this.fLv = new AlaMasterLiveRoomOpearator(this.fze, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fLz = k.Dx().Dy();
            this.fze.fFI = this.fLz;
            this.fLz.q(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.m.c cVar) {
        this.fze.fFc = cVar;
    }

    public void setArModel(com.baidu.live.ar.f fVar) {
        this.fze.fFF = fVar;
    }

    public void a(b bVar) {
        this.fLw = bVar;
        if (this.fLy != null) {
            this.fLy.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.fLv != null) {
            g gVar = null;
            if (obj instanceof g) {
                gVar = (g) obj;
            }
            int a = this.fLv.a(gVar);
            if (a == 1 || a == 2) {
                this.fze.qs(a);
            } else {
                return;
            }
        }
        if (this.fLy != null) {
            this.fLy.a(s, obj);
        }
    }

    public void b(g gVar) {
        a((short) 1, gVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.fJU = eVar;
        if (this.fLy != null) {
            this.fLy.c(eVar);
        }
    }

    public void aL(int i, String str) {
        if (this.fLy != null) {
            this.fLy.aL(i, str);
        }
    }

    public void c(h hVar) {
        if (this.fLy != null) {
            this.fLy.c(hVar);
        }
    }

    public void aM(int i, String str) {
        if (this.fLy != null) {
            this.fLy.aM(i, str);
        }
    }

    public void i(short s) {
        if (this.fLy != null) {
            this.fLy.i(s);
        }
        if (this.fLz != null) {
            this.fLz.Dt();
        }
    }

    public void byv() {
        if (this.fLy != null) {
            this.fLy.byv();
        }
        if (this.fLz != null) {
            this.fLz.onStop();
        }
    }

    public void byw() {
        if (this.fLy != null) {
            this.fLy.byw();
        }
        if (this.fLv != null) {
            this.fLv.onResume();
        }
        if (this.fLz != null) {
            this.fLz.onResume();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.fLy != null) {
            this.fLy.onPause();
        }
        if (this.fLz != null) {
            this.fLz.onPause();
        }
    }

    public boolean byx() {
        if (this.fLy != null) {
            return this.fLy.byx();
        }
        return false;
    }

    public void byy() {
        if (this.fLy != null) {
            this.fLy.byy();
        }
    }

    public void qQ(int i) {
        if (i == 1 && !(this.fLy instanceof c)) {
            this.fLy = new c(this.fze);
        } else if (i == 2 && !(this.fLy instanceof e)) {
            this.fLy = new e(this.fze);
        } else {
            return;
        }
        this.fLy.ai(this.fLv);
        this.fLy.a(this.fLw);
    }

    public void l(int i, int i2, int i3) {
        if (this.fLv != null) {
            this.fLv.l(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fLv != null) {
            this.fLv.onKeyboardVisibilityChanged(z);
        }
        if (this.fLz != null) {
            this.fLz.e(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fLv != null) {
            this.fLv.onActivityResult(i, i2, intent);
        }
        if (this.fLz != null) {
            this.fLz.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.fLz != null) {
            this.fLz.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData byA() {
        return this.fze.fFG;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fLv != null) {
            return this.fLv.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.fLv != null) {
            this.fLv.streamStateReceived(i, z, i2, z2);
        }
    }

    public void bxJ() {
        if (this.fLv != null) {
            this.fLv.bxJ();
        }
    }

    public void bxV() {
        if (this.fLv != null) {
            this.fLv.bxV();
        }
    }

    public void bvh() {
        if (this.fLv != null) {
            this.fLv.bvh();
        }
    }

    public com.baidu.tieba.ala.liveroom.data.e byB() {
        return this.fJU;
    }

    public boolean byz() {
        if (this.fLy != null) {
            return this.fLy.byz();
        }
        return false;
    }

    public int bvj() {
        if (this.fze != null) {
            return this.fze.bvj();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.fLv != null) {
            this.fLv.onDestroy();
        }
        if (this.fLz != null) {
            this.fLz.bI(false);
        }
    }

    public void f(short s) {
        if (this.fLw != null) {
            this.fLw.f(s);
        }
    }

    public void Hp() {
        if (this.fLw != null) {
            this.fLw.Hp();
        }
    }

    public void aFe() {
        if (this.fLw != null) {
            this.fLw.aFe();
        }
    }

    public void bvk() {
        if (this.fLw != null) {
            this.fLw.bvk();
        }
    }

    public void bvl() {
        if (this.fLw != null) {
            this.fLw.bvl();
        }
    }

    public void bvm() {
        if (this.fLw != null) {
            this.fLw.bvm();
        }
    }

    public void onRtcConnected(int i) {
        if (this.fLv != null) {
            this.fLv.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.fLv != null) {
            this.fLv.onPKPlayerFirstFrame();
        }
    }
}
