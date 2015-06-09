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
import com.baidu.tieba.t;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static volatile b boI;
    private List<ImMessageCenterPojo> mList = new LinkedList();
    private final CustomMessageListener bcA = new c(this, 0);

    public static b Uy() {
        if (boI == null) {
            synchronized (b.class) {
                if (boI == null) {
                    boI = new b();
                }
            }
        }
        return boI;
    }

    private b() {
        registerListener();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(2016004, this.bcA);
        MessageManager.getInstance().registerListener(2016007, this.bcA);
        MessageManager.getInstance().registerListener(2016001, this.bcA);
        MessageManager.getInstance().registerListener(2016010, this.bcA);
        MessageManager.getInstance().registerListener(2016002, this.bcA);
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
            bO(n);
        }
    }

    private boolean n(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
            return j.UR().aK(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return com.baidu.tieba.im.settingcache.c.UO().aK(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 4) {
            return h.UQ().aK(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        return imMessageCenterPojo.getCustomGroupType() == -3 || imMessageCenterPojo.getCustomGroupType() == -4 || imMessageCenterPojo.getCustomGroupType() == -5 || imMessageCenterPojo.getCustomGroupType() == -10;
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
                bO(false);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [243=7] */
    /* JADX INFO: Access modifiers changed from: private */
    public void bO(boolean z) {
        com.baidu.tbadk.coreExtra.c.h hVar = new com.baidu.tbadk.coreExtra.c.h();
        hVar.aK(z);
        d(hVar);
        hVar.wP();
        hVar.wQ();
        hVar.cR(com.baidu.tbadk.coreExtra.messageCenter.a.vJ().we().xj());
        hVar.cT(com.baidu.tbadk.coreExtra.messageCenter.a.vJ().we().wX());
        hVar.cW(com.baidu.tbadk.coreExtra.messageCenter.a.vJ().we().wV());
        hVar.cV(com.baidu.tbadk.coreExtra.messageCenter.a.vJ().we().wU());
        hVar.cU(com.baidu.tbadk.coreExtra.messageCenter.a.vJ().we().wS());
        hVar.cZ(com.baidu.tbadk.coreExtra.messageCenter.a.vJ().we().xn());
        e(hVar.xt(), com.baidu.tbadk.coreExtra.messageCenter.a.vJ().we().xt());
        hVar.dd(com.baidu.tbadk.coreExtra.messageCenter.a.vJ().we().xr());
        f(hVar.xu(), com.baidu.tbadk.coreExtra.messageCenter.a.vJ().we().xu());
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wv()) {
            hVar.cN(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wo()) {
            hVar.cX(0);
            hVar.cQ(0);
            hVar.da(0);
            hVar.de(0);
        }
        if (!TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
            hVar.de(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wk()) {
            hVar.db(0);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wj() <= 0) {
            hVar.cN(0);
            hVar.cX(0);
            hVar.da(0);
            hVar.cQ(0);
            hVar.de(0);
            hVar.db(0);
            hVar.dc(0);
            hVar.aK(false);
        }
        if ((((((((hVar.xj() + hVar.wR()) + hVar.wS()) + hVar.wU()) + hVar.xp()) + hVar.wV()) + hVar.xn()) + hVar.xr()) - hVar.wY() <= 0) {
            hVar.aK(false);
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.vJ().b(hVar);
    }

    private void e(List<com.baidu.tbadk.coreExtra.c.j> list, List<com.baidu.tbadk.coreExtra.c.j> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (com.baidu.tbadk.coreExtra.c.j jVar : list) {
                if (jVar != null) {
                    for (com.baidu.tbadk.coreExtra.c.j jVar2 : list2) {
                        if (jVar2 != null && jVar.gid == jVar2.gid) {
                            jVar.adZ = jVar2.unReadCount;
                        }
                    }
                }
            }
        }
    }

    private void f(List<i> list, List<i> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (i iVar : list) {
                if (iVar != null) {
                    for (i iVar2 : list2) {
                        if (iVar2 != null && iVar.gid == iVar2.gid) {
                            iVar.adZ = iVar2.unReadCount;
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
                    b(imMessageCenterPojo, hVar);
                    c(imMessageCenterPojo, hVar);
                    a(imMessageCenterPojo, hVar);
                    d(imMessageCenterPojo, hVar);
                    g(imMessageCenterPojo, hVar);
                    h(imMessageCenterPojo, hVar);
                    i(imMessageCenterPojo, hVar);
                    f(imMessageCenterPojo, hVar);
                    e(imMessageCenterPojo, hVar);
                }
            }
        }
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -10 && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0) {
            i iVar = new i();
            iVar.gid = com.baidu.adp.lib.g.c.toInt(imMessageCenterPojo.getGid(), 0);
            iVar.groupName = imMessageCenterPojo.getGroup_name();
            String string = TbadkCoreApplication.m411getInst().getResources().getString(t.live_chat_room_more_livenotify);
            String string2 = TbadkCoreApplication.m411getInst().getResources().getString(t.living_vip_msg_start, imMessageCenterPojo.getGroup_name());
            iVar.title = string;
            iVar.content = string2;
            iVar.unReadCount = imMessageCenterPojo.getUnread_count();
            hVar.xu().add(iVar);
            hVar.dc(hVar.xr() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 1) {
            HashMap<String, String> xf = hVar.xf();
            if (!com.baidu.tieba.im.settingcache.c.UO().aK(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                hVar.cS(hVar.wY() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    hVar.dP(imMessageCenterPojo.getLast_content());
                } else {
                    hVar.dP(String.valueOf(imMessageCenterPojo.getLast_user_name()) + ":" + imMessageCenterPojo.getLast_content());
                }
                xf.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            hVar.cN(hVar.wR() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && h.UQ().aK(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0) {
            com.baidu.tbadk.coreExtra.c.j jVar = new com.baidu.tbadk.coreExtra.c.j();
            int userType = imMessageCenterPojo.getUserType();
            jVar.gid = com.baidu.adp.lib.g.c.toInt(imMessageCenterPojo.getGid(), 0);
            jVar.aeb = imMessageCenterPojo.getGroup_name();
            if (userType == 4) {
                jVar.title = imMessageCenterPojo.getGroup_name();
                jVar.content = imMessageCenterPojo.getLast_content();
                jVar.aea = String.valueOf(imMessageCenterPojo.getGroup_name()) + ":" + imMessageCenterPojo.getLast_content();
            } else {
                jVar.content = String.valueOf(TbadkCoreApplication.m411getInst().getContext().getString(t.official_msg_list_name, imMessageCenterPojo.getGroup_name())) + " : " + imMessageCenterPojo.getLast_content();
                jVar.aea = jVar.content;
            }
            jVar.userType = userType;
            jVar.unReadCount = imMessageCenterPojo.getUnread_count();
            hVar.xt().add(jVar);
            if (userType == 4) {
                hVar.de(hVar.xv() + imMessageCenterPojo.getUnread_count());
            }
            hVar.cQ(hVar.wV() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && j.UR().aK(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                hVar.dV(imMessageCenterPojo.getLast_content());
                String group_name = imMessageCenterPojo.getGroup_name();
                HashMap<String, String> xl = hVar.xl();
                if (xl != null) {
                    xl.put(imMessageCenterPojo.getGid(), group_name);
                }
            }
            hVar.cX(hVar.xj() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && l.US().isAcceptNotify()) {
            hVar.db(imMessageCenterPojo.getUnread_count());
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && g.UP().isAcceptNotify()) {
            hVar.da(imMessageCenterPojo.getUnread_count());
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            hVar.cP(imMessageCenterPojo.getUnread_count());
            hVar.dU(imMessageCenterPojo.getLast_content());
            hVar.dR(imMessageCenterPojo.getGroup_name());
        }
    }

    private void h(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -3) {
            hVar.dS(imMessageCenterPojo.getGroup_name());
            hVar.dT(imMessageCenterPojo.getLast_content());
            hVar.cO(imMessageCenterPojo.getUnread_count());
        }
    }

    private void i(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.h hVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -5) {
            hVar.cY(imMessageCenterPojo.getUnread_count());
            hVar.dX(imMessageCenterPojo.getGroup_name());
            hVar.dY(imMessageCenterPojo.getLast_content());
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
            return imMessageCenterPojo.getCustomGroupType() == -7 || imMessageCenterPojo.getCustomGroupType() == -10;
        }
        return true;
    }

    private boolean o(ImMessageCenterPojo imMessageCenterPojo) {
        return (imMessageCenterPojo == null || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) ? false : true;
    }
}
