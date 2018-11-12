package com.baidu.tieba.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class c {
    private boolean bwU = false;
    private int mChannel;

    public c() {
        UC();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.put(intValue, ho(intValue));
            }
        }
    }

    private int ho(int i) {
        if (i == 1) {
            return hp(i);
        }
        if (this.mChannel == 1) {
            return hr(i);
        }
        if (this.mChannel == 0) {
            return hp(i);
        }
        return 0;
    }

    private int hp(int i) {
        String hq = hq(i);
        return (!ao.isEmpty(hq) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(hq, 0) == 1) ? 1 : 0;
    }

    private String hq(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int hr(int i) {
        String hs = hs(i);
        if (ao.isEmpty(hs)) {
            return 0;
        }
        SampleResult xQ = com.baidu.ubs.analytics.a.xQ(hs);
        return (xQ == SampleResult.T1 || xQ == SampleResult.T2 || xQ == SampleResult.T3 || xQ == SampleResult.T4 || xQ == SampleResult.T5) ? 1 : 0;
    }

    private String hs(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void UC() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0);
        UD();
    }

    public void ht(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_abtest_channel", this.mChannel);
            UD();
        }
    }

    private void UD() {
        if (!this.bwU && this.mChannel == 1) {
            this.bwU = UF();
            if (!this.bwU) {
                this.mChannel = 0;
            }
        }
    }

    public boolean UE() {
        return this.bwU;
    }

    public boolean UF() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().dj(TbadkCoreApplication.getInst()).oM(false).dh(30L).xm(1).oN(false).di(15L).xn(1000).bPB());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
