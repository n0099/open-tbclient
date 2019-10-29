package com.baidu.tieba.ala.live.personcenter.fans;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.AlaUserInfoData;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public int dRF;
    public int dRG;
    public AlaUserInfoData dRH;
    public String intro;
    private int isFriend;
    public String liveId;
    public int liveStatus;
    public int live_status;
    public int mAttentionType = 2;
    public String name_show;
    public String portrait;
    public String portraith;
    public String userId;
    public String userName;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.userId = jSONObject.optString("id");
            this.userName = jSONObject.optString("name");
            this.name_show = jSONObject.optString("name_show");
            this.portrait = jSONObject.optString("bd_portrait");
            if (StringUtils.isNull(this.portrait)) {
                this.portrait = jSONObject.optString("portrait");
            }
            this.portraith = jSONObject.optString("portraith");
            this.liveStatus = jSONObject.optInt("live_status");
            this.liveId = jSONObject.optString("live_id");
            this.intro = jSONObject.optString("intro");
            this.live_status = jSONObject.optInt("live_status");
            this.dRF = jSONObject.optInt("live_id");
            this.isFriend = jSONObject.optInt("is_friend");
            this.dRG = jSONObject.optInt("has_concerned");
            if (jSONObject.optJSONObject("ala_info") != null) {
                this.dRH = new AlaUserInfoData();
                this.dRH.parserJson(jSONObject.optJSONObject("ala_info"));
            }
        }
    }

    public String getNameShow() {
        return TextUtils.isEmpty(this.name_show) ? this.userName : this.name_show;
    }

    public boolean aMy() {
        return this.dRG != 0;
    }
}
