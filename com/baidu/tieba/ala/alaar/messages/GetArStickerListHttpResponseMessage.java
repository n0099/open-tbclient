package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GetArStickerListHttpResponseMessage extends JsonHttpResponsedMessage {
    public static String gsz = "live_face";
    public List<FuFaceItem> gsy;

    public GetArStickerListHttpResponseMessage() {
        super(1021155);
        this.gsy = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0) {
            Object opt = jSONObject.opt("data");
            if (JSONObject.NULL.equals(opt)) {
                opt = null;
            }
            if (opt != null && (opt instanceof JSONArray)) {
                JSONArray jSONArray = (JSONArray) opt;
                if (this.gsy == null) {
                    this.gsy = new ArrayList();
                } else {
                    this.gsy.clear();
                }
                FuFaceItem fuFaceItem = new FuFaceItem();
                fuFaceItem.isCancelItem = true;
                fuFaceItem.getSticker().setId("cancelItem");
                if (this.gsy != null) {
                    this.gsy.add(fuFaceItem);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        FuFaceItem fuFaceItem2 = new FuFaceItem();
                        fuFaceItem2.parse(optJSONObject);
                        this.gsy.add(fuFaceItem2);
                    }
                }
            }
        }
    }
}
