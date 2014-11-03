package com.baidu.tieba.data;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.UninstallInquirer;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private HashMap<String, Integer> hX;
    private final boolean ajO = true;
    private boolean mGpuOpen = true;
    private boolean ajW = true;
    private int ajX = 100000;
    private int ajY = TbConfig.POST_IMAGE_SMALL;
    private int ajZ = 10;
    private int aka = 10;
    private int akb = 6257;
    private int akc = 100;
    private boolean akd = false;
    private int ajQ = 0;
    private int ajR = 0;
    private int ajS = 1;
    private String ajT = null;
    private String ajU = null;
    private String adU = null;
    private String ajV = null;
    private final BannerData ajP = new BannerData();
    private com.baidu.tbadk.core.data.f CU = new com.baidu.tbadk.core.data.f();

    public f() {
        this.hX = null;
        this.hX = new HashMap<>();
    }

    public int yB() {
        return this.ajX;
    }

    public int yC() {
        return this.akc;
    }

    public int yD() {
        return this.akb;
    }

    public void parserJson(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null) {
            try {
                this.ajP.parserJson(jSONObject.optJSONObject("banner"));
                this.ajQ = jSONObject.optInt("pb_max_floor_total_num", 0);
                this.ajR = jSONObject.optInt("pb_big_image_width", 0);
                this.ajT = jSONObject.optString("big_head_image_host");
                this.ajU = jSONObject.optString("small_head_image_host");
                this.adU = jSONObject.optString("yijianfankui_fname");
                this.ajV = jSONObject.optString("yijianfankui_fid");
                this.ajS = jSONObject.optInt("img_chunk_upload_enable", 1);
                this.ajY = jSONObject.optInt("kuainan_vote_cd", TbConfig.POST_IMAGE_SMALL);
                this.ajZ = jSONObject.optInt("kuainan_vote_max", 10);
                this.aka = jSONObject.optInt("kuainan_vote_rate", 10);
                this.akb = jSONObject.optInt("aladin_port", 6257);
                this.akc = jSONObject.optInt("crash_limit_count", 100);
                int optInt = jSONObject.optInt("app_recommend", -1);
                JSONObject optJSONObject = jSONObject.optJSONObject("log_together");
                if (optJSONObject != null) {
                    com.baidu.tbadk.distribute.a.rc().cD(optJSONObject.optInt("distance", 60));
                    com.baidu.tbadk.distribute.a.rc().cE(optJSONObject.optInt("items_num", 10));
                    com.baidu.tbadk.distribute.a.rc().aq(1 == optJSONObject.optInt("ad_show", 1));
                }
                com.baidu.tieba.aj.wm().ef(this.adU);
                if (this.CU == null) {
                    this.CU = new com.baidu.tbadk.core.data.f();
                }
                this.CU.parseJson(jSONObject.optString("photo_strategy"));
                com.baidu.tbadk.core.util.e.lq().a(this.CU);
                com.baidu.tbadk.performanceLog.v.uP().s(jSONObject.optLong("small_flow_time_out"));
                JSONArray optJSONArray = jSONObject.optJSONArray("switch");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            String optString = jSONObject2.optString("name");
                            Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", -1));
                            this.hX.put(optString, valueOf);
                            if (TextUtils.equals("uninstall_feed_back_switch", optString)) {
                                UninstallInquirer.getInstance().startProcessBySync(valueOf.intValue() != 1);
                            }
                            if ("netlib_type".equals(optString)) {
                                TbadkApplication.m251getInst().setNetWorkCoreType(jSONObject2.optInt("type", 1) == 0 ? 1 : 0);
                            } else if ("switch_login_passv6".equals(optString)) {
                                com.baidu.adp.lib.b.f.db().c(optString, valueOf.intValue());
                                LoginActivity.checkPassV6Switch();
                            }
                        }
                    }
                }
                if (this.hX != null && this.hX.size() > 0) {
                    com.baidu.adp.lib.b.f.db().a(this.hX);
                }
                this.ajW = jSONObject.optInt("is_pushservice_open", 1) == 1;
                TbadkApplication.m251getInst().setIsPushServiceOpen(this.ajW);
                TbadkApplication.m251getInst().setIsMoPlusOpen(jSONObject.optInt("is_moplus_open", 1) == 1);
                if (!this.ajW) {
                    UtilHelper.stopPushService(com.baidu.tieba.aj.wm().getApp().getApplicationContext());
                }
                TbadkApplication.m251getInst().setFeatureCrashAutoCloseLimit(jSONObject.optInt("feature_crash_auto_close_limit", 3));
                this.mGpuOpen = jSONObject.optInt("gpu_open", 1) == 1;
                TbadkApplication.m251getInst().setGpuOpen(this.mGpuOpen);
                TbadkApplication.m251getInst().setHttpClientOpen(jSONObject.optInt("http_client", 1) == 1);
                this.akd = jSONObject.optInt("voice_use_soft_decoder", 0) == 1;
                VoiceManager.setVoiceUseSoftDecoder(this.akd);
                if (com.baidu.tieba.aj.wm().wN()) {
                    int optInt2 = jSONObject.optInt("open_abstract", 0);
                    if (!((optInt2 == 0 || TbadkApplication.m251getInst().getIsAbstractStatus() != 0) ? true : true)) {
                        TbadkApplication.m251getInst().setIsAbstractOn(optInt2);
                    }
                    com.baidu.tieba.aj.wm().bc(false);
                }
                if (optInt == 1) {
                    com.baidu.tieba.aj.wm().aQ(true);
                } else if (optInt == 0) {
                    com.baidu.tieba.aj.wm().aQ(false);
                }
                com.baidu.tieba.aj.wm().dE(this.ajY);
                com.baidu.tieba.aj.wm().dF(this.ajZ);
                com.baidu.tieba.aj.wm().dG(this.aka);
                this.ajX = jSONObject.optInt("perform_sample_param", 100000);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("keepalive");
                if (optJSONObject2 != null) {
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("wifi");
                    if (optJSONObject3 != null) {
                        TbadkApplication.m251getInst().setKeepaliveWifi(optJSONObject3.optInt("switch"));
                    }
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("nonwifi");
                    if (optJSONObject4 != null) {
                        TbadkApplication.m251getInst().setKeepaliveNonWifi(optJSONObject4.optInt("switch"));
                    }
                }
                com.baidu.tieba.aj.wm().eb(a(jSONObject.optJSONArray("lcsReconStrategy")));
                com.baidu.tieba.aj.wm().ec(a(jSONObject.optJSONArray("lcsHeartbeatStrategy")));
                com.baidu.tieba.aj.wm().ed(a(jSONObject.optJSONArray("imGetMsgStrategy")));
                JSONObject optJSONObject5 = jSONObject.optJSONObject("imNetworkTimeOut");
                if (optJSONObject5 != null) {
                    com.baidu.tieba.aj.wm().c(new int[]{optJSONObject5.optInt("2gTo", 0) * 1000, optJSONObject5.optInt("3gTo", 0) * 1000, optJSONObject5.optInt("wifiTo", 0) * 1000});
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("imNotifyRecordStrategy");
                com.baidu.tbadk.data.a qS = com.baidu.tbadk.data.a.qS();
                if (optJSONObject6 != null) {
                    qS.parserJson(optJSONObject6);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008017));
                e.dX(this.ajQ);
                TbConfig.setBigPhotoAdress(this.ajT);
                TbConfig.setSmallPhotoAdress(this.ajU);
                e.aa(this.adU, this.ajV);
                e.dY(this.ajS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String a(JSONArray jSONArray) {
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
