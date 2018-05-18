package com.baidu.tieba.channel.data;

import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private boolean hasMore = true;
    private List<b> mItems = new ArrayList();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        b bVar = new b();
                        bVar.parserJson(optJSONArray.getJSONObject(i));
                        bVar.ey(false);
                        this.mItems.add(bVar);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(WBPageConstants.ParamKey.PAGE);
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
        return this.mItems;
    }
}
