package com.baidu.tieba.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class c {
    private boolean cWX = false;
    private int mChannel;

    public c() {
        aCR();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.aB(intValue, mt(intValue));
            }
        }
    }

    private int mt(int i) {
        if (i == 1) {
            return mu(i);
        }
        if (this.mChannel == 1) {
            return mw(i);
        }
        if (this.mChannel == 0) {
            return mu(i);
        }
        return 0;
    }

    private int mu(int i) {
        String mv = mv(i);
        return (!aq.isEmpty(mv) && com.baidu.tbadk.core.sharedPref.b.ahU().getInt(mv, 0) == 1) ? 1 : 0;
    }

    private String mv(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int mw(int i) {
        String mx = mx(i);
        if (aq.isEmpty(mx)) {
            return 0;
        }
        SampleResult HG = com.baidu.ubs.analytics.a.HG(mx);
        return (HG == SampleResult.T1 || HG == SampleResult.T2 || HG == SampleResult.T3 || HG == SampleResult.T4 || HG == SampleResult.T5) ? 1 : 0;
    }

    private String mx(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void aCR() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_abtest_channel", 0);
        aCS();
    }

    public void my(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.ahU().putInt("key_abtest_channel", this.mChannel);
            aCS();
        }
    }

    private void aCS() {
        if (!this.cWX && this.mChannel == 1) {
            this.cWX = aCU();
            if (!this.cWX) {
                this.mChannel = 0;
            }
        }
    }

    public boolean aCT() {
        return this.cWX;
    }

    public boolean aCU() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().eA(TbadkCoreApplication.getInst()).sw(false).eJ(30L).Dy(1).sx(false).eK(15L).Dz(1000).cEr());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
