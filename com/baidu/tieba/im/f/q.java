package com.baidu.tieba.im.f;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.gson.JsonArray;
import com.baidu.gson.JsonElement;
import com.baidu.gson.JsonParser;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.data.VoiceMsgData;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class q {
    private static short a = 1;
    private static short b = 2;
    private static short c = 3;
    private static short d = 5;
    private static Pattern e = Pattern.compile("(#\\([^#\\)\\(]+\\))");

    public static String a(String str, boolean z) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONArray(str).getJSONObject(0).optString("big_src");
        } catch (Exception e2) {
            return null;
        }
    }

    public static String a(JSONObject jSONObject, boolean z) {
        return jSONObject.optString("src");
    }

    public static boolean a(com.baidu.tieba.im.message.a.a aVar) {
        return aVar != null && aVar.t() == b;
    }

    public static boolean b(com.baidu.tieba.im.message.a.a aVar) {
        return aVar != null && aVar.t() == 4;
    }

    public static boolean c(com.baidu.tieba.im.message.a.a aVar) {
        return aVar != null && aVar.t() == c;
    }

    public static boolean d(com.baidu.tieba.im.message.a.a aVar) {
        try {
            if (aVar.t() != 11 && TbadkApplication.F()) {
                return aVar.r().getUserId().equals(TbadkApplication.E());
            }
            return false;
        } catch (Exception e2) {
            com.baidu.adp.lib.util.f.b("LocalUtil", "isAuthor", "Msg Author is Null");
            return false;
        }
    }

    public static boolean e(com.baidu.tieba.im.message.a.a aVar) {
        return aVar != null && aVar.t() == 6;
    }

    public static MsgCacheData a() {
        try {
            MsgCacheData msgCacheData = new MsgCacheData();
            msgCacheData.setRich_content(null);
            return msgCacheData;
        } catch (Exception e2) {
            com.baidu.adp.lib.util.f.b("LocalUtil", "getMsgCacheData", "error:" + e2.getMessage());
            return null;
        }
    }

    public static VoiceMsgData f(com.baidu.tieba.im.message.a.a aVar) {
        VoiceMsgData voiceMsgData;
        Exception e2;
        if (aVar == null || aVar.t() != 3) {
            return null;
        }
        if (aVar.q() != null) {
            return (VoiceMsgData) aVar.q();
        }
        String v = aVar.v();
        if (TextUtils.isEmpty(v)) {
            VoiceMsgData voiceMsgData2 = new VoiceMsgData();
            aVar.a(voiceMsgData2);
            return voiceMsgData2;
        }
        try {
            Gson gson = new Gson();
            JsonArray asJsonArray = new JsonParser().parse(v).getAsJsonArray();
            if (asJsonArray == null || asJsonArray.size() <= 0) {
                return null;
            }
            Iterator<JsonElement> it = asJsonArray.iterator();
            voiceMsgData = it.hasNext() ? (VoiceMsgData) gson.fromJson(it.next(), (Class<Object>) VoiceMsgData.class) : null;
            try {
                aVar.a(voiceMsgData);
                return voiceMsgData;
            } catch (Exception e3) {
                e2 = e3;
                com.baidu.adp.lib.util.f.b("LocalUtil", "deserializerVoiceMsgData", "error:" + e2.getMessage());
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

    public static String g(com.baidu.tieba.im.message.a.a aVar) {
        int i = 0;
        if (aVar == null) {
            return null;
        }
        if (aVar.t() == 1) {
            String a2 = (aVar.v().length() <= 1 || aVar.v().charAt(0) != '[') ? null : a(aVar.v());
            if (TextUtils.isEmpty(a2)) {
                a2 = aVar.v();
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
        } else if (aVar.t() == 2) {
            return TbadkApplication.j().b().getString(com.baidu.tieba.im.j.last_msg_pic);
        } else {
            if (aVar.t() == 3) {
                return TbadkApplication.j().b().getString(com.baidu.tieba.im.j.last_msg_voice);
            }
            if (aVar.t() == 11) {
                String b2 = b(aVar.v());
                com.baidu.adp.lib.util.f.e("simon", "raw system message", aVar.v());
                com.baidu.adp.lib.util.f.e("simon", "converted system message", b2);
                return b2;
            } else if (aVar.t() == 4) {
                String v = aVar.v();
                try {
                    JSONArray jSONArray = new JSONArray(v);
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
                        String optString2 = new JSONObject(v).optString("face_name");
                        if (optString2 != null && optString2.startsWith("#(") && optString2.endsWith(")")) {
                            optString2 = "[" + optString2.substring(2, optString2.length() - 1) + "]";
                        }
                        return optString2;
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                        return null;
                    }
                }
            } else if (aVar.t() == 5) {
                return TbadkApplication.j().b().getString(com.baidu.tieba.im.j.last_msg_invite);
            } else {
                if (aVar.t() == 6) {
                    String str = "";
                    try {
                        str = new JSONObject(aVar.v()).optString("userMsg");
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                    return str;
                } else if (aVar.t() != 7) {
                    return null;
                } else {
                    String v2 = aVar.v();
                    String string = TbadkApplication.j().b().getString(com.baidu.tieba.im.j.last_msg_pic_text);
                    if (!TextUtils.isEmpty(v2)) {
                        try {
                            JSONArray jSONArray2 = new JSONArray(v2);
                            if (jSONArray2.length() <= 0) {
                                return string;
                            }
                            while (true) {
                                int i2 = i;
                                if (i2 < jSONArray2.length()) {
                                    String string2 = ((JSONObject) jSONArray2.get(i2)).getString("title");
                                    if (!TextUtils.isEmpty(string2)) {
                                        return string2;
                                    }
                                    i = i2 + 1;
                                } else {
                                    return string;
                                }
                            }
                        } catch (JSONException e5) {
                            e5.printStackTrace();
                            return string;
                        }
                    } else {
                        return string;
                    }
                }
            }
        }
    }

    public static String h(com.baidu.tieba.im.message.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        String str = "";
        UserData r = aVar.r();
        if (r != null && !TextUtils.isEmpty(r.getUserName())) {
            str = aVar.r().getUserName();
        }
        if (r != null && !TextUtils.isEmpty(r.getUserId()) && r.getUserId().equals(TbadkApplication.E())) {
            return g(aVar);
        }
        if (aVar.t() == 11) {
            return g(aVar);
        }
        if (!TextUtils.isEmpty(str)) {
            return String.valueOf(str) + ":" + g(aVar);
        }
        return g(aVar);
    }

    private static String b(String str) {
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("eventId");
                String optString2 = jSONObject.optString("userMsg");
                JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
                if (TextUtils.isEmpty(optString)) {
                    com.baidu.adp.lib.util.f.b("eventId == null or eventParam == null");
                } else if (optString.equals("-10001")) {
                    str2 = optString2;
                } else if (optJSONObject == null) {
                    com.baidu.adp.lib.util.f.b("eventParam == null");
                } else if (optString.equals("003")) {
                    str2 = TbadkApplication.j().b().getString(com.baidu.tieba.im.j.kick_out_myself);
                } else if (optString.equals("122") || optString.equals("121")) {
                    str2 = optString2;
                } else if (optString.equals("105")) {
                    String optString3 = optJSONObject.optString("userId");
                    String optString4 = optJSONObject.optString("userName");
                    if (optString3.equals(TbadkApplication.E())) {
                        str2 = TbadkApplication.j().b().getString(com.baidu.tieba.im.j.join_group_myself);
                    } else {
                        str2 = String.valueOf(optString4) + TbadkApplication.j().b().getString(com.baidu.tieba.im.j.join_group);
                    }
                } else if (optString.equals("106")) {
                    str2 = optJSONObject.optString("userId").equals(TbadkApplication.E()) ? TbadkApplication.j().b().getString(com.baidu.tieba.im.j.kick_out_myself) : optString2;
                } else if (optString.equals("002")) {
                    str2 = TbadkApplication.j().b().getString(com.baidu.tieba.im.j.join_group_myself);
                } else if (optString.equals("109")) {
                    str2 = optString2;
                } else if (optString.equals("110")) {
                    str2 = optString2;
                } else if (optString.equals("202")) {
                    str2 = String.valueOf(optJSONObject.optString("userName")) + TbadkApplication.j().b().getString(com.baidu.tieba.im.j.snap_group_chat_exit);
                } else if (optString.equals("123")) {
                    str2 = optString2;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                com.baidu.adp.lib.util.f.b("transform erro" + e2.getMessage());
            }
        }
        return str2;
    }

    public static SystemMsgData i(com.baidu.tieba.im.message.a.a aVar) {
        if (aVar == null || aVar.t() != 11 || TextUtils.isEmpty(aVar.v())) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(aVar.v());
            String optString = jSONObject.optString("eventId");
            String optString2 = jSONObject.optString("userMsg");
            JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
            if (TextUtils.isEmpty(optString) || optJSONObject == null) {
                com.baidu.adp.lib.util.f.b("eventId == null or eventParam == null");
                return null;
            } else if (optString.equals("003")) {
                SystemMsgData systemMsgData = new SystemMsgData();
                systemMsgData.setIsSelf(true);
                systemMsgData.setContent(TbadkApplication.j().b().getString(com.baidu.tieba.im.j.kick_out_myself));
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
                if (optString3.equals(TbadkApplication.E())) {
                    systemMsgData3.setIsSelf(true);
                    systemMsgData3.setContent(TbadkApplication.j().b().getString(com.baidu.tieba.im.j.join_group_myself));
                } else {
                    systemMsgData3.setIsSelf(false);
                    systemMsgData3.setContent(String.valueOf(optString4) + TbadkApplication.j().b().getString(com.baidu.tieba.im.j.join_group));
                }
                return systemMsgData3;
            } else if (optString.equals("106")) {
                String optString5 = optJSONObject.optString("userId");
                SystemMsgData systemMsgData4 = new SystemMsgData();
                if (optString5.equals(TbadkApplication.E())) {
                    systemMsgData4.setIsSelf(true);
                    systemMsgData4.setContent(TbadkApplication.j().b().getString(com.baidu.tieba.im.j.kick_out_myself));
                } else {
                    systemMsgData4.setIsSelf(false);
                    systemMsgData4.setContent(optString2);
                }
                return systemMsgData4;
            } else if (optString.equals("002")) {
                SystemMsgData systemMsgData5 = new SystemMsgData();
                systemMsgData5.setIsSelf(true);
                systemMsgData5.setContent(TbadkApplication.j().b().getString(com.baidu.tieba.im.j.join_group_myself));
                return null;
            } else if (optString.equals("123")) {
                SystemMsgData systemMsgData6 = new SystemMsgData();
                systemMsgData6.setIsSelf(true);
                systemMsgData6.setContent(optString2);
                return systemMsgData6;
            } else {
                return null;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            com.baidu.adp.lib.util.f.b("transform erro" + e2.getMessage());
            return null;
        }
    }
}
