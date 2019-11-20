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
    private boolean dfC = false;
    private int mChannel;

    public c() {
        aCY();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.aA(intValue, lx(intValue));
            }
        }
    }

    private int lx(int i) {
        if (i == 1) {
            return ly(i);
        }
        if (this.mChannel == 1) {
            return lA(i);
        }
        if (this.mChannel == 0) {
            return ly(i);
        }
        return 0;
    }

    private int ly(int i) {
        String lz = lz(i);
        return (!aq.isEmpty(lz) && com.baidu.tbadk.core.sharedPref.b.alP().getInt(lz, 0) == 1) ? 1 : 0;
    }

    private String lz(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int lA(int i) {
        String lB = lB(i);
        if (aq.isEmpty(lB)) {
            return 0;
        }
        SampleResult FX = com.baidu.ubs.analytics.a.FX(lB);
        return (FX == SampleResult.T1 || FX == SampleResult.T2 || FX == SampleResult.T3 || FX == SampleResult.T4 || FX == SampleResult.T5) ? 1 : 0;
    }

    private String lB(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void aCY() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.alP().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0);
        aCZ();
    }

    public void lC(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.alP().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, this.mChannel);
            aCZ();
        }
    }

    private void aCZ() {
        if (!this.dfC && this.mChannel == 1) {
            this.dfC = aDb();
            if (!this.dfC) {
                this.mChannel = 0;
            }
        }
    }

    public boolean aDa() {
        return this.dfC;
    }

    public boolean aDb() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().ep(TbadkCoreApplication.getInst()).sb(false).ec(30L).BT(1).sc(false).ed(15L).BU(1000).cAZ());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
