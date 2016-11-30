package com.baidu.tbadk.util;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import java.lang.reflect.Field;
import tbclient.CommonReq;
/* loaded from: classes.dex */
public class n {
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
                if (!TbadkCoreApplication.m9getInst().isOfficial()) {
                    builder.apid = TbConfig.SW_APID;
                }
                builder._phone_imei = TbadkCoreApplication.m9getInst().getImei();
                builder.from = TbadkCoreApplication.getFrom();
                builder.cuid = TbadkCoreApplication.m9getInst().getCuid();
                builder._timestamp = Long.valueOf(System.currentTimeMillis());
                builder.model = Build.MODEL;
                if (z && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                    builder.BDUSS = currentAccountInfo.getBDUSS();
                    String d = com.baidu.tbadk.core.a.h.d(currentAccountInfo);
                    if (!StringUtils.isNull(d)) {
                        builder.stoken = d;
                    }
                }
                if (z2) {
                    builder.tbs = TbadkCoreApplication.m9getInst().getTbs();
                }
                if (z3) {
                    builder.applist = TbadkCoreApplication.m9getInst().getInstalledAppIds();
                }
                builder.pversion = TiebaIMConfig.PROTOBUF_VERSION;
                builder.lego_lib_version = TbConfig.getLegoLibVersion();
                field.set(obj, builder.build(false));
            } catch (Throwable th) {
                if (BdLog.isDebugMode()) {
                    th.printStackTrace();
                }
            }
        }
    }
}
