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
    private boolean dYf = false;
    private int mChannel;

    public c() {
        aXH();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.aZ(intValue, oe(intValue));
            }
        }
    }

    private int oe(int i) {
        if (i == 1) {
            return of(i);
        }
        if (this.mChannel == 1) {
            return oh(i);
        }
        if (this.mChannel == 0) {
            return of(i);
        }
        return 0;
    }

    private int of(int i) {
        String og = og(i);
        return (!aq.isEmpty(og) && com.baidu.tbadk.core.sharedPref.b.aFH().getInt(og, 0) == 1) ? 1 : 0;
    }

    private String og(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int oh(int i) {
        String oi = oi(i);
        if (aq.isEmpty(oi)) {
            return 0;
        }
        SampleResult Ll = com.baidu.ubs.analytics.a.Ll(oi);
        return (Ll == SampleResult.T1 || Ll == SampleResult.T2 || Ll == SampleResult.T3 || Ll == SampleResult.T4 || Ll == SampleResult.T5) ? 1 : 0;
    }

    private String oi(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void aXH() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.aFH().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0);
        initSdk();
    }

    public void oj(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.aFH().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, this.mChannel);
            initSdk();
        }
    }

    private void initSdk() {
        if (!this.dYf && this.mChannel == 1) {
            this.dYf = aXJ();
            if (!this.dYf) {
                this.mChannel = 0;
            }
        }
    }

    public boolean aXI() {
        return this.dYf;
    }

    public boolean aXJ() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().fK(TbadkCoreApplication.getInst()).uf(false).eK(30L).EH(1).ug(false).eL(15L).EI(1000).cXM());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
