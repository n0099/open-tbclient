package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
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
public class w {
    private final LinkedList<WeakReference<bt>> c = new LinkedList<>();
    private com.baidu.adp.framework.listener.b d = new x(this, 0);
    private CustomMessageListener e = new ai(this, 0);
    private static w b = null;
    public static volatile int a = 0;

    private w() {
    }

    public void a() {
        MessageManager.getInstance().registerListener(202001, this.d);
        MessageManager.getInstance().registerListener(205001, this.d);
        MessageManager.getInstance().registerListener(2001103, this.e);
        MessageManager.getInstance().registerListener(2001105, this.e);
    }

    public static w b() {
        if (b == null) {
            b = new w();
        }
        return b;
    }

    public static void a(int i) {
        if (i != 0 && a != i) {
            a = i;
            com.baidu.tieba.im.i.a(new ar(i), null);
        }
    }

    public void a(bt btVar) {
        Iterator<WeakReference<bt>> it = this.c.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().get() == btVar) {
                z = true;
            }
        }
        if (!z) {
            this.c.add(new WeakReference<>(btVar));
        }
    }

    public void b(bt btVar) {
        WeakReference<bt> weakReference;
        Iterator<WeakReference<bt>> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                weakReference = null;
                break;
            }
            weakReference = it.next();
            if (weakReference.get() == btVar) {
                break;
            }
        }
        if (weakReference != null) {
            this.c.remove(weakReference);
        }
    }

    public void a(String str, bu buVar) {
        com.baidu.tieba.im.i.a(new as(this, str), new at(this, buVar));
    }

    public void b(String str, bu buVar) {
        com.baidu.tieba.im.i.a(new au(this, str), new av(this, buVar));
    }

    public void c(String str, bu buVar) {
        com.baidu.tieba.im.i.a(new aw(this, str), new ax(this, buVar));
    }

    public void a(ChatMessage chatMessage) {
        if (chatMessage instanceof CommonGroupChatMessage) {
            CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
            LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            com.baidu.tieba.im.i.a(new y(this, commonGroupChatMessage, linkedList), new z(this, commonGroupChatMessage));
        } else if (chatMessage instanceof PersonalChatMessage) {
            PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
            LinkedList linkedList2 = new LinkedList();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(chatMessage);
            commonMsgPojo2.setRead_flag(0);
            linkedList2.add(commonMsgPojo2);
            com.baidu.tieba.im.i.a(new aa(this, personalChatMessage, linkedList2), new ab(this, personalChatMessage));
        } else if (chatMessage instanceof OfficialChatMessage) {
            OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
            LinkedList linkedList3 = new LinkedList();
            CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(chatMessage);
            commonMsgPojo3.setRead_flag(0);
            linkedList3.add(commonMsgPojo3);
            com.baidu.tieba.im.i.a(new ac(this, officialChatMessage, linkedList3), new ad(this, officialChatMessage));
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
            if (responseCommitPersonalMessage.getError() != 0) {
                b((ResponsedMessage<?>) responseCommitPersonalMessage);
                return;
            }
            a(com.baidu.adp.lib.f.b.a(responseCommitPersonalMessage.getGroupId(), 0));
            if (responseCommitPersonalMessage.getToUserType() == 0) {
                a(responseCommitPersonalMessage);
            } else {
                b(responseCommitPersonalMessage);
            }
        }
    }

    private void b(ResponsedMessage<?> responsedMessage) {
        ChatMessage chatMessage;
        if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && (chatMessage = (ChatMessage) responsedMessage.getOrginalMessage()) != null) {
            if (chatMessage instanceof CommonGroupChatMessage) {
                com.baidu.tieba.im.i.a(new ae(this, (CommonGroupChatMessage) chatMessage, chatMessage), new af(this, responsedMessage));
            } else if (chatMessage instanceof PersonalChatMessage) {
                com.baidu.tieba.im.i.a(new ag(this, (PersonalChatMessage) chatMessage, chatMessage), new ah(this, responsedMessage));
            } else if (chatMessage instanceof OfficialChatMessage) {
                com.baidu.tieba.im.i.a(new aj(this, (OfficialChatMessage) chatMessage, chatMessage), new ak(this, responsedMessage));
            }
        }
    }

    private void a(ResponseCommitGroupMessage responseCommitGroupMessage) {
        com.baidu.tieba.im.i.a(new al(this, responseCommitGroupMessage), new am(this, responseCommitGroupMessage));
    }

    private void a(ResponseCommitPersonalMessage responseCommitPersonalMessage) {
        com.baidu.tieba.im.i.a(new an(this, com.baidu.adp.lib.f.b.a(TbadkApplication.getCurrentAccount(), 0L), com.baidu.adp.lib.f.b.a(responseCommitPersonalMessage.getToUserId(), 0L), responseCommitPersonalMessage), new ao(this, responseCommitPersonalMessage));
    }

    private void b(ResponseCommitPersonalMessage responseCommitPersonalMessage) {
        com.baidu.tieba.im.i.a(new ap(this, com.baidu.adp.lib.f.b.a(TbadkApplication.getCurrentAccount(), 0L), com.baidu.adp.lib.f.b.a(responseCommitPersonalMessage.getToUserId(), 0L), responseCommitPersonalMessage), new aq(this, responseCommitPersonalMessage));
    }

    public void a(ResponsedMessage<?> responsedMessage) {
        Iterator<WeakReference<bt>> it = this.c.iterator();
        while (it.hasNext()) {
            bt btVar = it.next().get();
            if (btVar != null) {
                btVar.a(responsedMessage);
            }
        }
    }
}
