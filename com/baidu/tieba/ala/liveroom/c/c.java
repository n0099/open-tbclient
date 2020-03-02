package com.baidu.tieba.ala.liveroom.c;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.data.aq;
import com.baidu.live.data.h;
import com.baidu.live.data.m;
import com.baidu.live.o.e;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    private com.baidu.tieba.ala.liveroom.data.a eRD;
    private short eSZ = 0;
    private aq eSn;
    private boolean eSs;
    private com.baidu.live.liveroom.f.a eTa;
    private com.baidu.live.liveroom.a.b eTb;
    private String otherParams;

    public void d(short s) {
        if (this.eTa != null && (this.eTa instanceof b)) {
            this.eTa.be(true);
            this.eTa = null;
        }
        if (this.eTa == null) {
            this.eTa = com.baidu.live.liveroom.f.c.yK().yL().b(s);
            if (this.eTa != null) {
                this.eTa.setActivity(this.eRD.pageContext.getPageActivity());
                this.eTa.a(this.eTb);
                this.eTa.b(this.eRD.faj);
                if (this.eRD.faj.getParent() != null && (this.eRD.faj.getParent() instanceof ViewGroup)) {
                    this.eTa.g((ViewGroup) this.eRD.faj.getParent());
                }
                this.eTa.a(this.eRD.fah, this.eRD.awi);
                this.eSZ = (short) 0;
                this.eRD.fam = false;
                this.eTa.init();
                return;
            }
            return;
        }
        this.eTa.b(this.eRD.faj);
        if (this.eRD.faj.getParent() != null && (this.eRD.faj.getParent() instanceof ViewGroup)) {
            this.eTa.g((ViewGroup) this.eRD.faj.getParent());
        }
        this.eTa.a(this.eRD.fah, this.eRD.awi);
    }

    public void e(short s) {
        if (1 == s) {
            if (this.eTa != null && !(this.eTa instanceof a)) {
                this.eTa.be(true);
                this.eTa = null;
            }
            if (this.eTa == null) {
                a aVar = new a();
                this.eSZ = (short) 0;
                aVar.a(this.eRD);
                aVar.a(this.eTb);
                aVar.setActivity(this.eRD.pageContext.getPageActivity());
                this.eRD.fam = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.eTa = aVar;
            }
            this.eTa.a(this.eRD.fah, this.eRD.awi);
        } else if (2 == s) {
            if (this.eTa != null && !(this.eTa instanceof d)) {
                this.eTa.be(true);
                this.eTa = null;
            }
            if (this.eTa == null) {
                d dVar = new d();
                this.eSZ = (short) 0;
                dVar.a(this.eRD);
                dVar.a(this.eTb);
                dVar.setActivity(this.eRD.pageContext.getPageActivity());
                this.eRD.fam = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.eTa = dVar;
            }
        }
        if (this.eTa instanceof b) {
            b bVar = (b) this.eTa;
            bVar.biY();
            bVar.iU(this.eSs);
            bVar.a(this.eSn);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, e eVar, com.baidu.live.o.d dVar, com.baidu.tieba.ala.liveroom.m.c cVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, aq aqVar) {
        if (this.eRD == null) {
            this.eRD = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.eRD.pageContext = tbPageContext;
        this.eRD.faj = alaLiveView;
        this.eRD.awi = eVar;
        this.eRD.fah = dVar;
        this.eRD.fai = cVar;
        this.eRD.fromType = str;
        this.eRD.enterTime = j;
        this.eRD.fak = z;
        this.eRD.fan = arrayList;
        this.eRD.fao = false;
        this.eSn = aqVar;
    }

    public void iU(boolean z) {
        this.eSs = z;
        if (this.eTa != null && (this.eTa instanceof b)) {
            ((b) this.eTa).iU(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.b bVar) {
        this.eTb = bVar;
        if (this.eTa != null) {
            this.eTa.a(this.eTb);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.eRD != null) {
            this.eRD.fah = alaLiveRoomBlurPageLayout;
        }
    }

    public void iY(boolean z) {
        if (this.eSZ != 1) {
            if (this.eRD != null) {
                this.eRD.fam = false;
            }
            try {
                if (this.eTa != null) {
                    if (this.eRD != null) {
                        this.eTa.k(this.eRD.fai.yO());
                    }
                    if ((this.eTa instanceof d) && z) {
                        ((d) this.eTa).ja(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eSZ = (short) 1;
        }
    }

    public void bk(int i) {
        this.eRD.fao = true;
        if (this.eTa != null) {
            this.eTa.bk(i);
        }
    }

    public void bjL() {
        if (this.eRD != null) {
            this.eRD.fal = true;
        }
    }

    public void a(m mVar) {
        if (this.eTa != null) {
            this.eTa.i(mVar);
        }
    }

    public void d(h hVar) {
        if (this.eTa != null) {
            this.eTa.b(hVar);
        }
    }

    public void iZ(boolean z) {
        if (this.eSZ != 3) {
            try {
                if (this.eRD != null) {
                    this.eRD.fam = false;
                }
                if (this.eTa != null) {
                    this.eTa.bf(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eSZ = (short) 3;
        }
    }

    public void bjM() {
        if (this.eSZ != 4) {
            try {
                if (this.eRD != null) {
                    this.eRD.fam = true;
                    if (this.eTa != null) {
                        this.eTa.l(this.eRD.fai.yO());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eSn = null;
            this.eSZ = (short) 4;
        }
    }

    public boolean bjN() {
        if (this.eTa == null || !(this.eTa instanceof b)) {
            return false;
        }
        return ((b) this.eTa).biQ();
    }

    public boolean bjO() {
        if (this.eTa != null && (this.eTa instanceof b) && ((b) this.eTa).eSB) {
            return false;
        }
        if (this.eSZ != 5) {
            if (this.eRD != null) {
                this.eRD.fam = false;
            }
            try {
                if (this.eTa != null) {
                    boolean yJ = this.eTa.yJ();
                    if (yJ && (this.eTa instanceof b)) {
                        ((b) this.eTa).eSA = true;
                    }
                    return yJ;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eSZ = (short) 5;
        }
        if (this.eTa != null && (this.eTa instanceof b)) {
            ((b) this.eTa).eSA = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.eTa != null) {
            this.eTa.be(false);
        }
    }

    public void enterBackground() {
        if (this.eTa != null) {
            this.eTa.onPause();
        }
    }

    public void enterForeground() {
        if (this.eTa != null) {
            this.eTa.onResume();
        }
    }

    public void bjP() {
        if (this.eTa != null) {
            this.eTa.onStop();
        }
    }

    public void bjQ() {
        if (this.eTa != null) {
            this.eTa.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eTa != null) {
            this.eTa.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.eTa != null) {
            this.eTa.d(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void j(int i, int i2, int i3) {
        if (this.eTa != null) {
            this.eTa.j(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a bjI() {
        return this.eRD;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a bjR() {
        return this.eTa;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.eTa != null) {
            return this.eTa.onKeyDown(i, keyEvent);
        }
        return false;
    }
}
