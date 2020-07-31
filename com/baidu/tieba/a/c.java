package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes15.dex */
public class c {
    private boolean fbF = false;
    private int mChannel;

    public c() {
        brA();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.bp(intValue, pM(intValue));
            }
        }
    }

    private int pM(int i) {
        if (i == 1) {
            return pN(i);
        }
        if (this.mChannel == 1) {
            return pP(i);
        }
        if (this.mChannel == 0) {
            return pN(i);
        }
        return 0;
    }

    private int pN(int i) {
        String pO = pO(i);
        return (!as.isEmpty(pO) && com.baidu.tbadk.core.sharedPref.b.aZP().getInt(pO, 0) == 1) ? 1 : 0;
    }

    private String pO(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int pP(int i) {
        String pQ = pQ(i);
        if (as.isEmpty(pQ)) {
            return 0;
        }
        SampleResult QO = com.baidu.ubs.analytics.a.QO(pQ);
        return (QO == SampleResult.T1 || QO == SampleResult.T2 || QO == SampleResult.T3 || QO == SampleResult.T4 || QO == SampleResult.T5) ? 1 : 0;
    }

    private String pQ(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void brA() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0);
        initSdk();
    }

    public void pR(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.aZP().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, this.mChannel);
            initSdk();
        }
    }

    private void initSdk() {
        if (!this.fbF && this.mChannel == 1) {
            this.fbF = brC();
            if (!this.fbF) {
                this.mChannel = 0;
            }
        }
    }

    public boolean brB() {
        return this.fbF;
    }

    public boolean brC() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().fM(TbadkCoreApplication.getInst()).wR(false).fS(30L).Id(1).wS(false).fT(15L).Ie(1000).dAs());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
