package com.baidu.tieba.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private int bbS;
    private boolean bbT = false;

    public c() {
        MD();
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
        if (this.bbS == 1) {
            return gq(i);
        }
        if (this.bbS == 0) {
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
        SampleResult vc = com.baidu.ubs.analytics.a.vc(gr);
        return (vc == SampleResult.T1 || vc == SampleResult.T2 || vc == SampleResult.T3 || vc == SampleResult.T4 || vc == SampleResult.T5) ? 1 : 0;
    }

    private String gr(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void MD() {
        this.bbS = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0);
        ME();
    }

    public void gs(int i) {
        if (i == 1 || i == 0) {
            this.bbS = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_abtest_channel", this.bbS);
            ME();
        }
    }

    private void ME() {
        if (!this.bbT && this.bbS == 1) {
            this.bbT = MG();
            if (!this.bbT) {
                this.bbS = 0;
            }
        }
    }

    public boolean MF() {
        return this.bbT;
    }

    public boolean MG() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().cl(TbadkCoreApplication.getInst()).nC(false).da(30L).vq(1).nD(false).db(15L).vr(1000).bEL());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
