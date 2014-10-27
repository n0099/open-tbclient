package com.baidu.tieba.im.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ChatRoomEventData {
    public String mContent;
    public int mEventId;
    public int mGroupId;
    public int mMaxUserNum;
    public String mPortrait;
    public String mTitle;
    public int mUserId;
    public String mUserMsg;
    public String mUserName;
    public int mUserNum;

    private ChatRoomEventData(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mUserMsg = jSONObject.optString("userMsg");
            this.mEventId = com.baidu.adp.lib.g.c.f(jSONObject.optString("eventId"), 0);
            JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
            if (optJSONObject != null) {
                this.mGroupId = com.baidu.adp.lib.g.c.f(optJSONObject.optString("groupId"), 0);
                this.mUserId = com.baidu.adp.lib.g.c.f(optJSONObject.optString("userId"), 0);
                this.mUserNum = com.baidu.adp.lib.g.c.f(optJSONObject.optString("userNum"), 0);
                this.mMaxUserNum = com.baidu.adp.lib.g.c.f(optJSONObject.optString("maxUserNum"), 0);
                this.mTitle = optJSONObject.optString("title");
                this.mContent = optJSONObject.optString("content");
                this.mUserName = optJSONObject.optString("userName");
                this.mPortrait = optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ChatRoomEventData parseFromEventContent(String str) {
        return new ChatRoomEventData(str);
    }
}
