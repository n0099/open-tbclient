package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class c {
    private boolean dgt = false;
    private int mChannel;

    public c() {
        aDa();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.aC(intValue, ly(intValue));
            }
        }
    }

    private int ly(int i) {
        if (i == 1) {
            return lz(i);
        }
        if (this.mChannel == 1) {
            return lB(i);
        }
        if (this.mChannel == 0) {
            return lz(i);
        }
        return 0;
    }

    private int lz(int i) {
        String lA = lA(i);
        return (!aq.isEmpty(lA) && com.baidu.tbadk.core.sharedPref.b.alR().getInt(lA, 0) == 1) ? 1 : 0;
    }

    private String lA(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int lB(int i) {
        String lC = lC(i);
        if (aq.isEmpty(lC)) {
            return 0;
        }
        SampleResult FX = com.baidu.ubs.analytics.a.FX(lC);
        return (FX == SampleResult.T1 || FX == SampleResult.T2 || FX == SampleResult.T3 || FX == SampleResult.T4 || FX == SampleResult.T5) ? 1 : 0;
    }

    private String lC(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void aDa() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.alR().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0);
        aDb();
    }

    public void lD(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.alR().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, this.mChannel);
            aDb();
        }
    }

    private void aDb() {
        if (!this.dgt && this.mChannel == 1) {
            this.dgt = aDd();
            if (!this.dgt) {
                this.mChannel = 0;
            }
        }
    }

    public boolean aDc() {
        return this.dgt;
    }

    public boolean aDd() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().ep(TbadkCoreApplication.getInst()).sb(false).ed(30L).BU(1).sc(false).ee(15L).BV(1000).cBb());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
