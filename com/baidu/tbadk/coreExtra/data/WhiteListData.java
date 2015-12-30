package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes.dex */
public class WhiteListData extends LinkedList<String> {
    private static final long serialVersionUID = -7967671019705518672L;

    private void parserJson(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String optString = jSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    add(optString);
                }
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
    }

    public void saveJson(JSONArray jSONArray) {
        if (jSONArray == null) {
            ed(null);
        } else {
            ed(jSONArray.toString());
        }
    }

    public boolean checkUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        Iterator it = iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (!TextUtils.isEmpty(str2)) {
                String lowerCase2 = str2.toLowerCase();
                if (lowerCase.startsWith(lowerCase2)) {
                    return true;
                }
                if (lowerCase.startsWith("http://") && lowerCase.substring("http://".length()).startsWith(lowerCase2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void ed(String str) {
        com.baidu.tbadk.core.sharedPref.b.tJ().putString("key_white_list", str);
    }

    public static WhiteListData createBySP() {
        WhiteListData whiteListData = new WhiteListData();
        String string = com.baidu.tbadk.core.sharedPref.b.tJ().getString("key_white_list", null);
        if (!TextUtils.isEmpty(string)) {
            whiteListData.parserJson(string);
        }
        return whiteListData;
    }
}
