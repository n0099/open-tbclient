package com.baidu.tieba.ala.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import java.io.File;
@TargetApi(14)
/* loaded from: classes4.dex */
public class c {
    private static File bTx() {
        File file = new File(BdBaseApplication.getInst().getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File bTy() {
        File file = new File(Environment.getExternalStorageState().equals("mounted") ? BdBaseApplication.getInst().getExternalFilesDir(null) : null, "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bTz() {
        File file = new File(bTx(), "ar-solibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bTA() {
        File file = new File(bTy(), "ar-resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static d GP(String str) {
        return d.er("5.1_v2", str);
    }

    public static boolean fE(Context context) {
        d GP = GP("so");
        if (GP == null) {
            return false;
        }
        if (com.baidu.tieba.ala.b.a.a.f.k(context, GP.acr())) {
            return true;
        }
        com.baidu.tieba.ala.b.a.a.f.j(context, GP.acr());
        return com.baidu.tieba.ala.b.a.a.f.k(context, GP.acr());
    }
}
