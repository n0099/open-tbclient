package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.VersionData;
import java.util.Date;
/* loaded from: classes.dex */
public class bc {
    public static String a() {
        String str = null;
        try {
            String versionName = TbadkApplication.m252getInst().getVersionName();
            String a = com.baidu.tbadk.core.sharedPref.b.a().a("version_name", "");
            if (!TextUtils.isEmpty(versionName)) {
                if (versionName.equals(a)) {
                    str = com.baidu.tbadk.core.sharedPref.b.a().a("apk_md5", "");
                } else {
                    com.baidu.tbadk.core.sharedPref.b.a().b("version_name", versionName);
                    String aPKMd5 = UtilHelper.getAPKMd5(TbadkApplication.m252getInst().getPackageManager().getPackageInfo(TbadkApplication.m252getInst().getPackageName(), 0));
                    com.baidu.tbadk.core.sharedPref.b.a().b("apk_md5", aPKMd5);
                    str = aPKMd5;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            BdLog.detailException(e);
        }
        return str;
    }

    public static boolean a(PackageManager packageManager) {
        for (PackageInfo packageInfo : packageManager.getInstalledPackages(8192)) {
            if (packageInfo != null) {
                String str = packageInfo.packageName;
                if (!TextUtils.isEmpty(str) && str.equals("com.baidu.appsearch")) {
                    return packageInfo.versionCode >= 16782633;
                }
            }
        }
        return false;
    }

    public static boolean a(Context context, CombineDownload combineDownload) {
        return (combineDownload == null || com.baidu.tieba.util.r.a(context, combineDownload.getAppProc()) || TextUtils.isEmpty(combineDownload.getAppUrl())) ? false : true;
    }

    public static void a(Context context, VersionData versionData) {
        String str = "-1";
        try {
            str = UtilHelper.creatSignInt(TbadkApplication.m252getInst().getPackageManager().getPackageInfo(TbadkApplication.m252getInst().getPackageName(), 64));
        } catch (PackageManager.NameNotFoundException e) {
            BdLog.detailException(e);
        } catch (NumberFormatException e2) {
            BdLog.detailException(e2);
        }
        Intent intent = new Intent("com.baidu.appsearch.extinvoker.LAUNCH");
        intent.setFlags(268435488);
        intent.putExtra("id", TbadkApplication.m252getInst().getPackageName());
        intent.putExtra("backup", "0");
        intent.putExtra("func", "11");
        Bundle bundle = new Bundle();
        bundle.putInt("versioncode", versionData.getNewVersionCode());
        bundle.putLong("patch_size", com.baidu.adp.lib.f.b.a(versionData.getPatchSize(), 0L));
        bundle.putString("patch_url", versionData.getPatch());
        bundle.putString("sname", context.getString(y.app_name));
        bundle.putString("packagename", TbadkApplication.m252getInst().getPackageName());
        bundle.putString("downurl", versionData.getUrl());
        bundle.putString("versionname", versionData.getNewVersion());
        bundle.putString("iconurl", versionData.getTiebaIconUrl());
        bundle.putString("updatetime", bm.d(new Date(System.currentTimeMillis())));
        bundle.putString("size", versionData.getSize());
        bundle.putString("signmd5", str);
        bundle.putString("tj", String.valueOf(str) + context.getString(y.app_name));
        intent.putExtra("extra_client_downloadinfo", bundle);
        context.startActivity(intent);
    }
}
