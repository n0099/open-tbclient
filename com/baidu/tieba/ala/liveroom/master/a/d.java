package com.baidu.tieba.ala.liveroom.master.a;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.ar.h;
import com.baidu.live.data.ag;
import com.baidu.live.liveroom.middleware.k;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes7.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.data.e gDb;
    private b gEA;
    private a gEC;
    private com.baidu.live.liveroom.middleware.a gED;
    private AlaMasterLiveRoomOpearator gEz;
    private f gqb = new f();

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, ViewGroup viewGroup2, com.baidu.live.tieba.e.b bVar, String str) {
        this.gqb.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.gqb.gxE = alaLiveRecorder;
        this.gqb.gxF = frameLayout;
        this.gqb.gxf = alaLiveView;
        this.gqb.rootView = viewGroup;
        this.gqb.gxG = viewGroup2;
        this.gqb.gxK = bVar;
        this.gqb.gxH = this;
        this.gqb.gxJ = new AlaLiveRecorderPerfData();
        this.gEz = new AlaMasterLiveRoomOpearator(this.gqb, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gED = k.Le().Lf();
            this.gqb.gxL = this.gED;
            this.gED.r(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.p.d dVar) {
        this.gqb.gxe = dVar;
    }

    public void setArModel(h hVar) {
        this.gqb.gxI = hVar;
    }

    public void a(b bVar) {
        this.gEA = bVar;
        if (this.gEC != null) {
            this.gEC.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.gEz != null) {
            g gVar = null;
            if (obj instanceof g) {
                gVar = (g) obj;
            }
            int a = this.gEz.a(gVar);
            if (a == 1 || a == 2) {
                this.gqb.tW(a);
            } else {
                return;
            }
        }
        if (this.gEC != null) {
            this.gEC.a(s, obj);
        }
    }

    public void b(g gVar) {
        a((short) 1, gVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.gDb = eVar;
        if (this.gEC != null) {
            this.gEC.c(eVar);
        }
    }

    public void aU(int i, String str) {
        if (this.gEC != null) {
            this.gEC.aU(i, str);
        }
    }

    public void c(ag agVar) {
        if (this.gEC != null) {
            this.gEC.c(agVar);
        }
    }

    public void aV(int i, String str) {
        if (this.gEC != null) {
            this.gEC.aV(i, str);
        }
    }

    public void i(short s) {
        if (this.gEC != null) {
            this.gEC.i(s);
        }
        if (this.gED != null) {
            this.gED.La();
        }
    }

    public void bUO() {
        if (this.gEC != null) {
            this.gEC.bUO();
        }
        if (this.gED != null) {
            this.gED.onStop();
        }
    }

    public void bUP() {
        if (this.gEC != null) {
            this.gEC.bUP();
        }
        if (this.gEz != null) {
            this.gEz.onResume();
        }
        if (this.gED != null) {
            this.gED.onResume();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.gEC != null) {
            this.gEC.onPause();
        }
        if (this.gED != null) {
            this.gED.onPause();
        }
    }

    public boolean bUQ() {
        if (this.gEC != null) {
            return this.gEC.bUQ();
        }
        return false;
    }

    public void bUR() {
        if (this.gEC != null) {
            this.gEC.bUR();
        }
    }

    public void uy(int i) {
        if (i == 1 && !(this.gEC instanceof c)) {
            this.gEC = new c(this.gqb);
        } else if (i == 2 && !(this.gEC instanceof e)) {
            this.gEC = new e(this.gqb);
        } else {
            return;
        }
        this.gEC.ai(this.gEz);
        this.gEC.a(this.gEA);
    }

    public void l(int i, int i2, int i3) {
        if (this.gEz != null) {
            this.gEz.l(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gEz != null) {
            this.gEz.onKeyboardVisibilityChanged(z);
        }
        if (this.gED != null) {
            this.gED.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gEz != null) {
            this.gEz.onActivityResult(i, i2, intent);
        }
        if (this.gED != null) {
            this.gED.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.gED != null) {
            this.gED.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData bUT() {
        return this.gqb.gxJ;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.gEz != null) {
            return this.gEz.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.gEz != null) {
            this.gEz.streamStateReceived(i, z, i2, z2);
        }
    }

    public void bUe() {
        if (this.gEz != null) {
            this.gEz.bUe();
        }
    }

    public void bUq() {
        if (this.gEz != null) {
            this.gEz.bUq();
        }
    }

    public void bQY() {
        if (this.gEz != null) {
            this.gEz.bQY();
        }
    }

    public void ma(boolean z) {
        if (this.gEz != null) {
            this.gEz.ma(z);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.e bUU() {
        return this.gDb;
    }

    public boolean bUS() {
        if (this.gEC != null) {
            return this.gEC.bUS();
        }
        return false;
    }

    public int bRa() {
        if (this.gqb != null) {
            return this.gqb.bRa();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.gEz != null) {
            this.gEz.onDestroy();
        }
        if (this.gED != null) {
            this.gED.cb(false);
        }
    }

    public void f(short s) {
        if (this.gEA != null) {
            this.gEA.f(s);
        }
    }

    public void Qt() {
        if (this.gEA != null) {
            this.gEA.Qt();
        }
    }

    public void aXJ() {
        if (this.gEA != null) {
            this.gEA.aXJ();
        }
    }

    public void bRb() {
        if (this.gEA != null) {
            this.gEA.bRb();
        }
    }

    public void bRc() {
        if (this.gEA != null) {
            this.gEA.bRc();
        }
    }

    public void bRd() {
        if (this.gEA != null) {
            this.gEA.bRd();
        }
    }

    public void onRtcConnected(int i) {
        if (this.gEz != null) {
            this.gEz.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.gEz != null) {
            this.gEz.onPKPlayerFirstFrame();
        }
    }
}
