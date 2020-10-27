package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes21.dex */
public class c {
    private boolean fKQ = false;
    private int mChannel;

    public c() {
        bGp();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.by(intValue, sZ(intValue));
            }
        }
    }

    private int sZ(int i) {
        if (i == 1) {
            return ta(i);
        }
        if (this.mChannel == 1) {
            return tc(i);
        }
        if (this.mChannel == 0) {
            return ta(i);
        }
        return 0;
    }

    private int ta(int i) {
        String tb = tb(i);
        return (!at.isEmpty(tb) && com.baidu.tbadk.core.sharedPref.b.bnH().getInt(tb, 0) == 1) ? 1 : 0;
    }

    private String tb(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int tc(int i) {
        String td = td(i);
        if (at.isEmpty(td)) {
            return 0;
        }
        SampleResult Wr = com.baidu.ubs.analytics.a.Wr(td);
        return (Wr == SampleResult.T1 || Wr == SampleResult.T2 || Wr == SampleResult.T3 || Wr == SampleResult.T4 || Wr == SampleResult.T5) ? 1 : 0;
    }

    private String td(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void bGp() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.bnH().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0);
        initSdk();
    }

    public void te(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.bnH().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, this.mChannel);
            initSdk();
        }
    }

    private void initSdk() {
        if (!this.fKQ && this.mChannel == 1) {
            this.fKQ = bGr();
            if (!this.fKQ) {
                this.mChannel = 0;
            }
        }
    }

    public boolean bGq() {
        return this.fKQ;
    }

    public boolean bGr() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().gp(TbadkCoreApplication.getInst()).zp(false).gT(30L).MQ(1).zq(false).gU(15L).MR(1000).dZQ());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
