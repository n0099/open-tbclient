package com.baidu.tieba.aiapps;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static String t(String str, String str2, String str3) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("tiebaclient://");
        sb.append("swan/");
        sb.append(str);
        if (!TextUtils.isEmpty(str2)) {
            if (!str2.startsWith("/")) {
                sb.append("/");
            }
            sb.append(str2);
            if (!str2.endsWith("/")) {
                sb.append("/");
            }
        } else {
            sb.append("/");
        }
        sb.append("?");
        sb.append("_baiduboxapp=");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        sb.append(URLEncoder.encode(jSONObject.toString()));
        sb.append("&callback=_bdbox_js_275&upgrade=0");
        return sb.toString();
    }

    public static final boolean u(String str, String str2, String str3) {
        String t;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3) || (t = t(str, str2, str3)) == null || !t.startsWith("tiebaclient://")) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, t));
        return true;
    }
}
