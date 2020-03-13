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
    private boolean dXP = false;
    private int mChannel;

    public c() {
        aXD();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.aY(intValue, oc(intValue));
            }
        }
    }

    private int oc(int i) {
        if (i == 1) {
            return od(i);
        }
        if (this.mChannel == 1) {
            return of(i);
        }
        if (this.mChannel == 0) {
            return od(i);
        }
        return 0;
    }

    private int od(int i) {
        String oe = oe(i);
        return (!aq.isEmpty(oe) && com.baidu.tbadk.core.sharedPref.b.aFD().getInt(oe, 0) == 1) ? 1 : 0;
    }

    private String oe(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int of(int i) {
        String og = og(i);
        if (aq.isEmpty(og)) {
            return 0;
        }
        SampleResult Ll = com.baidu.ubs.analytics.a.Ll(og);
        return (Ll == SampleResult.T1 || Ll == SampleResult.T2 || Ll == SampleResult.T3 || Ll == SampleResult.T4 || Ll == SampleResult.T5) ? 1 : 0;
    }

    private String og(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void aXD() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.aFD().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0);
        initSdk();
    }

    public void oh(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.aFD().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, this.mChannel);
            initSdk();
        }
    }

    private void initSdk() {
        if (!this.dXP && this.mChannel == 1) {
            this.dXP = aXF();
            if (!this.dXP) {
                this.mChannel = 0;
            }
        }
    }

    public boolean aXE() {
        return this.dXP;
    }

    public boolean aXF() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().fL(TbadkCoreApplication.getInst()).tY(false).eJ(30L).EA(1).tZ(false).eK(15L).EB(1000).cXo());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
