package com.baidu.tieba.advert.sdk.b;

import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.advert.sdk.c;
import com.baidu.tieba.advert.sdk.d;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class a {
    private static a gmF;
    private String gmD;
    private boolean isShow;
    private ArrayList<b> gmE = new ArrayList<>();
    private int gmC = com.baidu.tbadk.core.sharedPref.b.brR().getInt("splash_ad_strategy_key", 0);

    private a() {
    }

    public static a bMI() {
        if (gmF == null) {
            gmF = new a();
        }
        return gmF;
    }

    private synchronized void bMJ() {
        com.baidu.tieba.advert.sdk.b bVar = new com.baidu.tieba.advert.sdk.b();
        d dVar = new d();
        c cVar = new c();
        this.gmE.clear();
        this.gmE.add(bVar);
        if (this.gmC == 101) {
            this.gmE.add(cVar);
            this.gmE.add(dVar);
        } else if (this.gmC == 102) {
            this.gmE.add(dVar);
            this.gmE.add(cVar);
        } else if (this.gmC == 103 || this.gmC == 104) {
            this.gmD = com.baidu.tbadk.core.sharedPref.b.brR().getString("splash_ad_last_show_key", "");
            if (au.isEmpty(this.gmD)) {
                if (this.gmC == 103) {
                    this.gmE.add(cVar);
                    this.gmE.add(dVar);
                } else {
                    this.gmE.add(dVar);
                    this.gmE.add(cVar);
                }
            } else if (au.equals(this.gmD, cVar.bMA())) {
                this.gmE.add(dVar);
                this.gmE.add(cVar);
            } else {
                this.gmE.add(cVar);
                this.gmE.add(dVar);
            }
        } else {
            this.gmE.add(dVar);
        }
    }

    public synchronized void b(com.baidu.tbadk.g.c cVar) {
        this.isShow = false;
        bMJ();
        Iterator<b> it = this.gmE.iterator();
        while (it.hasNext()) {
            it.next().a(cVar);
        }
    }

    public void b(com.baidu.tbadk.g.a aVar) {
        a(aVar, true);
    }

    public synchronized void a(com.baidu.tbadk.g.a aVar, boolean z) {
        if (!this.isShow) {
            Iterator<b> it = this.gmE.iterator();
            while (true) {
                if (it.hasNext()) {
                    b next = it.next();
                    if (next != null) {
                        if (next.bMz() == AdLoadState.SUCCEED) {
                            this.isShow = true;
                            next.show();
                            com.baidu.tbadk.core.d.a.a("homePage", -1L, 0, "logo_splash", 0, "", "splashType", au.isEmpty(next.bMA()) ? "bes" : next.bMA());
                            Ft(next.bMA());
                        } else if (next.bMz() != AdLoadState.FAILED && z) {
                            break;
                        }
                    }
                } else if (aVar != null) {
                    aVar.zC("");
                }
            }
        }
    }

    private void Ft(String str) {
        if (!au.isEmpty(str)) {
            this.gmD = str;
            com.baidu.tbadk.core.sharedPref.b.brR().putString("splash_ad_last_show_key", str);
        }
    }

    public void Fu(String str) {
        int i = com.baidu.adp.lib.f.b.toInt(str, 0);
        if ((i == 103 || i == 104) && i != this.gmC) {
            this.gmD = "";
            com.baidu.tbadk.core.sharedPref.b.brR().remove("splash_ad_last_show_key");
        }
        com.baidu.tbadk.core.sharedPref.b.brR().putInt("splash_ad_strategy_key", i);
        if (!bMK() && TbadkCoreApplication.getInst().isNeedBearAd(i)) {
            if (l.isMainThread()) {
                com.baidu.tieba.h.a.cNx().cNw();
            } else {
                e.mA().post(new Runnable() { // from class: com.baidu.tieba.advert.sdk.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.tieba.h.a.cNx().cNw();
                    }
                });
            }
        }
        this.gmC = i;
    }

    public boolean bMK() {
        return TbadkCoreApplication.getInst().isNeedBearAd(this.gmC);
    }
}
