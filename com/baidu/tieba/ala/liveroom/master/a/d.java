package com.baidu.tieba.ala.liveroom.master.a;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.as;
import com.baidu.live.liveroom.middleware.k;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomActivity;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
/* loaded from: classes11.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.data.d hHZ;
    private AlaMasterLiveRoomOpearator hJv;
    private b hJw;
    private a hJy;
    private com.baidu.live.liveroom.middleware.a hJz;
    private com.baidu.tieba.ala.liveroom.data.e huX = new com.baidu.tieba.ala.liveroom.data.e();

    public d(AlaMasterLiveRoomActivity alaMasterLiveRoomActivity, AlaLiveRecorder alaLiveRecorder, AlaLiveView alaLiveView, FrameLayout frameLayout, ViewGroup viewGroup, ViewGroup viewGroup2, com.baidu.live.tieba.e.b bVar, String str, View view) {
        this.huX.pageContext = alaMasterLiveRoomActivity.getPageContext();
        this.huX.hCg = alaLiveRecorder;
        this.huX.hCh = view;
        this.huX.hCi = frameLayout;
        this.huX.hBQ = alaLiveView;
        this.huX.rootView = viewGroup;
        this.huX.hCj = viewGroup2;
        this.huX.hCn = bVar;
        this.huX.hCk = this;
        this.huX.hCm = new AlaLiveRecorderPerfData();
        this.hJv = new AlaMasterLiveRoomOpearator(this.huX, str);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hJz = k.Pc().Pd();
            this.huX.hCo = this.hJz;
            this.hJz.q(alaMasterLiveRoomActivity.getPageContext().getPageActivity());
        }
    }

    public void a(com.baidu.tieba.ala.liveroom.p.d dVar) {
        this.huX.hBP = dVar;
    }

    public void setArModel(com.baidu.live.ar.k kVar) {
        this.huX.hCl = kVar;
    }

    public void a(b bVar) {
        this.hJw = bVar;
        if (this.hJy != null) {
            this.hJy.a(bVar);
        }
    }

    public void a(short s, Object obj) {
        if (s == 1 && this.hJv != null) {
            f fVar = null;
            if (obj instanceof f) {
                fVar = (f) obj;
            }
            int a2 = this.hJv.a(fVar);
            if (a2 == 1 || a2 == 2) {
                this.huX.wP(a2);
            } else {
                return;
            }
        }
        if (this.hJy != null) {
            this.hJy.a(s, obj);
        }
    }

    public void b(f fVar) {
        a((short) 1, fVar);
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.hHZ = dVar;
        if (this.hJy != null) {
            this.hJy.c(dVar);
        }
    }

    public void bk(int i, String str) {
        if (this.hJy != null) {
            this.hJy.bk(i, str);
        }
    }

    public void c(as asVar) {
        if (this.hJy != null) {
            this.hJy.c(asVar);
        }
    }

    public void bl(int i, String str) {
        if (this.hJy != null) {
            this.hJy.bl(i, str);
        }
    }

    public void j(short s) {
        if (this.hJy != null) {
            this.hJy.j(s);
        }
        if (this.hJz != null) {
            this.hJz.OY();
        }
    }

    public void markEnterBackground() {
        if (this.hJy != null) {
            this.hJy.markEnterBackground();
        }
        if (this.hJz != null) {
            this.hJz.onStop();
        }
    }

    public void markEnterForeground() {
        if (this.hJy != null) {
            this.hJy.markEnterForeground();
        }
        if (this.hJv != null) {
            this.hJv.onResume();
        }
        if (this.hJz != null) {
            this.hJz.onResume();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.hJy != null) {
            this.hJy.onPause();
        }
        if (this.hJz != null) {
            this.hJz.onPause();
        }
    }

    public boolean clB() {
        if (this.hJy != null) {
            return this.hJy.clB();
        }
        return false;
    }

    public void clC() {
        if (this.hJy != null) {
            this.hJy.clC();
        }
    }

    public void xr(int i) {
        if (i == 1 && !(this.hJy instanceof c)) {
            this.hJy = new c(this.huX);
        } else if (i == 2 && !(this.hJy instanceof e)) {
            this.hJy = new e(this.huX);
        } else {
            return;
        }
        this.hJy.aq(this.hJv);
        this.hJy.a(this.hJw);
    }

    public void l(int i, int i2, int i3) {
        if (this.hJv != null) {
            this.hJv.l(i, i2, i3);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hJv != null) {
            this.hJv.onKeyboardVisibilityChanged(z);
        }
        if (this.hJz != null) {
            this.hJz.e(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.hJv != null) {
            this.hJv.onActivityResult(i, i2, intent);
        }
        if (this.hJz != null) {
            this.hJz.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.hJz != null) {
            this.hJz.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public AlaLiveRecorderPerfData clE() {
        return this.huX.hCm;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hJv != null) {
            return this.hJv.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        if (this.hJv != null) {
            this.hJv.streamStateReceived(i, z, i2, z2);
        }
    }

    public void sendBufferChanged(int i) {
        if (this.hJv != null) {
            this.hJv.sendBufferChanged(i);
        }
    }

    public void ckQ() {
        if (this.hJv != null) {
            this.hJv.ckQ();
        }
    }

    public void clc() {
        if (this.hJv != null) {
            this.hJv.clc();
        }
    }

    public void chu() {
        if (this.hJv != null) {
            this.hJv.chu();
        }
    }

    public void oc(boolean z) {
        if (this.hJv != null) {
            this.hJv.oc(z);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.d clF() {
        return this.hHZ;
    }

    public boolean clD() {
        if (this.hJy != null) {
            return this.hJy.clD();
        }
        return false;
    }

    public int bUl() {
        if (this.huX != null) {
            return this.huX.bUl();
        }
        return 0;
    }

    public void onDestroy() {
        if (this.hJv != null) {
            this.hJv.onDestroy();
        }
        if (this.hJz != null) {
            this.hJz.cA(false);
        }
    }

    public void g(short s) {
        if (this.hJw != null) {
            this.hJw.g(s);
        }
        if (this.hJv != null) {
            this.hJv.b(s);
        }
    }

    public void Zr() {
        if (this.hJw != null) {
            this.hJw.Zr();
        }
    }

    public void chw() {
        if (this.hJw != null) {
            this.hJw.chw();
        }
    }

    public void chx() {
        if (this.hJw != null) {
            this.hJw.chx();
        }
    }

    public void chy() {
        if (this.hJw != null) {
            this.hJw.chy();
        }
    }

    public void chz() {
        if (this.hJw != null) {
            this.hJw.chz();
        }
    }

    public void onRtcConnected(int i) {
        if (this.hJv != null) {
            this.hJv.onRtcConnected(i);
        }
    }

    public void onPKPlayerFirstFrame() {
        if (this.hJv != null) {
            this.hJv.onPKPlayerFirstFrame();
        }
    }
}
