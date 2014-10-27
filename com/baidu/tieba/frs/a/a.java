package com.baidu.tieba.frs.a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.adp.lib.util.m;
import com.baidu.adp.lib.util.p;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.util.d;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.y;
import java.io.File;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    public static void x(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            m.showToast(context, y.pb_app_error);
            return;
        }
        File br = s.br(String.valueOf(str.replace(".", "_")) + ".apk");
        if (br != null) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(br), "application/vnd.android.package-archive");
            context.startActivity(intent);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean y(Context context, String str) {
        Iterator<ActivityManager.RunningTaskInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(10).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.RunningTaskInfo next = it.next();
            if (next.topActivity.getClassName().equals(str)) {
                if (next.numActivities <= 1) {
                    return false;
                }
            }
        }
    }

    public static boolean z(Context context, String str) {
        String str2;
        String str3 = Build.MODEL;
        if (!TextUtils.isEmpty(str3) && str3.startsWith("MI")) {
            str2 = "content://com.miui.home.launcher.settings/favorites?notify=true";
        } else if (!TextUtils.isEmpty(str3) && str3.equals("MT788")) {
            str2 = "content://com.motorola.mmsp.motohomex.settings/favorites?notify=true";
        } else if (Build.VERSION.SDK_INT < 8) {
            str2 = "content://com.android.launcher.settings/favorites?notify=true";
        } else {
            str2 = "content://com.android.launcher2.settings/favorites?notify=true";
        }
        Cursor query = context.getContentResolver().query(Uri.parse(str2), null, "title=?", new String[]{String.valueOf(str) + context.getString(y.bar)}, null);
        boolean z = query != null && query.getCount() > 0;
        p.a(query);
        return z;
    }

    public static Intent A(Context context, String str) {
        Class<?> intentClass;
        if (str == null || str.length() <= 0 || (intentClass = TbadkApplication.m251getInst().getIntentClass(LogoActivityConfig.class)) == null) {
            return null;
        }
        Intent intent = new Intent(context, intentClass);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(603979776);
        intent.putExtra(ImageViewerConfig.FORUM_NAME, str);
        intent.putExtra(FrsActivityConfig.FROM_SHORT_CUT, true);
        intent.putExtra("back_special", true);
        intent.putExtra("from", "short_cut");
        return intent;
    }

    public static ImageFileInfo B(Context context, String str) {
        String str2 = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + str;
        try {
            int bl = d.bl(str2);
            if (bl != 0) {
                Bitmap a = d.a(str2, m.dip2px(context, m.n(context)), m.dip2px(context, m.o(context)));
                Bitmap e = d.e(a, bl);
                if (a != e) {
                    a.recycle();
                }
                s.a(TbConfig.LOCAL_CAMERA_DIR, str, e, 100);
                e.recycle();
            }
        } catch (Exception e2) {
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str2);
        imageFileInfo.setTempFile(true);
        return imageFileInfo;
    }
}
