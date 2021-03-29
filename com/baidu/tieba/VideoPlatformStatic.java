package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.apollon.statistics.g;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.CommonHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.tencent.connect.common.Constants;
import d.b.b.e.p.j;
import d.b.i0.l3.e;
import d.b.i0.s1.k;
import d.b.i0.s1.l;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class VideoPlatformStatic {

    /* renamed from: a  reason: collision with root package name */
    public static CustomMessageListener f14456a = new a(2007015);

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.h().o();
            d.b.i0.l3.b.d().k();
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements CustomMessageTask.CustomRunnable<k> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<k> run(CustomMessage<k> customMessage) {
            return new CustomResponsedMessage<>(2921309, new l());
        }
    }

    static {
        f();
        MessageManager.getInstance().registerListener(f14456a);
        e();
    }

    public static String a(String str) {
        return TextUtils.equals(str, "1") ? "index" : TextUtils.equals(str, "2") ? "frs" : TextUtils.equals(str, "6") ? "pb" : TextUtils.equals(str, Constants.VIA_REPORT_TYPE_SET_AVATAR) ? "frs_bavideotab" : TextUtils.equals(str, "3") ? "floor5" : TextUtils.equals(str, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ) ? "floor10" : TextUtils.equals(str, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE) ? "floor15" : TextUtils.equals(str, Constants.VIA_REPORT_TYPE_JOININ_GROUP) ? "auto_midpage" : str;
    }

    public static int b(int i) {
        if (i != -400) {
            if (i != -200) {
                return i != -100 ? 3 : 2;
            }
            return 1;
        }
        return 4;
    }

    public static JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appVer", TbConfig.getVersion());
            jSONObject.put("clientIp", CommonHelper.getIp());
            jSONObject.put("clientTimestamp", String.valueOf(System.currentTimeMillis()));
            jSONObject.put("deviceId", UtilHelper.getDeviceId());
            jSONObject.put("network", d());
            jSONObject.put("osType", "AND");
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
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("model", Build.MODEL);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static String d() {
        return j.H() ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : j.t() ? "2G" : j.u() ? g.f3874b : (j.v() || j.z()) ? "4G" : "NONE";
    }

    public static void e() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_MOOV_UPLOAD, TbConfig.SERVER_ADDRESS + TbConfig.URL_MOOV_REPORT);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static void f() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921309, new b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static String g(int i) {
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
