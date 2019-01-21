package com.baidu.tieba.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class c {
    private boolean bBi = false;
    private int mChannel;

    public c() {
        Wg();
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
        SampleResult yM = com.baidu.ubs.analytics.a.yM(hH);
        return (yM == SampleResult.T1 || yM == SampleResult.T2 || yM == SampleResult.T3 || yM == SampleResult.T4 || yM == SampleResult.T5) ? 1 : 0;
    }

    private String hH(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void Wg() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0);
        Wh();
    }

    public void hI(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_abtest_channel", this.mChannel);
            Wh();
        }
    }

    private void Wh() {
        if (!this.bBi && this.mChannel == 1) {
            this.bBi = Wj();
            if (!this.bBi) {
                this.mChannel = 0;
            }
        }
    }

    public boolean Wi() {
        return this.bBi;
    }

    public boolean Wj() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().dn(TbadkCoreApplication.getInst()).oS(false).dt(30L).xY(1).oT(false).du(15L).xZ(1000).bTf());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
