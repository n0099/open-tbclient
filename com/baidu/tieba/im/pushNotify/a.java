package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.messageCenter.c;
import com.baidu.tbadk.coreExtra.model.e;
import com.baidu.tieba.e;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.settingcache.d;
import com.baidu.tieba.im.settingcache.f;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static volatile a fbp;
    private List<ImMessageCenterPojo> mList = new LinkedList();
    private final CustomMessageListener eOe = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.pushNotify.a.1
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.If().c(new e());
                    com.baidu.tbadk.coreExtra.messageCenter.a.If().setMsgChat(0);
                    com.baidu.tbadk.coreExtra.messageCenter.a.If().Ix();
                    com.baidu.tbadk.coreExtra.messageCenter.a.If().Is();
                } else if (customResponsedMessage.getCmd() == 2016010 && a.this.mList != null) {
                    a.this.gm(false);
                }
            }
        }
    };

    public static a aVc() {
        if (fbp == null) {
            synchronized (a.class) {
                if (fbp == null) {
                    fbp = new a();
                }
            }
        }
        return fbp;
    }

    private a() {
        registerListener();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(2016004, this.eOe);
        MessageManager.getInstance().registerListener(2016007, this.eOe);
        MessageManager.getInstance().registerListener(2016001, this.eOe);
        MessageManager.getInstance().registerListener(2016010, this.eOe);
        MessageManager.getInstance().registerListener(2016002, this.eOe);
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
            gm(q);
        }
    }

    private boolean q(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
            return com.baidu.tieba.im.settingcache.e.aVy().bT(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return com.baidu.tieba.im.settingcache.b.aVv().bT(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 4) {
            return d.aVx().bT(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
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
    public void gm(boolean z) {
        e eVar = new e();
        eVar.cf(z);
        d(eVar);
        eVar.Jz();
        eVar.JA();
        eVar.fe(com.baidu.tbadk.coreExtra.messageCenter.a.If().IB().JT());
        eVar.fg(com.baidu.tbadk.coreExtra.messageCenter.a.If().IB().JH());
        eVar.fj(com.baidu.tbadk.coreExtra.messageCenter.a.If().IB().JF());
        eVar.fi(com.baidu.tbadk.coreExtra.messageCenter.a.If().IB().JE());
        eVar.fh(com.baidu.tbadk.coreExtra.messageCenter.a.If().IB().JC());
        n(eVar.JZ(), com.baidu.tbadk.coreExtra.messageCenter.a.If().IB().JZ());
        if (!c.IM().Jc()) {
            eVar.fa(0);
        }
        if (!c.IM().IU()) {
            eVar.fk(0);
        }
        if (!c.IM().Jg()) {
            eVar.fd(0);
            eVar.fl(0);
            eVar.fn(0);
        }
        if (c.IM().IP() <= 0) {
            eVar.fa(0);
            eVar.fk(0);
            eVar.fl(0);
            eVar.fd(0);
            eVar.fn(0);
            eVar.fm(0);
            eVar.cf(false);
        }
        if ((((((eVar.JT() + eVar.JB()) + eVar.JC()) + eVar.JE()) + eVar.JX()) + eVar.JF()) - eVar.JI() <= 0) {
            eVar.cf(false);
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.If().b(eVar);
    }

    private void n(List<e.a> list, List<e.a> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (e.a aVar : list) {
                if (aVar != null) {
                    for (e.a aVar2 : list2) {
                        if (aVar2 != null && ao.equals(aVar.gid, aVar2.gid)) {
                            aVar.aSf = aVar2.unReadCount;
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
            HashMap<String, String> JP = eVar.JP();
            if (!com.baidu.tieba.im.settingcache.b.aVv().bT(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                eVar.ff(eVar.JI() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    eVar.hc(imMessageCenterPojo.getLast_content());
                } else {
                    eVar.hc(imMessageCenterPojo.getLast_user_name() + ":" + imMessageCenterPojo.getLast_content());
                }
                JP.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            eVar.fa(eVar.JB() + imMessageCenterPojo.getUnread_count());
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
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && d.aVx().bT(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0 && (userType = imMessageCenterPojo.getUserType()) != 3) {
            e.a aVar = new e.a();
            aVar.gid = imMessageCenterPojo.getGid();
            aVar.aSe = imMessageCenterPojo.getGroup_name();
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
                                aVar.aSg = str4;
                                aVar.aSd = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
                                aVar.userType = userType;
                                aVar.unReadCount = imMessageCenterPojo.getUnread_count();
                                eVar.JZ().add(aVar);
                                if (userType == 4) {
                                }
                                eVar.fd(eVar.JF() + imMessageCenterPojo.getUnread_count());
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
                aVar.aSg = str4;
                aVar.aSd = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
            } else {
                aVar.content = TbadkCoreApplication.getInst().getContext().getString(e.j.chosen_pb_original_bar, imMessageCenterPojo.getGroup_name()) + " : " + imMessageCenterPojo.getLast_content();
                aVar.aSd = aVar.content;
            }
            aVar.userType = userType;
            aVar.unReadCount = imMessageCenterPojo.getUnread_count();
            eVar.JZ().add(aVar);
            if (userType == 4) {
                eVar.fn(eVar.Ka() + imMessageCenterPojo.getUnread_count());
            }
            eVar.fd(eVar.JF() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.model.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && com.baidu.tieba.im.settingcache.e.aVy().bT(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                eVar.hi(imMessageCenterPojo.getLast_content());
                String nameShow = imMessageCenterPojo.getNameShow();
                HashMap<String, String> JV = eVar.JV();
                if (JV != null) {
                    JV.put(imMessageCenterPojo.getGid(), nameShow);
                }
            }
            eVar.fk(eVar.JT() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.model.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && f.aVz().isAcceptNotify()) {
            eVar.fm(imMessageCenterPojo.getUnread_count());
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.model.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && com.baidu.tieba.im.settingcache.c.aVw().isAcceptNotify()) {
            eVar.fl(imMessageCenterPojo.getUnread_count());
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.model.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            eVar.fc(imMessageCenterPojo.getUnread_count());
            eVar.hh(imMessageCenterPojo.getLast_content());
            eVar.he(imMessageCenterPojo.getGroup_name());
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tbadk.coreExtra.model.e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -3) {
            eVar.hf(imMessageCenterPojo.getGroup_name());
            eVar.hg(imMessageCenterPojo.getLast_content());
            eVar.fb(imMessageCenterPojo.getUnread_count());
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
