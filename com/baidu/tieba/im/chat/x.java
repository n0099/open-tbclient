package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class x {
    private final LinkedList<WeakReference<bu>> c = new LinkedList<>();
    private com.baidu.adp.framework.listener.b d = new y(this, 0);
    private CustomMessageListener e = new aj(this, 0);
    private static x b = null;
    public static volatile int a = 0;

    private x() {
    }

    public void a() {
        MessageManager.getInstance().registerListener(MessageTypes.CMD_GROUP_CHAT_MSG, this.d);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_COMMIT_PERSONAL_MSG, this.d);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_LOAD_DRAFT, this.e);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_LOAD_HISTORY, this.e);
    }

    public static x b() {
        if (b == null) {
            b = new x();
        }
        return b;
    }

    public static void a(int i) {
        if (i != 0 && a != i) {
            if (a != 0) {
                BdLog.e("私聊GID有变化!!!!!!!!!!!");
            }
            a = i;
            com.baidu.tieba.im.i.a(new as(i), null);
        }
    }

    public void a(bu buVar) {
        Iterator<WeakReference<bu>> it = this.c.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().get() == buVar) {
                z = true;
            }
        }
        if (!z) {
            this.c.add(new WeakReference<>(buVar));
        }
    }

    public void b(bu buVar) {
        WeakReference<bu> weakReference;
        Iterator<WeakReference<bu>> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                weakReference = null;
                break;
            }
            weakReference = it.next();
            if (weakReference.get() == buVar) {
                break;
            }
        }
        if (weakReference != null) {
            this.c.remove(weakReference);
        }
    }

    public void a(String str, bv bvVar) {
        com.baidu.tieba.im.i.a(new at(this, str), new au(this, bvVar));
    }

    public void b(String str, bv bvVar) {
        com.baidu.tieba.im.i.a(new av(this, str), new aw(this, bvVar));
    }

    public void c(String str, bv bvVar) {
        com.baidu.tieba.im.i.a(new ax(this, str), new ay(this, bvVar));
    }

    public void a(ChatMessage chatMessage) {
        BdLog.d("SHNAG chatManager sendMessage, content = " + chatMessage.getContent());
        if (chatMessage instanceof CommonGroupChatMessage) {
            CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
            LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            com.baidu.tieba.im.i.a(new z(this, commonGroupChatMessage, linkedList), new aa(this, commonGroupChatMessage));
        } else if (chatMessage instanceof PersonalChatMessage) {
            PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
            LinkedList linkedList2 = new LinkedList();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(chatMessage);
            commonMsgPojo2.setRead_flag(0);
            linkedList2.add(commonMsgPojo2);
            com.baidu.tieba.im.i.a(new ab(this, personalChatMessage, linkedList2), new ac(this, personalChatMessage));
        } else if (chatMessage instanceof OfficialChatMessage) {
            OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
            LinkedList linkedList3 = new LinkedList();
            CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(chatMessage);
            commonMsgPojo3.setRead_flag(0);
            linkedList3.add(commonMsgPojo3);
            com.baidu.tieba.im.i.a(new ad(this, officialChatMessage, linkedList3), new ae(this, officialChatMessage));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage instanceof ResponsedMessage) {
            Message<?> orginalMessage = socketResponsedMessage.getOrginalMessage();
            if (orginalMessage instanceof ChatMessage) {
                TiebaStatic.imNet(socketResponsedMessage, String.valueOf(((ChatMessage) orginalMessage).getMsgType()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage instanceof ResponseCommitGroupMessage) {
            ResponseCommitGroupMessage responseCommitGroupMessage = (ResponseCommitGroupMessage) socketResponsedMessage;
            BdLog.d("SHANG ChatResponsedMessage onAcked");
            if (responseCommitGroupMessage.getError() != 0) {
                b((ResponsedMessage<?>) responseCommitGroupMessage);
            } else {
                a(responseCommitGroupMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage instanceof ResponseCommitPersonalMessage) {
            ResponseCommitPersonalMessage responseCommitPersonalMessage = (ResponseCommitPersonalMessage) socketResponsedMessage;
            BdLog.d("SHANG ChatResponsedMessage onAcked");
            if (responseCommitPersonalMessage.getError() != 0) {
                b((ResponsedMessage<?>) responseCommitPersonalMessage);
                return;
            }
            int a2 = com.baidu.adp.lib.f.b.a(responseCommitPersonalMessage.getGroupId(), 0);
            a(a2);
            BdLog.d("GET Personal Gid MSGACK=" + a2);
            if (responseCommitPersonalMessage.getToUserType() == 0) {
                a(responseCommitPersonalMessage);
            } else {
                b(responseCommitPersonalMessage);
            }
        }
    }

    private void b(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
            ChatMessage chatMessage = (ChatMessage) responsedMessage.getOrginalMessage();
            if (chatMessage == null) {
                BdLog.e("chatMessage == null");
            } else if (chatMessage instanceof CommonGroupChatMessage) {
                com.baidu.tieba.im.i.a(new af(this, (CommonGroupChatMessage) chatMessage, chatMessage), new ag(this, responsedMessage));
            } else if (chatMessage instanceof PersonalChatMessage) {
                com.baidu.tieba.im.i.a(new ah(this, (PersonalChatMessage) chatMessage, chatMessage), new ai(this, responsedMessage));
            } else if (chatMessage instanceof OfficialChatMessage) {
                com.baidu.tieba.im.i.a(new ak(this, (OfficialChatMessage) chatMessage, chatMessage), new al(this, responsedMessage));
            }
        }
    }

    private void a(ResponseCommitGroupMessage responseCommitGroupMessage) {
        com.baidu.tieba.im.i.a(new am(this, responseCommitGroupMessage), new an(this, responseCommitGroupMessage));
    }

    private void a(ResponseCommitPersonalMessage responseCommitPersonalMessage) {
        com.baidu.tieba.im.i.a(new ao(this, com.baidu.adp.lib.f.b.a(TbadkApplication.getCurrentAccount(), 0L), com.baidu.adp.lib.f.b.a(responseCommitPersonalMessage.getToUserId(), 0L), responseCommitPersonalMessage), new ap(this, responseCommitPersonalMessage));
    }

    private void b(ResponseCommitPersonalMessage responseCommitPersonalMessage) {
        com.baidu.tieba.im.i.a(new aq(this, com.baidu.adp.lib.f.b.a(TbadkApplication.getCurrentAccount(), 0L), com.baidu.adp.lib.f.b.a(responseCommitPersonalMessage.getToUserId(), 0L), responseCommitPersonalMessage), new ar(this, responseCommitPersonalMessage));
    }

    public void a(ResponsedMessage<?> responsedMessage) {
        Iterator<WeakReference<bu>> it = this.c.iterator();
        while (it.hasNext()) {
            bu buVar = it.next().get();
            if (buVar != null) {
                buVar.a(responsedMessage);
            }
        }
    }
}
