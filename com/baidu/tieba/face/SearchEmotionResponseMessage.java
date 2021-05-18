package com.baidu.tieba.face;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.face.data.EmotionImageData;
import d.a.k0.k0.c.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SearchEmotionResponseMessage extends JsonHttpResponsedMessage {
    public a mData;

    public SearchEmotionResponseMessage(int i2) {
        super(i2);
    }

    private List<EmotionImageData> parseImageData(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                EmotionImageData emotionImageData = new EmotionImageData();
                emotionImageData.setPicUrl(jSONObject.optString("pic_url"));
                emotionImageData.setThumbUrl(jSONObject.optString("thumbnail"));
                emotionImageData.setWidth(jSONObject.optInt("width"));
                emotionImageData.setHeight(jSONObject.optInt("height"));
                emotionImageData.setMemeContSign(jSONObject.optString("cont_sign"));
                arrayList.add(emotionImageData);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.mData = new a();
            JSONObject optJSONObject = jSONObject.optJSONObject("page");
            if (optJSONObject != null) {
                this.mData.f(optJSONObject.optInt("current_pn"));
                this.mData.e(optJSONObject.optInt("has_more"));
            }
            this.mData.d(parseImageData(jSONObject.optJSONArray("list")));
        }
    }

    public a getData() {
        return this.mData;
    }
}
