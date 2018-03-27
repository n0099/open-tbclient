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
    private int bkc;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int bka = 0;
    private int bkb = 0;
    private VersionData bjT = new VersionData();
    private k bjU = new k();
    private l bjV = new l();
    private CombineDownload bjW = new CombineDownload();
    private p bjX = new p();
    private v bjY = new v();
    private m bkd = new m();
    private com.baidu.tbadk.coreExtra.data.d bjZ = new com.baidu.tbadk.coreExtra.data.d();
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
                this.bjT.parserJson(jSONObject.optJSONObject("version"));
                this.bjU.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.bjV.parserJson(jSONObject.optJSONObject("config"));
                this.bjY.parserJson(jSONObject.optJSONObject("wl_config"));
                this.bkd.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.bkd);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.bkb = jSONObject.optInt("is_uninterest");
                this.bkc = jSONObject.optInt("first_time_motivate");
                this.bjW.parserJson(jSONObject.optJSONObject("combine_download"));
                this.bjX.parserJson(jSONObject.optJSONObject("mainbar"));
                this.bka = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().m(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                this.bjZ.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public l HS() {
        return this.bjV;
    }

    public String HT() {
        return this.mConfigVersion;
    }

    public CombineDownload HU() {
        return this.bjW;
    }

    public VersionData HV() {
        return this.bjT;
    }

    public k HW() {
        return this.bjU;
    }

    public v HX() {
        return this.bjY;
    }

    public com.baidu.tbadk.coreExtra.data.d HY() {
        return this.bjZ;
    }

    public com.baidu.tbadk.coreExtra.data.c getAdAdSense() {
        return this.mAdAdSense;
    }

    public int HZ() {
        return this.bkb;
    }

    public boolean Ia() {
        return this.bkc == 1;
    }

    public com.baidu.tbadk.coreExtra.data.b getActivitySwitch() {
        return this.mActivitySwitch;
    }
}
