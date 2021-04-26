package com.baidu.tieba.addresslist.relationship;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import d.a.j0.q.f.h;
import d.a.j0.q.f.i;
/* loaded from: classes4.dex */
public class RelationshipStatic {

    /* loaded from: classes4.dex */
    public static class a extends d.a.c.c.g.c {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage == null || socketResponsedMessage.getCmd() != 1001 || socketResponsedMessage.hasError() || !(socketResponsedMessage instanceof ResponseOnlineMessage) || TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getInst().checkInterrupt()) {
                return;
            }
            d.a.i0.r.d0.b j = d.a.i0.r.d0.b.j();
            if (j.g("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true)) {
                MessageManager.getInstance().sendMessage(new RequestGetAddressListMessage(304001));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends d.a.c.c.g.c {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage == null || socketResponsedMessage.getCmd() != 304001 || socketResponsedMessage.hasError() || !(socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
                return;
            }
            d.a.j0.q.f.a addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
            d.a.i0.r.d0.b j = d.a.i0.r.d0.b.j();
            j.t("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), false);
            new i(addressListData).execute(new Void[0]);
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001174 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                    d.a.i0.s.f.a aVar = new d.a.i0.s.f.a();
                    aVar.k(responseNewFriendUpdateUiMsg.getKey());
                    aVar.m(responseNewFriendUpdateUiMsg.getQuanping());
                    aVar.n(responseNewFriendUpdateUiMsg.getFriendId());
                    aVar.o(responseNewFriendUpdateUiMsg.getName());
                    aVar.q(responseNewFriendUpdateUiMsg.getPortrait());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001179, aVar));
                } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                    d.a.i0.s.f.a aVar2 = new d.a.i0.s.f.a();
                    aVar2.n(responseNewFriendUpdateUiMsg.getFriendId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001180, aVar2));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2002014) {
                return;
            }
            h.a();
        }
    }

    static {
        b(304001, ResponseGetAddressListMessage.class, false);
        a(2001178, d.a.j0.q.f.b.class);
        a(2001184, d.a.j0.q.f.c.class);
        a(2001179, d.a.j0.q.f.d.class);
        a(2001180, d.a.j0.q.f.d.class);
        MessageManager.getInstance().registerListener(new a(1001));
        MessageManager.getInstance().registerListener(new b(304001));
        MessageManager.getInstance().registerListener(new c(2001174));
        MessageManager.getInstance().registerListener(new d(2002014));
    }

    public static void a(int i2, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        d.a.j0.e1.c.a(i2, cls);
    }

    public static void b(int i2, Class<? extends SocketResponsedMessage> cls, boolean z) {
        d.a.j0.e1.c.b(i2, cls, z);
    }
}
