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
    private HashMap<String, Integer> ii;
    private final boolean QU = true;
    private boolean mGpuOpen = true;
    private boolean Rc = true;
    private int Rd = 100000;
    private int Re = 6257;
    private int Rf = 100;
    private boolean Rg = false;
    private int QW = 0;
    private int QX = 0;
    private int QY = 1;
    private String QZ = null;
    private String Ra = null;
    private String mYijianfankuiFname = null;
    private String Rb = null;
    private final BannerData QV = new BannerData();
    private com.baidu.tbadk.core.data.h Hp = new com.baidu.tbadk.core.data.h();

    public e() {
        this.ii = null;
        this.ii = new HashMap<>();
    }

    public int rJ() {
        return this.Rd;
    }

    public int rK() {
        return this.Rf;
    }

    public int rL() {
        return this.Re;
    }

    public void parserJson(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null) {
            try {
                this.QV.parserJson(jSONObject.optJSONObject("banner"));
                this.QW = jSONObject.optInt("pb_max_floor_total_num", 0);
                this.QX = jSONObject.optInt("pb_big_image_width", 0);
                this.QZ = jSONObject.optString("big_head_image_host");
                this.Ra = jSONObject.optString("small_head_image_host");
                this.mYijianfankuiFname = jSONObject.optString("yijianfankui_fname");
                this.Rb = jSONObject.optString("yijianfankui_fid");
                this.QY = jSONObject.optInt("img_chunk_upload_enable", 1);
                this.Re = jSONObject.optInt("aladin_port", 6257);
                this.Rf = jSONObject.optInt("crash_limit_count", 100);
                int optInt = jSONObject.optInt("app_recommend", -1);
                JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
                if (optJSONObject != null) {
                    com.baidu.tbadk.distribute.a.uU().dh(optJSONObject.optInt("distance", 60));
                    com.baidu.tbadk.distribute.a.uU().di(optJSONObject.optInt("items_num", 10));
                    com.baidu.tbadk.distribute.a.uU().aG(1 == optJSONObject.optInt("ad_show", 1));
                }
                TbadkCoreApplication.m255getInst().setYijianfankuiFname(this.mYijianfankuiFname);
                if (this.Hp == null) {
                    this.Hp = new com.baidu.tbadk.core.data.h();
                }
                this.Hp.parseJson(jSONObject.optString("photo_strategy"));
                com.baidu.tbadk.core.util.e.oo().a(this.Hp);
                CDNIPDirectConnect.pX().setIpDisableTime(jSONObject.optInt("ip_unavailable_time"));
                com.baidu.tbadk.cdnOptimize.a aVar = new com.baidu.tbadk.cdnOptimize.a();
                aVar.parseJson(jSONObject.optJSONObject("photo_cdn_time"));
                CDNIPDirectConnect.pX().Kq = aVar;
                ac.zy().v(jSONObject.optLong("small_flow_time_out"));
                JSONArray optJSONArray = jSONObject.optJSONArray("switch");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            String optString = jSONObject2.optString("name");
                            Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", -1));
                            this.ii.put(optString, valueOf);
                            if (TextUtils.equals("uninstall_feed_back_switch", optString)) {
                                UninstallInquirer.getInstance().startProcessBySync(valueOf.intValue() != 1);
                            }
                            if ("netlib_type".equals(optString)) {
                                TbadkCoreApplication.m255getInst().setNetWorkCoreType(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                            } else if ("switch_login_passv6".equals(optString)) {
                                com.baidu.adp.lib.b.f.da().d(optString, valueOf.intValue());
                                LoginActivity.checkPassV6Switch();
                            } else if ("switch_start_anim".equals(optString)) {
                                com.baidu.tbadk.core.sharedPref.b.oj().putBoolean("show_logo_anim_nexttime_", valueOf.intValue() == 1);
                            }
                        }
                    }
                }
                if (this.ii != null && this.ii.size() > 0) {
                    com.baidu.adp.lib.b.f.da().b(this.ii);
                }
                this.Rc = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TbadkCoreApplication.m255getInst().setIsPushServiceOpen(this.Rc);
                TbadkCoreApplication.m255getInst().setIsMoPlusOpen(jSONObject.optInt("is_moplus_open", 1) == 1);
                if (!this.Rc) {
                    UtilHelper.stopPushService(TbadkCoreApplication.m255getInst().getApp().getApplicationContext());
                }
                TbadkCoreApplication.m255getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt("feature_crash_auto_close_limit", 3));
                this.mGpuOpen = jSONObject.optInt("gpu_open", 1) == 1;
                TbadkCoreApplication.m255getInst().setGpuOpen(this.mGpuOpen);
                TbadkCoreApplication.m255getInst().setHttpClientOpen(jSONObject.optInt("http_client", 1) == 1);
                this.Rg = jSONObject.optInt("voice_use_soft_decoder", 0) == 1;
                VoiceManager.setVoiceUseSoftDecoder(this.Rg);
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
                this.Rd = jSONObject.optInt("perform_sample_param", 100000);
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
                com.baidu.tbadk.data.c uF = com.baidu.tbadk.data.c.uF();
                if (optJSONObject6 != null) {
                    uF.parserJson(optJSONObject6);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008017));
                TbConfig.setPbListNum(this.QW);
                TbConfig.setBigPhotoAdress(this.QZ);
                TbConfig.setSmallPhotoAdress(this.Ra);
                TbConfig.setFeedBack(this.mYijianfankuiFname, this.Rb);
                TbConfig.setImgChunkUploadEnable(this.QY);
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
