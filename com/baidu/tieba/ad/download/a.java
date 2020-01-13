package com.baidu.tieba.ad.download;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import java.io.File;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static boolean k(Context context, File file) {
        return b(context, file, false);
    }

    public static boolean b(Context context, File file, boolean z) {
        Uri fromFile;
        if (file != null && file.exists() && file.isFile()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            try {
                intent.addFlags(268435456);
                if (z) {
                    intent.putExtra("android.intent.extra.RETURN_RESULT", true);
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    fromFile = FileProvider.getUriForFile(context, "com.baidu.tieba.fileprovider", file);
                    intent.addFlags(1);
                } else {
                    fromFile = Uri.fromFile(file);
                }
                intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
                context.startActivity(intent);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public static boolean au(Context context, String str) {
        ResolveInfo next;
        if (TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0 || (next = queryIntentActivities.iterator().next()) == null) {
            return false;
        }
        String str2 = next.activityInfo.name;
        Intent intent2 = new Intent("android.intent.action.MAIN");
        intent2.addCategory("android.intent.category.LAUNCHER");
        intent2.setComponent(new ComponentName(str, str2));
        intent2.setFlags(268435456);
        boolean z = true;
        try {
            context.startActivity(intent2);
        } catch (ActivityNotFoundException e) {
            z = false;
        } catch (Exception e2) {
            z = false;
        }
        return z;
    }

    public static boolean isAppInstalled(Context context, String str) {
        if (context != null) {
            try {
                if (context.getPackageManager() != null) {
                    context.getPackageManager().getPackageInfo(str, 64);
                    return true;
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public static String aJ(Context context, String str) {
        PackageInfo packageArchiveInfo;
        if (context == null || TextUtils.isEmpty(str) || (packageArchiveInfo = context.getApplicationContext().getPackageManager().getPackageArchiveInfo(str, 1)) == null) {
            return null;
        }
        return packageArchiveInfo.applicationInfo.packageName;
    }
}
