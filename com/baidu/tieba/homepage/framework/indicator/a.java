package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes16.dex */
public class a {
    private int iuW = 1;
    private final List<t> iuX = new ArrayList();

    public a() {
        List<t> clV = clV();
        if (!x.isEmpty(clV)) {
            this.iuX.addAll(clV);
        }
    }

    private List<t> clV() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.aZP().getString("key_index_tab_info_list", "[]"));
            for (int i = 0; i < jSONArray.length(); i++) {
                t tVar = new t();
                tVar.parserJson(jSONArray.getJSONObject(i));
                if (!tVar.isDirtyData()) {
                    arrayList.add(tVar);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public List<t> clW() {
        return this.iuX;
    }

    public int clX() {
        return this.iuW;
    }
}
