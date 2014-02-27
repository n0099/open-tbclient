package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.c.j;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.chat.q;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.h;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.i;
import com.baidu.tieba.im.util.l;
import com.baidu.tieba.mention.v;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
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
            i.a(new b(valueOf, linkedList), new c(cVar, valueOf, commonMsgPojo2, i2));
        }
    }

    public static boolean a(com.baidu.tieba.im.message.b bVar) {
        if (bVar.i() != 11) {
            return (bVar.g() == null || bVar.g().getUserId() == null || !bVar.g().getUserId().equals(TiebaApplication.v())) ? false : true;
        }
        SystemMsgData i = l.i(bVar);
        return (i == null || i.getIsSelf()) ? false : true;
    }

    public static void a(String str, com.baidu.tieba.im.message.b bVar) {
        if (bVar != null) {
            try {
                switch (bVar.i()) {
                    case 3:
                        VoiceMsgData f = l.f(bVar);
                        if (f != null) {
                            if (l.d(bVar)) {
                                f.setHas_read(1);
                            } else {
                                f.setHas_read(0);
                            }
                            bVar.a("[" + new Gson().toJson(f) + "]");
                            return;
                        }
                        return;
                    case 10:
                        if (bVar != null) {
                            String k = bVar.k();
                            if (!TextUtils.isEmpty(k)) {
                                String v = TiebaApplication.v();
                                try {
                                    JSONObject jSONObject = new JSONObject(k);
                                    int optInt = jSONObject.optInt("replyme");
                                    int optInt2 = jSONObject.optInt("fans");
                                    int optInt3 = jSONObject.optInt("atme");
                                    if (optInt < 0 || optInt2 < 0 || optInt3 < 0) {
                                        return;
                                    }
                                    if (TiebaApplication.g().G() <= 0) {
                                        optInt2 = 0;
                                        optInt = 0;
                                        optInt3 = 0;
                                    }
                                    if (!TiebaApplication.g().Q()) {
                                        optInt = 0;
                                    }
                                    if (!TiebaApplication.g().P()) {
                                        optInt3 = 0;
                                    }
                                    int i = TiebaApplication.g().O() ? optInt2 : 0;
                                    if (v == null || v.length() <= 0) {
                                        return;
                                    }
                                    v.a().a(optInt, optInt3, i, v.a().n(), v.a().p());
                                    return;
                                } catch (Exception e) {
                                    com.baidu.adp.lib.util.e.b("ChatMsgHelper", "parseContent error ", e.getMessage());
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    case 11:
                        if (bVar.i() == 11) {
                            String k2 = bVar.k();
                            String optString = new JSONObject(k2).optString("eventId");
                            if ("105".equals(optString) || "106".equals(optString)) {
                                com.baidu.tieba.im.message.i iVar = new com.baidu.tieba.im.message.i();
                                iVar.a(str);
                                com.baidu.tieba.im.messageCenter.d.a().e(iVar);
                                return;
                            } else if ("201".equals(optString) || "202".equals(optString) || "203".equals(optString) || "205".equals(optString)) {
                                com.baidu.tieba.im.message.c cVar = new com.baidu.tieba.im.message.c();
                                cVar.a(k2);
                                com.baidu.tieba.im.messageCenter.d.a().e(cVar);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(com.baidu.tieba.im.data.c cVar, String str, CommonMsgPojo commonMsgPojo, int i) {
        h.a().a(str, i, commonMsgPojo);
        if (!TextUtils.isEmpty(str) && !str.equals(j.a().e()) && (cVar == null || cVar.a() == null || cVar.a().getGroupType() != 8)) {
            j.a().a(commonMsgPojo);
        }
        q.b().a(cVar);
    }
}
