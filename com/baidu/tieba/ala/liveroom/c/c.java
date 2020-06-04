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
    private com.baidu.tieba.ala.liveroom.data.a fKV;
    private ay fLH;
    private boolean fLM;
    private short fMw = 0;
    private com.baidu.live.liveroom.f.a fMx;
    private com.baidu.live.liveroom.a.b fMy;
    private String otherParams;

    public void d(short s) {
        if (this.fMx != null && (this.fMx instanceof b)) {
            this.fMx.bR(true);
            this.fMx = null;
        }
        if (this.fMx == null) {
            this.fMx = com.baidu.live.liveroom.f.c.Fg().Fh().b(s);
            if (this.fMx != null) {
                this.fMx.setActivity(this.fKV.pageContext.getPageActivity());
                this.fMx.a(this.fMy);
                this.fMx.b(this.fKV.fTn);
                if (this.fKV.fTn.getParent() != null && (this.fKV.fTn.getParent() instanceof ViewGroup)) {
                    this.fMx.l((ViewGroup) this.fKV.fTn.getParent());
                }
                this.fMx.a(this.fKV.fTl, this.fKV.aWl);
                this.fMw = (short) 0;
                this.fKV.fTq = false;
                this.fMx.init();
                return;
            }
            return;
        }
        this.fMx.b(this.fKV.fTn);
        if (this.fKV.fTn.getParent() != null && (this.fKV.fTn.getParent() instanceof ViewGroup)) {
            this.fMx.l((ViewGroup) this.fKV.fTn.getParent());
        }
        this.fMx.a(this.fKV.fTl, this.fKV.aWl);
    }

    public void e(short s) {
        if (1 == s) {
            if (this.fMx != null && !(this.fMx instanceof a)) {
                this.fMx.bR(true);
                this.fMx = null;
            }
            if (this.fMx == null) {
                a aVar = new a();
                this.fMw = (short) 0;
                aVar.a(this.fKV);
                aVar.a(this.fMy);
                aVar.setActivity(this.fKV.pageContext.getPageActivity());
                this.fKV.fTq = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.fMx = aVar;
            }
            this.fMx.a(this.fKV.fTl, this.fKV.aWl);
        } else if (2 == s) {
            if (this.fMx != null && !(this.fMx instanceof d)) {
                this.fMx.bR(true);
                this.fMx = null;
            }
            if (this.fMx == null) {
                d dVar = new d();
                this.fMw = (short) 0;
                dVar.a(this.fKV);
                dVar.a(this.fMy);
                dVar.setActivity(this.fKV.pageContext.getPageActivity());
                this.fKV.fTq = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.fMx = dVar;
            }
        }
        if (this.fMx instanceof b) {
            b bVar = (b) this.fMx;
            bVar.byt();
            bVar.kr(this.fLM);
            bVar.a(this.fLH);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.ala.liveroom.m.c cVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, ay ayVar) {
        if (this.fKV == null) {
            this.fKV = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.fKV.pageContext = tbPageContext;
        this.fKV.fTn = alaLiveView;
        this.fKV.aWl = fVar;
        this.fKV.fTl = eVar;
        this.fKV.fTm = cVar;
        this.fKV.fromType = str;
        this.fKV.enterTime = j;
        this.fKV.fTo = z;
        this.fKV.fTr = arrayList;
        this.fKV.fTs = false;
        this.fLH = ayVar;
    }

    public void kr(boolean z) {
        this.fLM = z;
        if (this.fMx != null && (this.fMx instanceof b)) {
            ((b) this.fMx).kr(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.b bVar) {
        this.fMy = bVar;
        if (this.fMx != null) {
            this.fMx.a(this.fMy);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.fKV != null) {
            this.fKV.fTl = alaLiveRoomBlurPageLayout;
        }
    }

    public void kv(boolean z) {
        if (this.fMw != 1) {
            if (this.fKV != null) {
                this.fKV.fTq = false;
            }
            try {
                if (this.fMx != null) {
                    if (this.fKV != null) {
                        this.fMx.k(this.fKV.fTm.Fk());
                    }
                    if ((this.fMx instanceof d) && z) {
                        ((d) this.fMx).kx(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fMw = (short) 1;
        }
    }

    public void bG(int i) {
        this.fKV.fTs = true;
        if (this.fMx != null) {
            this.fMx.bG(i);
        }
    }

    public void bzk() {
        if (this.fKV != null) {
            this.fKV.fTp = true;
        }
    }

    public void a(q qVar) {
        if (this.fMx != null) {
            this.fMx.i(qVar);
        }
    }

    public void c(k kVar) {
        if (this.fMx != null) {
            this.fMx.b(kVar);
        }
    }

    public void kw(boolean z) {
        if (this.fMw != 3) {
            try {
                if (this.fKV != null) {
                    this.fKV.fTq = false;
                }
                if (this.fMx != null) {
                    this.fMx.bS(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fMw = (short) 3;
        }
    }

    public void bzl() {
        if (this.fMw != 4) {
            try {
                if (this.fKV != null) {
                    this.fKV.fTq = true;
                    if (this.fMx != null) {
                        this.fMx.l(this.fKV.fTm.Fk());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fLH = null;
            this.fMw = (short) 4;
        }
    }

    public boolean bzm() {
        if (this.fMx == null || !(this.fMx instanceof b)) {
            return false;
        }
        return ((b) this.fMx).byl();
    }

    public boolean bzn() {
        if (this.fMx != null && (this.fMx instanceof b) && ((b) this.fMx).fLV) {
            return false;
        }
        if (this.fMw != 5) {
            if (this.fKV != null) {
                this.fKV.fTq = false;
            }
            try {
                if (this.fMx != null) {
                    boolean Ff = this.fMx.Ff();
                    if (Ff && (this.fMx instanceof b)) {
                        ((b) this.fMx).fLU = true;
                    }
                    return Ff;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.fMw = (short) 5;
        }
        if (this.fMx != null && (this.fMx instanceof b)) {
            ((b) this.fMx).fLU = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.fMx != null) {
            this.fMx.bR(false);
        }
    }

    public void enterBackground() {
        if (this.fMx != null) {
            this.fMx.onPause();
        }
    }

    public void enterForeground() {
        if (this.fMx != null) {
            this.fMx.onResume();
        }
    }

    public void bzo() {
        if (this.fMx != null) {
            this.fMx.onStop();
        }
    }

    public void bzp() {
        if (this.fMx != null) {
            this.fMx.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.fMx != null) {
            this.fMx.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fMx != null) {
            this.fMx.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.fMx != null) {
            this.fMx.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a bzh() {
        return this.fKV;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a bzq() {
        return this.fMx;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fMx != null) {
            return this.fMx.onKeyDown(i, keyEvent);
        }
        return false;
    }
}
