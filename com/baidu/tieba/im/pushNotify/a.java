package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.c.e;
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
    private static volatile a dCN;
    private List<ImMessageCenterPojo> mList = new LinkedList();
    private final CustomMessageListener dpq = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.pushNotify.a.1
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.yv().c(new e());
                    com.baidu.tbadk.coreExtra.messageCenter.a.yv().setMsgChat(0);
                    com.baidu.tbadk.coreExtra.messageCenter.a.yv().yN();
                    com.baidu.tbadk.coreExtra.messageCenter.a.yv().yJ();
                } else if (customResponsedMessage.getCmd() == 2016010 && a.this.mList != null) {
                    a.this.eo(false);
                }
            }
        }
    };

    public static a ayI() {
        if (dCN == null) {
            synchronized (a.class) {
                if (dCN == null) {
                    dCN = new a();
                }
            }
        }
        return dCN;
    }

    private a() {
        registerListener();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dpq);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dpq);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dpq);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.dpq);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dpq);
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
            eo(n);
        }
    }

    private boolean n(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
            return com.baidu.tieba.im.settingcache.e.azb().bj(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return com.baidu.tieba.im.settingcache.b.ayY().bj(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 4) {
            return d.aza().bj(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
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
                eo(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eo(boolean z) {
        e eVar = new e();
        eVar.bi(z);
        d(eVar);
        eVar.zC();
        eVar.zD();
        eVar.ed(com.baidu.tbadk.coreExtra.messageCenter.a.yv().yQ().zW());
        eVar.ef(com.baidu.tbadk.coreExtra.messageCenter.a.yv().yQ().zK());
        eVar.ei(com.baidu.tbadk.coreExtra.messageCenter.a.yv().yQ().zI());
        eVar.eh(com.baidu.tbadk.coreExtra.messageCenter.a.yv().yQ().zH());
        eVar.eg(com.baidu.tbadk.coreExtra.messageCenter.a.yv().yQ().zF());
        eVar.el(com.baidu.tbadk.coreExtra.messageCenter.a.yv().yQ().Aa());
        l(eVar.Ag(), com.baidu.tbadk.coreExtra.messageCenter.a.yv().yQ().Ag());
        eVar.ep(com.baidu.tbadk.coreExtra.messageCenter.a.yv().yQ().Ae());
        m(eVar.Ah(), com.baidu.tbadk.coreExtra.messageCenter.a.yv().yQ().Ah());
        if (!com.baidu.tbadk.coreExtra.messageCenter.b.yS().zh()) {
            eVar.dZ(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.b.yS().za()) {
            eVar.ej(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.b.yS().zm()) {
            eVar.ec(0);
            eVar.em(0);
            eVar.eq(0);
        }
        if (!TbadkCoreApplication.getInst().isPromotedMessageOn()) {
            eVar.eq(0);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.b.yS().yV() <= 0) {
            eVar.dZ(0);
            eVar.ej(0);
            eVar.em(0);
            eVar.ec(0);
            eVar.eq(0);
            eVar.en(0);
            eVar.eo(0);
            eVar.bi(false);
        }
        if ((((((((eVar.zW() + eVar.zE()) + eVar.zF()) + eVar.zH()) + eVar.Ac()) + eVar.zI()) + eVar.Aa()) + eVar.Ae()) - eVar.zL() <= 0) {
            eVar.bi(false);
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.yv().b(eVar);
    }

    private void l(List<e.b> list, List<e.b> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (e.b bVar : list) {
                if (bVar != null) {
                    for (e.b bVar2 : list2) {
                        if (bVar2 != null && bVar.ata == bVar2.ata) {
                            bVar.atb = bVar2.unReadCount;
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
                        if (aVar2 != null && aVar.ata == aVar2.ata) {
                            aVar.atb = aVar2.unReadCount;
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
            aVar.ata = com.baidu.adp.lib.g.b.g(imMessageCenterPojo.getGid(), 0);
            aVar.groupName = imMessageCenterPojo.getGroup_name();
            String string = TbadkCoreApplication.getInst().getResources().getString(d.l.live_chat_room_more_livenotify);
            String string2 = TbadkCoreApplication.getInst().getResources().getString(d.l.living_vip_msg_start, imMessageCenterPojo.getGroup_name());
            aVar.title = string;
            aVar.content = string2;
            aVar.unReadCount = imMessageCenterPojo.getUnread_count();
            eVar.Ah().add(aVar);
            eVar.eo(eVar.Ae() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 1) {
            HashMap<String, String> zS = eVar.zS();
            if (!com.baidu.tieba.im.settingcache.b.ayY().bj(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                eVar.ee(eVar.zL() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    eVar.eI(imMessageCenterPojo.getLast_content());
                } else {
                    eVar.eI(imMessageCenterPojo.getLast_user_name() + ":" + imMessageCenterPojo.getLast_content());
                }
                zS.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            eVar.dZ(eVar.zE() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        int userType;
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && com.baidu.tieba.im.settingcache.d.aza().bj(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0 && (userType = imMessageCenterPojo.getUserType()) != 3) {
            e.b bVar = new e.b();
            bVar.ata = com.baidu.adp.lib.g.b.g(imMessageCenterPojo.getGid(), 0);
            bVar.atd = imMessageCenterPojo.getGroup_name();
            if (userType == 4) {
                bVar.title = imMessageCenterPojo.getGroup_name();
                bVar.content = imMessageCenterPojo.getLast_content();
                bVar.atc = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
            } else {
                bVar.content = TbadkCoreApplication.getInst().getContext().getString(d.l.chosen_pb_original_bar, imMessageCenterPojo.getGroup_name()) + " : " + imMessageCenterPojo.getLast_content();
                bVar.atc = bVar.content;
            }
            bVar.userType = userType;
            bVar.unReadCount = imMessageCenterPojo.getUnread_count();
            eVar.Ag().add(bVar);
            if (userType == 4) {
                eVar.eq(eVar.Ai() + imMessageCenterPojo.getUnread_count());
            }
            eVar.ec(eVar.zI() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && com.baidu.tieba.im.settingcache.e.azb().bj(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                eVar.eO(imMessageCenterPojo.getLast_content());
                String group_name = imMessageCenterPojo.getGroup_name();
                HashMap<String, String> zY = eVar.zY();
                if (zY != null) {
                    zY.put(imMessageCenterPojo.getGid(), group_name);
                }
            }
            eVar.ej(eVar.zW() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && f.azc().isAcceptNotify()) {
            eVar.en(imMessageCenterPojo.getUnread_count());
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && c.ayZ().isAcceptNotify()) {
            eVar.em(imMessageCenterPojo.getUnread_count());
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            eVar.eb(imMessageCenterPojo.getUnread_count());
            eVar.eN(imMessageCenterPojo.getLast_content());
            eVar.eK(imMessageCenterPojo.getGroup_name());
        }
    }

    private void h(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -3) {
            eVar.eL(imMessageCenterPojo.getGroup_name());
            eVar.eM(imMessageCenterPojo.getLast_content());
            eVar.ea(imMessageCenterPojo.getUnread_count());
        }
    }

    private void i(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -5) {
            eVar.ek(imMessageCenterPojo.getUnread_count());
            eVar.eQ(imMessageCenterPojo.getGroup_name());
            eVar.eR(imMessageCenterPojo.getLast_content());
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
