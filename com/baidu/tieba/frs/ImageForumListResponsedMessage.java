package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ImageForumListResponsedMessage extends JsonHttpResponsedMessage {
    public AntiData mAnti;
    public int mCurrentCount;
    public ForumData mForum;
    public int mHasMore;
    public ArrayList<String> mIdList;
    public JSONObject mJSONObject;
    public com.baidu.tieba.data.ad mOwner;
    public ArrayList<com.baidu.tieba.data.at> mThread;
    public int mTotal;

    public ImageForumListResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            parserJson(jSONObject);
        }
        this.mJSONObject = jSONObject;
    }

    private void initData() {
        this.mForum = new ForumData();
        this.mThread = new ArrayList<>();
        this.mIdList = new ArrayList<>();
        this.mHasMore = 0;
        this.mTotal = 0;
        this.mCurrentCount = 0;
        this.mAnti = new AntiData();
        this.mOwner = new com.baidu.tieba.data.ad();
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                initData();
                this.mForum.parserJson(jSONObject.optJSONObject("forum"));
                this.mOwner.a(jSONObject.optJSONObject("user"));
                this.mAnti.parserJson(jSONObject.optJSONObject("anti"));
                JSONObject optJSONObject = jSONObject.optJSONObject("photo_data");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("thread_list");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            com.baidu.tieba.data.at atVar = new com.baidu.tieba.data.at();
                            atVar.a(optJSONArray.optJSONObject(i));
                            this.mThread.add(atVar);
                        }
                    }
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("alb_id_list");
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            this.mIdList.add(optJSONArray2.optString(i2));
                        }
                    }
                    this.mHasMore = optJSONObject.optInt("has_more", 0);
                    this.mTotal = optJSONObject.optInt("amount", 0);
                    this.mCurrentCount = optJSONObject.optInt("current_count", 0);
                }
            } catch (Exception e) {
            }
        }
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
        }
    }
}
