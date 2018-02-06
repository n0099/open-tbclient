package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Personalized.LiveAnswer;
/* loaded from: classes2.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public int ekE;
    public int ekF;
    public String imgUrl;

    public void a(LiveAnswer liveAnswer) {
        if (liveAnswer != null) {
            this.imgUrl = liveAnswer.banner_url;
            this.ekE = liveAnswer.banner_high.intValue();
            this.ekF = liveAnswer.banner_width.intValue();
        }
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return TYPE;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("img_width", this.ekF);
            jSONObject.put("img_url", this.imgUrl);
            jSONObject.put("img_height", this.ekE);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
