package com.baidu.tieba.channel.data;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private boolean hasMore = true;
    private List<b> aMK = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray(IntentConfig.LIST);
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray.getJSONObject(i));
                        bVar.hV(false);
                        this.aMK.add(bVar);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("page");
                if (optJSONObject != null) {
                    if ("0".equals(optJSONObject.optString("has_more"))) {
                        this.hasMore = false;
                    } else {
                        this.hasMore = true;
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

    public List<b> getItems() {
        return this.aMK;
    }
}
