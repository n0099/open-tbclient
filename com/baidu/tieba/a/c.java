package com.baidu.tieba.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class c {
    private boolean bwj = false;
    private int mChannel;

    public c() {
        Ut();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.put(intValue, hb(intValue));
            }
        }
    }

    private int hb(int i) {
        if (i == 1) {
            return hc(i);
        }
        if (this.mChannel == 1) {
            return he(i);
        }
        if (this.mChannel == 0) {
            return hc(i);
        }
        return 0;
    }

    private int hc(int i) {
        String hd = hd(i);
        return (!ao.isEmpty(hd) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(hd, 0) == 1) ? 1 : 0;
    }

    private String hd(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int he(int i) {
        String hf = hf(i);
        if (ao.isEmpty(hf)) {
            return 0;
        }
        SampleResult xL = com.baidu.ubs.analytics.a.xL(hf);
        return (xL == SampleResult.T1 || xL == SampleResult.T2 || xL == SampleResult.T3 || xL == SampleResult.T4 || xL == SampleResult.T5) ? 1 : 0;
    }

    private String hf(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void Ut() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0);
        Uu();
    }

    public void hg(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_abtest_channel", this.mChannel);
            Uu();
        }
    }

    private void Uu() {
        if (!this.bwj && this.mChannel == 1) {
            this.bwj = Uw();
            if (!this.bwj) {
                this.mChannel = 0;
            }
        }
    }

    public boolean Uv() {
        return this.bwj;
    }

    public boolean Uw() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().m21do(TbadkCoreApplication.getInst()).oy(false).dm(30L).wT(1).oz(false).dn(15L).wU(1000).bQd());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
