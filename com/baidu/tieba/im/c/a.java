package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.bc;
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
    private static volatile a cVN = null;
    public static volatile int cVO = 0;
    public static volatile int cVP = 0;
    private a.c cVS;
    private af cVT;
    private WeakReference<a.InterfaceC0044a<ChatMessage>> cVU;
    private ae mSendCallback;
    private final LinkedList<ChatMessage> cVQ = new LinkedList<>();
    private final HashMap<String, com.baidu.tbadk.img.a<ChatMessage>> cVR = new HashMap<>();
    af.b cVV = new b(this);

    private a() {
        init();
    }

    public void setSendCallback(ae aeVar) {
        this.mSendCallback = aeVar;
    }

    private void init() {
        this.cVT = new af(null);
        this.cVT.a(this.cVV);
        this.cVS = new o(this);
    }

    public static String c(String str, String str2, int i, int i2) {
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

    public static void j(ChatMessage chatMessage) {
        String groupId = chatMessage.getGroupId();
        if (chatMessage.getCustomGroupType() == 2 || chatMessage.getCustomGroupType() == 4) {
            groupId = String.valueOf(chatMessage.getToUserId());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(groupId, chatMessage.getCustomGroupType(), chatMessage, 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(String str, String str2) {
        com.baidu.adp.widget.a.a fS = com.baidu.tbadk.imageManager.c.CQ().fS(str);
        String str3 = String.valueOf(str2) + 10;
        if (fS != null && fS.jc()) {
            e(str3, fS);
        } else {
            new v(this, str, str3).execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, com.baidu.adp.widget.a.a aVar) {
        com.baidu.tbadk.imageManager.c.CQ().c(str, aVar);
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, bc.dB(str), DiskFileOperate.Action.WRITE);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.n(true);
        cVar.setData(aVar.je());
        cVar.q(false);
        com.baidu.adp.lib.Disk.d.bH().c(cVar);
    }

    public void c(ChatMessage chatMessage, String str) {
        com.baidu.tbadk.img.a<ChatMessage> aVar = this.cVR.get(str);
        if (aVar == null) {
            com.baidu.tbadk.img.a<ChatMessage> aVar2 = new com.baidu.tbadk.img.a<>(str, "IM");
            aVar2.CT();
            aVar2.y(chatMessage);
            if (this.cVU != null && this.cVU.get() != null) {
                aVar2.a(this.cVU.get());
            }
            aVar2.a(this.cVS);
            if (chatMessage instanceof CommonGroupChatMessage) {
                aVar2.setGroupId(((CommonGroupChatMessage) chatMessage).getGroupId());
            } else if (chatMessage instanceof PersonalChatMessage) {
                aVar2.setGroupId(String.valueOf(cVO));
            } else if (chatMessage instanceof OfficialChatMessage) {
                aVar2.setGroupId(String.valueOf(cVP));
            }
            synchronized (a.class) {
                this.cVR.put(str, aVar2);
            }
            aVar = aVar2;
        }
        chatMessage.setLogTime(System.currentTimeMillis());
        j(chatMessage);
        aVar.bD(false);
    }

    public void a(VoiceMsgData voiceMsgData, ChatMessage chatMessage) {
        l(chatMessage);
        if (chatMessage != null) {
            chatMessage.getClientLogID();
            chatMessage.getCmd();
        }
        this.cVT.b(voiceMsgData.getVoice_md5(), chatMessage);
    }

    public boolean k(ChatMessage chatMessage) {
        if (this.cVR == null || chatMessage == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.tbadk.img.a<ChatMessage>> entry : this.cVR.entrySet()) {
            com.baidu.tbadk.img.a<ChatMessage> value = entry.getValue();
            if (value != null && value.CS() != null) {
                ChatMessage CS = value.CS();
                if (chatMessage.getRecordId() != CS.getRecordId()) {
                    continue;
                } else if (chatMessage.getCustomGroupType() == 2 || chatMessage.getCustomGroupType() == 4) {
                    if (chatMessage.getToUserId() == CS.getToUserId()) {
                        if (this.cVU != null && this.cVU.get() != null) {
                            value.a(this.cVU.get());
                        }
                        return true;
                    }
                } else if (chatMessage.getGroupId() != null && CS.getGroupId() != null && chatMessage.getGroupId().equals(CS.getGroupId())) {
                    if (this.cVU != null && this.cVU.get() != null) {
                        value.a(this.cVU.get());
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void l(ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.cVQ.add(chatMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(ChatMessage chatMessage) {
        int a = a(chatMessage, this.cVQ);
        if (a >= 0) {
            this.cVQ.remove(a);
        }
    }

    public boolean n(ChatMessage chatMessage) {
        return a(chatMessage, this.cVQ) != -1;
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

    public static a aqE() {
        if (cVN == null) {
            synchronized (a.class) {
                if (cVN == null) {
                    cVN = new a();
                }
            }
        }
        return cVN;
    }

    public static void lg(int i) {
        cVO = i;
    }

    public static void lh(int i) {
        cVP = i;
    }

    public void b(String str, ad adVar) {
        com.baidu.tbadk.util.t.b(new w(this, str), new x(this, adVar));
    }

    public void c(String str, ad adVar) {
        com.baidu.tbadk.util.t.b(new y(this, str), new z(this, adVar));
    }

    public void d(String str, ad adVar) {
        com.baidu.tbadk.util.t.b(new aa(this, str), new ab(this, adVar));
    }

    public void o(ChatMessage chatMessage) {
        if (chatMessage instanceof CommonGroupChatMessage) {
            CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
            LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            com.baidu.tbadk.util.t.b(new i(this, commonGroupChatMessage, linkedList), new j(this, commonGroupChatMessage, chatMessage));
        } else if (chatMessage instanceof PersonalChatMessage) {
            PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
            LinkedList linkedList2 = new LinkedList();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(chatMessage);
            commonMsgPojo2.setRead_flag(0);
            linkedList2.add(commonMsgPojo2);
            com.baidu.tbadk.util.t.b(new k(this, personalChatMessage, linkedList2), new l(this, personalChatMessage, chatMessage));
        } else if (chatMessage instanceof OfficialChatMessage) {
            OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
            LinkedList linkedList3 = new LinkedList();
            CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(chatMessage);
            commonMsgPojo3.setRead_flag(0);
            linkedList3.add(commonMsgPojo3);
            com.baidu.tbadk.util.t.b(new m(this, officialChatMessage, linkedList3), new n(this, officialChatMessage, chatMessage));
        }
    }

    public void setImageUploadUIProgressCallback(a.InterfaceC0044a<ChatMessage> interfaceC0044a) {
        this.cVU = new WeakReference<>(interfaceC0044a);
    }
}
