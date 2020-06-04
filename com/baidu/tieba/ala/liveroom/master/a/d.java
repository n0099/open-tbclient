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
    private f fNw = new f();
    private com.baidu.tieba.ala.liveroom.data.e fYi;
    private AlaMasterLiveRoomOpearator fZJ;
    private b fZK;
    private a fZM;
    private com.baidu.live.liveroom.middleware.a fZN;

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, com.baidu.live.tieba.e.b bVar, String str) {
        this.fNw.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.fNw.fTM = alaLiveRecorder;
        this.fNw.fTN = frameLayout;
        this.fNw.fTn = alaLiveView;
        this.fNw.rootView = viewGroup;
        this.fNw.fTR = bVar;
        this.fNw.fTO = this;
        this.fNw.fTQ = new AlaLiveRecorderPerfData();
        this.fZJ = new AlaMasterLiveRoomOpearator(this.fNw, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fZN = k.EU().EV();
            this.fNw.fTS = this.fZN;
            this.fZN.q(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.m.c cVar) {
        this.fNw.fTm = cVar;
    }

    public void setArModel(com.baidu.live.ar.f fVar) {
        this.fNw.fTP = fVar;
    }

    public void a(b bVar) {
        this.fZK = bVar;
        if (this.fZM != null) {
            this.fZM.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.fZJ != null) {
            g gVar = null;
            if (obj instanceof g) {
                gVar = (g) obj;
            }
            int a = this.fZJ.a(gVar);
            if (a == 1 || a == 2) {
                this.fNw.qV(a);
            } else {
                return;
            }
        }
        if (this.fZM != null) {
            this.fZM.a(s, obj);
        }
    }

    public void b(g gVar) {
        a((short) 1, gVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.fYi = eVar;
        if (this.fZM != null) {
            this.fZM.c(eVar);
        }
    }

    public void aQ(int i, String str) {
        if (this.fZM != null) {
            this.fZM.aQ(i, str);
        }
    }

    public void c(h hVar) {
        if (this.fZM != null) {
            this.fZM.c(hVar);
        }
    }

    public void aR(int i, String str) {
        if (this.fZM != null) {
            this.fZM.aR(i, str);
        }
    }

    public void i(short s) {
        if (this.fZM != null) {
            this.fZM.i(s);
        }
        if (this.fZN != null) {
            this.fZN.EQ();
        }
    }

    public void bEy() {
        if (this.fZM != null) {
            this.fZM.bEy();
        }
        if (this.fZN != null) {
            this.fZN.onStop();
        }
    }

    public void bEz() {
        if (this.fZM != null) {
            this.fZM.bEz();
        }
        if (this.fZJ != null) {
            this.fZJ.onResume();
        }
        if (this.fZN != null) {
            this.fZN.onResume();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.fZM != null) {
            this.fZM.onPause();
        }
        if (this.fZN != null) {
            this.fZN.onPause();
        }
    }

    public boolean bEA() {
        if (this.fZM != null) {
            return this.fZM.bEA();
        }
        return false;
    }

    public void bEB() {
        if (this.fZM != null) {
            this.fZM.bEB();
        }
    }

    public void rt(int i) {
        if (i == 1 && !(this.fZM instanceof c)) {
            this.fZM = new c(this.fNw);
        } else if (i == 2 && !(this.fZM instanceof e)) {
            this.fZM = new e(this.fNw);
        } else {
            return;
        }
        this.fZM.ai(this.fZJ);
        this.fZM.a(this.fZK);
    }

    public void l(int i, int i2, int i3) {
        if (this.fZJ != null) {
            this.fZJ.l(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fZJ != null) {
            this.fZJ.onKeyboardVisibilityChanged(z);
        }
        if (this.fZN != null) {
            this.fZN.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fZJ != null) {
            this.fZJ.onActivityResult(i, i2, intent);
        }
        if (this.fZN != null) {
            this.fZN.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.fZN != null) {
            this.fZN.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData bED() {
        return this.fNw.fTQ;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fZJ != null) {
            return this.fZJ.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.fZJ != null) {
            this.fZJ.streamStateReceived(i, z, i2, z2);
        }
    }

    public void bDM() {
        if (this.fZJ != null) {
            this.fZJ.bDM();
        }
    }

    public void bDY() {
        if (this.fZJ != null) {
            this.fZJ.bDY();
        }
    }

    public void bBg() {
        if (this.fZJ != null) {
            this.fZJ.bBg();
        }
    }

    public void kL(boolean z) {
        if (this.fZJ != null) {
            this.fZJ.kL(z);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.e bEE() {
        return this.fYi;
    }

    public boolean bEC() {
        if (this.fZM != null) {
            return this.fZM.bEC();
        }
        return false;
    }

    public int bBi() {
        if (this.fNw != null) {
            return this.fNw.bBi();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.fZJ != null) {
            this.fZJ.onDestroy();
        }
        if (this.fZN != null) {
            this.fZN.bR(false);
        }
    }

    public void f(short s) {
        if (this.fZK != null) {
            this.fZK.f(s);
        }
    }

    public void Jh() {
        if (this.fZK != null) {
            this.fZK.Jh();
        }
    }

    public void aKz() {
        if (this.fZK != null) {
            this.fZK.aKz();
        }
    }

    public void bBj() {
        if (this.fZK != null) {
            this.fZK.bBj();
        }
    }

    public void bBk() {
        if (this.fZK != null) {
            this.fZK.bBk();
        }
    }

    public void bBl() {
        if (this.fZK != null) {
            this.fZK.bBl();
        }
    }

    public void onRtcConnected(int i) {
        if (this.fZJ != null) {
            this.fZJ.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.fZJ != null) {
            this.fZJ.onPKPlayerFirstFrame();
        }
    }
}
