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
    private static volatile d gii;
    private ArrayList<Integer> gie = new ArrayList<>();
    private c gif;
    private a gij;
    private List<aq> gik;

    public static d bOn() {
        if (gii == null) {
            synchronized (c.class) {
                if (gii == null) {
                    gii = new d();
                }
            }
        }
        return gii;
    }

    private d() {
        this.gie.add(1);
        this.gie.add(2);
        this.gif = new c();
        this.gij = new a(this.gif, this.gie);
        setChannel(com.baidu.tbadk.core.sharedPref.b.bvr().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int az(String str, int i) {
        if (this.gij == null) {
            return 0;
        }
        return this.gij.az(str, i);
    }

    public void Fk(String str) {
        if (this.gij != null) {
            this.gij.Fj(str);
        }
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.gik == null) {
                this.gik = new ArrayList();
            }
            this.gik.add(aqVar);
        }
    }

    public void dR(String str, String str2) {
        if (!x.isEmpty(this.gik) && this.gif != null && this.gif.bOl()) {
            int i = -1;
            for (aq aqVar : this.gik) {
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
            this.gik.clear();
        }
    }

    public void a(String str, String str2, aq aqVar) {
        if (aqVar != null && this.gif != null && this.gif.bOl()) {
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
        if (at.isEmpty(str) || this.gif == null || !this.gif.bOl()) {
            com.baidu.ubs.analytics.a.XE(str);
        }
    }

    public void onPageEnd(String str) {
        if (at.isEmpty(str) || this.gif == null || !this.gif.bOl()) {
            com.baidu.ubs.analytics.a.XF(str);
        }
    }

    public void setChannel(int i) {
        if (this.gif != null) {
            this.gif.setChannel(i);
        }
    }
}
