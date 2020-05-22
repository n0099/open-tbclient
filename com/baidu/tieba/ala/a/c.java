package com.baidu.tieba.ala.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import java.io.File;
@TargetApi(14)
/* loaded from: classes3.dex */
public class c {
    private static File bso() {
        File file = new File(BdBaseApplication.getInst().getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File bsp() {
        File file = new File(Environment.getExternalStorageState().equals("mounted") ? BdBaseApplication.getInst().getExternalFilesDir(null) : null, "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bsq() {
        File file = new File(bso(), "ar-solibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bsr() {
        File file = new File(bsp(), "ar-resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static d Ba(String str) {
        return d.dA("4.5-v1", str);
    }

    public static boolean ew(Context context) {
        d Ba = Ba("so");
        if (Ba == null) {
            return false;
        }
        if (com.baidu.tieba.ala.a.a.a.f.j(context, Ba.bss())) {
            return true;
        }
        com.baidu.tieba.ala.a.a.a.f.i(context, Ba.bss());
        return com.baidu.tieba.ala.a.a.a.f.j(context, Ba.bss());
    }
}
