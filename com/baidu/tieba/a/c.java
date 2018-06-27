package com.baidu.tieba.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class c {
    private boolean blE = false;
    private int mChannel;

    public c() {
        Qx();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.put(intValue, gp(intValue));
            }
        }
    }

    private int gp(int i) {
        if (i == 1) {
            return gq(i);
        }
        if (this.mChannel == 1) {
            return gs(i);
        }
        if (this.mChannel == 0) {
            return gq(i);
        }
        return 0;
    }

    private int gq(int i) {
        String gr = gr(i);
        return (!ap.isEmpty(gr) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(gr, 0) == 1) ? 1 : 0;
    }

    private String gr(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int gs(int i) {
        String gt = gt(i);
        if (ap.isEmpty(gt)) {
            return 0;
        }
        SampleResult vV = com.baidu.ubs.analytics.a.vV(gt);
        return (vV == SampleResult.T1 || vV == SampleResult.T2 || vV == SampleResult.T3 || vV == SampleResult.T4 || vV == SampleResult.T5) ? 1 : 0;
    }

    private String gt(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void Qx() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0);
        Qy();
    }

    public void gu(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_abtest_channel", this.mChannel);
            Qy();
        }
    }

    private void Qy() {
        if (!this.blE && this.mChannel == 1) {
            this.blE = QA();
            if (!this.blE) {
                this.mChannel = 0;
            }
        }
    }

    public boolean Qz() {
        return this.blE;
    }

    public boolean QA() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().cu(TbadkCoreApplication.getInst()).nS(false).df(30L).vP(1).nT(false).dg(15L).vQ(1000).bKo());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
