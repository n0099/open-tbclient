package com.baidu.tieba.ala.liveroom.d;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.data.bn;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.r.e;
import com.baidu.live.r.f;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c {
    private AlaLastLiveroomInfo fVh;
    private com.baidu.tieba.ala.liveroom.data.a gQt;
    private bn gRj;
    private com.baidu.tieba.ala.player.d gRm;
    private boolean gRr;
    private short gSl = 0;
    private com.baidu.live.liveroom.f.a gSm;
    private com.baidu.live.liveroom.a.c gSn;
    private String otherParams;

    public void e(short s) {
        if (this.gSm != null && (this.gSm instanceof b)) {
            this.gSm.cg(true);
            this.gSm = null;
        }
        if (this.gSm == null) {
            this.gSm = com.baidu.live.liveroom.f.c.Ny().Nz().c(s);
            if (this.gSm != null) {
                this.gSm.setActivity(this.gQt.pageContext.getPageActivity());
                this.gSm.a(this.gSn);
                this.gSm.b(this.gQt.haC);
                if (this.gQt.haC.getParent() != null && (this.gQt.haC.getParent() instanceof ViewGroup)) {
                    this.gSm.p((ViewGroup) this.gQt.haC.getParent());
                }
                this.gSm.a(this.gQt.haA, this.gQt.bmp);
                this.gSl = (short) 0;
                this.gQt.haF = false;
                this.gSm.init();
                return;
            }
            return;
        }
        this.gSm.b(this.gQt.haC);
        if (this.gQt.haC.getParent() != null && (this.gQt.haC.getParent() instanceof ViewGroup)) {
            this.gSm.p((ViewGroup) this.gQt.haC.getParent());
        }
        this.gSm.a(this.gQt.haA, this.gQt.bmp);
    }

    public void f(short s) {
        if (1 == s) {
            if (this.gSm != null && !(this.gSm instanceof a)) {
                this.gSm.cg(true);
                this.gSm = null;
            }
            if (this.gSm == null) {
                a aVar = new a();
                this.gSl = (short) 0;
                aVar.a(this.gQt);
                aVar.a(this.gSn);
                aVar.setActivity(this.gQt.pageContext.getPageActivity());
                this.gQt.haF = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.gSm = aVar;
            }
            this.gSm.a(this.gQt.haA, this.gQt.bmp);
        } else if (2 == s) {
            if (this.gSm != null && !(this.gSm instanceof d)) {
                this.gSm.cg(true);
                this.gSm = null;
            }
            if (this.gSm == null) {
                d dVar = new d();
                this.gSl = (short) 0;
                dVar.a(this.gQt);
                dVar.a(this.gSn);
                dVar.setActivity(this.gQt.pageContext.getPageActivity());
                this.gQt.haF = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.gSm = dVar;
            }
        }
        if (this.gSm instanceof b) {
            b bVar = (b) this.gSm;
            bVar.bVp();
            bVar.mD(this.gRr);
            bVar.a(this.gRj);
            bVar.a(this.gRm);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.ala.liveroom.q.d dVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, bn bnVar) {
        if (this.gQt == null) {
            this.gQt = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.gQt.pageContext = tbPageContext;
        this.gQt.haC = alaLiveView;
        this.gQt.bmp = fVar;
        this.gQt.haA = eVar;
        this.gQt.haB = dVar;
        this.gQt.fromType = str;
        this.gQt.enterTime = j;
        this.gQt.haD = z;
        this.gQt.haG = arrayList;
        this.gQt.haH = false;
        this.gRj = bnVar;
    }

    public void mD(boolean z) {
        this.gRr = z;
        if (this.gSm != null && (this.gSm instanceof b)) {
            ((b) this.gSm).mD(z);
        }
    }

    public void a(com.baidu.tieba.ala.player.d dVar) {
        this.gRm = dVar;
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.gSn = cVar;
        if (this.gSm != null) {
            this.gSm.a(this.gSn);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.gQt != null) {
            this.gQt.haA = alaLiveRoomBlurPageLayout;
        }
    }

    public void mH(boolean z) {
        if (this.gSl != 1) {
            if (this.gQt != null) {
                this.gQt.haF = false;
            }
            try {
                if (this.gSm != null) {
                    if (this.gQt != null) {
                        if (this.gSm instanceof d) {
                            ((d) this.gSm).b(this.fVh);
                        } else if (this.gSm instanceof a) {
                            ((a) this.gSm).b(this.fVh);
                        }
                        this.gSm.m(this.gQt.haB.GH());
                    }
                    if ((this.gSm instanceof d) && z) {
                        ((d) this.gSm).mJ(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gSl = (short) 1;
        }
    }

    public void dM(int i) {
        if (this.gQt != null) {
            this.gQt.haH = true;
        }
        if (this.gSm != null) {
            this.gSm.dM(i);
        }
    }

    public void bWn() {
        if (this.gQt != null) {
            this.gQt.haE = true;
        }
    }

    public void a(w wVar) {
        if (this.gSm != null) {
            this.gSm.k(wVar);
        }
    }

    public void c(q qVar) {
        if (this.gSm != null) {
            this.gSm.b(qVar);
        }
    }

    public void mI(boolean z) {
        if (this.gSl != 3) {
            try {
                if (this.gQt != null) {
                    this.gQt.haF = false;
                }
                if (this.gSm != null) {
                    this.gSm.ci(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gSl = (short) 3;
        }
    }

    public void bWo() {
        if (this.gSl != 4) {
            try {
                if (this.gQt != null) {
                    this.gQt.haF = true;
                    if (this.gSm != null) {
                        this.gSm.n(this.gQt.haB.GH());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gRj = null;
            this.gSl = (short) 4;
        }
    }

    public boolean bWp() {
        if (this.gSm == null || !(this.gSm instanceof b)) {
            return false;
        }
        return ((b) this.gSm).bVi();
    }

    public boolean bWq() {
        if (this.gSm != null && (this.gSm instanceof b) && ((b) this.gSm).gRB) {
            return false;
        }
        if (this.gSl != 5) {
            if (this.gQt != null) {
                this.gQt.haF = false;
            }
            try {
                if (this.gSm != null) {
                    boolean Nw = this.gSm.Nw();
                    if (Nw && (this.gSm instanceof b)) {
                        ((b) this.gSm).gRA = true;
                    }
                    return Nw;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gSl = (short) 5;
        }
        if (this.gSm != null && (this.gSm instanceof b)) {
            ((b) this.gSm).gRA = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.gSm != null) {
            this.gSm.cg(false);
        }
    }

    public void enterBackground() {
        if (this.gSm != null) {
            this.gSm.onPause();
        }
    }

    public void enterForeground() {
        if (this.gSm != null) {
            this.gSm.onResume();
        }
    }

    public void bWr() {
        if (this.gSm != null) {
            this.gSm.onStop();
        }
    }

    public void bWs() {
        if (this.gSm != null) {
            this.gSm.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.gSm != null) {
            this.gSm.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gSm != null) {
            this.gSm.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.gSm != null) {
            this.gSm.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a bWj() {
        return this.gQt;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a bWt() {
        return this.gSm;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.gSm != null) {
            return this.gSm.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.fVh = alaLastLiveroomInfo;
    }
}
