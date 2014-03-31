package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.message.ChatRoomEventResponseMessage;
import com.baidu.tieba.im.message.GroupMemberChangeResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {
    public static boolean a(com.baidu.tieba.im.message.a.a aVar) {
        if (aVar.t() != 11) {
            return (aVar.r() == null || aVar.r().getUserId() == null || !aVar.r().getUserId().equals(TbadkApplication.E())) ? false : true;
        }
        SystemMsgData i = com.baidu.tieba.im.f.q.i(aVar);
        return (i == null || i.getIsSelf()) ? false : true;
    }

    public static void a(String str, com.baidu.tieba.im.message.a.a aVar) {
        if (aVar != null) {
            try {
                switch (aVar.t()) {
                    case 3:
                        VoiceMsgData f = com.baidu.tieba.im.f.q.f(aVar);
                        if (f != null) {
                            if (com.baidu.tieba.im.f.q.d(aVar)) {
                                f.setHas_read(1);
                            } else {
                                f.setHas_read(0);
                            }
                            aVar.d("[" + new Gson().toJson(f) + "]");
                            return;
                        }
                        return;
                    case 10:
                        if (aVar != null) {
                            String v = aVar.v();
                            if (!TextUtils.isEmpty(v)) {
                                String E = TbadkApplication.E();
                                try {
                                    JSONObject jSONObject = new JSONObject(v);
                                    int optInt = jSONObject.optInt("replyme");
                                    int optInt2 = jSONObject.optInt("zan");
                                    if (optInt2 > 0) {
                                        optInt += optInt2;
                                    }
                                    int optInt3 = jSONObject.optInt("fans");
                                    int optInt4 = jSONObject.optInt("atme");
                                    if (optInt < 0 || optInt3 < 0 || optInt4 < 0) {
                                        return;
                                    }
                                    if (TbadkApplication.j().ag() <= 0) {
                                        optInt3 = 0;
                                        optInt = 0;
                                        optInt4 = 0;
                                    }
                                    if (!TbadkApplication.j().aj()) {
                                        optInt -= optInt2;
                                    }
                                    if (!TbadkApplication.j().ai()) {
                                        optInt = 0;
                                    }
                                    if (!TbadkApplication.j().ah()) {
                                        optInt4 = 0;
                                    }
                                    int i = TbadkApplication.j().ak() ? optInt3 : 0;
                                    if (E == null || E.length() <= 0) {
                                        return;
                                    }
                                    com.baidu.tbadk.coreExtra.messageCenter.a.a().a(optInt, optInt4, i, com.baidu.tbadk.coreExtra.messageCenter.a.a().l(), com.baidu.tbadk.coreExtra.messageCenter.a.a().n());
                                    return;
                                } catch (Exception e) {
                                    com.baidu.adp.lib.util.f.b("ChatMsgHelper", "parseContent error ", e.getMessage());
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    case 11:
                        if (aVar.t() == 11) {
                            String v2 = aVar.v();
                            String optString = new JSONObject(v2).optString("eventId");
                            if ("105".equals(optString) || "106".equals(optString)) {
                                com.baidu.adp.framework.c.a().b(new GroupMemberChangeResponsedMessage(str));
                                return;
                            } else if ("201".equals(optString) || "202".equals(optString) || "203".equals(optString) || "205".equals(optString)) {
                                com.baidu.adp.framework.c.a().b(new ChatRoomEventResponseMessage(v2));
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    default:
                        return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
