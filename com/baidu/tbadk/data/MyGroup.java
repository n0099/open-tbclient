package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.MyGroupInfo;
/* loaded from: classes3.dex */
public class MyGroup extends OrmObject implements Serializable {
    public static final long serialVersionUID = 3454151897639902332L;
    public long mGroupId;
    public Integer mGroupMemberNum;
    public String mGroupName;
    public String mGroupPortrait;

    public long getGroupId() {
        return this.mGroupId;
    }

    public String getGroupPortrait() {
        return this.mGroupPortrait;
    }

    public Integer getmGroupMemberNum() {
        return this.mGroupMemberNum;
    }

    public String getmGroupName() {
        return this.mGroupName;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mGroupName = jSONObject.optString("group_name");
        this.mGroupId = jSONObject.optLong("group_id");
        this.mGroupPortrait = jSONObject.optString("portrait");
        this.mGroupMemberNum = Integer.valueOf(jSONObject.optInt("member_num"));
    }

    public void parserProtobuf(MyGroupInfo myGroupInfo) {
        if (myGroupInfo == null) {
            return;
        }
        this.mGroupName = myGroupInfo.group_name;
        this.mGroupId = myGroupInfo.group_id.longValue();
        this.mGroupPortrait = myGroupInfo.portrait;
        this.mGroupMemberNum = myGroupInfo.member_num;
    }

    public void setGroupId(long j) {
        this.mGroupId = j;
    }

    public void setGroupName(String str) {
        this.mGroupName = str;
    }

    public void setGroupPortrait(String str) {
        this.mGroupPortrait = str;
    }

    public void setmGroupMemberNum(Integer num) {
        this.mGroupMemberNum = num;
    }
}
