package com.baidu.tieba.ala.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import java.io.File;
@TargetApi(14)
/* loaded from: classes4.dex */
public class c {
    private static File bPK() {
        File file = new File(BdBaseApplication.getInst().getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File bPL() {
        File file = new File(Environment.getExternalStorageState().equals("mounted") ? BdBaseApplication.getInst().getExternalFilesDir(null) : null, "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bPM() {
        File file = new File(bPK(), "ar-solibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bPN() {
        File file = new File(bPL(), "ar-resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static d Gb(String str) {
        return d.ek("4.9_v4", str);
    }

    public static boolean eY(Context context) {
        d Gb = Gb("so");
        if (Gb == null) {
            return false;
        }
        if (com.baidu.tieba.ala.b.a.a.f.k(context, Gb.bPP())) {
            return true;
        }
        com.baidu.tieba.ala.b.a.a.f.j(context, Gb.bPP());
        return com.baidu.tieba.ala.b.a.a.f.k(context, Gb.bPP());
    }
}
