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
    private boolean eMH = false;
    private int mChannel;

    public c() {
        blW();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.bi(intValue, oY(intValue));
            }
        }
    }

    private int oY(int i) {
        if (i == 1) {
            return oZ(i);
        }
        if (this.mChannel == 1) {
            return pb(i);
        }
        if (this.mChannel == 0) {
            return oZ(i);
        }
        return 0;
    }

    private int oZ(int i) {
        String pa = pa(i);
        return (!aq.isEmpty(pa) && com.baidu.tbadk.core.sharedPref.b.aTX().getInt(pa, 0) == 1) ? 1 : 0;
    }

    private String pa(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int pb(int i) {
        String pc = pc(i);
        if (aq.isEmpty(pc)) {
            return 0;
        }
        SampleResult Pp = com.baidu.ubs.analytics.a.Pp(pc);
        return (Pp == SampleResult.T1 || Pp == SampleResult.T2 || Pp == SampleResult.T3 || Pp == SampleResult.T4 || Pp == SampleResult.T5) ? 1 : 0;
    }

    private String pc(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void blW() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0);
        initSdk();
    }

    public void pd(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.aTX().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, this.mChannel);
            initSdk();
        }
    }

    private void initSdk() {
        if (!this.eMH && this.mChannel == 1) {
            this.eMH = blY();
            if (!this.eMH) {
                this.mChannel = 0;
            }
        }
    }

    public boolean blX() {
        return this.eMH;
    }

    public boolean blY() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().fI(TbadkCoreApplication.getInst()).vO(false).fA(30L).Gz(1).vP(false).fB(15L).GA(1000).dsi());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
