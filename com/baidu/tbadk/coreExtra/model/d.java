package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.coreExtra.data.m;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.t;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int bhp;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int bhn = 0;
    private int bho = 0;
    private VersionData bhg = new VersionData();
    private k bhh = new k();
    private l bhi = new l();
    private CombineDownload bhj = new CombineDownload();
    private p bhk = new p();
    private t bhl = new t();
    private m bhq = new m();
    private com.baidu.tbadk.coreExtra.data.d bhm = new com.baidu.tbadk.coreExtra.data.d();
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
                this.bhg.parserJson(jSONObject.optJSONObject(ClientCookie.VERSION_ATTR));
                this.bhh.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.bhi.parserJson(jSONObject.optJSONObject("config"));
                this.bhl.parserJson(jSONObject.optJSONObject("wl_config"));
                this.bhq.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.bhq);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.bho = jSONObject.optInt("is_uninterest");
                this.bhp = jSONObject.optInt("first_time_motivate");
                this.bhj.parserJson(jSONObject.optJSONObject("combine_download"));
                this.bhk.parserJson(jSONObject.optJSONObject("mainbar"));
                this.bhn = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_ADS_EMOTION, jSONObject));
                this.mFaceShopVersion = jSONObject.optInt("faceshop_version");
                if (this.mFaceShopVersion > TbadkCoreApplication.getInst().getFaceShopVersion()) {
                    TbadkCoreApplication.getInst().setTempFaceShopVersion(this.mFaceShopVersion);
                    TbadkCoreApplication.getInst().setFaceShopNew(true);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject != null) {
                    TbadkCoreApplication.getInst().setLcsSwitchStratgy(optJSONObject.toString());
                }
                new b().h(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                this.bhm.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public l Hm() {
        return this.bhi;
    }

    public String Hn() {
        return this.mConfigVersion;
    }

    public CombineDownload Ho() {
        return this.bhj;
    }

    public VersionData Hp() {
        return this.bhg;
    }

    public k Hq() {
        return this.bhh;
    }

    public t Hr() {
        return this.bhl;
    }

    public com.baidu.tbadk.coreExtra.data.d Hs() {
        return this.bhm;
    }

    public com.baidu.tbadk.coreExtra.data.c getAdAdSense() {
        return this.mAdAdSense;
    }

    public int Ht() {
        return this.bho;
    }

    public boolean Hu() {
        return this.bhp == 1;
    }

    public com.baidu.tbadk.coreExtra.data.b getActivitySwitch() {
        return this.mActivitySwitch;
    }
}
