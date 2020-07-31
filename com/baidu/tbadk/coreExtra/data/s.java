package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class s {
    public List<t> eqj;

    public void T(JSONArray jSONArray) {
        this.eqj = new ArrayList();
        try {
            if (jSONArray == null) {
                com.baidu.tbadk.core.sharedPref.b.aZP().putString("key_index_tab_info_list", "[]");
                return;
            }
            JSONArray jSONArray2 = new JSONArray(com.baidu.tbadk.core.sharedPref.b.aZP().getString("key_index_tab_info_list", "[]"));
            for (int i = 0; i < jSONArray.length(); i++) {
                t tVar = new t();
                t tVar2 = new t();
                tVar.parserJson(jSONArray.getJSONObject(i));
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    tVar2.parserJson(jSONArray2.getJSONObject(i2));
                    if (tVar.tabCode != null && tVar.tabCode.equals(tVar2.tabCode)) {
                        tVar.isShowRedDot = TextUtils.isEmpty(tVar2.eqk) || !tVar2.eqk.equals(tVar.eqk);
                    }
                }
                if (!tVar.isDirtyData()) {
                    this.eqj.add(tVar);
                }
            }
            com.baidu.tbadk.core.sharedPref.b.aZP().putString("key_index_tab_info_list", jSONArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
