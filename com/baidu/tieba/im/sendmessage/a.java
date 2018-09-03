package com.baidu.tieba.im.sendmessage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.im.data.PicMessageData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.sendmessage.VoiceSendModel;
import com.baidu.tieba.im.util.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class a {
    private static volatile a eBl = null;
    public static volatile Long eBm = 0L;
    public static volatile long eBn = 0;
    private a.c eBq;
    private VoiceSendModel eBr;
    private WeakReference<a.InterfaceC0114a<ChatMessage>> eBs;
    private d mSendCallback;
    private final LinkedList<ChatMessage> eBo = new LinkedList<>();
    private final HashMap<String, com.baidu.tbadk.img.a<ChatMessage>> eBp = new HashMap<>();
    VoiceSendModel.b eBt = new VoiceSendModel.b() { // from class: com.baidu.tieba.im.sendmessage.a.8
        @Override // com.baidu.tieba.im.sendmessage.VoiceSendModel.b
        public void a(String str, ChatMessage chatMessage) {
            try {
                a.aNn().p(chatMessage);
                if (chatMessage != null) {
                    if (str != null && str.length() > 0) {
                        VoiceMsgData z = e.z(chatMessage);
                        if (z != null) {
                            z.setVoice_md5(str);
                            chatMessage.setContent("[" + OrmObject.jsonStrWithObject(z) + "]");
                        }
                        com.baidu.tbadk.core.d.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", 0, null, new Object[0]);
                        a.aNn().r(chatMessage);
                        if (a.this.mSendCallback != null) {
                            a.this.mSendCallback.oC(2);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.d.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", -1, "voice http fail", new Object[0]);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001215, chatMessage));
                    if (chatMessage instanceof CommonGroupChatMessage) {
                        final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                        v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.8.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.u
                            public Boolean doInBackground() {
                                return Boolean.valueOf(com.baidu.tieba.im.db.c.aJw().c(commonGroupChatMessage.getGroupId(), String.valueOf(commonGroupChatMessage.getRecordId()), String.valueOf(commonGroupChatMessage.getMsgId()), 2));
                            }
                        }, new g<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.8.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.g
                            public void onReturnDataInUI(Boolean bool) {
                                a.m(commonGroupChatMessage);
                            }
                        });
                    } else if (chatMessage instanceof PersonalChatMessage) {
                        final PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                        v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.8.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.u
                            public Boolean doInBackground() {
                                return Boolean.valueOf(m.aJO().a(personalChatMessage.getUserId(), personalChatMessage.getToUserId(), String.valueOf(personalChatMessage.getRecordId()), String.valueOf(personalChatMessage.getMsgId()), 2));
                            }
                        }, new g<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.8.4
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.g
                            public void onReturnDataInUI(Boolean bool) {
                                a.m(personalChatMessage);
                            }
                        });
                    } else if (chatMessage instanceof OfficialChatMessage) {
                        final OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                        v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.8.5
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.u
                            public Boolean doInBackground() {
                                return Boolean.valueOf(l.aJM().a(officialChatMessage.getUserId(), officialChatMessage.getToUserId(), String.valueOf(officialChatMessage.getRecordId()), String.valueOf(officialChatMessage.getMsgId()), 2));
                            }
                        }, new g<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.8.6
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.g
                            public void onReturnDataInUI(Boolean bool) {
                                a.m(officialChatMessage);
                            }
                        });
                    }
                }
            } catch (Exception e) {
            }
        }
    };

    private a() {
        init();
    }

    public void setSendCallback(d dVar) {
        this.mSendCallback = dVar;
    }

    private void init() {
        this.eBr = new VoiceSendModel(null);
        this.eBr.a(this.eBt);
        this.eBq = new a.c() { // from class: com.baidu.tieba.im.sendmessage.a.1
            @Override // com.baidu.tbadk.img.a.c
            public synchronized void a(String str, ImageUploadResult imageUploadResult) {
                com.baidu.tbadk.img.a aVar;
                ChatMessage chatMessage;
                int i;
                String str2;
                int i2 = 0;
                synchronized (this) {
                    synchronized (a.class) {
                        aVar = (com.baidu.tbadk.img.a) a.this.eBp.remove(str);
                    }
                    if (aVar != null && (chatMessage = (ChatMessage) aVar.IW()) != null) {
                        if (imageUploadResult == null || imageUploadResult.error_code != 0 || imageUploadResult.picInfo == null) {
                            if (imageUploadResult != null) {
                                com.baidu.tbadk.core.d.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", imageUploadResult.error_code, imageUploadResult.error_msg, new Object[0]);
                            } else {
                                com.baidu.tbadk.core.d.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", -1, "result is null", new Object[0]);
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001215, chatMessage));
                            if (chatMessage instanceof CommonGroupChatMessage) {
                                final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                                v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.1.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.u
                                    public Boolean doInBackground() {
                                        return Boolean.valueOf(com.baidu.tieba.im.db.c.aJw().c(commonGroupChatMessage.getGroupId(), String.valueOf(commonGroupChatMessage.getRecordId()), String.valueOf(commonGroupChatMessage.getMsgId()), 2));
                                    }
                                }, new g<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.1.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.g
                                    public void onReturnDataInUI(Boolean bool) {
                                        a.m(commonGroupChatMessage);
                                    }
                                });
                            } else if (chatMessage instanceof PersonalChatMessage) {
                                final PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                                v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.1.3
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.u
                                    public Boolean doInBackground() {
                                        return Boolean.valueOf(m.aJO().a(personalChatMessage.getUserId(), personalChatMessage.getToUserId(), String.valueOf(personalChatMessage.getRecordId()), String.valueOf(personalChatMessage.getMsgId()), 2));
                                    }
                                }, new g<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.1.4
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.g
                                    public void onReturnDataInUI(Boolean bool) {
                                        a.m(personalChatMessage);
                                    }
                                });
                            } else if (chatMessage instanceof OfficialChatMessage) {
                                final OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                                v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.1.5
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.u
                                    public Boolean doInBackground() {
                                        return Boolean.valueOf(l.aJM().a(officialChatMessage.getUserId(), officialChatMessage.getToUserId(), String.valueOf(officialChatMessage.getRecordId()), String.valueOf(officialChatMessage.getMsgId()), 2));
                                    }
                                }, new g<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.1.6
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.g
                                    public void onReturnDataInUI(Boolean bool) {
                                        a.m(officialChatMessage);
                                    }
                                });
                            }
                        } else {
                            com.baidu.tbadk.core.d.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", 0, null, new Object[0]);
                            String str3 = imageUploadResult.picInfo.bigPic == null ? null : imageUploadResult.picInfo.bigPic.picUrl;
                            if (imageUploadResult.picInfo.smallPic != null) {
                                str2 = imageUploadResult.picInfo.smallPic.picUrl;
                                i2 = imageUploadResult.picInfo.smallPic.width;
                                i = imageUploadResult.picInfo.smallPic.height;
                                a.this.br(str, str2);
                            } else {
                                i = 0;
                                str2 = null;
                            }
                            chatMessage.setContent(a.c(str3, str2, i2, i));
                            a.aNn().r(chatMessage);
                            if (a.this.mSendCallback != null) {
                                a.this.mSendCallback.oC(1);
                            }
                        }
                    }
                }
            }
        };
    }

    public static String c(String str, String str2, int i, int i2) {
        PicMessageData picMessageData = new PicMessageData();
        picMessageData.src = str2;
        picMessageData.big_src = str;
        picMessageData.type = "3";
        if (i > 0) {
            picMessageData.bsize = i + "," + i2;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(OrmObject.jsonWithObject(picMessageData));
        return jSONArray.toString();
    }

    public static void m(ChatMessage chatMessage) {
        String groupId = chatMessage.getGroupId();
        if (chatMessage.getCustomGroupType() == 2 || chatMessage.getCustomGroupType() == 4) {
            groupId = String.valueOf(chatMessage.getToUserId());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(groupId, chatMessage.getCustomGroupType(), chatMessage, 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(final String str, String str2) {
        com.baidu.adp.widget.ImageView.a he = com.baidu.tbadk.imageManager.c.IQ().he(str);
        final String str3 = str2 + 10;
        if (he != null && he.nc()) {
            e(str3, he);
        } else {
            new BdAsyncTask<Void, Void, Bitmap>() { // from class: com.baidu.tieba.im.sendmessage.a.9
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Bitmap doInBackground(Void... voidArr) {
                    return BitmapFactory.decodeFile(str);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(Bitmap bitmap) {
                    a.this.e(str3, new com.baidu.adp.widget.ImageView.a(bitmap, false));
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, com.baidu.adp.widget.ImageView.a aVar) {
        com.baidu.tbadk.imageManager.c.IQ().c(str, aVar);
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.eM(str), DiskFileOperate.Action.WRITE);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.u(true);
        cVar.setData(aVar.ne());
        cVar.y(false);
        com.baidu.adp.lib.Disk.d.ge().c(cVar);
    }

    public void c(ChatMessage chatMessage, String str) {
        com.baidu.tbadk.img.a<ChatMessage> aVar = this.eBp.get(str);
        if (aVar == null) {
            com.baidu.tbadk.img.a<ChatMessage> aVar2 = new com.baidu.tbadk.img.a<>(str, "IM");
            aVar2.IX();
            aVar2.D(chatMessage);
            if (this.eBs != null && this.eBs.get() != null) {
                aVar2.a(this.eBs.get());
            }
            aVar2.a(this.eBq);
            if (chatMessage instanceof CommonGroupChatMessage) {
                aVar2.setGroupId(((CommonGroupChatMessage) chatMessage).getGroupId());
            } else if (chatMessage instanceof PersonalChatMessage) {
                aVar2.setGroupId(String.valueOf(eBm));
            } else if (chatMessage instanceof OfficialChatMessage) {
                aVar2.setGroupId(String.valueOf(eBn));
            }
            synchronized (a.class) {
                this.eBp.put(str, aVar2);
            }
            aVar = aVar2;
        }
        chatMessage.setLogTime(System.currentTimeMillis());
        m(chatMessage);
        aVar.bN(false);
    }

    public void a(VoiceMsgData voiceMsgData, ChatMessage chatMessage) {
        o(chatMessage);
        if (chatMessage != null) {
            chatMessage.getClientLogID();
            chatMessage.getCmd();
        }
        this.eBr.b(voiceMsgData.getVoice_md5(), chatMessage);
    }

    public boolean n(ChatMessage chatMessage) {
        if (this.eBp == null || chatMessage == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.tbadk.img.a<ChatMessage>> entry : this.eBp.entrySet()) {
            com.baidu.tbadk.img.a<ChatMessage> value = entry.getValue();
            if (value != null && value.IW() != null) {
                ChatMessage IW = value.IW();
                if (chatMessage.getRecordId() != IW.getRecordId()) {
                    continue;
                } else if (chatMessage.getCustomGroupType() == 2 || chatMessage.getCustomGroupType() == 4) {
                    if (chatMessage.getToUserId() == IW.getToUserId()) {
                        if (this.eBs != null && this.eBs.get() != null) {
                            value.a(this.eBs.get());
                        }
                        return true;
                    }
                } else if (chatMessage.getGroupId() != null && IW.getGroupId() != null && chatMessage.getGroupId().equals(IW.getGroupId())) {
                    if (this.eBs != null && this.eBs.get() != null) {
                        value.a(this.eBs.get());
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void o(ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.eBo.add(chatMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(ChatMessage chatMessage) {
        int a = a(chatMessage, this.eBo);
        if (a >= 0) {
            this.eBo.remove(a);
        }
    }

    public boolean q(ChatMessage chatMessage) {
        return a(chatMessage, this.eBo) != -1;
    }

    private int a(ChatMessage chatMessage, LinkedList<ChatMessage> linkedList) {
        if (chatMessage == null || linkedList == null || linkedList.size() == 0) {
            return -1;
        }
        int size = linkedList.size();
        for (int i = 0; i < size; i++) {
            ChatMessage chatMessage2 = linkedList.get(i);
            if (chatMessage2 != null && chatMessage.getRecordId() == chatMessage2.getRecordId()) {
                if (chatMessage.getCustomGroupType() == 2 || chatMessage.getCustomGroupType() == 4) {
                    if (chatMessage.getToUserId() == chatMessage2.getToUserId()) {
                        return i;
                    }
                } else if (chatMessage.getGroupId() != null && chatMessage2.getGroupId() != null && chatMessage.getGroupId().equals(chatMessage2.getGroupId())) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static a aNn() {
        if (eBl == null) {
            synchronized (a.class) {
                if (eBl == null) {
                    eBl = new a();
                }
            }
        }
        return eBl;
    }

    public static void cm(long j) {
        eBm = Long.valueOf(j);
    }

    public static void cn(long j) {
        eBn = j;
    }

    public void b(final String str, final c cVar) {
        v.b(new u<LinkedHashMap<String, String>>() { // from class: com.baidu.tieba.im.sendmessage.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: aNo */
            public LinkedHashMap<String, String> doInBackground() {
                return com.baidu.tieba.im.db.c.aJw().a(str, 2, null, 1000);
            }
        }, new g<LinkedHashMap<String, String>>() { // from class: com.baidu.tieba.im.sendmessage.a.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: a */
            public void onReturnDataInUI(LinkedHashMap<String, String> linkedHashMap) {
                LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                if (linkedHashMap != null && linkedHashMap.size() > 0) {
                    ArrayList arrayList = new ArrayList(linkedHashMap.size());
                    for (String str2 : linkedHashMap.keySet()) {
                        arrayList.add(str2);
                    }
                    Collections.reverse(arrayList);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str3 = (String) it.next();
                        String str4 = linkedHashMap.get(str3);
                        String F = e.F(str4, true);
                        if (F != null) {
                            linkedHashMap2.put(str3, F);
                        }
                        String F2 = e.F(str4, false);
                        if (!TextUtils.isEmpty(F2) && !TextUtils.isEmpty(F)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = F2;
                            imageUrlData.urlType = 10;
                            hashMap.put(F, imageUrlData);
                        }
                    }
                }
                cVar.a(linkedHashMap2, hashMap);
            }
        });
    }

    public void c(final String str, final c cVar) {
        v.b(new u<LinkedHashMap<String, String>>() { // from class: com.baidu.tieba.im.sendmessage.a.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: aNo */
            public LinkedHashMap<String, String> doInBackground() {
                return m.aJO().a(str, 2, null, 1000);
            }
        }, new g<LinkedHashMap<String, String>>() { // from class: com.baidu.tieba.im.sendmessage.a.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: a */
            public void onReturnDataInUI(LinkedHashMap<String, String> linkedHashMap) {
                LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                if (linkedHashMap != null && linkedHashMap.size() > 0) {
                    ArrayList arrayList = new ArrayList(linkedHashMap.size());
                    for (String str2 : linkedHashMap.keySet()) {
                        arrayList.add(str2);
                    }
                    Collections.reverse(arrayList);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str3 = (String) it.next();
                        String str4 = linkedHashMap.get(str3);
                        String F = e.F(str4, true);
                        if (F != null) {
                            linkedHashMap2.put(str3, F);
                        }
                        String F2 = e.F(str4, false);
                        if (!TextUtils.isEmpty(F2) && !TextUtils.isEmpty(F)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = F2;
                            imageUrlData.urlType = 10;
                            hashMap.put(F, imageUrlData);
                        }
                    }
                }
                cVar.a(linkedHashMap2, hashMap);
            }
        });
    }

    public void d(final String str, final c cVar) {
        v.b(new u<LinkedHashMap<String, String>>() { // from class: com.baidu.tieba.im.sendmessage.a.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            /* renamed from: aNo */
            public LinkedHashMap<String, String> doInBackground() {
                return l.aJM().a(str, 2, null, 1000);
            }
        }, new g<LinkedHashMap<String, String>>() { // from class: com.baidu.tieba.im.sendmessage.a.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: a */
            public void onReturnDataInUI(LinkedHashMap<String, String> linkedHashMap) {
                LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
                HashMap<String, ImageUrlData> hashMap = new HashMap<>();
                if (linkedHashMap != null && linkedHashMap.size() > 0) {
                    ArrayList arrayList = new ArrayList(linkedHashMap.size());
                    for (String str2 : linkedHashMap.keySet()) {
                        arrayList.add(str2);
                    }
                    Collections.reverse(arrayList);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str3 = (String) it.next();
                        String str4 = linkedHashMap.get(str3);
                        String F = e.F(str4, true);
                        if (F != null) {
                            linkedHashMap2.put(str3, F);
                        }
                        String F2 = e.F(str4, false);
                        if (!TextUtils.isEmpty(F2) && !TextUtils.isEmpty(F)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = F2;
                            imageUrlData.urlType = 10;
                            hashMap.put(F, imageUrlData);
                        }
                    }
                }
                cVar.a(linkedHashMap2, hashMap);
            }
        });
    }

    public void r(final ChatMessage chatMessage) {
        if (chatMessage instanceof CommonGroupChatMessage) {
            final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
            final LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.u
                public Boolean doInBackground() {
                    return Boolean.valueOf(com.baidu.tieba.im.db.c.aJw().a(commonGroupChatMessage.getGroupId(), linkedList, false));
                }
            }, new g<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.g
                public void onReturnDataInUI(Boolean bool) {
                    commonGroupChatMessage.setLogTime(System.currentTimeMillis());
                    MessageManager.getInstance().sendMessage(commonGroupChatMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(commonGroupChatMessage.getGroupId(), chatMessage.getCustomGroupType(), chatMessage, 3)));
                }
            });
        } else if (chatMessage instanceof PersonalChatMessage) {
            final PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
            final LinkedList linkedList2 = new LinkedList();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(chatMessage);
            commonMsgPojo2.setRead_flag(0);
            linkedList2.add(commonMsgPojo2);
            v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.u
                public Boolean doInBackground() {
                    return Boolean.valueOf(m.aJO().a(e.s(personalChatMessage), linkedList2, false));
                }
            }, new g<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.g
                public void onReturnDataInUI(Boolean bool) {
                    personalChatMessage.setLogTime(System.currentTimeMillis());
                    MessageManager.getInstance().sendMessage(personalChatMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(personalChatMessage.getToUserId()), 2, chatMessage, 3)));
                }
            });
        } else if (chatMessage instanceof OfficialChatMessage) {
            final OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
            final LinkedList linkedList3 = new LinkedList();
            CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(chatMessage);
            commonMsgPojo3.setRead_flag(0);
            linkedList3.add(commonMsgPojo3);
            v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.6
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.u
                public Boolean doInBackground() {
                    return Boolean.valueOf(l.aJM().a(e.s(officialChatMessage), linkedList3, false));
                }
            }, new g<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.g
                public void onReturnDataInUI(Boolean bool) {
                    officialChatMessage.setLogTime(System.currentTimeMillis());
                    MessageManager.getInstance().sendMessage(officialChatMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(officialChatMessage.getToUserId()), 4, chatMessage, 3)));
                }
            });
        }
    }

    public void setImageUploadUIProgressCallback(a.InterfaceC0114a<ChatMessage> interfaceC0114a) {
        this.eBs = new WeakReference<>(interfaceC0114a);
    }
}
