package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetArStickerListHttpResponseMessage extends JsonHttpResponsedMessage {
    public static String gbK = "live_face";
    public List<FuFaceItem> gbJ;

    public GetArStickerListHttpResponseMessage() {
        super(1021155);
        this.gbJ = null;
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
                if (this.gbJ == null) {
                    this.gbJ = new ArrayList();
                } else {
                    this.gbJ.clear();
                }
                FuFaceItem fuFaceItem = new FuFaceItem();
                fuFaceItem.isCancelItem = true;
                fuFaceItem.getSticker().setId("cancelItem");
                if (this.gbJ != null) {
                    this.gbJ.add(fuFaceItem);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        FuFaceItem fuFaceItem2 = new FuFaceItem();
                        fuFaceItem2.parse(optJSONObject);
                        this.gbJ.add(fuFaceItem2);
                    }
                }
            }
        }
    }
}
