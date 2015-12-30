package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.d.e;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.settingcache.g;
import com.baidu.tieba.im.settingcache.h;
import com.baidu.tieba.im.settingcache.j;
import com.baidu.tieba.im.settingcache.l;
import com.baidu.tieba.n;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static volatile b bZP;
    private List<ImMessageCenterPojo> mList = new LinkedList();
    private final CustomMessageListener bNr = new c(this, 0);

    public static b abv() {
        if (bZP == null) {
            synchronized (b.class) {
                if (bZP == null) {
                    bZP = new b();
                }
            }
        }
        return bZP;
    }

    private b() {
        registerListener();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.bNr);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.bNr);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CLEAR, this.bNr);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.bNr);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.bNr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            boolean n = n(data);
            if (memoryChangedMessage.getType() == 1) {
                c(data, this.mList);
            } else if (memoryChangedMessage.getType() == 2) {
                d(data, this.mList);
            }
            ci(n);
        }
    }

    private boolean n(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
            return j.abO().aK(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return com.baidu.tieba.im.settingcache.c.abL().aK(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 4) {
            return h.abN().aK(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        return imMessageCenterPojo.getCustomGroupType() == -3 || imMessageCenterPojo.getCustomGroupType() == -4 || imMessageCenterPojo.getCustomGroupType() == -5 || imMessageCenterPojo.getCustomGroupType() == -10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
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
                ci(false);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [239=7] */
    /* JADX INFO: Access modifiers changed from: private */
    public void ci(boolean z) {
        com.baidu.tbadk.coreExtra.d.e eVar = new com.baidu.tbadk.coreExtra.d.e();
        eVar.aQ(z);
        d(eVar);
        eVar.yz();
        eVar.yA();
        eVar.ds(com.baidu.tbadk.coreExtra.messageCenter.a.xv().xQ().yT());
        eVar.du(com.baidu.tbadk.coreExtra.messageCenter.a.xv().xQ().yH());
        eVar.dx(com.baidu.tbadk.coreExtra.messageCenter.a.xv().xQ().yF());
        eVar.dw(com.baidu.tbadk.coreExtra.messageCenter.a.xv().xQ().yE());
        eVar.dv(com.baidu.tbadk.coreExtra.messageCenter.a.xv().xQ().yC());
        eVar.dA(com.baidu.tbadk.coreExtra.messageCenter.a.xv().xQ().yX());
        f(eVar.zd(), com.baidu.tbadk.coreExtra.messageCenter.a.xv().xQ().zd());
        eVar.dE(com.baidu.tbadk.coreExtra.messageCenter.a.xv().xQ().zb());
        g(eVar.ze(), com.baidu.tbadk.coreExtra.messageCenter.a.xv().xQ().ze());
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.xS().yh()) {
            eVar.dn(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.xS().ya()) {
            eVar.dy(0);
            eVar.dr(0);
            eVar.dB(0);
            eVar.dF(0);
        }
        if (!TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
            eVar.dF(0);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xS().xV() <= 0) {
            eVar.dn(0);
            eVar.dy(0);
            eVar.dB(0);
            eVar.dr(0);
            eVar.dF(0);
            eVar.dC(0);
            eVar.dD(0);
            eVar.aQ(false);
        }
        if ((((((((eVar.yT() + eVar.yB()) + eVar.yC()) + eVar.yE()) + eVar.yZ()) + eVar.yF()) + eVar.yX()) + eVar.zb()) - eVar.yI() <= 0) {
            eVar.aQ(false);
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.xv().b(eVar);
    }

    private void f(List<e.b> list, List<e.b> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (e.b bVar : list) {
                if (bVar != null) {
                    for (e.b bVar2 : list2) {
                        if (bVar2 != null && bVar.gid == bVar2.gid) {
                            bVar.aln = bVar2.unReadCount;
                        }
                    }
                }
            }
        }
    }

    private void g(List<e.a> list, List<e.a> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (e.a aVar : list) {
                if (aVar != null) {
                    for (e.a aVar2 : list2) {
                        if (aVar2 != null && aVar.gid == aVar2.gid) {
                            aVar.aln = aVar2.unReadCount;
                        }
                    }
                }
            }
        }
    }

    private void d(com.baidu.tbadk.coreExtra.d.e eVar) {
        if (eVar != null) {
            for (ImMessageCenterPojo imMessageCenterPojo : this.mList) {
                if (imMessageCenterPojo != null && imMessageCenterPojo.getIs_hidden() != 1 && isNeed(imMessageCenterPojo)) {
                    b(imMessageCenterPojo, eVar);
                    c(imMessageCenterPojo, eVar);
                    a(imMessageCenterPojo, eVar);
                    d(imMessageCenterPojo, eVar);
                    g(imMessageCenterPojo, eVar);
                    h(imMessageCenterPojo, eVar);
                    i(imMessageCenterPojo, eVar);
                    f(imMessageCenterPojo, eVar);
                    e(imMessageCenterPojo, eVar);
                }
            }
        }
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.d.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -10 && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0) {
            e.a aVar = new e.a();
            aVar.gid = com.baidu.adp.lib.h.b.g(imMessageCenterPojo.getGid(), 0);
            aVar.groupName = imMessageCenterPojo.getGroup_name();
            String string = TbadkCoreApplication.m411getInst().getResources().getString(n.j.live_chat_room_more_livenotify);
            String string2 = TbadkCoreApplication.m411getInst().getResources().getString(n.j.living_vip_msg_start, imMessageCenterPojo.getGroup_name());
            aVar.title = string;
            aVar.content = string2;
            aVar.unReadCount = imMessageCenterPojo.getUnread_count();
            eVar.ze().add(aVar);
            eVar.dD(eVar.zb() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.d.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 1) {
            HashMap<String, String> yP = eVar.yP();
            if (!com.baidu.tieba.im.settingcache.c.abL().aK(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                eVar.dt(eVar.yI() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    eVar.eo(imMessageCenterPojo.getLast_content());
                } else {
                    eVar.eo(String.valueOf(imMessageCenterPojo.getLast_user_name()) + ":" + imMessageCenterPojo.getLast_content());
                }
                yP.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            eVar.dn(eVar.yB() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.d.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && h.abN().aK(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0) {
            e.b bVar = new e.b();
            int userType = imMessageCenterPojo.getUserType();
            bVar.gid = com.baidu.adp.lib.h.b.g(imMessageCenterPojo.getGid(), 0);
            bVar.alp = imMessageCenterPojo.getGroup_name();
            if (userType == 4) {
                bVar.title = imMessageCenterPojo.getGroup_name();
                bVar.content = imMessageCenterPojo.getLast_content();
                bVar.alo = String.valueOf(imMessageCenterPojo.getGroup_name()) + ":" + imMessageCenterPojo.getLast_content();
            } else {
                bVar.content = String.valueOf(TbadkCoreApplication.m411getInst().getContext().getString(n.j.official_msg_list_name, imMessageCenterPojo.getGroup_name())) + " : " + imMessageCenterPojo.getLast_content();
                bVar.alo = bVar.content;
            }
            bVar.userType = userType;
            bVar.unReadCount = imMessageCenterPojo.getUnread_count();
            eVar.zd().add(bVar);
            if (userType == 4) {
                eVar.dF(eVar.zf() + imMessageCenterPojo.getUnread_count());
            }
            eVar.dr(eVar.yF() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.d.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && j.abO().aK(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                eVar.eu(imMessageCenterPojo.getLast_content());
                String group_name = imMessageCenterPojo.getGroup_name();
                HashMap<String, String> yV = eVar.yV();
                if (yV != null) {
                    yV.put(imMessageCenterPojo.getGid(), group_name);
                }
            }
            eVar.dy(eVar.yT() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.d.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && l.abP().isAcceptNotify()) {
            eVar.dC(imMessageCenterPojo.getUnread_count());
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.d.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && g.abM().isAcceptNotify()) {
            eVar.dB(imMessageCenterPojo.getUnread_count());
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.d.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            eVar.dq(imMessageCenterPojo.getUnread_count());
            eVar.et(imMessageCenterPojo.getLast_content());
            eVar.eq(imMessageCenterPojo.getGroup_name());
        }
    }

    private void h(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.d.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -3) {
            eVar.er(imMessageCenterPojo.getGroup_name());
            eVar.es(imMessageCenterPojo.getLast_content());
            eVar.dp(imMessageCenterPojo.getUnread_count());
        }
    }

    private void i(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.d.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -5) {
            eVar.dz(imMessageCenterPojo.getUnread_count());
            eVar.ew(imMessageCenterPojo.getGroup_name());
            eVar.ex(imMessageCenterPojo.getLast_content());
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
