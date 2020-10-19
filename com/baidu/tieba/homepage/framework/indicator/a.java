package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes22.dex */
public class a {
    private int jgO = 1;
    private final List<x> jgP = new ArrayList();

    public a() {
        List<x> cDT = cDT();
        if (!y.isEmpty(cDT)) {
            this.jgP.addAll(cDT);
        }
    }

    private List<x> cDT() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.blO().getString("key_index_tab_info_list", "[]"));
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

    public List<x> cDU() {
        return this.jgP;
    }

    public int cDV() {
        return this.jgO;
    }
}
