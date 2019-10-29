package com.baidu.tieba.channel.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {
    private boolean hasMore;
    private List<f> mItems = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.hasMore = jSONObject.optInt("has_more", 0) == 1;
                JSONArray optJSONArray = jSONObject.optJSONArray("channel_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        f fVar = new f();
                        fVar.parserJson(optJSONArray.getJSONObject(i));
                        this.mItems.add(fVar);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public List<f> getItems() {
        return this.mItems;
    }
}
