package com.baidu.tbadk.coreExtra.data;

import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public ArrayList<Integer> eOn;
    public int dYB = 6;
    public int eOo = 2;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("first_ floor", null);
                if (optString != null) {
                    this.dYB = jSONObject.optInt("density", 6);
                    this.eOn = new ArrayList<>();
                    String[] split = optString.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
                    for (String str : split) {
                        int i = com.baidu.adp.lib.f.b.toInt(str, 2);
                        if (i > 0) {
                            this.eOn.add(Integer.valueOf(i));
                        }
                    }
                }
                com.baidu.tbadk.core.sharedPref.b.blO().putString("pref_key_fun_ad_density", jSONObject.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
