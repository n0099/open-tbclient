package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes15.dex */
public class d {
    private static volatile d fbG;
    private ArrayList<Integer> fbC = new ArrayList<>();
    private c fbD;
    private a fbH;
    private List<ap> fbI;

    public static d brD() {
        if (fbG == null) {
            synchronized (c.class) {
                if (fbG == null) {
                    fbG = new d();
                }
            }
        }
        return fbG;
    }

    private d() {
        this.fbC.add(1);
        this.fbC.add(2);
        this.fbD = new c();
        this.fbH = new a(this.fbD, this.fbC);
        pR(com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int ar(String str, int i) {
        if (this.fbH == null) {
            return 0;
        }
        return this.fbH.ar(str, i);
    }

    public void AO(String str) {
        if (this.fbH != null) {
            this.fbH.AN(str);
        }
    }

    public void e(ap apVar) {
        if (apVar != null) {
            if (this.fbI == null) {
                this.fbI = new ArrayList();
            }
            this.fbI.add(apVar);
        }
    }

    public void dk(String str, String str2) {
        if (!x.isEmpty(this.fbI) && this.fbD != null && this.fbD.brB()) {
            int i = -1;
            for (ap apVar : this.fbI) {
                if (apVar != null) {
                    if (apVar.getPosition() == 0) {
                        a(str, str2, apVar);
                    } else if (i != apVar.getPosition()) {
                        i = apVar.getPosition();
                        a(str, str2, apVar);
                    }
                    i = i;
                }
            }
            this.fbI.clear();
        }
    }

    public void a(String str, String str2, ap apVar) {
        if (apVar != null && this.fbD != null && this.fbD.brB()) {
            HashMap hashMap = new HashMap();
            List<Object> params = apVar.getParams();
            if (params != null) {
                int size = params.size();
                for (int i = 0; i < size; i += 2) {
                    String str3 = "";
                    Object obj = params.get(i);
                    if (obj != null) {
                        str3 = obj.toString();
                    }
                    String str4 = "";
                    Object obj2 = params.get(i + 1);
                    if (obj2 != null) {
                        str4 = obj2.toString();
                    }
                    hashMap.put(str3, str4);
                }
            }
            com.baidu.ubs.analytics.a.a(str2 + apVar.getKey(), str, "", hashMap);
        }
    }

    public void onPageStart(String str) {
        if (as.isEmpty(str) || this.fbD == null || !this.fbD.brB()) {
            com.baidu.ubs.analytics.a.QM(str);
        }
    }

    public void onPageEnd(String str) {
        if (as.isEmpty(str) || this.fbD == null || !this.fbD.brB()) {
            com.baidu.ubs.analytics.a.QN(str);
        }
    }

    public void pR(int i) {
        if (this.fbD != null) {
            this.fbD.pR(i);
        }
    }
}
