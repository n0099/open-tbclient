package com.baidu.tieba.data;

import java.util.ArrayList;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class ab {
    private ArrayList a = new ArrayList();

    public ArrayList a() {
        return this.a;
    }

    public void a(aa aaVar) {
        if (this.a != null) {
            this.a.add(aaVar);
        }
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    aa aaVar = new aa();
                    aaVar.a(jSONArray.getJSONObject(i));
                    this.a.add(aaVar);
                } catch (Exception e) {
                    com.baidu.tieba.util.z.b("LikeForumListData", "parserJson", "error = " + e.getMessage());
                    return;
                }
            }
        }
    }
}
