package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.model.MsglistModel;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class w {
    private com.baidu.tbadk.img.d f;
    private com.baidu.tieba.im.model.al g;
    private com.baidu.tieba.im.model.bc h;
    private WeakReference<com.baidu.tbadk.img.b<ChatMessage>> i;
    private static volatile w c = null;
    public static volatile int a = 0;
    private final LinkedList<ChatMessage> d = new LinkedList<>();
    private final HashMap<String, com.baidu.tbadk.img.a<ChatMessage>> e = new HashMap<>();
    com.baidu.tieba.im.model.be b = new x(this);

    private w() {
        b();
    }

    public void a(com.baidu.tieba.im.model.al alVar) {
        this.g = alVar;
    }

    private void b() {
        this.h = new com.baidu.tieba.im.model.bc();
        this.h.a(this.b);
        this.f = new ak(this);
    }

    public static String a(String str, String str2, int i, int i2) {
        MsglistModel.PicMessageData picMessageData = new MsglistModel.PicMessageData();
        picMessageData.src = str2;
        picMessageData.big_src = str;
        picMessageData.type = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        if (i > 0) {
            picMessageData.bsize = String.valueOf(i) + "," + i2;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(picMessageData);
        return new Gson().toJson(linkedList);
    }

    public static void a(ChatMessage chatMessage) {
        String groupId = chatMessage.getGroupId();
        if (chatMessage.getCustomGroupType() == 2 || chatMessage.getCustomGroupType() == 4) {
            groupId = String.valueOf(chatMessage.getToUserId());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.g(groupId, chatMessage.getCustomGroupType(), chatMessage, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        com.baidu.adp.widget.a.a c2 = com.baidu.tbadk.imageManager.e.a().c(str);
        String str3 = String.valueOf(str2) + 10;
        if (c2 != null && c2.i()) {
            a(str3, c2);
        } else {
            new ar(this, str, str3).execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.baidu.adp.widget.a.a aVar) {
        com.baidu.tbadk.imageManager.e.a().b(str, aVar);
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, com.baidu.tbadk.core.util.ba.f(str), DiskFileOperate.Action.WRITE);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.b(true);
        cVar.a(aVar.k());
        cVar.f(false);
        com.baidu.adp.lib.Disk.d.a().b(cVar);
    }

    public void a(ChatMessage chatMessage, String str) {
        com.baidu.tbadk.img.a<ChatMessage> aVar = this.e.get(str);
        if (aVar == null) {
            com.baidu.tbadk.img.a<ChatMessage> aVar2 = new com.baidu.tbadk.img.a<>(str, "IM");
            aVar2.c();
            aVar2.a((com.baidu.tbadk.img.a<ChatMessage>) chatMessage);
            if (this.i != null && this.i.get() != null) {
                aVar2.a(this.i.get());
            }
            aVar2.a(this.f);
            if (chatMessage instanceof CommonGroupChatMessage) {
                aVar2.a(((CommonGroupChatMessage) chatMessage).getGroupId());
            } else if (chatMessage instanceof PersonalChatMessage) {
                aVar2.a(String.valueOf(a));
            } else if (chatMessage instanceof OfficialChatMessage) {
                aVar2.a(String.valueOf(a));
            }
            synchronized (MsglistModel.class) {
                this.e.put(str, aVar2);
            }
            aVar = aVar2;
        }
        chatMessage.setLogTime(System.currentTimeMillis());
        a(chatMessage);
        aVar.a();
    }

    public void a(VoiceMsgData voiceMsgData, ChatMessage chatMessage) {
        e(chatMessage);
        this.h.a(voiceMsgData.getVoice_md5(), chatMessage);
    }

    public boolean b(ChatMessage chatMessage) {
        if (this.e == null || chatMessage == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.tbadk.img.a<ChatMessage>> entry : this.e.entrySet()) {
            com.baidu.tbadk.img.a<ChatMessage> value = entry.getValue();
            if (value != null && value.b() != null) {
                ChatMessage b = value.b();
                if (chatMessage.getRecordId() != b.getRecordId()) {
                    continue;
                } else if (chatMessage.getCustomGroupType() == 2 || chatMessage.getCustomGroupType() == 4) {
                    if (chatMessage.getToUserId() == b.getToUserId()) {
                        if (this.i != null && this.i.get() != null) {
                            value.a(this.i.get());
                        }
                        return true;
                    }
                } else if (chatMessage.getGroupId() != null && b.getGroupId() != null && chatMessage.getGroupId().equals(b.getGroupId())) {
                    if (this.i != null && this.i.get() != null) {
                        value.a(this.i.get());
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void e(ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.d.add(chatMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ChatMessage chatMessage) {
        int a2 = a(chatMessage, this.d);
        if (a2 >= 0) {
            this.d.remove(a2);
        }
    }

    public boolean c(ChatMessage chatMessage) {
        return a(chatMessage, this.d) != -1;
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

    public static w a() {
        if (c == null) {
            synchronized (w.class) {
                if (c == null) {
                    c = new w();
                }
            }
        }
        return c;
    }

    public static void a(int i) {
        if (i != 0 && a != i) {
            a = i;
        }
    }

    public void a(String str, bs bsVar) {
        com.baidu.tieba.im.e.a(new as(this, str), new at(this, bsVar));
    }

    public void b(String str, bs bsVar) {
        com.baidu.tieba.im.e.a(new au(this, str), new av(this, bsVar));
    }

    public void c(String str, bs bsVar) {
        com.baidu.tieba.im.e.a(new aw(this, str), new ax(this, bsVar));
    }

    public void d(ChatMessage chatMessage) {
        if (chatMessage instanceof CommonGroupChatMessage) {
            CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
            LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            com.baidu.tieba.im.e.a(new ae(this, commonGroupChatMessage, linkedList), new af(this, commonGroupChatMessage, chatMessage));
        } else if (chatMessage instanceof PersonalChatMessage) {
            PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
            LinkedList linkedList2 = new LinkedList();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(chatMessage);
            commonMsgPojo2.setRead_flag(0);
            linkedList2.add(commonMsgPojo2);
            com.baidu.tieba.im.e.a(new ag(this, personalChatMessage, linkedList2), new ah(this, personalChatMessage, chatMessage));
        } else if (chatMessage instanceof OfficialChatMessage) {
            OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
            LinkedList linkedList3 = new LinkedList();
            CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(chatMessage);
            commonMsgPojo3.setRead_flag(0);
            linkedList3.add(commonMsgPojo3);
            com.baidu.tieba.im.e.a(new ai(this, officialChatMessage, linkedList3), new aj(this, officialChatMessage, chatMessage));
        }
    }

    public void a(com.baidu.tbadk.img.b<ChatMessage> bVar) {
        this.i = new WeakReference<>(bVar);
    }
}
