package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class a {
    private int ked = 1;
    private final List<x> kee = new ArrayList();

    public a() {
        List<x> cPP = cPP();
        if (!y.isEmpty(cPP)) {
            this.kee.addAll(cPP);
        }
    }

    private List<x> cPP() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.brQ().getString("key_index_tab_info_list", "[]"));
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

    public List<x> cPQ() {
        return this.kee;
    }

    public int cPR() {
        return this.ked;
    }
}
