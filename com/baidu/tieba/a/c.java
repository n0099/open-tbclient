package com.baidu.tieba.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class c {
    private boolean bkf = false;
    private int mChannel;

    public c() {
        Qa();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.put(intValue, go(intValue));
            }
        }
    }

    private int go(int i) {
        if (i == 1) {
            return gp(i);
        }
        if (this.mChannel == 1) {
            return gr(i);
        }
        if (this.mChannel == 0) {
            return gp(i);
        }
        return 0;
    }

    private int gp(int i) {
        String gq = gq(i);
        return (!ao.isEmpty(gq) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(gq, 0) == 1) ? 1 : 0;
    }

    private String gq(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int gr(int i) {
        String gs = gs(i);
        if (ao.isEmpty(gs)) {
            return 0;
        }
        SampleResult vZ = com.baidu.ubs.analytics.a.vZ(gs);
        return (vZ == SampleResult.T1 || vZ == SampleResult.T2 || vZ == SampleResult.T3 || vZ == SampleResult.T4 || vZ == SampleResult.T5) ? 1 : 0;
    }

    private String gs(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void Qa() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0);
        Qb();
    }

    public void gt(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_abtest_channel", this.mChannel);
            Qb();
        }
    }

    private void Qb() {
        if (!this.bkf && this.mChannel == 1) {
            this.bkf = Qd();
            if (!this.bkf) {
                this.mChannel = 0;
            }
        }
    }

    public boolean Qc() {
        return this.bkf;
    }

    public boolean Qd() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().cw(TbadkCoreApplication.getInst()).nL(false).dh(30L).vG(1).nM(false).di(15L).vH(1000).bJN());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
