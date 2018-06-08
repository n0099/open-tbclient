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
    private int aDS;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int aDQ = 0;
    private int aDR = 0;
    private VersionData aDJ = new VersionData();
    private k aDK = new k();
    private l aDL = new l();
    private CombineDownload aDM = new CombineDownload();
    private p aDN = new p();
    private v aDO = new v();
    private m aDT = new m();
    private com.baidu.tbadk.coreExtra.data.d aDP = new com.baidu.tbadk.coreExtra.data.d();
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
                this.aDJ.parserJson(jSONObject.optJSONObject("version"));
                this.aDK.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.aDL.parserJson(jSONObject.optJSONObject("config"));
                this.aDO.parserJson(jSONObject.optJSONObject("wl_config"));
                this.aDT.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.aDT);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.aDR = jSONObject.optInt("is_uninterest");
                this.aDS = jSONObject.optInt("first_time_motivate");
                this.aDM.parserJson(jSONObject.optJSONObject("combine_download"));
                this.aDN.parserJson(jSONObject.optJSONObject("mainbar"));
                this.aDQ = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().t(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                this.aDP.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public l Ef() {
        return this.aDL;
    }

    public String Eg() {
        return this.mConfigVersion;
    }

    public CombineDownload Eh() {
        return this.aDM;
    }

    public VersionData Ei() {
        return this.aDJ;
    }

    public k Ej() {
        return this.aDK;
    }

    public v Ek() {
        return this.aDO;
    }

    public com.baidu.tbadk.coreExtra.data.d El() {
        return this.aDP;
    }

    public com.baidu.tbadk.coreExtra.data.c getAdAdSense() {
        return this.mAdAdSense;
    }

    public int Em() {
        return this.aDR;
    }

    public boolean En() {
        return this.aDS == 1;
    }

    public com.baidu.tbadk.coreExtra.data.b getActivitySwitch() {
        return this.mActivitySwitch;
    }
}
