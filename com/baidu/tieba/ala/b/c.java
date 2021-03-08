package com.baidu.tieba.ala.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import java.io.File;
@TargetApi(14)
/* loaded from: classes9.dex */
public class c {
    private static File bTb() {
        File file = new File(BdBaseApplication.getInst().getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File bTc() {
        File file = new File(Environment.getExternalStorageState().equals("mounted") ? BdBaseApplication.getInst().getExternalFilesDir(null) : null, "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bTd() {
        File file = new File(bTb(), "ar-solibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bTe() {
        File file = new File(bTc(), "ar-resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static d Gk(String str) {
        return d.eo("5.1_v2", str);
    }

    public static boolean bD(Context context) {
        d Gk = Gk("so");
        if (Gk == null) {
            return false;
        }
        if (com.baidu.tieba.ala.b.a.a.f.j(context, Gk.acf())) {
            return true;
        }
        com.baidu.tieba.ala.b.a.a.f.i(context, Gk.acf());
        return com.baidu.tieba.ala.b.a.a.f.j(context, Gk.acf());
    }
}
