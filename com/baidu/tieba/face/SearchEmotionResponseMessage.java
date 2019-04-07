package com.baidu.tieba.face;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.face.data.EmotionImageData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SearchEmotionResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.face.data.a mData;

    public SearchEmotionResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.mData = new com.baidu.tieba.face.data.a();
            JSONObject optJSONObject = jSONObject.optJSONObject("page");
            if (optJSONObject != null) {
                this.mData.setPage(optJSONObject.optInt("current_pn"));
                this.mData.setHasMore(optJSONObject.optInt("has_more"));
            }
            this.mData.bB(parseImageData(jSONObject.optJSONArray(IntentConfig.LIST)));
        }
    }

    private List<EmotionImageData> parseImageData(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                EmotionImageData emotionImageData = new EmotionImageData();
                emotionImageData.setPicUrl(jSONObject.optString("pic_url"));
                emotionImageData.setThumbUrl(jSONObject.optString("thumbnail"));
                emotionImageData.setWidth(jSONObject.optInt("width"));
                emotionImageData.setHeight(jSONObject.optInt("height"));
                emotionImageData.setMemeContSign(jSONObject.optString("cont_sign"));
                arrayList.add(emotionImageData);
            } catch (JSONException e) {
                e.printStackTrace();
                return arrayList;
            }
        }
        return arrayList;
    }

    public com.baidu.tieba.face.data.a getData() {
        return this.mData;
    }
}
