package com.baidu.tieba.ala.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import java.io.File;
@TargetApi(14)
/* loaded from: classes3.dex */
public class c {
    private static File bmQ() {
        File file = new File(BdBaseApplication.getInst().getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File bmR() {
        File file = new File(Environment.getExternalStorageState().equals("mounted") ? BdBaseApplication.getInst().getExternalFilesDir(null) : null, "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bmS() {
        File file = new File(bmQ(), "ar-solibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bmT() {
        File file = new File(bmR(), "ar-resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static d zu(String str) {
        return d.dc("4.5-v1", str);
    }

    public static boolean eh(Context context) {
        d zu = zu("so");
        if (zu == null) {
            return false;
        }
        if (com.baidu.tieba.ala.a.a.a.f.h(context, zu.bmU())) {
            return true;
        }
        com.baidu.tieba.ala.a.a.a.f.g(context, zu.bmU());
        return com.baidu.tieba.ala.a.a.a.f.h(context, zu.bmU());
    }
}
