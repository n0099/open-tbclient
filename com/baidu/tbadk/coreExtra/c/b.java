package com.baidu.tbadk.coreExtra.c;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ab;
import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class b extends Thread {
    private int a;
    private String b;
    private Hashtable<String, Integer> c;

    public b(Hashtable<String, Integer> hashtable) {
        this.a = 3;
        this.b = null;
        this.c = null;
        this.a = 3;
        this.c = hashtable;
    }

    public b(int i, String str) {
        this.a = 3;
        this.b = null;
        this.c = null;
        this.a = i;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ArrayList<String> a;
        super.run();
        try {
            if (this.a == 3) {
                if (this.c != null && (a = ab.a()) != null) {
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        this.c.put(a.get(i), 1);
                    }
                }
            } else if (this.a == 2) {
                ab.b(this.b);
            } else if (this.a == 1) {
                ab.a(this.b);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
