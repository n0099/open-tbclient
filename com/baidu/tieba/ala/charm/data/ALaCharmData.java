package com.baidu.tieba.ala.charm.data;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.BaseData;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ALaCharmData extends BaseData implements Serializable {
    private static final long serialVersionUID = -2170940113039348861L;
    public String anchor_live;
    public String appId;
    public String benefit_userid;
    public String charm_count;
    public String create_time;
    public String description;
    public String enter_live;
    public int fans_count;
    public int follow_count;
    public int follow_status;
    public long forwardDiff;
    public int is_official;
    public String lat;
    public String level_exp;
    public int level_id;
    public String live_id;
    public String live_status;
    public String lng;
    public String location;
    public String pass_name;
    public String pay_userid;
    public String portrait;
    public String push_switch;
    public int sex;
    public String total_price;
    public String update_time;
    public String user_id;
    public String user_name;
    public int user_status;
    public String verify_info_status;
    public String verify_video_status;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.benefit_userid = jSONObject.optString("benefit_userid");
                this.pay_userid = jSONObject.optString("pay_userid");
                this.total_price = jSONObject.optString("total_price");
                this.user_id = jSONObject.optString("user_id");
                this.user_name = jSONObject.optString("user_nickname");
                if (StringUtils.isNull(this.user_name)) {
                    this.user_name = jSONObject.optString("user_name");
                }
                this.pass_name = jSONObject.optString("pass_name");
                this.user_status = jSONObject.optInt("user_status");
                this.sex = jSONObject.optInt("sex");
                this.portrait = jSONObject.optString("bd_portrait");
                if (StringUtils.isNull(this.portrait)) {
                    this.portrait = jSONObject.optString("portrait");
                }
                this.description = jSONObject.optString("description");
                this.follow_count = jSONObject.optInt("follow_count");
                this.fans_count = jSONObject.optInt("fans_count");
                this.enter_live = jSONObject.optString("enter_live");
                this.anchor_live = jSONObject.optString("anchor_live");
                this.location = jSONObject.optString("location");
                this.lng = jSONObject.optString("lng");
                this.lat = jSONObject.optString("lat");
                this.live_id = jSONObject.optString("live_id");
                this.live_status = jSONObject.optString("live_status");
                this.level_exp = jSONObject.optString("level_exp");
                this.charm_count = jSONObject.optString("charm_count");
                this.update_time = jSONObject.optString("update_time");
                this.create_time = jSONObject.optString("create_time");
                this.push_switch = jSONObject.optString("push_switch");
                this.verify_info_status = jSONObject.optString("verify_info_status");
                this.verify_video_status = jSONObject.optString("verify_video_status");
                this.is_official = jSONObject.optInt("is_official", 0);
                this.level_id = jSONObject.optInt("level_id", 0);
                this.follow_status = jSONObject.optInt("follow_status", 0);
                this.appId = jSONObject.optString("third_app_id");
                this.forwardDiff = jSONObject.optLong("forward_diff");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
