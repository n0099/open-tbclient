package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Personalized.LiveAnswer;
/* loaded from: classes6.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public String aou;
    public int ewS;
    public int ewT;
    public String imgUrl;

    public void a(LiveAnswer liveAnswer) {
        if (liveAnswer != null) {
            this.imgUrl = liveAnswer.banner_url;
            this.ewS = liveAnswer.banner_high.intValue();
            this.ewT = liveAnswer.banner_width.intValue();
            this.aou = liveAnswer.jump_url;
        }
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return TYPE;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("img_width", this.ewT);
            jSONObject.put(BigdayActivityConfig.IMG_URL, this.imgUrl);
            jSONObject.put("img_height", this.ewS);
            jSONObject.put(BigdayActivityConfig.JUMP_URL, this.aou);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
