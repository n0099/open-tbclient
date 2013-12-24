package com.baidu.tieba.im.model;

import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.bc;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.ar;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.az;
import com.baidu.tieba.im.message.bm;
import com.baidu.tieba.im.message.br;
import com.baidu.tieba.im.message.bw;
import com.baidu.tieba.im.message.bz;
import com.baidu.tieba.im.message.ca;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class MsglistModel extends com.baidu.adp.a.d {
    private static final String b = MsglistModel.class.getName();
    private String i;
    private MsgPageData j;
    private com.baidu.tieba.im.chat.ag k;
    private ac o;
    private bc p;
    private final int c = 1800;
    private final int d = 20;
    private int e = 0;
    private GroupData f = null;
    private UserData g = null;
    private boolean h = true;
    com.baidu.adp.a.g a = new q(this);
    private final HashMap<String, ae> l = new HashMap<>();
    private final ah n = new n(this);
    private final an m = new an();

    /* loaded from: classes.dex */
    public class PicMessageData implements Serializable {
        private static final long serialVersionUID = -2120837602853869652L;
        public String big_src;
        public String bsize;
        public String src;
        public String type;
    }

    public MsglistModel(bc bcVar) {
        this.j = null;
        this.k = null;
        this.p = bcVar;
        this.j = new MsgPageData();
        this.k = new ab(this, null);
        this.m.setLoadDataCallBack(this.a);
        m();
    }

    private void m() {
        com.baidu.tieba.im.chat.a.b().a(this.k);
        this.o = new ac(this, null);
        com.baidu.tieba.im.messageCenter.e.a().a(103112, this.o);
        com.baidu.tieba.im.messageCenter.e.a().a(103102, this.o);
        com.baidu.tieba.im.messageCenter.e.a().a(202003, this.o);
        com.baidu.tieba.im.messageCenter.e.a().a(-113, this.o);
        com.baidu.tieba.im.messageCenter.e.a().a(205004, this.o);
    }

    private void n() {
        com.baidu.tieba.im.chat.a.b().b(this.k);
        com.baidu.tieba.im.messageCenter.e.a().a(this.o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.im.message.b a(long j) {
        if (this.j != null && this.j.getChatMessages() != null && this.j.getChatMessages().size() > 0) {
            for (com.baidu.tieba.im.message.b bVar : this.j.getChatMessages()) {
                if (bVar.i() == j) {
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
                for (Map.Entry<String, ae> entry : this.l.entrySet()) {
                    ae value = entry.getValue();
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
        com.baidu.adp.lib.h.e.d("start loadFirst");
        com.baidu.tieba.im.message.l lVar = new com.baidu.tieba.im.message.l();
        lVar.b(this.e);
        if (this.e == 0) {
            if (this.f == null || this.f.getGroupId() == 0) {
                return false;
            }
            lVar.c(String.valueOf(this.f.getGroupId()));
        } else if (this.g == null) {
            return false;
        } else {
            lVar.a(this.g.getUserId());
        }
        lVar.a(20);
        lVar.b((String) null);
        lVar.a((String) null);
        com.baidu.tieba.im.messageCenter.e.a().a(lVar);
        return true;
    }

    public void g() {
        if (this.e == 1 && this.g != null) {
            com.baidu.tieba.im.message.ah ahVar = new com.baidu.tieba.im.message.ah();
            ahVar.a(this.g.getUserId());
            com.baidu.tieba.im.messageCenter.e.a().a(ahVar);
        }
    }

    public boolean h() {
        long j;
        long j2 = 0;
        com.baidu.adp.lib.h.e.d("start loadPrepage");
        com.baidu.tieba.im.message.l lVar = new com.baidu.tieba.im.message.l();
        lVar.b(this.e);
        if (this.e == 0) {
            if (this.f == null || this.f.getGroupId() == 0) {
                return false;
            }
            lVar.c(String.valueOf(this.f.getGroupId()));
        } else if (this.g == null) {
            return false;
        } else {
            lVar.a(this.g.getUserId());
        }
        if (this.j == null || this.j.getChatMessages() == null || this.j.getChatMessages().size() <= 0 || this.j.getChatMessages().get(0) == null) {
            j = 0;
        } else {
            j = this.j.getChatMessages().get(0).k();
            j2 = this.j.getChatMessages().get(0).i();
        }
        lVar.a(20);
        lVar.b(String.valueOf(j));
        lVar.a(String.valueOf(j2));
        com.baidu.tieba.im.messageCenter.e.a().a(lVar);
        return true;
    }

    public boolean i() {
        com.baidu.tieba.im.message.j jVar = new com.baidu.tieba.im.message.j();
        if (this.e == 0) {
            if (this.f == null || this.f.getGroupId() == 0) {
                return false;
            }
            jVar.a(0);
            jVar.a(String.valueOf(this.f.getGroupId()));
        } else if (this.g == null) {
            return false;
        } else {
            jVar.a(1);
            jVar.a(String.valueOf(this.g.getUserId()));
        }
        com.baidu.tieba.im.messageCenter.e.a().a(jVar);
        return true;
    }

    public boolean b(String str) {
        if (this.i == null || !this.i.equals(str)) {
            ca caVar = new ca();
            if (this.e == 0) {
                if (this.f == null || this.f.getGroupId() == 0) {
                    return false;
                }
                caVar.a(0);
                caVar.a(String.valueOf(this.f.getGroupId()));
            } else if (this.g == null) {
                return false;
            } else {
                caVar.a(1);
                caVar.a(String.valueOf(this.g.getUserId()));
            }
            caVar.b(str);
            com.baidu.tieba.im.messageCenter.e.a().a(caVar);
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.im.message.d */
    /* JADX WARN: Multi-variable type inference failed */
    private com.baidu.tieba.im.message.b a(short s, String str) {
        com.baidu.tieba.im.message.p pVar;
        long j;
        if (this.e == 0) {
            com.baidu.tieba.im.message.d dVar = new com.baidu.tieba.im.message.d();
            dVar.b(String.valueOf(this.f.getGroupId()));
            pVar = dVar;
        } else {
            com.baidu.tieba.im.message.p pVar2 = new com.baidu.tieba.im.message.p();
            pVar2.a(this.g.getUserId());
            com.baidu.tieba.data.UserData userData = new com.baidu.tieba.data.UserData();
            userData.setId(String.valueOf(this.g.getUserId()));
            userData.setName(this.g.getUserName());
            userData.setPortrait(this.g.getPortrait());
            pVar2.b(userData);
            pVar = pVar2;
        }
        pVar.b((int) s);
        pVar.a(str);
        long a = com.baidu.tieba.im.chat.ai.a(j());
        pVar.c(a);
        pVar.b(a);
        pVar.e(System.currentTimeMillis() / 1000);
        com.baidu.tieba.data.UserData userData2 = new com.baidu.tieba.data.UserData();
        userData2.setName(TiebaApplication.G());
        userData2.setId(TiebaApplication.B());
        userData2.setPortrait(com.baidu.tieba.im.i.b());
        pVar.a(userData2);
        try {
            j = Long.valueOf(TiebaApplication.B()).longValue();
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.a("transform error" + e.getMessage());
            j = 0;
        }
        pVar.d(j);
        MsgLocalData msgLocalData = new MsgLocalData();
        msgLocalData.setStatus((short) 1);
        msgLocalData.setErrno(0L);
        msgLocalData.setRetry(0L);
        msgLocalData.setUpload_offset(null);
        pVar.a(msgLocalData);
        return pVar;
    }

    public long j() {
        List<com.baidu.tieba.im.message.b> chatMessages = this.j.getChatMessages();
        if (chatMessages == null || chatMessages.size() <= 0) {
            return 0L;
        }
        return chatMessages.get(chatMessages.size() - 1).k();
    }

    public void c(String str) {
        com.baidu.adp.lib.h.e.d("SHANG sendTextMessage");
        com.baidu.tieba.im.message.b a = a((short) 1, str);
        this.j.getChatMessages().add(a);
        this.mLoadDataMode = 4;
        this.mLoadDataCallBack.a(this.j);
        b(a);
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
        if (a instanceof com.baidu.tieba.im.message.d) {
            com.baidu.tieba.im.message.d dVar = (com.baidu.tieba.im.message.d) a;
            LinkedList<CommonMsgPojo> linkedList = new LinkedList<>();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(dVar);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            com.baidu.tieba.im.db.d.a().a(dVar.s(), linkedList, false, (com.baidu.tieba.im.a<Boolean>) new t(this, dVar));
        } else if (a instanceof com.baidu.tieba.im.message.p) {
            com.baidu.tieba.im.message.p pVar = (com.baidu.tieba.im.message.p) a;
            LinkedList<CommonMsgPojo> linkedList2 = new LinkedList<>();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(pVar);
            commonMsgPojo2.setRead_flag(0);
            linkedList2.add(commonMsgPojo2);
            ar.a().a(pVar.l(), pVar.b(), linkedList2, false, (com.baidu.tieba.im.a<Boolean>) new u(this, pVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.im.message.b bVar) {
        VoiceMsgData e = com.baidu.tieba.im.d.d.e(bVar);
        if (e != null) {
            bVar.f(System.currentTimeMillis());
            this.m.a(e.getVoice_md5(), bVar.i());
        }
    }

    public void a(String str, Bitmap bitmap, ai aiVar) {
        if (bitmap == null) {
            be.a("chosedImage is null!!!");
            return;
        }
        com.baidu.tieba.im.message.b a = a((short) 2, a(str, str, bitmap.getWidth(), bitmap.getHeight()));
        a.a(true);
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            a.c(width);
            a.d(height);
        }
        this.j.getChatMessages().add(a);
        this.mLoadDataMode = 4;
        this.mLoadDataCallBack.a(this.j);
        if (a instanceof com.baidu.tieba.im.message.d) {
            com.baidu.tieba.im.message.d dVar = (com.baidu.tieba.im.message.d) a;
            LinkedList<CommonMsgPojo> linkedList = new LinkedList<>();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(dVar);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            com.baidu.tieba.im.db.d.a().a(dVar.s(), linkedList, false, (com.baidu.tieba.im.a<Boolean>) new v(this, dVar, str, aiVar));
            return;
        }
        com.baidu.tieba.im.message.p pVar = (com.baidu.tieba.im.message.p) a;
        LinkedList<CommonMsgPojo> linkedList2 = new LinkedList<>();
        CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(pVar);
        commonMsgPojo2.setRead_flag(0);
        linkedList2.add(commonMsgPojo2);
        ar.a().a(pVar.l(), pVar.b(), linkedList2, false, (com.baidu.tieba.im.a<Boolean>) new w(this, pVar, str, aiVar));
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
        com.baidu.adp.lib.h.e.d("pic msg content:" + json);
        return json;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.im.message.b bVar, String str, ai aiVar) {
        String optString;
        if (bVar != null) {
            if (bVar.j() == null) {
                c(bVar);
            }
            if (str == null) {
                try {
                    optString = new JSONArray(bVar.j()).getJSONObject(0).optString("src");
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
                com.baidu.tieba.im.chat.a.b().a(bVar);
                return;
            }
            ae aeVar = this.l.get(optString);
            if (aeVar == null) {
                aeVar = new ae(optString, 0, 0, 0, 0);
                aeVar.a(bVar);
                aeVar.a(aiVar);
                aeVar.a(this.n);
                if (bVar instanceof com.baidu.tieba.im.message.d) {
                    aeVar.a(((com.baidu.tieba.im.message.d) bVar).s());
                } else {
                    aeVar.a(String.valueOf(com.baidu.tieba.im.chat.a.a));
                }
                synchronized (MsglistModel.class) {
                    this.l.put(optString, aeVar);
                }
            }
            bVar.f(System.currentTimeMillis());
            aeVar.a();
        }
    }

    public void a(int i, ai aiVar) {
        com.baidu.tieba.im.message.b a = a(i);
        if (a == null || a.m() == null || a.m().getStatus() == null) {
            com.baidu.adp.lib.h.e.b(b, "reSendMsg", "data error");
            return;
        }
        short shortValue = a.m().getStatus().shortValue();
        if (shortValue != 2) {
            com.baidu.adp.lib.h.e.b(b, "reSendMsg", "status error:" + ((int) shortValue));
            return;
        }
        a.b(a.k());
        a.m().setStatus((short) 1);
        a.e(System.currentTimeMillis() / 1000);
        switch (a.h()) {
            case 1:
                b(a);
                break;
            case 2:
                a(a, (String) null, aiVar);
                break;
            case 3:
                a(a);
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
            if (this.e == 0) {
                if (this.f != null && bVar != null) {
                    com.baidu.tieba.im.db.d.a().b(String.valueOf(this.f.getGroupId()), String.valueOf(bVar.k()), null);
                }
            } else if (this.g != null && bVar != null) {
                ar.a().b(String.valueOf(this.g.getUserId()), String.valueOf(bVar.k()), null);
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
            if (this.e == 0) {
                if (this.f != null && bVar != null) {
                    com.baidu.tieba.im.db.d.a().a(String.valueOf(this.f.getGroupId()), String.valueOf(bVar.k()), (com.baidu.tieba.im.a<Boolean>) null);
                }
            } else if (this.g != null && bVar != null) {
                ar.a().a(String.valueOf(this.g.getUserId()), String.valueOf(bVar.k()), null);
            }
            this.j.getChatMessages().remove(i);
            if (i == size - 1) {
                com.baidu.tieba.im.db.ad.a().a(new x(this, bVar, bVar2));
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
        com.baidu.tieba.im.chat.a.b().a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.im.message.n nVar) {
        if (nVar instanceof bm) {
            bm bmVar = (bm) nVar;
            if (!bmVar.i() && !bmVar.a()) {
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
        new Handler().postDelayed(new y(this), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.im.message.n nVar) {
        com.baidu.tieba.im.message.n l;
        String[] split;
        if (nVar instanceof br) {
            br brVar = (br) nVar;
            if (!brVar.i() && (l = brVar.l()) != null && (l instanceof com.baidu.tieba.im.message.ak)) {
                com.baidu.tieba.im.message.ak akVar = (com.baidu.tieba.im.message.ak) l;
                if (akVar.b() == this.f.getGroupId()) {
                    String c = akVar.c();
                    if (!TextUtils.isEmpty(c) && (split = c.split(",")) != null && split.length != 0) {
                        String id = TiebaApplication.F().getID();
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
    public void c(com.baidu.tieba.im.message.n nVar) {
        if (nVar instanceof bz) {
            bz bzVar = (bz) nVar;
            if (bzVar.i() && bzVar.j() == 110000) {
                com.baidu.adp.lib.h.e.d("-------unlogin");
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
    public void d(com.baidu.tieba.im.message.n nVar) {
        if (!(nVar instanceof bw)) {
            com.baidu.adp.lib.h.e.d("transform error");
            return;
        }
        bw bwVar = (bw) nVar;
        if (bwVar.i()) {
            com.baidu.adp.lib.h.e.a("has error");
        } else if (bwVar.a() != null) {
            this.mLoadDataMode = 10;
            this.mLoadDataCallBack.a(bwVar.a().getName());
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
            long i4 = list.get(i2).i();
            com.baidu.tieba.im.message.b bVar = list2.get(i);
            long i5 = bVar.i();
            if (i4 > i5) {
                i2--;
            } else if (i4 < i5) {
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
                    if (bVar != null && bVar.f() != null && !TextUtils.isEmpty(bVar.f().getId()) && bVar.f().getId().equals(TiebaApplication.B()) && bVar.m() != null && bVar.m().getStatus().shortValue() != 3) {
                        int i2 = size2 - 1;
                        while (true) {
                            if (i2 >= 0 && i2 >= 0) {
                                com.baidu.tieba.im.message.b bVar2 = list2.get(i2);
                                if (bVar2 != null && bVar2.f() != null && !TextUtils.isEmpty(bVar2.f().getId()) && bVar2.f().getId().equals(TiebaApplication.B()) && bVar2.i() == bVar.i()) {
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
            com.baidu.adp.lib.h.e.d("*****start updateMsgStatusTimeOut");
            for (com.baidu.tieba.im.message.b bVar : list) {
                if (bVar != null && bVar.m() != null && bVar.m().getStatus().shortValue() == 1) {
                    if ((System.currentTimeMillis() / 1000) - bVar.o() > 1800) {
                        bVar.m().setStatus((short) 2);
                        com.baidu.adp.lib.h.e.d("*****create time out");
                    } else if (com.baidu.tieba.im.messageCenter.e.a().c(bVar)) {
                        com.baidu.adp.lib.h.e.d("***** find in queues");
                    } else {
                        bVar.m().setStatus((short) 2);
                        com.baidu.adp.lib.h.e.d("*****no find in queues");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(az azVar) {
        int i;
        if (azVar == null) {
            com.baidu.adp.lib.h.e.a("SHANG sendMsgSuc msg == null");
            return;
        }
        if (this.e == 0) {
            if (azVar.c() == null || !azVar.c().equals(String.valueOf(this.f.getGroupId()))) {
                return;
            }
        } else {
            String c = azVar.c();
            if (c != null && c.length() != 0) {
                try {
                    i = Integer.parseInt(c);
                } catch (Exception e) {
                    e.printStackTrace();
                    i = 0;
                }
                com.baidu.tieba.im.chat.a.a(i);
                com.baidu.adp.lib.h.e.d("GET Personal Gid MSGACK=" + i);
            } else {
                return;
            }
        }
        com.baidu.adp.lib.h.e.d("SHANG sendMsgSuc msgId " + azVar.a() + " rid " + azVar.b());
        List<com.baidu.tieba.im.message.b> chatMessages = this.j.getChatMessages();
        long b2 = azVar.b();
        long a = azVar.a();
        this.j.setNewAddNum(0);
        this.j.setIsNewAdd(false);
        int size = chatMessages.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            } else if (b2 != chatMessages.get(size).i()) {
                size--;
            } else {
                com.baidu.tieba.im.message.b bVar = chatMessages.get(size);
                if (bVar.m() == null) {
                    MsgLocalData msgLocalData = new MsgLocalData();
                    msgLocalData.setStatus((short) 1);
                    msgLocalData.setErrno(0L);
                    msgLocalData.setRetry(0L);
                    msgLocalData.setUpload_offset(null);
                    bVar.a(msgLocalData);
                }
                bVar.c(a);
                bVar.m().setStatus((short) 3);
            }
        }
        this.mLoadDataMode = 5;
        this.mLoadDataCallBack.a(this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.im.message.b bVar) {
        if (bVar == null) {
            com.baidu.adp.lib.h.e.a("SHANG sendMsgFail chatmessage == null");
            return;
        }
        if (this.e == 0 && (bVar instanceof com.baidu.tieba.im.message.d)) {
            com.baidu.tieba.im.message.d dVar = (com.baidu.tieba.im.message.d) bVar;
            if (dVar.s() == null || this.f == null || !dVar.s().equals(String.valueOf(this.f.getGroupId()))) {
                return;
            }
        } else if (this.e == 1 && (bVar instanceof com.baidu.tieba.im.message.p) && ((com.baidu.tieba.im.message.p) bVar).b() != this.g.getUserId()) {
            return;
        }
        bVar.a(false);
        if (bVar.m() == null) {
            MsgLocalData msgLocalData = new MsgLocalData();
            msgLocalData.setStatus((short) 1);
            msgLocalData.setErrno(0L);
            msgLocalData.setRetry(0L);
            msgLocalData.setUpload_offset(null);
            bVar.a(msgLocalData);
        }
        com.baidu.adp.lib.h.e.d("SHANG sendMsgFail msgId " + bVar.k() + "recordId " + bVar.i());
        bVar.m().setStatus((short) 2);
        List<com.baidu.tieba.im.message.b> chatMessages = this.j.getChatMessages();
        if (chatMessages != null && chatMessages.size() != 0) {
            long i = bVar.i();
            int size = chatMessages.size() - 1;
            while (size >= 0 && chatMessages.get(size).k() != i) {
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
        if (this.e == 0) {
            com.baidu.tieba.im.db.ag.a().a(String.valueOf(this.f.getGroupId()), aVar);
            com.baidu.tieba.im.message.ae aeVar = new com.baidu.tieba.im.message.ae();
            aeVar.a(String.valueOf(this.f.getGroupId()));
            com.baidu.tieba.im.messageCenter.e.a().a(aeVar);
        } else if (this.e == 1) {
            com.baidu.tieba.im.db.ag.a().a(bc.d, aVar);
            com.baidu.tieba.im.m.a(new z(this), aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(com.baidu.tieba.im.message.b bVar) {
        if (bVar == null) {
            return "";
        }
        int h = bVar.h();
        String string = TiebaApplication.h().getString(R.string.websocket_type);
        switch (h) {
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
        int firstVisiblePosition = this.p.c().getFirstVisiblePosition();
        int lastVisiblePosition = this.p.c().getLastVisiblePosition();
        List<com.baidu.tieba.im.message.b> chatMessages = this.j.getChatMessages();
        int size = chatMessages.size();
        if (firstVisiblePosition >= 0 && lastVisiblePosition < size) {
            for (com.baidu.tieba.im.message.b bVar : list) {
                long l = bVar.l();
                String portrait = bVar.f().getPortrait();
                for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                    com.baidu.tieba.im.message.b bVar2 = chatMessages.get(i);
                    if (l == bVar2.l()) {
                        String portrait2 = bVar2.f().getPortrait();
                        if (portrait != null && !portrait.equals(portrait2)) {
                            bVar2.f().setPortrait(portrait);
                        }
                    }
                }
            }
        }
    }

    public int k() {
        return this.e;
    }

    public void d(int i) {
        this.e = i;
    }
}
