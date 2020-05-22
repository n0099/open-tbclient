package com.baidu.tbadk.util;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import java.lang.reflect.Field;
import tbclient.CommonReq;
/* loaded from: classes.dex */
public class t {
    public static void a(Object obj, boolean z) {
        a(obj, z, false);
    }

    public static void a(Object obj, boolean z, boolean z2) {
        a(obj, z, z2, false);
    }

    public static void a(Object obj, boolean z, boolean z2, boolean z3) {
        AccountData currentAccountInfo;
        if (obj != null) {
            try {
                Field field = obj.getClass().getField("common");
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                CommonReq.Builder builder = new CommonReq.Builder();
                builder._client_type = 2;
                builder._client_version = TbConfig.getVersion();
                builder._client_id = TbadkCoreApplication.getClientId();
                if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
                    builder.subapp_type = TbConfig.getSubappType();
                }
                if (!TbadkCoreApplication.getInst().isOfficial()) {
                    builder.apid = "sw";
                }
                builder._phone_imei = TbadkCoreApplication.getInst().getImei();
                builder.from = TbadkCoreApplication.getFrom();
                builder.cuid = TbadkCoreApplication.getInst().getCuid();
                builder.cuid_galaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
                builder.c3_aid = TbadkCoreApplication.getInst().getCuidGalaxy3();
                builder.cuid_gid = TbadkCoreApplication.getInst().getCuidGid();
                builder._timestamp = Long.valueOf(System.currentTimeMillis());
                builder.model = Build.MODEL;
                builder._os_version = Build.VERSION.RELEASE;
                builder.brand = Build.BRAND;
                if (z && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                    builder.BDUSS = currentAccountInfo.getBDUSS();
                    String c = com.baidu.tbadk.core.a.d.c(currentAccountInfo);
                    if (!StringUtils.isNull(c)) {
                        builder.stoken = c;
                    }
                }
                if (z2) {
                    builder.tbs = TbadkCoreApplication.getInst().getTbs();
                }
                if (z3) {
                    builder.applist = TbadkCoreApplication.getInst().getInstalledAppIds();
                }
                builder.pversion = "1.0.3";
                builder.lego_lib_version = TbConfig.getLegoLibVersion();
                if (com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.ANDROID_SAFE_SDK_OPEN, 0) == 1) {
                    builder.z_id = FH.gz(TbadkCoreApplication.getInst());
                }
                builder.net_type = Integer.valueOf(com.baidu.adp.lib.util.j.netType());
                builder.oaid = x.bgI();
                field.set(obj, builder.build(false));
            } catch (Throwable th) {
                if (BdLog.isDebugMode()) {
                    th.printStackTrace();
                }
            }
        }
    }
}
