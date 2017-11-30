package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.model.e;
import com.baidu.tieba.d;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.settingcache.c;
import com.baidu.tieba.im.settingcache.d;
import com.baidu.tieba.im.settingcache.f;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static volatile a dSu;
    private List<ImMessageCenterPojo> mList = new LinkedList();
    private final CustomMessageListener dFn = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.pushNotify.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016002) {
                    a.this.e(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016004) {
                    a.this.f(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016007) {
                    a.this.g(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016001) {
                    if (a.this.mList != null) {
                        a.this.mList.clear();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.a.yM().c(new e());
                    com.baidu.tbadk.coreExtra.messageCenter.a.yM().setMsgChat(0);
                    com.baidu.tbadk.coreExtra.messageCenter.a.yM().ze();
                    com.baidu.tbadk.coreExtra.messageCenter.a.yM().za();
                } else if (customResponsedMessage.getCmd() == 2016010 && a.this.mList != null) {
                    a.this.eH(false);
                }
            }
        }
    };

    public static a aCH() {
        if (dSu == null) {
            synchronized (a.class) {
                if (dSu == null) {
                    dSu = new a();
                }
            }
        }
        return dSu;
    }

    private a() {
        registerListener();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dFn);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dFn);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dFn);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.dFn);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dFn);
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
            eH(n);
        }
    }

    private boolean n(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
            return com.baidu.tieba.im.settingcache.e.aDa().bi(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return com.baidu.tieba.im.settingcache.b.aCX().bi(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 4) {
            return d.aCZ().bi(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
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
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(boolean z) {
        e eVar = new e();
        eVar.bh(z);
        d(eVar);
        eVar.zV();
        eVar.zW();
        eVar.ee(com.baidu.tbadk.coreExtra.messageCenter.a.yM().zh().Ap());
        eVar.eg(com.baidu.tbadk.coreExtra.messageCenter.a.yM().zh().Ad());
        eVar.ej(com.baidu.tbadk.coreExtra.messageCenter.a.yM().zh().Ab());
        eVar.ei(com.baidu.tbadk.coreExtra.messageCenter.a.yM().zh().Aa());
        eVar.eh(com.baidu.tbadk.coreExtra.messageCenter.a.yM().zh().zY());
        eVar.em(com.baidu.tbadk.coreExtra.messageCenter.a.yM().zh().At());
        n(eVar.Az(), com.baidu.tbadk.coreExtra.messageCenter.a.yM().zh().Az());
        eVar.eq(com.baidu.tbadk.coreExtra.messageCenter.a.yM().zh().Ax());
        o(eVar.AA(), com.baidu.tbadk.coreExtra.messageCenter.a.yM().zh().AA());
        if (!com.baidu.tbadk.coreExtra.messageCenter.b.zj().zy()) {
            eVar.ea(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.b.zj().zr()) {
            eVar.ek(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.b.zj().zD()) {
            eVar.ed(0);
            eVar.en(0);
            eVar.er(0);
        }
        if (!TbadkCoreApplication.getInst().isPromotedMessageOn()) {
            eVar.er(0);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.b.zj().zm() <= 0) {
            eVar.ea(0);
            eVar.ek(0);
            eVar.en(0);
            eVar.ed(0);
            eVar.er(0);
            eVar.eo(0);
            eVar.ep(0);
            eVar.bh(false);
        }
        if ((((((((eVar.Ap() + eVar.zX()) + eVar.zY()) + eVar.Aa()) + eVar.Av()) + eVar.Ab()) + eVar.At()) + eVar.Ax()) - eVar.Ae() <= 0) {
            eVar.bh(false);
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.yM().b(eVar);
    }

    private void n(List<e.b> list, List<e.b> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (e.b bVar : list) {
                if (bVar != null) {
                    for (e.b bVar2 : list2) {
                        if (bVar2 != null && bVar.atU == bVar2.atU) {
                            bVar.atV = bVar2.unReadCount;
                        }
                    }
                }
            }
        }
    }

    private void o(List<e.a> list, List<e.a> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (e.a aVar : list) {
                if (aVar != null) {
                    for (e.a aVar2 : list2) {
                        if (aVar2 != null && aVar.atU == aVar2.atU) {
                            aVar.atV = aVar2.unReadCount;
                        }
                    }
                }
            }
        }
    }

    private void d(e eVar) {
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

    private void a(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -10 && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0) {
            e.a aVar = new e.a();
            aVar.atU = com.baidu.adp.lib.g.b.g(imMessageCenterPojo.getGid(), 0);
            aVar.groupName = imMessageCenterPojo.getGroup_name();
            String string = TbadkCoreApplication.getInst().getResources().getString(d.j.live_chat_room_more_livenotify);
            String string2 = TbadkCoreApplication.getInst().getResources().getString(d.j.living_vip_msg_start, imMessageCenterPojo.getGroup_name());
            aVar.title = string;
            aVar.content = string2;
            aVar.unReadCount = imMessageCenterPojo.getUnread_count();
            eVar.AA().add(aVar);
            eVar.ep(eVar.Ax() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 1) {
            HashMap<String, String> Al = eVar.Al();
            if (!com.baidu.tieba.im.settingcache.b.aCX().bi(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                eVar.ef(eVar.Ae() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    eVar.eU(imMessageCenterPojo.getLast_content());
                } else {
                    eVar.eU(imMessageCenterPojo.getLast_user_name() + ":" + imMessageCenterPojo.getLast_content());
                }
                Al.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            eVar.ea(eVar.zX() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        int userType;
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && com.baidu.tieba.im.settingcache.d.aCZ().bi(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0 && (userType = imMessageCenterPojo.getUserType()) != 3) {
            e.b bVar = new e.b();
            bVar.atU = com.baidu.adp.lib.g.b.g(imMessageCenterPojo.getGid(), 0);
            bVar.atX = imMessageCenterPojo.getGroup_name();
            if (userType == 4) {
                bVar.title = imMessageCenterPojo.getGroup_name();
                bVar.content = imMessageCenterPojo.getLast_content();
                bVar.atW = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
            } else {
                bVar.content = TbadkCoreApplication.getInst().getContext().getString(d.j.chosen_pb_original_bar, imMessageCenterPojo.getGroup_name()) + " : " + imMessageCenterPojo.getLast_content();
                bVar.atW = bVar.content;
            }
            bVar.userType = userType;
            bVar.unReadCount = imMessageCenterPojo.getUnread_count();
            eVar.Az().add(bVar);
            if (userType == 4) {
                eVar.er(eVar.AB() + imMessageCenterPojo.getUnread_count());
            }
            eVar.ed(eVar.Ab() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && com.baidu.tieba.im.settingcache.e.aDa().bi(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                eVar.fa(imMessageCenterPojo.getLast_content());
                String group_name = imMessageCenterPojo.getGroup_name();
                HashMap<String, String> Ar = eVar.Ar();
                if (Ar != null) {
                    Ar.put(imMessageCenterPojo.getGid(), group_name);
                }
            }
            eVar.ek(eVar.Ap() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && f.aDb().isAcceptNotify()) {
            eVar.eo(imMessageCenterPojo.getUnread_count());
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && c.aCY().isAcceptNotify()) {
            eVar.en(imMessageCenterPojo.getUnread_count());
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            eVar.ec(imMessageCenterPojo.getUnread_count());
            eVar.eZ(imMessageCenterPojo.getLast_content());
            eVar.eW(imMessageCenterPojo.getGroup_name());
        }
    }

    private void h(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -3) {
            eVar.eX(imMessageCenterPojo.getGroup_name());
            eVar.eY(imMessageCenterPojo.getLast_content());
            eVar.eb(imMessageCenterPojo.getUnread_count());
        }
    }

    private void i(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -5) {
            eVar.el(imMessageCenterPojo.getUnread_count());
            eVar.fc(imMessageCenterPojo.getGroup_name());
            eVar.fd(imMessageCenterPojo.getLast_content());
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
