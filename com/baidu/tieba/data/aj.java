package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class aj {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f972a = new ArrayList();

    public ArrayList a() {
        return this.f972a;
    }

    public void a(ai aiVar) {
        if (this.f972a != null) {
            this.f972a.add(aiVar);
        }
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    ai aiVar = new ai();
                    aiVar.a(jSONArray.getJSONObject(i));
                    this.f972a.add(aiVar);
                } catch (Exception e) {
                    com.baidu.tieba.util.aj.b("LikeForumListData", "parserJson", "error = " + e.getMessage());
                    return;
                }
            }
        }
    }
}
