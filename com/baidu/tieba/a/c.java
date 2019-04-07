package com.baidu.tieba.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class c {
    private boolean cMn = false;
    private int mChannel;

    public c() {
        awd();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.put(intValue, ls(intValue));
            }
        }
    }

    private int ls(int i) {
        if (i == 1) {
            return lt(i);
        }
        if (this.mChannel == 1) {
            return lv(i);
        }
        if (this.mChannel == 0) {
            return lt(i);
        }
        return 0;
    }

    private int lt(int i) {
        String lu = lu(i);
        return (!ap.isEmpty(lu) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(lu, 0) == 1) ? 1 : 0;
    }

    private String lu(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int lv(int i) {
        String lw = lw(i);
        if (ap.isEmpty(lw)) {
            return 0;
        }
        SampleResult EO = com.baidu.ubs.analytics.a.EO(lw);
        return (EO == SampleResult.T1 || EO == SampleResult.T2 || EO == SampleResult.T3 || EO == SampleResult.T4 || EO == SampleResult.T5) ? 1 : 0;
    }

    private String lw(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void awd() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0);
        awe();
    }

    public void lx(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_abtest_channel", this.mChannel);
            awe();
        }
    }

    private void awe() {
        if (!this.cMn && this.mChannel == 1) {
            this.cMn = awg();
            if (!this.cMn) {
                this.mChannel = 0;
            }
        }
    }

    public boolean awf() {
        return this.cMn;
    }

    public boolean awg() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().eH(TbadkCoreApplication.getInst()).rn(false).dZ(30L).BH(1).ro(false).ea(15L).BI(1000).csm());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
