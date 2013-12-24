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
    private LinkedList<WeakReference<ag>> d = new LinkedList<>();
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

    public void a(ag agVar) {
        boolean z;
        boolean z2 = false;
        Iterator<WeakReference<ag>> it = this.d.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().get() == agVar ? true : z;
        }
        if (!z) {
            this.d.add(new WeakReference<>(agVar));
        }
    }

    public void b(ag agVar) {
        WeakReference<ag> weakReference;
        Iterator<WeakReference<ag>> it = this.d.iterator();
        while (true) {
            if (!it.hasNext()) {
                weakReference = null;
                break;
            }
            weakReference = it.next();
            if (weakReference.get() == agVar) {
                break;
            }
        }
        if (weakReference != null) {
            this.d.remove(weakReference);
        }
    }

    public void a(String str, ah ahVar) {
        com.baidu.tieba.im.db.d.a().a(str, 2, (String) null, LocationClientOption.MIN_SCAN_SPAN, new f(this, ahVar));
    }

    public void b(String str, ah ahVar) {
        com.baidu.tieba.im.db.ar.a().a(str, 2, (String) null, LocationClientOption.MIN_SCAN_SPAN, new g(this, ahVar));
    }

    public void a(com.baidu.tieba.im.message.b bVar) {
        com.baidu.adp.lib.h.e.d("SHNAG chatManager sendMessage, content = " + bVar.j());
        if (bVar instanceof com.baidu.tieba.im.message.d) {
            com.baidu.tieba.im.message.d dVar = (com.baidu.tieba.im.message.d) bVar;
            LinkedList<CommonMsgPojo> linkedList = new LinkedList<>();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(dVar);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            com.baidu.tieba.im.db.d.a().a(dVar.s(), linkedList, false, (com.baidu.tieba.im.a<Boolean>) new h(this, dVar));
        } else if (bVar instanceof com.baidu.tieba.im.message.p) {
            com.baidu.tieba.im.message.p pVar = (com.baidu.tieba.im.message.p) bVar;
            LinkedList<CommonMsgPojo> linkedList2 = new LinkedList<>();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo((com.baidu.tieba.im.message.p) bVar);
            commonMsgPojo2.setRead_flag(0);
            linkedList2.add(commonMsgPojo2);
            com.baidu.tieba.im.db.ar.a().a(pVar.l(), pVar.b(), linkedList2, false, (com.baidu.tieba.im.a<Boolean>) new i(this, pVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.im.message.n nVar) {
        if (nVar instanceof com.baidu.tieba.im.data.c) {
            com.baidu.tieba.im.data.c cVar = (com.baidu.tieba.im.data.c) nVar;
            if (cVar.a() != null) {
                if (cVar.a().getGroupType() != 6) {
                    b(cVar);
                } else {
                    a(cVar);
                }
            }
        }
    }

    private void a(com.baidu.tieba.im.data.c cVar) {
        List<com.baidu.tieba.im.message.b> a2;
        long j;
        LinkedList linkedList;
        int i;
        a(cVar.a().getGroupId());
        com.baidu.adp.lib.h.e.d("GET Personal Gid PULLMSG=" + cVar.a().getGroupId());
        String valueOf = String.valueOf(cVar.a().getGroupId());
        com.baidu.tieba.im.data.f b = cVar.b();
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
                    VoiceMsgData e = com.baidu.tieba.im.d.d.e(next);
                    if (e != null) {
                        if (com.baidu.tieba.im.d.d.c(next)) {
                            e.setHas_read(1);
                        } else {
                            e.setHas_read(0);
                        }
                        next.a("[" + new Gson().toJson(e) + "]");
                    }
                    next.a(new MsgLocalData());
                    next.m().setStatus((short) 3);
                    if (next instanceof com.baidu.tieba.im.message.d) {
                        CommonMsgPojo commonMsgPojo = new CommonMsgPojo((com.baidu.tieba.im.message.d) next);
                        commonMsgPojo.setPrivate(true);
                        String uid = commonMsgPojo.getUid();
                        String toUid = commonMsgPojo.getToUid();
                        com.baidu.adp.lib.h.e.d("see content:" + commonMsgPojo);
                        com.baidu.adp.lib.h.e.d("see push private uidStr:" + uid + " toUidStr:" + toUid + " loginId:" + TiebaApplication.B());
                        if (TextUtils.isEmpty(uid)) {
                            com.baidu.adp.lib.h.e.d("see push private uidStr is null");
                            return;
                        } else if (toUid.equals(uid) && uid.equals(TiebaApplication.B())) {
                            com.baidu.adp.lib.h.e.d("see push private send msg to self");
                            return;
                        } else {
                            if (uid.equals(TiebaApplication.B())) {
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
                                if (PersonalChatActivity.a && valueOf.equals(bc.d)) {
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
                                        com.baidu.tieba.im.message.f fVar = new com.baidu.tieba.im.message.f();
                                        fVar.a(valueOf);
                                        com.baidu.tieba.im.messageCenter.e.a().e(fVar);
                                    }
                                    SystemMsgData h = com.baidu.tieba.im.d.d.h(next);
                                    if (h != null) {
                                        if (h.getIsSelf()) {
                                            i5++;
                                            commonMsgPojo.setRead_flag(1);
                                        } else {
                                            commonMsgPojo.setRead_flag(0);
                                        }
                                    }
                                    i = i5;
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                    i = i5;
                                }
                            } else if (next.f() != null && next.f().getId() != null && next.f().getId().equals(TiebaApplication.B())) {
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
                            com.baidu.tieba.im.db.ar.a().a(parseLong2, parseLong3, linkedList4, true, (com.baidu.tieba.im.a<Boolean>) null);
                            if (i4 == size - 1) {
                                if (PersonalChatActivity.a && valueOf.equals(bc.d)) {
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
                    com.baidu.tieba.im.db.ag.a().a(hashMap, new j(this, cVar));
                    return;
                }
            }
        }
    }

    private void b(com.baidu.tieba.im.data.c cVar) {
        List<com.baidu.tieba.im.message.b> a2;
        String valueOf = String.valueOf(cVar.a().getGroupId());
        com.baidu.tieba.im.data.f b = cVar.b();
        if (b != null && (a2 = b.a()) != null && a2.size() > 0) {
            LinkedList<CommonMsgPojo> linkedList = new LinkedList<>();
            int i = 0;
            for (com.baidu.tieba.im.message.b bVar : a2) {
                VoiceMsgData e = com.baidu.tieba.im.d.d.e(bVar);
                if (e != null) {
                    if (com.baidu.tieba.im.d.d.c(bVar)) {
                        e.setHas_read(1);
                    } else {
                        e.setHas_read(0);
                    }
                    bVar.a("[" + new Gson().toJson(e) + "]");
                }
                bVar.a(new MsgLocalData());
                bVar.m().setStatus((short) 3);
                if (bVar instanceof com.baidu.tieba.im.message.d) {
                    CommonMsgPojo commonMsgPojo = new CommonMsgPojo((com.baidu.tieba.im.message.d) bVar);
                    if (bVar.h() == 11) {
                        try {
                            String optString = new JSONObject(bVar.j()).optString("eventId");
                            if ("105".equals(optString) || "106".equals(optString)) {
                                com.baidu.tieba.im.message.f fVar = new com.baidu.tieba.im.message.f();
                                fVar.a(valueOf);
                                com.baidu.tieba.im.messageCenter.e.a().e(fVar);
                            }
                            SystemMsgData h = com.baidu.tieba.im.d.d.h(bVar);
                            if (h != null) {
                                if (h.getIsSelf()) {
                                    i++;
                                    commonMsgPojo.setRead_flag(1);
                                } else {
                                    commonMsgPojo.setRead_flag(0);
                                }
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    } else if (bVar.f() != null && bVar.f().getId() != null && bVar.f().getId().equals(TiebaApplication.B())) {
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
            int i2 = (GroupChatActivity.a && valueOf.equals(bc.c)) ? 0 : i;
            CommonMsgPojo last = linkedList.getLast();
            last.checkRidAndSelf();
            com.baidu.tieba.im.db.d.a().a(valueOf, linkedList, true, (com.baidu.tieba.im.a<Boolean>) new k(this, cVar, valueOf, last, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.im.message.n nVar) {
        if (nVar instanceof com.baidu.tieba.im.message.ax) {
            com.baidu.tieba.im.message.ax axVar = (com.baidu.tieba.im.message.ax) nVar;
            com.baidu.adp.lib.h.e.d("SHANG ChatResponsedMessage onAcked");
            if (axVar.i()) {
                a((com.baidu.tieba.im.message.bz) axVar);
            } else {
                a(axVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.im.message.n nVar) {
        if (nVar instanceof com.baidu.tieba.im.message.ba) {
            com.baidu.tieba.im.message.ba baVar = (com.baidu.tieba.im.message.ba) nVar;
            com.baidu.adp.lib.h.e.d("SHANG ChatResponsedMessage onAcked");
            if (baVar.i()) {
                a((com.baidu.tieba.im.message.bz) baVar);
            } else {
                int a2 = com.baidu.adp.lib.f.b.a(baVar.c(), 0);
                a(a2);
                com.baidu.adp.lib.h.e.d("GET Personal Gid MSGACK=" + a2);
            }
            a(baVar);
        }
    }

    private void a(com.baidu.tieba.im.message.bz bzVar) {
        if (bzVar != null && bzVar.l() != null) {
            com.baidu.tieba.im.message.b bVar = (com.baidu.tieba.im.message.b) bzVar.l();
            if (bVar == null) {
                com.baidu.adp.lib.h.e.a("chatMessage == null");
            } else if (bVar instanceof com.baidu.tieba.im.message.d) {
                com.baidu.tieba.im.db.d.a().a(((com.baidu.tieba.im.message.d) bVar).s(), String.valueOf(bVar.i()), String.valueOf(bVar.k()), 2, new l(this, bzVar));
            } else if (bVar instanceof com.baidu.tieba.im.message.p) {
                com.baidu.tieba.im.message.p pVar = (com.baidu.tieba.im.message.p) bVar;
                com.baidu.tieba.im.db.ar.a().a(pVar.l(), pVar.b(), String.valueOf(bVar.i()), String.valueOf(bVar.k()), 2, new m(this, bzVar));
            }
        }
    }

    private void a(com.baidu.tieba.im.message.ax axVar) {
        com.baidu.tieba.im.db.d.a().a(axVar.c(), String.valueOf(axVar.b()), String.valueOf(axVar.a()), 3, new c(this, axVar));
    }

    private void a(com.baidu.tieba.im.message.ba baVar) {
        com.baidu.tieba.im.db.ar.a().a(com.baidu.adp.lib.f.b.a(TiebaApplication.B(), 0L), com.baidu.adp.lib.f.b.a(baVar.d(), 0L), String.valueOf(baVar.b()), String.valueOf(baVar.a()), 3, new d(this, baVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.im.data.c cVar, String str, CommonMsgPojo commonMsgPojo, int i) {
        com.baidu.tieba.im.db.ag.a().a(str, i, commonMsgPojo, new e(this, str, commonMsgPojo));
        d(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.im.message.n nVar) {
        Iterator<WeakReference<ag>> it = this.d.iterator();
        while (it.hasNext()) {
            ag agVar = it.next().get();
            if (agVar != null) {
                agVar.a(nVar);
            }
        }
    }
}
