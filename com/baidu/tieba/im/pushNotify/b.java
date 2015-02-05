package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.c.i;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.settingcache.g;
import com.baidu.tieba.im.settingcache.h;
import com.baidu.tieba.im.settingcache.j;
import com.baidu.tieba.im.settingcache.l;
import com.baidu.tieba.z;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static volatile b blN;
    private List<ImMessageCenterPojo> mList = new LinkedList();
    private final CustomMessageListener aTB = new c(this, 0);

    public static b Sa() {
        if (blN == null) {
            synchronized (b.class) {
                if (blN == null) {
                    blN = new b();
                }
            }
        }
        return blN;
    }

    private b() {
        registerListener();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(2016003, this.aTB);
        MessageManager.getInstance().registerListener(2016006, this.aTB);
        MessageManager.getInstance().registerListener(2016000, this.aTB);
        MessageManager.getInstance().registerListener(2016010, this.aTB);
        MessageManager.getInstance().registerListener(2016001, this.aTB);
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
            boolean u = u(data);
            if (memoryChangedMessage.getType() == 1) {
                c(data, this.mList);
            } else if (memoryChangedMessage.getType() == 2) {
                d(data, this.mList);
            }
            bz(u);
        }
    }

    private boolean u(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
            return j.Tp().aH(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return com.baidu.tieba.im.settingcache.c.Tm().aH(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 4) {
            return h.To().aH(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        return imMessageCenterPojo.getCustomGroupType() == -3 || imMessageCenterPojo.getCustomGroupType() == -4 || imMessageCenterPojo.getCustomGroupType() == -5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1) {
                this.mList.clear();
                for (ImMessageCenterPojo imMessageCenterPojo : data) {
                    if (isNeed(imMessageCenterPojo)) {
                        this.mList.add(imMessageCenterPojo);
                    }
                }
                bz(false);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [232=6] */
    /* JADX INFO: Access modifiers changed from: private */
    public void bz(boolean z) {
        com.baidu.tbadk.coreExtra.c.h hVar = new com.baidu.tbadk.coreExtra.c.h();
        hVar.ax(z);
        d(hVar);
        hVar.sC();
        hVar.sD();
        hVar.cJ(com.baidu.tbadk.coreExtra.messageCenter.a.rS().sm().sW());
        hVar.cL(com.baidu.tbadk.coreExtra.messageCenter.a.rS().sm().sK());
        hVar.cO(com.baidu.tbadk.coreExtra.messageCenter.a.rS().sm().sI());
        hVar.cN(com.baidu.tbadk.coreExtra.messageCenter.a.rS().sm().sH());
        hVar.cM(com.baidu.tbadk.coreExtra.messageCenter.a.rS().sm().sF());
        hVar.cR(com.baidu.tbadk.coreExtra.messageCenter.a.rS().sm().ta());
        c(hVar.te(), com.baidu.tbadk.coreExtra.messageCenter.a.rS().sm().te());
        if (!TbadkCoreApplication.m255getInst().isGroupMsgOn()) {
            hVar.cF(0);
        }
        if (!TbadkCoreApplication.m255getInst().isMsgChatOn()) {
            hVar.cP(0);
            hVar.cI(0);
            hVar.cS(0);
            hVar.cU(0);
        }
        if (!TbadkCoreApplication.m255getInst().isStrangerChatOn()) {
            hVar.cT(0);
        }
        if (TbadkCoreApplication.m255getInst().getMsgFrequency() <= 0) {
            hVar.cF(0);
            hVar.cP(0);
            hVar.cS(0);
            hVar.cI(0);
            hVar.cU(0);
            hVar.cT(0);
            hVar.ax(false);
        }
        if (((((((hVar.sW() + hVar.sE()) + hVar.sF()) + hVar.sH()) + hVar.tc()) + hVar.sI()) + hVar.ta()) - hVar.sL() <= 0) {
            hVar.ax(false);
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.rS().b(hVar);
    }

    private void c(List<i> list, List<i> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (i iVar : list) {
                if (iVar != null) {
                    for (i iVar2 : list2) {
                        if (iVar2 != null && iVar.gid == iVar2.gid) {
                            iVar.SH = iVar2.unReadCount;
                        }
                    }
                }
            }
        }
    }

    private void d(com.baidu.tbadk.coreExtra.c.h hVar) {
        if (hVar != null) {
            for (ImMessageCenterPojo imMessageCenterPojo : this.mList) {
                if (imMessageCenterPojo != null && imMessageCenterPojo.getIs_hidden() != 1 && isNeed(imMessageCenterPojo)) {
                    a(imMessageCenterPojo, hVar);
                    b(imMessageCenterPojo, hVar);
                    c(imMessageCenterPojo, hVar);
                    f(imMessageCenterPojo, hVar);
                    g(imMessageCenterPojo, hVar);
                    h(imMessageCenterPojo, hVar);
                    e(imMessageCenterPojo, hVar);
                    d(imMessageCenterPojo, hVar);
                }
            }
        }
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 1) {
            HashMap<String, String> sS = hVar.sS();
            if (!com.baidu.tieba.im.settingcache.c.Tm().aH(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                hVar.cK(hVar.sL() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    hVar.dm(imMessageCenterPojo.getLast_content());
                } else {
                    hVar.dm(String.valueOf(imMessageCenterPojo.getLast_user_name()) + ":" + imMessageCenterPojo.getLast_content());
                }
                sS.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            hVar.cF(hVar.sE() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && h.To().aH(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0) {
            i iVar = new i();
            int userType = imMessageCenterPojo.getUserType();
            iVar.gid = com.baidu.adp.lib.g.c.toInt(imMessageCenterPojo.getGid(), 0);
            iVar.SG = imMessageCenterPojo.getGroup_name();
            if (userType == 4) {
                iVar.title = imMessageCenterPojo.getGroup_name();
                iVar.content = imMessageCenterPojo.getLast_content();
            } else {
                iVar.content = String.valueOf(TbadkCoreApplication.m255getInst().getContext().getString(z.official_msg_list_name, imMessageCenterPojo.getGroup_name())) + " : " + imMessageCenterPojo.getLast_content();
            }
            iVar.userType = userType;
            iVar.unReadCount = imMessageCenterPojo.getUnread_count();
            hVar.te().add(iVar);
            if (userType == 4) {
                hVar.cU(hVar.tf() + imMessageCenterPojo.getUnread_count());
            }
            hVar.cI(hVar.sI() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && j.Tp().aH(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                hVar.dt(imMessageCenterPojo.getLast_content());
                String group_name = imMessageCenterPojo.getGroup_name();
                HashMap<String, String> sY = hVar.sY();
                if (sY != null) {
                    sY.put(imMessageCenterPojo.getGid(), group_name);
                }
            }
            hVar.cP(hVar.sW() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && l.Tq().isAcceptNotify()) {
            hVar.cT(imMessageCenterPojo.getUnread_count());
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && g.Tn().isAcceptNotify()) {
            hVar.cS(imMessageCenterPojo.getUnread_count());
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            hVar.cH(imMessageCenterPojo.getUnread_count());
            hVar.ds(imMessageCenterPojo.getLast_content());
            hVar.dp(imMessageCenterPojo.getGroup_name());
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -3) {
            hVar.dq(imMessageCenterPojo.getGroup_name());
            hVar.dr(imMessageCenterPojo.getLast_content());
            hVar.cG(imMessageCenterPojo.getUnread_count());
        }
    }

    private void h(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -5) {
            hVar.cQ(imMessageCenterPojo.getUnread_count());
            hVar.dv(imMessageCenterPojo.getGroup_name());
            hVar.dw(imMessageCenterPojo.getLast_content());
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, List<ImMessageCenterPojo> list) {
        if (imMessageCenterPojo != null && list != null) {
            d(imMessageCenterPojo, list);
            list.add(imMessageCenterPojo);
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, List<ImMessageCenterPojo> list) {
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
            return v(imMessageCenterPojo);
        }
        if (imMessageCenterPojo.getCustomGroupType() != -3 && imMessageCenterPojo.getCustomGroupType() != -4 && imMessageCenterPojo.getCustomGroupType() != -5) {
            if (imMessageCenterPojo.getCustomGroupType() == 4) {
                return v(imMessageCenterPojo);
            }
            if (imMessageCenterPojo.getCustomGroupType() == -8) {
                return true;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                return v(imMessageCenterPojo);
            }
            return imMessageCenterPojo.getCustomGroupType() == -7;
        }
        return true;
    }

    private boolean v(ImMessageCenterPojo imMessageCenterPojo) {
        return (imMessageCenterPojo == null || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) ? false : true;
    }
}
