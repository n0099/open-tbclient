package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.UninstallInquirer;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.performanceLog.ah;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, Integer> tO;
    private final boolean abH = true;
    private boolean mGpuOpen = true;
    private boolean abP = true;
    private int abQ = 100000;
    private int abR = 6257;
    private int abS = 100;
    private boolean abU = false;
    private int abJ = 0;
    private int abK = 0;
    private int abL = 1;
    private String abM = null;
    private String abN = null;
    private String mYijianfankuiFname = null;
    private String abO = null;
    private final BannerData abI = new BannerData();
    private com.baidu.tbadk.core.data.h abT = new com.baidu.tbadk.core.data.h();
    private k abV = new k();

    public e() {
        this.tO = null;
        this.tO = new HashMap<>();
    }

    public int vj() {
        return this.abQ;
    }

    public int getCrashLimitCount() {
        return this.abS;
    }

    public int vk() {
        return this.abR;
    }

    public k vl() {
        return this.abV;
    }

    public void parserJson(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null) {
            try {
                this.abI.parserJson(jSONObject.optJSONObject("banner"));
                this.abJ = jSONObject.optInt("pb_max_floor_total_num", 0);
                this.abK = jSONObject.optInt("pb_big_image_width", 0);
                this.abM = jSONObject.optString("big_head_image_host");
                this.abN = jSONObject.optString("small_head_image_host");
                this.mYijianfankuiFname = jSONObject.optString("yijianfankui_fname");
                this.abO = jSONObject.optString("yijianfankui_fid");
                this.abL = jSONObject.optInt("img_chunk_upload_enable", 1);
                this.abR = jSONObject.optInt("aladin_port", 6257);
                this.abS = jSONObject.optInt("crash_limit_count", 100);
                int optInt = jSONObject.optInt("app_recommend", -1);
                this.abV.parserJson(jSONObject.optJSONObject("webview_checkurl"));
                JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
                if (optJSONObject != null) {
                    com.baidu.tbadk.distribute.a.yX().dt(optJSONObject.optInt("distance", 60));
                    com.baidu.tbadk.distribute.a.yX().du(optJSONObject.optInt("items_num", 10));
                    com.baidu.tbadk.distribute.a.yX().aT(1 == optJSONObject.optInt("ad_show", 1));
                }
                TbadkCoreApplication.m411getInst().setYijianfankuiFname(this.mYijianfankuiFname);
                if (this.abT == null) {
                    this.abT = new com.baidu.tbadk.core.data.h();
                }
                this.abT.parseJson(jSONObject.optString("photo_strategy"));
                if (r.getInstance() != null) {
                    r.getInstance().setmCdnLogData(this.abT);
                }
                com.baidu.tbadk.cdnOptimize.a aVar = new com.baidu.tbadk.cdnOptimize.a();
                aVar.parseJson(jSONObject.optJSONObject("photo_cdn_time"));
                if (com.baidu.tbadk.core.util.httpNet.e.getInstance() != null) {
                    if (!com.baidu.tbadk.core.util.httpNet.e.getInstance().WL) {
                        com.baidu.tbadk.core.util.httpNet.e.getInstance().init();
                    }
                    com.baidu.tbadk.core.util.httpNet.e.getInstance().setCDNImageTimeData(aVar);
                    com.baidu.tbadk.core.util.httpNet.e.getInstance().setIpDisableTime(jSONObject.optInt("ip_unavailable_time"));
                }
                ah.DB().x(jSONObject.optLong("small_flow_time_out"));
                JSONArray optJSONArray = jSONObject.optJSONArray("switch");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            String optString = jSONObject2.optString("name");
                            Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", -1));
                            this.tO.put(optString, valueOf);
                            if (TextUtils.equals("uninstall_feed_back_switch", optString)) {
                                UninstallInquirer.getInstance().startProcessBySync(valueOf.intValue() != 1);
                            }
                            if ("netlib_type".equals(optString)) {
                                TbadkCoreApplication.m411getInst().setNetWorkCoreType(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                            } else if ("switch_login_passv6".equals(optString)) {
                                com.baidu.adp.lib.b.f.gD().d(optString, valueOf.intValue());
                                com.baidu.tbadk.coreExtra.act.a.checkPassV6Switch();
                            }
                            if ("is_plugin_resource_open_net".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("is_plugin_resource_open_net", valueOf.intValue() == 1);
                                if (valueOf.intValue() != 1) {
                                    TbadkCoreApplication.m411getInst().setPluginResourceSwitch(false);
                                }
                            }
                        }
                    }
                }
                if (this.tO != null && this.tO.size() > 0) {
                    com.baidu.adp.lib.b.f.gD().b(this.tO);
                }
                this.abP = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TbadkCoreApplication.m411getInst().setIsPushServiceOpen(this.abP);
                TbadkCoreApplication.m411getInst().setIsMoPlusOpen(jSONObject.optInt("is_moplus_open", 1) == 1);
                if (!this.abP) {
                    UtilHelper.stopPushService(TbadkCoreApplication.m411getInst().getApp().getApplicationContext());
                }
                TbadkCoreApplication.m411getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt("feature_crash_auto_close_limit", 3));
                this.mGpuOpen = jSONObject.optInt("gpu_open", 1) == 1;
                TbadkCoreApplication.m411getInst().setGpuOpen(this.mGpuOpen);
                TbadkCoreApplication.m411getInst().setHttpClientOpen(jSONObject.optInt("http_client", 1) == 1);
                this.abU = jSONObject.optInt("voice_use_soft_decoder", 0) == 1;
                VoiceManager.setVoiceUseSoftDecoder(this.abU);
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
                this.abQ = jSONObject.optInt("perform_sample_param", 100000);
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
                com.baidu.tbadk.data.c yI = com.baidu.tbadk.data.c.yI();
                if (optJSONObject6 != null) {
                    yI.parserJson(optJSONObject6);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008017));
                TbConfig.setPbListNum(this.abJ);
                TbConfig.setBigPhotoAdress(this.abM);
                TbConfig.setSmallPhotoAdress(this.abN);
                TbConfig.setFeedBack(this.mYijianfankuiFname, this.abO);
                TbConfig.setImgChunkUploadEnable(this.abL);
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
