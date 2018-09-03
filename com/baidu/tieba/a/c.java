package com.baidu.tieba.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class c {
    private boolean bmo = false;
    private int mChannel;

    public c() {
        QJ();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.put(intValue, gt(intValue));
            }
        }
    }

    private int gt(int i) {
        if (i == 1) {
            return gu(i);
        }
        if (this.mChannel == 1) {
            return gw(i);
        }
        if (this.mChannel == 0) {
            return gu(i);
        }
        return 0;
    }

    private int gu(int i) {
        String gv = gv(i);
        return (!ap.isEmpty(gv) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(gv, 0) == 1) ? 1 : 0;
    }

    private String gv(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int gw(int i) {
        String gx = gx(i);
        if (ap.isEmpty(gx)) {
            return 0;
        }
        SampleResult wa = com.baidu.ubs.analytics.a.wa(gx);
        return (wa == SampleResult.T1 || wa == SampleResult.T2 || wa == SampleResult.T3 || wa == SampleResult.T4 || wa == SampleResult.T5) ? 1 : 0;
    }

    private String gx(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void QJ() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0);
        QK();
    }

    public void gy(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_abtest_channel", this.mChannel);
            QK();
        }
    }

    private void QK() {
        if (!this.bmo && this.mChannel == 1) {
            this.bmo = QM();
            if (!this.bmo) {
                this.mChannel = 0;
            }
        }
    }

    public boolean QL() {
        return this.bmo;
    }

    public boolean QM() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().cu(TbadkCoreApplication.getInst()).nG(false).dc(30L).vM(1).nH(false).dd(15L).vN(1000).bIW());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
