package com.baidu.tieba.aiapps.apps.abtest.msg;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.decrypt.DataRes;
/* loaded from: classes4.dex */
public class a {
    private static final String DEFAULT_TITLE = TbadkCoreApplication.getInst().getString(e.j.tb_token);
    private static final String DEFAULT_TIPS = TbadkCoreApplication.getInst().getString(e.j.tb_ai_apps_tips);
    private static final String bAV = TbadkCoreApplication.getInst().getString(e.j.cancel);
    private static final String bAW = TbadkCoreApplication.getInst().getString(e.j.check_immediately);
    private String title = "";
    private String img = "";
    private String tips = "";
    private String url = "";
    private String bAX = "";
    private String bAY = "";
    public String appId = "";

    public void a(DataRes dataRes) {
        this.title = StringUtils.isNull(dataRes.title) ? DEFAULT_TITLE : dataRes.title;
        this.img = dataRes.img;
        this.tips = StringUtils.isNull(dataRes.tips) ? DEFAULT_TIPS : dataRes.tips;
        if (!StringUtils.isNull(dataRes.url)) {
            try {
                JSONObject jSONObject = new JSONObject(dataRes.url);
                this.appId = jSONObject.optString("appid");
                this.url = com.baidu.tieba.aiapps.a.t(this.appId, jSONObject.optString("url"), "1191005500000000");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        this.bAX = StringUtils.isNull(dataRes.btn_sure) ? bAW : dataRes.btn_sure;
        this.bAY = StringUtils.isNull(dataRes.btn_cancel) ? bAV : dataRes.btn_cancel;
    }

    public String getTitle() {
        return this.title;
    }

    public String Wh() {
        return this.img;
    }

    public String getTips() {
        return this.tips;
    }

    public String getUrl() {
        return this.url;
    }

    public String Wi() {
        return this.bAX;
    }

    public String Wj() {
        return this.bAY;
    }
}
