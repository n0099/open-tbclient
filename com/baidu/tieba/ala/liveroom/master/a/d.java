package com.baidu.tieba.ala.liveroom.master.a;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.aw;
import com.baidu.live.liveroom.middleware.k;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes11.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.data.d hHG;
    private AlaMasterLiveRoomOpearator hJb;
    private b hJc;
    private a hJe;
    private com.baidu.live.liveroom.middleware.a hJf;
    private com.baidu.tieba.ala.liveroom.data.e huB = new com.baidu.tieba.ala.liveroom.data.e();

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, ViewGroup viewGroup2, com.baidu.live.tieba.e.b bVar, String str, View view) {
        this.huB.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.huB.hBK = alaLiveRecorder;
        this.huB.hBL = view;
        this.huB.hBM = frameLayout;
        this.huB.hBu = alaLiveView;
        this.huB.rootView = viewGroup;
        this.huB.hBN = viewGroup2;
        this.huB.hBR = bVar;
        this.huB.hBO = this;
        this.huB.hBQ = new AlaLiveRecorderPerfData();
        this.hJb = new AlaMasterLiveRoomOpearator(this.huB, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hJf = k.MF().MG();
            this.huB.hBS = this.hJf;
            this.hJf.q(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.n.d dVar) {
        this.huB.hBt = dVar;
    }

    public void setArModel(com.baidu.live.ar.k kVar) {
        this.huB.hBP = kVar;
    }

    public void a(b bVar) {
        this.hJc = bVar;
        if (this.hJe != null) {
            this.hJe.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.hJb != null) {
            f fVar = null;
            if (obj instanceof f) {
                fVar = (f) obj;
            }
            int a2 = this.hJb.a(fVar);
            if (a2 == 1 || a2 == 2) {
                this.huB.vu(a2);
            } else {
                return;
            }
        }
        if (this.hJe != null) {
            this.hJe.a(s, obj);
        }
    }

    public void b(f fVar) {
        a((short) 1, fVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.hHG = dVar;
        if (this.hJe != null) {
            this.hJe.c(dVar);
        }
    }

    public void bq(int i, String str) {
        if (this.hJe != null) {
            this.hJe.bq(i, str);
        }
    }

    public void c(aw awVar) {
        if (this.hJe != null) {
            this.hJe.c(awVar);
        }
    }

    public void br(int i, String str) {
        if (this.hJe != null) {
            this.hJe.br(i, str);
        }
    }

    public void j(short s) {
        if (this.hJe != null) {
            this.hJe.j(s);
        }
        if (this.hJf != null) {
            this.hJf.MB();
        }
    }

    public void markEnterBackground() {
        if (this.hJe != null) {
            this.hJe.markEnterBackground();
        }
        if (this.hJf != null) {
            this.hJf.onStop();
        }
    }

    public void markEnterForeground() {
        if (this.hJe != null) {
            this.hJe.markEnterForeground();
        }
        if (this.hJb != null) {
            this.hJb.onResume();
        }
        if (this.hJf != null) {
            this.hJf.onResume();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.hJe != null) {
            this.hJe.onPause();
        }
        if (this.hJf != null) {
            this.hJf.onPause();
        }
    }

    public boolean ciD() {
        if (this.hJe != null) {
            return this.hJe.ciD();
        }
        return false;
    }

    public void ciE() {
        if (this.hJe != null) {
            this.hJe.ciE();
        }
    }

    public void vW(int i) {
        if (i == 1 && !(this.hJe instanceof c)) {
            this.hJe = new c(this.huB);
        } else if (i == 2 && !(this.hJe instanceof e)) {
            this.hJe = new e(this.huB);
        } else {
            return;
        }
        this.hJe.ao(this.hJb);
        this.hJe.a(this.hJc);
    }

    public void l(int i, int i2, int i3) {
        if (this.hJb != null) {
            this.hJb.l(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hJb != null) {
            this.hJb.onKeyboardVisibilityChanged(z);
        }
        if (this.hJf != null) {
            this.hJf.e(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hJb != null) {
            this.hJb.onActivityResult(i, i2, intent);
        }
        if (this.hJf != null) {
            this.hJf.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hJf != null) {
            this.hJf.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData ciG() {
        return this.huB.hBQ;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hJb != null) {
            return this.hJb.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.hJb != null) {
            this.hJb.streamStateReceived(i, z, i2, z2);
        }
    }

    public void sendBufferChanged(int i) {
        if (this.hJb != null) {
            this.hJb.sendBufferChanged(i);
        }
    }

    public void chS() {
        if (this.hJb != null) {
            this.hJb.chS();
        }
    }

    public void cie() {
        if (this.hJb != null) {
            this.hJb.cie();
        }
    }

    public void cey() {
        if (this.hJb != null) {
            this.hJb.cey();
        }
    }

    public void oj(boolean z) {
        if (this.hJb != null) {
            this.hJb.oj(z);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.d ciH() {
        return this.hHG;
    }

    public boolean ciF() {
        if (this.hJe != null) {
            return this.hJe.ciF();
        }
        return false;
    }

    public int bQY() {
        if (this.huB != null) {
            return this.huB.bQY();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.hJb != null) {
            this.hJb.onDestroy();
        }
        if (this.hJf != null) {
            this.hJf.cF(false);
        }
    }

    public void g(short s) {
        if (this.hJc != null) {
            this.hJc.g(s);
        }
        if (this.hJb != null) {
            this.hJb.b(s);
        }
    }

    public void Xi() {
        if (this.hJc != null) {
            this.hJc.Xi();
        }
    }

    public void ceA() {
        if (this.hJc != null) {
            this.hJc.ceA();
        }
    }

    public void ceB() {
        if (this.hJc != null) {
            this.hJc.ceB();
        }
    }

    public void ceC() {
        if (this.hJc != null) {
            this.hJc.ceC();
        }
    }

    public void ceD() {
        if (this.hJc != null) {
            this.hJc.ceD();
        }
    }

    public void onRtcConnected(int i) {
        if (this.hJb != null) {
            this.hJb.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.hJb != null) {
            this.hJb.onPKPlayerFirstFrame();
        }
    }

    public void VC() {
        if (this.hJb != null) {
            this.hJb.VC();
        }
    }
}
