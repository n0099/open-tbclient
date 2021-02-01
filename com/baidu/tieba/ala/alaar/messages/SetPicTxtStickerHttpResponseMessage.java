package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.data.AlaLiveStickerInfo;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class SetPicTxtStickerHttpResponseMessage extends JsonHttpResponsedMessage {
    private List<AlaLiveStickerInfo> mAlaLiveStickerList;

    public SetPicTxtStickerHttpResponseMessage() {
        super(1021206);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        this.mAlaLiveStickerList = null;
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("sticker_info");
            if (optJSONArray != null) {
                this.mAlaLiveStickerList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    try {
                        this.mAlaLiveStickerList.add(AlaLiveStickerInfo.parse(optJSONArray.getJSONObject(i2)));
                    } catch (JSONException e) {
                        return;
                    }
                }
                return;
            }
            this.mAlaLiveStickerList = null;
        }
    }

    public List<AlaLiveStickerInfo> getData() {
        return this.mAlaLiveStickerList;
    }
}
