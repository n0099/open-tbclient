package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.chat.officialBar.aw;
import com.baidu.tieba.im.chat.officialBar.ax;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupInfo.aa;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static volatile d bhz;
    private List<ImMessageCenterPojo> WB = new LinkedList();
    private final CustomMessageListener aQO = new e(this, 0);

    public static d Rp() {
        if (bhz == null) {
            synchronized (d.class) {
                if (bhz == null) {
                    bhz = new d();
                }
            }
        }
        return bhz;
    }

    private d() {
        registerListener();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(2016003, this.aQO);
        MessageManager.getInstance().registerListener(2016006, this.aQO);
        MessageManager.getInstance().registerListener(2016000, this.aQO);
        MessageManager.getInstance().registerListener(2016010, this.aQO);
        MessageManager.getInstance().registerListener(2016001, this.aQO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            boolean m = m(data);
            if (memoryChangedMessage.getType() == 1) {
                b(data, this.WB);
            } else if (memoryChangedMessage.getType() == 2) {
                c(data, this.WB);
            }
            bE(m);
        }
    }

    private boolean m(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
            return com.baidu.tieba.im.chat.personaltalk.c.KJ().av(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return aa.Pe().av(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 4) {
            return ax.KE().av(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        return imMessageCenterPojo.getCustomGroupType() == -3 || imMessageCenterPojo.getCustomGroupType() == -4 || imMessageCenterPojo.getCustomGroupType() == -5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1) {
                this.WB.clear();
                for (ImMessageCenterPojo imMessageCenterPojo : data) {
                    if (isNeed(imMessageCenterPojo)) {
                        this.WB.add(imMessageCenterPojo);
                    }
                }
                bE(false);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [218=6] */
    /* JADX INFO: Access modifiers changed from: private */
    public void bE(boolean z) {
        com.baidu.tbadk.coreExtra.b.c cVar = new com.baidu.tbadk.coreExtra.b.c();
        cVar.ah(z);
        d(cVar);
        cVar.oY();
        cVar.oZ();
        cVar.ce(com.baidu.tbadk.coreExtra.messageCenter.a.oD().oW().pu());
        cVar.cg(com.baidu.tbadk.coreExtra.messageCenter.a.oD().oW().pg());
        cVar.cj(com.baidu.tbadk.coreExtra.messageCenter.a.oD().oW().pe());
        cVar.ci(com.baidu.tbadk.coreExtra.messageCenter.a.oD().oW().pd());
        cVar.ch(com.baidu.tbadk.coreExtra.messageCenter.a.oD().oW().pb());
        cVar.cm(com.baidu.tbadk.coreExtra.messageCenter.a.oD().oW().py());
        if (!TbadkApplication.m251getInst().isGroupMsgOn()) {
            cVar.ca(0);
        }
        if (!TbadkApplication.m251getInst().isMsgChatOn()) {
            cVar.ck(0);
            cVar.cd(0);
            cVar.cn(0);
        }
        if (TbadkApplication.m251getInst().getMsgFrequency() <= 0) {
            cVar.ca(0);
            cVar.ck(0);
            cVar.cn(0);
            cVar.cd(0);
            cVar.ah(false);
        }
        if (((((((cVar.pu() + cVar.pa()) + cVar.pb()) + cVar.pd()) + cVar.pA()) + cVar.pe()) + cVar.py()) - cVar.pj() <= 0) {
            cVar.ah(false);
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.oD().b(cVar);
    }

    private void d(com.baidu.tbadk.coreExtra.b.c cVar) {
        if (cVar != null) {
            for (ImMessageCenterPojo imMessageCenterPojo : this.WB) {
                if (imMessageCenterPojo != null && imMessageCenterPojo.getIs_hidden() != 1 && isNeed(imMessageCenterPojo)) {
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
            HashMap<String, String> pq = cVar.pq();
            if (!aa.Pe().av(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                cVar.cf(cVar.pj() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    cVar.cu(imMessageCenterPojo.getLast_content());
                } else {
                    cVar.cu(String.valueOf(imMessageCenterPojo.getLast_user_name()) + ":" + imMessageCenterPojo.getLast_content());
                }
                pq.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            cVar.ca(cVar.pa() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.b.c cVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && ax.KE().av(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            cVar.cs(null);
            cVar.ct(String.valueOf(TbadkApplication.m251getInst().getContext().getString(y.official_msg_list_name, imMessageCenterPojo.getGroup_name())) + ":" + imMessageCenterPojo.getLast_content());
            cVar.cd(cVar.pe() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.b.c cVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && com.baidu.tieba.im.chat.personaltalk.c.KJ().av(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                cVar.cA(imMessageCenterPojo.getLast_content());
                String group_name = imMessageCenterPojo.getGroup_name();
                HashMap<String, String> pw = cVar.pw();
                if (pw != null) {
                    pw.put(imMessageCenterPojo.getGid(), group_name);
                }
            }
            cVar.ck(cVar.pu() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.b.c cVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && aw.KD().isAcceptNotify()) {
            cVar.cn(imMessageCenterPojo.getUnread_count());
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.b.c cVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            cVar.cc(imMessageCenterPojo.getUnread_count());
            cVar.cz(imMessageCenterPojo.getLast_content());
            cVar.cw(imMessageCenterPojo.getGroup_name());
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.b.c cVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -3) {
            cVar.cx(imMessageCenterPojo.getGroup_name());
            cVar.cy(imMessageCenterPojo.getLast_content());
            cVar.cb(imMessageCenterPojo.getUnread_count());
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.b.c cVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -5) {
            cVar.cl(imMessageCenterPojo.getUnread_count());
            cVar.cC(imMessageCenterPojo.getGroup_name());
            cVar.cD(imMessageCenterPojo.getLast_content());
        }
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo, List<ImMessageCenterPojo> list) {
        if (imMessageCenterPojo != null && list != null) {
            c(imMessageCenterPojo, list);
            list.add(imMessageCenterPojo);
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, List<ImMessageCenterPojo> list) {
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

    private boolean isNeed(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return n(imMessageCenterPojo);
        }
        if (imMessageCenterPojo.getCustomGroupType() != -3 && imMessageCenterPojo.getCustomGroupType() != -4 && imMessageCenterPojo.getCustomGroupType() != -5) {
            if (imMessageCenterPojo.getCustomGroupType() == 4) {
                return n(imMessageCenterPojo);
            }
            if (imMessageCenterPojo.getCustomGroupType() == -8) {
                return true;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                return n(imMessageCenterPojo);
            }
            return false;
        }
        return true;
    }

    private boolean n(ImMessageCenterPojo imMessageCenterPojo) {
        return (imMessageCenterPojo == null || TextUtils.isEmpty(imMessageCenterPojo.getGroup_head()) || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) ? false : true;
    }
}
