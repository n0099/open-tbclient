package com.baidu.tieba.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class c {
    private boolean bsc = false;
    private int mChannel;

    public c() {
        Sx();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.put(intValue, gT(intValue));
            }
        }
    }

    private int gT(int i) {
        if (i == 1) {
            return gU(i);
        }
        if (this.mChannel == 1) {
            return gW(i);
        }
        if (this.mChannel == 0) {
            return gU(i);
        }
        return 0;
    }

    private int gU(int i) {
        String gV = gV(i);
        return (!ao.isEmpty(gV) && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt(gV, 0) == 1) ? 1 : 0;
    }

    private String gV(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int gW(int i) {
        String gX = gX(i);
        if (ao.isEmpty(gX)) {
            return 0;
        }
        SampleResult wL = com.baidu.ubs.analytics.a.wL(gX);
        return (wL == SampleResult.T1 || wL == SampleResult.T2 || wL == SampleResult.T3 || wL == SampleResult.T4 || wL == SampleResult.T5) ? 1 : 0;
    }

    private String gX(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void Sx() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0);
        Sy();
    }

    public void gY(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("key_abtest_channel", this.mChannel);
            Sy();
        }
    }

    private void Sy() {
        if (!this.bsc && this.mChannel == 1) {
            this.bsc = SA();
            if (!this.bsc) {
                this.mChannel = 0;
            }
        }
    }

    public boolean Sz() {
        return this.bsc;
    }

    public boolean SA() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().db(TbadkCoreApplication.getInst()).od(false).de(30L).wm(1).oe(false).df(15L).wn(1000).bLN());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
