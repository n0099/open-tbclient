package com.baidu.tieba.ala.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import java.io.File;
@TargetApi(14)
/* loaded from: classes3.dex */
public class c {
    private static File bmS() {
        File file = new File(BdBaseApplication.getInst().getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File bmT() {
        File file = new File(Environment.getExternalStorageState().equals("mounted") ? BdBaseApplication.getInst().getExternalFilesDir(null) : null, "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bmU() {
        File file = new File(bmS(), "ar-solibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bmV() {
        File file = new File(bmT(), "ar-resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static d zr(String str) {
        return d.dc("4.5-v1", str);
    }

    public static boolean et(Context context) {
        d zr = zr("so");
        if (zr == null) {
            return false;
        }
        if (com.baidu.tieba.ala.a.a.a.f.h(context, zr.bmW())) {
            return true;
        }
        com.baidu.tieba.ala.a.a.a.f.g(context, zr.bmW());
        return com.baidu.tieba.ala.a.a.a.f.h(context, zr.bmW());
    }
}
