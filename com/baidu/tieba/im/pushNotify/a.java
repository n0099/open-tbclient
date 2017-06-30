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
    private static volatile a dnw;
    private List<ImMessageCenterPojo> mList = new LinkedList();
    private final CustomMessageListener cZR = new b(this, 0);

    public static a avL() {
        if (dnw == null) {
            synchronized (a.class) {
                if (dnw == null) {
                    dnw = new a();
                }
            }
        }
        return dnw;
    }

    private a() {
        registerListener();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cZR);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cZR);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cZR);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cZR);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cZR);
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
            el(n);
        }
    }

    private boolean n(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
            return j.awd().bl(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return com.baidu.tieba.im.settingcache.c.awa().bl(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 4) {
            return h.awc().bl(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
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
                el(false);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [242=7] */
    /* JADX INFO: Access modifiers changed from: private */
    public void el(boolean z) {
        com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
        eVar.bi(z);
        d(eVar);
        eVar.zN();
        eVar.zO();
        eVar.dP(com.baidu.tbadk.coreExtra.messageCenter.a.yG().zb().Ah());
        eVar.dR(com.baidu.tbadk.coreExtra.messageCenter.a.yG().zb().zV());
        eVar.dU(com.baidu.tbadk.coreExtra.messageCenter.a.yG().zb().zT());
        eVar.dT(com.baidu.tbadk.coreExtra.messageCenter.a.yG().zb().zS());
        eVar.dS(com.baidu.tbadk.coreExtra.messageCenter.a.yG().zb().zQ());
        eVar.dX(com.baidu.tbadk.coreExtra.messageCenter.a.yG().zb().Al());
        m(eVar.Ar(), com.baidu.tbadk.coreExtra.messageCenter.a.yG().zb().Ar());
        eVar.eb(com.baidu.tbadk.coreExtra.messageCenter.a.yG().zb().Ap());
        n(eVar.As(), com.baidu.tbadk.coreExtra.messageCenter.a.yG().zb().As());
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.zd().zs()) {
            eVar.dL(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.zd().zl()) {
            eVar.dV(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.zd().zx()) {
            eVar.dO(0);
            eVar.dY(0);
            eVar.ec(0);
        }
        if (!TbadkCoreApplication.m9getInst().isPromotedMessageOn()) {
            eVar.ec(0);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zd().zg() <= 0) {
            eVar.dL(0);
            eVar.dV(0);
            eVar.dY(0);
            eVar.dO(0);
            eVar.ec(0);
            eVar.dZ(0);
            eVar.ea(0);
            eVar.bi(false);
        }
        if ((((((((eVar.Ah() + eVar.zP()) + eVar.zQ()) + eVar.zS()) + eVar.An()) + eVar.zT()) + eVar.Al()) + eVar.Ap()) - eVar.zW() <= 0) {
            eVar.bi(false);
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.yG().b(eVar);
    }

    private void m(List<e.b> list, List<e.b> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (e.b bVar : list) {
                if (bVar != null) {
                    for (e.b bVar2 : list2) {
                        if (bVar2 != null && bVar.asp == bVar2.asp) {
                            bVar.asq = bVar2.unReadCount;
                        }
                    }
                }
            }
        }
    }

    private void n(List<e.a> list, List<e.a> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (e.a aVar : list) {
                if (aVar != null) {
                    for (e.a aVar2 : list2) {
                        if (aVar2 != null && aVar.asp == aVar2.asp) {
                            aVar.asq = aVar2.unReadCount;
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
            aVar.asp = com.baidu.adp.lib.g.b.g(imMessageCenterPojo.getGid(), 0);
            aVar.groupName = imMessageCenterPojo.getGroup_name();
            String string = TbadkCoreApplication.m9getInst().getResources().getString(w.l.live_chat_room_more_livenotify);
            String string2 = TbadkCoreApplication.m9getInst().getResources().getString(w.l.living_vip_msg_start, imMessageCenterPojo.getGroup_name());
            aVar.title = string;
            aVar.content = string2;
            aVar.unReadCount = imMessageCenterPojo.getUnread_count();
            eVar.As().add(aVar);
            eVar.ea(eVar.Ap() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 1) {
            HashMap<String, String> Ad = eVar.Ad();
            if (!com.baidu.tieba.im.settingcache.c.awa().bl(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                eVar.dQ(eVar.zW() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    eVar.eH(imMessageCenterPojo.getLast_content());
                } else {
                    eVar.eH(String.valueOf(imMessageCenterPojo.getLast_user_name()) + ":" + imMessageCenterPojo.getLast_content());
                }
                Ad.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            eVar.dL(eVar.zP() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.e eVar) {
        int userType;
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && h.awc().bl(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0 && (userType = imMessageCenterPojo.getUserType()) != 3) {
            e.b bVar = new e.b();
            bVar.asp = com.baidu.adp.lib.g.b.g(imMessageCenterPojo.getGid(), 0);
            bVar.ass = imMessageCenterPojo.getGroup_name();
            if (userType == 4) {
                bVar.title = imMessageCenterPojo.getGroup_name();
                bVar.content = imMessageCenterPojo.getLast_content();
                bVar.asr = String.valueOf(imMessageCenterPojo.getGroup_name()) + ":" + imMessageCenterPojo.getLast_content();
            } else {
                bVar.content = String.valueOf(TbadkCoreApplication.m9getInst().getContext().getString(w.l.chosen_pb_original_bar, imMessageCenterPojo.getGroup_name())) + " : " + imMessageCenterPojo.getLast_content();
                bVar.asr = bVar.content;
            }
            bVar.userType = userType;
            bVar.unReadCount = imMessageCenterPojo.getUnread_count();
            eVar.Ar().add(bVar);
            if (userType == 4) {
                eVar.ec(eVar.At() + imMessageCenterPojo.getUnread_count());
            }
            eVar.dO(eVar.zT() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && j.awd().bl(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                eVar.eN(imMessageCenterPojo.getLast_content());
                String group_name = imMessageCenterPojo.getGroup_name();
                HashMap<String, String> Aj = eVar.Aj();
                if (Aj != null) {
                    Aj.put(imMessageCenterPojo.getGid(), group_name);
                }
            }
            eVar.dV(eVar.Ah() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && l.awe().isAcceptNotify()) {
            eVar.dZ(imMessageCenterPojo.getUnread_count());
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && g.awb().isAcceptNotify()) {
            eVar.dY(imMessageCenterPojo.getUnread_count());
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            eVar.dN(imMessageCenterPojo.getUnread_count());
            eVar.eM(imMessageCenterPojo.getLast_content());
            eVar.eJ(imMessageCenterPojo.getGroup_name());
        }
    }

    private void h(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -3) {
            eVar.eK(imMessageCenterPojo.getGroup_name());
            eVar.eL(imMessageCenterPojo.getLast_content());
            eVar.dM(imMessageCenterPojo.getUnread_count());
        }
    }

    private void i(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -5) {
            eVar.dW(imMessageCenterPojo.getUnread_count());
            eVar.eP(imMessageCenterPojo.getGroup_name());
            eVar.eQ(imMessageCenterPojo.getLast_content());
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
