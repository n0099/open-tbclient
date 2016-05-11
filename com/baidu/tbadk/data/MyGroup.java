package com.baidu.tbadk.data;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.MyGroupInfo;
/* loaded from: classes.dex */
public class MyGroup extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
    private static final long serialVersionUID = 3454151897639902332L;
    private long mGroupId;
    private Integer mGroupMemberNum;
    private String mGroupName;
    private String mGroupPortrait;

    public Integer getmGroupMemberNum() {
        return this.mGroupMemberNum;
    }

    public void setmGroupMemberNum(Integer num) {
        this.mGroupMemberNum = num;
    }

    public String getmGroupName() {
        return this.mGroupName;
    }

    public void setGroupName(String str) {
        this.mGroupName = str;
    }

    public String getGroupPortrait() {
        return this.mGroupPortrait;
    }

    public void setGroupPortrait(String str) {
        this.mGroupPortrait = str;
    }

    public long getGroupId() {
        return this.mGroupId;
    }

    public void setGroupId(long j) {
        this.mGroupId = j;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mGroupName = jSONObject.optString("group_name");
            this.mGroupId = jSONObject.optLong("group_id");
            this.mGroupPortrait = jSONObject.optString(IntentConfig.PORTRAIT);
            this.mGroupMemberNum = Integer.valueOf(jSONObject.optInt("member_num"));
        }
    }

    public void parserProtobuf(MyGroupInfo myGroupInfo) {
        if (myGroupInfo != null) {
            this.mGroupName = myGroupInfo.group_name;
            this.mGroupId = myGroupInfo.group_id.longValue();
            this.mGroupPortrait = myGroupInfo.portrait;
            this.mGroupMemberNum = myGroupInfo.member_num;
        }
    }
}
