package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.UninstallInquirerBySyncMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.performanceLog.y;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, Integer> tL;
    private boolean mGpuOpen = true;
    private boolean agd = true;
    private int age = 100000;
    private int agf = 100;
    private boolean agh = false;
    private int afX = 0;
    private int afY = 0;
    private int afZ = 1;
    private String aga = null;
    private String agb = null;
    private String mYijianfankuiFname = null;
    private String agc = null;
    private final BannerData afW = new BannerData();
    private com.baidu.tbadk.core.data.f agg = new com.baidu.tbadk.core.data.f();
    private k agi = new k();

    public e() {
        this.tL = null;
        this.tL = new HashMap<>();
    }

    public int wf() {
        return this.age;
    }

    public int getCrashLimitCount() {
        return this.agf;
    }

    public k wg() {
        return this.agi;
    }

    public void parserJson(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null) {
            try {
                this.afW.parserJson(jSONObject.optJSONObject("banner"));
                this.afX = jSONObject.optInt("pb_max_floor_total_num", 0);
                this.afY = jSONObject.optInt("pb_big_image_width", 0);
                this.aga = jSONObject.optString("big_head_image_host");
                this.agb = jSONObject.optString("small_head_image_host");
                this.mYijianfankuiFname = jSONObject.optString("yijianfankui_fname");
                this.agc = jSONObject.optString("yijianfankui_fid");
                this.afZ = jSONObject.optInt("img_chunk_upload_enable", 1);
                this.agf = jSONObject.optInt("crash_limit_count", 100);
                int optInt = jSONObject.optInt("app_recommend", -1);
                this.agi.parserJson(jSONObject.optJSONObject("webview_checkurl"));
                JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
                if (optJSONObject != null) {
                    com.baidu.tbadk.distribute.a.Ad().dM(optJSONObject.optInt("distance", 60));
                    com.baidu.tbadk.distribute.a.Ad().dN(optJSONObject.optInt("items_num", 10));
                    com.baidu.tbadk.distribute.a.Ad().aZ(1 == optJSONObject.optInt("ad_show", 1));
                }
                TbadkCoreApplication.m411getInst().setYijianfankuiFname(this.mYijianfankuiFname);
                if (this.agg == null) {
                    this.agg = new com.baidu.tbadk.core.data.f();
                }
                this.agg.parseJson(jSONObject.optString("photo_strategy"));
                if (p.getInstance() != null) {
                    p.getInstance().setmCdnLogData(this.agg);
                }
                com.baidu.tbadk.cdnOptimize.a aVar = new com.baidu.tbadk.cdnOptimize.a();
                aVar.parseJson(jSONObject.optJSONObject("photo_cdn_time"));
                if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                    if (!com.baidu.tbadk.core.util.a.e.getInstance().abV) {
                        com.baidu.tbadk.core.util.a.e.getInstance().init();
                    }
                    com.baidu.tbadk.core.util.a.e.getInstance().setCDNImageTimeData(aVar);
                    com.baidu.tbadk.core.util.a.e.getInstance().setIpDisableTime(jSONObject.optInt("ip_unavailable_time"));
                }
                y.DY().B(jSONObject.optLong("small_flow_time_out"));
                JSONArray optJSONArray = jSONObject.optJSONArray("switch");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            String optString = jSONObject2.optString("name");
                            Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", -1));
                            this.tL.put(optString, valueOf);
                            if (TextUtils.equals("uninstall_feed_back_switch", optString)) {
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new UninstallInquirerBySyncMessage(Boolean.valueOf(valueOf.intValue() != 1)));
                            }
                            if ("netlib_type".equals(optString)) {
                                TbadkCoreApplication.m411getInst().setNetWorkCoreType(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                            } else if ("switch_login_passv6".equals(optString)) {
                                com.baidu.adp.lib.b.e.gv().d(optString, valueOf.intValue());
                                com.baidu.tbadk.coreExtra.a.a.checkPassV6Switch();
                            }
                            if ("is_plugin_resource_open_net".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.tr().putBoolean("is_plugin_resource_open_net", valueOf.intValue() == 1);
                                if (valueOf.intValue() != 1) {
                                    TbadkCoreApplication.m411getInst().setPluginResourceSwitch(false);
                                }
                            }
                        }
                    }
                }
                if (this.tL != null && this.tL.size() > 0) {
                    com.baidu.adp.lib.b.e.gv().c(this.tL);
                }
                this.agd = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TbadkCoreApplication.m411getInst().setIsPushServiceOpen(this.agd);
                if (!this.agd) {
                    UtilHelper.stopPushService(TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
                }
                TbadkCoreApplication.m411getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt("feature_crash_auto_close_limit", 3));
                this.mGpuOpen = jSONObject.optInt("gpu_open", 1) == 1;
                TbadkCoreApplication.m411getInst().setGpuOpen(this.mGpuOpen);
                TbadkCoreApplication.m411getInst().setHttpClientOpen(jSONObject.optInt("http_client", 1) == 1);
                this.agh = jSONObject.optInt("voice_use_soft_decoder", 0) == 1;
                VoiceManager.setVoiceUseSoftDecoder(this.agh);
                if (TbadkCoreApplication.m411getInst().getFirstSyncImageQuality()) {
                    int optInt2 = jSONObject.optInt("open_abstract", 0);
                    if (!((optInt2 == 0 || TbadkCoreApplication.m411getInst().getIsAbstractStatus() != 0) ? true : true)) {
                        TbadkCoreApplication.m411getInst().setIsAbstractOn(optInt2);
                    }
                    TbadkCoreApplication.m411getInst().setFirstSyncImageQuality(false);
                }
                if (optInt == 1) {
                    TbadkCoreApplication.m411getInst().setIsAppOn(true);
                } else if (optInt == 0) {
                    TbadkCoreApplication.m411getInst().setIsAppOn(false);
                }
                this.age = jSONObject.optInt("perform_sample_param", 100000);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("keepalive");
                if (optJSONObject2 != null) {
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("wifi");
                    if (optJSONObject3 != null) {
                        TbadkCoreApplication.m411getInst().setKeepaliveWifi(optJSONObject3.optInt("switch"));
                    }
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("nonwifi");
                    if (optJSONObject4 != null) {
                        TbadkCoreApplication.m411getInst().setKeepaliveNonWifi(optJSONObject4.optInt("switch"));
                    }
                }
                TbadkCoreApplication.m411getInst().setSocketReconnStratgy(b(jSONObject.optJSONArray("lcsReconStrategy")));
                TbadkCoreApplication.m411getInst().setSocketHeartBeatStratgy(b(jSONObject.optJSONArray("lcsHeartbeatStrategy")));
                TbadkCoreApplication.m411getInst().setSocketGetMsgStratgy(b(jSONObject.optJSONArray("imGetMsgStrategy")));
                JSONObject optJSONObject5 = jSONObject.optJSONObject("imNetworkTimeOut");
                if (optJSONObject5 != null) {
                    TbadkCoreApplication.m411getInst().setImTimeOut(new int[]{optJSONObject5.optInt("2gTo", 0) * 1000, optJSONObject5.optInt("3gTo", 0) * 1000, optJSONObject5.optInt("wifiTo", 0) * 1000});
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("imNotifyRecordStrategy");
                com.baidu.tbadk.data.c zS = com.baidu.tbadk.data.c.zS();
                if (optJSONObject6 != null) {
                    zS.parserJson(optJSONObject6);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_RESET_CONNECT_STRATEGY));
                TbConfig.setPbListNum(this.afX);
                TbConfig.setBigPhotoAdress(this.aga);
                TbConfig.setSmallPhotoAdress(this.agb);
                TbConfig.setFeedBack(this.mYijianfankuiFname, this.agc);
                TbConfig.setImgChunkUploadEnable(this.afZ);
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
