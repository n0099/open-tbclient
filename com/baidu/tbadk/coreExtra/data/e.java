package com.baidu.tbadk.coreExtra.data;

import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public ArrayList<Integer> fsP;
    public int eBU = 6;
    public int fsQ = 2;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("first_ floor", null);
                if (optString != null) {
                    this.eBU = jSONObject.optInt("density", 6);
                    this.fsP = new ArrayList<>();
                    String[] split = optString.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
                    for (String str : split) {
                        int i = com.baidu.adp.lib.f.b.toInt(str, 2);
                        if (i > 0) {
                            this.fsP.add(Integer.valueOf(i));
                        }
                    }
                }
                com.baidu.tbadk.core.sharedPref.b.bvq().putString("pref_key_fun_ad_density", jSONObject.toString());
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
                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("pref_key_fun_ad_frs_first_floor", optInt);
                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("pref_key_fun_ad_frs_density", optInt2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static int bzF() {
        return com.baidu.tbadk.core.sharedPref.b.bvq().getInt("pref_key_fun_ad_frs_first_floor", 2);
    }

    public static int bzG() {
        return com.baidu.tbadk.core.sharedPref.b.bvq().getInt("pref_key_fun_ad_frs_density", 5);
    }
}
