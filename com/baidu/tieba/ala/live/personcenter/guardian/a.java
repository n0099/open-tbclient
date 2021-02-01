package com.baidu.tieba.ala.live.personcenter.guardian;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends BaseData {
    public String appId;
    public String charmCount;
    public JSONObject extInfoJson;
    public int fansCount;
    public int followCount;
    public int followStatus;
    public String hlD;
    public String hlE;
    public int hlF;
    public int hlG;
    public String hlH;
    public String hlI;
    public int isOfficial;
    public int levelId;
    public String nickName;
    public String portrait;
    public int sex;
    public String userName;
    public int userStatus;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        this.hlD = jSONObject.optString("benefit_userid");
        this.hlE = jSONObject.optString("pay_userid");
        this.userName = jSONObject.optString("user_name");
        this.nickName = jSONObject.optString("user_nickname");
        this.userStatus = jSONObject.optInt("user_status");
        this.sex = jSONObject.optInt("sex");
        this.portrait = jSONObject.optString("bd_portrait");
        if (StringUtils.isNull(this.portrait)) {
            this.portrait = jSONObject.optString("portrait");
        }
        this.hlF = jSONObject.optInt("enter_live");
        this.hlG = jSONObject.optInt("ancher_live");
        this.hlH = jSONObject.optString("level_exp");
        this.charmCount = jSONObject.optString("charm_count");
        this.isOfficial = jSONObject.optInt("is_official");
        this.levelId = jSONObject.optInt("level_id");
        this.followStatus = jSONObject.optInt("follow_status");
        this.followCount = jSONObject.optInt("follow_count");
        this.fansCount = jSONObject.optInt("fans_count");
        this.hlI = jSONObject.optString("total_price");
        this.appId = jSONObject.optString("third_app_id");
        this.extInfoJson = jSONObject.optJSONObject("ext_info");
    }

    public String getNameShow() {
        return TextUtils.isEmpty(this.nickName) ? this.userName : this.nickName;
    }
}
