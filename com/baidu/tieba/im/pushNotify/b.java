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
    private static volatile b bkr;
    private List<ImMessageCenterPojo> mList = new LinkedList();
    private final CustomMessageListener aSs = new c(this, 0);

    public static b RJ() {
        if (bkr == null) {
            synchronized (b.class) {
                if (bkr == null) {
                    bkr = new b();
                }
            }
        }
        return bkr;
    }

    private b() {
        registerListener();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(2016003, this.aSs);
        MessageManager.getInstance().registerListener(2016006, this.aSs);
        MessageManager.getInstance().registerListener(2016000, this.aSs);
        MessageManager.getInstance().registerListener(2016010, this.aSs);
        MessageManager.getInstance().registerListener(2016001, this.aSs);
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
            bw(u);
        }
    }

    private boolean u(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
            return j.SY().aE(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return com.baidu.tieba.im.settingcache.c.SV().aE(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 4) {
            return h.SX().aE(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
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
                bw(false);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [232=6] */
    /* JADX INFO: Access modifiers changed from: private */
    public void bw(boolean z) {
        com.baidu.tbadk.coreExtra.c.h hVar = new com.baidu.tbadk.coreExtra.c.h();
        hVar.av(z);
        d(hVar);
        hVar.sr();
        hVar.ss();
        hVar.cC(com.baidu.tbadk.coreExtra.messageCenter.a.rI().sc().sL());
        hVar.cE(com.baidu.tbadk.coreExtra.messageCenter.a.rI().sc().sz());
        hVar.cH(com.baidu.tbadk.coreExtra.messageCenter.a.rI().sc().sx());
        hVar.cG(com.baidu.tbadk.coreExtra.messageCenter.a.rI().sc().sw());
        hVar.cF(com.baidu.tbadk.coreExtra.messageCenter.a.rI().sc().su());
        hVar.cK(com.baidu.tbadk.coreExtra.messageCenter.a.rI().sc().sP());
        c(hVar.sT(), com.baidu.tbadk.coreExtra.messageCenter.a.rI().sc().sT());
        if (!TbadkCoreApplication.m255getInst().isGroupMsgOn()) {
            hVar.cy(0);
        }
        if (!TbadkCoreApplication.m255getInst().isMsgChatOn()) {
            hVar.cI(0);
            hVar.cB(0);
            hVar.cL(0);
            hVar.cN(0);
        }
        if (!TbadkCoreApplication.m255getInst().isStrangerChatOn()) {
            hVar.cM(0);
        }
        if (TbadkCoreApplication.m255getInst().getMsgFrequency() <= 0) {
            hVar.cy(0);
            hVar.cI(0);
            hVar.cL(0);
            hVar.cB(0);
            hVar.cN(0);
            hVar.cM(0);
            hVar.av(false);
        }
        if (((((((hVar.sL() + hVar.st()) + hVar.su()) + hVar.sw()) + hVar.sR()) + hVar.sx()) + hVar.sP()) - hVar.sA() <= 0) {
            hVar.av(false);
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.rI().b(hVar);
    }

    private void c(List<i> list, List<i> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (i iVar : list) {
                if (iVar != null) {
                    for (i iVar2 : list2) {
                        if (iVar2 != null && iVar.gid == iVar2.gid) {
                            iVar.Sh = iVar2.unReadCount;
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
            HashMap<String, String> sH = hVar.sH();
            if (!com.baidu.tieba.im.settingcache.c.SV().aE(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                hVar.cD(hVar.sA() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    hVar.dr(imMessageCenterPojo.getLast_content());
                } else {
                    hVar.dr(String.valueOf(imMessageCenterPojo.getLast_user_name()) + ":" + imMessageCenterPojo.getLast_content());
                }
                sH.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            hVar.cy(hVar.st() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && h.SX().aE(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0) {
            i iVar = new i();
            int userType = imMessageCenterPojo.getUserType();
            iVar.gid = com.baidu.adp.lib.g.c.toInt(imMessageCenterPojo.getGid(), 0);
            iVar.Sg = imMessageCenterPojo.getGroup_name();
            if (userType == 4) {
                iVar.title = imMessageCenterPojo.getGroup_name();
                iVar.content = imMessageCenterPojo.getLast_content();
            } else {
                iVar.content = String.valueOf(TbadkCoreApplication.m255getInst().getContext().getString(z.official_msg_list_name, imMessageCenterPojo.getGroup_name())) + " : " + imMessageCenterPojo.getLast_content();
            }
            iVar.userType = userType;
            iVar.unReadCount = imMessageCenterPojo.getUnread_count();
            hVar.sT().add(iVar);
            if (userType == 4) {
                hVar.cN(hVar.sU() + imMessageCenterPojo.getUnread_count());
            }
            hVar.cB(hVar.sx() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && j.SY().aE(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                hVar.dx(imMessageCenterPojo.getLast_content());
                String group_name = imMessageCenterPojo.getGroup_name();
                HashMap<String, String> sN = hVar.sN();
                if (sN != null) {
                    sN.put(imMessageCenterPojo.getGid(), group_name);
                }
            }
            hVar.cI(hVar.sL() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && l.SZ().isAcceptNotify()) {
            hVar.cM(imMessageCenterPojo.getUnread_count());
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && g.SW().isAcceptNotify()) {
            hVar.cL(imMessageCenterPojo.getUnread_count());
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            hVar.cA(imMessageCenterPojo.getUnread_count());
            hVar.dw(imMessageCenterPojo.getLast_content());
            hVar.dt(imMessageCenterPojo.getGroup_name());
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -3) {
            hVar.du(imMessageCenterPojo.getGroup_name());
            hVar.dv(imMessageCenterPojo.getLast_content());
            hVar.cz(imMessageCenterPojo.getUnread_count());
        }
    }

    private void h(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -5) {
            hVar.cJ(imMessageCenterPojo.getUnread_count());
            hVar.dz(imMessageCenterPojo.getGroup_name());
            hVar.dA(imMessageCenterPojo.getLast_content());
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
