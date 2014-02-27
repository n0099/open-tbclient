package com.baidu.tieba.data;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes.dex */
public final class ae {
    private ArrayList<ad> a = new ArrayList<>();
    private boolean b;
    private int c;

    public final ArrayList<ad> a() {
        return this.a;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final boolean b() {
        return this.b;
    }

    public final void c() {
        Iterator<ad> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(0);
        }
    }

    public final void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    ad adVar = new ad();
                    adVar.a(jSONArray.getJSONObject(i));
                    if (adVar.d() >= this.c) {
                        this.b = true;
                    }
                    this.a.add(adVar);
                } catch (Exception e) {
                    com.baidu.adp.lib.util.e.b("LikeForumListData", "parserJson", "error = " + e.getMessage());
                    return;
                }
            }
        }
    }
}
