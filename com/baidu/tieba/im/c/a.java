package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.img.a;
import com.baidu.tieba.im.c.af;
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
    private static volatile a cpA = null;
    public static volatile int cpB = 0;
    public static volatile int cpC = 0;
    private a.c cpF;
    private af cpG;
    private WeakReference<a.InterfaceC0053a<ChatMessage>> cpH;
    private ae mSendCallback;
    private final LinkedList<ChatMessage> cpD = new LinkedList<>();
    private final HashMap<String, com.baidu.tbadk.img.a<ChatMessage>> cpE = new HashMap<>();
    af.b cpI = new b(this);

    private a() {
        init();
    }

    public void setSendCallback(ae aeVar) {
        this.mSendCallback = aeVar;
    }

    private void init() {
        this.cpG = new af(null);
        this.cpG.a(this.cpI);
        this.cpF = new o(this);
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
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(groupId, chatMessage.getCustomGroupType(), chatMessage, 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(String str, String str2) {
        com.baidu.adp.widget.a.a fP = com.baidu.tbadk.imageManager.c.EO().fP(str);
        String str3 = String.valueOf(str2) + 10;
        if (fP != null && fP.mL()) {
            e(str3, fP);
        } else {
            new v(this, str, str3).execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, com.baidu.adp.widget.a.a aVar) {
        com.baidu.tbadk.imageManager.c.EO().c(str, aVar);
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ba.dB(str), DiskFileOperate.Action.WRITE);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.n(true);
        cVar.setData(aVar.mN());
        cVar.q(false);
        com.baidu.adp.lib.Disk.d.fs().c(cVar);
    }

    public void c(ChatMessage chatMessage, String str) {
        com.baidu.tbadk.img.a<ChatMessage> aVar = this.cpE.get(str);
        if (aVar == null) {
            com.baidu.tbadk.img.a<ChatMessage> aVar2 = new com.baidu.tbadk.img.a<>(str, "IM");
            aVar2.ER();
            aVar2.y(chatMessage);
            if (this.cpH != null && this.cpH.get() != null) {
                aVar2.a(this.cpH.get());
            }
            aVar2.a(this.cpF);
            if (chatMessage instanceof CommonGroupChatMessage) {
                aVar2.setGroupId(((CommonGroupChatMessage) chatMessage).getGroupId());
            } else if (chatMessage instanceof PersonalChatMessage) {
                aVar2.setGroupId(String.valueOf(cpB));
            } else if (chatMessage instanceof OfficialChatMessage) {
                aVar2.setGroupId(String.valueOf(cpC));
            }
            synchronized (a.class) {
                this.cpE.put(str, aVar2);
            }
            aVar = aVar2;
        }
        chatMessage.setLogTime(System.currentTimeMillis());
        i(chatMessage);
        aVar.by(false);
    }

    public void a(VoiceMsgData voiceMsgData, ChatMessage chatMessage) {
        k(chatMessage);
        if (chatMessage != null) {
            chatMessage.getClientLogID();
            chatMessage.getCmd();
        }
        this.cpG.b(voiceMsgData.getVoice_md5(), chatMessage);
    }

    public boolean j(ChatMessage chatMessage) {
        if (this.cpE == null || chatMessage == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.tbadk.img.a<ChatMessage>> entry : this.cpE.entrySet()) {
            com.baidu.tbadk.img.a<ChatMessage> value = entry.getValue();
            if (value != null && value.EQ() != null) {
                ChatMessage EQ = value.EQ();
                if (chatMessage.getRecordId() != EQ.getRecordId()) {
                    continue;
                } else if (chatMessage.getCustomGroupType() == 2 || chatMessage.getCustomGroupType() == 4) {
                    if (chatMessage.getToUserId() == EQ.getToUserId()) {
                        if (this.cpH != null && this.cpH.get() != null) {
                            value.a(this.cpH.get());
                        }
                        return true;
                    }
                } else if (chatMessage.getGroupId() != null && EQ.getGroupId() != null && chatMessage.getGroupId().equals(EQ.getGroupId())) {
                    if (this.cpH != null && this.cpH.get() != null) {
                        value.a(this.cpH.get());
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void k(ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.cpD.add(chatMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(ChatMessage chatMessage) {
        int a = a(chatMessage, this.cpD);
        if (a >= 0) {
            this.cpD.remove(a);
        }
    }

    public boolean m(ChatMessage chatMessage) {
        return a(chatMessage, this.cpD) != -1;
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

    public static a aih() {
        if (cpA == null) {
            synchronized (a.class) {
                if (cpA == null) {
                    cpA = new a();
                }
            }
        }
        return cpA;
    }

    public static void ka(int i) {
        cpB = i;
    }

    public static void kb(int i) {
        cpC = i;
    }

    public void b(String str, ad adVar) {
        com.baidu.tbadk.util.q.b(new w(this, str), new x(this, adVar));
    }

    public void c(String str, ad adVar) {
        com.baidu.tbadk.util.q.b(new y(this, str), new z(this, adVar));
    }

    public void d(String str, ad adVar) {
        com.baidu.tbadk.util.q.b(new aa(this, str), new ab(this, adVar));
    }

    public void n(ChatMessage chatMessage) {
        if (chatMessage instanceof CommonGroupChatMessage) {
            CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
            LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            com.baidu.tbadk.util.q.b(new i(this, commonGroupChatMessage, linkedList), new j(this, commonGroupChatMessage, chatMessage));
        } else if (chatMessage instanceof PersonalChatMessage) {
            PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
            LinkedList linkedList2 = new LinkedList();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(chatMessage);
            commonMsgPojo2.setRead_flag(0);
            linkedList2.add(commonMsgPojo2);
            com.baidu.tbadk.util.q.b(new k(this, personalChatMessage, linkedList2), new l(this, personalChatMessage, chatMessage));
        } else if (chatMessage instanceof OfficialChatMessage) {
            OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
            LinkedList linkedList3 = new LinkedList();
            CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(chatMessage);
            commonMsgPojo3.setRead_flag(0);
            linkedList3.add(commonMsgPojo3);
            com.baidu.tbadk.util.q.b(new m(this, officialChatMessage, linkedList3), new n(this, officialChatMessage, chatMessage));
        }
    }

    public void setImageUploadUIProgressCallback(a.InterfaceC0053a<ChatMessage> interfaceC0053a) {
        this.cpH = new WeakReference<>(interfaceC0053a);
    }
}
