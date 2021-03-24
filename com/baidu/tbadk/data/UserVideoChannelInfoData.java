package com.baidu.tbadk.data;

import java.io.Serializable;
import org.json.JSONObject;
import tbclient.UserManChannelInfo;
/* loaded from: classes3.dex */
public class UserVideoChannelInfoData implements Serializable {
    public static final long serialVersionUID = 1412620310378110L;
    public int followChannel;
    public int manChannel;

    public int getFollowChannel() {
        return this.followChannel;
    }

    public int getManChannel() {
        return this.manChannel;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.manChannel = jSONObject.optInt("man_channel", 0);
        this.followChannel = jSONObject.optInt("follow_channel", 0);
    }

    public void parserProtobuf(UserManChannelInfo userManChannelInfo) {
        if (userManChannelInfo == null) {
            return;
        }
        Integer num = userManChannelInfo.man_channel;
        if (num != null) {
            this.manChannel = num.intValue();
        }
        Integer num2 = userManChannelInfo.follow_channel;
        if (num2 != null) {
            this.followChannel = num2.intValue();
        }
    }
}
