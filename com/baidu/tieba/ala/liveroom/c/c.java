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
    private com.baidu.tieba.ala.liveroom.data.a fwI;
    private at fxs;
    private boolean fxx;
    private short fye = 0;
    private com.baidu.live.liveroom.f.a fyf;
    private com.baidu.live.liveroom.a.b fyg;
    private String otherParams;

    public void d(short s) {
        if (this.fyf != null && (this.fyf instanceof b)) {
            this.fyf.bI(true);
            this.fyf = null;
        }
        if (this.fyf == null) {
            this.fyf = com.baidu.live.liveroom.f.c.DJ().DK().b(s);
            if (this.fyf != null) {
                this.fyf.setActivity(this.fwI.pageContext.getPageActivity());
                this.fyf.a(this.fyg);
                this.fyf.b(this.fwI.fFd);
                if (this.fwI.fFd.getParent() != null && (this.fwI.fFd.getParent() instanceof ViewGroup)) {
                    this.fyf.h((ViewGroup) this.fwI.fFd.getParent());
                }
                this.fyf.a(this.fwI.fFb, this.fwI.aPW);
                this.fye = (short) 0;
                this.fwI.fFg = false;
                this.fyf.init();
                return;
            }
            return;
        }
        this.fyf.b(this.fwI.fFd);
        if (this.fwI.fFd.getParent() != null && (this.fwI.fFd.getParent() instanceof ViewGroup)) {
            this.fyf.h((ViewGroup) this.fwI.fFd.getParent());
        }
        this.fyf.a(this.fwI.fFb, this.fwI.aPW);
    }

    public void e(short s) {
        if (1 == s) {
            if (this.fyf != null && !(this.fyf instanceof a)) {
                this.fyf.bI(true);
                this.fyf = null;
            }
            if (this.fyf == null) {
                a aVar = new a();
                this.fye = (short) 0;
                aVar.a(this.fwI);
                aVar.a(this.fyg);
                aVar.setActivity(this.fwI.pageContext.getPageActivity());
                this.fwI.fFg = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.fyf = aVar;
            }
            this.fyf.a(this.fwI.fFb, this.fwI.aPW);
        } else if (2 == s) {
            if (this.fyf != null && !(this.fyf instanceof d)) {
                this.fyf.bI(true);
                this.fyf = null;
            }
            if (this.fyf == null) {
                d dVar = new d();
                this.fye = (short) 0;
                dVar.a(this.fwI);
                dVar.a(this.fyg);
                dVar.setActivity(this.fwI.pageContext.getPageActivity());
                this.fwI.fFg = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.fyf = dVar;
            }
        }
        if (this.fyf instanceof b) {
            b bVar = (b) this.fyf;
            bVar.bsy();
            bVar.jX(this.fxx);
            bVar.a(this.fxs);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.ala.liveroom.m.c cVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, at atVar) {
        if (this.fwI == null) {
            this.fwI = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.fwI.pageContext = tbPageContext;
        this.fwI.fFd = alaLiveView;
        this.fwI.aPW = fVar;
        this.fwI.fFb = eVar;
        this.fwI.fFc = cVar;
        this.fwI.fromType = str;
        this.fwI.enterTime = j;
        this.fwI.fFe = z;
        this.fwI.fFh = arrayList;
        this.fwI.fFi = false;
        this.fxs = atVar;
    }

    public void jX(boolean z) {
        this.fxx = z;
        if (this.fyf != null && (this.fyf instanceof b)) {
            ((b) this.fyf).jX(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.b bVar) {
        this.fyg = bVar;
        if (this.fyf != null) {
            this.fyf.a(this.fyg);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.fwI != null) {
            this.fwI.fFb = alaLiveRoomBlurPageLayout;
        }
    }

    public void kb(boolean z) {
        if (this.fye != 1) {
            if (this.fwI != null) {
                this.fwI.fFg = false;
            }
            try {
                if (this.fyf != null) {
                    if (this.fwI != null) {
                        this.fyf.k(this.fwI.fFc.DN());
                    }
                    if ((this.fyf instanceof d) && z) {
                        ((d) this.fyf).kd(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fye = (short) 1;
        }
    }

    public void bx(int i) {
        this.fwI.fFi = true;
        if (this.fyf != null) {
            this.fyf.bx(i);
        }
    }

    public void btl() {
        if (this.fwI != null) {
            this.fwI.fFf = true;
        }
    }

    public void a(n nVar) {
        if (this.fyf != null) {
            this.fyf.i(nVar);
        }
    }

    public void c(h hVar) {
        if (this.fyf != null) {
            this.fyf.b(hVar);
        }
    }

    public void kc(boolean z) {
        if (this.fye != 3) {
            try {
                if (this.fwI != null) {
                    this.fwI.fFg = false;
                }
                if (this.fyf != null) {
                    this.fyf.bJ(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fye = (short) 3;
        }
    }

    public void btm() {
        if (this.fye != 4) {
            try {
                if (this.fwI != null) {
                    this.fwI.fFg = true;
                    if (this.fyf != null) {
                        this.fyf.l(this.fwI.fFc.DN());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fxs = null;
            this.fye = (short) 4;
        }
    }

    public boolean btn() {
        if (this.fyf == null || !(this.fyf instanceof b)) {
            return false;
        }
        return ((b) this.fyf).bsq();
    }

    public boolean bto() {
        if (this.fyf != null && (this.fyf instanceof b) && ((b) this.fyf).fxG) {
            return false;
        }
        if (this.fye != 5) {
            if (this.fwI != null) {
                this.fwI.fFg = false;
            }
            try {
                if (this.fyf != null) {
                    boolean DI = this.fyf.DI();
                    if (DI && (this.fyf instanceof b)) {
                        ((b) this.fyf).fxF = true;
                    }
                    return DI;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fye = (short) 5;
        }
        if (this.fyf != null && (this.fyf instanceof b)) {
            ((b) this.fyf).fxF = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.fyf != null) {
            this.fyf.bI(false);
        }
    }

    public void enterBackground() {
        if (this.fyf != null) {
            this.fyf.onPause();
        }
    }

    public void enterForeground() {
        if (this.fyf != null) {
            this.fyf.onResume();
        }
    }

    public void btp() {
        if (this.fyf != null) {
            this.fyf.onStop();
        }
    }

    public void btq() {
        if (this.fyf != null) {
            this.fyf.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fyf != null) {
            this.fyf.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fyf != null) {
            this.fyf.e(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.fyf != null) {
            this.fyf.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a bti() {
        return this.fwI;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a btr() {
        return this.fyf;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fyf != null) {
            return this.fyf.onKeyDown(i, keyEvent);
        }
        return false;
    }
}
