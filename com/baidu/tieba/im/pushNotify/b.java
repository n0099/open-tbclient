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
import com.baidu.tieba.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static volatile b blN;
    private List<ImMessageCenterPojo> mList = new LinkedList();
    private final CustomMessageListener aZC = new c(this, 0);

    public static b SX() {
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
        MessageManager.getInstance().registerListener(2016003, this.aZC);
        MessageManager.getInstance().registerListener(2016006, this.aZC);
        MessageManager.getInstance().registerListener(2016000, this.aZC);
        MessageManager.getInstance().registerListener(2016010, this.aZC);
        MessageManager.getInstance().registerListener(2016001, this.aZC);
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
            boolean n = n(data);
            if (memoryChangedMessage.getType() == 1) {
                c(data, this.mList);
            } else if (memoryChangedMessage.getType() == 2) {
                d(data, this.mList);
            }
            bF(n);
        }
    }

    private boolean n(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
            return j.Tq().aF(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return com.baidu.tieba.im.settingcache.c.Tn().aF(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 4) {
            return h.Tp().aF(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
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
                bF(false);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [237=6] */
    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        com.baidu.tbadk.coreExtra.c.h hVar = new com.baidu.tbadk.coreExtra.c.h();
        hVar.aD(z);
        d(hVar);
        hVar.vY();
        hVar.vZ();
        hVar.cK(com.baidu.tbadk.coreExtra.messageCenter.a.uT().vo().ws());
        hVar.cM(com.baidu.tbadk.coreExtra.messageCenter.a.uT().vo().wg());
        hVar.cP(com.baidu.tbadk.coreExtra.messageCenter.a.uT().vo().we());
        hVar.cO(com.baidu.tbadk.coreExtra.messageCenter.a.uT().vo().wd());
        hVar.cN(com.baidu.tbadk.coreExtra.messageCenter.a.uT().vo().wb());
        hVar.cS(com.baidu.tbadk.coreExtra.messageCenter.a.uT().vo().ww());
        d(hVar.wA(), com.baidu.tbadk.coreExtra.messageCenter.a.uT().vo().wA());
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vF()) {
            hVar.cG(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vy()) {
            hVar.cQ(0);
            hVar.cJ(0);
            hVar.cT(0);
            hVar.cV(0);
        }
        if (!TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
            hVar.cV(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vu()) {
            hVar.cU(0);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().vt() <= 0) {
            hVar.cG(0);
            hVar.cQ(0);
            hVar.cT(0);
            hVar.cJ(0);
            hVar.cV(0);
            hVar.cU(0);
            hVar.aD(false);
        }
        if (((((((hVar.ws() + hVar.wa()) + hVar.wb()) + hVar.wd()) + hVar.wy()) + hVar.we()) + hVar.ww()) - hVar.wh() <= 0) {
            hVar.aD(false);
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.uT().b(hVar);
    }

    private void d(List<i> list, List<i> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (i iVar : list) {
                if (iVar != null) {
                    for (i iVar2 : list2) {
                        if (iVar2 != null && iVar.gid == iVar2.gid) {
                            iVar.acL = iVar2.unReadCount;
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
            HashMap<String, String> wo = hVar.wo();
            if (!com.baidu.tieba.im.settingcache.c.Tn().aF(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                hVar.cL(hVar.wh() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    hVar.dv(imMessageCenterPojo.getLast_content());
                } else {
                    hVar.dv(String.valueOf(imMessageCenterPojo.getLast_user_name()) + ":" + imMessageCenterPojo.getLast_content());
                }
                wo.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            hVar.cG(hVar.wa() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && h.Tp().aF(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0) {
            i iVar = new i();
            int userType = imMessageCenterPojo.getUserType();
            iVar.gid = com.baidu.adp.lib.g.c.toInt(imMessageCenterPojo.getGid(), 0);
            iVar.acK = imMessageCenterPojo.getGroup_name();
            if (userType == 4) {
                iVar.title = imMessageCenterPojo.getGroup_name();
                iVar.content = imMessageCenterPojo.getLast_content();
                iVar.acJ = String.valueOf(imMessageCenterPojo.getGroup_name()) + ":" + imMessageCenterPojo.getLast_content();
            } else {
                iVar.content = String.valueOf(TbadkCoreApplication.m411getInst().getContext().getString(y.official_msg_list_name, imMessageCenterPojo.getGroup_name())) + " : " + imMessageCenterPojo.getLast_content();
                iVar.acJ = iVar.content;
            }
            iVar.userType = userType;
            iVar.unReadCount = imMessageCenterPojo.getUnread_count();
            hVar.wA().add(iVar);
            if (userType == 4) {
                hVar.cV(hVar.wB() + imMessageCenterPojo.getUnread_count());
            }
            hVar.cJ(hVar.we() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && j.Tq().aF(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                hVar.dB(imMessageCenterPojo.getLast_content());
                String group_name = imMessageCenterPojo.getGroup_name();
                HashMap<String, String> wu = hVar.wu();
                if (wu != null) {
                    wu.put(imMessageCenterPojo.getGid(), group_name);
                }
            }
            hVar.cQ(hVar.ws() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && l.Tr().isAcceptNotify()) {
            hVar.cU(imMessageCenterPojo.getUnread_count());
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && g.To().isAcceptNotify()) {
            hVar.cT(imMessageCenterPojo.getUnread_count());
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            hVar.cI(imMessageCenterPojo.getUnread_count());
            hVar.dA(imMessageCenterPojo.getLast_content());
            hVar.dx(imMessageCenterPojo.getGroup_name());
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -3) {
            hVar.dy(imMessageCenterPojo.getGroup_name());
            hVar.dz(imMessageCenterPojo.getLast_content());
            hVar.cH(imMessageCenterPojo.getUnread_count());
        }
    }

    private void h(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -5) {
            hVar.cR(imMessageCenterPojo.getUnread_count());
            hVar.dD(imMessageCenterPojo.getGroup_name());
            hVar.dE(imMessageCenterPojo.getLast_content());
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
            return o(imMessageCenterPojo);
        }
        if (imMessageCenterPojo.getCustomGroupType() != -3 && imMessageCenterPojo.getCustomGroupType() != -4 && imMessageCenterPojo.getCustomGroupType() != -5) {
            if (imMessageCenterPojo.getCustomGroupType() == 4) {
                return o(imMessageCenterPojo);
            }
            if (imMessageCenterPojo.getCustomGroupType() == -8) {
                return true;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                return o(imMessageCenterPojo);
            }
            return imMessageCenterPojo.getCustomGroupType() == -7;
        }
        return true;
    }

    private boolean o(ImMessageCenterPojo imMessageCenterPojo) {
        return (imMessageCenterPojo == null || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) ? false : true;
    }
}
