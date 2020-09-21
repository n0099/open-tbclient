package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Personalized.LiveAnswer;
/* loaded from: classes21.dex */
public class h extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public String aEb;
    public int akq;
    public int iYH;
    public String imgUrl;

    public void a(LiveAnswer liveAnswer) {
        if (liveAnswer != null) {
            this.imgUrl = liveAnswer.banner_url;
            this.iYH = liveAnswer.banner_high.intValue();
            this.akq = liveAnswer.banner_width.intValue();
            this.aEb = liveAnswer.jump_url;
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("img_width", this.akq);
            jSONObject.put(BigdayActivityConfig.IMG_URL, this.imgUrl);
            jSONObject.put("img_height", this.iYH);
            jSONObject.put(BigdayActivityConfig.JUMP_URL, this.aEb);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
