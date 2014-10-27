package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.model.VoiceSendModel;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class w {
    private static volatile w aNE = null;
    public static volatile int aNF = 0;
    private com.baidu.tbadk.img.d aNI;
    private VoiceSendModel aNJ;
    private WeakReference<com.baidu.tbadk.img.b<ChatMessage>> aNK;
    private MsglistModel.SendCallback mSendCallback;
    private final LinkedList<ChatMessage> aNG = new LinkedList<>();
    private final HashMap<String, com.baidu.tbadk.img.a<ChatMessage>> aNH = new HashMap<>();
    VoiceSendModel.UploadVoiceCallback aNL = new x(this);

    private w() {
        init();
    }

    public void setSendCallback(MsglistModel.SendCallback sendCallback) {
        this.mSendCallback = sendCallback;
    }

    private void init() {
        this.aNJ = new VoiceSendModel(null);
        this.aNJ.setUploadVoiceCallback(this.aNL);
        this.aNI = new ak(this);
    }

    public static String b(String str, String str2, int i, int i2) {
        MsglistModel.PicMessageData picMessageData = new MsglistModel.PicMessageData();
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

    public static void a(ChatMessage chatMessage) {
        String groupId = chatMessage.getGroupId();
        if (chatMessage.getCustomGroupType() == 2 || chatMessage.getCustomGroupType() == 4) {
            groupId = String.valueOf(chatMessage.getToUserId());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.f(groupId, chatMessage.getCustomGroupType(), chatMessage, 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(String str, String str2) {
        com.baidu.adp.widget.a.a dt = com.baidu.tbadk.imageManager.e.sg().dt(str);
        String str3 = String.valueOf(str2) + 10;
        if (dt != null && dt.hm()) {
            e(str3, dt);
        } else {
            new ar(this, str, str3).execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, com.baidu.adp.widget.a.a aVar) {
        com.baidu.tbadk.imageManager.e.sg().c(str, aVar);
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, com.baidu.tbadk.core.util.ba.bQ(str), DiskFileOperate.Action.WRITE);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.k(true);
        cVar.setData(aVar.ho());
        cVar.n(false);
        com.baidu.adp.lib.Disk.d.bn().c(cVar);
    }

    public void a(ChatMessage chatMessage, String str) {
        com.baidu.tbadk.img.a<ChatMessage> aVar = this.aNH.get(str);
        if (aVar == null) {
            com.baidu.tbadk.img.a<ChatMessage> aVar2 = new com.baidu.tbadk.img.a<>(str, "IM");
            aVar2.sl();
            aVar2.q(chatMessage);
            if (this.aNK != null && this.aNK.get() != null) {
                aVar2.a(this.aNK.get());
            }
            aVar2.a(this.aNI);
            if (chatMessage instanceof CommonGroupChatMessage) {
                aVar2.setGroupId(((CommonGroupChatMessage) chatMessage).getGroupId());
            } else if (chatMessage instanceof PersonalChatMessage) {
                aVar2.setGroupId(String.valueOf(aNF));
            } else if (chatMessage instanceof OfficialChatMessage) {
                aVar2.setGroupId(String.valueOf(aNF));
            }
            synchronized (MsglistModel.class) {
                this.aNH.put(str, aVar2);
            }
            aVar = aVar2;
        }
        chatMessage.setLogTime(System.currentTimeMillis());
        a(chatMessage);
        aVar.sj();
    }

    public void a(VoiceMsgData voiceMsgData, ChatMessage chatMessage) {
        c(chatMessage);
        this.aNJ.upload(voiceMsgData.getVoice_md5(), chatMessage);
    }

    public boolean b(ChatMessage chatMessage) {
        if (this.aNH == null || chatMessage == null) {
            return false;
        }
        for (Map.Entry<String, com.baidu.tbadk.img.a<ChatMessage>> entry : this.aNH.entrySet()) {
            com.baidu.tbadk.img.a<ChatMessage> value = entry.getValue();
            if (value != null && value.sk() != null) {
                ChatMessage sk = value.sk();
                if (chatMessage.getRecordId() != sk.getRecordId()) {
                    continue;
                } else if (chatMessage.getCustomGroupType() == 2 || chatMessage.getCustomGroupType() == 4) {
                    if (chatMessage.getToUserId() == sk.getToUserId()) {
                        if (this.aNK != null && this.aNK.get() != null) {
                            value.a(this.aNK.get());
                        }
                        return true;
                    }
                } else if (chatMessage.getGroupId() != null && sk.getGroupId() != null && chatMessage.getGroupId().equals(sk.getGroupId())) {
                    if (this.aNK != null && this.aNK.get() != null) {
                        value.a(this.aNK.get());
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void c(ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.aNG.add(chatMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ChatMessage chatMessage) {
        int a = a(chatMessage, this.aNG);
        if (a >= 0) {
            this.aNG.remove(a);
        }
    }

    public boolean e(ChatMessage chatMessage) {
        return a(chatMessage, this.aNG) != -1;
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

    public static w Jo() {
        if (aNE == null) {
            synchronized (w.class) {
                if (aNE == null) {
                    aNE = new w();
                }
            }
        }
        return aNE;
    }

    public static void fm(int i) {
        if (i != 0 && aNF != i) {
            aNF = i;
        }
    }

    public void b(String str, bs bsVar) {
        com.baidu.tieba.im.e.a(new as(this, str), new at(this, bsVar));
    }

    public void c(String str, bs bsVar) {
        com.baidu.tieba.im.e.a(new au(this, str), new av(this, bsVar));
    }

    public void d(String str, bs bsVar) {
        com.baidu.tieba.im.e.a(new aw(this, str), new ax(this, bsVar));
    }

    public void f(ChatMessage chatMessage) {
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

    public void setImageUploadUIProgressCallback(com.baidu.tbadk.img.b<ChatMessage> bVar) {
        this.aNK = new WeakReference<>(bVar);
    }
}
