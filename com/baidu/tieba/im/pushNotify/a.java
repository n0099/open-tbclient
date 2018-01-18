package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
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
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static volatile a eHl;
    private List<ImMessageCenterPojo> mList = new LinkedList();
    private final CustomMessageListener etX = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.pushNotify.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016002) {
                    a.this.f(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016004) {
                    a.this.g(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016007) {
                    a.this.h(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016001) {
                    if (a.this.mList != null) {
                        a.this.mList.clear();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gf().c(new e());
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gf().setMsgChat(0);
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gf().Gx();
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gf().Gt();
                } else if (customResponsedMessage.getCmd() == 2016010 && a.this.mList != null) {
                    a.this.ft(false);
                }
            }
        }
    };

    public static a aJX() {
        if (eHl == null) {
            synchronized (a.class) {
                if (eHl == null) {
                    eHl = new a();
                }
            }
        }
        return eHl;
    }

    private a() {
        registerListener();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.etX);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.etX);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CLEAR, this.etX);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.etX);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.etX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            boolean n = n(data);
            if (memoryChangedMessage.getType() == 1) {
                c(data, this.mList);
            } else if (memoryChangedMessage.getType() == 2) {
                d(data, this.mList);
            }
            ft(n);
        }
    }

    private boolean n(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
            return com.baidu.tieba.im.settingcache.e.aKq().bi(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return com.baidu.tieba.im.settingcache.b.aKn().bi(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 4) {
            return d.aKp().bi(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        return imMessageCenterPojo.getCustomGroupType() == -3 || imMessageCenterPojo.getCustomGroupType() == -4 || imMessageCenterPojo.getCustomGroupType() == -5 || imMessageCenterPojo.getCustomGroupType() == -10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CustomResponsedMessage<?> customResponsedMessage) {
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
    public void ft(boolean z) {
        e eVar = new e();
        eVar.bO(z);
        d(eVar);
        eVar.Ho();
        eVar.Hp();
        eVar.gZ(com.baidu.tbadk.coreExtra.messageCenter.a.Gf().GA().HI());
        eVar.hb(com.baidu.tbadk.coreExtra.messageCenter.a.Gf().GA().Hw());
        eVar.he(com.baidu.tbadk.coreExtra.messageCenter.a.Gf().GA().Hu());
        eVar.hd(com.baidu.tbadk.coreExtra.messageCenter.a.Gf().GA().Ht());
        eVar.hc(com.baidu.tbadk.coreExtra.messageCenter.a.Gf().GA().Hr());
        eVar.hh(com.baidu.tbadk.coreExtra.messageCenter.a.Gf().GA().HM());
        n(eVar.HS(), com.baidu.tbadk.coreExtra.messageCenter.a.Gf().GA().HS());
        eVar.hl(com.baidu.tbadk.coreExtra.messageCenter.a.Gf().GA().HQ());
        o(eVar.HT(), com.baidu.tbadk.coreExtra.messageCenter.a.Gf().GA().HT());
        if (!com.baidu.tbadk.coreExtra.messageCenter.b.GC().GR()) {
            eVar.gV(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.b.GC().GK()) {
            eVar.hf(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.b.GC().GW()) {
            eVar.gY(0);
            eVar.hi(0);
            eVar.hm(0);
        }
        if (!TbadkCoreApplication.getInst().isPromotedMessageOn()) {
            eVar.hm(0);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.b.GC().GF() <= 0) {
            eVar.gV(0);
            eVar.hf(0);
            eVar.hi(0);
            eVar.gY(0);
            eVar.hm(0);
            eVar.hj(0);
            eVar.hk(0);
            eVar.bO(false);
        }
        if ((((((((eVar.HI() + eVar.Hq()) + eVar.Hr()) + eVar.Ht()) + eVar.HO()) + eVar.Hu()) + eVar.HM()) + eVar.HQ()) - eVar.Hx() <= 0) {
            eVar.bO(false);
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.Gf().b(eVar);
    }

    private void n(List<e.b> list, List<e.b> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (e.b bVar : list) {
                if (bVar != null) {
                    for (e.b bVar2 : list2) {
                        if (bVar2 != null && bVar.biw == bVar2.biw) {
                            bVar.bix = bVar2.unReadCount;
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
                        if (aVar2 != null && aVar.biw == aVar2.biw) {
                            aVar.bix = aVar2.unReadCount;
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
            aVar.biw = com.baidu.adp.lib.g.b.h(imMessageCenterPojo.getGid(), 0);
            aVar.groupName = imMessageCenterPojo.getGroup_name();
            String string = TbadkCoreApplication.getInst().getResources().getString(d.j.live_chat_room_more_livenotify);
            String string2 = TbadkCoreApplication.getInst().getResources().getString(d.j.living_vip_msg_start, imMessageCenterPojo.getGroup_name());
            aVar.title = string;
            aVar.content = string2;
            aVar.unReadCount = imMessageCenterPojo.getUnread_count();
            eVar.HT().add(aVar);
            eVar.hk(eVar.HQ() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 1) {
            HashMap<String, String> HE = eVar.HE();
            if (!com.baidu.tieba.im.settingcache.b.aKn().bi(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                eVar.ha(eVar.Hx() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    eVar.fa(imMessageCenterPojo.getLast_content());
                } else {
                    eVar.fa(imMessageCenterPojo.getLast_user_name() + ":" + imMessageCenterPojo.getLast_content());
                }
                HE.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            eVar.gV(eVar.Hq() + imMessageCenterPojo.getUnread_count());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        int userType;
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = null;
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && com.baidu.tieba.im.settingcache.d.aKp().bi(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0 && (userType = imMessageCenterPojo.getUserType()) != 3) {
            e.b bVar = new e.b();
            bVar.biw = com.baidu.adp.lib.g.b.h(imMessageCenterPojo.getGid(), 0);
            bVar.biz = imMessageCenterPojo.getGroup_name();
            if (userType == 4) {
                try {
                    JSONArray jSONArray = new JSONArray(imMessageCenterPojo.getLastContentRawData());
                    if (jSONArray.length() == 1) {
                        JSONObject jSONObject = jSONArray.getJSONObject(0);
                        str2 = jSONObject.optString("title", null);
                        try {
                            str5 = jSONObject.optString("text", null);
                        } catch (Exception e) {
                            str = str2;
                            e = e;
                            BdLog.e(e);
                            str2 = str;
                            if (str5 != null) {
                            }
                            if (str3 == null) {
                            }
                            bVar.title = str3;
                            bVar.content = str4;
                            bVar.biy = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
                            bVar.userType = userType;
                            bVar.unReadCount = imMessageCenterPojo.getUnread_count();
                            eVar.HS().add(bVar);
                            if (userType == 4) {
                            }
                            eVar.gY(eVar.Hu() + imMessageCenterPojo.getUnread_count());
                        }
                    } else {
                        str2 = null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    str = null;
                }
                if (str5 != null) {
                    str3 = imMessageCenterPojo.getGroup_name();
                    str4 = imMessageCenterPojo.getLast_content();
                } else {
                    String str6 = str5;
                    str3 = str2;
                    str4 = str6;
                }
                if (str3 == null) {
                    str3 = imMessageCenterPojo.getGroup_name();
                }
                bVar.title = str3;
                bVar.content = str4;
                bVar.biy = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
            } else {
                bVar.content = TbadkCoreApplication.getInst().getContext().getString(d.j.chosen_pb_original_bar, imMessageCenterPojo.getGroup_name()) + " : " + imMessageCenterPojo.getLast_content();
                bVar.biy = bVar.content;
            }
            bVar.userType = userType;
            bVar.unReadCount = imMessageCenterPojo.getUnread_count();
            eVar.HS().add(bVar);
            if (userType == 4) {
                eVar.hm(eVar.HU() + imMessageCenterPojo.getUnread_count());
            }
            eVar.gY(eVar.Hu() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && com.baidu.tieba.im.settingcache.e.aKq().bi(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                eVar.fg(imMessageCenterPojo.getLast_content());
                String group_name = imMessageCenterPojo.getGroup_name();
                HashMap<String, String> HK = eVar.HK();
                if (HK != null) {
                    HK.put(imMessageCenterPojo.getGid(), group_name);
                }
            }
            eVar.hf(eVar.HI() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && f.aKr().isAcceptNotify()) {
            eVar.hj(imMessageCenterPojo.getUnread_count());
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && c.aKo().isAcceptNotify()) {
            eVar.hi(imMessageCenterPojo.getUnread_count());
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            eVar.gX(imMessageCenterPojo.getUnread_count());
            eVar.ff(imMessageCenterPojo.getLast_content());
            eVar.fc(imMessageCenterPojo.getGroup_name());
        }
    }

    private void h(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -3) {
            eVar.fd(imMessageCenterPojo.getGroup_name());
            eVar.fe(imMessageCenterPojo.getLast_content());
            eVar.gW(imMessageCenterPojo.getUnread_count());
        }
    }

    private void i(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -5) {
            eVar.hg(imMessageCenterPojo.getUnread_count());
            eVar.fi(imMessageCenterPojo.getGroup_name());
            eVar.fj(imMessageCenterPojo.getLast_content());
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
