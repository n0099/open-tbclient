package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class an {
    private ArrayList<ac> a;

    public an() {
        a(new ArrayList<>());
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    ac acVar = new ac();
                    acVar.a(jSONArray.getJSONObject(i));
                    this.a.add(acVar);
                } catch (Exception e) {
                    BdLog.e("LikeForumListData", "parserJson", "error = " + e.getMessage());
                    return;
                }
            }
        }
    }

    public ArrayList<ac> a() {
        return this.a;
    }

    public void a(ArrayList<ac> arrayList) {
        this.a = arrayList;
    }
}
