package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a c = null;
    public static int a = 0;
    private LinkedList<WeakReference<af>> d = new LinkedList<>();
    private n e = null;
    boolean b = false;

    public static void a(int i) {
        if (i != 0 && a != i) {
            if (a != 0) {
                com.baidu.adp.lib.h.e.a("私聊GID有变化!!!!!!!!!!!");
            }
            a = i;
            com.baidu.tieba.im.m.a(new b(i), null);
        }
    }

    private a() {
    }

    public void a() {
        this.e = new n(this, null);
        com.baidu.tieba.im.messageCenter.e.a().a(-100, this.e);
        com.baidu.tieba.im.messageCenter.e.a().a(202001, this.e);
        com.baidu.tieba.im.messageCenter.e.a().a(-103, this.e);
        com.baidu.tieba.im.messageCenter.e.a().a(-105, this.e);
        com.baidu.tieba.im.messageCenter.e.a().a(205001, this.e);
    }

    public static a b() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    public void a(af afVar) {
        boolean z;
        boolean z2 = false;
        Iterator<WeakReference<af>> it = this.d.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().get() == afVar ? true : z;
        }
        if (!z) {
            this.d.add(new WeakReference<>(afVar));
        }
    }

    public void b(af afVar) {
        WeakReference<af> weakReference;
        Iterator<WeakReference<af>> it = this.d.iterator();
        while (true) {
            if (!it.hasNext()) {
                weakReference = null;
                break;
            }
            weakReference = it.next();
            if (weakReference.get() == afVar) {
                break;
            }
        }
        if (weakReference != null) {
            this.d.remove(weakReference);
        }
    }

    public void a(String str, ag agVar) {
        com.baidu.tieba.im.db.d.a().a(str, 2, (String) null, LocationClientOption.MIN_SCAN_SPAN, new f(this, agVar));
    }

    public void b(String str, ag agVar) {
        com.baidu.tieba.im.db.as.a().a(str, 2, (String) null, LocationClientOption.MIN_SCAN_SPAN, new g(this, agVar));
    }

    public void a(com.baidu.tieba.im.message.b bVar) {
        com.baidu.adp.lib.h.e.d("SHNAG chatManager sendMessage, content = " + bVar.j());
        if (bVar instanceof com.baidu.tieba.im.message.e) {
            com.baidu.tieba.im.message.e eVar = (com.baidu.tieba.im.message.e) bVar;
            LinkedList<CommonMsgPojo> linkedList = new LinkedList<>();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(eVar);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            com.baidu.tieba.im.db.d.a().a(eVar.t(), linkedList, false, (com.baidu.tieba.im.a<Boolean>) new h(this, eVar));
        } else if (bVar instanceof com.baidu.tieba.im.message.s) {
            com.baidu.tieba.im.message.s sVar = (com.baidu.tieba.im.message.s) bVar;
            LinkedList<CommonMsgPojo> linkedList2 = new LinkedList<>();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo((com.baidu.tieba.im.message.s) bVar);
            commonMsgPojo2.setRead_flag(0);
            linkedList2.add(commonMsgPojo2);
            com.baidu.tieba.im.db.as.a().a(sVar.l(), sVar.b(), linkedList2, false, (com.baidu.tieba.im.a<Boolean>) new i(this, sVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.im.message.o oVar) {
        if (oVar instanceof com.baidu.tieba.im.data.b) {
            com.baidu.tieba.im.data.b bVar = (com.baidu.tieba.im.data.b) oVar;
            if (bVar.a() != null) {
                if (bVar.a().getGroupType() != 6) {
                    b(bVar);
                } else {
                    a(bVar);
                }
            }
        }
    }

    private void a(com.baidu.tieba.im.data.b bVar) {
        List<com.baidu.tieba.im.message.b> a2;
        long j;
        LinkedList linkedList;
        int i;
        a(bVar.a().getGroupId());
        com.baidu.adp.lib.h.e.d("GET Personal Gid PULLMSG=" + bVar.a().getGroupId());
        String valueOf = String.valueOf(bVar.a().getGroupId());
        com.baidu.tieba.im.data.e b = bVar.b();
        HashMap<String, o> hashMap = new HashMap<>();
        if (b != null && (a2 = b.a()) != null && a2.size() > 0) {
            LinkedList linkedList2 = new LinkedList();
            int i2 = 0;
            long j2 = 0;
            int i3 = 0;
            int size = a2.size();
            Iterator<com.baidu.tieba.im.message.b> it = a2.iterator();
            while (true) {
                int i4 = i3;
                LinkedList linkedList3 = linkedList2;
                int i5 = i2;
                long j3 = j2;
                if (it.hasNext()) {
                    com.baidu.tieba.im.message.b next = it.next();
                    VoiceMsgData f = com.baidu.tieba.im.d.d.f(next);
                    if (f != null) {
                        if (com.baidu.tieba.im.d.d.d(next)) {
                            f.setHas_read(1);
                        } else {
                            f.setHas_read(0);
                        }
                        next.a("[" + new Gson().toJson(f) + "]");
                    }
                    next.a(new MsgLocalData());
                    next.m().setStatus((short) 3);
                    if (next instanceof com.baidu.tieba.im.message.e) {
                        CommonMsgPojo commonMsgPojo = new CommonMsgPojo((com.baidu.tieba.im.message.e) next);
                        commonMsgPojo.setPrivate(true);
                        String uid = commonMsgPojo.getUid();
                        String toUid = commonMsgPojo.getToUid();
                        com.baidu.adp.lib.h.e.d("see content:" + commonMsgPojo);
                        com.baidu.adp.lib.h.e.d("see push private uidStr:" + uid + " toUidStr:" + toUid + " loginId:" + TiebaApplication.A());
                        if (TextUtils.isEmpty(uid)) {
                            com.baidu.adp.lib.h.e.d("see push private uidStr is null");
                            return;
                        } else if (toUid.equals(uid) && uid.equals(TiebaApplication.A())) {
                            com.baidu.adp.lib.h.e.d("see push private send msg to self");
                            return;
                        } else {
                            if (uid.equals(TiebaApplication.A())) {
                                com.baidu.adp.lib.h.e.d("see push private uid is loginid");
                            } else {
                                toUid = uid;
                            }
                            commonMsgPojo.setGid(toUid);
                            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(next);
                            long parseLong = Long.parseLong(toUid);
                            if (0 == j3) {
                                j = parseLong;
                                linkedList = linkedList3;
                            } else if (j3 == parseLong || i4 == size - 1) {
                                j = j3;
                                linkedList = linkedList3;
                            } else {
                                if (PersonalChatActivity.a && valueOf.equals(ba.d)) {
                                    i5 = 0;
                                }
                                CommonMsgPojo commonMsgPojo3 = (CommonMsgPojo) linkedList3.getLast();
                                com.baidu.adp.lib.h.e.d("see content1:" + commonMsgPojo + "lastPojo:" + commonMsgPojo3);
                                commonMsgPojo3.checkRidAndSelf();
                                String gid = commonMsgPojo3.getGid();
                                if (hashMap.get(gid) != null) {
                                    o oVar = hashMap.get(gid);
                                    oVar.b = commonMsgPojo3;
                                    oVar.c += i5;
                                } else {
                                    o oVar2 = new o(this);
                                    oVar2.a = gid;
                                    oVar2.b = commonMsgPojo3;
                                    oVar2.c = i5;
                                    hashMap.put(oVar2.a, oVar2);
                                }
                                i5 = 0;
                                j = parseLong;
                                linkedList = new LinkedList();
                            }
                            if (next.h() == 11) {
                                try {
                                    String optString = new JSONObject(next.j()).optString("eventId");
                                    if ("105".equals(optString) || "106".equals(optString)) {
                                        com.baidu.tieba.im.message.g gVar = new com.baidu.tieba.im.message.g();
                                        gVar.a(valueOf);
                                        com.baidu.tieba.im.messageCenter.e.a().e(gVar);
                                    }
                                    SystemMsgData i6 = com.baidu.tieba.im.d.d.i(next);
                                    if (i6 != null) {
                                        if (i6.getIsSelf()) {
                                            i5++;
                                            commonMsgPojo.setRead_flag(1);
                                        } else {
                                            commonMsgPojo.setRead_flag(0);
                                        }
                                    }
                                    i = i5;
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    i = i5;
                                }
                            } else if (next.f() != null && next.f().getId() != null && next.f().getId().equals(TiebaApplication.A())) {
                                com.baidu.adp.lib.h.e.d(" private insert 1 unreadCount:" + i5);
                                commonMsgPojo.setRead_flag(0);
                                i = i5;
                            } else {
                                com.baidu.adp.lib.h.e.d(" private insert 2 unreadCount:" + i5);
                                commonMsgPojo.setRead_flag(1);
                                i = i5 + 1;
                            }
                            linkedList.add(commonMsgPojo);
                            long parseLong2 = Long.parseLong(commonMsgPojo2.getUid());
                            long parseLong3 = Long.parseLong(commonMsgPojo2.getToUid());
                            LinkedList<CommonMsgPojo> linkedList4 = new LinkedList<>();
                            linkedList4.add(commonMsgPojo2);
                            com.baidu.adp.lib.h.e.d(" private insert to db:" + commonMsgPojo2 + " unreadCount:" + i);
                            com.baidu.tieba.im.db.as.a().a(parseLong2, parseLong3, linkedList4, true, (com.baidu.tieba.im.a<Boolean>) null);
                            if (i4 == size - 1) {
                                if (PersonalChatActivity.a && valueOf.equals(ba.d)) {
                                    i = 0;
                                }
                                CommonMsgPojo commonMsgPojo4 = (CommonMsgPojo) linkedList.getLast();
                                commonMsgPojo4.checkRidAndSelf();
                                String gid2 = commonMsgPojo4.getGid();
                                com.baidu.adp.lib.h.e.d("see content2:" + commonMsgPojo + "lastPojo:" + commonMsgPojo4);
                                if (hashMap.get(gid2) != null) {
                                    o oVar3 = hashMap.get(gid2);
                                    oVar3.b = commonMsgPojo4;
                                    oVar3.c += i;
                                } else {
                                    o oVar4 = new o(this);
                                    oVar4.a = gid2;
                                    oVar4.b = commonMsgPojo4;
                                    oVar4.c = i;
                                    hashMap.put(oVar4.a, oVar4);
                                }
                                linkedList = new LinkedList();
                                i = 0;
                                j2 = parseLong3;
                            } else {
                                j2 = j;
                            }
                            i2 = i;
                            linkedList2 = linkedList;
                            i3 = i4 + 1;
                        }
                    } else {
                        return;
                    }
                } else {
                    this.b = false;
                    com.baidu.tieba.im.db.ag.a().a(hashMap, new j(this, bVar));
                    return;
                }
            }
        }
    }

    private void b(com.baidu.tieba.im.data.b bVar) {
        List<com.baidu.tieba.im.message.b> a2;
        String valueOf = String.valueOf(bVar.a().getGroupId());
        com.baidu.tieba.im.data.e b = bVar.b();
        if (b != null && (a2 = b.a()) != null && a2.size() > 0) {
            LinkedList<CommonMsgPojo> linkedList = new LinkedList<>();
            int i = 0;
            for (com.baidu.tieba.im.message.b bVar2 : a2) {
                VoiceMsgData f = com.baidu.tieba.im.d.d.f(bVar2);
                if (f != null) {
                    if (com.baidu.tieba.im.d.d.d(bVar2)) {
                        f.setHas_read(1);
                    } else {
                        f.setHas_read(0);
                    }
                    bVar2.a("[" + new Gson().toJson(f) + "]");
                }
                bVar2.a(new MsgLocalData());
                bVar2.m().setStatus((short) 3);
                if (bVar2 instanceof com.baidu.tieba.im.message.e) {
                    CommonMsgPojo commonMsgPojo = new CommonMsgPojo((com.baidu.tieba.im.message.e) bVar2);
                    if (bVar2.h() == 11) {
                        try {
                            String optString = new JSONObject(bVar2.j()).optString("eventId");
                            if ("105".equals(optString) || "106".equals(optString)) {
                                com.baidu.tieba.im.message.g gVar = new com.baidu.tieba.im.message.g();
                                gVar.a(valueOf);
                                com.baidu.tieba.im.messageCenter.e.a().e(gVar);
                            }
                            SystemMsgData i2 = com.baidu.tieba.im.d.d.i(bVar2);
                            if (i2 != null) {
                                if (i2.getIsSelf()) {
                                    i++;
                                    commonMsgPojo.setRead_flag(1);
                                } else {
                                    commonMsgPojo.setRead_flag(0);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } else if (bVar2.f() != null && bVar2.f().getId() != null && bVar2.f().getId().equals(TiebaApplication.A())) {
                        commonMsgPojo.setRead_flag(0);
                    } else {
                        i++;
                        commonMsgPojo.setRead_flag(1);
                    }
                    linkedList.add(commonMsgPojo);
                    i = i;
                } else {
                    return;
                }
            }
            int i3 = (GroupChatActivity.a && valueOf.equals(ba.c)) ? 0 : i;
            CommonMsgPojo last = linkedList.getLast();
            last.checkRidAndSelf();
            com.baidu.tieba.im.db.d.a().a(valueOf, linkedList, true, (com.baidu.tieba.im.a<Boolean>) new k(this, bVar, valueOf, last, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.im.message.o oVar) {
        if (oVar instanceof com.baidu.tieba.im.message.ba) {
            com.baidu.tieba.im.message.ba baVar = (com.baidu.tieba.im.message.ba) oVar;
            com.baidu.adp.lib.h.e.d("SHANG ChatResponsedMessage onAcked");
            if (baVar.i()) {
                a((com.baidu.tieba.im.message.cc) baVar);
            } else {
                a(baVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.im.message.o oVar) {
        if (oVar instanceof com.baidu.tieba.im.message.bd) {
            com.baidu.tieba.im.message.bd bdVar = (com.baidu.tieba.im.message.bd) oVar;
            com.baidu.adp.lib.h.e.d("SHANG ChatResponsedMessage onAcked");
            if (bdVar.i()) {
                a((com.baidu.tieba.im.message.cc) bdVar);
            } else {
                int a2 = com.baidu.adp.lib.f.b.a(bdVar.c(), 0);
                a(a2);
                com.baidu.adp.lib.h.e.d("GET Personal Gid MSGACK=" + a2);
            }
            a(bdVar);
        }
    }

    private void a(com.baidu.tieba.im.message.cc ccVar) {
        if (ccVar != null && ccVar.l() != null) {
            com.baidu.tieba.im.message.b bVar = (com.baidu.tieba.im.message.b) ccVar.l();
            if (bVar == null) {
                com.baidu.adp.lib.h.e.a("chatMessage == null");
            } else if (bVar instanceof com.baidu.tieba.im.message.e) {
                com.baidu.tieba.im.db.d.a().a(((com.baidu.tieba.im.message.e) bVar).t(), String.valueOf(bVar.i()), String.valueOf(bVar.k()), 2, new l(this, ccVar));
            } else if (bVar instanceof com.baidu.tieba.im.message.s) {
                com.baidu.tieba.im.message.s sVar = (com.baidu.tieba.im.message.s) bVar;
                com.baidu.tieba.im.db.as.a().a(sVar.l(), sVar.b(), String.valueOf(bVar.i()), String.valueOf(bVar.k()), 2, new m(this, ccVar));
            }
        }
    }

    private void a(com.baidu.tieba.im.message.ba baVar) {
        com.baidu.tieba.im.db.d.a().a(baVar.c(), String.valueOf(baVar.b()), String.valueOf(baVar.a()), 3, new c(this, baVar));
    }

    private void a(com.baidu.tieba.im.message.bd bdVar) {
        com.baidu.tieba.im.db.as.a().a(com.baidu.adp.lib.f.b.a(TiebaApplication.A(), 0L), com.baidu.adp.lib.f.b.a(bdVar.d(), 0L), String.valueOf(bdVar.b()), String.valueOf(bdVar.a()), 3, new d(this, bdVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.im.data.b bVar, String str, CommonMsgPojo commonMsgPojo, int i) {
        com.baidu.tieba.im.db.ag.a().a(str, i, commonMsgPojo, new e(this, str, commonMsgPojo));
        d(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.im.message.o oVar) {
        Iterator<WeakReference<af>> it = this.d.iterator();
        while (it.hasNext()) {
            af afVar = it.next().get();
            if (afVar != null) {
                afVar.a(oVar);
            }
        }
    }
}
