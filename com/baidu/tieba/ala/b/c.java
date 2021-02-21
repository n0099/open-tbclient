package com.baidu.tieba.ala.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import java.io.File;
@TargetApi(14)
/* loaded from: classes10.dex */
public class c {
    private static File bSV() {
        File file = new File(BdBaseApplication.getInst().getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File bSW() {
        File file = new File(Environment.getExternalStorageState().equals("mounted") ? BdBaseApplication.getInst().getExternalFilesDir(null) : null, "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bSX() {
        File file = new File(bSV(), "ar-solibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bSY() {
        File file = new File(bSW(), "ar-resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static d Gb(String str) {
        return d.eo("5.1_v2", str);
    }

    public static boolean bE(Context context) {
        d Gb = Gb("so");
        if (Gb == null) {
            return false;
        }
        if (com.baidu.tieba.ala.b.a.a.f.j(context, Gb.acc())) {
            return true;
        }
        com.baidu.tieba.ala.b.a.a.f.i(context, Gb.acc());
        return com.baidu.tieba.ala.b.a.a.f.j(context, Gb.acc());
    }
}
