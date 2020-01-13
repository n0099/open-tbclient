package com.baidu.tieba.ala.liveroom.yuangift;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.gift.g;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CashGiftHttpResponseMessage extends JsonHttpResponsedMessage {
    public int abE;
    public int abF;
    public int abG;
    public long dubi;
    public g fli;
    public String flj;
    public int flk;
    public String iconId;
    public long nonMemberT;
    public int photoHeight;
    public String photoUrl;
    public int photoWidth;
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
                this.fli = new g();
                this.fli.parseJson(optJSONObject3);
            }
            this.previewGiftId = optJSONObject.optInt("preview_gift_id");
            this.photoUrl = optJSONObject.optString("photo_url");
            this.productId = optJSONObject.optString("product_id");
            this.iconId = optJSONObject.optString("icon_id");
            this.nonMemberT = optJSONObject.optLong("non_member_t");
            this.dubi = optJSONObject.optLong("dubi");
            this.photoWidth = optJSONObject.optInt("photo_width");
            this.photoHeight = optJSONObject.optInt("photo_height");
            this.flj = optJSONObject.optString("back_ground");
            this.flk = optJSONObject.optInt("premium_user");
            if (optJSONObject.has("cash_gift") && (optJSONObject2 = optJSONObject.optJSONObject("cash_gift")) != null) {
                this.abE = optJSONObject2.optInt("show_times_daily");
                this.abF = optJSONObject2.optInt("continue_show_times");
                this.abG = optJSONObject2.optInt("condition");
            }
        }
    }
}
