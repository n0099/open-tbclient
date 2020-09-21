package com.baidu.tbadk.coreExtra.data;

import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public ArrayList<Integer> eCg;
    public int dMA = 6;
    public int eCh = 2;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("first_ floor", null);
                if (optString != null) {
                    this.dMA = jSONObject.optInt("density", 6);
                    this.eCg = new ArrayList<>();
                    String[] split = optString.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
                    for (String str : split) {
                        int i = com.baidu.adp.lib.f.b.toInt(str, 2);
                        if (i > 0) {
                            this.eCg.add(Integer.valueOf(i));
                        }
                    }
                }
                com.baidu.tbadk.core.sharedPref.b.bjf().putString("pref_key_fun_ad_density", jSONObject.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
