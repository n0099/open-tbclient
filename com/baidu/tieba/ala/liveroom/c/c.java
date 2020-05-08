package com.baidu.tieba.ala.liveroom.c;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.data.at;
import com.baidu.live.data.h;
import com.baidu.live.data.n;
import com.baidu.live.o.e;
import com.baidu.live.o.f;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    private com.baidu.tieba.ala.liveroom.data.a fwN;
    private boolean fxC;
    private at fxx;
    private short fyj = 0;
    private com.baidu.live.liveroom.f.a fyk;
    private com.baidu.live.liveroom.a.b fyl;
    private String otherParams;

    public void d(short s) {
        if (this.fyk != null && (this.fyk instanceof b)) {
            this.fyk.bI(true);
            this.fyk = null;
        }
        if (this.fyk == null) {
            this.fyk = com.baidu.live.liveroom.f.c.DI().DJ().b(s);
            if (this.fyk != null) {
                this.fyk.setActivity(this.fwN.pageContext.getPageActivity());
                this.fyk.a(this.fyl);
                this.fyk.b(this.fwN.fFi);
                if (this.fwN.fFi.getParent() != null && (this.fwN.fFi.getParent() instanceof ViewGroup)) {
                    this.fyk.h((ViewGroup) this.fwN.fFi.getParent());
                }
                this.fyk.a(this.fwN.fFg, this.fwN.aQc);
                this.fyj = (short) 0;
                this.fwN.fFl = false;
                this.fyk.init();
                return;
            }
            return;
        }
        this.fyk.b(this.fwN.fFi);
        if (this.fwN.fFi.getParent() != null && (this.fwN.fFi.getParent() instanceof ViewGroup)) {
            this.fyk.h((ViewGroup) this.fwN.fFi.getParent());
        }
        this.fyk.a(this.fwN.fFg, this.fwN.aQc);
    }

    public void e(short s) {
        if (1 == s) {
            if (this.fyk != null && !(this.fyk instanceof a)) {
                this.fyk.bI(true);
                this.fyk = null;
            }
            if (this.fyk == null) {
                a aVar = new a();
                this.fyj = (short) 0;
                aVar.a(this.fwN);
                aVar.a(this.fyl);
                aVar.setActivity(this.fwN.pageContext.getPageActivity());
                this.fwN.fFl = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.fyk = aVar;
            }
            this.fyk.a(this.fwN.fFg, this.fwN.aQc);
        } else if (2 == s) {
            if (this.fyk != null && !(this.fyk instanceof d)) {
                this.fyk.bI(true);
                this.fyk = null;
            }
            if (this.fyk == null) {
                d dVar = new d();
                this.fyj = (short) 0;
                dVar.a(this.fwN);
                dVar.a(this.fyl);
                dVar.setActivity(this.fwN.pageContext.getPageActivity());
                this.fwN.fFl = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.fyk = dVar;
            }
        }
        if (this.fyk instanceof b) {
            b bVar = (b) this.fyk;
            bVar.bsw();
            bVar.jX(this.fxC);
            bVar.a(this.fxx);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.ala.liveroom.m.c cVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, at atVar) {
        if (this.fwN == null) {
            this.fwN = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.fwN.pageContext = tbPageContext;
        this.fwN.fFi = alaLiveView;
        this.fwN.aQc = fVar;
        this.fwN.fFg = eVar;
        this.fwN.fFh = cVar;
        this.fwN.fromType = str;
        this.fwN.enterTime = j;
        this.fwN.fFj = z;
        this.fwN.fFm = arrayList;
        this.fwN.fFn = false;
        this.fxx = atVar;
    }

    public void jX(boolean z) {
        this.fxC = z;
        if (this.fyk != null && (this.fyk instanceof b)) {
            ((b) this.fyk).jX(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.b bVar) {
        this.fyl = bVar;
        if (this.fyk != null) {
            this.fyk.a(this.fyl);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.fwN != null) {
            this.fwN.fFg = alaLiveRoomBlurPageLayout;
        }
    }

    public void kb(boolean z) {
        if (this.fyj != 1) {
            if (this.fwN != null) {
                this.fwN.fFl = false;
            }
            try {
                if (this.fyk != null) {
                    if (this.fwN != null) {
                        this.fyk.k(this.fwN.fFh.DM());
                    }
                    if ((this.fyk instanceof d) && z) {
                        ((d) this.fyk).kd(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fyj = (short) 1;
        }
    }

    public void bx(int i) {
        this.fwN.fFn = true;
        if (this.fyk != null) {
            this.fyk.bx(i);
        }
    }

    public void btj() {
        if (this.fwN != null) {
            this.fwN.fFk = true;
        }
    }

    public void a(n nVar) {
        if (this.fyk != null) {
            this.fyk.i(nVar);
        }
    }

    public void c(h hVar) {
        if (this.fyk != null) {
            this.fyk.b(hVar);
        }
    }

    public void kc(boolean z) {
        if (this.fyj != 3) {
            try {
                if (this.fwN != null) {
                    this.fwN.fFl = false;
                }
                if (this.fyk != null) {
                    this.fyk.bJ(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fyj = (short) 3;
        }
    }

    public void btk() {
        if (this.fyj != 4) {
            try {
                if (this.fwN != null) {
                    this.fwN.fFl = true;
                    if (this.fyk != null) {
                        this.fyk.l(this.fwN.fFh.DM());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fxx = null;
            this.fyj = (short) 4;
        }
    }

    public boolean btl() {
        if (this.fyk == null || !(this.fyk instanceof b)) {
            return false;
        }
        return ((b) this.fyk).bso();
    }

    public boolean btm() {
        if (this.fyk != null && (this.fyk instanceof b) && ((b) this.fyk).fxL) {
            return false;
        }
        if (this.fyj != 5) {
            if (this.fwN != null) {
                this.fwN.fFl = false;
            }
            try {
                if (this.fyk != null) {
                    boolean DH = this.fyk.DH();
                    if (DH && (this.fyk instanceof b)) {
                        ((b) this.fyk).fxK = true;
                    }
                    return DH;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fyj = (short) 5;
        }
        if (this.fyk != null && (this.fyk instanceof b)) {
            ((b) this.fyk).fxK = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.fyk != null) {
            this.fyk.bI(false);
        }
    }

    public void enterBackground() {
        if (this.fyk != null) {
            this.fyk.onPause();
        }
    }

    public void enterForeground() {
        if (this.fyk != null) {
            this.fyk.onResume();
        }
    }

    public void btn() {
        if (this.fyk != null) {
            this.fyk.onStop();
        }
    }

    public void bto() {
        if (this.fyk != null) {
            this.fyk.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fyk != null) {
            this.fyk.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fyk != null) {
            this.fyk.e(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.fyk != null) {
            this.fyk.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a btg() {
        return this.fwN;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a btp() {
        return this.fyk;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fyk != null) {
            return this.fyk.onKeyDown(i, keyEvent);
        }
        return false;
    }
}
