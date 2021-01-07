package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.coreExtra.data.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class a {
    private int kaT = 1;
    private final List<x> kaU = new ArrayList();

    public a() {
        List<x> cRD = cRD();
        if (!com.baidu.tbadk.core.util.x.isEmpty(cRD)) {
            this.kaU.addAll(cRD);
        }
    }

    private List<x> cRD() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.bvr().getString("key_index_tab_info_list", "[]"));
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

    public List<x> cRE() {
        return this.kaU;
    }

    public int cRF() {
        return this.kaT;
    }
}
