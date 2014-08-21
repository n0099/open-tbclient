package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.chat.officialBar.ay;
import com.baidu.tieba.im.chat.officialBar.az;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupInfo.y;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static volatile d a;
    private List<ImMessageCenterPojo> b = new LinkedList();
    private final CustomMessageListener c = new e(this, 0);

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    private d() {
        b();
    }

    private void b() {
        MessageManager.getInstance().registerListener(2016003, this.c);
        MessageManager.getInstance().registerListener(2016006, this.c);
        MessageManager.getInstance().registerListener(2016000, this.c);
        MessageManager.getInstance().registerListener(2016010, this.c);
        MessageManager.getInstance().registerListener(2016001, this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            boolean a2 = a(data);
            if (memoryChangedMessage.getType() == 1) {
                a(data, this.b);
            } else if (memoryChangedMessage.getType() == 2) {
                b(data, this.b);
            }
            a(a2);
        }
    }

    private boolean a(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
            return com.baidu.tieba.im.chat.personaltalk.a.a().c(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return y.a().c(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 4) {
            return az.a().c(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        return imMessageCenterPojo.getCustomGroupType() == -3 || imMessageCenterPojo.getCustomGroupType() == -4 || imMessageCenterPojo.getCustomGroupType() == -5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1) {
                this.b.clear();
                for (ImMessageCenterPojo imMessageCenterPojo : data) {
                    if (b(imMessageCenterPojo)) {
                        this.b.add(imMessageCenterPojo);
                    }
                }
                a(false);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [218=5] */
    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        com.baidu.tbadk.coreExtra.b.c cVar = new com.baidu.tbadk.coreExtra.b.c();
        cVar.a(z);
        a(cVar);
        cVar.a();
        cVar.b();
        cVar.e(com.baidu.tbadk.coreExtra.messageCenter.a.a().u().w());
        cVar.g(com.baidu.tbadk.coreExtra.messageCenter.a.a().u().i());
        cVar.j(com.baidu.tbadk.coreExtra.messageCenter.a.a().u().g());
        cVar.i(com.baidu.tbadk.coreExtra.messageCenter.a.a().u().f());
        cVar.h(com.baidu.tbadk.coreExtra.messageCenter.a.a().u().d());
        cVar.m(com.baidu.tbadk.coreExtra.messageCenter.a.a().u().A());
        if (!TbadkApplication.m252getInst().isGroupMsgOn()) {
            cVar.a(0);
        }
        if (!TbadkApplication.m252getInst().isMsgChatOn()) {
            cVar.k(0);
            cVar.d(0);
            cVar.n(0);
        }
        if (TbadkApplication.m252getInst().getMsgFrequency() <= 0) {
            cVar.a(0);
            cVar.k(0);
            cVar.n(0);
            cVar.d(0);
            cVar.a(false);
        }
        if ((((((cVar.w() + cVar.c()) + cVar.d()) + cVar.f()) + cVar.C()) + cVar.A()) - cVar.l() <= 0) {
            cVar.a(false);
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.a().b(cVar);
    }

    private void a(com.baidu.tbadk.coreExtra.b.c cVar) {
        if (cVar != null) {
            for (ImMessageCenterPojo imMessageCenterPojo : this.b) {
                if (imMessageCenterPojo != null && imMessageCenterPojo.getIs_hidden() != 1 && b(imMessageCenterPojo)) {
                    a(imMessageCenterPojo, cVar);
                    b(imMessageCenterPojo, cVar);
                    c(imMessageCenterPojo, cVar);
                    e(imMessageCenterPojo, cVar);
                    f(imMessageCenterPojo, cVar);
                    g(imMessageCenterPojo, cVar);
                    d(imMessageCenterPojo, cVar);
                }
            }
        }
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.b.c cVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 1) {
            HashMap<String, String> s = cVar.s();
            if (!y.a().c(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                cVar.f(cVar.l() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                cVar.c(imMessageCenterPojo.getLast_content());
                s.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            cVar.a(cVar.c() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.b.c cVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && az.a().c(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            cVar.a(imMessageCenterPojo.getGroup_name());
            if (imMessageCenterPojo.isSelf()) {
                cVar.b(imMessageCenterPojo.getLast_content());
            } else {
                cVar.b(String.valueOf(TbadkApplication.m252getInst().getContext().getString(x.official_msg_list_name, imMessageCenterPojo.getGroup_name())) + ":" + imMessageCenterPojo.getLast_content());
            }
            cVar.d(cVar.g() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.b.c cVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && com.baidu.tieba.im.chat.personaltalk.a.a().c(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                cVar.i(imMessageCenterPojo.getLast_content());
                String group_name = imMessageCenterPojo.getGroup_name();
                HashMap<String, String> y = cVar.y();
                if (y != null) {
                    y.put(imMessageCenterPojo.getGid(), group_name);
                }
            }
            cVar.k(cVar.w() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.b.c cVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && ay.a().b()) {
            cVar.n(imMessageCenterPojo.getUnread_count());
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.b.c cVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            cVar.c(imMessageCenterPojo.getUnread_count());
            cVar.h(imMessageCenterPojo.getLast_content());
            cVar.e(imMessageCenterPojo.getGroup_name());
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.b.c cVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -3) {
            cVar.f(imMessageCenterPojo.getGroup_name());
            cVar.g(imMessageCenterPojo.getLast_content());
            cVar.b(imMessageCenterPojo.getUnread_count());
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.b.c cVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -5) {
            cVar.l(imMessageCenterPojo.getUnread_count());
            cVar.k(imMessageCenterPojo.getGroup_name());
            cVar.l(imMessageCenterPojo.getLast_content());
        }
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, List<ImMessageCenterPojo> list) {
        if (imMessageCenterPojo != null && list != null) {
            b(imMessageCenterPojo, list);
            list.add(imMessageCenterPojo);
        }
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo, List<ImMessageCenterPojo> list) {
        if (imMessageCenterPojo != null && list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ImMessageCenterPojo imMessageCenterPojo2 = list.get(i);
                if (imMessageCenterPojo2 != null && imMessageCenterPojo2.getGid().equals(imMessageCenterPojo.getGid()) && imMessageCenterPojo2.getCustomGroupType() == imMessageCenterPojo.getCustomGroupType()) {
                    list.remove(i);
                    return;
                }
            }
        }
    }

    private boolean b(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return c(imMessageCenterPojo);
        }
        if (imMessageCenterPojo.getCustomGroupType() != -3 && imMessageCenterPojo.getCustomGroupType() != -4 && imMessageCenterPojo.getCustomGroupType() != -5) {
            if (imMessageCenterPojo.getCustomGroupType() == 4) {
                return c(imMessageCenterPojo);
            }
            if (imMessageCenterPojo.getCustomGroupType() == -8) {
                return true;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                return c(imMessageCenterPojo);
            }
            return false;
        }
        return true;
    }

    private boolean c(ImMessageCenterPojo imMessageCenterPojo) {
        return (imMessageCenterPojo == null || TextUtils.isEmpty(imMessageCenterPojo.getGroup_head()) || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) ? false : true;
    }
}
