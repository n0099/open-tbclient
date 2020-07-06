package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class a {
    private int ioQ = 1;
    private final List<t> ioR = new ArrayList();

    public a() {
        List<t> civ = civ();
        if (!w.isEmpty(civ)) {
            this.ioR.addAll(civ);
        }
    }

    private List<t> civ() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.aVP().getString("key_index_tab_info_list", "[]"));
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

    public List<t> ciw() {
        return this.ioR;
    }

    public int cix() {
        return this.ioQ;
    }
}
