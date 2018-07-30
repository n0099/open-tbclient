package com.baidu.tieba.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class c {
    private boolean bmk = false;
    private int mChannel;

    public c() {
        QE();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.put(intValue, gu(intValue));
            }
        }
    }

    private int gu(int i) {
        if (i == 1) {
            return gv(i);
        }
        if (this.mChannel == 1) {
            return gx(i);
        }
        if (this.mChannel == 0) {
            return gv(i);
        }
        return 0;
    }

    private int gv(int i) {
        String gw = gw(i);
        return (!ap.isEmpty(gw) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(gw, 0) == 1) ? 1 : 0;
    }

    private String gw(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int gx(int i) {
        String gy = gy(i);
        if (ap.isEmpty(gy)) {
            return 0;
        }
        SampleResult vW = com.baidu.ubs.analytics.a.vW(gy);
        return (vW == SampleResult.T1 || vW == SampleResult.T2 || vW == SampleResult.T3 || vW == SampleResult.T4 || vW == SampleResult.T5) ? 1 : 0;
    }

    private String gy(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void QE() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0);
        QF();
    }

    public void gz(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_abtest_channel", this.mChannel);
            QF();
        }
    }

    private void QF() {
        if (!this.bmk && this.mChannel == 1) {
            this.bmk = QH();
            if (!this.bmk) {
                this.mChannel = 0;
            }
        }
    }

    public boolean QG() {
        return this.bmk;
    }

    public boolean QH() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().cv(TbadkCoreApplication.getInst()).nG(false).dc(30L).vM(1).nH(false).dd(15L).vN(1000).bIS());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
