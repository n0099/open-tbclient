package com.baidu.tieba.c;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aq {
    private ArrayList a = new ArrayList();

    public ArrayList a() {
        return this.a;
    }

    public void a(ArrayList arrayList) {
        this.a = arrayList;
    }

    public void a(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.a.size()) {
                if (((ar) this.a.get(i2)).a() == 1 && ((ar) this.a.get(i2)).d().equals(str)) {
                    ((ar) this.a.get(i2)).a(true);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void b(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("NearbyForumListModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        ar arVar = null;
        try {
            int size = this.a.size();
            if (size > 0) {
                arVar = (ar) this.a.get(size - 1);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i = 0;
                ar arVar2 = arVar;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    ar arVar3 = new ar(this);
                    arVar3.c = optJSONObject.optString("fname");
                    arVar3.b = optJSONObject.optString("distance");
                    arVar3.d = optJSONObject.optString("fid");
                    arVar3.e = optJSONObject.optInt("heat", 0);
                    arVar3.g = optJSONObject.optInt("member_count", 0);
                    arVar3.h = optJSONObject.optInt("post_num", 0);
                    arVar3.f = optJSONObject.optInt("is_like", 0) == 1;
                    arVar3.a = 1;
                    if (arVar2 != null && arVar3.b.equals(arVar2.b)) {
                        this.a.add(arVar3);
                    } else {
                        ar arVar4 = new ar(this);
                        arVar4.b = arVar3.b;
                        arVar4.a = 0;
                        this.a.add(arVar4);
                        this.a.add(arVar3);
                    }
                    i++;
                    arVar2 = arVar3;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("NearbyForumListModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
