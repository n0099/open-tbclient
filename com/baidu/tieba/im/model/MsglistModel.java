package com.baidu.tieba.im.model;

import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.chat.bc;
import com.baidu.tieba.im.chat.cr;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.au;
import com.baidu.tieba.im.message.az;
import com.baidu.tieba.im.message.br;
import com.baidu.tieba.im.message.ci;
import com.baidu.tieba.im.message.cp;
import com.baidu.tieba.im.message.cw;
import com.baidu.tieba.im.message.da;
import com.baidu.tieba.im.message.db;
import com.slidingmenu.lib.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MsglistModel extends com.baidu.adp.a.d {
    private static final String b = MsglistModel.class.getName();
    private String i;
    private MsgPageData j;
    private bc k;
    private ai o;
    private MsglistActivity p;
    private aj q;
    private final int c = 1800;
    private final int d = 20;
    private int e = 0;
    private GroupData f = null;
    private UserData g = null;
    private boolean h = true;
    com.baidu.adp.a.g a = new m(this);
    private final HashMap<String, com.baidu.tieba.img.a<com.baidu.tieba.im.message.b>> l = new HashMap<>();
    private final com.baidu.tieba.img.d n = new w(this);
    private final ap m = new ap();

    /* loaded from: classes.dex */
    public class PicMessageData implements Serializable {
        private static final long serialVersionUID = -2120837602853869652L;
        public String big_src;
        public String bsize;
        public String src;
        public String type;
    }

    public MsglistModel(MsglistActivity msglistActivity) {
        this.j = null;
        this.k = null;
        this.p = msglistActivity;
        this.j = new MsgPageData();
        this.k = new ah(this, (byte) 0);
        this.m.setLoadDataCallBack(this.a);
        com.baidu.tieba.im.chat.q.b().a(this.k);
        this.o = new ai(this, (byte) 0);
        com.baidu.tieba.im.messageCenter.d.a().a(103112, this.o);
        com.baidu.tieba.im.messageCenter.d.a().a(103102, this.o);
        com.baidu.tieba.im.messageCenter.d.a().a(202003, this.o);
        com.baidu.tieba.im.messageCenter.d.a().a(-113, this.o);
        com.baidu.tieba.im.messageCenter.d.a().a(205004, this.o);
        com.baidu.tieba.im.messageCenter.d.a().a(-126, this.o);
    }

    public static /* synthetic */ com.baidu.tieba.im.message.b a(MsglistModel msglistModel, long j) {
        if (msglistModel.j != null && msglistModel.j.getChatMessages() != null && msglistModel.j.getChatMessages().size() > 0) {
            for (com.baidu.tieba.im.message.b bVar : msglistModel.j.getChatMessages()) {
                if (bVar.j() == j) {
                    return bVar;
                }
            }
        }
        return null;
    }

    public final void a(GroupData groupData) {
        this.f = groupData;
    }

    public final GroupData a() {
        return this.f;
    }

    public final void a(UserData userData) {
        this.g = userData;
    }

    public final UserData b() {
        return this.g;
    }

    public final MsgPageData c() {
        return this.j;
    }

    public final boolean d() {
        return this.h;
    }

    public final void a(boolean z) {
        this.h = z;
    }

    public final void a(String str) {
        this.i = str;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public final void e() {
        com.baidu.tieba.img.a<com.baidu.tieba.im.message.b> remove;
        synchronized (MsglistModel.class) {
            if (this.l != null) {
                while (!this.l.isEmpty()) {
                    Set<Map.Entry<String, com.baidu.tieba.img.a<com.baidu.tieba.im.message.b>>> entrySet = this.l.entrySet();
                    if (!entrySet.isEmpty() && (remove = this.l.remove(entrySet.iterator().next().getKey())) != null) {
                        remove.b();
                    }
                }
            }
        }
        com.baidu.tieba.im.chat.q.b().b(this.k);
        com.baidu.tieba.im.messageCenter.d.a().a(this.o);
    }

    public final boolean f() {
        com.baidu.adp.lib.util.e.e("start loadFirst");
        if (n()) {
            return true;
        }
        com.baidu.tieba.im.message.q qVar = new com.baidu.tieba.im.message.q();
        qVar.b(this.e);
        if (m()) {
            if (this.f == null || this.f.getGroupId() == 0) {
                return false;
            }
            qVar.c(String.valueOf(this.f.getGroupId()));
        } else if (this.g == null) {
            return false;
        } else {
            qVar.a(this.g.getUserIdLong());
        }
        qVar.a(20);
        qVar.b((String) null);
        qVar.a((String) null);
        com.baidu.tieba.im.messageCenter.d.a().a(qVar);
        return true;
    }

    public final void g() {
        if (this.e == 1 && this.g != null) {
            au auVar = new au();
            auVar.a(this.g.getUserIdLong());
            com.baidu.tieba.im.messageCenter.d.a().a(auVar);
        }
    }

    public final boolean h() {
        long j;
        long j2 = 0;
        com.baidu.adp.lib.util.e.e("start loadPrepage");
        if (n()) {
            return true;
        }
        com.baidu.tieba.im.message.q qVar = new com.baidu.tieba.im.message.q();
        qVar.b(this.e);
        if (m()) {
            if (this.f == null || this.f.getGroupId() == 0) {
                return false;
            }
            qVar.c(String.valueOf(this.f.getGroupId()));
        } else if (this.g == null) {
            return false;
        } else {
            qVar.a(this.g.getUserIdLong());
        }
        if (this.j == null || this.j.getChatMessages() == null || this.j.getChatMessages().size() <= 0 || this.j.getChatMessages().get(0) == null) {
            j = 0;
        } else {
            j = this.j.getChatMessages().get(0).l();
            j2 = this.j.getChatMessages().get(0).j();
        }
        qVar.a(20);
        qVar.b(String.valueOf(j));
        qVar.a(String.valueOf(j2));
        com.baidu.tieba.im.messageCenter.d.a().a(qVar);
        return true;
    }

    public final boolean i() {
        com.baidu.tieba.im.message.o oVar = new com.baidu.tieba.im.message.o();
        if (m() || n()) {
            if (this.f == null || this.f.getGroupId() == 0) {
                return false;
            }
            oVar.a(0);
            oVar.a(String.valueOf(this.f.getGroupId()));
        } else if (this.g == null) {
            return false;
        } else {
            oVar.a(1);
            oVar.a(String.valueOf(this.g.getUserId()));
        }
        com.baidu.tieba.im.messageCenter.d.a().a(oVar);
        return true;
    }

    public final boolean b(String str) {
        if (this.i == null || !this.i.equals(str)) {
            db dbVar = new db();
            if (m() || n()) {
                if (this.f == null || this.f.getGroupId() == 0) {
                    return false;
                }
                dbVar.a(0);
                dbVar.a(String.valueOf(this.f.getGroupId()));
            } else if (this.g == null) {
                return false;
            } else {
                dbVar.a(1);
                dbVar.a(String.valueOf(this.g.getUserId()));
            }
            dbVar.b(str);
            com.baidu.tieba.im.messageCenter.d.a().a(dbVar);
            return true;
        }
        return false;
    }

    private com.baidu.tieba.im.message.b a(short s, String str) {
        com.baidu.tieba.im.message.b bVar;
        long j;
        if (m() || n()) {
            com.baidu.tieba.im.message.g gVar = new com.baidu.tieba.im.message.g();
            gVar.a(System.currentTimeMillis());
            gVar.b(String.valueOf(this.f.getGroupId()));
            bVar = gVar;
        } else {
            com.baidu.tieba.im.message.b wVar = new com.baidu.tieba.im.message.w();
            wVar.a(System.currentTimeMillis());
            wVar.b(this.g.getUserIdLong());
            UserData userData = new UserData();
            userData.setUserId(String.valueOf(this.g.getUserId()));
            userData.setUserName(this.g.getUserName());
            userData.setPortrait(this.g.getPortrait());
            wVar.b(userData);
            bVar = wVar;
        }
        bVar.b((int) s);
        bVar.a(str);
        List<com.baidu.tieba.im.message.b> chatMessages = this.j.getChatMessages();
        long l = ((chatMessages == null || chatMessages.size() <= 0) ? 0L : chatMessages.get(chatMessages.size() - 1).l()) + 1;
        bVar.d(l);
        bVar.c(l);
        bVar.f(System.currentTimeMillis() / 1000);
        UserData userData2 = new UserData();
        userData2.setUserName(TiebaApplication.z());
        userData2.setUserId(TiebaApplication.v());
        userData2.setPortrait(com.baidu.tieba.im.e.c());
        bVar.a(userData2);
        try {
            j = com.baidu.adp.lib.f.b.a(TiebaApplication.v(), 0L);
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("transform error" + e.getMessage());
            j = 0;
        }
        bVar.e(j);
        MsgLocalData msgLocalData = new MsgLocalData();
        msgLocalData.setStatus((short) 1);
        msgLocalData.setErrno(0L);
        msgLocalData.setRetry(0L);
        msgLocalData.setUpload_offset(null);
        bVar.a(msgLocalData);
        return bVar;
    }

    public final void c(String str) {
        com.baidu.adp.lib.util.e.e("SHANG sendTextMessage");
        com.baidu.tieba.im.message.b a = a((short) 1, str);
        this.j.getChatMessages().add(a);
        this.mLoadDataMode = 4;
        this.mLoadDataCallBack.a(this.j);
        com.baidu.tieba.im.chat.q.b().a(a);
    }

    public final void a(com.baidu.tieba.editortool.x xVar) {
        String b2 = b(xVar);
        if (b2 != null) {
            com.baidu.tieba.im.message.b a = a((short) 4, b2);
            this.j.getChatMessages().add(a);
            this.mLoadDataMode = 4;
            this.mLoadDataCallBack.a(this.j);
            com.baidu.tieba.im.chat.q.b().a(a);
        }
    }

    private static String b(com.baidu.tieba.editortool.x xVar) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pid", xVar.d());
            jSONObject.put("packet_name", xVar.c());
            jSONObject.put("face_name", xVar.a());
            jSONObject.put("size_width", xVar.e());
            jSONObject.put("size_height", xVar.f());
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void a(String str, int i) {
        VoiceMsgData voiceMsgData = new VoiceMsgData();
        voiceMsgData.setDuring_time(i);
        voiceMsgData.setVoice_md5(str);
        voiceMsgData.setHas_read(1);
        com.baidu.tieba.im.message.b a = a((short) 3, "[" + new Gson().toJson(voiceMsgData) + "]");
        a.a((MsgCacheData) null);
        this.j.getChatMessages().add(a);
        this.mLoadDataMode = 4;
        this.mLoadDataCallBack.a(this.j);
        if (a instanceof com.baidu.tieba.im.message.g) {
            com.baidu.tieba.im.message.g gVar = (com.baidu.tieba.im.message.g) a;
            LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(gVar);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            com.baidu.tieba.im.i.a(new z(this, gVar, linkedList), new aa(this, gVar));
        } else if (a instanceof com.baidu.tieba.im.message.w) {
            com.baidu.tieba.im.message.w wVar = (com.baidu.tieba.im.message.w) a;
            LinkedList linkedList2 = new LinkedList();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(wVar);
            commonMsgPojo2.setRead_flag(0);
            linkedList2.add(commonMsgPojo2);
            com.baidu.tieba.im.i.a(new ab(this, wVar, linkedList2), new ac(this, wVar));
        }
    }

    public void a(com.baidu.tieba.im.message.b bVar) {
        VoiceMsgData f = com.baidu.tieba.im.util.l.f(bVar);
        if (f != null) {
            bVar.g(System.currentTimeMillis());
            this.m.a(f.getVoice_md5(), bVar.j());
        }
    }

    public final void a(String str, Bitmap bitmap, com.baidu.tieba.img.b<com.baidu.tieba.im.message.b> bVar) {
        if (bitmap == null) {
            com.baidu.adp.lib.util.e.b("chosedImage is null!!!");
            return;
        }
        com.baidu.tieba.im.message.b a = a((short) 2, a(str, str, bitmap.getWidth(), bitmap.getHeight()));
        a.a(true);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        a.c(width);
        a.d(height);
        this.j.getChatMessages().add(a);
        this.mLoadDataMode = 4;
        this.mLoadDataCallBack.a(this.j);
        if (a instanceof com.baidu.tieba.im.message.g) {
            com.baidu.tieba.im.message.g gVar = (com.baidu.tieba.im.message.g) a;
            LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(gVar);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            com.baidu.tieba.im.i.a(new ad(this, gVar, linkedList), new ae(this, gVar, str, bVar));
            return;
        }
        com.baidu.tieba.im.message.w wVar = (com.baidu.tieba.im.message.w) a;
        LinkedList linkedList2 = new LinkedList();
        CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(wVar);
        commonMsgPojo2.setRead_flag(0);
        linkedList2.add(commonMsgPojo2);
        com.baidu.tieba.im.i.a(new af(this, wVar, linkedList2), new p(this, wVar, str, bVar));
    }

    public static String a(String str, String str2, int i, int i2) {
        PicMessageData picMessageData = new PicMessageData();
        picMessageData.src = str2;
        picMessageData.big_src = str;
        picMessageData.type = "3";
        if (i > 0) {
            picMessageData.bsize = String.valueOf(i) + "," + i2;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(picMessageData);
        String json = new Gson().toJson(linkedList);
        com.baidu.adp.lib.util.e.e("pic msg content:" + json);
        return json;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tieba.im.message.b */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.baidu.tieba.im.message.b bVar, String str, com.baidu.tieba.img.b<com.baidu.tieba.im.message.b> bVar2) {
        if (bVar != 0) {
            if (bVar.k() == null) {
                b(bVar);
            }
            if (str == null) {
                try {
                    str = new JSONArray(bVar.k()).getJSONObject(0).optString("src");
                } catch (Exception e) {
                    e.printStackTrace();
                    b(bVar);
                    return;
                }
            }
            if (str == null) {
                b(bVar);
                return;
            }
            bVar.a(0);
            bVar.a(true);
            if (str.startsWith("http")) {
                com.baidu.tieba.im.chat.q.b().a(bVar);
                return;
            }
            com.baidu.tieba.img.a<com.baidu.tieba.im.message.b> aVar = this.l.get(str);
            if (aVar == null) {
                com.baidu.tieba.img.a<com.baidu.tieba.im.message.b> aVar2 = new com.baidu.tieba.img.a<>(str, "IM");
                LocalViewSize.a().a(aVar2);
                aVar2.a = bVar;
                aVar2.a(bVar2);
                aVar2.a(this.n);
                if (bVar instanceof com.baidu.tieba.im.message.g) {
                    aVar2.a(((com.baidu.tieba.im.message.g) bVar).u());
                } else {
                    aVar2.a(String.valueOf(com.baidu.tieba.im.chat.q.a));
                }
                synchronized (MsglistModel.class) {
                    this.l.put(str, aVar2);
                }
                aVar = aVar2;
            }
            bVar.g(System.currentTimeMillis());
            aVar.a();
        }
    }

    public final void a(int i, com.baidu.tieba.img.b<com.baidu.tieba.im.message.b> bVar) {
        com.baidu.tieba.im.message.b a = a(i);
        if (a == null || a.n() == null || a.n().getStatus() == null) {
            com.baidu.adp.lib.util.e.b(b, "reSendMsg", "data error");
            return;
        }
        short shortValue = a.n().getStatus().shortValue();
        if (shortValue != 2) {
            com.baidu.adp.lib.util.e.b(b, "reSendMsg", "status error:" + ((int) shortValue));
            return;
        }
        a.c(a.l());
        a.n().setStatus((short) 1);
        a.f(System.currentTimeMillis() / 1000);
        switch (a.i()) {
            case 1:
                com.baidu.tieba.im.chat.q.b().a(a);
                break;
            case 2:
                a(a, (String) null, bVar);
                break;
            case 3:
                a(a);
                break;
            case 4:
                com.baidu.tieba.im.chat.q.b().a(a);
                break;
        }
        this.mLoadDataMode = 6;
        this.mLoadDataCallBack.a(this.j);
        List<com.baidu.tieba.im.message.b> chatMessages = this.j.getChatMessages();
        int size = chatMessages.size();
        if (i < 0 || i >= size) {
            return;
        }
        chatMessages.remove(i);
        chatMessages.add(i, a);
        this.j.setIsNewAdd(false);
        this.j.setNewAddNum(0);
    }

    public final com.baidu.tieba.im.message.b a(int i) {
        if (this.j == null || this.j.getChatMessages() == null || i < 0 || i >= this.j.getChatMessages().size()) {
            return null;
        }
        return this.j.getChatMessages().get(i);
    }

    public final void b(int i) {
        int size = this.j.getChatMessages().size();
        if (i >= 0 && i < size) {
            com.baidu.tieba.im.message.b bVar = this.j.getChatMessages().get(i);
            if (m() || n()) {
                if (this.f != null && bVar != null) {
                    com.baidu.tieba.im.i.a(new q(this, bVar), null);
                }
            } else if (this.g != null && bVar != null) {
                com.baidu.tieba.im.i.a(new r(this, bVar), null);
            }
            this.j.getChatMessages().remove(i);
        }
        this.mLoadDataMode = 7;
        this.mLoadDataCallBack.a(null);
    }

    public final void c(int i) {
        ImMessageCenterPojo a;
        int size = this.j.getChatMessages().size();
        if (i >= 0 && i < size) {
            com.baidu.tieba.im.message.b bVar = this.j.getChatMessages().get(i);
            com.baidu.tieba.im.message.b bVar2 = i + (-1) >= 0 ? this.j.getChatMessages().get(i - 1) : null;
            if (m() || n()) {
                if (this.f != null && bVar != null) {
                    com.baidu.tieba.im.i.a(new s(this, bVar), null);
                }
            } else if (this.g != null && bVar != null) {
                com.baidu.tieba.im.i.a(new t(this, bVar), null);
            }
            this.j.getChatMessages().remove(i);
            if (i == size - 1) {
                com.baidu.tieba.im.db.d d = com.baidu.tieba.im.db.h.a().d();
                if ((m() || n()) && (bVar instanceof com.baidu.tieba.im.message.g)) {
                    a = d.a(((com.baidu.tieba.im.message.g) bVar).u());
                } else {
                    a = (this.e != 1 || this.g == null) ? null : d.a(String.valueOf(this.g.getUserId()));
                }
                if (a != null) {
                    if (bVar2 != null) {
                        a.setLast_content_time(bVar2.p() * 1000);
                        a.setLast_content(com.baidu.tieba.im.util.l.h(bVar2));
                        a.setLast_user_name(bVar2.g().getUserName());
                        a.setLast_rid(bVar2.j());
                    } else {
                        a.setLast_content(" ");
                        a.setLast_user_name(" ");
                    }
                }
            }
        }
        this.mLoadDataMode = 7;
        this.mLoadDataCallBack.a(null);
    }

    public static /* synthetic */ void d(MsglistModel msglistModel, com.baidu.tieba.im.message.s sVar) {
        if (sVar instanceof ci) {
            ci ciVar = (ci) sVar;
            if (ciVar.l() || ciVar.a()) {
                return;
            }
            msglistModel.l();
        }
    }

    public void l() {
        String string = this.p.getString(R.string.chat_permisson);
        if (this.g != null) {
            if (this.g.getSex() == 1) {
                string = string.replaceAll(this.p.getString(R.string.it), this.p.getString(R.string.he));
            } else if (this.g.getSex() == 2) {
                string = string.replaceAll(this.p.getString(R.string.it), this.p.getString(R.string.she));
            }
        }
        this.p.showToast(string, false);
        new Handler().postDelayed(new u(this), 500L);
    }

    public static /* synthetic */ void a(MsglistModel msglistModel, com.baidu.tieba.im.message.s sVar) {
        com.baidu.tieba.im.message.s o;
        String[] split;
        if (sVar instanceof cp) {
            cp cpVar = (cp) sVar;
            if (cpVar.l() || (o = cpVar.o()) == null || !(o instanceof az)) {
                return;
            }
            az azVar = (az) o;
            if (azVar.b() == msglistModel.f.getGroupId()) {
                String c = azVar.c();
                if (TextUtils.isEmpty(c) || (split = c.split(",")) == null || split.length == 0) {
                    return;
                }
                String id = TiebaApplication.y().getID();
                if (TextUtils.isEmpty(id)) {
                    return;
                }
                for (String str : split) {
                    if (id.equals(str)) {
                        msglistModel.mLoadDataMode = 9;
                        msglistModel.mLoadDataCallBack.a(null);
                        return;
                    }
                }
            }
        }
    }

    public static /* synthetic */ void c(MsglistModel msglistModel, com.baidu.tieba.im.message.s sVar) {
        if (sVar instanceof da) {
            da daVar = (da) sVar;
            if (daVar.l() && daVar.m() == 110000) {
                com.baidu.adp.lib.util.e.e("-------unlogin");
                msglistModel.mLoadDataMode = 11;
                msglistModel.mLoadDataCallBack.a(null);
            }
        }
    }

    public static /* synthetic */ void k(MsglistModel msglistModel) {
        if (msglistModel.j == null || msglistModel.j.getChatMessages() == null || msglistModel.j.getChatMessages().size() == 0) {
            return;
        }
        msglistModel.j.getChatMessages().clear();
        msglistModel.mLoadDataMode = 12;
        msglistModel.mLoadDataCallBack.a(null);
    }

    public static /* synthetic */ void b(MsglistModel msglistModel, com.baidu.tieba.im.message.s sVar) {
        if (!(sVar instanceof cw)) {
            com.baidu.adp.lib.util.e.e("transform error");
            return;
        }
        cw cwVar = (cw) sVar;
        if (cwVar.l()) {
            com.baidu.adp.lib.util.e.b("has error");
        } else if (cwVar.a() != null) {
            msglistModel.mLoadDataMode = 10;
            msglistModel.mLoadDataCallBack.a(cwVar.a().getName());
        }
    }

    public static /* synthetic */ int b(MsglistModel msglistModel, List list, List list2) {
        if (list == null || list2 == null) {
            return 0;
        }
        int size = list.size();
        int size2 = list2.size();
        if (size2 == 0) {
            return 0;
        }
        if (size == 0) {
            list.addAll(list2);
            return size2;
        }
        int i = size2 - 1;
        int i2 = size - 1;
        int i3 = 0;
        while (i2 >= 0 && i >= 0) {
            long j = ((com.baidu.tieba.im.message.b) list.get(i2)).j();
            com.baidu.tieba.im.message.b bVar = (com.baidu.tieba.im.message.b) list2.get(i);
            long j2 = bVar.j();
            if (j > j2) {
                i2--;
            } else if (j < j2) {
                list.add(i2 + 1, bVar);
                i--;
                i3++;
            } else {
                i--;
                i2--;
            }
        }
        if (i >= 0) {
            while (i >= 0) {
                list.add(0, (com.baidu.tieba.im.message.b) list2.get(i));
                i3++;
                i--;
            }
        }
        return i3;
    }

    public static /* synthetic */ void a(MsglistModel msglistModel, List list, List list2) {
        if (list == null || list2 == null) {
            return;
        }
        int size = list.size();
        int size2 = list2.size();
        if (size2 != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = size - 1; i >= 0 && i >= 0; i--) {
                com.baidu.tieba.im.message.b bVar = (com.baidu.tieba.im.message.b) list.get(i);
                if (bVar != null && bVar.g() != null && !TextUtils.isEmpty(bVar.g().getUserId()) && bVar.g().getUserId().equals(TiebaApplication.v()) && bVar.n() != null && (bVar.n().getStatus().shortValue() != 3 || bVar.i() == 4)) {
                    int i2 = size2 - 1;
                    while (true) {
                        if (i2 >= 0 && i2 >= 0) {
                            com.baidu.tieba.im.message.b bVar2 = (com.baidu.tieba.im.message.b) list2.get(i2);
                            if (bVar2 != null && bVar2.g() != null && !TextUtils.isEmpty(bVar2.g().getUserId()) && bVar2.g().getUserId().equals(TiebaApplication.v()) && bVar2.j() == bVar.j()) {
                                arrayList.add(bVar);
                                break;
                            }
                            i2--;
                        }
                    }
                }
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                list.remove(arrayList.get(i3));
            }
            arrayList.clear();
        }
    }

    public static /* synthetic */ void b(MsglistModel msglistModel, List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.baidu.adp.lib.util.e.e("*****start updateMsgStatusTimeOut");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.im.message.b bVar = (com.baidu.tieba.im.message.b) it.next();
            if (bVar != null && bVar.n() != null && bVar.n().getStatus().shortValue() == 1) {
                if ((System.currentTimeMillis() / 1000) - bVar.p() > 1800) {
                    bVar.n().setStatus((short) 2);
                    com.baidu.adp.lib.util.e.e("*****create time out");
                } else if (com.baidu.tieba.im.messageCenter.d.a().c(bVar)) {
                    com.baidu.adp.lib.util.e.e("***** find in queues");
                } else {
                    bVar.n().setStatus((short) 2);
                    com.baidu.adp.lib.util.e.e("*****no find in queues");
                }
            }
        }
    }

    public static /* synthetic */ void a(MsglistModel msglistModel, br brVar) {
        int i;
        if (brVar == null) {
            com.baidu.adp.lib.util.e.b("SHANG sendMsgSuc msg == null");
            return;
        }
        if (!msglistModel.m() && !msglistModel.n()) {
            String c = brVar.c();
            if (c == null || c.length() == 0) {
                return;
            }
            try {
                i = Integer.parseInt(c);
            } catch (Exception e) {
                e.printStackTrace();
                i = 0;
            }
            com.baidu.tieba.im.chat.q.a(i);
            com.baidu.adp.lib.util.e.e("GET Personal Gid MSGACK=" + i);
        } else if (brVar.c() == null || !brVar.c().equals(String.valueOf(msglistModel.f.getGroupId()))) {
            return;
        }
        com.baidu.adp.lib.util.e.e("SHANG sendMsgSuc msgId " + brVar.a() + " rid " + brVar.b());
        List<com.baidu.tieba.im.message.b> chatMessages = msglistModel.j.getChatMessages();
        long b2 = brVar.b();
        long a = brVar.a();
        msglistModel.j.setNewAddNum(0);
        msglistModel.j.setIsNewAdd(false);
        int size = chatMessages.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            } else if (b2 == chatMessages.get(size).j()) {
                com.baidu.tieba.im.message.b bVar = chatMessages.get(size);
                if (bVar.n() == null) {
                    MsgLocalData msgLocalData = new MsgLocalData();
                    msgLocalData.setStatus((short) 1);
                    msgLocalData.setErrno(0L);
                    msgLocalData.setRetry(0L);
                    msgLocalData.setUpload_offset(null);
                    bVar.a(msgLocalData);
                }
                bVar.d(a);
                bVar.n().setStatus((short) 3);
            } else {
                size--;
            }
        }
        msglistModel.mLoadDataMode = 5;
        msglistModel.mLoadDataCallBack.a(msglistModel.j);
        if (msglistModel.q != null) {
            com.baidu.adp.lib.util.e.e("simon", "send message", "send text");
            msglistModel.q.o();
        }
    }

    public void b(com.baidu.tieba.im.message.b bVar) {
        if (bVar == null) {
            com.baidu.adp.lib.util.e.b("SHANG sendMsgFail chatmessage == null");
            return;
        }
        if ((m() || n()) && (bVar instanceof com.baidu.tieba.im.message.g)) {
            com.baidu.tieba.im.message.g gVar = (com.baidu.tieba.im.message.g) bVar;
            if (gVar.u() == null || this.f == null || !gVar.u().equals(String.valueOf(this.f.getGroupId()))) {
                return;
            }
        } else if (this.e == 1 && (bVar instanceof com.baidu.tieba.im.message.w) && ((com.baidu.tieba.im.message.w) bVar).c() != this.g.getUserIdLong()) {
            return;
        }
        bVar.a(false);
        if (bVar.n() == null) {
            MsgLocalData msgLocalData = new MsgLocalData();
            msgLocalData.setStatus((short) 1);
            msgLocalData.setErrno(0L);
            msgLocalData.setRetry(0L);
            msgLocalData.setUpload_offset(null);
            bVar.a(msgLocalData);
        }
        com.baidu.adp.lib.util.e.e("SHANG sendMsgFail msgId " + bVar.l() + "recordId " + bVar.j());
        bVar.n().setStatus((short) 2);
        List<com.baidu.tieba.im.message.b> chatMessages = this.j.getChatMessages();
        if (chatMessages != null && chatMessages.size() != 0) {
            long j = bVar.j();
            int size = chatMessages.size() - 1;
            while (size >= 0 && chatMessages.get(size).l() != j) {
                size--;
            }
            if (size >= 0) {
                chatMessages.remove(size);
                chatMessages.add(size, bVar);
                this.j.setNewAddNum(0);
                this.j.setIsNewAdd(false);
                this.mLoadDataMode = 5;
                this.mLoadDataCallBack.a(this.j);
            }
        }
    }

    public final void a(com.baidu.tieba.im.a<Void> aVar) {
        if (m() || n()) {
            com.baidu.tieba.im.db.l.a();
            com.baidu.tieba.im.db.l.c(String.valueOf(this.f.getGroupId()));
            aVar.a(null);
            com.baidu.tieba.im.message.ar arVar = new com.baidu.tieba.im.message.ar();
            arVar.a(String.valueOf(this.f.getGroupId()));
            com.baidu.tieba.im.messageCenter.d.a().a(arVar);
        } else if (this.e == 1) {
            com.baidu.tieba.im.db.l.a();
            com.baidu.tieba.im.db.l.c(PersonalChatActivity.b);
            aVar.a(null);
            com.baidu.tieba.im.i.a(new v(this), aVar);
        }
    }

    public static /* synthetic */ String b(MsglistModel msglistModel, com.baidu.tieba.im.message.b bVar) {
        if (bVar == null) {
            return "";
        }
        int i = bVar.i();
        String string = TiebaApplication.g().b().getString(R.string.websocket_type);
        switch (i) {
            case 1:
                return String.valueOf(string) + TiebaApplication.g().b().getString(R.string.log_msg_text);
            case 2:
                return String.valueOf(string) + TiebaApplication.g().b().getString(R.string.log_msg_pic);
            case 3:
                return String.valueOf(string) + TiebaApplication.g().b().getString(R.string.log_msg_voice);
            default:
                return "";
        }
    }

    public static /* synthetic */ void a(MsglistModel msglistModel, List list) {
        int i;
        int i2;
        if (msglistModel.p.c() != null) {
            i = msglistModel.p.c().getFirstVisiblePosition();
            i2 = msglistModel.p.c().getLastVisiblePosition();
        } else {
            i = -1;
            i2 = 0;
        }
        List<com.baidu.tieba.im.message.b> chatMessages = msglistModel.j.getChatMessages();
        int size = chatMessages.size();
        if (i < 0 || i2 >= size) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.im.message.b bVar = (com.baidu.tieba.im.message.b) it.next();
            if (bVar.i() == 4) {
                cr.a = com.baidu.tieba.util.i.b();
            }
            long m = bVar.m();
            String portrait = bVar.g().getPortrait();
            for (int i3 = i; i3 <= i2; i3++) {
                com.baidu.tieba.im.message.b bVar2 = chatMessages.get(i3);
                if (bVar2 == null) {
                    return;
                }
                if (m == bVar2.m()) {
                    if (bVar2.g() == null) {
                        return;
                    }
                    String portrait2 = bVar2.g().getPortrait();
                    if (portrait != null && !portrait.equals(portrait2)) {
                        bVar2.g().setPortrait(portrait);
                    }
                }
            }
        }
    }

    public boolean m() {
        return this.e == 0;
    }

    public boolean n() {
        return this.e == 2;
    }

    public final int j() {
        return this.e;
    }

    public final void d(int i) {
        this.e = i;
    }

    public final void a(aj ajVar) {
        this.q = ajVar;
    }
}
