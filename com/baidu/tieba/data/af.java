package com.baidu.tieba.data;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class af {
    private ArrayList<ae> a = new ArrayList<>();
    private boolean b;
    private int c;

    public ArrayList<ae> a() {
        return this.a;
    }

    public void a(int i) {
        this.c = i;
    }

    public boolean b() {
        return this.b;
    }

    public void c() {
        Iterator<ae> it = this.a.iterator();
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
                    if (aeVar.d() >= this.c) {
                        this.b = true;
                    }
                    this.a.add(aeVar);
                } catch (Exception e) {
                    com.baidu.adp.lib.g.e.b("LikeForumListData", "parserJson", "error = " + e.getMessage());
                    return;
                }
            }
        }
    }
}
