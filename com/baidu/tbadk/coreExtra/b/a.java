package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.util.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class a {
    private static a afQ;
    private boolean afP;

    private a() {
        this.afP = false;
        try {
            InputStream open = TbadkCoreApplication.m411getInst().getApp().getAssets().open("apk_ab_test.txt");
            if (!ar.isEmpty(new BufferedReader(new InputStreamReader(open)).readLine())) {
                this.afP = true;
            }
            o.d(open);
        } catch (Throwable th) {
            try {
                this.afP = false;
                o.d(null);
            } catch (Throwable th2) {
                o.d(null);
                throw th2;
            }
        }
    }

    public static synchronized a wb() {
        a aVar;
        synchronized (a.class) {
            if (afQ == null) {
                afQ = new a();
            }
            aVar = afQ;
        }
        return aVar;
    }

    public boolean wc() {
        return this.afP;
    }

    public String wd() {
        return this.afP ? "pub_env=3;" : "";
    }
}
