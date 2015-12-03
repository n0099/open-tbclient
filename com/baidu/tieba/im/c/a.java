package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.az;
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
    private static volatile a bWx = null;
    public static volatile int bWy = 0;
    public static volatile int bWz = 0;
    private a.c bWC;
    private af bWD;
    private WeakReference<a.InterfaceC0052a<ChatMessage>> bWE;
    private ae mSendCallback;
    private final LinkedList<ChatMessage> bWA = new LinkedList<>();
    private final HashMap<String, com.baidu.tbadk.img.a<ChatMessage>> bWB = new HashMap<>();
    af.b bWF = new b(this);

    private a() {
        init();
    }

    public void setSendCallback(ae aeVar) {
        this.mSendCallback = aeVar;
    }

    private void init() {
        this.bWD = new af(null);
        this.bWD.a(this.bWF);
        this.bWC = new o(this);
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
    public void aN(String str, String str2) {
        com.baidu.adp.widget.a.a fF = com.baidu.tbadk.imageManager.c.CX().fF(str);
        String str3 = String.valueOf(str2) + 10;
        if (fF != null && fF.nh()) {
            e(str3, fF);
        } else {
            new v(this, str, str3).execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, com.baidu.adp.widget.a.a aVar) {
        com.baidu.tbadk.imageManager.c.CX().c(str, aVar);
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, az.dy(str), DiskFileOperate.Action.WRITE);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.o(true);
        cVar.setData(aVar.nj());
        cVar.r(false);
        com.baidu.adp.lib.Disk.d.fj().c(cVar);
    }

    public void c(ChatMessage chatMessage, String str) {
        com.baidu.tbadk.img.a<ChatMessage> aVar = this.bWB.get(str);
        if (aVar == null) {
            com.baidu.tbadk.img.a<ChatMessage> aVar2 = new com.baidu.tbadk.img.a<>(str, "IM");
            aVar2.Da();
            aVar2.y(chatMessage);
            if (this.bWE != null && this.bWE.get() != null) {
                aVar2.a(this.bWE.get());
            }
            aVar2.a(this.bWC);
            if (chatMessage instanceof CommonGroupChatMessage) {
                aVar2.setGroupId(((CommonGroupChatMessage) chatMessage).getGroupId());
            } else if (chatMessage instanceof PersonalChatMessage) {
                aVar2.setGroupId(String.valueOf(bWy));
            } else if (chatMessage instanceof OfficialChatMessage) {
                aVar2.setGroupId(String.valueOf(bWz));
            }
            synchronized (a.class) {
                this.bWB.put(str, aVar2);
            }
            aVar = aVar2;
        }
        chatMessage.setLogTime(System.currentTimeMillis());
        i(chatMessage);
        aVar.br(false);
    }

    public void a(VoiceMsgData voiceMsgData, ChatMessage chatMessage) {
        k(chatMessage);
        if (chatMessage != null) {
            chatMessage.getClientLogID();
            chatMessage.getCmd();
        }
        this.bWD.b(voiceMsgData.getVoice_md5(), chatMessage);
    }

    public boolean j(ChatMessage chatMessage) {
        if (this.bWB == null || chatMessage == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.tbadk.img.a<ChatMessage>> entry : this.bWB.entrySet()) {
            com.baidu.tbadk.img.a<ChatMessage> value = entry.getValue();
            if (value != null && value.CZ() != null) {
                ChatMessage CZ = value.CZ();
                if (chatMessage.getRecordId() != CZ.getRecordId()) {
                    continue;
                } else if (chatMessage.getCustomGroupType() == 2 || chatMessage.getCustomGroupType() == 4) {
                    if (chatMessage.getToUserId() == CZ.getToUserId()) {
                        if (this.bWE != null && this.bWE.get() != null) {
                            value.a(this.bWE.get());
                        }
                        return true;
                    }
                } else if (chatMessage.getGroupId() != null && CZ.getGroupId() != null && chatMessage.getGroupId().equals(CZ.getGroupId())) {
                    if (this.bWE != null && this.bWE.get() != null) {
                        value.a(this.bWE.get());
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void k(ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.bWA.add(chatMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(ChatMessage chatMessage) {
        int a = a(chatMessage, this.bWA);
        if (a >= 0) {
            this.bWA.remove(a);
        }
    }

    public boolean m(ChatMessage chatMessage) {
        return a(chatMessage, this.bWA) != -1;
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

    public static a aaA() {
        if (bWx == null) {
            synchronized (a.class) {
                if (bWx == null) {
                    bWx = new a();
                }
            }
        }
        return bWx;
    }

    public static void iy(int i) {
        bWy = i;
    }

    public static void iz(int i) {
        bWz = i;
    }

    public void b(String str, ad adVar) {
        com.baidu.tbadk.util.n.b(new w(this, str), new x(this, adVar));
    }

    public void c(String str, ad adVar) {
        com.baidu.tbadk.util.n.b(new y(this, str), new z(this, adVar));
    }

    public void d(String str, ad adVar) {
        com.baidu.tbadk.util.n.b(new aa(this, str), new ab(this, adVar));
    }

    public void n(ChatMessage chatMessage) {
        if (chatMessage instanceof CommonGroupChatMessage) {
            CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
            LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            com.baidu.tbadk.util.n.b(new i(this, commonGroupChatMessage, linkedList), new j(this, commonGroupChatMessage, chatMessage));
        } else if (chatMessage instanceof PersonalChatMessage) {
            PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
            LinkedList linkedList2 = new LinkedList();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(chatMessage);
            commonMsgPojo2.setRead_flag(0);
            linkedList2.add(commonMsgPojo2);
            com.baidu.tbadk.util.n.b(new k(this, personalChatMessage, linkedList2), new l(this, personalChatMessage, chatMessage));
        } else if (chatMessage instanceof OfficialChatMessage) {
            OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
            LinkedList linkedList3 = new LinkedList();
            CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(chatMessage);
            commonMsgPojo3.setRead_flag(0);
            linkedList3.add(commonMsgPojo3);
            com.baidu.tbadk.util.n.b(new m(this, officialChatMessage, linkedList3), new n(this, officialChatMessage, chatMessage));
        }
    }

    public void setImageUploadUIProgressCallback(a.InterfaceC0052a<ChatMessage> interfaceC0052a) {
        this.bWE = new WeakReference<>(interfaceC0052a);
    }
}
