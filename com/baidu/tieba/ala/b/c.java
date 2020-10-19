package com.baidu.tieba.ala.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import java.io.File;
@TargetApi(14)
/* loaded from: classes4.dex */
public class c {
    private static File bLp() {
        File file = new File(BdBaseApplication.getInst().getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File bLq() {
        File file = new File(Environment.getExternalStorageState().equals("mounted") ? BdBaseApplication.getInst().getExternalFilesDir(null) : null, "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bLr() {
        File file = new File(bLp(), "ar-solibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bLs() {
        File file = new File(bLq(), "ar-resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static d FN(String str) {
        return d.ed("4.9_v4", str);
    }

    public static boolean eX(Context context) {
        d FN = FN("so");
        if (FN == null) {
            return false;
        }
        if (com.baidu.tieba.ala.b.a.a.f.k(context, FN.bLu())) {
            return true;
        }
        com.baidu.tieba.ala.b.a.a.f.j(context, FN.bLu());
        return com.baidu.tieba.ala.b.a.a.f.k(context, FN.bLu());
    }
}
