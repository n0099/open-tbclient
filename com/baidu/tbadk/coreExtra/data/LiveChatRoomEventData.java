package com.baidu.tbadk.coreExtra.data;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class LiveChatRoomEventData {
    public String mEventId;
    public int mGroupId;
    public String mIntro;
    public boolean mIsBgChanged;
    public List<MetaData> mLikeUserList = new ArrayList();
    public int mLikers;
    public int mListeners;
    public String mName;
    public String mPortrait;
    public String mSignature;
    public String mUserMsg;

    private LiveChatRoomEventData(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mUserMsg = jSONObject.optString("userMsg");
            this.mEventId = jSONObject.optString("eventId");
            JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
            if (optJSONObject != null) {
                this.mGroupId = com.baidu.adp.lib.g.b.g(optJSONObject.optString("groupId"), 0);
                this.mListeners = com.baidu.adp.lib.g.b.g(optJSONObject.optString("listeners"), 0);
                this.mLikers = com.baidu.adp.lib.g.b.g(optJSONObject.optString("likes"), 0);
                JSONArray optJSONArray = optJSONObject.optJSONArray("users");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        MetaData metaData = new MetaData();
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        metaData.setUserId(optJSONObject2.optString("user_id"));
                        metaData.setUserName(optJSONObject2.optString("user_name"));
                        metaData.setPortrait(optJSONObject2.optString(IntentConfig.PORTRAIT));
                        this.mLikeUserList.add(metaData);
                    }
                }
                this.mName = optJSONObject.optString("name");
                this.mPortrait = optJSONObject.optString(IntentConfig.PORTRAIT);
                this.mIntro = optJSONObject.optString("intro");
                this.mSignature = optJSONObject.optString("signature");
                this.mIsBgChanged = optJSONObject.optInt("bgChanged", 0) == 1;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static LiveChatRoomEventData parseFromEventContent(String str) {
        return new LiveChatRoomEventData(str);
    }
}
