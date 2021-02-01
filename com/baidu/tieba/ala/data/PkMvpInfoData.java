package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class PkMvpInfoData extends BaseData implements Serializable {
    public String bdPortrait;
    public String passName;
    public String portrait;
    public int propsID;
    public long userID;
    public String userName;
    public String userNickName;
    public String propsType = "";
    public String contributionHonor = "";

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        this.userID = jSONObject.optLong("user_id");
        this.passName = jSONObject.optString("pass_name");
        this.userName = jSONObject.optString("user_name");
        this.userNickName = jSONObject.optString("user_nickname");
        this.portrait = jSONObject.optString("portrait");
        this.bdPortrait = jSONObject.optString("bd_portrait");
        this.contributionHonor = jSONObject.optString("contribution_honor");
        this.propsID = jSONObject.optInt("props_id");
        JSONObject optJSONObject = jSONObject.optJSONObject("props_info");
        if (optJSONObject != null) {
            this.propsType = optJSONObject.optString("props_type");
        }
    }
}
