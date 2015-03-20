package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.im.data.PicMessageData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class a {
    private static volatile a bmt = null;
    public static volatile int bmu = 0;
    public static volatile int bmv = 0;
    private WeakReference<com.baidu.tbadk.img.b<ChatMessage>> bmA;
    private com.baidu.tbadk.img.d bmy;
    private af bmz;
    private ae mSendCallback;
    private final LinkedList<ChatMessage> bmw = new LinkedList<>();
    private final HashMap<String, com.baidu.tbadk.img.a<ChatMessage>> bmx = new HashMap<>();
    ah bmB = new b(this);

    private a() {
        init();
    }

    public void setSendCallback(ae aeVar) {
        this.mSendCallback = aeVar;
    }

    private void init() {
        this.bmz = new af(null);
        this.bmz.a(this.bmB);
        this.bmy = new o(this);
    }

    public static String b(String str, String str2, int i, int i2) {
        PicMessageData picMessageData = new PicMessageData();
        picMessageData.src = str2;
        picMessageData.big_src = str;
        picMessageData.type = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        if (i > 0) {
            picMessageData.bsize = String.valueOf(i) + "," + i2;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(com.baidu.adp.lib.a.b.a.a.i.jsonWithObject(picMessageData));
        return jSONArray.toString();
    }

    public static void i(ChatMessage chatMessage) {
        String groupId = chatMessage.getGroupId();
        if (chatMessage.getCustomGroupType() == 2 || chatMessage.getCustomGroupType() == 4) {
            groupId = String.valueOf(chatMessage.getToUserId());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.g(groupId, chatMessage.getCustomGroupType(), chatMessage, 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(String str, String str2) {
        com.baidu.adp.widget.a.a er = com.baidu.tbadk.imageManager.e.zs().er(str);
        String str3 = String.valueOf(str2) + 10;
        if (er != null && er.mA()) {
            e(str3, er);
        } else {
            new v(this, str, str3).execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, com.baidu.adp.widget.a.a aVar) {
        com.baidu.tbadk.imageManager.e.zs().c(str, aVar);
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, bf.cN(str), DiskFileOperate.Action.WRITE);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.o(true);
        cVar.setData(aVar.mC());
        cVar.r(false);
        com.baidu.adp.lib.Disk.d.fk().c(cVar);
    }

    public void c(ChatMessage chatMessage, String str) {
        com.baidu.tbadk.img.a<ChatMessage> aVar = this.bmx.get(str);
        if (aVar == null) {
            com.baidu.tbadk.img.a<ChatMessage> aVar2 = new com.baidu.tbadk.img.a<>(str, "IM");
            aVar2.zx();
            aVar2.w(chatMessage);
            if (this.bmA != null && this.bmA.get() != null) {
                aVar2.a(this.bmA.get());
            }
            aVar2.a(this.bmy);
            if (chatMessage instanceof CommonGroupChatMessage) {
                aVar2.setGroupId(((CommonGroupChatMessage) chatMessage).getGroupId());
            } else if (chatMessage instanceof PersonalChatMessage) {
                aVar2.setGroupId(String.valueOf(bmu));
            } else if (chatMessage instanceof OfficialChatMessage) {
                aVar2.setGroupId(String.valueOf(bmv));
            }
            synchronized (a.class) {
                this.bmx.put(str, aVar2);
            }
            aVar = aVar2;
        }
        chatMessage.setLogTime(System.currentTimeMillis());
        i(chatMessage);
        aVar.zv();
    }

    public void a(VoiceMsgData voiceMsgData, ChatMessage chatMessage) {
        k(chatMessage);
        this.bmz.b(voiceMsgData.getVoice_md5(), chatMessage);
    }

    public boolean j(ChatMessage chatMessage) {
        if (this.bmx == null || chatMessage == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.tbadk.img.a<ChatMessage>> entry : this.bmx.entrySet()) {
            com.baidu.tbadk.img.a<ChatMessage> value = entry.getValue();
            if (value != null && value.zw() != null) {
                ChatMessage zw = value.zw();
                if (chatMessage.getRecordId() != zw.getRecordId()) {
                    continue;
                } else if (chatMessage.getCustomGroupType() == 2 || chatMessage.getCustomGroupType() == 4) {
                    if (chatMessage.getToUserId() == zw.getToUserId()) {
                        if (this.bmA != null && this.bmA.get() != null) {
                            value.a(this.bmA.get());
                        }
                        return true;
                    }
                } else if (chatMessage.getGroupId() != null && zw.getGroupId() != null && chatMessage.getGroupId().equals(zw.getGroupId())) {
                    if (this.bmA != null && this.bmA.get() != null) {
                        value.a(this.bmA.get());
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void k(ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.bmw.add(chatMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(ChatMessage chatMessage) {
        int a = a(chatMessage, this.bmw);
        if (a >= 0) {
            this.bmw.remove(a);
        }
    }

    public boolean m(ChatMessage chatMessage) {
        return a(chatMessage, this.bmw) != -1;
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

    public static a Tk() {
        if (bmt == null) {
            synchronized (a.class) {
                if (bmt == null) {
                    bmt = new a();
                }
            }
        }
        return bmt;
    }

    public static void gk(int i) {
        bmu = i;
    }

    public static void gl(int i) {
        bmv = i;
    }

    public void b(String str, ad adVar) {
        com.baidu.tieba.im.l.a(new w(this, str), new x(this, adVar));
    }

    public void c(String str, ad adVar) {
        com.baidu.tieba.im.l.a(new y(this, str), new z(this, adVar));
    }

    public void d(String str, ad adVar) {
        com.baidu.tieba.im.l.a(new aa(this, str), new ab(this, adVar));
    }

    public void n(ChatMessage chatMessage) {
        if (chatMessage instanceof CommonGroupChatMessage) {
            CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
            LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            com.baidu.tieba.im.l.a(new i(this, commonGroupChatMessage, linkedList), new j(this, commonGroupChatMessage, chatMessage));
        } else if (chatMessage instanceof PersonalChatMessage) {
            PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
            LinkedList linkedList2 = new LinkedList();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(chatMessage);
            commonMsgPojo2.setRead_flag(0);
            linkedList2.add(commonMsgPojo2);
            com.baidu.tieba.im.l.a(new k(this, personalChatMessage, linkedList2), new l(this, personalChatMessage, chatMessage));
        } else if (chatMessage instanceof OfficialChatMessage) {
            OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
            LinkedList linkedList3 = new LinkedList();
            CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(chatMessage);
            commonMsgPojo3.setRead_flag(0);
            linkedList3.add(commonMsgPojo3);
            com.baidu.tieba.im.l.a(new m(this, officialChatMessage, linkedList3), new n(this, officialChatMessage, chatMessage));
        }
    }

    public void setImageUploadUIProgressCallback(com.baidu.tbadk.img.b<ChatMessage> bVar) {
        this.bmA = new WeakReference<>(bVar);
    }
}
