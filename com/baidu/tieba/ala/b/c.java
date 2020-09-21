package com.baidu.tieba.ala.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import java.io.File;
@TargetApi(14)
/* loaded from: classes4.dex */
public class c {
    private static File bIF() {
        File file = new File(BdBaseApplication.getInst().getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File bIG() {
        File file = new File(Environment.getExternalStorageState().equals("mounted") ? BdBaseApplication.getInst().getExternalFilesDir(null) : null, "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bIH() {
        File file = new File(bIF(), "ar-solibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bII() {
        File file = new File(bIG(), "ar-resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static d Fc(String str) {
        return d.dX("4.9_v4", str);
    }

    public static boolean eQ(Context context) {
        d Fc = Fc("so");
        if (Fc == null) {
            return false;
        }
        if (com.baidu.tieba.ala.b.a.a.f.j(context, Fc.bIK())) {
            return true;
        }
        com.baidu.tieba.ala.b.a.a.f.i(context, Fc.bIK());
        return com.baidu.tieba.ala.b.a.a.f.j(context, Fc.bIK());
    }
}
