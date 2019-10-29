package com.baidu.tieba.channel.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    private boolean hasMore = true;
    private List<i> mItems = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.hasMore = jSONObject.optInt("has_more", 0) == 1;
                JSONArray optJSONArray = jSONObject.optJSONArray("fans_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        i iVar = new i();
                        iVar.parserJson(optJSONArray.getJSONObject(i));
                        this.mItems.add(iVar);
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

    public List<i> getItems() {
        return this.mItems;
    }
}
