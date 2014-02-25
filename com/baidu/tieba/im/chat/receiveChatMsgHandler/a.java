package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.chat.q;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.h;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.j;
import com.baidu.tieba.im.message.i;
import com.baidu.tieba.im.util.l;
import com.baidu.tieba.mention.v;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static void b(com.baidu.tieba.im.message.b bVar) {
        VoiceMsgData g = l.g(bVar);
        if (g != null) {
            if (l.d(bVar)) {
                g.setHas_read(1);
            } else {
                g.setHas_read(0);
            }
            bVar.a("[" + new Gson().toJson(g) + "]");
        }
    }

    public static void a(com.baidu.tieba.im.data.c cVar) {
        List<com.baidu.tieba.im.message.b> a;
        int i;
        String valueOf = String.valueOf(cVar.a().getGroupId());
        com.baidu.tieba.im.data.f b = cVar.b();
        if (b != null && (a = b.a()) != null && a.size() > 0) {
            LinkedList linkedList = new LinkedList();
            int i2 = 0;
            for (com.baidu.tieba.im.message.b bVar : a) {
                bVar.a(new MsgLocalData());
                bVar.n().setStatus((short) 3);
                if (bVar instanceof com.baidu.tieba.im.message.g) {
                    CommonMsgPojo commonMsgPojo = new CommonMsgPojo(bVar);
                    a(valueOf, bVar);
                    if (a(bVar)) {
                        commonMsgPojo.setRead_flag(0);
                        i = i2;
                    } else {
                        i = i2 + 1;
                        commonMsgPojo.setRead_flag(1);
                    }
                    linkedList.add(commonMsgPojo);
                    i2 = i;
                } else {
                    return;
                }
            }
            if (GroupChatActivity.a && valueOf.equals(GroupChatActivity.b)) {
                i2 = 0;
            }
            CommonMsgPojo commonMsgPojo2 = (CommonMsgPojo) linkedList.getLast();
            commonMsgPojo2.checkRidAndSelf();
            j.a(new b(valueOf, linkedList), new c(cVar, valueOf, commonMsgPojo2, i2));
        }
    }

    public static boolean a(com.baidu.tieba.im.message.b bVar) {
        if (bVar.i() != 11) {
            return (bVar.g() == null || bVar.g().getUserId() == null || !bVar.g().getUserId().equals(TiebaApplication.A())) ? false : true;
        }
        SystemMsgData j = l.j(bVar);
        return (j == null || j.getIsSelf()) ? false : true;
    }

    public static void a(String str, com.baidu.tieba.im.message.b bVar) {
        if (bVar != null) {
            try {
                switch (bVar.i()) {
                    case 3:
                        b(bVar);
                        break;
                    case 10:
                        c(bVar);
                        break;
                    case 11:
                        b(str, bVar);
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void b(String str, com.baidu.tieba.im.message.b bVar) {
        if (bVar.i() == 11) {
            String k = bVar.k();
            String optString = new JSONObject(k).optString("eventId");
            if ("105".equals(optString) || "106".equals(optString)) {
                i iVar = new i();
                iVar.a(str);
                com.baidu.tieba.im.messageCenter.e.a().e(iVar);
            } else if ("201".equals(optString) || "202".equals(optString) || "203".equals(optString) || "205".equals(optString)) {
                com.baidu.tieba.im.message.c cVar = new com.baidu.tieba.im.message.c();
                cVar.a(k);
                com.baidu.tieba.im.messageCenter.e.a().e(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.baidu.tieba.im.data.c cVar, String str, CommonMsgPojo commonMsgPojo, int i) {
        h.a().a(str, i, commonMsgPojo);
        if (!TextUtils.isEmpty(str) && !str.equals(com.baidu.tieba.im.c.j.a().e())) {
            com.baidu.tieba.im.c.j.a().a(commonMsgPojo);
        }
        q.b().a(cVar);
    }

    private static void c(com.baidu.tieba.im.message.b bVar) {
        if (bVar != null) {
            String k = bVar.k();
            if (!TextUtils.isEmpty(k)) {
                String A = TiebaApplication.A();
                try {
                    JSONObject jSONObject = new JSONObject(k);
                    int optInt = jSONObject.optInt("replyme");
                    int optInt2 = jSONObject.optInt("fans");
                    int optInt3 = jSONObject.optInt("atme");
                    int optInt4 = jSONObject.optInt("storethread");
                    if (optInt >= 0 && optInt2 >= 0 && optInt3 >= 0 && optInt4 >= 0) {
                        if (!TiebaApplication.g().W()) {
                            optInt = 0;
                        }
                        if (!TiebaApplication.g().V()) {
                            optInt3 = 0;
                        }
                        int i = TiebaApplication.g().U() ? optInt2 : 0;
                        if (A != null && A.length() > 0) {
                            v.a().a(optInt, optInt3, i, 0, optInt4);
                        }
                    }
                } catch (Exception e) {
                    com.baidu.adp.lib.util.f.b("ChatMsgHelper", "parseContent error ", e.getMessage());
                }
            }
        }
    }
}
