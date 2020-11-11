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
    private boolean fQG = false;
    private int mChannel;

    public c() {
        bIO();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.by(intValue, tj(intValue));
            }
        }
    }

    private int tj(int i) {
        if (i == 1) {
            return tk(i);
        }
        if (this.mChannel == 1) {
            return tm(i);
        }
        if (this.mChannel == 0) {
            return tk(i);
        }
        return 0;
    }

    private int tk(int i) {
        String tl = tl(i);
        return (!at.isEmpty(tl) && com.baidu.tbadk.core.sharedPref.b.bqh().getInt(tl, 0) == 1) ? 1 : 0;
    }

    private String tl(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int tm(int i) {
        String tn = tn(i);
        if (at.isEmpty(tn)) {
            return 0;
        }
        SampleResult WU = com.baidu.ubs.analytics.a.WU(tn);
        return (WU == SampleResult.T1 || WU == SampleResult.T2 || WU == SampleResult.T3 || WU == SampleResult.T4 || WU == SampleResult.T5) ? 1 : 0;
    }

    private String tn(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void bIO() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.bqh().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0);
        initSdk();
    }

    public void to(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.bqh().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, this.mChannel);
            initSdk();
        }
    }

    private void initSdk() {
        if (!this.fQG && this.mChannel == 1) {
            this.fQG = bIQ();
            if (!this.fQG) {
                this.mChannel = 0;
            }
        }
    }

    public boolean bIP() {
        return this.fQG;
    }

    public boolean bIQ() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().gp(TbadkCoreApplication.getInst()).zA(false).hp(30L).Nj(1).zB(false).hq(15L).Nk(1000).edy());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
