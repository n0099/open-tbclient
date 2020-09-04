package com.baidu.tieba.ala.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import java.io.File;
@TargetApi(14)
/* loaded from: classes4.dex */
public class c {
    private static File bHx() {
        File file = new File(BdBaseApplication.getInst().getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File bHy() {
        File file = new File(Environment.getExternalStorageState().equals("mounted") ? BdBaseApplication.getInst().getExternalFilesDir(null) : null, "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bHz() {
        File file = new File(bHx(), "ar-solibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bHA() {
        File file = new File(bHy(), "ar-resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static d EF(String str) {
        return d.dV("4.9_v4", str);
    }

    public static boolean eK(Context context) {
        d EF = EF("so");
        if (EF == null) {
            return false;
        }
        if (com.baidu.tieba.ala.a.a.a.f.j(context, EF.bHC())) {
            return true;
        }
        com.baidu.tieba.ala.a.a.a.f.i(context, EF.bHC());
        return com.baidu.tieba.ala.a.a.a.f.j(context, EF.bHC());
    }
}
