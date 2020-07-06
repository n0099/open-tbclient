package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class c {
    private boolean eXe = false;
    private int mChannel;

    public c() {
        boy();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.bm(intValue, pz(intValue));
            }
        }
    }

    private int pz(int i) {
        if (i == 1) {
            return pA(i);
        }
        if (this.mChannel == 1) {
            return pC(i);
        }
        if (this.mChannel == 0) {
            return pA(i);
        }
        return 0;
    }

    private int pA(int i) {
        String pB = pB(i);
        return (!ar.isEmpty(pB) && com.baidu.tbadk.core.sharedPref.b.aVP().getInt(pB, 0) == 1) ? 1 : 0;
    }

    private String pB(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int pC(int i) {
        String pD = pD(i);
        if (ar.isEmpty(pD)) {
            return 0;
        }
        SampleResult Qd = com.baidu.ubs.analytics.a.Qd(pD);
        return (Qd == SampleResult.T1 || Qd == SampleResult.T2 || Qd == SampleResult.T3 || Qd == SampleResult.T4 || Qd == SampleResult.T5) ? 1 : 0;
    }

    private String pD(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void boy() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.aVP().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0);
        initSdk();
    }

    public void pE(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.aVP().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, this.mChannel);
            initSdk();
        }
    }

    private void initSdk() {
        if (!this.eXe && this.mChannel == 1) {
            this.eXe = boA();
            if (!this.eXe) {
                this.mChannel = 0;
            }
        }
    }

    public boolean boz() {
        return this.eXe;
    }

    public boolean boA() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().fJ(TbadkCoreApplication.getInst()).wm(false).fF(30L).HI(1).wn(false).fG(15L).HJ(1000).dxf());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
