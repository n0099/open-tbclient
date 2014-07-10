package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.model.Hao123Model;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class aa {
    private ArrayList<z> a = new ArrayList<>();
    private boolean b;
    private int c;

    public ArrayList<z> a() {
        return this.a;
    }

    public void a(int i) {
        this.c = i;
    }

    public boolean b() {
        return this.b;
    }

    public void c() {
        Iterator<z> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(0);
        }
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                Hao123Model.setHao123Cache(Hao123Model.getHao123JosnStr(Hao123Model.parserLikeForums(jSONArray)));
                for (int i = 0; i < jSONArray.length(); i++) {
                    z zVar = new z();
                    zVar.a(jSONArray.getJSONObject(i));
                    if (zVar.d() >= this.c) {
                        this.b = true;
                    }
                    this.a.add(zVar);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
