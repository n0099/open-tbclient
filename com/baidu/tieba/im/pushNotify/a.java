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
    private static volatile a eHG;
    private List<ImMessageCenterPojo> mList = new LinkedList();
    private final CustomMessageListener eus = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.pushNotify.a.1
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gh().c(new e());
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gh().setMsgChat(0);
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gh().Gz();
                    com.baidu.tbadk.coreExtra.messageCenter.a.Gh().Gv();
                } else if (customResponsedMessage.getCmd() == 2016010 && a.this.mList != null) {
                    a.this.fw(false);
                }
            }
        }
    };

    public static a aKc() {
        if (eHG == null) {
            synchronized (a.class) {
                if (eHG == null) {
                    eHG = new a();
                }
            }
        }
        return eHG;
    }

    private a() {
        registerListener();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.eus);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.eus);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CLEAR, this.eus);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.eus);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.eus);
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
            fw(n);
        }
    }

    private boolean n(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
            return com.baidu.tieba.im.settingcache.e.aKv().bh(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return com.baidu.tieba.im.settingcache.b.aKs().bh(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 4) {
            return d.aKu().bh(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
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
    public void fw(boolean z) {
        e eVar = new e();
        eVar.bP(z);
        d(eVar);
        eVar.Hq();
        eVar.Hr();
        eVar.gZ(com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC().HK());
        eVar.hb(com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC().Hy());
        eVar.he(com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC().Hw());
        eVar.hd(com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC().Hv());
        eVar.hc(com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC().Ht());
        eVar.hh(com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC().HO());
        n(eVar.HU(), com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC().HU());
        eVar.hl(com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC().HS());
        o(eVar.HV(), com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC().HV());
        if (!com.baidu.tbadk.coreExtra.messageCenter.b.GE().GT()) {
            eVar.gV(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.b.GE().GM()) {
            eVar.hf(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.b.GE().GY()) {
            eVar.gY(0);
            eVar.hi(0);
            eVar.hm(0);
        }
        if (!TbadkCoreApplication.getInst().isPromotedMessageOn()) {
            eVar.hm(0);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.b.GE().GH() <= 0) {
            eVar.gV(0);
            eVar.hf(0);
            eVar.hi(0);
            eVar.gY(0);
            eVar.hm(0);
            eVar.hj(0);
            eVar.hk(0);
            eVar.bP(false);
        }
        if ((((((((eVar.HK() + eVar.Hs()) + eVar.Ht()) + eVar.Hv()) + eVar.HQ()) + eVar.Hw()) + eVar.HO()) + eVar.HS()) - eVar.Hz() <= 0) {
            eVar.bP(false);
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.Gh().b(eVar);
    }

    private void n(List<e.b> list, List<e.b> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (e.b bVar : list) {
                if (bVar != null) {
                    for (e.b bVar2 : list2) {
                        if (bVar2 != null && bVar.biE == bVar2.biE) {
                            bVar.biF = bVar2.unReadCount;
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
                        if (aVar2 != null && aVar.biE == aVar2.biE) {
                            aVar.biF = aVar2.unReadCount;
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
            aVar.biE = com.baidu.adp.lib.g.b.h(imMessageCenterPojo.getGid(), 0);
            aVar.groupName = imMessageCenterPojo.getGroup_name();
            String string = TbadkCoreApplication.getInst().getResources().getString(d.j.live_chat_room_more_livenotify);
            String string2 = TbadkCoreApplication.getInst().getResources().getString(d.j.living_vip_msg_start, imMessageCenterPojo.getGroup_name());
            aVar.title = string;
            aVar.content = string2;
            aVar.unReadCount = imMessageCenterPojo.getUnread_count();
            eVar.HV().add(aVar);
            eVar.hk(eVar.HS() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 1) {
            HashMap<String, String> HG = eVar.HG();
            if (!com.baidu.tieba.im.settingcache.b.aKs().bh(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                eVar.ha(eVar.Hz() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    eVar.fi(imMessageCenterPojo.getLast_content());
                } else {
                    eVar.fi(imMessageCenterPojo.getLast_user_name() + ":" + imMessageCenterPojo.getLast_content());
                }
                HG.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            eVar.gV(eVar.Hs() + imMessageCenterPojo.getUnread_count());
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
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && com.baidu.tieba.im.settingcache.d.aKu().bh(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0 && (userType = imMessageCenterPojo.getUserType()) != 3) {
            e.b bVar = new e.b();
            bVar.biE = com.baidu.adp.lib.g.b.h(imMessageCenterPojo.getGid(), 0);
            bVar.biH = imMessageCenterPojo.getGroup_name();
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
                            bVar.biG = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
                            bVar.userType = userType;
                            bVar.unReadCount = imMessageCenterPojo.getUnread_count();
                            eVar.HU().add(bVar);
                            if (userType == 4) {
                            }
                            eVar.gY(eVar.Hw() + imMessageCenterPojo.getUnread_count());
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
                bVar.biG = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
            } else {
                bVar.content = TbadkCoreApplication.getInst().getContext().getString(d.j.chosen_pb_original_bar, imMessageCenterPojo.getGroup_name()) + " : " + imMessageCenterPojo.getLast_content();
                bVar.biG = bVar.content;
            }
            bVar.userType = userType;
            bVar.unReadCount = imMessageCenterPojo.getUnread_count();
            eVar.HU().add(bVar);
            if (userType == 4) {
                eVar.hm(eVar.HW() + imMessageCenterPojo.getUnread_count());
            }
            eVar.gY(eVar.Hw() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && com.baidu.tieba.im.settingcache.e.aKv().bh(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                eVar.fo(imMessageCenterPojo.getLast_content());
                String group_name = imMessageCenterPojo.getGroup_name();
                HashMap<String, String> HM = eVar.HM();
                if (HM != null) {
                    HM.put(imMessageCenterPojo.getGid(), group_name);
                }
            }
            eVar.hf(eVar.HK() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && f.aKw().isAcceptNotify()) {
            eVar.hj(imMessageCenterPojo.getUnread_count());
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && c.aKt().isAcceptNotify()) {
            eVar.hi(imMessageCenterPojo.getUnread_count());
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            eVar.gX(imMessageCenterPojo.getUnread_count());
            eVar.fn(imMessageCenterPojo.getLast_content());
            eVar.fk(imMessageCenterPojo.getGroup_name());
        }
    }

    private void h(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -3) {
            eVar.fl(imMessageCenterPojo.getGroup_name());
            eVar.fm(imMessageCenterPojo.getLast_content());
            eVar.gW(imMessageCenterPojo.getUnread_count());
        }
    }

    private void i(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -5) {
            eVar.hg(imMessageCenterPojo.getUnread_count());
            eVar.fq(imMessageCenterPojo.getGroup_name());
            eVar.fr(imMessageCenterPojo.getLast_content());
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
