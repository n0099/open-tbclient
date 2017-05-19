package com.baidu.tieba.im.sendmessage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.img.a;
import com.baidu.tieba.im.data.PicMessageData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.sendmessage.VoiceSendModel;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class a {
    private static volatile a daL = null;
    public static volatile int daM = 0;
    public static volatile int daN = 0;
    private a.c daQ;
    private VoiceSendModel daR;
    private WeakReference<a.InterfaceC0046a<ChatMessage>> daS;
    private ae mSendCallback;
    private final LinkedList<ChatMessage> daO = new LinkedList<>();
    private final HashMap<String, com.baidu.tbadk.img.a<ChatMessage>> daP = new HashMap<>();
    VoiceSendModel.b daT = new b(this);

    private a() {
        init();
    }

    public void setSendCallback(ae aeVar) {
        this.mSendCallback = aeVar;
    }

    private void init() {
        this.daR = new VoiceSendModel(null);
        this.daR.a(this.daT);
        this.daQ = new o(this);
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
        jSONArray.put(OrmObject.jsonWithObject(picMessageData));
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
        com.baidu.adp.widget.a.a fL = com.baidu.tbadk.imageManager.c.DN().fL(str);
        String str3 = String.valueOf(str2) + 10;
        if (fL != null && fL.kS()) {
            e(str3, fL);
        } else {
            new v(this, str, str3).execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, com.baidu.adp.widget.a.a aVar) {
        com.baidu.tbadk.imageManager.c.DN().c(str, aVar);
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, aw.dB(str), DiskFileOperate.Action.WRITE);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.s(true);
        cVar.setData(aVar.kU());
        cVar.v(false);
        com.baidu.adp.lib.Disk.d.dI().c(cVar);
    }

    public void c(ChatMessage chatMessage, String str) {
        com.baidu.tbadk.img.a<ChatMessage> aVar = this.daP.get(str);
        if (aVar == null) {
            com.baidu.tbadk.img.a<ChatMessage> aVar2 = new com.baidu.tbadk.img.a<>(str, "IM");
            aVar2.DQ();
            aVar2.B(chatMessage);
            if (this.daS != null && this.daS.get() != null) {
                aVar2.a(this.daS.get());
            }
            aVar2.a(this.daQ);
            if (chatMessage instanceof CommonGroupChatMessage) {
                aVar2.setGroupId(((CommonGroupChatMessage) chatMessage).getGroupId());
            } else if (chatMessage instanceof PersonalChatMessage) {
                aVar2.setGroupId(String.valueOf(daM));
            } else if (chatMessage instanceof OfficialChatMessage) {
                aVar2.setGroupId(String.valueOf(daN));
            }
            synchronized (a.class) {
                this.daP.put(str, aVar2);
            }
            aVar = aVar2;
        }
        chatMessage.setLogTime(System.currentTimeMillis());
        j(chatMessage);
        aVar.bN(false);
    }

    public void a(VoiceMsgData voiceMsgData, ChatMessage chatMessage) {
        l(chatMessage);
        if (chatMessage != null) {
            chatMessage.getClientLogID();
            chatMessage.getCmd();
        }
        this.daR.b(voiceMsgData.getVoice_md5(), chatMessage);
    }

    public boolean k(ChatMessage chatMessage) {
        if (this.daP == null || chatMessage == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.tbadk.img.a<ChatMessage>> entry : this.daP.entrySet()) {
            com.baidu.tbadk.img.a<ChatMessage> value = entry.getValue();
            if (value != null && value.DP() != null) {
                ChatMessage DP = value.DP();
                if (chatMessage.getRecordId() != DP.getRecordId()) {
                    continue;
                } else if (chatMessage.getCustomGroupType() == 2 || chatMessage.getCustomGroupType() == 4) {
                    if (chatMessage.getToUserId() == DP.getToUserId()) {
                        if (this.daS != null && this.daS.get() != null) {
                            value.a(this.daS.get());
                        }
                        return true;
                    }
                } else if (chatMessage.getGroupId() != null && DP.getGroupId() != null && chatMessage.getGroupId().equals(DP.getGroupId())) {
                    if (this.daS != null && this.daS.get() != null) {
                        value.a(this.daS.get());
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void l(ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.daO.add(chatMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(ChatMessage chatMessage) {
        int a = a(chatMessage, this.daO);
        if (a >= 0) {
            this.daO.remove(a);
        }
    }

    public boolean n(ChatMessage chatMessage) {
        return a(chatMessage, this.daO) != -1;
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

    public static a aro() {
        if (daL == null) {
            synchronized (a.class) {
                if (daL == null) {
                    daL = new a();
                }
            }
        }
        return daL;
    }

    public static void lM(int i) {
        daM = i;
    }

    public static void lN(int i) {
        daN = i;
    }

    public void b(String str, ad adVar) {
        com.baidu.tbadk.util.w.b(new w(this, str), new x(this, adVar));
    }

    public void c(String str, ad adVar) {
        com.baidu.tbadk.util.w.b(new y(this, str), new z(this, adVar));
    }

    public void d(String str, ad adVar) {
        com.baidu.tbadk.util.w.b(new aa(this, str), new ab(this, adVar));
    }

    public void o(ChatMessage chatMessage) {
        if (chatMessage instanceof CommonGroupChatMessage) {
            CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
            LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            com.baidu.tbadk.util.w.b(new i(this, commonGroupChatMessage, linkedList), new j(this, commonGroupChatMessage, chatMessage));
        } else if (chatMessage instanceof PersonalChatMessage) {
            PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
            LinkedList linkedList2 = new LinkedList();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(chatMessage);
            commonMsgPojo2.setRead_flag(0);
            linkedList2.add(commonMsgPojo2);
            com.baidu.tbadk.util.w.b(new k(this, personalChatMessage, linkedList2), new l(this, personalChatMessage, chatMessage));
        } else if (chatMessage instanceof OfficialChatMessage) {
            OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
            LinkedList linkedList3 = new LinkedList();
            CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(chatMessage);
            commonMsgPojo3.setRead_flag(0);
            linkedList3.add(commonMsgPojo3);
            com.baidu.tbadk.util.w.b(new m(this, officialChatMessage, linkedList3), new n(this, officialChatMessage, chatMessage));
        }
    }

    public void setImageUploadUIProgressCallback(a.InterfaceC0046a<ChatMessage> interfaceC0046a) {
        this.daS = new WeakReference<>(interfaceC0046a);
    }
}
