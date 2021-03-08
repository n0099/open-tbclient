package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static volatile d ghw;
    private ArrayList<Integer> ghs = new ArrayList<>();
    private c ght;
    private a ghx;
    private List<ar> ghy;

    public static d bKY() {
        if (ghw == null) {
            synchronized (c.class) {
                if (ghw == null) {
                    ghw = new d();
                }
            }
        }
        return ghw;
    }

    private d() {
        this.ghs.add(1);
        this.ghs.add(2);
        this.ght = new c();
        this.ghx = new a(this.ght, this.ghs);
        setChannel(com.baidu.tbadk.core.sharedPref.b.brR().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int aB(String str, int i) {
        if (this.ghx == null) {
            return 0;
        }
        return this.ghx.aB(str, i);
    }

    public void EC(String str) {
        if (this.ghx != null) {
            this.ghx.EB(str);
        }
    }

    public void e(ar arVar) {
        if (arVar != null) {
            if (this.ghy == null) {
                this.ghy = new ArrayList();
            }
            this.ghy.add(arVar);
        }
    }

    public void dK(String str, String str2) {
        if (!y.isEmpty(this.ghy) && this.ght != null && this.ght.bKW()) {
            int i = -1;
            for (ar arVar : this.ghy) {
                if (arVar != null) {
                    if (arVar.getPosition() == 0) {
                        a(str, str2, arVar);
                    } else if (i != arVar.getPosition()) {
                        i = arVar.getPosition();
                        a(str, str2, arVar);
                    }
                    i = i;
                }
            }
            this.ghy.clear();
        }
    }

    public void a(String str, String str2, ar arVar) {
        if (arVar != null && this.ght != null && this.ght.bKW()) {
            HashMap hashMap = new HashMap();
            List<Object> params = arVar.getParams();
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
            com.baidu.ubs.analytics.a.a(str2 + arVar.getKey(), str, "", hashMap);
        }
    }

    public void onPageStart(String str) {
        if (au.isEmpty(str) || this.ght == null || !this.ght.bKW()) {
            com.baidu.ubs.analytics.a.XP(str);
        }
    }

    public void onPageEnd(String str) {
        if (au.isEmpty(str) || this.ght == null || !this.ght.bKW()) {
            com.baidu.ubs.analytics.a.XQ(str);
        }
    }

    public void setChannel(int i) {
        if (this.ght != null) {
            this.ght.setChannel(i);
        }
    }
}
