package com.baidu.tieba.ala.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import java.io.File;
@TargetApi(14)
/* loaded from: classes10.dex */
public class c {
    private static File bWd() {
        File file = new File(BdBaseApplication.getInst().getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File bWe() {
        File file = new File(Environment.getExternalStorageState().equals("mounted") ? BdBaseApplication.getInst().getExternalFilesDir(null) : null, "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bWf() {
        File file = new File(bWd(), "ar-solibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bWg() {
        File file = new File(bWe(), "ar-resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static d GN(String str) {
        return d.eq("5.1_v2", str);
    }

    public static boolean bC(Context context) {
        d GN = GN("so");
        if (GN == null) {
            return false;
        }
        if (com.baidu.tieba.ala.b.a.a.f.k(context, GN.aeh())) {
            return true;
        }
        com.baidu.tieba.ala.b.a.a.f.j(context, GN.aeh());
        return com.baidu.tieba.ala.b.a.a.f.k(context, GN.aeh());
    }
}
