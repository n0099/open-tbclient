package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.UninstallInquirer;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.httpNet.CDNIPDirectConnect;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.performanceLog.ac;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, Integer> ig;
    private final boolean Qs = true;
    private boolean mGpuOpen = true;
    private boolean QB = true;
    private int QC = 100000;
    private int QD = 6257;
    private int QE = 100;
    private boolean QF = false;
    private int Qu = 0;
    private int Qv = 0;
    private int Qw = 1;
    private String Qx = null;
    private String Qy = null;
    private String mYijianfankuiFname = null;
    private String Qz = null;
    private final BannerData Qt = new BannerData();
    private com.baidu.tbadk.core.data.h Hg = new com.baidu.tbadk.core.data.h();

    public e() {
        this.ig = null;
        this.ig = new HashMap<>();
    }

    public int rx() {
        return this.QC;
    }

    public int getCrashLimitCount() {
        return this.QE;
    }

    public int ry() {
        return this.QD;
    }

    public void parserJson(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null) {
            try {
                this.Qt.parserJson(jSONObject.optJSONObject("banner"));
                this.Qu = jSONObject.optInt("pb_max_floor_total_num", 0);
                this.Qv = jSONObject.optInt("pb_big_image_width", 0);
                this.Qx = jSONObject.optString("big_head_image_host");
                this.Qy = jSONObject.optString("small_head_image_host");
                this.mYijianfankuiFname = jSONObject.optString("yijianfankui_fname");
                this.Qz = jSONObject.optString("yijianfankui_fid");
                this.Qw = jSONObject.optInt("img_chunk_upload_enable", 1);
                this.QD = jSONObject.optInt("aladin_port", 6257);
                this.QE = jSONObject.optInt("crash_limit_count", 100);
                int optInt = jSONObject.optInt("app_recommend", -1);
                JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
                if (optJSONObject != null) {
                    com.baidu.tbadk.distribute.a.uD().da(optJSONObject.optInt("distance", 60));
                    com.baidu.tbadk.distribute.a.uD().db(optJSONObject.optInt("items_num", 10));
                    com.baidu.tbadk.distribute.a.uD().aE(1 == optJSONObject.optInt("ad_show", 1));
                }
                TbadkCoreApplication.m255getInst().setYijianfankuiFname(this.mYijianfankuiFname);
                if (this.Hg == null) {
                    this.Hg = new com.baidu.tbadk.core.data.h();
                }
                this.Hg.parseJson(jSONObject.optString("photo_strategy"));
                com.baidu.tbadk.core.util.e.ol().a(this.Hg);
                CDNIPDirectConnect.pM().setIpDisableTime(jSONObject.optInt("ip_unavailable_time"));
                com.baidu.tbadk.cdnOptimize.a aVar = new com.baidu.tbadk.cdnOptimize.a();
                aVar.parseJson(jSONObject.optJSONObject("photo_cdn_time"));
                CDNIPDirectConnect.pM().JX = aVar;
                ac.zh().v(jSONObject.optLong("small_flow_time_out"));
                JSONArray optJSONArray = jSONObject.optJSONArray("switch");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            String optString = jSONObject2.optString("name");
                            Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", -1));
                            this.ig.put(optString, valueOf);
                            if (TextUtils.equals("uninstall_feed_back_switch", optString)) {
                                UninstallInquirer.getInstance().startProcessBySync(valueOf.intValue() != 1);
                            }
                            if ("netlib_type".equals(optString)) {
                                TbadkCoreApplication.m255getInst().setNetWorkCoreType(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                            } else if ("switch_login_passv6".equals(optString)) {
                                com.baidu.adp.lib.b.f.dc().d(optString, valueOf.intValue());
                                LoginActivity.checkPassV6Switch();
                            }
                        }
                    }
                }
                if (this.ig != null && this.ig.size() > 0) {
                    com.baidu.adp.lib.b.f.dc().b(this.ig);
                }
                this.QB = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TbadkCoreApplication.m255getInst().setIsPushServiceOpen(this.QB);
                TbadkCoreApplication.m255getInst().setIsMoPlusOpen(jSONObject.optInt("is_moplus_open", 1) == 1);
                if (!this.QB) {
                    UtilHelper.stopPushService(TbadkCoreApplication.m255getInst().getApp().getApplicationContext());
                }
                TbadkCoreApplication.m255getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt("feature_crash_auto_close_limit", 3));
                this.mGpuOpen = jSONObject.optInt("gpu_open", 1) == 1;
                TbadkCoreApplication.m255getInst().setGpuOpen(this.mGpuOpen);
                TbadkCoreApplication.m255getInst().setHttpClientOpen(jSONObject.optInt("http_client", 1) == 1);
                this.QF = jSONObject.optInt("voice_use_soft_decoder", 0) == 1;
                VoiceManager.setVoiceUseSoftDecoder(this.QF);
                if (TbadkCoreApplication.m255getInst().getFirstSyncImageQuality()) {
                    int optInt2 = jSONObject.optInt("open_abstract", 0);
                    if (!((optInt2 == 0 || TbadkCoreApplication.m255getInst().getIsAbstractStatus() != 0) ? true : true)) {
                        TbadkCoreApplication.m255getInst().setIsAbstractOn(optInt2);
                    }
                    TbadkCoreApplication.m255getInst().setFirstSyncImageQuality(false);
                }
                if (optInt == 1) {
                    TbadkCoreApplication.m255getInst().setIsAppOn(true);
                } else if (optInt == 0) {
                    TbadkCoreApplication.m255getInst().setIsAppOn(false);
                }
                this.QC = jSONObject.optInt("perform_sample_param", 100000);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("keepalive");
                if (optJSONObject2 != null) {
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("wifi");
                    if (optJSONObject3 != null) {
                        TbadkCoreApplication.m255getInst().setKeepaliveWifi(optJSONObject3.optInt("switch"));
                    }
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("nonwifi");
                    if (optJSONObject4 != null) {
                        TbadkCoreApplication.m255getInst().setKeepaliveNonWifi(optJSONObject4.optInt("switch"));
                    }
                }
                TbadkCoreApplication.m255getInst().setSocketReconnStratgy(b(jSONObject.optJSONArray("lcsReconStrategy")));
                TbadkCoreApplication.m255getInst().setSocketHeartBeatStratgy(b(jSONObject.optJSONArray("lcsHeartbeatStrategy")));
                TbadkCoreApplication.m255getInst().setSocketGetMsgStratgy(b(jSONObject.optJSONArray("imGetMsgStrategy")));
                JSONObject optJSONObject5 = jSONObject.optJSONObject("imNetworkTimeOut");
                if (optJSONObject5 != null) {
                    TbadkCoreApplication.m255getInst().setImTimeOut(new int[]{optJSONObject5.optInt("2gTo", 0) * 1000, optJSONObject5.optInt("3gTo", 0) * 1000, optJSONObject5.optInt("wifiTo", 0) * 1000});
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("imNotifyRecordStrategy");
                com.baidu.tbadk.data.c uo = com.baidu.tbadk.data.c.uo();
                if (optJSONObject6 != null) {
                    uo.parserJson(optJSONObject6);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008017));
                TbConfig.setPbListNum(this.Qu);
                TbConfig.setBigPhotoAdress(this.Qx);
                TbConfig.setSmallPhotoAdress(this.Qy);
                TbConfig.setFeedBack(this.mYijianfankuiFname, this.Qz);
                TbConfig.setImgChunkUploadEnable(this.Qw);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(jSONArray.get(i));
            if (i < length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
