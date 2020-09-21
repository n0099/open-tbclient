package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes20.dex */
public class c {
    private boolean fqi = false;
    private int mChannel;

    public c() {
        bBK();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.by(intValue, sq(intValue));
            }
        }
    }

    private int sq(int i) {
        if (i == 1) {
            return sr(i);
        }
        if (this.mChannel == 1) {
            return st(i);
        }
        if (this.mChannel == 0) {
            return sr(i);
        }
        return 0;
    }

    private int sr(int i) {
        String ss = ss(i);
        return (!at.isEmpty(ss) && com.baidu.tbadk.core.sharedPref.b.bjf().getInt(ss, 0) == 1) ? 1 : 0;
    }

    private String ss(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int st(int i) {
        String su = su(i);
        if (at.isEmpty(su)) {
            return 0;
        }
        SampleResult Up = com.baidu.ubs.analytics.a.Up(su);
        return (Up == SampleResult.T1 || Up == SampleResult.T2 || Up == SampleResult.T3 || Up == SampleResult.T4 || Up == SampleResult.T5) ? 1 : 0;
    }

    private String su(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void bBK() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.bjf().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0);
        initSdk();
    }

    public void sv(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.bjf().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, this.mChannel);
            initSdk();
        }
    }

    private void initSdk() {
        if (!this.fqi && this.mChannel == 1) {
            this.fqi = bBM();
            if (!this.fqi) {
                this.mChannel = 0;
            }
        }
    }

    public boolean bBL() {
        return this.fqi;
    }

    public boolean bBM() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().gg(TbadkCoreApplication.getInst()).xS(false).gu(30L).Li(1).xT(false).gv(15L).Lj(1000).dQn());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
