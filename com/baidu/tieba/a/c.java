package com.baidu.tieba.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class c {
    private boolean cUA = false;
    private int mChannel;

    public c() {
        aBm();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.put(intValue, mh(intValue));
            }
        }
    }

    private int mh(int i) {
        if (i == 1) {
            return mi(i);
        }
        if (this.mChannel == 1) {
            return mk(i);
        }
        if (this.mChannel == 0) {
            return mi(i);
        }
        return 0;
    }

    private int mi(int i) {
        String mj = mj(i);
        return (!ap.isEmpty(mj) && com.baidu.tbadk.core.sharedPref.b.agM().getInt(mj, 0) == 1) ? 1 : 0;
    }

    private String mj(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int mk(int i) {
        String ml = ml(i);
        if (ap.isEmpty(ml)) {
            return 0;
        }
        SampleResult Gj = com.baidu.ubs.analytics.a.Gj(ml);
        return (Gj == SampleResult.T1 || Gj == SampleResult.T2 || Gj == SampleResult.T3 || Gj == SampleResult.T4 || Gj == SampleResult.T5) ? 1 : 0;
    }

    private String ml(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void aBm() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_abtest_channel", 0);
        aBn();
    }

    public void mm(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_abtest_channel", this.mChannel);
            aBn();
        }
    }

    private void aBn() {
        if (!this.cUA && this.mChannel == 1) {
            this.cUA = aBp();
            if (!this.cUA) {
                this.mChannel = 0;
            }
        }
    }

    public boolean aBo() {
        return this.cUA;
    }

    public boolean aBp() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().ex(TbadkCoreApplication.getInst()).sc(false).ey(30L).CL(1).sd(false).ez(15L).CM(1000).cAl());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
