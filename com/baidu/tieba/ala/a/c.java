package com.baidu.tieba.ala.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import java.io.File;
@TargetApi(14)
/* loaded from: classes4.dex */
public class c {
    private static File byv() {
        File file = new File(BdBaseApplication.getInst().getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File byw() {
        File file = new File(Environment.getExternalStorageState().equals("mounted") ? BdBaseApplication.getInst().getExternalFilesDir(null) : null, "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File byx() {
        File file = new File(byv(), "ar-solibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File byy() {
        File file = new File(byw(), "ar-resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static d Cj(String str) {
        return d.dE("4.6", str);
    }

    public static boolean eC(Context context) {
        d Cj = Cj("so");
        if (Cj == null) {
            return false;
        }
        if (com.baidu.tieba.ala.a.a.a.f.j(context, Cj.byz())) {
            return true;
        }
        com.baidu.tieba.ala.a.a.a.f.i(context, Cj.byz());
        return com.baidu.tieba.ala.a.a.a.f.j(context, Cj.byz());
    }
}
