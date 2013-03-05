package com.baidu.tieba.b;

import com.baidu.tieba.c.ag;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
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
                if (((n) this.a.get(i2)).a() == 1 && ((n) this.a.get(i2)).d().equals(str)) {
                    ((n) this.a.get(i2)).a(true);
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
        n nVar = null;
        try {
            int size = this.a.size();
            if (size > 0) {
                nVar = (n) this.a.get(size - 1);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i = 0;
                n nVar2 = nVar;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    n nVar3 = new n(this);
                    nVar3.c = optJSONObject.optString("fname");
                    nVar3.b = optJSONObject.optString("distance");
                    nVar3.d = optJSONObject.optString("fid");
                    nVar3.e = optJSONObject.optInt("heat", 0);
                    nVar3.g = optJSONObject.optInt("member_count", 0);
                    nVar3.h = optJSONObject.optInt("post_num", 0);
                    nVar3.f = optJSONObject.optInt("is_like", 0) == 1;
                    nVar3.a = 1;
                    if (nVar2 != null && nVar3.b.equals(nVar2.b)) {
                        this.a.add(nVar3);
                    } else {
                        n nVar4 = new n(this);
                        nVar4.b = nVar3.b;
                        nVar4.a = 0;
                        this.a.add(nVar4);
                        this.a.add(nVar3);
                    }
                    i++;
                    nVar2 = nVar3;
                }
            }
        } catch (Exception e) {
            ag.b("NearbyForumListModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
