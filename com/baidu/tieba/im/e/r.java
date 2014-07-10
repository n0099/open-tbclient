package com.baidu.tieba.im.e;

import android.content.Context;
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
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.y;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private static Pattern a = Pattern.compile("(#\\([^#\\)\\(]+\\))");

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
        return chatMessage != null && chatMessage.getMsgType() == 2;
    }

    public static boolean b(ChatMessage chatMessage) {
        return chatMessage != null && chatMessage.getMsgType() == 4;
    }

    public static boolean c(ChatMessage chatMessage) {
        return chatMessage != null && chatMessage.getMsgType() == 3;
    }

    public static boolean d(ChatMessage chatMessage) {
        try {
            if (chatMessage.getMsgType() != 11 && TbadkApplication.isLogin()) {
                return chatMessage.getUserInfo().getUserId().equals(TbadkApplication.getCurrentAccount());
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean e(ChatMessage chatMessage) {
        return chatMessage != null && chatMessage.getMsgType() == 6;
    }

    public static MsgCacheData f(ChatMessage chatMessage) {
        try {
            MsgCacheData msgCacheData = new MsgCacheData();
            msgCacheData.setRich_content(null);
            return msgCacheData;
        } catch (Exception e) {
            return null;
        }
    }

    public static VoiceMsgData g(ChatMessage chatMessage) {
        if (chatMessage == null || chatMessage.getMsgType() != 3) {
            return null;
        }
        if (chatMessage.getObjContent() != null) {
            return (VoiceMsgData) chatMessage.getObjContent();
        }
        String content = chatMessage.getContent();
        if (TextUtils.isEmpty(content)) {
            VoiceMsgData voiceMsgData = new VoiceMsgData();
            chatMessage.setObjContent(voiceMsgData);
            return voiceMsgData;
        }
        try {
            Gson gson = new Gson();
            JsonArray asJsonArray = new JsonParser().parse(content).getAsJsonArray();
            if (asJsonArray == null || asJsonArray.size() <= 0) {
                return null;
            }
            Iterator<JsonElement> it = asJsonArray.iterator();
            VoiceMsgData voiceMsgData2 = it.hasNext() ? (VoiceMsgData) gson.fromJson(it.next(), (Class<Object>) VoiceMsgData.class) : null;
            try {
                chatMessage.setObjContent(voiceMsgData2);
                return voiceMsgData2;
            } catch (Exception e) {
                return voiceMsgData2;
            }
        } catch (Exception e2) {
            return null;
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

    private static final String b(String str) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() >= 2) {
                String optString = jSONArray.optString(0);
                if (1 == jSONArray.optInt(1)) {
                    sb.append(TbadkApplication.m252getInst().getString(y.last_msg_extra_share));
                }
                if (optString != null) {
                    sb.append(optString);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String h(ChatMessage chatMessage) {
        int i = 0;
        if (chatMessage == null) {
            return null;
        }
        if (chatMessage.getMsgType() == 1) {
            String a2 = (chatMessage.getContent().length() <= 1 || chatMessage.getContent().charAt(0) != '[') ? null : a(chatMessage.getContent());
            if (TextUtils.isEmpty(a2)) {
                a2 = chatMessage.getContent();
            }
            if (a2 != null) {
                Matcher matcher = a.matcher(a2);
                while (matcher.find()) {
                    String group = matcher.group();
                    a2 = a2.replace(group, group.replace("#(", "[").replace(")", "]"));
                }
                return a2;
            }
            return null;
        } else if (chatMessage.getMsgType() == 2) {
            return TbadkApplication.m252getInst().getApp().getString(y.last_msg_pic);
        } else {
            if (chatMessage.getMsgType() == 3) {
                return TbadkApplication.m252getInst().getApp().getString(y.last_msg_voice);
            }
            if (chatMessage.getMsgType() == 11) {
                return c(chatMessage.getContent());
            }
            if (chatMessage.getMsgType() == 4) {
                String content = chatMessage.getContent();
                try {
                    JSONArray jSONArray = new JSONArray(content);
                    if (jSONArray.length() > 0) {
                        String optString = jSONArray.getJSONObject(0).optString("face_name");
                        if (optString != null && optString.startsWith("#(") && optString.endsWith(")")) {
                            optString = "[" + optString.substring(2, optString.length() - 1) + "]";
                        }
                        return optString;
                    }
                    return null;
                } catch (JSONException e) {
                    e.printStackTrace();
                    try {
                        String optString2 = new JSONObject(content).optString("face_name");
                        if (optString2 != null && optString2.startsWith("#(") && optString2.endsWith(")")) {
                            optString2 = "[" + optString2.substring(2, optString2.length() - 1) + "]";
                        }
                        return optString2;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        return null;
                    }
                }
            } else if (chatMessage.getMsgType() == 5) {
                return TbadkApplication.m252getInst().getApp().getString(y.last_msg_invite);
            } else {
                if (chatMessage.getMsgType() == 6) {
                    String str = "";
                    try {
                        str = new JSONObject(chatMessage.getContent()).optString("userMsg");
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    return str;
                } else if (chatMessage.getMsgType() == 7) {
                    String content2 = chatMessage.getContent();
                    String string = TbadkApplication.m252getInst().getApp().getString(y.last_msg_pic_text);
                    if (!TextUtils.isEmpty(content2)) {
                        try {
                            JSONArray jSONArray2 = new JSONArray(content2);
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
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                            return string;
                        }
                    } else {
                        return string;
                    }
                } else if (chatMessage.getMsgType() == 9) {
                    return b(chatMessage.getContent());
                } else {
                    return null;
                }
            }
        }
    }

    public static String i(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return null;
        }
        String str = "";
        UserData userInfo = chatMessage.getUserInfo();
        if (userInfo != null && !TextUtils.isEmpty(userInfo.getUserName())) {
            str = chatMessage.getUserInfo().getUserName();
        }
        if (userInfo != null && !TextUtils.isEmpty(userInfo.getUserId()) && userInfo.getUserId().equals(TbadkApplication.getCurrentAccount())) {
            return h(chatMessage);
        }
        if (chatMessage.getMsgType() == 11) {
            return h(chatMessage);
        }
        if (chatMessage.getToUserId() != 0) {
            return h(chatMessage);
        }
        if (!TextUtils.isEmpty(str)) {
            return String.valueOf(str) + ":" + h(chatMessage);
        }
        return h(chatMessage);
    }

    private static String c(String str) {
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("eventId");
                String optString2 = jSONObject.optString("userMsg");
                JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
                if (!TextUtils.isEmpty(optString)) {
                    if (optString.equals("-10001")) {
                        str2 = optString2;
                    } else if (optJSONObject != null) {
                        if (optString.equals("003")) {
                            str2 = TbadkApplication.m252getInst().getApp().getString(y.kick_out_myself);
                        } else if (optString.equals("122") || optString.equals("121")) {
                            str2 = optString2;
                        } else if (optString.equals("105")) {
                            String optString3 = optJSONObject.optString("userId");
                            String optString4 = optJSONObject.optString("userName");
                            if (optString3.equals(TbadkApplication.getCurrentAccount())) {
                                str2 = TbadkApplication.m252getInst().getApp().getString(y.join_group_myself);
                            } else {
                                str2 = String.valueOf(optString4) + TbadkApplication.m252getInst().getApp().getString(y.join_group);
                            }
                        } else if (optString.equals("106")) {
                            str2 = optJSONObject.optString("userId").equals(TbadkApplication.getCurrentAccount()) ? TbadkApplication.m252getInst().getApp().getString(y.kick_out_myself) : optString2;
                        } else if (optString.equals("002")) {
                            str2 = TbadkApplication.m252getInst().getApp().getString(y.join_group_myself);
                        } else if (optString.equals("109")) {
                            str2 = optString2;
                        } else if (optString.equals("110")) {
                            str2 = optString2;
                        } else if (optString.equals("202")) {
                            str2 = String.valueOf(optJSONObject.optString("userName")) + TbadkApplication.m252getInst().getApp().getString(y.snap_group_chat_exit);
                        } else if (optString.equals("123")) {
                            str2 = optString2;
                        } else if (optString.equals("304")) {
                            str2 = optString2;
                        } else {
                            str2 = optString.equals("305") ? optString2 : optString2;
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return str2;
    }

    public static SystemMsgData j(ChatMessage chatMessage) {
        if (chatMessage == null || chatMessage.getMsgType() != 11 || TextUtils.isEmpty(chatMessage.getContent())) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(chatMessage.getContent());
            String optString = jSONObject.optString("eventId");
            String optString2 = jSONObject.optString("userMsg");
            JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
            if (TextUtils.isEmpty(optString) || optJSONObject == null) {
                return null;
            }
            if (optString.equals("003")) {
                SystemMsgData systemMsgData = new SystemMsgData();
                systemMsgData.setIsSelf(true);
                systemMsgData.setContent(TbadkApplication.m252getInst().getApp().getString(y.kick_out_myself));
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
                if (optString3.equals(TbadkApplication.getCurrentAccount())) {
                    systemMsgData3.setIsSelf(true);
                    systemMsgData3.setContent(TbadkApplication.m252getInst().getApp().getString(y.join_group_myself));
                } else {
                    systemMsgData3.setIsSelf(false);
                    systemMsgData3.setContent(String.valueOf(optString4) + TbadkApplication.m252getInst().getApp().getString(y.join_group));
                }
                return systemMsgData3;
            } else if (optString.equals("106")) {
                String optString5 = optJSONObject.optString("userId");
                SystemMsgData systemMsgData4 = new SystemMsgData();
                if (optString5.equals(TbadkApplication.getCurrentAccount())) {
                    systemMsgData4.setIsSelf(true);
                    systemMsgData4.setContent(TbadkApplication.m252getInst().getApp().getString(y.kick_out_myself));
                } else {
                    systemMsgData4.setIsSelf(false);
                    systemMsgData4.setContent(optString2);
                }
                return systemMsgData4;
            } else if (optString.equals("002")) {
                SystemMsgData systemMsgData5 = new SystemMsgData();
                systemMsgData5.setIsSelf(true);
                systemMsgData5.setContent(TbadkApplication.m252getInst().getApp().getString(y.join_group_myself));
                return null;
            } else if (optString.equals("123")) {
                SystemMsgData systemMsgData6 = new SystemMsgData();
                systemMsgData6.setIsSelf(true);
                systemMsgData6.setContent(optString2);
                return systemMsgData6;
            } else {
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int a(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }
}
