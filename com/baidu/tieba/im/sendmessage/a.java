package com.baidu.tieba.im.sendmessage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.a;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.im.data.PicMessageData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.sendmessage.VoiceSendModel;
import com.baidu.tieba.im.util.e;
import com.xiaomi.mipush.sdk.Constants;
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
    private static volatile a kiA = null;
    public static volatile Long kiB = 0L;
    public static volatile long kiC = 0;
    private a.c kiF;
    private VoiceSendModel kiG;
    private WeakReference<a.InterfaceC0582a<ChatMessage>> kiH;
    private d mSendCallback;
    private final LinkedList<ChatMessage> kiD = new LinkedList<>();
    private final HashMap<String, com.baidu.tbadk.img.a<ChatMessage>> kiE = new HashMap<>();
    VoiceSendModel.b kiI = new VoiceSendModel.b() { // from class: com.baidu.tieba.im.sendmessage.a.8
        @Override // com.baidu.tieba.im.sendmessage.VoiceSendModel.b
        public void a(String str, ChatMessage chatMessage) {
            try {
                a.cSA().k(chatMessage);
                if (chatMessage != null) {
                    if (str != null && str.length() > 0) {
                        VoiceMsgData u = e.u(chatMessage);
                        if (u != null) {
                            u.setVoice_md5(str);
                            chatMessage.setContent("[" + OrmObject.jsonStrWithObject(u) + "]");
                        }
                        com.baidu.tbadk.core.d.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", 0, null, new Object[0]);
                        a.cSA().m(chatMessage);
                        if (a.this.mSendCallback != null) {
                            a.this.mSendCallback.Dh(2);
                            return;
                        }
                        return;
                    }
                    com.baidu.tbadk.core.d.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", -1, "voice http fail", new Object[0]);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPLOAD_FAIL, chatMessage));
                    if (chatMessage instanceof CommonGroupChatMessage) {
                        final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                        ae.b(new ad<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.8.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.ad
                            public Boolean doInBackground() {
                                return Boolean.valueOf(com.baidu.tieba.im.db.c.cOt().f(commonGroupChatMessage.getGroupId(), String.valueOf(commonGroupChatMessage.getRecordId()), String.valueOf(commonGroupChatMessage.getMsgId()), 2));
                            }
                        }, new m<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.8.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.m
                            public void onReturnDataInUI(Boolean bool) {
                                a.h(commonGroupChatMessage);
                            }
                        });
                    } else if (chatMessage instanceof PersonalChatMessage) {
                        final PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                        ae.b(new ad<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.8.3
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.ad
                            public Boolean doInBackground() {
                                return Boolean.valueOf(com.baidu.tieba.im.db.m.cON().a(personalChatMessage.getUserId(), personalChatMessage.getToUserId(), String.valueOf(personalChatMessage.getRecordId()), String.valueOf(personalChatMessage.getMsgId()), 2));
                            }
                        }, new m<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.8.4
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.m
                            public void onReturnDataInUI(Boolean bool) {
                                a.h(personalChatMessage);
                            }
                        });
                    } else if (chatMessage instanceof OfficialChatMessage) {
                        final OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                        ae.b(new ad<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.8.5
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.baidu.tbadk.util.ad
                            public Boolean doInBackground() {
                                return Boolean.valueOf(l.cOK().a(officialChatMessage.getUserId(), officialChatMessage.getToUserId(), String.valueOf(officialChatMessage.getRecordId()), String.valueOf(officialChatMessage.getMsgId()), 2));
                            }
                        }, new m<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.8.6
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.tbadk.util.m
                            public void onReturnDataInUI(Boolean bool) {
                                a.h(officialChatMessage);
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
        this.kiG = new VoiceSendModel(null);
        this.kiG.a(this.kiI);
        this.kiF = new a.c() { // from class: com.baidu.tieba.im.sendmessage.a.1
            @Override // com.baidu.tbadk.img.a.c
            public synchronized void a(String str, ImageUploadResult imageUploadResult) {
                com.baidu.tbadk.img.a aVar;
                ChatMessage chatMessage;
                int i;
                String str2;
                int i2 = 0;
                synchronized (this) {
                    synchronized (a.class) {
                        aVar = (com.baidu.tbadk.img.a) a.this.kiE.remove(str);
                    }
                    if (aVar != null && (chatMessage = (ChatMessage) aVar.getProgessObject()) != null) {
                        if (imageUploadResult == null || imageUploadResult.error_code != 0 || imageUploadResult.picInfo == null) {
                            if (imageUploadResult != null) {
                                com.baidu.tbadk.core.d.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", imageUploadResult.error_code, imageUploadResult.error_msg, new Object[0]);
                            } else {
                                com.baidu.tbadk.core.d.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", -1, "result is null", new Object[0]);
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPLOAD_FAIL, chatMessage));
                            if (chatMessage instanceof CommonGroupChatMessage) {
                                final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                                ae.b(new ad<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.1.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.ad
                                    public Boolean doInBackground() {
                                        return Boolean.valueOf(com.baidu.tieba.im.db.c.cOt().f(commonGroupChatMessage.getGroupId(), String.valueOf(commonGroupChatMessage.getRecordId()), String.valueOf(commonGroupChatMessage.getMsgId()), 2));
                                    }
                                }, new m<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.1.2
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.m
                                    public void onReturnDataInUI(Boolean bool) {
                                        a.h(commonGroupChatMessage);
                                    }
                                });
                            } else if (chatMessage instanceof PersonalChatMessage) {
                                final PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                                ae.b(new ad<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.1.3
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.ad
                                    public Boolean doInBackground() {
                                        return Boolean.valueOf(com.baidu.tieba.im.db.m.cON().a(personalChatMessage.getUserId(), personalChatMessage.getToUserId(), String.valueOf(personalChatMessage.getRecordId()), String.valueOf(personalChatMessage.getMsgId()), 2));
                                    }
                                }, new m<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.1.4
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.m
                                    public void onReturnDataInUI(Boolean bool) {
                                        a.h(personalChatMessage);
                                    }
                                });
                            } else if (chatMessage instanceof OfficialChatMessage) {
                                final OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                                ae.b(new ad<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.1.5
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.baidu.tbadk.util.ad
                                    public Boolean doInBackground() {
                                        return Boolean.valueOf(l.cOK().a(officialChatMessage.getUserId(), officialChatMessage.getToUserId(), String.valueOf(officialChatMessage.getRecordId()), String.valueOf(officialChatMessage.getMsgId()), 2));
                                    }
                                }, new m<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.1.6
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.tbadk.util.m
                                    public void onReturnDataInUI(Boolean bool) {
                                        a.h(officialChatMessage);
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
                                a.this.fr(str, str2);
                            } else {
                                i = 0;
                                str2 = null;
                            }
                            chatMessage.setContent(a.b(str3, str2, i2, i));
                            a.cSA().m(chatMessage);
                            if (a.this.mSendCallback != null) {
                                a.this.mSendCallback.Dh(1);
                            }
                        }
                    }
                }
            }
        };
    }

    public static String b(String str, String str2, int i, int i2) {
        PicMessageData picMessageData = new PicMessageData();
        picMessageData.src = str2;
        picMessageData.big_src = str;
        picMessageData.type = "3";
        if (i > 0) {
            picMessageData.bsize = i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(OrmObject.jsonWithObject(picMessageData));
        return jSONArray.toString();
    }

    public static void h(ChatMessage chatMessage) {
        String groupId = chatMessage.getGroupId();
        if (chatMessage.getCustomGroupType() == 2 || chatMessage.getCustomGroupType() == 4) {
            groupId = String.valueOf(chatMessage.getToUserId());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(groupId, chatMessage.getCustomGroupType(), chatMessage, 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fr(final String str, String str2) {
        com.baidu.adp.widget.ImageView.a DN = com.baidu.tbadk.imageManager.c.byE().DN(str);
        final String str3 = str2 + 10;
        if (DN != null && DN.isValidNow()) {
            e(str3, DN);
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
        com.baidu.tbadk.imageManager.c.byE().c(str, aVar);
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, av.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setData(aVar.getImageByte());
        cVar.setGif(false);
        com.baidu.adp.lib.Disk.d.lL().c(cVar);
    }

    public void c(ChatMessage chatMessage, String str) {
        com.baidu.tbadk.img.a<ChatMessage> aVar = this.kiE.get(str);
        if (aVar == null) {
            com.baidu.tbadk.img.a<ChatMessage> aVar2 = new com.baidu.tbadk.img.a<>(str, "IM");
            aVar2.setServerResizeForIMImage();
            aVar2.setProgessObject(chatMessage);
            if (this.kiH != null && this.kiH.get() != null) {
                aVar2.a(this.kiH.get());
            }
            aVar2.a(this.kiF);
            if (chatMessage instanceof CommonGroupChatMessage) {
                aVar2.setGroupId(((CommonGroupChatMessage) chatMessage).getGroupId());
            } else if (chatMessage instanceof PersonalChatMessage) {
                aVar2.setGroupId(String.valueOf(kiB));
            } else if (chatMessage instanceof OfficialChatMessage) {
                aVar2.setGroupId(String.valueOf(kiC));
            }
            synchronized (a.class) {
                this.kiE.put(str, aVar2);
            }
            aVar = aVar2;
        }
        chatMessage.setLogTime(System.currentTimeMillis());
        h(chatMessage);
        aVar.loadPic(false);
    }

    public void a(VoiceMsgData voiceMsgData, ChatMessage chatMessage) {
        j(chatMessage);
        if (chatMessage != null) {
            chatMessage.getClientLogID();
            chatMessage.getCmd();
        }
        this.kiG.b(voiceMsgData.getVoice_md5(), chatMessage);
    }

    public boolean i(ChatMessage chatMessage) {
        if (this.kiE == null || chatMessage == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.tbadk.img.a<ChatMessage>> entry : this.kiE.entrySet()) {
            com.baidu.tbadk.img.a<ChatMessage> value = entry.getValue();
            if (value != null && value.getProgessObject() != null) {
                ChatMessage progessObject = value.getProgessObject();
                if (chatMessage.getRecordId() != progessObject.getRecordId()) {
                    continue;
                } else if (chatMessage.getCustomGroupType() == 2 || chatMessage.getCustomGroupType() == 4) {
                    if (chatMessage.getToUserId() == progessObject.getToUserId()) {
                        if (this.kiH != null && this.kiH.get() != null) {
                            value.a(this.kiH.get());
                        }
                        return true;
                    }
                } else if (chatMessage.getGroupId() != null && progessObject.getGroupId() != null && chatMessage.getGroupId().equals(progessObject.getGroupId())) {
                    if (this.kiH != null && this.kiH.get() != null) {
                        value.a(this.kiH.get());
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void j(ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.kiD.add(chatMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(ChatMessage chatMessage) {
        int a2 = a(chatMessage, this.kiD);
        if (a2 >= 0) {
            this.kiD.remove(a2);
        }
    }

    public boolean l(ChatMessage chatMessage) {
        return a(chatMessage, this.kiD) != -1;
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

    public static a cSA() {
        if (kiA == null) {
            synchronized (a.class) {
                if (kiA == null) {
                    kiA = new a();
                }
            }
        }
        return kiA;
    }

    public static void fV(long j) {
        kiB = Long.valueOf(j);
    }

    public static void fW(long j) {
        kiC = j;
    }

    public void b(final String str, final c cVar) {
        ae.b(new ad<LinkedHashMap<String, String>>() { // from class: com.baidu.tieba.im.sendmessage.a.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: cSB */
            public LinkedHashMap<String, String> doInBackground() {
                return com.baidu.tieba.im.db.c.cOt().a(str, 2, null, 1000);
            }
        }, new m<LinkedHashMap<String, String>>() { // from class: com.baidu.tieba.im.sendmessage.a.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: b */
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
                        String aR = e.aR(str4, true);
                        if (aR != null) {
                            linkedHashMap2.put(str3, aR);
                        }
                        String aR2 = e.aR(str4, false);
                        if (!TextUtils.isEmpty(aR2) && !TextUtils.isEmpty(aR)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = aR2;
                            imageUrlData.urlType = 10;
                            hashMap.put(aR, imageUrlData);
                        }
                    }
                }
                cVar.a(linkedHashMap2, hashMap);
            }
        });
    }

    public void c(final String str, final c cVar) {
        ae.b(new ad<LinkedHashMap<String, String>>() { // from class: com.baidu.tieba.im.sendmessage.a.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: cSB */
            public LinkedHashMap<String, String> doInBackground() {
                return com.baidu.tieba.im.db.m.cON().a(str, 2, null, 1000);
            }
        }, new m<LinkedHashMap<String, String>>() { // from class: com.baidu.tieba.im.sendmessage.a.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: b */
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
                        String aR = e.aR(str4, true);
                        if (aR != null) {
                            linkedHashMap2.put(str3, aR);
                        }
                        String aR2 = e.aR(str4, false);
                        if (!TextUtils.isEmpty(aR2) && !TextUtils.isEmpty(aR)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = aR2;
                            imageUrlData.urlType = 10;
                            hashMap.put(aR, imageUrlData);
                        }
                    }
                }
                cVar.a(linkedHashMap2, hashMap);
            }
        });
    }

    public void d(final String str, final c cVar) {
        ae.b(new ad<LinkedHashMap<String, String>>() { // from class: com.baidu.tieba.im.sendmessage.a.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: cSB */
            public LinkedHashMap<String, String> doInBackground() {
                return l.cOK().a(str, 2, null, 1000);
            }
        }, new m<LinkedHashMap<String, String>>() { // from class: com.baidu.tieba.im.sendmessage.a.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: b */
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
                        String aR = e.aR(str4, true);
                        if (aR != null) {
                            linkedHashMap2.put(str3, aR);
                        }
                        String aR2 = e.aR(str4, false);
                        if (!TextUtils.isEmpty(aR2) && !TextUtils.isEmpty(aR)) {
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = aR2;
                            imageUrlData.urlType = 10;
                            hashMap.put(aR, imageUrlData);
                        }
                    }
                }
                cVar.a(linkedHashMap2, hashMap);
            }
        });
    }

    public void m(final ChatMessage chatMessage) {
        if (chatMessage instanceof CommonGroupChatMessage) {
            final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
            final LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            ae.b(new ad<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ad
                public Boolean doInBackground() {
                    return Boolean.valueOf(com.baidu.tieba.im.db.c.cOt().b(commonGroupChatMessage.getGroupId(), linkedList, false));
                }
            }, new m<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
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
            ae.b(new ad<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ad
                public Boolean doInBackground() {
                    return Boolean.valueOf(com.baidu.tieba.im.db.m.cON().a(e.n(personalChatMessage), linkedList2, false));
                }
            }, new m<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
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
            ae.b(new ad<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.6
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ad
                public Boolean doInBackground() {
                    return Boolean.valueOf(l.cOK().a(e.n(officialChatMessage), linkedList3, false));
                }
            }, new m<Boolean>() { // from class: com.baidu.tieba.im.sendmessage.a.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                public void onReturnDataInUI(Boolean bool) {
                    officialChatMessage.setLogTime(System.currentTimeMillis());
                    MessageManager.getInstance().sendMessage(officialChatMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(officialChatMessage.getToUserId()), 4, chatMessage, 3)));
                }
            });
        }
    }

    public void setImageUploadUIProgressCallback(a.InterfaceC0582a<ChatMessage> interfaceC0582a) {
        this.kiH = new WeakReference<>(interfaceC0582a);
    }
}
