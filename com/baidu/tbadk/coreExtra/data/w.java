package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class w {
    public List<x> eCM;

    public void V(JSONArray jSONArray) {
        this.eCM = new ArrayList();
        try {
            if (jSONArray == null) {
                com.baidu.tbadk.core.sharedPref.b.bjf().putString("key_index_tab_info_list", "[]");
                return;
            }
            JSONArray jSONArray2 = new JSONArray(com.baidu.tbadk.core.sharedPref.b.bjf().getString("key_index_tab_info_list", "[]"));
            for (int i = 0; i < jSONArray.length(); i++) {
                x xVar = new x();
                x xVar2 = new x();
                xVar.parserJson(jSONArray.getJSONObject(i));
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    xVar2.parserJson(jSONArray2.getJSONObject(i2));
                    if (xVar.tabCode != null && xVar.tabCode.equals(xVar2.tabCode)) {
                        xVar.isShowRedDot = TextUtils.isEmpty(xVar2.eCN) || !xVar2.eCN.equals(xVar.eCN);
                    }
                }
                if (!xVar.isDirtyData()) {
                    this.eCM.add(xVar);
                }
            }
            com.baidu.tbadk.core.sharedPref.b.bjf().putString("key_index_tab_info_list", jSONArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
