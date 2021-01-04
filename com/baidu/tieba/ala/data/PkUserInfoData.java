package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class PkUserInfoData extends BaseData implements Serializable {
    public String bdPortrait;
    public long charmCount;
    public String division;
    public String divisionIcon;
    public long feedID;
    public long groupID;
    public long liveID;
    public int liveStatus;
    public int liveType;
    public int openType;
    public String passName;
    public long pkID;
    public String portrait;
    public ArrayList<PropsInfoData> propsInfos;
    public long roomID;
    public long startTime;
    public String subappType;
    public long userID;
    public String userName;
    public String userNickName;
    public int winningStreak;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        this.userID = jSONObject.optLong("user_id");
        this.passName = jSONObject.optString("pass_name");
        this.userName = jSONObject.optString("user_name");
        this.userNickName = jSONObject.optString("user_nickname");
        this.portrait = jSONObject.optString("portrait");
        this.bdPortrait = jSONObject.optString("bd_portrait");
        this.liveID = jSONObject.optLong("live_id");
        this.roomID = jSONObject.optLong("room_id");
        this.feedID = jSONObject.optLong("feed_id");
        this.groupID = jSONObject.optLong("group_id");
        this.liveStatus = jSONObject.optInt("live_status");
        this.liveType = jSONObject.optInt(UbcStatConstant.KEY_LIVE_TYPE);
        this.openType = jSONObject.optInt("open_type");
        this.startTime = jSONObject.optLong("start_time");
        this.subappType = jSONObject.optString("subapp_type");
        this.charmCount = jSONObject.optLong("charm_count");
        this.winningStreak = jSONObject.optInt("win_streak");
        this.pkID = jSONObject.optLong("pk_id");
        this.division = jSONObject.optString("division");
        this.divisionIcon = jSONObject.optString("division_icon_url");
        setPropsInfos(jSONObject);
    }

    private void setPropsInfos(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject.has("props_info") && (optJSONArray = jSONObject.optJSONArray("props_info")) != null && optJSONArray.length() > 0) {
            if (this.propsInfos == null) {
                this.propsInfos = new ArrayList<>();
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    PropsInfoData propsInfoData = new PropsInfoData();
                    propsInfoData.parserJson(optJSONObject);
                    this.propsInfos.add(propsInfoData);
                }
            }
        }
    }
}
