package com.baidu.tieba.ala.personcenter.privilege.entereffect.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.ala.gift.AlaDynamicGift;
import com.baidu.ala.gift.AlaDynamicGiftConfigInfo;
import com.baidu.ala.gift.AlaDynamicGiftZip;
import d.b.b.e.m.b;
import d.b.b.j.e.n;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaEnterEffectData implements Serializable, n {
    public static final int ALA_ENTER_EFFECT_DOWNLOADING = 102;
    public static final int ALA_ENTER_EFFECT_HAS_DOWNLOAD = 101;
    public static final int ALA_ENTER_EFFECT_NOT_DOWNLOAD = 100;
    public static final int ALA_ENTER_EFFECT_TYPE_GENERAL = 0;
    public static final int ALA_ENTER_EFFECT_TYPE_VEHICLE = 1;
    public static final BdUniqueId TYPE_ENTER_EFFECT_DATA = BdUniqueId.gen();
    public long begin_time;
    public int buy_staus;
    public int categoryType;
    public String color;
    public String content_first;
    public String content_last;
    public int downLoadStatus;
    public String effect_range_name;
    public String endColor;
    public long end_time;
    public AlaDynamicGift gift;
    public String icon_url;
    public String id;
    public boolean isOwn;
    public String name;
    public String nobilityName;
    public int nobilityType;
    public String obtain_way;
    public long price;
    public int propId;
    public String startColor;
    public String strokeColor;
    public String thumbnail_url;
    public String time;
    public int type;
    public int use_status;

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return TYPE_ENTER_EFFECT_DATA;
    }

    public boolean isUsing() {
        return this.use_status == 1;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.id = jSONObject.optString("id");
        this.type = jSONObject.optInt("type");
        this.name = jSONObject.optString("name");
        this.use_status = jSONObject.optInt("use_status");
        this.isOwn = jSONObject.optInt("is_own") == 1;
        this.color = jSONObject.optString("color");
        this.startColor = jSONObject.optString("start_color");
        this.endColor = jSONObject.optString("end_color");
        this.strokeColor = jSONObject.optString("stroke_color");
        this.icon_url = jSONObject.optString("icon_url");
        this.content_first = jSONObject.optString("content_first");
        this.content_last = jSONObject.optString("content_last");
        this.effect_range_name = jSONObject.optString("effect_range_name");
        this.end_time = jSONObject.optLong("end_time");
        this.begin_time = jSONObject.optLong("begin_time");
        this.categoryType = jSONObject.optInt("effect_type");
        this.obtain_way = jSONObject.optString("obtain_way");
        JSONObject optJSONObject = jSONObject.optJSONObject("nobility_info");
        if (optJSONObject != null) {
            this.nobilityType = optJSONObject.optInt("nobility_type");
            this.nobilityName = optJSONObject.optString("nobility_type_name");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("props_info");
        if (optJSONObject2 != null) {
            this.propId = b.d(optJSONObject2.optString("props_id"), 0);
            this.price = b.f(optJSONObject2.optString("price"), 0L);
            this.time = optJSONObject2.optString("buy_cycle");
            this.buy_staus = optJSONObject2.optInt("buy_staus");
        }
        int i = this.type;
        if (i != 1) {
            if (i == 0) {
                this.thumbnail_url = this.icon_url;
                return;
            }
            return;
        }
        this.thumbnail_url = jSONObject.optString("thumbnail_url");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("gift");
        if (optJSONObject3 != null) {
            AlaDynamicGift alaDynamicGift = new AlaDynamicGift();
            this.gift = alaDynamicGift;
            alaDynamicGift.giftId = optJSONObject3.optString("gift_id");
            this.gift.giftName = optJSONObject3.optString("gift_name");
            JSONObject optJSONObject4 = optJSONObject3.optJSONObject("gift_zip");
            if (optJSONObject4 != null) {
                this.gift.giftZip = new AlaDynamicGiftZip();
                this.gift.giftZip.parseJson(optJSONObject4);
            }
            JSONObject optJSONObject5 = optJSONObject3.optJSONObject("config_info");
            if (optJSONObject5 != null) {
                this.gift.configInfo = new AlaDynamicGiftConfigInfo();
                this.gift.configInfo.parseJson(optJSONObject5);
            }
        }
    }
}
