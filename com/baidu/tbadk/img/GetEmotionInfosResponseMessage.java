package com.baidu.tbadk.img;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GetEmotionInfosResponseMessage extends JsonHttpResponsedMessage {
    private List<c> mEmotionList;

    public GetEmotionInfosResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            parseEmotionImages(jSONObject.optJSONArray(SocialConstants.PARAM_IMAGE));
        }
    }

    private void parseEmotionImages(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.mEmotionList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    this.mEmotionList.add(c.cU(jSONArray.getJSONObject(i)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<c> getEmotionList() {
        return this.mEmotionList;
    }
}
