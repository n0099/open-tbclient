package com.baidu.tieba.ala.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import java.io.File;
@TargetApi(14)
/* loaded from: classes4.dex */
public class c {
    private static File bNR() {
        File file = new File(BdBaseApplication.getInst().getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File bNS() {
        File file = new File(Environment.getExternalStorageState().equals("mounted") ? BdBaseApplication.getInst().getExternalFilesDir(null) : null, "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bNT() {
        File file = new File(bNR(), "ar-solibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bNU() {
        File file = new File(bNS(), "ar-resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static d Gm(String str) {
        return d.ek("4.9_v4", str);
    }

    public static boolean eY(Context context) {
        d Gm = Gm("so");
        if (Gm == null) {
            return false;
        }
        if (com.baidu.tieba.ala.b.a.a.f.k(context, Gm.bNW())) {
            return true;
        }
        com.baidu.tieba.ala.b.a.a.f.j(context, Gm.bNW());
        return com.baidu.tieba.ala.b.a.a.f.k(context, Gm.bNW());
    }
}
