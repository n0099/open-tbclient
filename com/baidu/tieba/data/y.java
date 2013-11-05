package com.baidu.tieba.data;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<MetaData> f1182a = new ArrayList<>();
    private HashMap<String, String> b = null;

    public void a(JSONObject jSONObject, boolean z) {
        if (jSONObject != null) {
            if (z) {
                try {
                    if (this.b == null) {
                        this.b = new HashMap<>();
                    }
                } catch (Exception e) {
                    com.baidu.tieba.util.be.b("FriendData", "parserFreindJson", "error = " + e.getMessage());
                    return;
                }
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    MetaData metaData = new MetaData();
                    metaData.parserJson(optJSONArray.getJSONObject(i));
                    if (metaData.getName_show() != null) {
                        this.f1182a.add(metaData);
                        if (z) {
                            this.b.put(metaData.getName_show(), metaData.getPortrait());
                        }
                    }
                }
            }
        }
    }

    public void a(String str) {
        try {
            a(new JSONObject(str), true);
        } catch (Exception e) {
            com.baidu.tieba.util.be.b("FriendData", "parserFreindJson", "error = " + e.getMessage());
        }
    }

    public ArrayList<MetaData> a() {
        return this.f1182a;
    }

    public HashMap<String, String> b() {
        return this.b;
    }
}
