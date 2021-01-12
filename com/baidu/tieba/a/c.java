package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private boolean gdy = false;
    private int mChannel;

    public c() {
        bKs();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.by(intValue, sR(intValue));
            }
        }
    }

    private int sR(int i) {
        if (i == 1) {
            return sS(i);
        }
        if (this.mChannel == 1) {
            return sU(i);
        }
        if (this.mChannel == 0) {
            return sS(i);
        }
        return 0;
    }

    private int sS(int i) {
        String sT = sT(i);
        return (!at.isEmpty(sT) && com.baidu.tbadk.core.sharedPref.b.brx().getInt(sT, 0) == 1) ? 1 : 0;
    }

    private String sT(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int sU(int i) {
        String sV = sV(i);
        if (at.isEmpty(sV)) {
            return 0;
        }
        SampleResult Wy = com.baidu.ubs.analytics.a.Wy(sV);
        return (Wy == SampleResult.T1 || Wy == SampleResult.T2 || Wy == SampleResult.T3 || Wy == SampleResult.T4 || Wy == SampleResult.T5) ? 1 : 0;
    }

    private String sV(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void bKs() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.brx().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0);
        initSdk();
    }

    public void setChannel(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.brx().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, this.mChannel);
            initSdk();
        }
    }

    private void initSdk() {
        if (!this.gdy && this.mChannel == 1) {
            this.gdy = bKu();
            if (!this.gdy) {
                this.mChannel = 0;
            }
        }
    }

    public boolean bKt() {
        return this.gdy;
    }

    public boolean bKu() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().hl(TbadkCoreApplication.getInst()).Ai(false).hR(30L).MS(1).Aj(false).hS(15L).MT(1000).efF());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
