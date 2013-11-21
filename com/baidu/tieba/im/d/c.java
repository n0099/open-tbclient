package com.baidu.tieba.im.d;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.message.ChatMessage;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.slidingmenu.lib.R;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static short f1588a = 1;
    private static short b = 2;
    private static short c = 3;

    public static String a(String str, boolean z) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        try {
            str2 = new JSONArray(str).getJSONObject(0).optString(z ? "big_src" : "src");
            return str2;
        } catch (Exception e) {
            return str2;
        }
    }

    public static String a(JSONObject jSONObject, boolean z) {
        return jSONObject.optString(z ? "big_src" : "src");
    }

    public static boolean a(ChatMessage chatMessage) {
        return chatMessage != null && chatMessage.getMsgType() == b;
    }

    public static boolean b(ChatMessage chatMessage) {
        return chatMessage != null && chatMessage.getMsgType() == c;
    }

    public static boolean c(ChatMessage chatMessage) {
        try {
            if (chatMessage.getMsgType() != 11 && TiebaApplication.B()) {
                return chatMessage.getUserInfo().getId().equals(TiebaApplication.A());
            }
            return false;
        } catch (Exception e) {
            com.baidu.adp.lib.h.d.b("LocalUtil", "isAuthor", "Msg Author is Null");
            return false;
        }
    }

    public static MsgCacheData d(ChatMessage chatMessage) {
        try {
            MsgCacheData msgCacheData = new MsgCacheData();
            msgCacheData.setRich_content(null);
            return msgCacheData;
        } catch (Exception e) {
            com.baidu.adp.lib.h.d.b("LocalUtil", "getMsgCacheData", "error:" + e.getMessage());
            return null;
        }
    }

    public static VoiceMsgData e(ChatMessage chatMessage) {
        VoiceMsgData voiceMsgData;
        Exception e;
        if (chatMessage == null || chatMessage.getMsgType() != 3) {
            return null;
        }
        if (chatMessage.getObjContent() != null) {
            return (VoiceMsgData) chatMessage.getObjContent();
        }
        String content = chatMessage.getContent();
        if (TextUtils.isEmpty(content)) {
            VoiceMsgData voiceMsgData2 = new VoiceMsgData();
            chatMessage.setObjContent(voiceMsgData2);
            return voiceMsgData2;
        }
        try {
            Gson gson = new Gson();
            JsonArray asJsonArray = new JsonParser().parse(content).getAsJsonArray();
            if (asJsonArray == null || asJsonArray.size() <= 0) {
                return null;
            }
            Iterator<JsonElement> it = asJsonArray.iterator();
            voiceMsgData = it.hasNext() ? (VoiceMsgData) gson.fromJson(it.next(), (Class<Object>) VoiceMsgData.class) : null;
            try {
                chatMessage.setObjContent(voiceMsgData);
                return voiceMsgData;
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.h.d.b("LocalUtil", "deserializerVoiceMsgData", "error:" + e.getMessage());
                return voiceMsgData;
            }
        } catch (Exception e3) {
            voiceMsgData = null;
            e = e3;
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String f(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return null;
        }
        if (chatMessage.getMsgType() == 1) {
            String a2 = (chatMessage.getContent().length() <= 1 || chatMessage.getContent().charAt(0) != '[') ? null : a(chatMessage.getContent());
            if (TextUtils.isEmpty(a2)) {
                a2 = chatMessage.getContent();
            }
            if (a2 != null) {
                return a2;
            }
            return null;
        } else if (chatMessage.getMsgType() == 2) {
            return TiebaApplication.g().getString(R.string.last_msg_pic);
        } else {
            if (chatMessage.getMsgType() == 3) {
                return TiebaApplication.g().getString(R.string.last_msg_voice);
            }
            if (chatMessage.getMsgType() == 11) {
                return b(chatMessage.getContent());
            }
            return null;
        }
    }

    public static String g(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return null;
        }
        String str = "";
        UserData userInfo = chatMessage.getUserInfo();
        if (userInfo != null && !TextUtils.isEmpty(userInfo.getName())) {
            str = chatMessage.getUserInfo().getName();
        }
        if (!TextUtils.isEmpty(userInfo.getId()) && userInfo.getId().equals(TiebaApplication.A())) {
            return f(chatMessage);
        }
        if (chatMessage.getMsgType() == 11) {
            return f(chatMessage);
        }
        if (!TextUtils.isEmpty(str)) {
            return str + ":" + f(chatMessage);
        }
        return f(chatMessage);
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
                    com.baidu.adp.lib.h.d.a("eventId == null or eventParam == null");
                } else if (optString.equals("003")) {
                    str2 = TiebaApplication.g().getString(R.string.kick_out_myself);
                } else if (optString.equals("105")) {
                    String optString3 = optJSONObject.optString("userId");
                    String optString4 = optJSONObject.optString("userName");
                    if (optString3.equals(TiebaApplication.A())) {
                        str2 = TiebaApplication.g().getString(R.string.join_group_myself);
                    } else {
                        str2 = optString4 + TiebaApplication.g().getString(R.string.join_group);
                    }
                } else if (optString.equals("106")) {
                    String optString5 = optJSONObject.optString("userId");
                    optJSONObject.optString("userName");
                    str2 = optString5.equals(TiebaApplication.A()) ? TiebaApplication.g().getString(R.string.kick_out_myself) : optString2;
                } else if (optString.equals("002")) {
                    str2 = TiebaApplication.g().getString(R.string.join_group_myself);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                com.baidu.adp.lib.h.d.a("transform erro" + e.getMessage());
            }
        }
        return str2;
    }

    public static SystemMsgData h(ChatMessage chatMessage) {
        if (chatMessage == null || chatMessage.getMsgType() != 11 || TextUtils.isEmpty(chatMessage.getContent())) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(chatMessage.getContent());
            String optString = jSONObject.optString("eventId");
            String optString2 = jSONObject.optString("userMsg");
            JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
            if (TextUtils.isEmpty(optString) || optJSONObject == null) {
                com.baidu.adp.lib.h.d.a("eventId == null or eventParam == null");
                return null;
            } else if (optString.equals("003")) {
                SystemMsgData systemMsgData = new SystemMsgData();
                systemMsgData.setIsSelf(true);
                systemMsgData.setContent(TiebaApplication.g().getString(R.string.kick_out_myself));
                return systemMsgData;
            } else if (optString.equals("105")) {
                String optString3 = optJSONObject.optString("userId");
                String optString4 = optJSONObject.optString("userName");
                SystemMsgData systemMsgData2 = new SystemMsgData();
                if (optString3.equals(TiebaApplication.A())) {
                    systemMsgData2.setIsSelf(true);
                    systemMsgData2.setContent(TiebaApplication.g().getString(R.string.join_group_myself));
                } else {
                    systemMsgData2.setIsSelf(false);
                    systemMsgData2.setContent(optString4 + TiebaApplication.g().getString(R.string.join_group));
                }
                return systemMsgData2;
            } else if (optString.equals("106")) {
                String optString5 = optJSONObject.optString("userId");
                optJSONObject.optString("userName");
                SystemMsgData systemMsgData3 = new SystemMsgData();
                if (optString5.equals(TiebaApplication.A())) {
                    systemMsgData3.setIsSelf(true);
                    systemMsgData3.setContent(TiebaApplication.g().getString(R.string.kick_out_myself));
                } else {
                    systemMsgData3.setIsSelf(false);
                    systemMsgData3.setContent(optString2);
                }
                return systemMsgData3;
            } else if (optString.equals("002")) {
                SystemMsgData systemMsgData4 = new SystemMsgData();
                systemMsgData4.setIsSelf(true);
                systemMsgData4.setContent(TiebaApplication.g().getString(R.string.join_group_myself));
                return null;
            } else {
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            com.baidu.adp.lib.h.d.a("transform erro" + e.getMessage());
            return null;
        }
    }
}
