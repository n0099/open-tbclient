package com.baidu.tieba.ala.liveroom.c;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.data.ab;
import com.baidu.live.data.bw;
import com.baidu.live.data.v;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.u.e;
import com.baidu.live.u.f;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class c {
    private AlaLastLiveroomInfo grr;
    private bw hrS;
    private com.baidu.tieba.ala.player.d hrV;
    private com.baidu.tieba.ala.liveroom.data.a hra;
    private boolean hsd;
    private short hta = 0;
    private com.baidu.live.liveroom.f.a htb;
    private com.baidu.live.liveroom.a.c htc;
    private String otherParams;

    public void e(short s) {
        if (this.htb != null && (this.htb instanceof b)) {
            this.htb.cF(true);
            this.htb = null;
        }
        if (this.htb == null) {
            this.htb = com.baidu.live.liveroom.f.c.Na().Nb().c(s);
            if (this.htb != null) {
                this.htb.setActivity(this.hra.pageContext.getPageActivity());
                this.htb.a(this.htc);
                this.htb.b(this.hra.hBu);
                if (this.hra.hBu.getParent() != null && (this.hra.hBu.getParent() instanceof ViewGroup)) {
                    this.htb.o((ViewGroup) this.hra.hBu.getParent());
                }
                this.htb.a(this.hra.hBs, this.hra.brO);
                this.hta = (short) 0;
                this.hra.hBy = false;
                this.htb.init();
                return;
            }
            return;
        }
        this.htb.b(this.hra.hBu);
        if (this.hra.hBu.getParent() != null && (this.hra.hBu.getParent() instanceof ViewGroup)) {
            this.htb.o((ViewGroup) this.hra.hBu.getParent());
        }
        this.htb.a(this.hra.hBs, this.hra.brO);
    }

    public void f(short s) {
        if (1 == s) {
            if (this.htb != null && !(this.htb instanceof a)) {
                this.htb.cF(true);
                this.htb = null;
            }
            if (this.htb == null) {
                a aVar = new a();
                this.hta = (short) 0;
                aVar.a(this.hra);
                aVar.a(this.htc);
                aVar.setActivity(this.hra.pageContext.getPageActivity());
                this.hra.hBy = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.htb = aVar;
            }
            this.htb.a(this.hra.hBs, this.hra.brO);
        } else if (2 == s) {
            if (this.htb != null && !(this.htb instanceof d)) {
                this.htb.cF(true);
                this.htb = null;
            }
            if (this.htb == null) {
                d dVar = new d();
                this.hta = (short) 0;
                dVar.a(this.hra);
                dVar.a(this.htc);
                dVar.setActivity(this.hra.pageContext.getPageActivity());
                this.hra.hBy = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.htb = dVar;
            }
        }
        if (this.htb instanceof b) {
            b bVar = (b) this.htb;
            bVar.caL();
            bVar.nO(this.hsd);
            bVar.a(this.hrS);
            bVar.a(this.hrV);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.ala.liveroom.n.d dVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, bw bwVar, AlaLoopViewPager alaLoopViewPager) {
        if (this.hra == null) {
            this.hra = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.hra.pageContext = tbPageContext;
        this.hra.hBu = alaLiveView;
        this.hra.hBv = alaLoopViewPager;
        this.hra.brO = fVar;
        this.hra.hBs = eVar;
        this.hra.hBt = dVar;
        this.hra.fromType = str;
        this.hra.enterTime = j;
        this.hra.hBw = z;
        this.hra.hBz = arrayList;
        this.hra.hBA = false;
        this.hrS = bwVar;
    }

    public void nO(boolean z) {
        this.hsd = z;
        if (this.htb != null && (this.htb instanceof b)) {
            ((b) this.htb).nO(z);
        }
    }

    public void a(com.baidu.tieba.ala.player.d dVar) {
        this.hrV = dVar;
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.htc = cVar;
        if (this.htb != null) {
            this.htb.a(this.htc);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.hra != null) {
            this.hra.hBs = alaLiveRoomBlurPageLayout;
        }
    }

    public void nT(boolean z) {
        if (this.hta != 1) {
            if (this.hra != null) {
                this.hra.hBy = false;
            }
            try {
                if (this.htb != null) {
                    if (this.hra != null) {
                        if (this.htb instanceof d) {
                            ((d) this.htb).b(this.grr);
                        } else if (this.htb instanceof a) {
                            ((a) this.htb).b(this.grr);
                        }
                        this.htb.m(this.hra.hBt.Fm());
                    }
                    if ((this.htb instanceof d) && z) {
                        ((d) this.htb).nV(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hta = (short) 1;
        }
    }

    public void cv(int i) {
        if (this.hra != null) {
            this.hra.hBA = true;
        }
        if (this.htb != null) {
            this.htb.cv(i);
        }
    }

    public void cbN() {
        if (this.hra != null) {
            this.hra.hBx = true;
        }
    }

    public void a(ab abVar) {
        if (this.htb != null) {
            this.htb.k(abVar);
        }
    }

    public void c(v vVar) {
        if (this.htb != null) {
            this.htb.b(vVar);
        }
    }

    public void nU(boolean z) {
        if (this.hta != 3) {
            try {
                if (this.hra != null) {
                    this.hra.hBy = false;
                }
                if (this.htb != null) {
                    this.htb.cH(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hta = (short) 3;
        }
    }

    public void cbO() {
        if (this.hta != 4) {
            try {
                if (this.hra != null) {
                    this.hra.hBy = true;
                    if (this.htb != null) {
                        this.htb.n(this.hra.hBt.Fm());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hrS = null;
            this.hta = (short) 4;
        }
    }

    public boolean cbP() {
        if (this.htb == null || !(this.htb instanceof b)) {
            return false;
        }
        return ((b) this.htb).caE();
    }

    public boolean cbQ() {
        if (this.htb != null && (this.htb instanceof b) && ((b) this.htb).hsn) {
            return false;
        }
        if (this.hta != 5) {
            if (this.hra != null) {
                this.hra.hBy = false;
            }
            try {
                if (this.htb != null) {
                    boolean MY = this.htb.MY();
                    if (MY && (this.htb instanceof b)) {
                        ((b) this.htb).hsm = true;
                    }
                    return MY;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.hta = (short) 5;
        }
        if (this.htb != null && (this.htb instanceof b)) {
            ((b) this.htb).hsm = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.htb != null) {
            this.htb.cF(false);
        }
    }

    public void enterBackground() {
        if (this.htb != null) {
            this.htb.onPause();
        }
    }

    public void enterForeground() {
        if (this.htb != null) {
            this.htb.onResume();
        }
    }

    public void cbR() {
        if (this.htb != null) {
            this.htb.onStop();
        }
    }

    public void cbS() {
        if (this.htb != null) {
            this.htb.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.htb != null) {
            this.htb.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.htb != null) {
            this.htb.e(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.htb != null) {
            this.htb.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a cbI() {
        return this.hra;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a cbT() {
        return this.htb;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.htb != null) {
            return this.htb.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.grr = alaLastLiveroomInfo;
    }
}
