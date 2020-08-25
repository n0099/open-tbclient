package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class v {
    public List<w> eAD;

    public void V(JSONArray jSONArray) {
        this.eAD = new ArrayList();
        try {
            if (jSONArray == null) {
                com.baidu.tbadk.core.sharedPref.b.bik().putString("key_index_tab_info_list", "[]");
                return;
            }
            JSONArray jSONArray2 = new JSONArray(com.baidu.tbadk.core.sharedPref.b.bik().getString("key_index_tab_info_list", "[]"));
            for (int i = 0; i < jSONArray.length(); i++) {
                w wVar = new w();
                w wVar2 = new w();
                wVar.parserJson(jSONArray.getJSONObject(i));
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    wVar2.parserJson(jSONArray2.getJSONObject(i2));
                    if (wVar.tabCode != null && wVar.tabCode.equals(wVar2.tabCode)) {
                        wVar.isShowRedDot = TextUtils.isEmpty(wVar2.eAE) || !wVar2.eAE.equals(wVar.eAE);
                    }
                }
                if (!wVar.isDirtyData()) {
                    this.eAD.add(wVar);
                }
            }
            com.baidu.tbadk.core.sharedPref.b.bik().putString("key_index_tab_info_list", jSONArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
