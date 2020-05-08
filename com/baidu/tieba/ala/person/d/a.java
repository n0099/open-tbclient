package com.baidu.tieba.ala.person.d;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.z;
import com.baidu.tieba.ala.person.a.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static PersonUserData a(b bVar) {
        PersonUserData personUserData = new PersonUserData();
        personUserData.user_info = new z();
        personUserData.relation_info = new AlaRelationData();
        personUserData.location_info = new AlaLocationData();
        personUserData.user_info.atT = bVar.metaKey;
        personUserData.user_info.user_id = bVar.id;
        personUserData.user_info.user_name = bVar.name;
        personUserData.user_info.user_nickname = bVar.name_show;
        personUserData.user_info.description = bVar.intro;
        personUserData.user_info.portrait = bVar.portrait;
        personUserData.relation_info.follow_status = bVar.fqH;
        return personUserData;
    }

    public static String aP(int i, String str) {
        String str2;
        String str3;
        String str4 = null;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (i == 0) {
                    str3 = jSONObject.optString("user_list");
                    str2 = new JSONObject(jSONObject.optString("page")).optString("has_more");
                } else if (i == 1) {
                    str3 = jSONObject.optString("follow_list").trim();
                    if ("".equals(str3)) {
                        str3 = "[]";
                    }
                    str2 = jSONObject.optString("has_more");
                } else {
                    str2 = null;
                    str3 = null;
                }
                if (jSONObject.optInt("error_code") == 0) {
                    str4 = "{\"has_more\":\"" + str2 + "\", \"user_list\":" + str3 + "}";
                    return str4;
                }
                return null;
            } catch (JSONException e) {
                BdLog.detailException(e);
                return str4;
            }
        }
        return null;
    }

    public static String dL(long j) {
        return j / 10000 > 0 ? p(Math.floor(j / 1000.0d) / 10.0d) + "w" : String.valueOf(j);
    }

    public static String p(double d) {
        String valueOf = String.valueOf(d);
        int indexOf = valueOf.indexOf(".");
        String substring = valueOf.substring(indexOf + 1, valueOf.length());
        if (substring.length() == 1) {
            if (Integer.parseInt(substring) == 0) {
                return valueOf.substring(0, indexOf);
            }
            return valueOf;
        } else if ("00".equals(substring)) {
            return valueOf.substring(0, indexOf);
        } else {
            return valueOf;
        }
    }
}
