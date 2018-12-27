package com.baidu.tieba.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class c {
    private boolean bAu = false;
    private int mChannel;

    public c() {
        VK();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.put(intValue, hD(intValue));
            }
        }
    }

    private int hD(int i) {
        if (i == 1) {
            return hE(i);
        }
        if (this.mChannel == 1) {
            return hG(i);
        }
        if (this.mChannel == 0) {
            return hE(i);
        }
        return 0;
    }

    private int hE(int i) {
        String hF = hF(i);
        return (!ao.isEmpty(hF) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(hF, 0) == 1) ? 1 : 0;
    }

    private String hF(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int hG(int i) {
        String hH = hH(i);
        if (ao.isEmpty(hH)) {
            return 0;
        }
        SampleResult yw = com.baidu.ubs.analytics.a.yw(hH);
        return (yw == SampleResult.T1 || yw == SampleResult.T2 || yw == SampleResult.T3 || yw == SampleResult.T4 || yw == SampleResult.T5) ? 1 : 0;
    }

    private String hH(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void VK() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0);
        VL();
    }

    public void hI(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_abtest_channel", this.mChannel);
            VL();
        }
    }

    private void VL() {
        if (!this.bAu && this.mChannel == 1) {
            this.bAu = VN();
            if (!this.bAu) {
                this.mChannel = 0;
            }
        }
    }

    public boolean VM() {
        return this.bAu;
    }

    public boolean VN() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().dn(TbadkCoreApplication.getInst()).oR(false).dt(30L).xW(1).oS(false).du(15L).xX(1000).bSx());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
