package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.location.LocationClientOption;
import com.baidu.sapi2.shell.SapiErrorCode;
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
public class q {
    private LinkedList<WeakReference<ay>> c = new LinkedList<>();
    private ad d = null;
    private static q b = null;
    public static int a = 0;

    public static void a(int i) {
        if (i != 0 && a != i) {
            if (a != 0) {
                com.baidu.adp.lib.g.e.a("私聊GID有变化!!!!!!!!!!!");
            }
            a = i;
            com.baidu.tieba.im.m.a(new r(i), null);
        }
    }

    private q() {
    }

    public void a() {
        this.d = new ad(this, null);
        com.baidu.tieba.im.messageCenter.e.a().a(-100, this.d);
        com.baidu.tieba.im.messageCenter.e.a().a(202001, this.d);
        com.baidu.tieba.im.messageCenter.e.a().a(SapiErrorCode.INVALID_ARG, this.d);
        com.baidu.tieba.im.messageCenter.e.a().a(SapiErrorCode.GET_CERT_FAIL, this.d);
        com.baidu.tieba.im.messageCenter.e.a().a(205001, this.d);
    }

    public static q b() {
        if (b == null) {
            b = new q();
        }
        return b;
    }

    public void a(ay ayVar) {
        boolean z;
        boolean z2 = false;
        Iterator<WeakReference<ay>> it = this.c.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            z2 = it.next().get() == ayVar ? true : z;
        }
        if (!z) {
            this.c.add(new WeakReference<>(ayVar));
        }
    }

    public void b(ay ayVar) {
        WeakReference<ay> weakReference;
        Iterator<WeakReference<ay>> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                weakReference = null;
                break;
            }
            weakReference = it.next();
            if (weakReference.get() == ayVar) {
                break;
            }
        }
        if (weakReference != null) {
            this.c.remove(weakReference);
        }
    }

    public void a(String str, az azVar) {
        com.baidu.tieba.im.db.d.a().a(str, 2, (String) null, LocationClientOption.MIN_SCAN_SPAN, new v(this, azVar));
    }

    public void b(String str, az azVar) {
        com.baidu.tieba.im.db.au.a().a(str, 2, (String) null, LocationClientOption.MIN_SCAN_SPAN, new w(this, azVar));
    }

    public void a(com.baidu.tieba.im.message.b bVar) {
        com.baidu.adp.lib.g.e.d("SHNAG chatManager sendMessage, content = " + bVar.k());
        if (bVar instanceof com.baidu.tieba.im.message.g) {
            com.baidu.tieba.im.message.g gVar = (com.baidu.tieba.im.message.g) bVar;
            LinkedList<CommonMsgPojo> linkedList = new LinkedList<>();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(gVar);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            com.baidu.tieba.im.db.d.a().a(gVar.u(), linkedList, false, (com.baidu.tieba.im.a<Boolean>) new x(this, gVar));
        } else if (bVar instanceof com.baidu.tieba.im.message.u) {
            com.baidu.tieba.im.message.u uVar = (com.baidu.tieba.im.message.u) bVar;
            LinkedList<CommonMsgPojo> linkedList2 = new LinkedList<>();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo((com.baidu.tieba.im.message.u) bVar);
            commonMsgPojo2.setRead_flag(0);
            linkedList2.add(commonMsgPojo2);
            com.baidu.tieba.im.db.au.a().a(uVar.m(), uVar.c(), linkedList2, false, (com.baidu.tieba.im.a<Boolean>) new y(this, uVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.im.message.q qVar) {
        if (qVar instanceof com.baidu.tieba.im.data.c) {
            com.baidu.tieba.im.data.c cVar = (com.baidu.tieba.im.data.c) qVar;
            if (cVar.a() != null) {
                if (cVar.a().getGroupType() == 6) {
                    a(cVar);
                } else {
                    b(cVar);
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
        com.baidu.adp.lib.g.e.d("GET Personal Gid PULLMSG=" + cVar.a().getGroupId());
        String valueOf = String.valueOf(cVar.a().getGroupId());
        com.baidu.tieba.im.data.f b2 = cVar.b();
        HashMap<String, ae> hashMap = new HashMap<>();
        if (b2 != null && (a2 = b2.a()) != null && a2.size() > 0) {
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
                    next.n().setStatus((short) 3);
                    if (next instanceof com.baidu.tieba.im.message.g) {
                        CommonMsgPojo commonMsgPojo = new CommonMsgPojo((com.baidu.tieba.im.message.g) next);
                        commonMsgPojo.setPrivate(true);
                        String uid = commonMsgPojo.getUid();
                        String toUid = commonMsgPojo.getToUid();
                        com.baidu.adp.lib.g.e.d("see content:" + commonMsgPojo);
                        com.baidu.adp.lib.g.e.d("see push private uidStr:" + uid + " toUidStr:" + toUid + " loginId:" + TiebaApplication.A());
                        if (TextUtils.isEmpty(uid)) {
                            com.baidu.adp.lib.g.e.d("see push private uidStr is null");
                            return;
                        } else if (toUid.equals(uid) && uid.equals(TiebaApplication.A())) {
                            com.baidu.adp.lib.g.e.d("see push private send msg to self");
                            return;
                        } else {
                            if (uid.equals(TiebaApplication.A())) {
                                com.baidu.adp.lib.g.e.d("see push private uid is loginid");
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
                                if (PersonalChatActivity.a && valueOf.equals(PersonalChatActivity.b)) {
                                    i5 = 0;
                                }
                                CommonMsgPojo commonMsgPojo3 = (CommonMsgPojo) linkedList3.getLast();
                                com.baidu.adp.lib.g.e.d("see content1:" + commonMsgPojo + "lastPojo:" + commonMsgPojo3);
                                commonMsgPojo3.checkRidAndSelf();
                                String gid = commonMsgPojo3.getGid();
                                if (hashMap.get(gid) != null) {
                                    ae aeVar = hashMap.get(gid);
                                    aeVar.b = commonMsgPojo3;
                                    aeVar.c += i5;
                                } else {
                                    ae aeVar2 = new ae();
                                    aeVar2.a = gid;
                                    aeVar2.b = commonMsgPojo3;
                                    aeVar2.c = i5;
                                    hashMap.put(aeVar2.a, aeVar2);
                                }
                                i5 = 0;
                                j = parseLong;
                                linkedList = new LinkedList();
                            }
                            if (next.i() == 11) {
                                try {
                                    String optString = new JSONObject(next.k()).optString("eventId");
                                    if ("105".equals(optString) || "106".equals(optString)) {
                                        com.baidu.tieba.im.message.i iVar = new com.baidu.tieba.im.message.i();
                                        iVar.a(valueOf);
                                        com.baidu.tieba.im.messageCenter.e.a().e(iVar);
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
                            } else if (next.g() != null && next.g().getId() != null && next.g().getId().equals(TiebaApplication.A())) {
                                com.baidu.adp.lib.g.e.d(" private insert 1 unreadCount:" + i5);
                                commonMsgPojo.setRead_flag(0);
                                i = i5;
                            } else {
                                com.baidu.adp.lib.g.e.d(" private insert 2 unreadCount:" + i5);
                                commonMsgPojo.setRead_flag(1);
                                i = i5 + 1;
                            }
                            linkedList.add(commonMsgPojo);
                            long parseLong2 = Long.parseLong(commonMsgPojo2.getUid());
                            long parseLong3 = Long.parseLong(commonMsgPojo2.getToUid());
                            LinkedList<CommonMsgPojo> linkedList4 = new LinkedList<>();
                            linkedList4.add(commonMsgPojo2);
                            com.baidu.adp.lib.g.e.d(" private insert to db:" + commonMsgPojo2 + " unreadCount:" + i);
                            com.baidu.tieba.im.db.au.a().a(parseLong2, parseLong3, linkedList4, true, (com.baidu.tieba.im.a<Boolean>) null);
                            if (i4 == size - 1) {
                                if (PersonalChatActivity.a && valueOf.equals(PersonalChatActivity.b)) {
                                    i = 0;
                                }
                                CommonMsgPojo commonMsgPojo4 = (CommonMsgPojo) linkedList.getLast();
                                commonMsgPojo4.checkRidAndSelf();
                                String gid2 = commonMsgPojo4.getGid();
                                com.baidu.adp.lib.g.e.d("see content2:" + commonMsgPojo + "lastPojo:" + commonMsgPojo4);
                                if (hashMap.get(gid2) != null) {
                                    ae aeVar3 = hashMap.get(gid2);
                                    aeVar3.b = commonMsgPojo4;
                                    aeVar3.c += i;
                                } else {
                                    ae aeVar4 = new ae();
                                    aeVar4.a = gid2;
                                    aeVar4.b = commonMsgPojo4;
                                    aeVar4.c = i;
                                    hashMap.put(aeVar4.a, aeVar4);
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
                    com.baidu.tieba.im.db.ah.a().a(hashMap, new z(this, cVar));
                    return;
                }
            }
        }
    }

    private void b(com.baidu.tieba.im.data.c cVar) {
        List<com.baidu.tieba.im.message.b> a2;
        String valueOf = String.valueOf(cVar.a().getGroupId());
        com.baidu.tieba.im.data.f b2 = cVar.b();
        if (b2 != null && (a2 = b2.a()) != null && a2.size() > 0) {
            LinkedList<CommonMsgPojo> linkedList = new LinkedList<>();
            int i = 0;
            for (com.baidu.tieba.im.message.b bVar : a2) {
                VoiceMsgData f = com.baidu.tieba.im.d.d.f(bVar);
                if (f != null) {
                    if (com.baidu.tieba.im.d.d.d(bVar)) {
                        f.setHas_read(1);
                    } else {
                        f.setHas_read(0);
                    }
                    bVar.a("[" + new Gson().toJson(f) + "]");
                }
                bVar.a(new MsgLocalData());
                bVar.n().setStatus((short) 3);
                if (bVar instanceof com.baidu.tieba.im.message.g) {
                    CommonMsgPojo commonMsgPojo = new CommonMsgPojo((com.baidu.tieba.im.message.g) bVar);
                    if (bVar.i() == 11) {
                        try {
                            String k = bVar.k();
                            String optString = new JSONObject(k).optString("eventId");
                            if ("105".equals(optString) || "106".equals(optString)) {
                                com.baidu.tieba.im.message.i iVar = new com.baidu.tieba.im.message.i();
                                iVar.a(valueOf);
                                com.baidu.tieba.im.messageCenter.e.a().e(iVar);
                            } else if ("201".equals(optString) || "202".equals(optString) || "203".equals(optString) || "205".equals(optString)) {
                                com.baidu.tieba.im.message.c cVar2 = new com.baidu.tieba.im.message.c();
                                cVar2.a(k);
                                com.baidu.tieba.im.messageCenter.e.a().e(cVar2);
                            }
                            SystemMsgData i2 = com.baidu.tieba.im.d.d.i(bVar);
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
                    } else if (bVar.g() != null && bVar.g().getId() != null && bVar.g().getId().equals(TiebaApplication.A())) {
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
            int i3 = (GroupChatActivity.a && valueOf.equals(GroupChatActivity.b)) ? 0 : i;
            CommonMsgPojo last = linkedList.getLast();
            last.checkRidAndSelf();
            com.baidu.tieba.im.db.d.a().a(valueOf, linkedList, true, (com.baidu.tieba.im.a<Boolean>) new aa(this, cVar, valueOf, last, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.im.message.q qVar) {
        if (qVar instanceof com.baidu.tieba.im.message.bj) {
            com.baidu.tieba.im.message.bj bjVar = (com.baidu.tieba.im.message.bj) qVar;
            com.baidu.adp.lib.g.e.d("SHANG ChatResponsedMessage onAcked");
            if (bjVar.k()) {
                a((com.baidu.tieba.im.message.cr) bjVar);
            } else {
                a(bjVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.im.message.q qVar) {
        if (qVar instanceof com.baidu.tieba.im.message.bm) {
            com.baidu.tieba.im.message.bm bmVar = (com.baidu.tieba.im.message.bm) qVar;
            com.baidu.adp.lib.g.e.d("SHANG ChatResponsedMessage onAcked");
            if (bmVar.k()) {
                a((com.baidu.tieba.im.message.cr) bmVar);
            } else {
                int a2 = com.baidu.adp.lib.f.b.a(bmVar.c(), 0);
                a(a2);
                com.baidu.adp.lib.g.e.d("GET Personal Gid MSGACK=" + a2);
            }
            a(bmVar);
        }
    }

    private void a(com.baidu.tieba.im.message.cr crVar) {
        if (crVar != null && crVar.n() != null) {
            com.baidu.tieba.im.message.b bVar = (com.baidu.tieba.im.message.b) crVar.n();
            if (bVar == null) {
                com.baidu.adp.lib.g.e.a("chatMessage == null");
            } else if (bVar instanceof com.baidu.tieba.im.message.g) {
                com.baidu.tieba.im.db.d.a().a(((com.baidu.tieba.im.message.g) bVar).u(), String.valueOf(bVar.j()), String.valueOf(bVar.l()), 2, new ab(this, crVar));
            } else if (bVar instanceof com.baidu.tieba.im.message.u) {
                com.baidu.tieba.im.message.u uVar = (com.baidu.tieba.im.message.u) bVar;
                com.baidu.tieba.im.db.au.a().a(uVar.m(), uVar.c(), String.valueOf(bVar.j()), String.valueOf(bVar.l()), 2, new ac(this, crVar));
            }
        }
    }

    private void a(com.baidu.tieba.im.message.bj bjVar) {
        com.baidu.tieba.im.db.d.a().a(bjVar.c(), String.valueOf(bjVar.b()), String.valueOf(bjVar.a()), 3, new s(this, bjVar));
    }

    private void a(com.baidu.tieba.im.message.bm bmVar) {
        com.baidu.tieba.im.db.au.a().a(com.baidu.adp.lib.f.b.a(TiebaApplication.A(), 0L), com.baidu.adp.lib.f.b.a(bmVar.d(), 0L), String.valueOf(bmVar.b()), String.valueOf(bmVar.a()), 3, new t(this, bmVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.im.data.c cVar, String str, CommonMsgPojo commonMsgPojo, int i) {
        com.baidu.tieba.im.db.ah.a().a(str, i, commonMsgPojo, new u(this, str, commonMsgPojo));
        d(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.im.message.q qVar) {
        Iterator<WeakReference<ay>> it = this.c.iterator();
        while (it.hasNext()) {
            ay ayVar = it.next().get();
            if (ayVar != null) {
                ayVar.a(qVar);
            }
        }
    }
}
