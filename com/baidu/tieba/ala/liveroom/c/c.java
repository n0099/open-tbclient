package com.baidu.tieba.ala.liveroom.c;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.data.aq;
import com.baidu.live.data.h;
import com.baidu.live.data.m;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    private com.baidu.tieba.ala.liveroom.data.a eRC;
    private short eSY = 0;
    private com.baidu.live.liveroom.f.a eSZ;
    private aq eSm;
    private boolean eSr;
    private com.baidu.live.liveroom.a.b eTa;
    private String otherParams;

    public void d(short s) {
        if (this.eSZ != null && (this.eSZ instanceof b)) {
            this.eSZ.be(true);
            this.eSZ = null;
        }
        if (this.eSZ == null) {
            this.eSZ = com.baidu.live.liveroom.f.c.yJ().yK().b(s);
            if (this.eSZ != null) {
                this.eSZ.setActivity(this.eRC.pageContext.getPageActivity());
                this.eSZ.a(this.eTa);
                this.eSZ.b(this.eRC.fai);
                if (this.eRC.fai.getParent() != null && (this.eRC.fai.getParent() instanceof ViewGroup)) {
                    this.eSZ.g((ViewGroup) this.eRC.fai.getParent());
                }
                this.eSZ.a(this.eRC.fag, this.eRC.awh);
                this.eSY = (short) 0;
                this.eRC.fal = false;
                this.eSZ.init();
                return;
            }
            return;
        }
        this.eSZ.b(this.eRC.fai);
        if (this.eRC.fai.getParent() != null && (this.eRC.fai.getParent() instanceof ViewGroup)) {
            this.eSZ.g((ViewGroup) this.eRC.fai.getParent());
        }
        this.eSZ.a(this.eRC.fag, this.eRC.awh);
    }

    public void e(short s) {
        if (1 == s) {
            if (this.eSZ != null && !(this.eSZ instanceof a)) {
                this.eSZ.be(true);
                this.eSZ = null;
            }
            if (this.eSZ == null) {
                a aVar = new a();
                this.eSY = (short) 0;
                aVar.a(this.eRC);
                aVar.a(this.eTa);
                aVar.setActivity(this.eRC.pageContext.getPageActivity());
                this.eRC.fal = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.eSZ = aVar;
            }
            this.eSZ.a(this.eRC.fag, this.eRC.awh);
        } else if (2 == s) {
            if (this.eSZ != null && !(this.eSZ instanceof d)) {
                this.eSZ.be(true);
                this.eSZ = null;
            }
            if (this.eSZ == null) {
                d dVar = new d();
                this.eSY = (short) 0;
                dVar.a(this.eRC);
                dVar.a(this.eTa);
                dVar.setActivity(this.eRC.pageContext.getPageActivity());
                this.eRC.fal = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.eSZ = dVar;
            }
        }
        if (this.eSZ instanceof b) {
            b bVar = (b) this.eSZ;
            bVar.biW();
            bVar.iU(this.eSr);
            bVar.a(this.eSm);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, com.baidu.live.o.c cVar, com.baidu.live.o.b bVar, com.baidu.tieba.ala.liveroom.m.c cVar2, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, aq aqVar) {
        if (this.eRC == null) {
            this.eRC = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.eRC.pageContext = tbPageContext;
        this.eRC.fai = alaLiveView;
        this.eRC.awh = cVar;
        this.eRC.fag = bVar;
        this.eRC.fah = cVar2;
        this.eRC.fromType = str;
        this.eRC.enterTime = j;
        this.eRC.faj = z;
        this.eRC.fam = arrayList;
        this.eRC.fan = false;
        this.eSm = aqVar;
    }

    public void iU(boolean z) {
        this.eSr = z;
        if (this.eSZ != null && (this.eSZ instanceof b)) {
            ((b) this.eSZ).iU(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.b bVar) {
        this.eTa = bVar;
        if (this.eSZ != null) {
            this.eSZ.a(this.eTa);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.eRC != null) {
            this.eRC.fag = alaLiveRoomBlurPageLayout;
        }
    }

    public void iY(boolean z) {
        if (this.eSY != 1) {
            if (this.eRC != null) {
                this.eRC.fal = false;
            }
            try {
                if (this.eSZ != null) {
                    if (this.eRC != null) {
                        this.eSZ.k(this.eRC.fah.yN());
                    }
                    if ((this.eSZ instanceof d) && z) {
                        ((d) this.eSZ).ja(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eSY = (short) 1;
        }
    }

    public void bk(int i) {
        this.eRC.fan = true;
        if (this.eSZ != null) {
            this.eSZ.bk(i);
        }
    }

    public void bjJ() {
        if (this.eRC != null) {
            this.eRC.fak = true;
        }
    }

    public void a(m mVar) {
        if (this.eSZ != null) {
            this.eSZ.i(mVar);
        }
    }

    public void d(h hVar) {
        if (this.eSZ != null) {
            this.eSZ.b(hVar);
        }
    }

    public void iZ(boolean z) {
        if (this.eSY != 3) {
            try {
                if (this.eRC != null) {
                    this.eRC.fal = false;
                }
                if (this.eSZ != null) {
                    this.eSZ.bf(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eSY = (short) 3;
        }
    }

    public void bjK() {
        if (this.eSY != 4) {
            try {
                if (this.eRC != null) {
                    this.eRC.fal = true;
                    if (this.eSZ != null) {
                        this.eSZ.l(this.eRC.fah.yN());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eSm = null;
            this.eSY = (short) 4;
        }
    }

    public boolean bjL() {
        if (this.eSZ == null || !(this.eSZ instanceof b)) {
            return false;
        }
        return ((b) this.eSZ).biO();
    }

    public boolean bjM() {
        if (this.eSZ != null && (this.eSZ instanceof b) && ((b) this.eSZ).eSA) {
            return false;
        }
        if (this.eSY != 5) {
            if (this.eRC != null) {
                this.eRC.fal = false;
            }
            try {
                if (this.eSZ != null) {
                    boolean yI = this.eSZ.yI();
                    if (yI && (this.eSZ instanceof b)) {
                        ((b) this.eSZ).eSz = true;
                    }
                    return yI;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.eSY = (short) 5;
        }
        if (this.eSZ != null && (this.eSZ instanceof b)) {
            ((b) this.eSZ).eSz = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.eSZ != null) {
            this.eSZ.be(false);
        }
    }

    public void enterBackground() {
        if (this.eSZ != null) {
            this.eSZ.onPause();
        }
    }

    public void enterForeground() {
        if (this.eSZ != null) {
            this.eSZ.onResume();
        }
    }

    public void bjN() {
        if (this.eSZ != null) {
            this.eSZ.onStop();
        }
    }

    public void bjO() {
        if (this.eSZ != null) {
            this.eSZ.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.eSZ != null) {
            this.eSZ.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.eSZ != null) {
            this.eSZ.d(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void j(int i, int i2, int i3) {
        if (this.eSZ != null) {
            this.eSZ.j(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a bjG() {
        return this.eRC;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a bjP() {
        return this.eSZ;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.eSZ != null) {
            return this.eSZ.onKeyDown(i, keyEvent);
        }
        return false;
    }
}
