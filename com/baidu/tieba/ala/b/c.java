package com.baidu.tieba.ala.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import java.io.File;
@TargetApi(14)
/* loaded from: classes4.dex */
public class c {
    private static File bQr() {
        File file = new File(BdBaseApplication.getInst().getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File bQs() {
        File file = new File(Environment.getExternalStorageState().equals("mounted") ? BdBaseApplication.getInst().getExternalFilesDir(null) : null, "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bQt() {
        File file = new File(bQr(), "ar-solibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bQu() {
        File file = new File(bQs(), "ar-resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static d GA(String str) {
        return d.ek("4.9_v4", str);
    }

    public static boolean eY(Context context) {
        d GA = GA("so");
        if (GA == null) {
            return false;
        }
        if (com.baidu.tieba.ala.b.a.a.f.k(context, GA.bQw())) {
            return true;
        }
        com.baidu.tieba.ala.b.a.a.f.j(context, GA.bQw());
        return com.baidu.tieba.ala.b.a.a.f.k(context, GA.bQw());
    }
}
