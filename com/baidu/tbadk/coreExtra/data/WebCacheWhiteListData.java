package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class WebCacheWhiteListData extends LinkedList<String> {
    private void eE(String str) {
        String[] split;
        if (!StringUtils.isNull(str) && (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length >= 1) {
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2)) {
                    add(str2);
                }
            }
        }
    }

    public void saveString(String str) {
        if (str == null) {
            eF(null);
        } else {
            eF(str);
        }
    }

    private void eF(String str) {
        if (str != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("key_web_cache_white_list", str);
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
            if (!TextUtils.isEmpty(str2) && lowerCase.contains(str2.toLowerCase().replaceFirst("http://", "").replaceFirst("https://", ""))) {
                return true;
            }
        }
        return false;
    }

    public static WebCacheWhiteListData createBySP() {
        WebCacheWhiteListData webCacheWhiteListData = new WebCacheWhiteListData();
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_web_cache_white_list", null);
        if (!TextUtils.isEmpty(string)) {
            webCacheWhiteListData.eE(string);
        }
        return webCacheWhiteListData;
    }
}
