package com.baidu.tieba.ala.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import java.io.File;
@TargetApi(14)
/* loaded from: classes9.dex */
public class c {
    private static File bSl() {
        File file = new File(BdBaseApplication.getInst().getFilesDir(), "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File bSm() {
        File file = new File(Environment.getExternalStorageState().equals("mounted") ? BdBaseApplication.getInst().getExternalFilesDir(null) : null, "duar");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bSn() {
        File file = new File(bSl(), "ar-solibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File bSo() {
        File file = new File(bSm(), "ar-resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static d FC(String str) {
        return d.ep("5.1_v2", str);
    }

    public static boolean bB(Context context) {
        d FC = FC("so");
        if (FC == null) {
            return false;
        }
        if (com.baidu.tieba.ala.b.a.a.f.k(context, FC.aao())) {
            return true;
        }
        com.baidu.tieba.ala.b.a.a.f.j(context, FC.aao());
        return com.baidu.tieba.ala.b.a.a.f.k(context, FC.aao());
    }
}
