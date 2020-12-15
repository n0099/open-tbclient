package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tieba.card.data.BaseCardInfo;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Personalized.LiveAnswer;
/* loaded from: classes22.dex */
public class h extends BaseCardInfo {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public String aJj;
    public int alO;
    public String imgUrl;
    public int jUH;

    public void a(LiveAnswer liveAnswer) {
        if (liveAnswer != null) {
            this.imgUrl = liveAnswer.banner_url;
            this.jUH = liveAnswer.banner_high.intValue();
            this.alO = liveAnswer.banner_width.intValue();
            this.aJj = liveAnswer.jump_url;
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("img_width", this.alO);
            jSONObject.put(BigdayActivityConfig.IMG_URL, this.imgUrl);
            jSONObject.put("img_height", this.jUH);
            jSONObject.put(BigdayActivityConfig.JUMP_URL, this.aJj);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
