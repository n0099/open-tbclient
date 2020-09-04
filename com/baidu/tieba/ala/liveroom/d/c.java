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
    private AlaLastLiveroomInfo fxx;
    private bf gnS;
    private boolean gnY;
    private com.baidu.tieba.ala.liveroom.data.a gne;
    private short goN = 0;
    private com.baidu.live.liveroom.f.a goO;
    private com.baidu.live.liveroom.a.c goP;
    private String otherParams;

    public void d(short s) {
        if (this.goO != null && (this.goO instanceof b)) {
            this.goO.cb(true);
            this.goO = null;
        }
        if (this.goO == null) {
            this.goO = com.baidu.live.liveroom.f.c.Lx().Ly().b(s);
            if (this.goO != null) {
                this.goO.setActivity(this.gne.pageContext.getPageActivity());
                this.goO.a(this.goP);
                this.goO.b(this.gne.gxj);
                if (this.gne.gxj.getParent() != null && (this.gne.gxj.getParent() instanceof ViewGroup)) {
                    this.goO.o((ViewGroup) this.gne.gxj.getParent());
                }
                this.goO.a(this.gne.gxh, this.gne.ben);
                this.goN = (short) 0;
                this.gne.gxm = false;
                this.goO.init();
                return;
            }
            return;
        }
        this.goO.b(this.gne.gxj);
        if (this.gne.gxj.getParent() != null && (this.gne.gxj.getParent() instanceof ViewGroup)) {
            this.goO.o((ViewGroup) this.gne.gxj.getParent());
        }
        this.goO.a(this.gne.gxh, this.gne.ben);
    }

    public void e(short s) {
        if (1 == s) {
            if (this.goO != null && !(this.goO instanceof a)) {
                this.goO.cb(true);
                this.goO = null;
            }
            if (this.goO == null) {
                a aVar = new a();
                this.goN = (short) 0;
                aVar.a(this.gne);
                aVar.a(this.goP);
                aVar.setActivity(this.gne.pageContext.getPageActivity());
                this.gne.gxm = false;
                aVar.setOtherParams(this.otherParams);
                aVar.init();
                this.goO = aVar;
            }
            this.goO.a(this.gne.gxh, this.gne.ben);
        } else if (2 == s) {
            if (this.goO != null && !(this.goO instanceof d)) {
                this.goO.cb(true);
                this.goO = null;
            }
            if (this.goO == null) {
                d dVar = new d();
                this.goN = (short) 0;
                dVar.a(this.gne);
                dVar.a(this.goP);
                dVar.setActivity(this.gne.pageContext.getPageActivity());
                this.gne.gxm = false;
                dVar.setOtherParams(this.otherParams);
                dVar.init();
                this.goO = dVar;
            }
        }
        if (this.goO instanceof b) {
            b bVar = (b) this.goO;
            bVar.bNT();
            bVar.lJ(this.gnY);
            bVar.a(this.gnS);
        }
    }

    public void a(TbPageContext tbPageContext, AlaLiveView alaLiveView, f fVar, e eVar, com.baidu.tieba.ala.liveroom.p.d dVar, String str, boolean z, long j, ArrayList<AlaBroadcastGiftToastData> arrayList, bf bfVar) {
        if (this.gne == null) {
            this.gne = new com.baidu.tieba.ala.liveroom.data.a();
        }
        this.gne.pageContext = tbPageContext;
        this.gne.gxj = alaLiveView;
        this.gne.ben = fVar;
        this.gne.gxh = eVar;
        this.gne.gxi = dVar;
        this.gne.fromType = str;
        this.gne.enterTime = j;
        this.gne.gxk = z;
        this.gne.gxn = arrayList;
        this.gne.gxo = false;
        this.gnS = bfVar;
    }

    public void lJ(boolean z) {
        this.gnY = z;
        if (this.goO != null && (this.goO instanceof b)) {
            ((b) this.goO).lJ(z);
        }
    }

    public void a(com.baidu.live.liveroom.a.c cVar) {
        this.goP = cVar;
        if (this.goO != null) {
            this.goO.a(this.goP);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout) {
        if (this.gne != null) {
            this.gne.gxh = alaLiveRoomBlurPageLayout;
        }
    }

    public void lN(boolean z) {
        if (this.goN != 1) {
            if (this.gne != null) {
                this.gne.gxm = false;
            }
            try {
                if (this.goO != null) {
                    if (this.gne != null) {
                        if (this.goO instanceof d) {
                            ((d) this.goO).b(this.fxx);
                        } else if (this.goO instanceof a) {
                            ((a) this.goO).b(this.fxx);
                        }
                        this.goO.m(this.gne.gxi.LC());
                    }
                    if ((this.goO instanceof d) && z) {
                        ((d) this.goO).lP(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.goN = (short) 1;
        }
    }

    public void dD(int i) {
        if (this.gne != null) {
            this.gne.gxo = true;
        }
        if (this.goO != null) {
            this.goO.dD(i);
        }
    }

    public void bOK() {
        if (this.gne != null) {
            this.gne.gxl = true;
        }
    }

    public void a(r rVar) {
        if (this.goO != null) {
            this.goO.k(rVar);
        }
    }

    public void c(k kVar) {
        if (this.goO != null) {
            this.goO.b(kVar);
        }
    }

    public void lO(boolean z) {
        if (this.goN != 3) {
            try {
                if (this.gne != null) {
                    this.gne.gxm = false;
                }
                if (this.goO != null) {
                    this.goO.cd(z);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.goN = (short) 3;
        }
    }

    public void bOL() {
        if (this.goN != 4) {
            try {
                if (this.gne != null) {
                    this.gne.gxm = true;
                    if (this.goO != null) {
                        this.goO.n(this.gne.gxi.LC());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.gnS = null;
            this.goN = (short) 4;
        }
    }

    public boolean bOM() {
        if (this.goO == null || !(this.goO instanceof b)) {
            return false;
        }
        return ((b) this.goO).bNL();
    }

    public boolean bON() {
        if (this.goO != null && (this.goO instanceof b) && ((b) this.goO).goh) {
            return false;
        }
        if (this.goN != 5) {
            if (this.gne != null) {
                this.gne.gxm = false;
            }
            try {
                if (this.goO != null) {
                    boolean Lv = this.goO.Lv();
                    if (Lv && (this.goO instanceof b)) {
                        ((b) this.goO).gog = true;
                    }
                    return Lv;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.goN = (short) 5;
        }
        if (this.goO != null && (this.goO instanceof b)) {
            ((b) this.goO).gog = true;
        }
        return true;
    }

    public void onDestroy() {
        if (this.goO != null) {
            this.goO.cb(false);
        }
    }

    public void enterBackground() {
        if (this.goO != null) {
            this.goO.onPause();
        }
    }

    public void enterForeground() {
        if (this.goO != null) {
            this.goO.onResume();
        }
    }

    public void bOO() {
        if (this.goO != null) {
            this.goO.onStop();
        }
    }

    public void bOP() {
        if (this.goO != null) {
            this.goO.onStart();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.goO != null) {
            this.goO.onActivityResult(i, i2, intent);
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.goO != null) {
            this.goO.f(z, TbadkCoreApplication.getInst().getKeyboardHeight());
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.goO != null) {
            this.goO.l(i, i2, i3);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.a bOG() {
        return this.gne;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public com.baidu.live.liveroom.f.a bOQ() {
        return this.goO;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.goO != null) {
            return this.goO.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.fxx = alaLastLiveroomInfo;
    }

    public void a(au auVar) {
        if (this.goO instanceof b) {
            ((b) this.goO).a(auVar);
        }
    }
}
