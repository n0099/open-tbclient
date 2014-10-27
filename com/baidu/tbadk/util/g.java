package com.baidu.tbadk.util;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TiebaIMConfig;
import java.lang.reflect.Field;
import tbclient.CommonReq;
/* loaded from: classes.dex */
public class g {
    public static void a(Object obj, boolean z) {
        a(obj, z, false);
    }

    public static void a(Object obj, boolean z, boolean z2) {
        if (obj != null) {
            try {
                Field field = obj.getClass().getField("common");
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                CommonReq.Builder builder = new CommonReq.Builder();
                builder._client_type = 2;
                builder._client_version = TbConfig.getVersion();
                builder._client_id = TbadkApplication.getClientId();
                if (!TbadkApplication.m251getInst().isOfficial()) {
                    builder.apid = TbConfig.SW_APID;
                }
                builder._phone_imei = TbadkApplication.m251getInst().getImei();
                builder.from = TbadkApplication.getFrom();
                builder.cuid = TbadkApplication.m251getInst().getCuid();
                builder._timestamp = Long.valueOf(System.currentTimeMillis());
                builder.model = Build.MODEL;
                if (z) {
                    builder.BDUSS = TbadkApplication.getCurrentBduss();
                }
                if (z2) {
                    builder.tbs = TbadkApplication.m251getInst().getTbs();
                }
                builder.pversion = TiebaIMConfig.PROTOBUF_VERSION;
                field.set(obj, builder.build(false));
            } catch (Throwable th) {
                if (BdLog.isDebugMode()) {
                    th.printStackTrace();
                }
            }
        }
    }
}
