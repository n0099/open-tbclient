package com.baidu.tieba.data;

import com.baidu.tieba.util.bg;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class af {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<ae> f1160a = new ArrayList<>();
    private boolean b;
    private int c;

    public ArrayList<ae> a() {
        return this.f1160a;
    }

    public void a(int i) {
        this.c = i;
    }

    public boolean b() {
        return this.b;
    }

    public void c() {
        Iterator<ae> it = this.f1160a.iterator();
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
                    this.f1160a.add(aeVar);
                } catch (Exception e) {
                    bg.b("LikeForumListData", "parserJson", "error = " + e.getMessage());
                    return;
                }
            }
        }
    }
}
