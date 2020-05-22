package com.baidu.tieba.ala.liveroom.c;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.data.ay;
import com.baidu.live.data.k;
import com.baidu.live.data.q;
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
    private com.baidu.tieba.ala.liveroom.data.a fKK;
    private boolean fLB;
    private ay fLw;
    private short fMl = 0;
    private com.baidu.live.liveroom.f.a fMm;
    private com.baidu.live.liveroom.a.b fMn;
    private String otherParams;

    public void d(short s) {
        if (this.fMm != null && (this.fMm instanceof b)) {
            this.fMm.bR(true);
            this.fMm = null;
        }
        if (this.fMm == null) {
            this.fMm = com.baidu.live.liveroom.f.c.Fg().Fh().b(s);
            if (this.fMm != null) {
                this.fMm.setActivity(this.fKK.pageContext.getPageActivity());
                this.fMm.a(this.fMn);
                this.fMm.b(this.fKK.fTc);
                if (this.fKK.fTc.getParent() != null && (this.fKK.fTc.getParent() instanceof ViewGroup)) {
                    this.fMm.l((ViewGroup) this.fKK.fTc.getParent());
                }
                this.fMm.a(this.fKK.fTa, this.fKK.aWl);
                this.fMl = (short) 0;
                this.fKK.fTf = false;
                this.fMm.init();
                return;
            }
            return;
        }
        this.fMm.b(this.fKK.fTc);
        if (this.fKK.fTc.getParent() != null && (this.fKK.fTc.getParent() instanceof ViewGroup)) {
            this.fMm.l((ViewGroup) this.fKK.fTc.getParent());
        }
        this.fMm.a(this.fKK.fTa, this.fKK.aWl);
    }

    public void e(short s) {
        if (1 == s) {
            if (this.fMm != null && !(this.fMm instanceof a)) {
                this.fMm.bR(true);
                this.fMm = null;
            }
            if (this.fMm == null) {
                a aVar = new a();
                this.fMl = (short) 0;
                aVar.a(this.fKK);
                aVar.a(this.fMn);
                aVar.setActivity(this.fKK.pageContext.getPageActivity());
                this.fKK.fTf = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.fMm = aVar;
            }
            this.fMm.a(this.fKK.fTa, this.fKK.aWl);
        } else if (2 == s) {
            if (this.fMm != null && !(this.fMm instanceof d)) {
                this.fMm.bR(true);
                this.fMm = null;
            }
            if (this.fMm == null) {
                d dVar = new d();
                this.fMl = (short) 0;
                dVar.a(this.fKK);
                dVar.a(this.fMn);
                dVar.setActivity(this.fKK.pageContext.getPageActivity());
                this.fKK.fTf = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.fMm = dVar;
            }
        }
        if (this.fMm instanceof b) {
            b bVar = (b) this.fMm;
            bVar.byr();
            bVar.kr(this.fLB);
            bVar.a(this.fLw);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.ala.liveroom.m.c cVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, ay ayVar) {
        if (this.fKK == null) {
            this.fKK = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.fKK.pageContext = tbPageContext;
        this.fKK.fTc = alaLiveView;
        this.fKK.aWl = fVar;
        this.fKK.fTa = eVar;
        this.fKK.fTb = cVar;
        this.fKK.fromType = str;
        this.fKK.enterTime = j;
        this.fKK.fTd = z;
        this.fKK.fTg = arrayList;
        this.fKK.fTh = false;
        this.fLw = ayVar;
    }

    public void kr(boolean z) {
        this.fLB = z;
        if (this.fMm != null && (this.fMm instanceof b)) {
            ((b) this.fMm).kr(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.b bVar) {
        this.fMn = bVar;
        if (this.fMm != null) {
            this.fMm.a(this.fMn);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.fKK != null) {
            this.fKK.fTa = alaLiveRoomBlurPageLayout;
        }
    }

    public void kv(boolean z) {
        if (this.fMl != 1) {
            if (this.fKK != null) {
                this.fKK.fTf = false;
            }
            try {
                if (this.fMm != null) {
                    if (this.fKK != null) {
                        this.fMm.k(this.fKK.fTb.Fk());
                    }
                    if ((this.fMm instanceof d) && z) {
                        ((d) this.fMm).kx(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fMl = (short) 1;
        }
    }

    public void bE(int i) {
        this.fKK.fTh = true;
        if (this.fMm != null) {
            this.fMm.bE(i);
        }
    }

    public void bzi() {
        if (this.fKK != null) {
            this.fKK.fTe = true;
        }
    }

    public void a(q qVar) {
        if (this.fMm != null) {
            this.fMm.i(qVar);
        }
    }

    public void c(k kVar) {
        if (this.fMm != null) {
            this.fMm.b(kVar);
        }
    }

    public void kw(boolean z) {
        if (this.fMl != 3) {
            try {
                if (this.fKK != null) {
                    this.fKK.fTf = false;
                }
                if (this.fMm != null) {
                    this.fMm.bS(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fMl = (short) 3;
        }
    }

    public void bzj() {
        if (this.fMl != 4) {
            try {
                if (this.fKK != null) {
                    this.fKK.fTf = true;
                    if (this.fMm != null) {
                        this.fMm.l(this.fKK.fTb.Fk());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fLw = null;
            this.fMl = (short) 4;
        }
    }

    public boolean bzk() {
        if (this.fMm == null || !(this.fMm instanceof b)) {
            return false;
        }
        return ((b) this.fMm).byj();
    }

    public boolean bzl() {
        if (this.fMm != null && (this.fMm instanceof b) && ((b) this.fMm).fLK) {
            return false;
        }
        if (this.fMl != 5) {
            if (this.fKK != null) {
                this.fKK.fTf = false;
            }
            try {
                if (this.fMm != null) {
                    boolean Ff = this.fMm.Ff();
                    if (Ff && (this.fMm instanceof b)) {
                        ((b) this.fMm).fLJ = true;
                    }
                    return Ff;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fMl = (short) 5;
        }
        if (this.fMm != null && (this.fMm instanceof b)) {
            ((b) this.fMm).fLJ = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.fMm != null) {
            this.fMm.bR(false);
        }
    }

    public void enterBackground() {
        if (this.fMm != null) {
            this.fMm.onPause();
        }
    }

    public void enterForeground() {
        if (this.fMm != null) {
            this.fMm.onResume();
        }
    }

    public void bzm() {
        if (this.fMm != null) {
            this.fMm.onStop();
        }
    }

    public void bzn() {
        if (this.fMm != null) {
            this.fMm.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fMm != null) {
            this.fMm.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fMm != null) {
            this.fMm.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.fMm != null) {
            this.fMm.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a bzf() {
        return this.fKK;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a bzo() {
        return this.fMm;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fMm != null) {
            return this.fMm.onKeyDown(i, keyEvent);
        }
        return false;
    }
}
