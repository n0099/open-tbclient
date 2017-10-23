package com.baidu.tbadk.coreExtra.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import com.baidu.tbadk.coreExtra.data.i;
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.coreExtra.data.r;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int asm;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int ask = 0;
    private int asl = 0;
    private VersionData asd = new VersionData();
    private i ase = new i();
    private j asf = new j();
    private CombineDownload asg = new CombineDownload();
    private n ash = new n();
    private r asi = new r();
    private k asn = new k();
    private com.baidu.tbadk.coreExtra.data.b asj = new com.baidu.tbadk.coreExtra.data.b();
    private com.baidu.tbadk.coreExtra.data.a mAdAdSense = new com.baidu.tbadk.coreExtra.data.a();

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
                this.asd.parserJson(jSONObject.optJSONObject("version"));
                this.ase.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.asf.parserJson(jSONObject.optJSONObject("config"));
                this.asi.parserJson(jSONObject.optJSONObject("wl_config"));
                this.asn.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.asn);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.asl = jSONObject.optInt("is_uninterest");
                this.asm = jSONObject.optInt("first_time_motivate");
                this.asg.parserJson(jSONObject.optJSONObject("combine_download"));
                this.ash.parserJson(jSONObject.optJSONObject("mainbar"));
                this.ask = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().i(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                this.asj.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public j zt() {
        return this.asf;
    }

    public String zu() {
        return this.mConfigVersion;
    }

    public CombineDownload zv() {
        return this.asg;
    }

    public VersionData zw() {
        return this.asd;
    }

    public i zx() {
        return this.ase;
    }

    public r zy() {
        return this.asi;
    }

    public com.baidu.tbadk.coreExtra.data.b zz() {
        return this.asj;
    }

    public com.baidu.tbadk.coreExtra.data.a getAdAdSense() {
        return this.mAdAdSense;
    }

    public int zA() {
        return this.asl;
    }

    public boolean zB() {
        return this.asm == 1;
    }
}
