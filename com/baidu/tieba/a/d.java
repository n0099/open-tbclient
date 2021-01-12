package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static volatile d gdz;
    private a gdA;
    private List<aq> gdB;
    private ArrayList<Integer> gdv = new ArrayList<>();
    private c gdw;

    public static d bKv() {
        if (gdz == null) {
            synchronized (c.class) {
                if (gdz == null) {
                    gdz = new d();
                }
            }
        }
        return gdz;
    }

    private d() {
        this.gdv.add(1);
        this.gdv.add(2);
        this.gdw = new c();
        this.gdA = new a(this.gdw, this.gdv);
        setChannel(com.baidu.tbadk.core.sharedPref.b.brx().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int az(String str, int i) {
        if (this.gdA == null) {
            return 0;
        }
        return this.gdA.az(str, i);
    }

    public void DZ(String str) {
        if (this.gdA != null) {
            this.gdA.DY(str);
        }
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.gdB == null) {
                this.gdB = new ArrayList();
            }
            this.gdB.add(aqVar);
        }
    }

    public void dQ(String str, String str2) {
        if (!x.isEmpty(this.gdB) && this.gdw != null && this.gdw.bKt()) {
            int i = -1;
            for (aq aqVar : this.gdB) {
                if (aqVar != null) {
                    if (aqVar.getPosition() == 0) {
                        a(str, str2, aqVar);
                    } else if (i != aqVar.getPosition()) {
                        i = aqVar.getPosition();
                        a(str, str2, aqVar);
                    }
                    i = i;
                }
            }
            this.gdB.clear();
        }
    }

    public void a(String str, String str2, aq aqVar) {
        if (aqVar != null && this.gdw != null && this.gdw.bKt()) {
            HashMap hashMap = new HashMap();
            List<Object> params = aqVar.getParams();
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
            com.baidu.ubs.analytics.a.a(str2 + aqVar.getKey(), str, "", hashMap);
        }
    }

    public void onPageStart(String str) {
        if (at.isEmpty(str) || this.gdw == null || !this.gdw.bKt()) {
            com.baidu.ubs.analytics.a.Ww(str);
        }
    }

    public void onPageEnd(String str) {
        if (at.isEmpty(str) || this.gdw == null || !this.gdw.bKt()) {
            com.baidu.ubs.analytics.a.Wx(str);
        }
    }

    public void setChannel(int i) {
        if (this.gdw != null) {
            this.gdw.setChannel(i);
        }
    }
}
