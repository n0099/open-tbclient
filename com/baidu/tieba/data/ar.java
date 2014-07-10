package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class ar {
    private ArrayList<ae> a;

    public ar() {
        a(new ArrayList<>());
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    ae aeVar = new ae();
                    aeVar.a(jSONArray.getJSONObject(i));
                    this.a.add(aeVar);
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
        }
    }

    public ArrayList<ae> a() {
        return this.a;
    }

    public void a(ArrayList<ae> arrayList) {
        this.a = arrayList;
    }
}
