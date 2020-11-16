package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes20.dex */
public class c {
    private boolean fQp = false;
    private int mChannel;

    public c() {
        bIi();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.by(intValue, tH(intValue));
            }
        }
    }

    private int tH(int i) {
        if (i == 1) {
            return tI(i);
        }
        if (this.mChannel == 1) {
            return tK(i);
        }
        if (this.mChannel == 0) {
            return tI(i);
        }
        return 0;
    }

    private int tI(int i) {
        String tJ = tJ(i);
        return (!au.isEmpty(tJ) && com.baidu.tbadk.core.sharedPref.b.bpu().getInt(tJ, 0) == 1) ? 1 : 0;
    }

    private String tJ(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int tK(int i) {
        String tL = tL(i);
        if (au.isEmpty(tL)) {
            return 0;
        }
        SampleResult WF = com.baidu.ubs.analytics.a.WF(tL);
        return (WF == SampleResult.T1 || WF == SampleResult.T2 || WF == SampleResult.T3 || WF == SampleResult.T4 || WF == SampleResult.T5) ? 1 : 0;
    }

    private String tL(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void bIi() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.bpu().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0);
        initSdk();
    }

    public void tM(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.bpu().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, this.mChannel);
            initSdk();
        }
    }

    private void initSdk() {
        if (!this.fQp && this.mChannel == 1) {
            this.fQp = bIk();
            if (!this.fQp) {
                this.mChannel = 0;
            }
        }
    }

    public boolean bIj() {
        return this.fQp;
    }

    public boolean bIk() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().go(TbadkCoreApplication.getInst()).zH(false).hs(30L).NM(1).zI(false).ht(15L).NN(1000).edx());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
