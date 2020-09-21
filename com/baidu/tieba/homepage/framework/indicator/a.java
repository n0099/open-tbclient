package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes21.dex */
public class a {
    private int iRR = 1;
    private final List<x> iRS = new ArrayList();

    public a() {
        List<x> cAm = cAm();
        if (!y.isEmpty(cAm)) {
            this.iRS.addAll(cAm);
        }
    }

    private List<x> cAm() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.bjf().getString("key_index_tab_info_list", "[]"));
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

    public List<x> cAn() {
        return this.iRS;
    }

    public int cAo() {
        return this.iRR;
    }
}
