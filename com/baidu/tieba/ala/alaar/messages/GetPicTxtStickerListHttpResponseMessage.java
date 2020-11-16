package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.baidu.tieba.ala.alaar.sticker.model.PicStickerItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetPicTxtStickerListHttpResponseMessage extends JsonHttpResponsedMessage {
    public List<FuFaceItem> gbL;

    public GetPicTxtStickerListHttpResponseMessage() {
        super(1021156);
        this.gbL = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0) {
            Object opt = jSONObject.opt("data");
            if (JSONObject.NULL.equals(opt)) {
                opt = null;
            }
            if (opt != null) {
                JSONArray jSONArray = (JSONArray) opt;
                if (this.gbL == null) {
                    this.gbL = new ArrayList();
                }
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    PicStickerItem picStickerItem = new PicStickerItem();
                    picStickerItem.parse(optJSONObject);
                    this.gbL.add(picStickerItem);
                }
            }
        }
    }
}
