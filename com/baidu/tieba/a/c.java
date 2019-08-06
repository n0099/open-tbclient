package com.baidu.tieba.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class c {
    private boolean cWe = false;
    private int mChannel;

    public c() {
        aCD();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.aB(intValue, mp(intValue));
            }
        }
    }

    private int mp(int i) {
        if (i == 1) {
            return mq(i);
        }
        if (this.mChannel == 1) {
            return ms(i);
        }
        if (this.mChannel == 0) {
            return mq(i);
        }
        return 0;
    }

    private int mq(int i) {
        String mr = mr(i);
        return (!aq.isEmpty(mr) && com.baidu.tbadk.core.sharedPref.b.ahQ().getInt(mr, 0) == 1) ? 1 : 0;
    }

    private String mr(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int ms(int i) {
        String mt = mt(i);
        if (aq.isEmpty(mt)) {
            return 0;
        }
        SampleResult Hg = com.baidu.ubs.analytics.a.Hg(mt);
        return (Hg == SampleResult.T1 || Hg == SampleResult.T2 || Hg == SampleResult.T3 || Hg == SampleResult.T4 || Hg == SampleResult.T5) ? 1 : 0;
    }

    private String mt(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void aCD() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_abtest_channel", 0);
        aCE();
    }

    public void mu(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("key_abtest_channel", this.mChannel);
            aCE();
        }
    }

    private void aCE() {
        if (!this.cWe && this.mChannel == 1) {
            this.cWe = aCG();
            if (!this.cWe) {
                this.mChannel = 0;
            }
        }
    }

    public boolean aCF() {
        return this.cWe;
    }

    public boolean aCG() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().ez(TbadkCoreApplication.getInst()).st(false).eG(30L).Du(1).su(false).eH(15L).Dv(1000).cDD());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
