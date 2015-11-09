package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.d.e;
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
    private static volatile b bGK;
    private List<ImMessageCenterPojo> mList = new LinkedList();
    private final CustomMessageListener buE = new c(this, 0);

    public static b Xh() {
        if (bGK == null) {
            synchronized (b.class) {
                if (bGK == null) {
                    bGK = new b();
                }
            }
        }
        return bGK;
    }

    private b() {
        registerListener();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.buE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.buE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CLEAR, this.buE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.buE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.buE);
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
            bU(n);
        }
    }

    private boolean n(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
            return j.XA().aK(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return com.baidu.tieba.im.settingcache.c.Xx().aK(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 4) {
            return h.Xz().aK(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
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
                bU(false);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [239=7] */
    /* JADX INFO: Access modifiers changed from: private */
    public void bU(boolean z) {
        com.baidu.tbadk.coreExtra.d.e eVar = new com.baidu.tbadk.coreExtra.d.e();
        eVar.aO(z);
        d(eVar);
        eVar.xR();
        eVar.xS();
        eVar.di(com.baidu.tbadk.coreExtra.messageCenter.a.wM().xh().yl());
        eVar.dk(com.baidu.tbadk.coreExtra.messageCenter.a.wM().xh().xZ());
        eVar.dn(com.baidu.tbadk.coreExtra.messageCenter.a.wM().xh().xX());
        eVar.dm(com.baidu.tbadk.coreExtra.messageCenter.a.wM().xh().xW());
        eVar.dl(com.baidu.tbadk.coreExtra.messageCenter.a.wM().xh().xU());
        eVar.dr(com.baidu.tbadk.coreExtra.messageCenter.a.wM().xh().yp());
        e(eVar.yv(), com.baidu.tbadk.coreExtra.messageCenter.a.wM().xh().yv());
        eVar.dv(com.baidu.tbadk.coreExtra.messageCenter.a.wM().xh().yt());
        f(eVar.yw(), com.baidu.tbadk.coreExtra.messageCenter.a.wM().xh().yw());
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.xj().xy()) {
            eVar.de(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.xj().xr()) {
            eVar.dp(0);
            eVar.dh(0);
            eVar.ds(0);
            eVar.dw(0);
        }
        if (!TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
            eVar.dw(0);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().xm() <= 0) {
            eVar.de(0);
            eVar.dp(0);
            eVar.ds(0);
            eVar.dh(0);
            eVar.dw(0);
            eVar.dt(0);
            eVar.du(0);
            eVar.aO(false);
        }
        if ((((((((eVar.yl() + eVar.xT()) + eVar.xU()) + eVar.xW()) + eVar.yr()) + eVar.xX()) + eVar.yp()) + eVar.yt()) - eVar.ya() <= 0) {
            eVar.aO(false);
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.wM().b(eVar);
    }

    private void e(List<e.b> list, List<e.b> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (e.b bVar : list) {
                if (bVar != null) {
                    for (e.b bVar2 : list2) {
                        if (bVar2 != null && bVar.gid == bVar2.gid) {
                            bVar.aiu = bVar2.unReadCount;
                        }
                    }
                }
            }
        }
    }

    private void f(List<e.a> list, List<e.a> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (e.a aVar : list) {
                if (aVar != null) {
                    for (e.a aVar2 : list2) {
                        if (aVar2 != null && aVar.gid == aVar2.gid) {
                            aVar.aiu = aVar2.unReadCount;
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
            aVar.gid = com.baidu.adp.lib.g.b.g(imMessageCenterPojo.getGid(), 0);
            aVar.groupName = imMessageCenterPojo.getGroup_name();
            String string = TbadkCoreApplication.m411getInst().getResources().getString(i.h.live_chat_room_more_livenotify);
            String string2 = TbadkCoreApplication.m411getInst().getResources().getString(i.h.living_vip_msg_start, imMessageCenterPojo.getGroup_name());
            aVar.title = string;
            aVar.content = string2;
            aVar.unReadCount = imMessageCenterPojo.getUnread_count();
            eVar.yw().add(aVar);
            eVar.du(eVar.yt() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.d.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 1) {
            HashMap<String, String> yh = eVar.yh();
            if (!com.baidu.tieba.im.settingcache.c.Xx().aK(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                eVar.dj(eVar.ya() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    eVar.ec(imMessageCenterPojo.getLast_content());
                } else {
                    eVar.ec(String.valueOf(imMessageCenterPojo.getLast_user_name()) + ":" + imMessageCenterPojo.getLast_content());
                }
                yh.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            eVar.de(eVar.xT() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.d.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && h.Xz().aK(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0) {
            e.b bVar = new e.b();
            int userType = imMessageCenterPojo.getUserType();
            bVar.gid = com.baidu.adp.lib.g.b.g(imMessageCenterPojo.getGid(), 0);
            bVar.aiw = imMessageCenterPojo.getGroup_name();
            if (userType == 4) {
                bVar.title = imMessageCenterPojo.getGroup_name();
                bVar.content = imMessageCenterPojo.getLast_content();
                bVar.aiv = String.valueOf(imMessageCenterPojo.getGroup_name()) + ":" + imMessageCenterPojo.getLast_content();
            } else {
                bVar.content = String.valueOf(TbadkCoreApplication.m411getInst().getContext().getString(i.h.official_msg_list_name, imMessageCenterPojo.getGroup_name())) + " : " + imMessageCenterPojo.getLast_content();
                bVar.aiv = bVar.content;
            }
            bVar.userType = userType;
            bVar.unReadCount = imMessageCenterPojo.getUnread_count();
            eVar.yv().add(bVar);
            if (userType == 4) {
                eVar.dw(eVar.yx() + imMessageCenterPojo.getUnread_count());
            }
            eVar.dh(eVar.xX() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.d.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && j.XA().aK(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                eVar.ei(imMessageCenterPojo.getLast_content());
                String group_name = imMessageCenterPojo.getGroup_name();
                HashMap<String, String> yn = eVar.yn();
                if (yn != null) {
                    yn.put(imMessageCenterPojo.getGid(), group_name);
                }
            }
            eVar.dp(eVar.yl() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.d.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && l.XB().isAcceptNotify()) {
            eVar.dt(imMessageCenterPojo.getUnread_count());
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.d.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && g.Xy().isAcceptNotify()) {
            eVar.ds(imMessageCenterPojo.getUnread_count());
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.d.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            eVar.dg(imMessageCenterPojo.getUnread_count());
            eVar.eh(imMessageCenterPojo.getLast_content());
            eVar.ee(imMessageCenterPojo.getGroup_name());
        }
    }

    private void h(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.d.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -3) {
            eVar.ef(imMessageCenterPojo.getGroup_name());
            eVar.eg(imMessageCenterPojo.getLast_content());
            eVar.df(imMessageCenterPojo.getUnread_count());
        }
    }

    private void i(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.d.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -5) {
            eVar.dq(imMessageCenterPojo.getUnread_count());
            eVar.ek(imMessageCenterPojo.getGroup_name());
            eVar.el(imMessageCenterPojo.getLast_content());
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
