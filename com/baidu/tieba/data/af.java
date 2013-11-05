package com.baidu.tieba.data;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class af {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<ae> f1126a = new ArrayList<>();

    public ArrayList<ae> a() {
        return this.f1126a;
    }

    public void b() {
        Iterator<ae> it = this.f1126a.iterator();
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
                    this.f1126a.add(aeVar);
                } catch (Exception e) {
                    com.baidu.tieba.util.be.b("LikeForumListData", "parserJson", "error = " + e.getMessage());
                    return;
                }
            }
        }
    }
}
