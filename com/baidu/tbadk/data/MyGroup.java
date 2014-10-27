package com.baidu.tbadk.data;

import com.baidu.adp.lib.a.b.a.a.i;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.MyGroupInfo;
/* loaded from: classes.dex */
public class MyGroup extends i implements Serializable {
    private static final long serialVersionUID = 3454151897639902332L;
    private long mGroupId;
    private String mGroupName;
    private String mGroupPortrait;

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
            this.mGroupPortrait = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
        }
    }

    public void parserProtobuf(MyGroupInfo myGroupInfo) {
        if (myGroupInfo != null) {
            this.mGroupName = myGroupInfo.group_name;
            this.mGroupId = myGroupInfo.group_id.longValue();
            this.mGroupPortrait = myGroupInfo.portrait;
        }
    }
}
