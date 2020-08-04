package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class c {
    public int hWM;
    public b hWW;
    public List<q> hWX;
    public boolean hasMore;

    public c(JSONObject jSONObject) {
        int length;
        if (jSONObject != null) {
            this.hWM = jSONObject.optInt("current_pn");
            this.hasMore = jSONObject.optInt("has_more", 0) == 1;
            JSONObject optJSONObject = jSONObject.optJSONObject("main_comment");
            if (optJSONObject != null) {
                this.hWW = new b(optJSONObject);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("sub_comment");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                this.hWX = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    d dVar = new d(optJSONArray.optJSONObject(i));
                    if (dVar != null) {
                        this.hWX.add(dVar);
                    }
                }
            }
        }
    }
}
