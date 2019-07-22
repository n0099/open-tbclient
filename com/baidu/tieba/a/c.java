package com.baidu.tieba.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class c {
    private boolean cVX = false;
    private int mChannel;

    public c() {
        aCB();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.aB(intValue, mo(intValue));
            }
        }
    }

    private int mo(int i) {
        if (i == 1) {
            return mp(i);
        }
        if (this.mChannel == 1) {
            return mr(i);
        }
        if (this.mChannel == 0) {
            return mp(i);
        }
        return 0;
    }

    private int mp(int i) {
        String mq = mq(i);
        return (!aq.isEmpty(mq) && com.baidu.tbadk.core.sharedPref.b.ahO().getInt(mq, 0) == 1) ? 1 : 0;
    }

    private String mq(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int mr(int i) {
        String ms = ms(i);
        if (aq.isEmpty(ms)) {
            return 0;
        }
        SampleResult Hf = com.baidu.ubs.analytics.a.Hf(ms);
        return (Hf == SampleResult.T1 || Hf == SampleResult.T2 || Hf == SampleResult.T3 || Hf == SampleResult.T4 || Hf == SampleResult.T5) ? 1 : 0;
    }

    private String ms(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void aCB() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.ahO().getInt("key_abtest_channel", 0);
        aCC();
    }

    public void mt(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.ahO().putInt("key_abtest_channel", this.mChannel);
            aCC();
        }
    }

    private void aCC() {
        if (!this.cVX && this.mChannel == 1) {
            this.cVX = aCE();
            if (!this.cVX) {
                this.mChannel = 0;
            }
        }
    }

    public boolean aCD() {
        return this.cVX;
    }

    public boolean aCE() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().ey(TbadkCoreApplication.getInst()).ss(false).eG(30L).Ds(1).st(false).eH(15L).Dt(1000).cDi());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
