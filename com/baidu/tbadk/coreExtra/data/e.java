package com.baidu.tbadk.coreExtra.data;

import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public ArrayList<Integer> eWJ;
    public int egY = 6;
    public int eWK = 2;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("first_ floor", null);
                if (optString != null) {
                    this.egY = jSONObject.optInt("density", 6);
                    this.eWJ = new ArrayList<>();
                    String[] split = optString.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
                    for (String str : split) {
                        int i = com.baidu.adp.lib.f.b.toInt(str, 2);
                        if (i > 0) {
                            this.eWJ.add(Integer.valueOf(i));
                        }
                    }
                }
                com.baidu.tbadk.core.sharedPref.b.bnH().putString("pref_key_fun_ad_density", jSONObject.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
