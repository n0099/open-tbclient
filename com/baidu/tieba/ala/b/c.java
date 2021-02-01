package com.baidu.tieba.ala.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import java.io.File;
@TargetApi(14)
/* loaded from: classes10.dex */
public class c {
    private static File bSO() {
        File file = new File(BdBaseApplication.getInst().getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File bSP() {
        File file = new File(Environment.getExternalStorageState().equals("mounted") ? BdBaseApplication.getInst().getExternalFilesDir(null) : null, "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bSQ() {
        File file = new File(bSO(), "ar-solibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bSR() {
        File file = new File(bSP(), "ar-resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static d Ga(String str) {
        return d.eo("5.1_v2", str);
    }

    public static boolean bE(Context context) {
        d Ga = Ga("so");
        if (Ga == null) {
            return false;
        }
        if (com.baidu.tieba.ala.b.a.a.f.k(context, Ga.acc())) {
            return true;
        }
        com.baidu.tieba.ala.b.a.a.f.j(context, Ga.acc());
        return com.baidu.tieba.ala.b.a.a.f.k(context, Ga.acc());
    }
}
