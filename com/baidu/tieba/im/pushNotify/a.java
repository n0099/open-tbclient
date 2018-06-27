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
import com.baidu.tieba.d;
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
    private static volatile a ewO;
    private List<ImMessageCenterPojo> mList = new LinkedList();
    private final CustomMessageListener ejw = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.pushNotify.a.1
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
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dp().c(new e());
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dp().setMsgChat(0);
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dp().DH();
                    com.baidu.tbadk.coreExtra.messageCenter.a.Dp().DC();
                } else if (customResponsedMessage.getCmd() == 2016010 && a.this.mList != null) {
                    a.this.fm(false);
                }
            }
        }
    };

    public static a aMa() {
        if (ewO == null) {
            synchronized (a.class) {
                if (ewO == null) {
                    ewO = new a();
                }
            }
        }
        return ewO;
    }

    private a() {
        registerListener();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(2016004, this.ejw);
        MessageManager.getInstance().registerListener(2016007, this.ejw);
        MessageManager.getInstance().registerListener(2016001, this.ejw);
        MessageManager.getInstance().registerListener(2016010, this.ejw);
        MessageManager.getInstance().registerListener(2016002, this.ejw);
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
            fm(q);
        }
    }

    private boolean q(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
            return com.baidu.tieba.im.settingcache.e.aMw().bv(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return com.baidu.tieba.im.settingcache.b.aMt().bv(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 4) {
            return d.aMv().bv(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
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
    public void fm(boolean z) {
        e eVar = new e();
        eVar.bs(z);
        d(eVar);
        eVar.EG();
        eVar.EH();
        eVar.ee(com.baidu.tbadk.coreExtra.messageCenter.a.Dp().DL().Fa());
        eVar.eg(com.baidu.tbadk.coreExtra.messageCenter.a.Dp().DL().EO());
        eVar.ej(com.baidu.tbadk.coreExtra.messageCenter.a.Dp().DL().EM());
        eVar.ei(com.baidu.tbadk.coreExtra.messageCenter.a.Dp().DL().EL());
        eVar.eh(com.baidu.tbadk.coreExtra.messageCenter.a.Dp().DL().EJ());
        n(eVar.Fg(), com.baidu.tbadk.coreExtra.messageCenter.a.Dp().DL().Fg());
        if (!c.DW().El()) {
            eVar.ea(0);
        }
        if (!c.DW().Ee()) {
            eVar.ek(0);
        }
        if (!c.DW().Ep()) {
            eVar.ed(0);
            eVar.el(0);
            eVar.en(0);
        }
        if (c.DW().DZ() <= 0) {
            eVar.ea(0);
            eVar.ek(0);
            eVar.el(0);
            eVar.ed(0);
            eVar.en(0);
            eVar.em(0);
            eVar.bs(false);
        }
        if ((((((eVar.Fa() + eVar.EI()) + eVar.EJ()) + eVar.EL()) + eVar.Fe()) + eVar.EM()) - eVar.EP() <= 0) {
            eVar.bs(false);
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.Dp().b(eVar);
    }

    private void n(List<e.a> list, List<e.a> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (e.a aVar : list) {
                if (aVar != null) {
                    for (e.a aVar2 : list2) {
                        if (aVar2 != null && ap.equals(aVar.gid, aVar2.gid)) {
                            aVar.aFv = aVar2.unReadCount;
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
            HashMap<String, String> EW = eVar.EW();
            if (!com.baidu.tieba.im.settingcache.b.aMt().bv(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                eVar.ef(eVar.EP() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    eVar.fM(imMessageCenterPojo.getLast_content());
                } else {
                    eVar.fM(imMessageCenterPojo.getLast_user_name() + SystemInfoUtil.COLON + imMessageCenterPojo.getLast_content());
                }
                EW.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            eVar.ea(eVar.EI() + imMessageCenterPojo.getUnread_count());
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
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && d.aMv().bv(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0 && (userType = imMessageCenterPojo.getUserType()) != 3) {
            e.a aVar = new e.a();
            aVar.gid = imMessageCenterPojo.getGid();
            aVar.aFu = imMessageCenterPojo.getGroup_name();
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
                                aVar.aFw = str4;
                                aVar.aFt = imMessageCenterPojo.getGroup_name() + SystemInfoUtil.COLON + imMessageCenterPojo.getLast_content();
                                aVar.userType = userType;
                                aVar.unReadCount = imMessageCenterPojo.getUnread_count();
                                eVar.Fg().add(aVar);
                                if (userType == 4) {
                                }
                                eVar.ed(eVar.EM() + imMessageCenterPojo.getUnread_count());
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
                aVar.aFw = str4;
                aVar.aFt = imMessageCenterPojo.getGroup_name() + SystemInfoUtil.COLON + imMessageCenterPojo.getLast_content();
            } else {
                aVar.content = TbadkCoreApplication.getInst().getContext().getString(d.k.chosen_pb_original_bar, imMessageCenterPojo.getGroup_name()) + " : " + imMessageCenterPojo.getLast_content();
                aVar.aFt = aVar.content;
            }
            aVar.userType = userType;
            aVar.unReadCount = imMessageCenterPojo.getUnread_count();
            eVar.Fg().add(aVar);
            if (userType == 4) {
                eVar.en(eVar.Fh() + imMessageCenterPojo.getUnread_count());
            }
            eVar.ed(eVar.EM() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && com.baidu.tieba.im.settingcache.e.aMw().bv(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                eVar.fS(imMessageCenterPojo.getLast_content());
                String nameShow = imMessageCenterPojo.getNameShow();
                HashMap<String, String> Fc = eVar.Fc();
                if (Fc != null) {
                    Fc.put(imMessageCenterPojo.getGid(), nameShow);
                }
            }
            eVar.ek(eVar.Fa() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && f.aMx().isAcceptNotify()) {
            eVar.em(imMessageCenterPojo.getUnread_count());
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && com.baidu.tieba.im.settingcache.c.aMu().isAcceptNotify()) {
            eVar.el(imMessageCenterPojo.getUnread_count());
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            eVar.ec(imMessageCenterPojo.getUnread_count());
            eVar.fR(imMessageCenterPojo.getLast_content());
            eVar.fO(imMessageCenterPojo.getGroup_name());
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -3) {
            eVar.fP(imMessageCenterPojo.getGroup_name());
            eVar.fQ(imMessageCenterPojo.getLast_content());
            eVar.eb(imMessageCenterPojo.getUnread_count());
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
