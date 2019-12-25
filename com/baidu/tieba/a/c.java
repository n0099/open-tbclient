package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class c {
    private boolean dTn = false;
    private int mChannel;

    public c() {
        aUR();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.aU(intValue, nL(intValue));
            }
        }
    }

    private int nL(int i) {
        if (i == 1) {
            return nM(i);
        }
        if (this.mChannel == 1) {
            return nO(i);
        }
        if (this.mChannel == 0) {
            return nM(i);
        }
        return 0;
    }

    private int nM(int i) {
        String nN = nN(i);
        return (!aq.isEmpty(nN) && com.baidu.tbadk.core.sharedPref.b.aCY().getInt(nN, 0) == 1) ? 1 : 0;
    }

    private String nN(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int nO(int i) {
        String nP = nP(i);
        if (aq.isEmpty(nP)) {
            return 0;
        }
        SampleResult KN = com.baidu.ubs.analytics.a.KN(nP);
        return (KN == SampleResult.T1 || KN == SampleResult.T2 || KN == SampleResult.T3 || KN == SampleResult.T4 || KN == SampleResult.T5) ? 1 : 0;
    }

    private String nP(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void aUR() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.aCY().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0);
        aUS();
    }

    public void nQ(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.aCY().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, this.mChannel);
            aUS();
        }
    }

    private void aUS() {
        if (!this.dTn && this.mChannel == 1) {
            this.dTn = aUU();
            if (!this.dTn) {
                this.mChannel = 0;
            }
        }
    }

    public boolean aUT() {
        return this.dTn;
    }

    public boolean aUU() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().fL(TbadkCoreApplication.getInst()).tI(false).eG(30L).Eq(1).tJ(false).eH(15L).Er(1000).cUS());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
