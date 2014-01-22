package com.baidu.tieba.im.model;

import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.chat.ay;
import com.baidu.tieba.im.chat.ba;
import com.baidu.tieba.im.chat.ci;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.au;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.at;
import com.baidu.tieba.im.message.bl;
import com.baidu.tieba.im.message.bz;
import com.baidu.tieba.im.message.cg;
import com.baidu.tieba.im.message.cn;
import com.baidu.tieba.im.message.cr;
import com.baidu.tieba.im.message.cs;
import com.slidingmenu.lib.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MsglistModel extends com.baidu.adp.a.d {
    private static final String b = MsglistModel.class.getName();
    private String i;
    private MsgPageData j;
    private ay k;
    private ad o;
    private MsglistActivity p;
    private ae q;
    private final int c = 1800;
    private final int d = 20;
    private int e = 0;
    private GroupData f = null;
    private UserData g = null;
    private boolean h = true;
    com.baidu.adp.a.g a = new r(this);
    private final HashMap<String, ag> l = new HashMap<>();
    private final aj n = new o(this);
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
        this.k = new ac(this, null);
        this.m.setLoadDataCallBack(this.a);
        m();
    }

    private void m() {
        com.baidu.tieba.im.chat.q.b().a(this.k);
        this.o = new ad(this, null);
        com.baidu.tieba.im.messageCenter.e.a().a(103112, this.o);
        com.baidu.tieba.im.messageCenter.e.a().a(103102, this.o);
        com.baidu.tieba.im.messageCenter.e.a().a(202003, this.o);
        com.baidu.tieba.im.messageCenter.e.a().a(-113, this.o);
        com.baidu.tieba.im.messageCenter.e.a().a(205004, this.o);
        com.baidu.tieba.im.messageCenter.e.a().a(-126, this.o);
    }

    private void n() {
        com.baidu.tieba.im.chat.q.b().b(this.k);
        com.baidu.tieba.im.messageCenter.e.a().a(this.o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.im.message.b a(long j) {
        if (this.j != null && this.j.getChatMessages() != null && this.j.getChatMessages().size() > 0) {
            for (com.baidu.tieba.im.message.b bVar : this.j.getChatMessages()) {
                if (bVar.j() == j) {
                    return bVar;
                }
            }
        }
        return null;
    }

    public void a(GroupData groupData) {
        this.f = groupData;
    }

    public GroupData a() {
        return this.f;
    }

    public void a(UserData userData) {
        this.g = userData;
    }

    public UserData b() {
        return this.g;
    }

    public MsgPageData c() {
        return this.j;
    }

    public boolean d() {
        return this.h;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void a(String str) {
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

    public void e() {
        synchronized (MsglistModel.class) {
            if (this.l != null) {
                for (Map.Entry<String, ag> entry : this.l.entrySet()) {
                    ag value = entry.getValue();
                    if (value != null) {
                        value.b();
                    }
                }
                this.l.clear();
            }
        }
        n();
    }

    public boolean f() {
        com.baidu.adp.lib.g.e.d("start loadFirst");
        if (r()) {
            return true;
        }
        com.baidu.tieba.im.message.o oVar = new com.baidu.tieba.im.message.o();
        oVar.b(this.e);
        if (q()) {
            if (this.f == null || this.f.getGroupId() == 0) {
                return false;
            }
            oVar.c(String.valueOf(this.f.getGroupId()));
        } else if (this.g == null) {
            return false;
        } else {
            oVar.a(this.g.getUserId());
        }
        oVar.a(20);
        oVar.b((String) null);
        oVar.a((String) null);
        com.baidu.tieba.im.messageCenter.e.a().a(oVar);
        return true;
    }

    public void g() {
        if (this.e == 1 && this.g != null) {
            com.baidu.tieba.im.message.ao aoVar = new com.baidu.tieba.im.message.ao();
            aoVar.a(this.g.getUserId());
            com.baidu.tieba.im.messageCenter.e.a().a(aoVar);
        }
    }

    public boolean h() {
        long j;
        long j2 = 0;
        com.baidu.adp.lib.g.e.d("start loadPrepage");
        if (r()) {
            return true;
        }
        com.baidu.tieba.im.message.o oVar = new com.baidu.tieba.im.message.o();
        oVar.b(this.e);
        if (q()) {
            if (this.f == null || this.f.getGroupId() == 0) {
                return false;
            }
            oVar.c(String.valueOf(this.f.getGroupId()));
        } else if (this.g == null) {
            return false;
        } else {
            oVar.a(this.g.getUserId());
        }
        if (this.j == null || this.j.getChatMessages() == null || this.j.getChatMessages().size() <= 0 || this.j.getChatMessages().get(0) == null) {
            j = 0;
        } else {
            j = this.j.getChatMessages().get(0).l();
            j2 = this.j.getChatMessages().get(0).j();
        }
        oVar.a(20);
        oVar.b(String.valueOf(j));
        oVar.a(String.valueOf(j2));
        com.baidu.tieba.im.messageCenter.e.a().a(oVar);
        return true;
    }

    public boolean i() {
        com.baidu.tieba.im.message.m mVar = new com.baidu.tieba.im.message.m();
        if (q() || r()) {
            if (this.f == null || this.f.getGroupId() == 0) {
                return false;
            }
            mVar.a(0);
            mVar.a(String.valueOf(this.f.getGroupId()));
        } else if (this.g == null) {
            return false;
        } else {
            mVar.a(1);
            mVar.a(String.valueOf(this.g.getUserId()));
        }
        com.baidu.tieba.im.messageCenter.e.a().a(mVar);
        return true;
    }

    public boolean b(String str) {
        if (this.i == null || !this.i.equals(str)) {
            cs csVar = new cs();
            if (q() || r()) {
                if (this.f == null || this.f.getGroupId() == 0) {
                    return false;
                }
                csVar.a(0);
                csVar.a(String.valueOf(this.f.getGroupId()));
            } else if (this.g == null) {
                return false;
            } else {
                csVar.a(1);
                csVar.a(String.valueOf(this.g.getUserId()));
            }
            csVar.b(str);
            com.baidu.tieba.im.messageCenter.e.a().a(csVar);
            return true;
        }
        return false;
    }

    private com.baidu.tieba.im.message.b a(short s, String str) {
        com.baidu.tieba.im.message.b bVar;
        long j;
        if (q() || r()) {
            com.baidu.tieba.im.message.g gVar = new com.baidu.tieba.im.message.g();
            gVar.a(System.currentTimeMillis());
            gVar.b(String.valueOf(this.f.getGroupId()));
            bVar = gVar;
        } else {
            com.baidu.tieba.im.message.b uVar = new com.baidu.tieba.im.message.u();
            uVar.a(System.currentTimeMillis());
            uVar.b(this.g.getUserId());
            com.baidu.tieba.data.UserData userData = new com.baidu.tieba.data.UserData();
            userData.setId(String.valueOf(this.g.getUserId()));
            userData.setName(this.g.getUserName());
            userData.setPortrait(this.g.getPortrait());
            uVar.b(userData);
            bVar = uVar;
        }
        bVar.b((int) s);
        bVar.a(str);
        long a = ba.a(j());
        bVar.d(a);
        bVar.c(a);
        bVar.f(System.currentTimeMillis() / 1000);
        com.baidu.tieba.data.UserData userData2 = new com.baidu.tieba.data.UserData();
        userData2.setName(TiebaApplication.F());
        userData2.setId(TiebaApplication.A());
        userData2.setPortrait(com.baidu.tieba.im.i.b());
        bVar.a(userData2);
        try {
            j = com.baidu.adp.lib.f.b.a(TiebaApplication.A(), 0L);
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.a("transform error" + e.getMessage());
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

    public long j() {
        List<com.baidu.tieba.im.message.b> chatMessages = this.j.getChatMessages();
        if (chatMessages == null || chatMessages.size() <= 0) {
            return 0L;
        }
        return chatMessages.get(chatMessages.size() - 1).l();
    }

    public void c(String str) {
        com.baidu.adp.lib.g.e.d("SHANG sendTextMessage");
        com.baidu.tieba.im.message.b a = a((short) 1, str);
        this.j.getChatMessages().add(a);
        this.mLoadDataMode = 4;
        this.mLoadDataCallBack.a(this.j);
        b(a);
    }

    public void a(com.baidu.tieba.editortool.q qVar) {
        String b2 = b(qVar);
        if (b2 != null) {
            com.baidu.tieba.im.message.b a = a((short) 4, b2);
            this.j.getChatMessages().add(a);
            this.mLoadDataMode = 4;
            this.mLoadDataCallBack.a(this.j);
            b(a);
        }
    }

    private String b(com.baidu.tieba.editortool.q qVar) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pid", qVar.d());
            jSONObject.put("packet_name", qVar.c());
            jSONObject.put("face_name", qVar.a());
            jSONObject.put("size_width", qVar.e());
            jSONObject.put("size_height", qVar.f());
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(String str, int i) {
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
            LinkedList<CommonMsgPojo> linkedList = new LinkedList<>();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(gVar);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            com.baidu.tieba.im.db.d.a().a(gVar.u(), linkedList, false, (com.baidu.tieba.im.a<Boolean>) new u(this, gVar));
        } else if (a instanceof com.baidu.tieba.im.message.u) {
            com.baidu.tieba.im.message.u uVar = (com.baidu.tieba.im.message.u) a;
            LinkedList<CommonMsgPojo> linkedList2 = new LinkedList<>();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(uVar);
            commonMsgPojo2.setRead_flag(0);
            linkedList2.add(commonMsgPojo2);
            au.a().a(uVar.m(), uVar.c(), linkedList2, false, (com.baidu.tieba.im.a<Boolean>) new v(this, uVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.im.message.b bVar) {
        VoiceMsgData f = com.baidu.tieba.im.d.d.f(bVar);
        if (f != null) {
            bVar.g(System.currentTimeMillis());
            this.m.a(f.getVoice_md5(), bVar.j());
        }
    }

    public void a(String str, Bitmap bitmap, ak akVar) {
        if (bitmap == null) {
            com.baidu.adp.lib.g.e.a("chosedImage is null!!!");
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
            LinkedList<CommonMsgPojo> linkedList = new LinkedList<>();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(gVar);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            com.baidu.tieba.im.db.d.a().a(gVar.u(), linkedList, false, (com.baidu.tieba.im.a<Boolean>) new w(this, gVar, str, akVar));
            return;
        }
        com.baidu.tieba.im.message.u uVar = (com.baidu.tieba.im.message.u) a;
        LinkedList<CommonMsgPojo> linkedList2 = new LinkedList<>();
        CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(uVar);
        commonMsgPojo2.setRead_flag(0);
        linkedList2.add(commonMsgPojo2);
        au.a().a(uVar.m(), uVar.c(), linkedList2, false, (com.baidu.tieba.im.a<Boolean>) new x(this, uVar, str, akVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(String str, String str2, int i, int i2) {
        PicMessageData picMessageData = new PicMessageData();
        picMessageData.src = str2;
        picMessageData.big_src = str;
        picMessageData.type = "3";
        if (i > 0) {
            picMessageData.bsize = i + "," + i2;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(picMessageData);
        String json = new Gson().toJson(linkedList);
        com.baidu.adp.lib.g.e.d("pic msg content:" + json);
        return json;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.im.message.b bVar, String str, ak akVar) {
        String optString;
        if (bVar != null) {
            if (bVar.k() == null) {
                c(bVar);
            }
            if (str == null) {
                try {
                    optString = new JSONArray(bVar.k()).getJSONObject(0).optString("src");
                } catch (Exception e) {
                    e.printStackTrace();
                    c(bVar);
                    return;
                }
            } else {
                optString = str;
            }
            if (optString == null) {
                c(bVar);
                return;
            }
            bVar.a(0);
            bVar.a(true);
            if (optString.startsWith("http")) {
                com.baidu.tieba.im.chat.q.b().a(bVar);
                return;
            }
            ag agVar = this.l.get(optString);
            if (agVar == null) {
                agVar = new ag(optString, 0, 0, 0, 0);
                agVar.a(bVar);
                agVar.a(akVar);
                agVar.a(this.n);
                if (bVar instanceof com.baidu.tieba.im.message.g) {
                    agVar.a(((com.baidu.tieba.im.message.g) bVar).u());
                } else {
                    agVar.a(String.valueOf(com.baidu.tieba.im.chat.q.a));
                }
                synchronized (MsglistModel.class) {
                    this.l.put(optString, agVar);
                }
            }
            bVar.g(System.currentTimeMillis());
            agVar.a();
        }
    }

    public void a(int i, ak akVar) {
        com.baidu.tieba.im.message.b a = a(i);
        if (a == null || a.n() == null || a.n().getStatus() == null) {
            com.baidu.adp.lib.g.e.b(b, "reSendMsg", "data error");
            return;
        }
        short shortValue = a.n().getStatus().shortValue();
        if (shortValue != 2) {
            com.baidu.adp.lib.g.e.b(b, "reSendMsg", "status error:" + ((int) shortValue));
            return;
        }
        a.c(a.l());
        a.n().setStatus((short) 1);
        a.f(System.currentTimeMillis() / 1000);
        switch (a.i()) {
            case 1:
                b(a);
                break;
            case 2:
                a(a, (String) null, akVar);
                break;
            case 3:
                a(a);
                break;
            case 4:
                b(a);
                break;
        }
        this.mLoadDataMode = 6;
        this.mLoadDataCallBack.a(this.j);
        a(i, a);
    }

    public com.baidu.tieba.im.message.b a(int i) {
        if (this.j == null || this.j.getChatMessages() == null || i < 0 || i >= this.j.getChatMessages().size()) {
            return null;
        }
        return this.j.getChatMessages().get(i);
    }

    public void b(int i) {
        int size = this.j.getChatMessages().size();
        if (i >= 0 && i < size) {
            com.baidu.tieba.im.message.b bVar = this.j.getChatMessages().get(i);
            if (q() || r()) {
                if (this.f != null && bVar != null) {
                    com.baidu.tieba.im.db.d.a().b(String.valueOf(this.f.getGroupId()), String.valueOf(bVar.l()), null);
                }
            } else if (this.g != null && bVar != null) {
                au.a().b(String.valueOf(this.g.getUserId()), String.valueOf(bVar.l()), null);
            }
            this.j.getChatMessages().remove(i);
        }
        this.mLoadDataMode = 7;
        this.mLoadDataCallBack.a(null);
    }

    public void c(int i) {
        int size = this.j.getChatMessages().size();
        if (i >= 0 && i < size) {
            com.baidu.tieba.im.message.b bVar = this.j.getChatMessages().get(i);
            com.baidu.tieba.im.message.b bVar2 = i + (-1) >= 0 ? this.j.getChatMessages().get(i - 1) : null;
            if (q() || r()) {
                if (this.f != null && bVar != null) {
                    com.baidu.tieba.im.db.d.a().a(String.valueOf(this.f.getGroupId()), String.valueOf(bVar.l()), (com.baidu.tieba.im.a<Boolean>) null);
                }
            } else if (this.g != null && bVar != null) {
                au.a().a(String.valueOf(this.g.getUserId()), String.valueOf(bVar.l()), null);
            }
            this.j.getChatMessages().remove(i);
            if (i == size - 1) {
                com.baidu.tieba.im.db.ae.a().a(new y(this, bVar, bVar2));
            }
        }
        this.mLoadDataMode = 7;
        this.mLoadDataCallBack.a(null);
    }

    public void a(int i, com.baidu.tieba.im.message.b bVar) {
        List<com.baidu.tieba.im.message.b> chatMessages = this.j.getChatMessages();
        int size = chatMessages.size();
        if (i >= 0 && i < size) {
            chatMessages.remove(i);
            chatMessages.add(i, bVar);
            this.j.setIsNewAdd(false);
            this.j.setNewAddNum(0);
        }
    }

    private void b(com.baidu.tieba.im.message.b bVar) {
        com.baidu.tieba.im.chat.q.b().a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.im.message.q qVar) {
        if (qVar instanceof bz) {
            bz bzVar = (bz) qVar;
            if (!bzVar.k() && !bzVar.a()) {
                o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        String string = this.p.getString(R.string.chat_permisson);
        if (this.g != null) {
            if (this.g.getSex() == 1) {
                string = string.replaceAll(this.p.getString(R.string.it), this.p.getString(R.string.he));
            } else if (this.g.getSex() == 2) {
                string = string.replaceAll(this.p.getString(R.string.it), this.p.getString(R.string.she));
            }
        }
        this.p.showToast(string, false);
        new Handler().postDelayed(new z(this), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.im.message.q qVar) {
        com.baidu.tieba.im.message.q n;
        String[] split;
        if (qVar instanceof cg) {
            cg cgVar = (cg) qVar;
            if (!cgVar.k() && (n = cgVar.n()) != null && (n instanceof at)) {
                at atVar = (at) n;
                if (atVar.b() == this.f.getGroupId()) {
                    String c = atVar.c();
                    if (!TextUtils.isEmpty(c) && (split = c.split(",")) != null && split.length != 0) {
                        String id = TiebaApplication.E().getID();
                        if (!TextUtils.isEmpty(id)) {
                            for (String str : split) {
                                if (id.equals(str)) {
                                    this.mLoadDataMode = 9;
                                    this.mLoadDataCallBack.a(null);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.im.message.q qVar) {
        if (qVar instanceof cr) {
            cr crVar = (cr) qVar;
            if (crVar.k() && crVar.l() == 110000) {
                com.baidu.adp.lib.g.e.d("-------unlogin");
                this.mLoadDataMode = 11;
                this.mLoadDataCallBack.a(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.j != null && this.j.getChatMessages() != null && this.j.getChatMessages().size() != 0) {
            this.j.getChatMessages().clear();
            this.mLoadDataMode = 12;
            this.mLoadDataCallBack.a(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.im.message.q qVar) {
        if (!(qVar instanceof cn)) {
            com.baidu.adp.lib.g.e.d("transform error");
            return;
        }
        cn cnVar = (cn) qVar;
        if (cnVar.k()) {
            com.baidu.adp.lib.g.e.a("has error");
        } else if (cnVar.a() != null) {
            this.mLoadDataMode = 10;
            this.mLoadDataCallBack.a(cnVar.a().getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(List<com.baidu.tieba.im.message.b> list, List<com.baidu.tieba.im.message.b> list2) {
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
            long j = list.get(i2).j();
            com.baidu.tieba.im.message.b bVar = list2.get(i);
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
                list.add(0, list2.get(i));
                i3++;
                i--;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<com.baidu.tieba.im.message.b> list, List<com.baidu.tieba.im.message.b> list2) {
        if (list != null && list2 != null) {
            int size = list.size();
            int size2 = list2.size();
            if (size2 != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = size - 1; i >= 0 && i >= 0; i--) {
                    com.baidu.tieba.im.message.b bVar = list.get(i);
                    if (bVar != null && bVar.g() != null && !TextUtils.isEmpty(bVar.g().getId()) && bVar.g().getId().equals(TiebaApplication.A()) && bVar.n() != null && (bVar.n().getStatus().shortValue() != 3 || bVar.i() == 4)) {
                        int i2 = size2 - 1;
                        while (true) {
                            if (i2 >= 0 && i2 >= 0) {
                                com.baidu.tieba.im.message.b bVar2 = list2.get(i2);
                                if (bVar2 != null && bVar2.g() != null && !TextUtils.isEmpty(bVar2.g().getId()) && bVar2.g().getId().equals(TiebaApplication.A()) && bVar2.j() == bVar.j()) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<com.baidu.tieba.im.message.b> list) {
        if (list != null && list.size() != 0) {
            com.baidu.adp.lib.g.e.d("*****start updateMsgStatusTimeOut");
            for (com.baidu.tieba.im.message.b bVar : list) {
                if (bVar != null && bVar.n() != null && bVar.n().getStatus().shortValue() == 1) {
                    if ((System.currentTimeMillis() / 1000) - bVar.p() > 1800) {
                        bVar.n().setStatus((short) 2);
                        com.baidu.adp.lib.g.e.d("*****create time out");
                    } else if (com.baidu.tieba.im.messageCenter.e.a().c(bVar)) {
                        com.baidu.adp.lib.g.e.d("***** find in queues");
                    } else {
                        bVar.n().setStatus((short) 2);
                        com.baidu.adp.lib.g.e.d("*****no find in queues");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bl blVar) {
        int i;
        if (blVar == null) {
            com.baidu.adp.lib.g.e.a("SHANG sendMsgSuc msg == null");
            return;
        }
        if (q() || r()) {
            if (blVar.c() == null || !blVar.c().equals(String.valueOf(this.f.getGroupId()))) {
                return;
            }
        } else {
            String c = blVar.c();
            if (c != null && c.length() != 0) {
                try {
                    i = Integer.parseInt(c);
                } catch (Exception e) {
                    e.printStackTrace();
                    i = 0;
                }
                com.baidu.tieba.im.chat.q.a(i);
                com.baidu.adp.lib.g.e.d("GET Personal Gid MSGACK=" + i);
            } else {
                return;
            }
        }
        com.baidu.adp.lib.g.e.d("SHANG sendMsgSuc msgId " + blVar.a() + " rid " + blVar.b());
        List<com.baidu.tieba.im.message.b> chatMessages = this.j.getChatMessages();
        long b2 = blVar.b();
        long a = blVar.a();
        this.j.setNewAddNum(0);
        this.j.setIsNewAdd(false);
        int size = chatMessages.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            } else if (b2 != chatMessages.get(size).j()) {
                size--;
            } else {
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
            }
        }
        this.mLoadDataMode = 5;
        this.mLoadDataCallBack.a(this.j);
        if (this.q != null) {
            com.baidu.adp.lib.g.e.e("simon", "send message", "send text");
            this.q.a(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.im.message.b bVar) {
        if (bVar == null) {
            com.baidu.adp.lib.g.e.a("SHANG sendMsgFail chatmessage == null");
            return;
        }
        if ((q() || r()) && (bVar instanceof com.baidu.tieba.im.message.g)) {
            com.baidu.tieba.im.message.g gVar = (com.baidu.tieba.im.message.g) bVar;
            if (gVar.u() == null || this.f == null || !gVar.u().equals(String.valueOf(this.f.getGroupId()))) {
                return;
            }
        } else if (this.e == 1 && (bVar instanceof com.baidu.tieba.im.message.u) && ((com.baidu.tieba.im.message.u) bVar).c() != this.g.getUserId()) {
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
        com.baidu.adp.lib.g.e.d("SHANG sendMsgFail msgId " + bVar.l() + "recordId " + bVar.j());
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

    public void a(com.baidu.tieba.im.a<Void> aVar) {
        if (q() || r()) {
            com.baidu.tieba.im.db.ah.a().a(String.valueOf(this.f.getGroupId()), aVar);
            com.baidu.tieba.im.message.al alVar = new com.baidu.tieba.im.message.al();
            alVar.a(String.valueOf(this.f.getGroupId()));
            com.baidu.tieba.im.messageCenter.e.a().a(alVar);
        } else if (this.e == 1) {
            com.baidu.tieba.im.db.ah.a().a(PersonalChatActivity.b, aVar);
            com.baidu.tieba.im.m.a(new aa(this), aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(com.baidu.tieba.im.message.b bVar) {
        if (bVar == null) {
            return "";
        }
        int i = bVar.i();
        String string = TiebaApplication.h().getString(R.string.websocket_type);
        switch (i) {
            case 1:
                return string + TiebaApplication.h().getString(R.string.log_msg_text);
            case 2:
                return string + TiebaApplication.h().getString(R.string.log_msg_pic);
            case 3:
                return string + TiebaApplication.h().getString(R.string.log_msg_voice);
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<com.baidu.tieba.im.message.b> list) {
        int i;
        int i2;
        if (this.p.c() != null) {
            i2 = this.p.c().getFirstVisiblePosition();
            i = this.p.c().getLastVisiblePosition();
        } else {
            i = -1;
            i2 = -1;
        }
        List<com.baidu.tieba.im.message.b> chatMessages = this.j.getChatMessages();
        int size = chatMessages.size();
        if (i2 >= 0 && i < size) {
            for (com.baidu.tieba.im.message.b bVar : list) {
                if (bVar.i() == 4) {
                    ci.a = com.baidu.tieba.util.i.b();
                }
                long m = bVar.m();
                String portrait = bVar.g().getPortrait();
                for (int i3 = i2; i3 <= i; i3++) {
                    com.baidu.tieba.im.message.b bVar2 = chatMessages.get(i3);
                    if (bVar2 != null) {
                        if (m == bVar2.m()) {
                            if (bVar2.g() != null) {
                                String portrait2 = bVar2.g().getPortrait();
                                if (portrait != null && !portrait.equals(portrait2)) {
                                    bVar2.g().setPortrait(portrait);
                                }
                            } else {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        return this.e == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        return this.e == 2;
    }

    public int k() {
        return this.e;
    }

    public void d(int i) {
        this.e = i;
    }

    public void a(ae aeVar) {
        this.q = aeVar;
    }
}
