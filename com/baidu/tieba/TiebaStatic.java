package com.baidu.tieba;

import com.baidu.tbadk.core.util.bb;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TiebaStatic {
    static {
        bb.vQ().a(new ad());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String gy(String str) {
        URL url;
        try {
            url = new URL(str);
        } catch (Exception e) {
            e.printStackTrace();
            url = null;
        }
        if (url == null) {
            return "";
        }
        String query = url.getQuery();
        HashMap hashMap = new HashMap();
        String[] split = query.split("&");
        if (split != null) {
            for (String str2 : split) {
                String[] split2 = str2.split("=");
                if (split2 != null && split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        return new JSONObject(hashMap).toString();
    }
}
