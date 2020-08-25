package com.baidu.tieba.ala.liveroom.d;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.data.au;
import com.baidu.live.data.bf;
import com.baidu.live.data.k;
import com.baidu.live.data.r;
import com.baidu.live.p.e;
import com.baidu.live.p.f;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class c {
    private AlaLastLiveroomInfo fxt;
    private bf gnO;
    private boolean gnU;
    private com.baidu.tieba.ala.liveroom.data.a gna;
    private short goJ = 0;
    private com.baidu.live.liveroom.f.a goK;
    private com.baidu.live.liveroom.a.c goL;
    private String otherParams;

    public void d(short s) {
        if (this.goK != null && (this.goK instanceof b)) {
            this.goK.cb(true);
            this.goK = null;
        }
        if (this.goK == null) {
            this.goK = com.baidu.live.liveroom.f.c.Lx().Ly().b(s);
            if (this.goK != null) {
                this.goK.setActivity(this.gna.pageContext.getPageActivity());
                this.goK.a(this.goL);
                this.goK.b(this.gna.gxf);
                if (this.gna.gxf.getParent() != null && (this.gna.gxf.getParent() instanceof ViewGroup)) {
                    this.goK.o((ViewGroup) this.gna.gxf.getParent());
                }
                this.goK.a(this.gna.gxd, this.gna.bel);
                this.goJ = (short) 0;
                this.gna.gxi = false;
                this.goK.init();
                return;
            }
            return;
        }
        this.goK.b(this.gna.gxf);
        if (this.gna.gxf.getParent() != null && (this.gna.gxf.getParent() instanceof ViewGroup)) {
            this.goK.o((ViewGroup) this.gna.gxf.getParent());
        }
        this.goK.a(this.gna.gxd, this.gna.bel);
    }

    public void e(short s) {
        if (1 == s) {
            if (this.goK != null && !(this.goK instanceof a)) {
                this.goK.cb(true);
                this.goK = null;
            }
            if (this.goK == null) {
                a aVar = new a();
                this.goJ = (short) 0;
                aVar.a(this.gna);
                aVar.a(this.goL);
                aVar.setActivity(this.gna.pageContext.getPageActivity());
                this.gna.gxi = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.goK = aVar;
            }
            this.goK.a(this.gna.gxd, this.gna.bel);
        } else if (2 == s) {
            if (this.goK != null && !(this.goK instanceof d)) {
                this.goK.cb(true);
                this.goK = null;
            }
            if (this.goK == null) {
                d dVar = new d();
                this.goJ = (short) 0;
                dVar.a(this.gna);
                dVar.a(this.goL);
                dVar.setActivity(this.gna.pageContext.getPageActivity());
                this.gna.gxi = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.goK = dVar;
            }
        }
        if (this.goK instanceof b) {
            b bVar = (b) this.goK;
            bVar.bNS();
            bVar.lH(this.gnU);
            bVar.a(this.gnO);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.ala.liveroom.p.d dVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, bf bfVar) {
        if (this.gna == null) {
            this.gna = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.gna.pageContext = tbPageContext;
        this.gna.gxf = alaLiveView;
        this.gna.bel = fVar;
        this.gna.gxd = eVar;
        this.gna.gxe = dVar;
        this.gna.fromType = str;
        this.gna.enterTime = j;
        this.gna.gxg = z;
        this.gna.gxj = arrayList;
        this.gna.gxk = false;
        this.gnO = bfVar;
    }

    public void lH(boolean z) {
        this.gnU = z;
        if (this.goK != null && (this.goK instanceof b)) {
            ((b) this.goK).lH(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.goL = cVar;
        if (this.goK != null) {
            this.goK.a(this.goL);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.gna != null) {
            this.gna.gxd = alaLiveRoomBlurPageLayout;
        }
    }

    public void lL(boolean z) {
        if (this.goJ != 1) {
            if (this.gna != null) {
                this.gna.gxi = false;
            }
            try {
                if (this.goK != null) {
                    if (this.gna != null) {
                        if (this.goK instanceof d) {
                            ((d) this.goK).b(this.fxt);
                        } else if (this.goK instanceof a) {
                            ((a) this.goK).b(this.fxt);
                        }
                        this.goK.m(this.gna.gxe.LC());
                    }
                    if ((this.goK instanceof d) && z) {
                        ((d) this.goK).lN(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.goJ = (short) 1;
        }
    }

    public void dD(int i) {
        if (this.gna != null) {
            this.gna.gxk = true;
        }
        if (this.goK != null) {
            this.goK.dD(i);
        }
    }

    public void bOJ() {
        if (this.gna != null) {
            this.gna.gxh = true;
        }
    }

    public void a(r rVar) {
        if (this.goK != null) {
            this.goK.k(rVar);
        }
    }

    public void c(k kVar) {
        if (this.goK != null) {
            this.goK.b(kVar);
        }
    }

    public void lM(boolean z) {
        if (this.goJ != 3) {
            try {
                if (this.gna != null) {
                    this.gna.gxi = false;
                }
                if (this.goK != null) {
                    this.goK.cd(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.goJ = (short) 3;
        }
    }

    public void bOK() {
        if (this.goJ != 4) {
            try {
                if (this.gna != null) {
                    this.gna.gxi = true;
                    if (this.goK != null) {
                        this.goK.n(this.gna.gxe.LC());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gnO = null;
            this.goJ = (short) 4;
        }
    }

    public boolean bOL() {
        if (this.goK == null || !(this.goK instanceof b)) {
            return false;
        }
        return ((b) this.goK).bNK();
    }

    public boolean bOM() {
        if (this.goK != null && (this.goK instanceof b) && ((b) this.goK).god) {
            return false;
        }
        if (this.goJ != 5) {
            if (this.gna != null) {
                this.gna.gxi = false;
            }
            try {
                if (this.goK != null) {
                    boolean Lv = this.goK.Lv();
                    if (Lv && (this.goK instanceof b)) {
                        ((b) this.goK).goc = true;
                    }
                    return Lv;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.goJ = (short) 5;
        }
        if (this.goK != null && (this.goK instanceof b)) {
            ((b) this.goK).goc = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.goK != null) {
            this.goK.cb(false);
        }
    }

    public void enterBackground() {
        if (this.goK != null) {
            this.goK.onPause();
        }
    }

    public void enterForeground() {
        if (this.goK != null) {
            this.goK.onResume();
        }
    }

    public void bON() {
        if (this.goK != null) {
            this.goK.onStop();
        }
    }

    public void bOO() {
        if (this.goK != null) {
            this.goK.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.goK != null) {
            this.goK.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.goK != null) {
            this.goK.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.goK != null) {
            this.goK.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a bOF() {
        return this.gna;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a bOP() {
        return this.goK;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.goK != null) {
            return this.goK.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.fxt = alaLastLiveroomInfo;
    }

    public void a(au auVar) {
        if (this.goK instanceof b) {
            ((b) this.goK).a(auVar);
        }
    }
}
