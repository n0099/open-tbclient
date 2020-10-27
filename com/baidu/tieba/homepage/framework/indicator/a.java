package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes22.dex */
public class a {
    private int jtm = 1;
    private final List<x> jtn = new ArrayList();

    public a() {
        List<x> cHa = cHa();
        if (!y.isEmpty(cHa)) {
            this.jtn.addAll(cHa);
        }
    }

    private List<x> cHa() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.bnH().getString("key_index_tab_info_list", "[]"));
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

    public List<x> cHb() {
        return this.jtn;
    }

    public int cHc() {
        return this.jtm;
    }
}
