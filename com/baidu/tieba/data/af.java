package com.baidu.tieba.data;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class af {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<ae> f996a = new ArrayList<>();

    public ArrayList<ae> a() {
        return this.f996a;
    }

    public void b() {
        Iterator<ae> it = this.f996a.iterator();
        while (it.hasNext()) {
            it.next().a(0);
        }
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    ae aeVar = new ae();
                    aeVar.a(jSONArray.getJSONObject(i));
                    this.f996a.add(aeVar);
                } catch (Exception e) {
                    com.baidu.tieba.util.av.b("LikeForumListData", "parserJson", "error = " + e.getMessage());
                    return;
                }
            }
        }
    }
}
