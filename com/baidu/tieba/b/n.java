package com.baidu.tieba.b;

import com.baidu.tieba.c.ag;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
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
                if (((o) this.a.get(i2)).a() == 1 && ((o) this.a.get(i2)).d().equals(str)) {
                    ((o) this.a.get(i2)).a(true);
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
            ag.b("NearbyForumListModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        o oVar = null;
        try {
            int size = this.a.size();
            if (size > 0) {
                oVar = (o) this.a.get(size - 1);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i = 0;
                o oVar2 = oVar;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    o oVar3 = new o(this);
                    oVar3.c = optJSONObject.optString("fname");
                    oVar3.b = optJSONObject.optString("distance");
                    oVar3.d = optJSONObject.optString("fid");
                    oVar3.e = optJSONObject.optInt("heat", 0);
                    oVar3.g = optJSONObject.optInt("member_count", 0);
                    oVar3.h = optJSONObject.optInt("post_num", 0);
                    oVar3.f = optJSONObject.optInt("is_like", 0) == 1;
                    oVar3.a = 1;
                    if (oVar2 != null && oVar3.b.equals(oVar2.b)) {
                        this.a.add(oVar3);
                    } else {
                        o oVar4 = new o(this);
                        oVar4.b = oVar3.b;
                        oVar4.a = 0;
                        this.a.add(oVar4);
                        this.a.add(oVar3);
                    }
                    i++;
                    oVar2 = oVar3;
                }
            }
        } catch (Exception e) {
            ag.b("NearbyForumListModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
