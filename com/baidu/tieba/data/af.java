package com.baidu.tieba.data;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class af {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f978a = new ArrayList();

    public ArrayList a() {
        return this.f978a;
    }

    public void b() {
        Iterator it = this.f978a.iterator();
        while (it.hasNext()) {
            ((ae) it.next()).a(0);
        }
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    ae aeVar = new ae();
                    aeVar.a(jSONArray.getJSONObject(i));
                    this.f978a.add(aeVar);
                } catch (Exception e) {
                    com.baidu.tieba.util.aq.b("LikeForumListData", "parserJson", "error = " + e.getMessage());
                    return;
                }
            }
        }
    }
}
