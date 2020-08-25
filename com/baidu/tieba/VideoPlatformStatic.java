package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.ala.helper.AlaLiveBaseInfo;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.k.l;
import com.baidu.tieba.k.m;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class VideoPlatformStatic {
    private static CustomMessageListener fmV = new CustomMessageListener(CmdConfigCustom.MAINTAB_ONCREATE_END) { // from class: com.baidu.tieba.VideoPlatformStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.u.e.dAx().dAt();
            com.baidu.tieba.u.b.dAs().dAt();
        }
    };

    static {
        bAu();
        MessageManager.getInstance().registerListener(fmV);
        bAv();
    }

    private static void bAu() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, new CustomMessageTask.CustomRunnable<l>() { // from class: com.baidu.tieba.VideoPlatformStatic.2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<l> run(CustomMessage<l> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, new m());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bAv() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003388, TbConfig.SERVER_ADDRESS + TbConfig.URL_MOOV_REPORT);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static int rW(int i) {
        switch (i) {
            case -400:
                return 4;
            case -200:
                return 1;
            case -100:
                return 2;
            default:
                return 3;
        }
    }

    public static String Dg(String str) {
        if (TextUtils.equals(str, "1")) {
            return "index";
        }
        if (TextUtils.equals(str, "2")) {
            return "frs";
        }
        if (TextUtils.equals(str, "6")) {
            return "pb";
        }
        if (TextUtils.equals(str, "12")) {
            return ConstantData.VideoLocationType.VIDEO_AGGREGATION;
        }
        if (TextUtils.equals(str, "3")) {
            return ConstantData.VideoLocationType.FRS_5FLOOR;
        }
        if (TextUtils.equals(str, "10")) {
            return ConstantData.VideoLocationType.FLOOR_10;
        }
        if (TextUtils.equals(str, "11")) {
            return ConstantData.VideoLocationType.FLOOR_15;
        }
        if (TextUtils.equals(str, Constants.VIA_REPORT_TYPE_JOININ_GROUP)) {
            return ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
        }
        return str;
    }

    public static JSONObject bAw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appVer", TbConfig.getVersion());
            jSONObject.put("clientIp", com.baidu.tbadk.core.util.d.getIp());
            jSONObject.put("clientTimestamp", String.valueOf(System.currentTimeMillis()));
            jSONObject.put("deviceId", UtilHelper.getDeviceId());
            jSONObject.put("network", nj());
            jSONObject.put(HttpConstants.HTTP_OS_TYPE_OLD, AlaLiveBaseInfo.mOSType);
            jSONObject.put("osVer", Build.VERSION.RELEASE);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
            } else {
                jSONObject.put("uid", "");
            }
            jSONObject.put("cuid", TbadkCoreApplication.getInst().getCuid());
            if (UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                jSONObject.put("location", new StringBuilder().toString());
            }
            jSONObject.put(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, Build.BRAND);
            jSONObject.put("model", Build.MODEL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static String nj() {
        if (j.isWifiNet()) {
            return "WIFI";
        }
        if (j.is2GNet()) {
            return "2G";
        }
        if (j.is3GNet()) {
            return "3G";
        }
        if (!j.is4GNet() && !j.isNetWorkAvailable()) {
            return "NONE";
        }
        return "4G";
    }

    public static String rX(int i) {
        switch (i) {
            case 101:
                return TbadkCoreApplication.getInst().getString(R.string.post_error_compress_success);
            case 102:
                return TbadkCoreApplication.getInst().getString(R.string.post_error_compress_not_do);
            case 103:
                return TbadkCoreApplication.getInst().getString(R.string.post_error_compress_failed);
            case 104:
                return TbadkCoreApplication.getInst().getString(R.string.post_error_compress_abort);
            case 105:
                return TbadkCoreApplication.getInst().getString(R.string.post_error_compress_too_slow);
            case 106:
                return TbadkCoreApplication.getInst().getString(R.string.post_error_compress_file_not_exists);
            case 107:
                return TbadkCoreApplication.getInst().getString(R.string.post_error_compress_filename_not_exists);
            default:
                return TbadkCoreApplication.getInst().getString(R.string.error_not_record) + i;
        }
    }
}
