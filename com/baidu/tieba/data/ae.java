package com.baidu.tieba.data;

import com.baidu.tieba.util.bg;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class ae {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<ad> f1165a = new ArrayList<>();
    private boolean b;
    private int c;

    public ArrayList<ad> a() {
        return this.f1165a;
    }

    public void a(int i) {
        this.c = i;
    }

    public boolean b() {
        return this.b;
    }

    public void c() {
        Iterator<ad> it = this.f1165a.iterator();
        while (it.hasNext()) {
            it.next().a(0);
        }
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    ad adVar = new ad();
                    adVar.a(jSONArray.getJSONObject(i));
                    if (adVar.d() >= this.c) {
                        this.b = true;
                    }
                    this.f1165a.add(adVar);
                } catch (Exception e) {
                    bg.b("LikeForumListData", "parserJson", "error = " + e.getMessage());
                    return;
                }
            }
        }
    }
}
