package com.baidu.tbadk.coreExtra.data;

import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public ArrayList<Integer> foe;
    public int exf = 6;
    public int fof = 2;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("first_ floor", null);
                if (optString != null) {
                    this.exf = jSONObject.optInt("density", 6);
                    this.foe = new ArrayList<>();
                    String[] split = optString.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
                    for (String str : split) {
                        int i = com.baidu.adp.lib.f.b.toInt(str, 2);
                        if (i > 0) {
                            this.foe.add(Integer.valueOf(i));
                        }
                    }
                }
                com.baidu.tbadk.core.sharedPref.b.brx().putString("pref_key_fun_ad_density", jSONObject.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void dv(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                int optInt = jSONObject.optInt("frs_bear_first_floor", 2);
                int optInt2 = jSONObject.optInt("frs_bear_density", 5);
                com.baidu.tbadk.core.sharedPref.b.brx().putInt("pref_key_fun_ad_frs_first_floor", optInt);
                com.baidu.tbadk.core.sharedPref.b.brx().putInt("pref_key_fun_ad_frs_density", optInt2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static int bvM() {
        return com.baidu.tbadk.core.sharedPref.b.brx().getInt("pref_key_fun_ad_frs_first_floor", 2);
    }

    public static int bvN() {
        return com.baidu.tbadk.core.sharedPref.b.brx().getInt("pref_key_fun_ad_frs_density", 5);
    }
}
