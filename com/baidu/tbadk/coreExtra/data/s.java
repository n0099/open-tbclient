package com.baidu.tbadk.coreExtra.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class s {
    public List<t> ejW;

    public void S(JSONArray jSONArray) {
        this.ejW = new ArrayList();
        try {
            if (jSONArray == null) {
                com.baidu.tbadk.core.sharedPref.b.aVP().putString("key_index_tab_info_list", "[]");
                return;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                t tVar = new t();
                tVar.parserJson(jSONArray.getJSONObject(i));
                if (!tVar.isDirtyData()) {
                    this.ejW.add(tVar);
                }
            }
            com.baidu.tbadk.core.sharedPref.b.aVP().putString("key_index_tab_info_list", jSONArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
