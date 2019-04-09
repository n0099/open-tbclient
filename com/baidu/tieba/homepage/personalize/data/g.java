package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Personalized.LiveAnswer;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public int aam;
    public String bvM;
    public int fNi;
    public String imgUrl;

    public void a(LiveAnswer liveAnswer) {
        if (liveAnswer != null) {
            this.imgUrl = liveAnswer.banner_url;
            this.fNi = liveAnswer.banner_high.intValue();
            this.aam = liveAnswer.banner_width.intValue();
            this.bvM = liveAnswer.jump_url;
        }
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("img_width", this.aam);
            jSONObject.put(BigdayActivityConfig.IMG_URL, this.imgUrl);
            jSONObject.put("img_height", this.fNi);
            jSONObject.put(BigdayActivityConfig.JUMP_URL, this.bvM);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
