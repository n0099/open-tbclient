package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.settingcache.g;
import com.baidu.tieba.im.settingcache.h;
import com.baidu.tieba.im.settingcache.j;
import com.baidu.tieba.im.settingcache.l;
import com.baidu.tieba.w;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static volatile a dfB;
    private List<ImMessageCenterPojo> mList = new LinkedList();
    private final CustomMessageListener cRV = new b(this, 0);

    public static a asa() {
        if (dfB == null) {
            synchronized (a.class) {
                if (dfB == null) {
                    dfB = new a();
                }
            }
        }
        return dfB;
    }

    private a() {
        registerListener();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cRV);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cRV);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cRV);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cRV);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cRV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            boolean n = n(data);
            if (memoryChangedMessage.getType() == 1) {
                c(data, this.mList);
            } else if (memoryChangedMessage.getType() == 2) {
                d(data, this.mList);
            }
            dU(n);
        }
    }

    private boolean n(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
            return j.ass().be(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return com.baidu.tieba.im.settingcache.c.asp().be(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 4) {
            return h.asr().be(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        return imMessageCenterPojo.getCustomGroupType() == -3 || imMessageCenterPojo.getCustomGroupType() == -4 || imMessageCenterPojo.getCustomGroupType() == -5 || imMessageCenterPojo.getCustomGroupType() == -10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
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
                dU(false);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [242=7] */
    /* JADX INFO: Access modifiers changed from: private */
    public void dU(boolean z) {
        com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
        eVar.bh(z);
        d(eVar);
        eVar.zs();
        eVar.zt();
        eVar.dN(com.baidu.tbadk.coreExtra.messageCenter.a.yn().yI().zM());
        eVar.dP(com.baidu.tbadk.coreExtra.messageCenter.a.yn().yI().zA());
        eVar.dS(com.baidu.tbadk.coreExtra.messageCenter.a.yn().yI().zy());
        eVar.dR(com.baidu.tbadk.coreExtra.messageCenter.a.yn().yI().zx());
        eVar.dQ(com.baidu.tbadk.coreExtra.messageCenter.a.yn().yI().zv());
        eVar.dV(com.baidu.tbadk.coreExtra.messageCenter.a.yn().yI().zQ());
        l(eVar.zW(), com.baidu.tbadk.coreExtra.messageCenter.a.yn().yI().zW());
        eVar.dZ(com.baidu.tbadk.coreExtra.messageCenter.a.yn().yI().zU());
        m(eVar.zX(), com.baidu.tbadk.coreExtra.messageCenter.a.yn().yI().zX());
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.yK().yZ()) {
            eVar.dJ(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.yK().yS()) {
            eVar.dT(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.yK().ze()) {
            eVar.dM(0);
            eVar.dW(0);
            eVar.ea(0);
        }
        if (!TbadkCoreApplication.m9getInst().isPromotedMessageOn()) {
            eVar.ea(0);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yK().yN() <= 0) {
            eVar.dJ(0);
            eVar.dT(0);
            eVar.dW(0);
            eVar.dM(0);
            eVar.ea(0);
            eVar.dX(0);
            eVar.dY(0);
            eVar.bh(false);
        }
        if ((((((((eVar.zM() + eVar.zu()) + eVar.zv()) + eVar.zx()) + eVar.zS()) + eVar.zy()) + eVar.zQ()) + eVar.zU()) - eVar.zB() <= 0) {
            eVar.bh(false);
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.yn().b(eVar);
    }

    private void l(List<e.b> list, List<e.b> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (e.b bVar : list) {
                if (bVar != null) {
                    for (e.b bVar2 : list2) {
                        if (bVar2 != null && bVar.arm == bVar2.arm) {
                            bVar.arn = bVar2.unReadCount;
                        }
                    }
                }
            }
        }
    }

    private void m(List<e.a> list, List<e.a> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (e.a aVar : list) {
                if (aVar != null) {
                    for (e.a aVar2 : list2) {
                        if (aVar2 != null && aVar.arm == aVar2.arm) {
                            aVar.arn = aVar2.unReadCount;
                        }
                    }
                }
            }
        }
    }

    private void d(com.baidu.tbadk.coreExtra.c.e eVar) {
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

    private void a(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -10 && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0) {
            e.a aVar = new e.a();
            aVar.arm = com.baidu.adp.lib.g.b.g(imMessageCenterPojo.getGid(), 0);
            aVar.groupName = imMessageCenterPojo.getGroup_name();
            String string = TbadkCoreApplication.m9getInst().getResources().getString(w.l.live_chat_room_more_livenotify);
            String string2 = TbadkCoreApplication.m9getInst().getResources().getString(w.l.living_vip_msg_start, imMessageCenterPojo.getGroup_name());
            aVar.title = string;
            aVar.content = string2;
            aVar.unReadCount = imMessageCenterPojo.getUnread_count();
            eVar.zX().add(aVar);
            eVar.dY(eVar.zU() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 1) {
            HashMap<String, String> zI = eVar.zI();
            if (!com.baidu.tieba.im.settingcache.c.asp().be(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                eVar.dO(eVar.zB() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    eVar.en(imMessageCenterPojo.getLast_content());
                } else {
                    eVar.en(String.valueOf(imMessageCenterPojo.getLast_user_name()) + ":" + imMessageCenterPojo.getLast_content());
                }
                zI.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            eVar.dJ(eVar.zu() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.e eVar) {
        int userType;
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && h.asr().be(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0 && (userType = imMessageCenterPojo.getUserType()) != 3) {
            e.b bVar = new e.b();
            bVar.arm = com.baidu.adp.lib.g.b.g(imMessageCenterPojo.getGid(), 0);
            bVar.arp = imMessageCenterPojo.getGroup_name();
            if (userType == 4) {
                bVar.title = imMessageCenterPojo.getGroup_name();
                bVar.content = imMessageCenterPojo.getLast_content();
                bVar.aro = String.valueOf(imMessageCenterPojo.getGroup_name()) + ":" + imMessageCenterPojo.getLast_content();
            } else {
                bVar.content = String.valueOf(TbadkCoreApplication.m9getInst().getContext().getString(w.l.chosen_pb_original_bar, imMessageCenterPojo.getGroup_name())) + " : " + imMessageCenterPojo.getLast_content();
                bVar.aro = bVar.content;
            }
            bVar.userType = userType;
            bVar.unReadCount = imMessageCenterPojo.getUnread_count();
            eVar.zW().add(bVar);
            if (userType == 4) {
                eVar.ea(eVar.zY() + imMessageCenterPojo.getUnread_count());
            }
            eVar.dM(eVar.zy() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && j.ass().be(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                eVar.et(imMessageCenterPojo.getLast_content());
                String group_name = imMessageCenterPojo.getGroup_name();
                HashMap<String, String> zO = eVar.zO();
                if (zO != null) {
                    zO.put(imMessageCenterPojo.getGid(), group_name);
                }
            }
            eVar.dT(eVar.zM() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && l.ast().isAcceptNotify()) {
            eVar.dX(imMessageCenterPojo.getUnread_count());
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && g.asq().isAcceptNotify()) {
            eVar.dW(imMessageCenterPojo.getUnread_count());
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            eVar.dL(imMessageCenterPojo.getUnread_count());
            eVar.es(imMessageCenterPojo.getLast_content());
            eVar.ep(imMessageCenterPojo.getGroup_name());
        }
    }

    private void h(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -3) {
            eVar.eq(imMessageCenterPojo.getGroup_name());
            eVar.er(imMessageCenterPojo.getLast_content());
            eVar.dK(imMessageCenterPojo.getUnread_count());
        }
    }

    private void i(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -5) {
            eVar.dU(imMessageCenterPojo.getUnread_count());
            eVar.ev(imMessageCenterPojo.getGroup_name());
            eVar.ew(imMessageCenterPojo.getLast_content());
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
