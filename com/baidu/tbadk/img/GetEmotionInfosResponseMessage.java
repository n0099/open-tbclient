package com.baidu.tbadk.img;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.tencent.open.SocialConstants;
import d.b.h0.b0.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetEmotionInfosResponseMessage extends JsonHttpResponsedMessage {
    public List<c> mEmotionList;

    public GetEmotionInfosResponseMessage(int i) {
        super(i);
    }

    private void parseEmotionImages(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        this.mEmotionList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                this.mEmotionList.add(c.a(jSONArray.getJSONObject(i)));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            parseEmotionImages(jSONObject.optJSONArray(SocialConstants.PARAM_IMAGE));
        }
    }

    public List<c> getEmotionList() {
        return this.mEmotionList;
    }
}
