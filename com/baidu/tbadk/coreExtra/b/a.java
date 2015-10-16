package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.util.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class a {
    private static a afR;
    private boolean afQ;

    private a() {
        this.afQ = false;
        try {
            InputStream open = TbadkCoreApplication.m411getInst().getApp().getAssets().open("apk_ab_test.txt");
            if (!as.isEmpty(new BufferedReader(new InputStreamReader(open)).readLine())) {
                this.afQ = true;
            }
            o.d(open);
        } catch (Throwable th) {
            try {
                this.afQ = false;
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
            if (afR == null) {
                afR = new a();
            }
            aVar = afR;
        }
        return aVar;
    }

    public boolean wc() {
        return this.afQ;
    }

    public String wd() {
        return this.afQ ? "pub_env=3;" : "";
    }
}
