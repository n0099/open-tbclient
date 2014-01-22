package com.baidu.tieba.im.d;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.gson.JsonArray;
import com.baidu.gson.JsonElement;
import com.baidu.gson.JsonParser;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.slidingmenu.lib.R;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private static short a = 1;
    private static short b = 2;
    private static short c = 3;
    private static short d = 5;
    private static Pattern e = Pattern.compile("(#\\([^#\\)\\(]+\\))");

    public static String a(String str, boolean z) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        try {
            str2 = new JSONArray(str).getJSONObject(0).optString(z ? "big_src" : "src");
            return str2;
        } catch (Exception e2) {
            return str2;
        }
    }

    public static String a(JSONObject jSONObject, boolean z) {
        return jSONObject.optString(z ? "big_src" : "src");
    }

    public static boolean a(com.baidu.tieba.im.message.b bVar) {
        return bVar != null && bVar.i() == b;
    }

    public static boolean b(com.baidu.tieba.im.message.b bVar) {
        return bVar != null && bVar.i() == 4;
    }

    public static boolean c(com.baidu.tieba.im.message.b bVar) {
        return bVar != null && bVar.i() == c;
    }

    public static boolean d(com.baidu.tieba.im.message.b bVar) {
        try {
            if (bVar.i() != 11 && TiebaApplication.B()) {
                return bVar.g().getId().equals(TiebaApplication.A());
            }
            return false;
        } catch (Exception e2) {
            com.baidu.adp.lib.g.e.b("LocalUtil", "isAuthor", "Msg Author is Null");
            return false;
        }
    }

    public static MsgCacheData e(com.baidu.tieba.im.message.b bVar) {
        try {
            MsgCacheData msgCacheData = new MsgCacheData();
            msgCacheData.setRich_content(null);
            return msgCacheData;
        } catch (Exception e2) {
            com.baidu.adp.lib.g.e.b("LocalUtil", "getMsgCacheData", "error:" + e2.getMessage());
            return null;
        }
    }

    public static VoiceMsgData f(com.baidu.tieba.im.message.b bVar) {
        VoiceMsgData voiceMsgData;
        Exception e2;
        if (bVar == null || bVar.i() != 3) {
            return null;
        }
        if (bVar.f() != null) {
            return (VoiceMsgData) bVar.f();
        }
        String k = bVar.k();
        if (TextUtils.isEmpty(k)) {
            VoiceMsgData voiceMsgData2 = new VoiceMsgData();
            bVar.a(voiceMsgData2);
            return voiceMsgData2;
        }
        try {
            Gson gson = new Gson();
            JsonArray asJsonArray = new JsonParser().parse(k).getAsJsonArray();
            if (asJsonArray == null || asJsonArray.size() <= 0) {
                return null;
            }
            Iterator<JsonElement> it = asJsonArray.iterator();
            voiceMsgData = it.hasNext() ? (VoiceMsgData) gson.fromJson(it.next(), (Class<Object>) VoiceMsgData.class) : null;
            try {
                bVar.a(voiceMsgData);
                return voiceMsgData;
            } catch (Exception e3) {
                e2 = e3;
                com.baidu.adp.lib.g.e.b("LocalUtil", "deserializerVoiceMsgData", "error:" + e2.getMessage());
                return voiceMsgData;
            }
        } catch (Exception e4) {
            voiceMsgData = null;
            e2 = e4;
        }
    }

    private static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && !optJSONObject.isNull("type")) {
                    int optInt = optJSONObject.optInt("type");
                    if (optInt == 0) {
                        sb.append(optJSONObject.opt("text"));
                    } else if (optInt == 2) {
                        sb.append("#(");
                        sb.append(optJSONObject.opt("c"));
                        sb.append(")");
                    }
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return sb.toString();
    }

    public static String g(com.baidu.tieba.im.message.b bVar) {
        if (bVar == null) {
            return null;
        }
        if (bVar.i() == 1) {
            String a2 = (bVar.k().length() <= 1 || bVar.k().charAt(0) != '[') ? null : a(bVar.k());
            if (TextUtils.isEmpty(a2)) {
                a2 = bVar.k();
            }
            if (a2 != null) {
                Matcher matcher = e.matcher(a2);
                while (matcher.find()) {
                    String group = matcher.group();
                    a2 = a2.replace(group, group.replace("#(", "[").replace(")", "]"));
                }
                return a2;
            }
            return null;
        } else if (bVar.i() == 2) {
            return TiebaApplication.h().getString(R.string.last_msg_pic);
        } else {
            if (bVar.i() == 3) {
                return TiebaApplication.h().getString(R.string.last_msg_voice);
            }
            if (bVar.i() == 11) {
                String b2 = b(bVar.k());
                com.baidu.adp.lib.g.e.e("simon", "raw system message", bVar.k());
                com.baidu.adp.lib.g.e.e("simon", "converted system message", b2);
                return b2;
            } else if (bVar.i() == 4) {
                String k = bVar.k();
                try {
                    JSONArray jSONArray = new JSONArray(k);
                    if (jSONArray.length() > 0) {
                        String optString = jSONArray.getJSONObject(0).optString("face_name");
                        if (optString != null && optString.startsWith("#(") && optString.endsWith(")")) {
                            optString = "[" + optString.substring(2, optString.length() - 1) + "]";
                        }
                        return optString;
                    }
                    return null;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    try {
                        String optString2 = new JSONObject(k).optString("face_name");
                        if (optString2 != null && optString2.startsWith("#(") && optString2.endsWith(")")) {
                            optString2 = "[" + optString2.substring(2, optString2.length() - 1) + "]";
                        }
                        return optString2;
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                        return null;
                    }
                }
            } else if (bVar.i() == 5) {
                return TiebaApplication.h().getString(R.string.last_msg_invite);
            } else {
                return null;
            }
        }
    }

    public static String h(com.baidu.tieba.im.message.b bVar) {
        if (bVar == null) {
            return null;
        }
        String str = "";
        UserData g = bVar.g();
        if (g != null && !TextUtils.isEmpty(g.getName())) {
            str = bVar.g().getName();
        }
        if (g != null && !TextUtils.isEmpty(g.getId()) && g.getId().equals(TiebaApplication.A())) {
            return g(bVar);
        }
        if (bVar.i() == 11) {
            return g(bVar);
        }
        if (!TextUtils.isEmpty(str)) {
            return str + ":" + g(bVar);
        }
        return g(bVar);
    }

    private static String b(String str) {
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("eventId");
                String optString2 = jSONObject.optString("userMsg");
                JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
                if (TextUtils.isEmpty(optString) || optJSONObject == null) {
                    com.baidu.adp.lib.g.e.a("eventId == null or eventParam == null");
                } else if (optString.equals("-10001")) {
                    str2 = optString2;
                } else if (optString.equals("003")) {
                    str2 = TiebaApplication.h().getString(R.string.kick_out_myself);
                } else if (optString.equals("122") || optString.equals("121")) {
                    str2 = optString2;
                } else if (optString.equals("105")) {
                    String optString3 = optJSONObject.optString("userId");
                    String optString4 = optJSONObject.optString("userName");
                    if (optString3.equals(TiebaApplication.A())) {
                        str2 = TiebaApplication.h().getString(R.string.join_group_myself);
                    } else {
                        str2 = optString4 + TiebaApplication.h().getString(R.string.join_group);
                    }
                } else if (optString.equals("106")) {
                    String optString5 = optJSONObject.optString("userId");
                    optJSONObject.optString("userName");
                    str2 = optString5.equals(TiebaApplication.A()) ? TiebaApplication.h().getString(R.string.kick_out_myself) : optString2;
                } else if (optString.equals("002")) {
                    str2 = TiebaApplication.h().getString(R.string.join_group_myself);
                } else if (optString.equals("109")) {
                    str2 = optString2;
                } else if (optString.equals("110")) {
                    str2 = optString2;
                } else if (optString.equals("202")) {
                    str2 = optJSONObject.optString("userName") + TiebaApplication.h().getString(R.string.snap_group_chat_exit);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                com.baidu.adp.lib.g.e.a("transform erro" + e2.getMessage());
            }
        }
        return str2;
    }

    public static SystemMsgData i(com.baidu.tieba.im.message.b bVar) {
        if (bVar == null || bVar.i() != 11 || TextUtils.isEmpty(bVar.k())) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(bVar.k());
            String optString = jSONObject.optString("eventId");
            String optString2 = jSONObject.optString("userMsg");
            JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
            if (TextUtils.isEmpty(optString) || optJSONObject == null) {
                com.baidu.adp.lib.g.e.a("eventId == null or eventParam == null");
                return null;
            } else if (optString.equals("003")) {
                SystemMsgData systemMsgData = new SystemMsgData();
                systemMsgData.setIsSelf(true);
                systemMsgData.setContent(TiebaApplication.h().getString(R.string.kick_out_myself));
                return systemMsgData;
            } else if (optString.equals("122") || optString.equals("121")) {
                SystemMsgData systemMsgData2 = new SystemMsgData();
                systemMsgData2.setIsSelf(true);
                systemMsgData2.setContent(optString2);
                return systemMsgData2;
            } else if (optString.equals("105")) {
                String optString3 = optJSONObject.optString("userId");
                String optString4 = optJSONObject.optString("userName");
                SystemMsgData systemMsgData3 = new SystemMsgData();
                if (optString3.equals(TiebaApplication.A())) {
                    systemMsgData3.setIsSelf(true);
                    systemMsgData3.setContent(TiebaApplication.h().getString(R.string.join_group_myself));
                } else {
                    systemMsgData3.setIsSelf(false);
                    systemMsgData3.setContent(optString4 + TiebaApplication.h().getString(R.string.join_group));
                }
                return systemMsgData3;
            } else if (optString.equals("106")) {
                String optString5 = optJSONObject.optString("userId");
                optJSONObject.optString("userName");
                SystemMsgData systemMsgData4 = new SystemMsgData();
                if (optString5.equals(TiebaApplication.A())) {
                    systemMsgData4.setIsSelf(true);
                    systemMsgData4.setContent(TiebaApplication.h().getString(R.string.kick_out_myself));
                } else {
                    systemMsgData4.setIsSelf(false);
                    systemMsgData4.setContent(optString2);
                }
                return systemMsgData4;
            } else if (optString.equals("002")) {
                SystemMsgData systemMsgData5 = new SystemMsgData();
                systemMsgData5.setIsSelf(true);
                systemMsgData5.setContent(TiebaApplication.h().getString(R.string.join_group_myself));
                return null;
            } else {
                return null;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            com.baidu.adp.lib.g.e.a("transform erro" + e2.getMessage());
            return null;
        }
    }
}
