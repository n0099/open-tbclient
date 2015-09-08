package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.c.f;
import com.baidu.tieba.i;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.settingcache.g;
import com.baidu.tieba.im.settingcache.h;
import com.baidu.tieba.im.settingcache.j;
import com.baidu.tieba.im.settingcache.l;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static volatile b bDc;
    private List<ImMessageCenterPojo> mList = new LinkedList();
    private final CustomMessageListener bqS = new c(this, 0);

    public static b Wh() {
        if (bDc == null) {
            synchronized (b.class) {
                if (bDc == null) {
                    bDc = new b();
                }
            }
        }
        return bDc;
    }

    private b() {
        registerListener();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.bqS);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.bqS);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CLEAR, this.bqS);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.bqS);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.bqS);
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
            bV(n);
        }
    }

    private boolean n(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
            return j.WA().aM(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return com.baidu.tieba.im.settingcache.c.Wx().aM(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 4) {
            return h.Wz().aM(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
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
                bV(false);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [239=7] */
    /* JADX INFO: Access modifiers changed from: private */
    public void bV(boolean z) {
        com.baidu.tbadk.coreExtra.c.f fVar = new com.baidu.tbadk.coreExtra.c.f();
        fVar.aP(z);
        d(fVar);
        fVar.yf();
        fVar.yg();
        fVar.dh(com.baidu.tbadk.coreExtra.messageCenter.a.wZ().xu().yz());
        fVar.dj(com.baidu.tbadk.coreExtra.messageCenter.a.wZ().xu().yn());
        fVar.dm(com.baidu.tbadk.coreExtra.messageCenter.a.wZ().xu().yl());
        fVar.dl(com.baidu.tbadk.coreExtra.messageCenter.a.wZ().xu().yk());
        fVar.dk(com.baidu.tbadk.coreExtra.messageCenter.a.wZ().xu().yi());
        fVar.dq(com.baidu.tbadk.coreExtra.messageCenter.a.wZ().xu().yD());
        e(fVar.yJ(), com.baidu.tbadk.coreExtra.messageCenter.a.wZ().xu().yJ());
        fVar.du(com.baidu.tbadk.coreExtra.messageCenter.a.wZ().xu().yH());
        f(fVar.yK(), com.baidu.tbadk.coreExtra.messageCenter.a.wZ().xu().yK());
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.xw().xL()) {
            fVar.dd(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.xw().xE()) {
            fVar.dn(0);
            fVar.dg(0);
            fVar.dr(0);
            fVar.dv(0);
        }
        if (!TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
            fVar.dv(0);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xw().xz() <= 0) {
            fVar.dd(0);
            fVar.dn(0);
            fVar.dr(0);
            fVar.dg(0);
            fVar.dv(0);
            fVar.ds(0);
            fVar.dt(0);
            fVar.aP(false);
        }
        if ((((((((fVar.yz() + fVar.yh()) + fVar.yi()) + fVar.yk()) + fVar.yF()) + fVar.yl()) + fVar.yD()) + fVar.yH()) - fVar.yo() <= 0) {
            fVar.aP(false);
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.wZ().b(fVar);
    }

    private void e(List<f.b> list, List<f.b> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (f.b bVar : list) {
                if (bVar != null) {
                    for (f.b bVar2 : list2) {
                        if (bVar2 != null && bVar.gid == bVar2.gid) {
                            bVar.ajr = bVar2.unReadCount;
                        }
                    }
                }
            }
        }
    }

    private void f(List<f.a> list, List<f.a> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (f.a aVar : list) {
                if (aVar != null) {
                    for (f.a aVar2 : list2) {
                        if (aVar2 != null && aVar.gid == aVar2.gid) {
                            aVar.ajr = aVar2.unReadCount;
                        }
                    }
                }
            }
        }
    }

    private void d(com.baidu.tbadk.coreExtra.c.f fVar) {
        if (fVar != null) {
            for (ImMessageCenterPojo imMessageCenterPojo : this.mList) {
                if (imMessageCenterPojo != null && imMessageCenterPojo.getIs_hidden() != 1 && isNeed(imMessageCenterPojo)) {
                    b(imMessageCenterPojo, fVar);
                    c(imMessageCenterPojo, fVar);
                    a(imMessageCenterPojo, fVar);
                    d(imMessageCenterPojo, fVar);
                    g(imMessageCenterPojo, fVar);
                    h(imMessageCenterPojo, fVar);
                    i(imMessageCenterPojo, fVar);
                    f(imMessageCenterPojo, fVar);
                    e(imMessageCenterPojo, fVar);
                }
            }
        }
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.f fVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -10 && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0) {
            f.a aVar = new f.a();
            aVar.gid = com.baidu.adp.lib.g.b.g(imMessageCenterPojo.getGid(), 0);
            aVar.groupName = imMessageCenterPojo.getGroup_name();
            String string = TbadkCoreApplication.m411getInst().getResources().getString(i.h.live_chat_room_more_livenotify);
            String string2 = TbadkCoreApplication.m411getInst().getResources().getString(i.h.living_vip_msg_start, imMessageCenterPojo.getGroup_name());
            aVar.title = string;
            aVar.content = string2;
            aVar.unReadCount = imMessageCenterPojo.getUnread_count();
            fVar.yK().add(aVar);
            fVar.dt(fVar.yH() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.f fVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 1) {
            HashMap<String, String> yv = fVar.yv();
            if (!com.baidu.tieba.im.settingcache.c.Wx().aM(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                fVar.di(fVar.yo() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    fVar.dZ(imMessageCenterPojo.getLast_content());
                } else {
                    fVar.dZ(String.valueOf(imMessageCenterPojo.getLast_user_name()) + ":" + imMessageCenterPojo.getLast_content());
                }
                yv.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            fVar.dd(fVar.yh() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.f fVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && h.Wz().aM(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0) {
            f.b bVar = new f.b();
            int userType = imMessageCenterPojo.getUserType();
            bVar.gid = com.baidu.adp.lib.g.b.g(imMessageCenterPojo.getGid(), 0);
            bVar.ajt = imMessageCenterPojo.getGroup_name();
            if (userType == 4) {
                bVar.title = imMessageCenterPojo.getGroup_name();
                bVar.content = imMessageCenterPojo.getLast_content();
                bVar.ajs = String.valueOf(imMessageCenterPojo.getGroup_name()) + ":" + imMessageCenterPojo.getLast_content();
            } else {
                bVar.content = String.valueOf(TbadkCoreApplication.m411getInst().getContext().getString(i.h.official_msg_list_name, imMessageCenterPojo.getGroup_name())) + " : " + imMessageCenterPojo.getLast_content();
                bVar.ajs = bVar.content;
            }
            bVar.userType = userType;
            bVar.unReadCount = imMessageCenterPojo.getUnread_count();
            fVar.yJ().add(bVar);
            if (userType == 4) {
                fVar.dv(fVar.yL() + imMessageCenterPojo.getUnread_count());
            }
            fVar.dg(fVar.yl() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.f fVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && j.WA().aM(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                fVar.ef(imMessageCenterPojo.getLast_content());
                String group_name = imMessageCenterPojo.getGroup_name();
                HashMap<String, String> yB = fVar.yB();
                if (yB != null) {
                    yB.put(imMessageCenterPojo.getGid(), group_name);
                }
            }
            fVar.dn(fVar.yz() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.f fVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && l.WB().isAcceptNotify()) {
            fVar.ds(imMessageCenterPojo.getUnread_count());
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.f fVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && g.Wy().isAcceptNotify()) {
            fVar.dr(imMessageCenterPojo.getUnread_count());
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.f fVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            fVar.df(imMessageCenterPojo.getUnread_count());
            fVar.ee(imMessageCenterPojo.getLast_content());
            fVar.eb(imMessageCenterPojo.getGroup_name());
        }
    }

    private void h(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.f fVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -3) {
            fVar.ec(imMessageCenterPojo.getGroup_name());
            fVar.ed(imMessageCenterPojo.getLast_content());
            fVar.de(imMessageCenterPojo.getUnread_count());
        }
    }

    private void i(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.c.f fVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -5) {
            fVar.dp(imMessageCenterPojo.getUnread_count());
            fVar.eh(imMessageCenterPojo.getGroup_name());
            fVar.ei(imMessageCenterPojo.getLast_content());
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
