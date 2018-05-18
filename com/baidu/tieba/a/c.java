package com.baidu.tieba.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private int bbT;
    private boolean bbU = false;

    public c() {
        MB();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.put(intValue, gn(intValue));
            }
        }
    }

    private int gn(int i) {
        if (i == 1) {
            return go(i);
        }
        if (this.bbT == 1) {
            return gq(i);
        }
        if (this.bbT == 0) {
            return go(i);
        }
        return 0;
    }

    private int go(int i) {
        String gp = gp(i);
        return (!an.isEmpty(gp) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(gp, 0) == 1) ? 1 : 0;
    }

    private String gp(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int gq(int i) {
        String gr = gr(i);
        if (an.isEmpty(gr)) {
            return 0;
        }
        SampleResult vf = com.baidu.ubs.analytics.a.vf(gr);
        return (vf == SampleResult.T1 || vf == SampleResult.T2 || vf == SampleResult.T3 || vf == SampleResult.T4 || vf == SampleResult.T5) ? 1 : 0;
    }

    private String gr(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void MB() {
        this.bbT = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0);
        MC();
    }

    public void gs(int i) {
        if (i == 1 || i == 0) {
            this.bbT = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_abtest_channel", this.bbT);
            MC();
        }
    }

    private void MC() {
        if (!this.bbU && this.bbT == 1) {
            this.bbU = ME();
            if (!this.bbU) {
                this.bbT = 0;
            }
        }
    }

    public boolean MD() {
        return this.bbU;
    }

    public boolean ME() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().cl(TbadkCoreApplication.getInst()).nD(false).da(30L).vo(1).nE(false).db(15L).vp(1000).bEJ());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
