package com.baidu.tieba;

import android.location.Address;
import android.os.Build;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiSafeFacade;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.searchbox.plugin.api.PayPluginManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.i.k;
import com.baidu.tieba.i.l;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class VideoPlatformStatic {
    private static CustomMessageListener bbO = new CustomMessageListener(CmdConfigCustom.MAINTAB_ONCREATE_END) { // from class: com.baidu.tieba.VideoPlatformStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.p.e.bAt().bAo();
            com.baidu.tieba.p.b.bAn().bAo();
        }
    };

    static {
        Mf();
        MessageManager.getInstance().registerListener(bbO);
        Mg();
    }

    private static void Mf() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, new CustomMessageTask.CustomRunnable<k>() { // from class: com.baidu.tieba.VideoPlatformStatic.2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<k> run(CustomMessage<k> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, new l());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Mg() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_MOOV_UPLOAD, TbConfig.SERVER_ADDRESS + TbConfig.URL_MOOV_REPORT);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public static int gu(int i) {
        switch (i) {
            case SapiErrorCode.NETWORK_FAILED /* -200 */:
                return 1;
            case -100:
                return 2;
            default:
                return 3;
        }
    }

    public static int hJ(String str) {
        if (str.contains("127.0.0.1")) {
            return 1;
        }
        if (!str.contains("http")) {
            return 2;
        }
        return 0;
    }

    public static String gv(int i) {
        switch (i) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_system_system);
            case -44399:
                return TbadkCoreApplication.getInst().getString(d.j.error_url_empty);
            case -34399:
                return TbadkCoreApplication.getInst().getString(d.j.error_what_oom);
            case -24399:
                return TbadkCoreApplication.getInst().getString(d.j.error_what_exception);
            case -14399:
                return TbadkCoreApplication.getInst().getString(d.j.error_what_service_crash);
            case -10040:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_stream_index);
            case -10039:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_avcodec_alloc_context3);
            case -10038:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_configure_audio_filters);
            case -10037:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_avcodec_parameters_to_context);
            case -10035:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_open_video_decoder);
            case -10032:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_avcodec_open);
            case -10031:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_avcodec_not_find);
            case -10028:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_auto_exit);
            case -10027:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_av_copy_packet);
            case -10026:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_av_dict_get);
            case -10025:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_no_video_or_audio_stream);
            case -10024:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_avformat_find_stream_info);
            case -10023:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_avformat_open_input);
            case -10022:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_avformat_alloc_context);
            case -10021:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_wait_mutex);
            case -10019:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_av_mallocz);
            case -10018:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_file_name);
            case -10017:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_read_tid);
            case -10016:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_video_refresh_tid);
            case -10015:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_continue_read_thread);
            case -10014:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_packet_queue_init_all);
            case -10013:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_frame_queue_init_audio);
            case -10012:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_frame_queue_init_subtitle);
            case -10011:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_frame_queue_init_video);
            case -10010:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_stream_open);
            case PayPluginManager.RESULT_CODE_UNKNOWN /* -10000 */:
                return TbadkCoreApplication.getInst().getString(d.j.error_what_ijk);
            case -5000:
                return TbadkCoreApplication.getInst().getString(d.j.error_warning_prepare_timeout);
            case -4399:
                return TbadkCoreApplication.getInst().getString(d.j.error_prepare_timeout);
            case -1010:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_system_unsupported);
            case TbErrInfo.ERR_IMG_FILE /* -1007 */:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_system_malformed);
            case TbErrInfo.ERR_IMG_CACHE /* -1004 */:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_system_io);
            case -110:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_system_timed_out);
            case 1:
                return TbadkCoreApplication.getInst().getString(d.j.error_what_system_unknown);
            case 100:
                return TbadkCoreApplication.getInst().getString(d.j.error_what_server_died);
            case 200:
                return TbadkCoreApplication.getInst().getString(d.j.error_what_system_not_valid_for_progressive_playback);
            default:
                return TbadkCoreApplication.getInst().getString(d.j.error_not_record) + i;
        }
    }

    public static String hK(String str) {
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
            return "frs_bavideotab";
        }
        if (TextUtils.equals(str, "3")) {
            return "floor5";
        }
        if (TextUtils.equals(str, "10")) {
            return "floor10";
        }
        if (TextUtils.equals(str, "11")) {
            return "floor15";
        }
        if (TextUtils.equals(str, "13")) {
            return "auto_midpage";
        }
        return str;
    }

    public static JSONObject Mh() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appVer", TbConfig.getVersion());
            jSONObject.put("clientIp", com.baidu.tbadk.core.util.d.getIp());
            jSONObject.put("clientTimestamp", String.valueOf(System.currentTimeMillis()));
            jSONObject.put("deviceId", UtilHelper.getDeviceId());
            jSONObject.put("network", Mi());
            jSONObject.put("osType", "AND");
            jSONObject.put("osVer", Build.VERSION.RELEASE);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                jSONObject.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            } else {
                jSONObject.put(SapiAccountManager.SESSION_UID, "");
            }
            StringBuilder sb = new StringBuilder();
            if (com.baidu.adp.lib.d.a.fc().D(false) != null) {
                Address D = com.baidu.adp.lib.d.a.fc().D(false);
                if (!StringUtils.isNull(D.getAdminArea())) {
                    sb.append(D.getAdminArea());
                }
                if (!StringUtils.isNull(D.getSubAdminArea())) {
                    sb.append(D.getSubAdminArea());
                }
                if (!StringUtils.isNull(D.getSubLocality())) {
                    sb.append(D.getSubLocality());
                }
            }
            jSONObject.put("location", sb.toString());
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("model", Build.MODEL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static String Mi() {
        if (j.hi()) {
            return "WIFI";
        }
        if (j.hm()) {
            return "2G";
        }
        if (j.hl()) {
            return "3G";
        }
        if (!j.hk() && !j.hh()) {
            return "NONE";
        }
        return "4G";
    }

    public static String gw(int i) {
        switch (i) {
            case 101:
                return TbadkCoreApplication.getInst().getString(d.j.post_error_compress_success);
            case SapiSafeFacade.SAPIWEBVIEW_BACK /* 102 */:
                return TbadkCoreApplication.getInst().getString(d.j.post_error_compress_not_do);
            case SapiSafeFacade.SAPIWEBVIEW_FINISH /* 103 */:
                return TbadkCoreApplication.getInst().getString(d.j.post_error_compress_failed);
            case SapiSafeFacade.SAPIWEBVIEW_AUTHORIZATION /* 104 */:
                return TbadkCoreApplication.getInst().getString(d.j.post_error_compress_abort);
            case 105:
                return TbadkCoreApplication.getInst().getString(d.j.post_error_compress_too_slow);
            case SapiSafeFacade.SAPIWEBVIEW_MODIFY_PWD /* 106 */:
                return TbadkCoreApplication.getInst().getString(d.j.post_error_compress_file_not_exists);
            case SapiSafeFacade.SAPIWEBVIEW_LOGIN /* 107 */:
                return TbadkCoreApplication.getInst().getString(d.j.post_error_compress_filename_not_exists);
            default:
                return TbadkCoreApplication.getInst().getString(d.j.error_not_record) + i;
        }
    }
}
