package com.baidu.tieba.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class c {
    private boolean bAr = false;
    private int mChannel;

    public c() {
        VI();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.put(intValue, hC(intValue));
            }
        }
    }

    private int hC(int i) {
        if (i == 1) {
            return hD(i);
        }
        if (this.mChannel == 1) {
            return hF(i);
        }
        if (this.mChannel == 0) {
            return hD(i);
        }
        return 0;
    }

    private int hD(int i) {
        String hE = hE(i);
        return (!ao.isEmpty(hE) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(hE, 0) == 1) ? 1 : 0;
    }

    private String hE(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int hF(int i) {
        String hG = hG(i);
        if (ao.isEmpty(hG)) {
            return 0;
        }
        SampleResult yt = com.baidu.ubs.analytics.a.yt(hG);
        return (yt == SampleResult.T1 || yt == SampleResult.T2 || yt == SampleResult.T3 || yt == SampleResult.T4 || yt == SampleResult.T5) ? 1 : 0;
    }

    private String hG(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void VI() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0);
        VJ();
    }

    public void hH(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_abtest_channel", this.mChannel);
            VJ();
        }
    }

    private void VJ() {
        if (!this.bAr && this.mChannel == 1) {
            this.bAr = VL();
            if (!this.bAr) {
                this.mChannel = 0;
            }
        }
    }

    public boolean VK() {
        return this.bAr;
    }

    public boolean VL() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().dn(TbadkCoreApplication.getInst()).oO(false).m23do(30L).xJ(1).oP(false).dp(15L).xK(1000).bRG());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
