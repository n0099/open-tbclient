package com.baidu.tieba.im.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.dc;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.LoadDraftResponsedMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.ResponseCommitMessage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
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
public abstract class MsglistModel extends com.baidu.adp.a.e {
    private static final String a = MsglistModel.class.getName();
    protected MsgPageData b;
    protected MsglistActivity c;
    private String g;
    private final HashMap<String, com.baidu.tbadk.img.a<com.baidu.tieba.im.message.a.a>> h;
    private final bt i;
    private final com.baidu.tbadk.img.d j;
    private ax k;
    private final int e = 1800;
    private boolean f = true;
    com.baidu.adp.a.h d = new aa(this);
    private final com.baidu.adp.framework.c.a l = new al(this, 0);
    private com.baidu.adp.framework.c.a m = new am(this, 0);

    /* loaded from: classes.dex */
    public class PicMessageData implements Serializable {
        private static final long serialVersionUID = -2120837602853869652L;
        public String big_src;
        public String bsize;
        public String src;
        public String type;
    }

    protected abstract ImMessageCenterPojo a(com.baidu.tieba.im.db.e eVar);

    public abstract void a(com.baidu.tieba.im.a<Void> aVar);

    protected abstract void a(com.baidu.tieba.im.message.a.a aVar);

    public abstract boolean a(String str);

    protected abstract void b(com.baidu.tieba.im.message.a.a aVar);

    public abstract boolean d();

    public abstract boolean e();

    protected abstract com.baidu.tieba.im.message.a.a f();

    public abstract boolean f_();

    public MsglistModel(MsglistActivity msglistActivity) {
        this.b = null;
        setUniqueId(msglistActivity.getUniqueId());
        this.c = msglistActivity;
        this.b = new MsgPageData();
        this.h = new HashMap<>();
        this.j = new an(this);
        this.i = new bt();
        this.i.setLoadDataCallBack(this.d);
        com.baidu.adp.framework.c.a().a(2001157, this.m);
        com.baidu.adp.framework.c.a().a(2001113, this.l);
        com.baidu.adp.framework.c.a().a(501126, this.l);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ com.baidu.tieba.im.message.a.a a(MsglistModel msglistModel, long j) {
        if (msglistModel.b != null && msglistModel.b.getChatMessages() != null && msglistModel.b.getChatMessages().size() > 0) {
            for (com.baidu.tieba.im.message.a.a aVar : msglistModel.b.getChatMessages()) {
                if (aVar.u() == j) {
                    return aVar;
                }
            }
        }
        return null;
    }

    public final MsgPageData g() {
        return this.b;
    }

    public final boolean h() {
        return this.f;
    }

    public final void a(boolean z) {
        this.f = z;
    }

    public final void b(String str) {
        this.g = str;
    }

    @Override // com.baidu.adp.a.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a() {
        com.baidu.tbadk.img.a<com.baidu.tieba.im.message.a.a> remove;
        synchronized (MsglistModel.class) {
            if (this.h != null) {
                while (!this.h.isEmpty()) {
                    Set<Map.Entry<String, com.baidu.tbadk.img.a<com.baidu.tieba.im.message.a.a>>> entrySet = this.h.entrySet();
                    if (!entrySet.isEmpty() && (remove = this.h.remove(entrySet.iterator().next().getKey())) != null) {
                        remove.b();
                    }
                }
            }
        }
        com.baidu.adp.framework.c.a().b(this.m);
        com.baidu.adp.framework.c.a().b(this.l);
    }

