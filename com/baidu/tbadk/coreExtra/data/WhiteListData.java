package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import d.b.h0.r.d0.b;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class WhiteListData extends LinkedList<String> {
    public static final String HTTPS_PREFIX = "https://";
    public static final String HTTP_PREFIX = "http://";
    public static final long serialVersionUID = -7967671019705518672L;

    public static WhiteListData createBySP() {
        WhiteListData whiteListData = new WhiteListData();
        String o = b.i().o("key_white_list", null);
        if (!TextUtils.isEmpty(o)) {
            whiteListData.parserJson(o);
        }
        return whiteListData;
    }

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
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
    }

    private void save(String str) {
        b.i().w("key_white_list", str);
    }

    public boolean checkHostname(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        Iterator<String> it = iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                String lowerCase2 = next.toLowerCase();
                if (lowerCase.startsWith(lowerCase2)) {
                    return true;
                }
                if (lowerCase.startsWith("http://") && lowerCase.substring(7).startsWith(lowerCase2)) {
                    return true;
                }
                if (lowerCase.startsWith("https://") && lowerCase.substring(8).startsWith(lowerCase2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        Iterator<String> it = iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                String lowerCase2 = next.toLowerCase();
                if (lowerCase.startsWith(lowerCase2)) {
                    return true;
                }
                if (lowerCase.startsWith("http://") && lowerCase.substring(7).startsWith(lowerCase2)) {
                    return true;
                }
                if (lowerCase.startsWith("https://") && lowerCase.substring(8).startsWith(lowerCase2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void saveJson(JSONArray jSONArray) {
        if (jSONArray == null) {
            save(null);
        } else {
            save(jSONArray.toString());
        }
    }
}
