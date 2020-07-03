package com.baidu.tieba.ala.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import java.io.File;
@TargetApi(14)
/* loaded from: classes3.dex */
public class c {
    private static File bvl() {
        File file = new File(BdBaseApplication.getInst().getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File bvm() {
        File file = new File(Environment.getExternalStorageState().equals("mounted") ? BdBaseApplication.getInst().getExternalFilesDir(null) : null, "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bvn() {
        File file = new File(bvl(), "ar-solibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bvo() {
        File file = new File(bvm(), "ar-resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static d By(String str) {
        return d.dE("4.6", str);
    }

    public static boolean ex(Context context) {
        d By = By("so");
        if (By == null) {
            return false;
        }
        if (com.baidu.tieba.ala.a.a.a.f.j(context, By.bvp())) {
            return true;
        }
        com.baidu.tieba.ala.a.a.a.f.i(context, By.bvp());
        return com.baidu.tieba.ala.a.a.a.f.j(context, By.bvp());
    }
}
