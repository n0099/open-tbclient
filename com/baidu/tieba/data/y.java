package com.baidu.tieba.data;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes.dex */
public final class y {
    private ArrayList<x> a = new ArrayList<>();
    private boolean b;
    private int c;

    public final ArrayList<x> a() {
        return this.a;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final boolean b() {
        return this.b;
    }

    public final void c() {
        Iterator<x> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(0);
        }
    }

    public final void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    x xVar = new x();
                    xVar.a(jSONArray.getJSONObject(i));
                    if (xVar.d() >= this.c) {
                        this.b = true;
                    }
                    this.a.add(xVar);
                } catch (Exception e) {
                    com.baidu.adp.lib.util.f.b("LikeForumListData", "parserJson", "error = " + e.getMessage());
                    return;
                }
            }
        }
    }
}
