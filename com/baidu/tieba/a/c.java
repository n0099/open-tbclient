package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class c {
    private boolean eyg = false;
    private int mChannel;

    public c() {
        bfK();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.bd(intValue, or(intValue));
            }
        }
    }

    private int or(int i) {
        if (i == 1) {
            return os(i);
        }
        if (this.mChannel == 1) {
            return ou(i);
        }
        if (this.mChannel == 0) {
            return os(i);
        }
        return 0;
    }

    private int os(int i) {
        String ot = ot(i);
        return (!aq.isEmpty(ot) && com.baidu.tbadk.core.sharedPref.b.aNT().getInt(ot, 0) == 1) ? 1 : 0;
    }

    private String ot(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int ou(int i) {
        String ov = ov(i);
        if (aq.isEmpty(ov)) {
            return 0;
        }
        SampleResult NC = com.baidu.ubs.analytics.a.NC(ov);
        return (NC == SampleResult.T1 || NC == SampleResult.T2 || NC == SampleResult.T3 || NC == SampleResult.T4 || NC == SampleResult.T5) ? 1 : 0;
    }

    private String ov(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void bfK() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.aNT().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0);
        initSdk();
    }

    public void ow(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.aNT().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, this.mChannel);
            initSdk();
        }
    }

    private void initSdk() {
        if (!this.eyg && this.mChannel == 1) {
            this.eyg = bfM();
            if (!this.eyg) {
                this.mChannel = 0;
            }
        }
    }

    public boolean bfL() {
        return this.eyg;
    }

    public boolean bfM() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().ft(TbadkCoreApplication.getInst()).vq(false).fA(30L).FM(1).vr(false).fB(15L).FN(1000).dkS());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
