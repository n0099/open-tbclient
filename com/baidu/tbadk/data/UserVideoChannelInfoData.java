package com.baidu.tbadk.data;

import java.io.Serializable;
import org.json.JSONObject;
import tbclient.UserManChannelInfo;
/* loaded from: classes.dex */
public class UserVideoChannelInfoData implements Serializable {
    private static final long serialVersionUID = 1412620310378110L;
    private int followChannel;
    private int manChannel;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.manChannel = jSONObject.optInt("man_channel", 0);
            this.followChannel = jSONObject.optInt("follow_channel", 0);
        }
    }

    public void parserProtobuf(UserManChannelInfo userManChannelInfo) {
        if (userManChannelInfo != null) {
            if (userManChannelInfo.man_channel != null) {
                this.manChannel = userManChannelInfo.man_channel.intValue();
            }
            if (userManChannelInfo.follow_channel != null) {
                this.followChannel = userManChannelInfo.follow_channel.intValue();
            }
        }
    }

    public int getManChannel() {
        return this.manChannel;
    }

    public int getFollowChannel() {
        return this.followChannel;
    }
}
