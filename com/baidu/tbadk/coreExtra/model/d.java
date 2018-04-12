package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.coreExtra.data.m;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.v;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int avG;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int avE = 0;
    private int avF = 0;
    private VersionData avx = new VersionData();
    private k avy = new k();
    private l avz = new l();
    private CombineDownload avA = new CombineDownload();
    private p avB = new p();
    private v avC = new v();
    private m avH = new m();
    private com.baidu.tbadk.coreExtra.data.d avD = new com.baidu.tbadk.coreExtra.data.d();
    private com.baidu.tbadk.coreExtra.data.c mAdAdSense = new com.baidu.tbadk.coreExtra.data.c();
    private final com.baidu.tbadk.coreExtra.data.b mActivitySwitch = new com.baidu.tbadk.coreExtra.data.b();

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.avx.parserJson(jSONObject.optJSONObject("version"));
                this.avy.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.avz.parserJson(jSONObject.optJSONObject("config"));
                this.avC.parserJson(jSONObject.optJSONObject("wl_config"));
                this.avH.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.avH);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.avF = jSONObject.optInt("is_uninterest");
                this.avG = jSONObject.optInt("first_time_motivate");
                this.avA.parserJson(jSONObject.optJSONObject("combine_download"));
                this.avB.parserJson(jSONObject.optJSONObject("mainbar"));
                this.avE = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001141, jSONObject));
                this.mFaceShopVersion = jSONObject.optInt("faceshop_version");
                if (this.mFaceShopVersion > TbadkCoreApplication.getInst().getFaceShopVersion()) {
                    TbadkCoreApplication.getInst().setTempFaceShopVersion(this.mFaceShopVersion);
                    TbadkCoreApplication.getInst().setFaceShopNew(true);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject != null) {
                    TbadkCoreApplication.getInst().setLcsSwitchStratgy(optJSONObject.toString());
                }
                new b().p(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                this.avD.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public l AG() {
        return this.avz;
    }

    public String AH() {
        return this.mConfigVersion;
    }

    public CombineDownload AI() {
        return this.avA;
    }

    public VersionData AJ() {
        return this.avx;
    }

    public k AK() {
        return this.avy;
    }

    public v AL() {
        return this.avC;
    }

    public com.baidu.tbadk.coreExtra.data.d AM() {
        return this.avD;
    }

    public com.baidu.tbadk.coreExtra.data.c getAdAdSense() {
        return this.mAdAdSense;
    }

    public int AN() {
        return this.avF;
    }

    public boolean AO() {
        return this.avG == 1;
    }

    public com.baidu.tbadk.coreExtra.data.b getActivitySwitch() {
        return this.mActivitySwitch;
    }
}
