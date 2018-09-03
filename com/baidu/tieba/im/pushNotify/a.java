package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.messageCenter.c;
import com.baidu.tbadk.coreExtra.model.e;
import com.baidu.tieba.f;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.settingcache.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static volatile a eAD;
    private List<ImMessageCenterPojo> mList = new LinkedList();
    private final CustomMessageListener enk = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.pushNotify.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016002) {
                    a.this.c(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016004) {
                    a.this.e(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016007) {
                    a.this.d(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016001) {
                    if (a.this.mList != null) {
                        a.this.mList.clear();
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dl().c(new e());
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dl().setMsgChat(0);
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DD();
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dl().Dy();
                } else if (customResponsedMessage.getCmd() == 2016010 && a.this.mList != null) {
                    a.this.fn(false);
                }
            }
        }
    };

    public static a aMX() {
        if (eAD == null) {
            synchronized (a.class) {
                if (eAD == null) {
                    eAD = new a();
                }
            }
        }
        return eAD;
    }

    private a() {
        registerListener();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(2016004, this.enk);
        MessageManager.getInstance().registerListener(2016007, this.enk);
        MessageManager.getInstance().registerListener(2016001, this.enk);
        MessageManager.getInstance().registerListener(2016010, this.enk);
        MessageManager.getInstance().registerListener(2016002, this.enk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            boolean q = q(data);
            if (memoryChangedMessage.getType() == 1) {
                c(data, this.mList);
            } else if (memoryChangedMessage.getType() == 2) {
                d(data, this.mList);
            }
            fn(q);
        }
    }

    private boolean q(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
            return com.baidu.tieba.im.settingcache.e.aNt().bt(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return com.baidu.tieba.im.settingcache.b.aNq().bt(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 4) {
            return d.aNs().bt(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        return imMessageCenterPojo.getCustomGroupType() == -3 || imMessageCenterPojo.getCustomGroupType() == -4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
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
    public void fn(boolean z) {
        e eVar = new e();
        eVar.br(z);
        d(eVar);
        eVar.EC();
        eVar.ED();
        eVar.eg(com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DH().EW());
        eVar.ei(com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DH().EK());
        eVar.el(com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DH().EI());
        eVar.ek(com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DH().EH());
        eVar.ej(com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DH().EF());
        n(eVar.Fc(), com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DH().Fc());
        if (!c.DS().Eh()) {
            eVar.ec(0);
        }
        if (!c.DS().Ea()) {
            eVar.em(0);
        }
        if (!c.DS().El()) {
            eVar.ef(0);
            eVar.en(0);
            eVar.ep(0);
        }
        if (c.DS().DV() <= 0) {
            eVar.ec(0);
            eVar.em(0);
            eVar.en(0);
            eVar.ef(0);
            eVar.ep(0);
            eVar.eo(0);
            eVar.br(false);
        }
        if ((((((eVar.EW() + eVar.EE()) + eVar.EF()) + eVar.EH()) + eVar.Fa()) + eVar.EI()) - eVar.EL() <= 0) {
            eVar.br(false);
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().b(eVar);
    }

    private void n(List<e.a> list, List<e.a> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (e.a aVar : list) {
                if (aVar != null) {
                    for (e.a aVar2 : list2) {
                        if (aVar2 != null && ap.equals(aVar.gid, aVar2.gid)) {
                            aVar.aFu = aVar2.unReadCount;
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
                    a(imMessageCenterPojo, eVar);
                    b(imMessageCenterPojo, eVar);
                    c(imMessageCenterPojo, eVar);
                    f(imMessageCenterPojo, eVar);
                    g(imMessageCenterPojo, eVar);
                    e(imMessageCenterPojo, eVar);
                    d(imMessageCenterPojo, eVar);
                }
            }
        }
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 1) {
            HashMap<String, String> ES = eVar.ES();
            if (!com.baidu.tieba.im.settingcache.b.aNq().bt(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                eVar.eh(eVar.EL() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    eVar.fK(imMessageCenterPojo.getLast_content());
                } else {
                    eVar.fK(imMessageCenterPojo.getLast_user_name() + SystemInfoUtil.COLON + imMessageCenterPojo.getLast_content());
                }
                ES.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            eVar.ec(eVar.EE() + imMessageCenterPojo.getUnread_count());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        int userType;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10 = null;
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && d.aNs().bt(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0 && (userType = imMessageCenterPojo.getUserType()) != 3) {
            e.a aVar = new e.a();
            aVar.gid = imMessageCenterPojo.getGid();
            aVar.aFt = imMessageCenterPojo.getGroup_name();
            if (userType == 4) {
                try {
                    JSONArray jSONArray = new JSONArray(imMessageCenterPojo.getLastContentRawData());
                    if (jSONArray.length() == 1) {
                        JSONObject jSONObject = jSONArray.getJSONObject(0);
                        str9 = jSONObject.optString("title", null);
                        try {
                            str8 = jSONObject.optString("text", null);
                            try {
                                str10 = jSONObject.optString("isShow", null);
                            } catch (Exception e) {
                                str2 = str9;
                                str = str8;
                                e = e;
                                BdLog.e(e);
                                str3 = str2;
                                String str11 = str;
                                str4 = null;
                                str5 = str11;
                                if (str5 != null) {
                                }
                                if (str6 == null) {
                                }
                                aVar.title = str6;
                                aVar.content = str7;
                                aVar.aFv = str4;
                                aVar.aFs = imMessageCenterPojo.getGroup_name() + SystemInfoUtil.COLON + imMessageCenterPojo.getLast_content();
                                aVar.userType = userType;
                                aVar.unReadCount = imMessageCenterPojo.getUnread_count();
                                eVar.Fc().add(aVar);
                                if (userType == 4) {
                                }
                                eVar.ef(eVar.EI() + imMessageCenterPojo.getUnread_count());
                            }
                        } catch (Exception e2) {
                            e = e2;
                            str2 = str9;
                            str = null;
                        }
                    } else {
                        str8 = null;
                        str9 = null;
                    }
                    String str12 = str10;
                    str5 = str8;
                    str3 = str9;
                    str4 = str12;
                } catch (Exception e3) {
                    e = e3;
                    str = null;
                    str2 = null;
                }
                if (str5 != null) {
                    str6 = imMessageCenterPojo.getGroup_name();
                    str7 = imMessageCenterPojo.getLast_content();
                } else {
                    String str13 = str5;
                    str6 = str3;
                    str7 = str13;
                }
                if (str6 == null) {
                    str6 = imMessageCenterPojo.getGroup_name();
                }
                aVar.title = str6;
                aVar.content = str7;
                aVar.aFv = str4;
                aVar.aFs = imMessageCenterPojo.getGroup_name() + SystemInfoUtil.COLON + imMessageCenterPojo.getLast_content();
            } else {
                aVar.content = TbadkCoreApplication.getInst().getContext().getString(f.j.chosen_pb_original_bar, imMessageCenterPojo.getGroup_name()) + " : " + imMessageCenterPojo.getLast_content();
                aVar.aFs = aVar.content;
            }
            aVar.userType = userType;
            aVar.unReadCount = imMessageCenterPojo.getUnread_count();
            eVar.Fc().add(aVar);
            if (userType == 4) {
                eVar.ep(eVar.Fd() + imMessageCenterPojo.getUnread_count());
            }
            eVar.ef(eVar.EI() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && com.baidu.tieba.im.settingcache.e.aNt().bt(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                eVar.fQ(imMessageCenterPojo.getLast_content());
                String nameShow = imMessageCenterPojo.getNameShow();
                HashMap<String, String> EY = eVar.EY();
                if (EY != null) {
                    EY.put(imMessageCenterPojo.getGid(), nameShow);
                }
            }
            eVar.em(eVar.EW() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && com.baidu.tieba.im.settingcache.f.aNu().isAcceptNotify()) {
            eVar.eo(imMessageCenterPojo.getUnread_count());
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && com.baidu.tieba.im.settingcache.c.aNr().isAcceptNotify()) {
            eVar.en(imMessageCenterPojo.getUnread_count());
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            eVar.ee(imMessageCenterPojo.getUnread_count());
            eVar.fP(imMessageCenterPojo.getLast_content());
            eVar.fM(imMessageCenterPojo.getGroup_name());
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -3) {
            eVar.fN(imMessageCenterPojo.getGroup_name());
            eVar.fO(imMessageCenterPojo.getLast_content());
            eVar.ed(imMessageCenterPojo.getUnread_count());
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
            return r(imMessageCenterPojo);
        }
        if (imMessageCenterPojo.getCustomGroupType() != -3 && imMessageCenterPojo.getCustomGroupType() != -4) {
            if (imMessageCenterPojo.getCustomGroupType() == 4) {
                return r(imMessageCenterPojo);
            }
            if (imMessageCenterPojo.getCustomGroupType() == -8) {
                return true;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                return r(imMessageCenterPojo);
            }
            return imMessageCenterPojo.getCustomGroupType() == -7;
        }
        return true;
    }

    private boolean r(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        return (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) ? false : true;
    }
}
