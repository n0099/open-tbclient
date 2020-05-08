package com.baidu.tieba.forumsearch.controller;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes11.dex */
public class e {
    public static void CR(String str) {
        int i;
        if (!StringUtils.isNull(str)) {
            String string = com.baidu.tbadk.core.sharedPref.b.aNT().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SEARCH_FORUM_HISTORY), "");
            try {
                JSONArray jSONArray = StringUtils.isNull(string) ? new JSONArray() : new JSONArray(string);
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                int i2 = 1;
                int i3 = 0;
                while (i3 < jSONArray.length()) {
                    Object obj = jSONArray.get(i3);
                    if (!(obj instanceof String) || str.equals(obj)) {
                        i = i2;
                    } else {
                        arrayList.add((String) obj);
                        i = i2 + 1;
                    }
                    if (i == 6) {
                        break;
                    }
                    i3++;
                    i2 = i;
                }
                com.baidu.tbadk.core.sharedPref.b.aNT().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SEARCH_FORUM_HISTORY), new JSONArray((Collection) arrayList).toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<String> bNs() {
        ArrayList<String> arrayList = null;
        String string = com.baidu.tbadk.core.sharedPref.b.aNT().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SEARCH_FORUM_HISTORY), "");
        if (StringUtils.isNull(string)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() <= 0) {
                return null;
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        return arrayList2;
                    }
                    Object obj = jSONArray.get(i2);
                    if (obj instanceof String) {
                        arrayList2.add((String) obj);
                    }
                    i = i2 + 1;
                } catch (JSONException e) {
                    arrayList = arrayList2;
                    e = e;
                    e.printStackTrace();
                    return arrayList;
                }
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }

    public static void CS(String str) {
        if (!StringUtils.isNull(str)) {
            String string = com.baidu.tbadk.core.sharedPref.b.aNT().getString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SEARCH_FORUM_HISTORY), "");
            if (!StringUtils.isNull(string)) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    if (jSONArray.length() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            Object obj = jSONArray.get(i);
                            if (!str.equals(obj)) {
                                arrayList.add((String) obj);
                            }
                        }
                        com.baidu.tbadk.core.sharedPref.b.aNT().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SEARCH_FORUM_HISTORY), new JSONArray((Collection) arrayList).toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void bNt() {
        com.baidu.tbadk.core.sharedPref.b.aNT().putString(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SEARCH_FORUM_HISTORY), "");
    }
}
