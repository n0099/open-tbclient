package com.baidu.tbadk.util;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import java.lang.reflect.Field;
import tbclient.CommonReq;
/* loaded from: classes.dex */
public class n {
    public static void bindCommonParamsToProtobufData(Object obj, boolean z) {
        bindCommonParamsToProtobufData(obj, z, false);
    }

    public static void bindCommonParamsToProtobufData(Object obj, boolean z, boolean z2) {
        bindCommonParamsToProtobufData(obj, z, z2, false);
    }

    public static void bindCommonParamsToProtobufData(Object obj, boolean z, boolean z2, boolean z3) {
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
                    builder.apid = TbConfig.SW_APID;
                }
                builder._phone_imei = TbadkCoreApplication.getInst().getImei();
                builder.from = TbadkCoreApplication.getFrom();
                builder.cuid = TbadkCoreApplication.getInst().getCuid();
                builder._timestamp = Long.valueOf(System.currentTimeMillis());
                builder.model = Build.MODEL;
                if (z && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
                    builder.BDUSS = currentAccountInfo.getBDUSS();
                    String d = com.baidu.tbadk.core.a.e.d(currentAccountInfo);
                    if (!StringUtils.isNull(d)) {
                        builder.stoken = d;
                    }
                }
                if (z2) {
                    builder.tbs = TbadkCoreApplication.getInst().getTbs();
                }
                if (z3) {
                    builder.applist = TbadkCoreApplication.getInst().getInstalledAppIds();
                }
                builder.pversion = TiebaIMConfig.PROTOBUF_VERSION;
                builder.lego_lib_version = TbConfig.getLegoLibVersion();
                if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("android_safe_sdk_open", 0) == 1) {
                    builder.z_id = FH.gz(TbadkCoreApplication.getInst());
                }
                field.set(obj, builder.build(false));
            } catch (Throwable th) {
                if (BdLog.isDebugMode()) {
                    th.printStackTrace();
                }
            }
        }
    }
}