    public final boolean c(String str) {
        if (this.g == null || !this.g.equals(str)) {
            return a(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.baidu.tieba.im.message.a.a a(short s, String str) {
        long j;
        com.baidu.tieba.im.message.a.a f = f();
        if (f == null) {
            return null;
        }
        f.e((int) s);
        f.d(str);
        List<com.baidu.tieba.im.message.a.a> chatMessages = this.b.getChatMessages();
        long w = ((chatMessages == null || chatMessages.size() <= 0) ? 0L : chatMessages.get(chatMessages.size() - 1).w()) + 1;
        f.f(w);
        f.e(w);
        f.h(System.currentTimeMillis() / 1000);
        UserData userData = new UserData();
        userData.setUserName(TbadkApplication.O());
        userData.setUserId(TbadkApplication.E());
        userData.setPortrait(com.baidu.tieba.im.p.c());
        f.a(userData);
        try {
            j = com.baidu.adp.lib.f.b.a(TbadkApplication.E(), 0L);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("transform error" + e.getMessage());
            j = 0;
        }
        f.g(j);
        MsgLocalData msgLocalData = new MsgLocalData();
        msgLocalData.setStatus((short) 1);
        msgLocalData.setErrno(0L);
        msgLocalData.setRetry(0L);
        msgLocalData.setUpload_offset(null);
        f.a(msgLocalData);
        return f;
    }

    public final void d(String str) {
        com.baidu.adp.lib.util.f.e("SHANG sendTextMessage");
        com.baidu.tieba.im.message.a.a a2 = a((short) 1, str);
        if (a2 != null) {
            this.b.getChatMessages().add(a2);
            this.mLoadDataMode = 4;
            this.mLoadDataCallBack.a(this.b);
            com.baidu.tieba.im.chat.x.b().a(a2);
        }
    }

    public final void a(com.baidu.tbadk.coreExtra.data.d dVar) {
        com.baidu.tieba.im.message.a.a a2;
        String b = b(dVar);
        if (b != null && (a2 = a((short) 4, b)) != null) {
            this.b.getChatMessages().add(a2);
            this.mLoadDataMode = 4;
            this.mLoadDataCallBack.a(this.b);
            com.baidu.tieba.im.chat.x.b().a(a2);
        }
    }

    private static String b(com.baidu.tbadk.coreExtra.data.d dVar) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pid", dVar.d());
            jSONObject.put("packet_name", dVar.c());
            jSONObject.put("face_name", dVar.a());
            jSONObject.put("size_width", dVar.e());
            jSONObject.put("size_height", dVar.f());
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
        voiceMsgData.setHas_read(0);
        com.baidu.tieba.im.message.a.a a2 = a((short) 3, "[" + new Gson().toJson(voiceMsgData) + "]");
        if (a2 != null) {
            a2.a((MsgCacheData) null);
            this.b.getChatMessages().add(a2);
            this.mLoadDataMode = 4;
            this.mLoadDataCallBack.a(this.b);
            if (a2 instanceof com.baidu.tieba.im.message.a.b) {
                com.baidu.tieba.im.message.a.b bVar = (com.baidu.tieba.im.message.a.b) a2;
                LinkedList linkedList = new LinkedList();
                CommonMsgPojo commonMsgPojo = new CommonMsgPojo(bVar);
                commonMsgPojo.setRead_flag(0);
                linkedList.add(commonMsgPojo);
                com.baidu.tieba.im.r.a(new ar(this, bVar, linkedList), new as(this, bVar));
            } else if (a2 instanceof com.baidu.tieba.im.message.a.f) {
                com.baidu.tieba.im.message.a.f fVar = (com.baidu.tieba.im.message.a.f) a2;
                LinkedList linkedList2 = new LinkedList();
                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(fVar);
                commonMsgPojo2.setRead_flag(0);
                linkedList2.add(commonMsgPojo2);
                com.baidu.tieba.im.r.a(new at(this, fVar, linkedList2), new au(this, fVar));
            } else if (a2 instanceof com.baidu.tieba.im.message.a.e) {
                com.baidu.tieba.im.message.a.e eVar = (com.baidu.tieba.im.message.a.e) a2;
                LinkedList linkedList3 = new LinkedList();
                CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(eVar);
                commonMsgPojo3.setRead_flag(0);
                linkedList3.add(commonMsgPojo3);
                com.baidu.tieba.im.r.a(new av(this, eVar, linkedList3), new ae(this, eVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.im.message.a.a aVar) {
        VoiceMsgData f = com.baidu.tieba.im.f.q.f(aVar);
        if (f != null) {
            aVar.i(System.currentTimeMillis());
            this.i.a(f.getVoice_md5(), aVar.u());
        }
    }

    public final void a(String str, Bitmap bitmap, com.baidu.tbadk.img.b<com.baidu.tieba.im.message.a.a> bVar) {
        if (bitmap == null) {
            com.baidu.adp.lib.util.f.b("chosedImage is null!!!");
            return;
        }
        com.baidu.tieba.im.message.a.a a2 = a((short) 2, a(str, str, bitmap.getWidth(), bitmap.getHeight()));
        if (a2 != null) {
            a2.a(true);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            a2.f(width);
            a2.h(height);
            this.b.getChatMessages().add(a2);
            this.mLoadDataMode = 4;
            this.mLoadDataCallBack.a(this.b);
            if (a2 instanceof com.baidu.tieba.im.message.a.b) {
                com.baidu.tieba.im.message.a.b bVar2 = (com.baidu.tieba.im.message.a.b) a2;
                LinkedList linkedList = new LinkedList();
                CommonMsgPojo commonMsgPojo = new CommonMsgPojo(bVar2);
                commonMsgPojo.setRead_flag(0);
                linkedList.add(commonMsgPojo);
                com.baidu.tieba.im.r.a(new af(this, bVar2, linkedList), new ag(this, bVar2, str, bVar));
            } else if (a2 instanceof com.baidu.tieba.im.message.a.f) {
                com.baidu.tieba.im.message.a.f fVar = (com.baidu.tieba.im.message.a.f) a2;
                LinkedList linkedList2 = new LinkedList();
                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(fVar);
                commonMsgPojo2.setRead_flag(0);
                linkedList2.add(commonMsgPojo2);
                com.baidu.tieba.im.r.a(new ah(this, fVar, linkedList2), new ai(this, fVar, str, bVar));
            } else if (a2 instanceof com.baidu.tieba.im.message.a.e) {
                com.baidu.tieba.im.message.a.e eVar = (com.baidu.tieba.im.message.a.e) a2;
                LinkedList linkedList3 = new LinkedList();
                CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(eVar);
                commonMsgPojo3.setRead_flag(0);
                linkedList3.add(commonMsgPojo3);
                com.baidu.tieba.im.r.a(new aj(this, eVar, linkedList3), new ak(this, eVar, str, bVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
        com.baidu.adp.lib.util.f.e("pic msg content:" + json);
        return json;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tieba.im.message.a.a */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.baidu.tieba.im.message.a.a aVar, String str, com.baidu.tbadk.img.b<com.baidu.tieba.im.message.a.a> bVar) {
        if (aVar != 0) {
            if (aVar.v() == null) {
                d(aVar);
            }
            if (str == null) {
                try {
                    str = new JSONArray(aVar.v()).getJSONObject(0).optString("src");
                } catch (Exception e) {
                    e.printStackTrace();
                    d(aVar);
                    return;
                }
            }
            if (str == null) {
                d(aVar);
                return;
            }
            aVar.d(0);
            aVar.a(true);
            if (str.startsWith("http")) {
                com.baidu.tieba.im.chat.x.b().a(aVar);
                return;
            }
            com.baidu.tbadk.img.a<com.baidu.tieba.im.message.a.a> aVar2 = this.h.get(str);
            if (aVar2 == null) {
                com.baidu.tbadk.img.a<com.baidu.tieba.im.message.a.a> aVar3 = new com.baidu.tbadk.img.a<>(str, "IM");
                aVar3.c();
                aVar3.a = aVar;
                aVar3.a(bVar);
                aVar3.a(this.j);
                if (aVar instanceof com.baidu.tieba.im.message.a.b) {
                    aVar3.a(((com.baidu.tieba.im.message.a.b) aVar).i());
                } else if (aVar instanceof com.baidu.tieba.im.message.a.f) {
                    aVar3.a(String.valueOf(com.baidu.tieba.im.chat.x.a));
                } else if (aVar instanceof com.baidu.tieba.im.message.a.e) {
                    aVar3.a(String.valueOf(com.baidu.tieba.im.chat.x.a));
                }
                synchronized (MsglistModel.class) {
                    this.h.put(str, aVar3);
                }
                aVar2 = aVar3;
            }
            aVar.i(System.currentTimeMillis());
            aVar2.a();
        }
    }

    public final void a(int i, com.baidu.tbadk.img.b<com.baidu.tieba.im.message.a.a> bVar) {
        com.baidu.tieba.im.message.a.a a2 = a(i);
        if (a2 == null || a2.y() == null || a2.y().getStatus() == null) {
            com.baidu.adp.lib.util.f.b(a, "reSendMsg", "data error");
            return;
        }
        short shortValue = a2.y().getStatus().shortValue();
        if (shortValue != 2) {
            com.baidu.adp.lib.util.f.b(a, "reSendMsg", "status error:" + ((int) shortValue));
            return;
        }
        a2.e(a2.w());
        a2.y().setStatus((short) 1);
        a2.h(System.currentTimeMillis() / 1000);
        switch (a2.t()) {
            case 1:
                com.baidu.tieba.im.chat.x.b().a(a2);
                break;
            case 2:
                a(a2, (String) null, bVar);
                break;
            case 3:
                c(a2);
                break;
            case 4:
                com.baidu.tieba.im.chat.x.b().a(a2);
                break;
        }
        this.mLoadDataMode = 6;
        this.mLoadDataCallBack.a(this.b);
        List<com.baidu.tieba.im.message.a.a> chatMessages = this.b.getChatMessages();
        int size = chatMessages.size();
        if (i < 0 || i >= size) {
            return;
        }
        chatMessages.remove(i);
        chatMessages.add(i, a2);
        this.b.setIsNewAdd(false);
        this.b.setNewAddNum(0);
    }

    public final com.baidu.tieba.im.message.a.a a(int i) {
        if (this.b == null || this.b.getChatMessages() == null || i < 0 || i >= this.b.getChatMessages().size()) {
            return null;
        }
        return this.b.getChatMessages().get(i);
    }

    public final void b(int i) {
        int size = this.b.getChatMessages().size();
        if (i >= 0 && i < size) {
            a(this.b.getChatMessages().get(i));
            this.b.getChatMessages().remove(i);
        }
        this.mLoadDataMode = 7;
        this.mLoadDataCallBack.a(null);
    }

    public final void c(int i) {
        ImMessageCenterPojo a2;
        int size = this.b.getChatMessages().size();
        if (i >= 0 && i < size) {
            com.baidu.tieba.im.message.a.a aVar = this.b.getChatMessages().get(i);
            com.baidu.tieba.im.message.a.a aVar2 = i + (-1) >= 0 ? this.b.getChatMessages().get(i - 1) : null;
            b(aVar);
            this.b.getChatMessages().remove(i);
            if (i == size - 1 && (a2 = a((com.baidu.tieba.im.db.e) null)) != null) {
                if (aVar2 != null) {
                    a2.setLast_content_time(aVar2.A() * 1000);
                    a2.setLast_content(com.baidu.tieba.im.f.q.h(aVar2));
                    a2.setLast_user_name(aVar2.r().getUserName());
                    a2.setLast_rid(aVar2.u());
                } else {
                    a2.setLast_content(" ");
                    a2.setLast_user_name(" ");
                }
            }
        }
        this.mLoadDataMode = 7;
        this.mLoadDataCallBack.a(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        if (customResponsedMessage != null && (customResponsedMessage instanceof LoadHistoryResponsedMessage)) {
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = (LoadHistoryResponsedMessage) customResponsedMessage;
            if (loadHistoryResponsedMessage.a() != null) {
                List<com.baidu.tieba.im.message.a.a> list = loadHistoryResponsedMessage.a().b;
                boolean z2 = loadHistoryResponsedMessage.a().c;
                int a2 = a(this.b.getChatMessages(), list);
                if (a2 > 0) {
                    this.b.setIsNewAdd(true);
                    this.b.setNewAddNum(a2);
                } else {
                    this.b.setIsNewAdd(false);
                    this.b.setNewAddNum(0);
                }
                List<com.baidu.tieba.im.message.a.a> chatMessages = this.b.getChatMessages();
                if (chatMessages != null && chatMessages.size() != 0) {
                    com.baidu.adp.lib.util.f.e("*****start updateMsgStatusTimeOut");
                    for (com.baidu.tieba.im.message.a.a aVar : chatMessages) {
                        if (aVar != null && aVar.y() != null && aVar.y().getStatus().shortValue() == 1) {
                            if ((System.currentTimeMillis() / 1000) - aVar.A() > 1800) {
                                aVar.y().setStatus((short) 2);
                                com.baidu.adp.lib.util.f.e("*****create time out");
                            } else {
                                Iterator<? extends com.baidu.adp.framework.message.d> it = com.baidu.adp.framework.c.a().a(aVar.e(), this.c.getUniqueId()).iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        z = false;
                                        break;
                                    }
                                    com.baidu.adp.framework.message.d next = it.next();
                                    if ((next instanceof com.baidu.tieba.im.message.a.a) && ((com.baidu.tieba.im.message.a.a) next).k() == aVar.k()) {
                                        z = true;
                                        break;
                                    }
                                }
                                if (z) {
                                    com.baidu.adp.lib.util.f.e("***** find in queues");
                                } else {
                                    aVar.y().setStatus((short) 2);
                                    com.baidu.adp.lib.util.f.e("*****no find in queues");
                                }
                            }
                        }
                    }
                }
                if (z2) {
                    if (this.b.getIsNewAdd()) {
                        this.mLoadDataMode = 1;
                        this.mLoadDataCallBack.a(null);
                    }
                } else if (this.b.getIsNewAdd()) {
                    this.mLoadDataMode = 2;
                    this.mLoadDataCallBack.a(null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof LoadDraftResponsedMessage) {
            LoadDraftResponsedMessage loadDraftResponsedMessage = (LoadDraftResponsedMessage) customResponsedMessage;
            if (loadDraftResponsedMessage.a() != null) {
                String str = loadDraftResponsedMessage.a().a;
                this.mLoadDataMode = 8;
                this.mLoadDataCallBack.a(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(List<com.baidu.tieba.im.message.a.a> list) {
        int i;
        int i2;
        if (this.c.a() != null) {
            i2 = this.c.a().getFirstVisiblePosition();
            i = this.c.a().getLastVisiblePosition();
        } else {
            i = 0;
            i2 = -1;
        }
        List<com.baidu.tieba.im.message.a.a> chatMessages = this.b.getChatMessages();
        int size = chatMessages.size();
        if (i2 >= 0 && i < size) {
            loop0: for (com.baidu.tieba.im.message.a.a aVar : list) {
                if (aVar.t() == 4) {
                    dc.a = com.baidu.tbadk.core.util.b.b();
                }
                long x = aVar.x();
                String portrait = aVar.r().getPortrait();
                for (int i3 = i2; i3 <= i; i3++) {
                    com.baidu.tieba.im.message.a.a aVar2 = chatMessages.get(i3);
                    if (aVar2 == null) {
                        break loop0;
                    }
                    if (x == aVar2.x()) {
                        if (aVar2.r() == null) {
                            break loop0;
                        }
                        String portrait2 = aVar2.r().getPortrait();
                        if (portrait != null && !portrait.equals(portrait2)) {
                            aVar2.r().setPortrait(portrait);
                        }
                    }
                }
            }
        }
        List<com.baidu.tieba.im.message.a.a> chatMessages2 = this.b.getChatMessages();
        if (chatMessages2 != null && list != null) {
            int size2 = chatMessages2.size();
            int size3 = list.size();
            if (size3 != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i4 = size2 - 1; i4 >= 0 && i4 >= 0; i4--) {
                    com.baidu.tieba.im.message.a.a aVar3 = chatMessages2.get(i4);
                    if (aVar3 != null && aVar3.r() != null && !TextUtils.isEmpty(aVar3.r().getUserId()) && aVar3.r().getUserId().equals(TbadkApplication.E()) && aVar3.y() != null && (aVar3.y().getStatus().shortValue() != 3 || aVar3.t() == 4)) {
                        int i5 = size3 - 1;
                        while (true) {
                            if (i5 >= 0 && i5 >= 0) {
                                com.baidu.tieba.im.message.a.a aVar4 = list.get(i5);
                                if (aVar4 != null && aVar4.r() != null && !TextUtils.isEmpty(aVar4.r().getUserId()) && aVar4.r().getUserId().equals(TbadkApplication.E()) && aVar4.u() == aVar3.u()) {
                                    arrayList.add(aVar3);
                                    break;
                                }
                                i5--;
                            }
                        }
                    }
                }
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    chatMessages2.remove(arrayList.get(i6));
                }
                arrayList.clear();
            }
        }
        Collections.sort(list, new aw(this, (byte) 0));
        int a2 = a(this.b.getChatMessages(), list);
        if (a2 > 0) {
            this.b.setIsNewAdd(true);
            this.b.setNewAddNum(a2);
            this.mLoadDataMode = 3;
            this.mLoadDataCallBack.a(this.b);
            return;
        }
        this.b.setIsNewAdd(false);
        this.b.setNewAddNum(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(ResponseCommitMessage responseCommitMessage) {
        if (responseCommitMessage != null) {
            if (responseCommitMessage.h() == null || !(responseCommitMessage.h() instanceof com.baidu.tieba.im.message.a.a)) {
                TiebaStatic.a(responseCommitMessage.g(), 0, "chatResMessage.getOrginalMessage()==null", "return", null, 0, null);
                return;
            }
            com.baidu.tieba.im.message.a.a aVar = (com.baidu.tieba.im.message.a.a) responseCommitMessage.h();
            if (responseCommitMessage.e() != 0) {
                TiebaStatic.a(responseCommitMessage.g(), 0, "", "", String.valueOf(e(aVar)) + "rid" + aVar.u(), responseCommitMessage.e(), responseCommitMessage.f(), System.currentTimeMillis() - aVar.E());
                if (responseCommitMessage.e() > 0) {
                    this.c.showToast(responseCommitMessage.f());
                    if (aVar.u() != responseCommitMessage.i()) {
                        responseCommitMessage.c(aVar.u());
                        TiebaStatic.a(responseCommitMessage.g(), 0, "orginalRecordId != serverRecordId", "", null, responseCommitMessage.e(), responseCommitMessage.f());
                    }
                }
                d(aVar);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - aVar.E();
            long i = responseCommitMessage.i();
            long d = responseCommitMessage.d();
            TiebaStatic.a(responseCommitMessage.g(), 0, "", "", "rid = " + i + "msgId = " + d + e(aVar), responseCommitMessage.e(), responseCommitMessage.f(), currentTimeMillis);
            if (aVar.u() != responseCommitMessage.i()) {
                responseCommitMessage.c(aVar.u());
                TiebaStatic.a(responseCommitMessage.g(), 0, "orginalRecordId != serverRecordId", "", null, responseCommitMessage.e(), responseCommitMessage.f());
            }
            b(responseCommitMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i() {
        if (this.b != null && this.b.getChatMessages() != null && this.b.getChatMessages().size() != 0) {
            this.b.getChatMessages().clear();
            this.mLoadDataMode = 12;
            this.mLoadDataCallBack.a(null);
        }
    }

    private static int a(List<com.baidu.tieba.im.message.a.a> list, List<com.baidu.tieba.im.message.a.a> list2) {
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
            long u = list.get(i2).u();
            com.baidu.tieba.im.message.a.a aVar = list2.get(i);
            long u2 = aVar.u();
            if (u > u2) {
                i2--;
            } else if (u < u2) {
                list.add(i2 + 1, aVar);
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

    private void b(ResponseCommitMessage responseCommitMessage) {
        if (responseCommitMessage == null) {
            com.baidu.adp.lib.util.f.b("SHANG sendMsgSuc msg == null");
            return;
        }
        com.baidu.adp.lib.util.f.e("SHANG sendMsgSuc msgId " + responseCommitMessage.d() + " rid " + responseCommitMessage.i());
        List<com.baidu.tieba.im.message.a.a> chatMessages = this.b.getChatMessages();
        long i = responseCommitMessage.i();
        long d = responseCommitMessage.d();
        this.b.setNewAddNum(0);
        this.b.setIsNewAdd(false);
        int size = chatMessages.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            } else if (i != chatMessages.get(size).u()) {
                size--;
            } else {
                com.baidu.tieba.im.message.a.a aVar = chatMessages.get(size);
                if (aVar.y() == null) {
                    MsgLocalData msgLocalData = new MsgLocalData();
                    msgLocalData.setStatus((short) 1);
                    msgLocalData.setErrno(0L);
                    msgLocalData.setRetry(0L);
                    msgLocalData.setUpload_offset(null);
                    aVar.a(msgLocalData);
                }
                aVar.f(d);
                aVar.y().setStatus((short) 3);
            }
        }
        this.mLoadDataMode = 5;
        this.mLoadDataCallBack.a(this.b);
        if (this.k != null) {
            com.baidu.adp.lib.util.f.e("simon", "send message", "send text");
            this.k.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.im.message.a.a aVar) {
        if (aVar == null) {
            com.baidu.adp.lib.util.f.b("sendMsgFail chatmessage == null");
            return;
        }
        aVar.a(false);
        if (aVar.y() == null) {
            MsgLocalData msgLocalData = new MsgLocalData();
            msgLocalData.setStatus((short) 1);
            msgLocalData.setErrno(0L);
            msgLocalData.setRetry(0L);
            msgLocalData.setUpload_offset(null);
            aVar.a(msgLocalData);
        }
        com.baidu.adp.lib.util.f.e("sendMsgFail msgId " + aVar.w() + "recordId " + aVar.u());
        aVar.y().setStatus((short) 2);
        List<com.baidu.tieba.im.message.a.a> chatMessages = this.b.getChatMessages();
        if (chatMessages != null && chatMessages.size() != 0) {
            long u = aVar.u();
            int size = chatMessages.size() - 1;
            while (size >= 0 && chatMessages.get(size).w() != u) {
                size--;
            }
            if (size >= 0) {
                chatMessages.remove(size);
                chatMessages.add(size, aVar);
                this.b.setNewAddNum(0);
                this.b.setIsNewAdd(false);
                this.mLoadDataMode = 5;
                this.mLoadDataCallBack.a(this.b);
            }
        }
    }

    private static String e(com.baidu.tieba.im.message.a.a aVar) {
        if (aVar == null) {
            return "";
        }
        int t = aVar.t();
        String string = TbadkApplication.j().b().getString(com.baidu.tieba.im.j.websocket_type);
        switch (t) {
            case 1:
                return String.valueOf(string) + TbadkApplication.j().b().getString(com.baidu.tieba.im.j.log_msg_text);
            case 2:
                return String.valueOf(string) + TbadkApplication.j().b().getString(com.baidu.tieba.im.j.log_msg_pic);
            case 3:
                return String.valueOf(string) + TbadkApplication.j().b().getString(com.baidu.tieba.im.j.log_msg_voice);
            default:
                return "";
        }
    }

    public final void a(ax axVar) {
        this.k = axVar;
    }
}
