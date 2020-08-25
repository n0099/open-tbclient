package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.w;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes16.dex */
public class a {
    private int iJl = 1;
    private final List<w> iJm = new ArrayList();

    public a() {
        List<w> cwE = cwE();
        if (!y.isEmpty(cwE)) {
            this.iJm.addAll(cwE);
        }
    }

    private List<w> cwE() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.bik().getString("key_index_tab_info_list", "[]"));
            for (int i = 0; i < jSONArray.length(); i++) {
                w wVar = new w();
                wVar.parserJson(jSONArray.getJSONObject(i));
                if (!wVar.isDirtyData()) {
                    arrayList.add(wVar);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public List<w> cwF() {
        return this.iJm;
    }

    public int cwG() {
        return this.iJl;
    }
}
