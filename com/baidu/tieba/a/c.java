package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class c {
    private boolean eMS = false;
    private int mChannel;

    public c() {
        blY();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.bi(intValue, pa(intValue));
            }
        }
    }

    private int pa(int i) {
        if (i == 1) {
            return pb(i);
        }
        if (this.mChannel == 1) {
            return pd(i);
        }
        if (this.mChannel == 0) {
            return pb(i);
        }
        return 0;
    }

    private int pb(int i) {
        String pc = pc(i);
        return (!aq.isEmpty(pc) && com.baidu.tbadk.core.sharedPref.b.aTX().getInt(pc, 0) == 1) ? 1 : 0;
    }

    private String pc(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int pd(int i) {
        String pe = pe(i);
        if (aq.isEmpty(pe)) {
            return 0;
        }
        SampleResult Pq = com.baidu.ubs.analytics.a.Pq(pe);
        return (Pq == SampleResult.T1 || Pq == SampleResult.T2 || Pq == SampleResult.T3 || Pq == SampleResult.T4 || Pq == SampleResult.T5) ? 1 : 0;
    }

    private String pe(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void blY() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0);
        initSdk();
    }

    public void pf(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.aTX().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, this.mChannel);
            initSdk();
        }
    }

    private void initSdk() {
        if (!this.eMS && this.mChannel == 1) {
            this.eMS = bma();
            if (!this.eMS) {
                this.mChannel = 0;
            }
        }
    }

    public boolean blZ() {
        return this.eMS;
    }

    public boolean bma() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().fI(TbadkCoreApplication.getInst()).vQ(false).fA(30L).GB(1).vR(false).fB(15L).GC(1000).dsw());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
