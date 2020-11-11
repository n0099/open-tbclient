package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Personalized.LiveAnswer;
/* loaded from: classes22.dex */
public class h extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public String aIk;
    public int akJ;
    public String imgUrl;
    public int jGd;

    public void a(LiveAnswer liveAnswer) {
        if (liveAnswer != null) {
            this.imgUrl = liveAnswer.banner_url;
            this.jGd = liveAnswer.banner_high.intValue();
            this.akJ = liveAnswer.banner_width.intValue();
            this.aIk = liveAnswer.jump_url;
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("img_width", this.akJ);
            jSONObject.put(BigdayActivityConfig.IMG_URL, this.imgUrl);
            jSONObject.put("img_height", this.jGd);
            jSONObject.put(BigdayActivityConfig.JUMP_URL, this.aIk);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
