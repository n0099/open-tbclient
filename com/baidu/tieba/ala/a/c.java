package com.baidu.tieba.ala.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import java.io.File;
@TargetApi(14)
/* loaded from: classes4.dex */
public class c {
    private static File bHw() {
        File file = new File(BdBaseApplication.getInst().getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File bHx() {
        File file = new File(Environment.getExternalStorageState().equals("mounted") ? BdBaseApplication.getInst().getExternalFilesDir(null) : null, "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bHy() {
        File file = new File(bHw(), "ar-solibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bHz() {
        File file = new File(bHx(), "ar-resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static d EE(String str) {
        return d.dU("4.9_v3", str);
    }

    public static boolean eK(Context context) {
        d EE = EE("so");
        if (EE == null) {
            return false;
        }
        if (com.baidu.tieba.ala.a.a.a.f.j(context, EE.bHB())) {
            return true;
        }
        com.baidu.tieba.ala.a.a.a.f.i(context, EE.bHB());
        return com.baidu.tieba.ala.a.a.a.f.j(context, EE.bHB());
    }
}
