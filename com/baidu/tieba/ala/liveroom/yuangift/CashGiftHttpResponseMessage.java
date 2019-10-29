package com.baidu.tieba.ala.liveroom.yuangift;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.gift.g;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class CashGiftHttpResponseMessage extends JsonHttpResponsedMessage {
    public int UF;
    public int UG;
    public int UH;
    public long dubi;
    public g est;
    public String esu;
    public int esv;
    public int esw;
    public int esx;
    public String iconId;
    public long nonMemberT;
    public String photoUrl;
    public int previewGiftId;
    public String productId;

    public CashGiftHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("gift_info");
            if (optJSONObject3 != null) {
                this.est = new g();
                this.est.parseJson(optJSONObject3);
            }
            this.previewGiftId = optJSONObject.optInt("preview_gift_id");
            this.photoUrl = optJSONObject.optString("photo_url");
            this.productId = optJSONObject.optString("product_id");
            this.iconId = optJSONObject.optString("icon_id");
            this.nonMemberT = optJSONObject.optLong("non_member_t");
            this.dubi = optJSONObject.optLong("dubi");
            this.esw = optJSONObject.optInt("photo_width");
            this.esv = optJSONObject.optInt("photo_height");
            this.esu = optJSONObject.optString("back_ground");
            this.esx = optJSONObject.optInt("premium_user");
            if (optJSONObject.has("cash_gift") && (optJSONObject2 = optJSONObject.optJSONObject("cash_gift")) != null) {
                this.UF = optJSONObject2.optInt("show_times_daily");
                this.UG = optJSONObject2.optInt("continue_show_times");
                this.UH = optJSONObject2.optInt("condition");
            }
        }
    }
}
