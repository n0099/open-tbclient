package com.baidu.tieba.data;

import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class r {
    private final ArrayList<MetaData> a = new ArrayList<>();
    private HashMap<String, String> b = null;

    public final void a(JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            try {
                if (this.b == null) {
                    this.b = new HashMap<>();
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        MetaData metaData = new MetaData();
                        metaData.parserJson(optJSONArray.getJSONObject(i));
                        if (metaData.getName_show() != null) {
                            this.a.add(metaData);
                            this.b.put(metaData.getName_show(), metaData.getPortrait());
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("FriendData", "parserFreindJson", "error = " + e.getMessage());
            }
        }
    }

    public final ArrayList<MetaData> a() {
        return this.a;
    }

    public final HashMap<String, String> b() {
        return this.b;
    }
}
