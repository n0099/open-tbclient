package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes21.dex */
public class a {
    private int jAb = 1;
    private final List<x> jAc = new ArrayList();

    public a() {
        List<x> cJg = cJg();
        if (!y.isEmpty(cJg)) {
            this.jAc.addAll(cJg);
        }
    }

    private List<x> cJg() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.bpu().getString("key_index_tab_info_list", "[]"));
            for (int i = 0; i < jSONArray.length(); i++) {
                x xVar = new x();
                xVar.parserJson(jSONArray.getJSONObject(i));
                if (!xVar.isDirtyData()) {
                    arrayList.add(xVar);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public List<x> cJh() {
        return this.jAc;
    }

    public int cJi() {
        return this.jAb;
    }
}
