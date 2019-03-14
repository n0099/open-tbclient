package com.baidu.tieba.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class c {
    private boolean cMl = false;
    private int mChannel;

    public c() {
        awg();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.put(intValue, lt(intValue));
            }
        }
    }

    private int lt(int i) {
        if (i == 1) {
            return lu(i);
        }
        if (this.mChannel == 1) {
            return lw(i);
        }
        if (this.mChannel == 0) {
            return lu(i);
        }
        return 0;
    }

    private int lu(int i) {
        String lv = lv(i);
        return (!ap.isEmpty(lv) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(lv, 0) == 1) ? 1 : 0;
    }

    private String lv(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int lw(int i) {
        String lx = lx(i);
        if (ap.isEmpty(lx)) {
            return 0;
        }
        SampleResult EP = com.baidu.ubs.analytics.a.EP(lx);
        return (EP == SampleResult.T1 || EP == SampleResult.T2 || EP == SampleResult.T3 || EP == SampleResult.T4 || EP == SampleResult.T5) ? 1 : 0;
    }

    private String lx(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void awg() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0);
        awh();
    }

    public void ly(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_abtest_channel", this.mChannel);
            awh();
        }
    }

    private void awh() {
        if (!this.cMl && this.mChannel == 1) {
            this.cMl = awj();
            if (!this.cMl) {
                this.mChannel = 0;
            }
        }
    }

    public boolean awi() {
        return this.cMl;
    }

    public boolean awj() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().eH(TbadkCoreApplication.getInst()).rn(false).dY(30L).BL(1).ro(false).dZ(15L).BM(1000).cso());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
