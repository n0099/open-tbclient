package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.model.e;
import com.baidu.tieba.R;
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
    private static volatile a jiO;
    private List<ImMessageCenterPojo> mList = new LinkedList();
    private final CustomMessageListener iTP = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.pushNotify.a.1
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.bfl().c(new e());
                    com.baidu.tbadk.coreExtra.messageCenter.b.bfl().setMsgChat(0);
                    com.baidu.tbadk.coreExtra.messageCenter.b.bfl().bfD();
                    com.baidu.tbadk.coreExtra.messageCenter.b.bfl().bfx();
                } else if (customResponsedMessage.getCmd() == 2016010 && a.this.mList != null) {
                    a.this.refresh(false);
                }
            }
        }
    };

    public static a cwY() {
        if (jiO == null) {
            synchronized (a.class) {
                if (jiO == null) {
                    jiO = new a();
                }
            }
        }
        return jiO;
    }

    private a() {
        registerListener();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.iTP);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.iTP);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CLEAR, this.iTP);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.iTP);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.iTP);
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
            boolean o = o(data);
            if (memoryChangedMessage.getType() == 1) {
                c(data, this.mList);
            } else if (memoryChangedMessage.getType() == 2) {
                d(data, this.mList);
            }
            refresh(o);
        }
    }

    private boolean o(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
            return com.baidu.tieba.im.settingcache.e.cxt().eC(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return com.baidu.tieba.im.settingcache.b.cxq().eC(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 4) {
            return d.cxs().eC(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
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
    public void refresh(boolean z) {
        e eVar = new e();
        eVar.setShowInNotifyBar(z);
        d(eVar);
        eVar.setLastMsgGroupName();
        eVar.setLastPrivateMsgUserName();
        eVar.setUnReadPrivateMessagePreCount(com.baidu.tbadk.coreExtra.messageCenter.b.bfl().bfH().getUnReadPrivateMessageCount());
        eVar.setUnReadGroupMessagePreCount(com.baidu.tbadk.coreExtra.messageCenter.b.bfl().bfH().getUnReadGroupMessageCount());
        eVar.setUnReadOfficialMessagePreCount(com.baidu.tbadk.coreExtra.messageCenter.b.bfl().bfH().getUnReadOfficialMessageCount());
        eVar.setUnReadGroupValidatePre(com.baidu.tbadk.coreExtra.messageCenter.b.bfl().bfH().getUnReadGroupValidate());
        eVar.setUnReadGroupUpdatesPre(com.baidu.tbadk.coreExtra.messageCenter.b.bfl().bfH().getUnReadGroupUpdates());
        s(eVar.getOfficialNotificationListData(), com.baidu.tbadk.coreExtra.messageCenter.b.bfl().bfH().getOfficialNotificationListData());
        if (!com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bge()) {
            eVar.setUnReadGroupMessage(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfW()) {
            eVar.setUnReadPrivateMessageCount(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bgi()) {
            eVar.setUnReadOfficialMessageCount(0);
            eVar.setUnReadOfficialMergeCount(0);
            eVar.setUnReadOfficialAccountCount(0);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfR() <= 0) {
            eVar.setUnReadGroupMessage(0);
            eVar.setUnReadPrivateMessageCount(0);
            eVar.setUnReadOfficialMergeCount(0);
            eVar.setUnReadOfficialMessageCount(0);
            eVar.setUnReadOfficialAccountCount(0);
            eVar.setUnReadStrangerMergeCount(0);
            eVar.setShowInNotifyBar(false);
        }
        if ((((((eVar.getUnReadPrivateMessageCount() + eVar.getUnReadGroupMessage()) + eVar.getUnReadGroupUpdates()) + eVar.getUnReadGroupValidate()) + eVar.getUnReadOfficialMergeCount()) + eVar.getUnReadOfficialMessageCount()) - eVar.getUnReadGroupMessageNotNotify() <= 0) {
            eVar.setShowInNotifyBar(false);
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.bfl().b(eVar);
    }

    private void s(List<e.a> list, List<e.a> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (e.a aVar : list) {
                if (aVar != null) {
                    for (e.a aVar2 : list2) {
                        if (aVar2 != null && as.equals(aVar.gid, aVar2.gid)) {
                            aVar.unReadPreCount = aVar2.unReadCount;
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
            HashMap<String, String> groupGidName = eVar.getGroupGidName();
            if (!com.baidu.tieba.im.settingcache.b.cxq().eC(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                eVar.setUnReadGroupMessageNotNotify(eVar.getUnReadGroupMessageNotNotify() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    eVar.setLatestSummary(imMessageCenterPojo.getLast_content());
                } else {
                    eVar.setLatestSummary(imMessageCenterPojo.getLast_user_name() + ":" + imMessageCenterPojo.getLast_content());
                }
                groupGidName.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            eVar.setUnReadGroupMessage(eVar.getUnReadGroupMessage() + imMessageCenterPojo.getUnread_count());
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
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && d.cxs().eC(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0 && (userType = imMessageCenterPojo.getUserType()) != 3) {
            e.a aVar = new e.a();
            aVar.gid = imMessageCenterPojo.getGid();
            aVar.gName = imMessageCenterPojo.getGroup_name();
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
                                aVar.isShow = str4;
                                aVar.tickerText = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
                                aVar.userType = userType;
                                aVar.unReadCount = imMessageCenterPojo.getUnread_count();
                                eVar.getOfficialNotificationListData().add(aVar);
                                if (userType == 4) {
                                }
                                eVar.setUnReadOfficialMessageCount(eVar.getUnReadOfficialMessageCount() + imMessageCenterPojo.getUnread_count());
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
                aVar.isShow = str4;
                aVar.tickerText = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
            } else {
                aVar.content = TbadkCoreApplication.getInst().getContext().getString(R.string.chosen_pb_original_bar, imMessageCenterPojo.getGroup_name()) + " : " + imMessageCenterPojo.getLast_content();
                aVar.tickerText = aVar.content;
            }
            aVar.userType = userType;
            aVar.unReadCount = imMessageCenterPojo.getUnread_count();
            eVar.getOfficialNotificationListData().add(aVar);
            if (userType == 4) {
                eVar.setUnReadOfficialAccountCount(eVar.getUnReadOfficialAccountCount() + imMessageCenterPojo.getUnread_count());
            }
            eVar.setUnReadOfficialMessageCount(eVar.getUnReadOfficialMessageCount() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && com.baidu.tieba.im.settingcache.e.cxt().eC(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                eVar.setLatestSummaryPrivateMessage(imMessageCenterPojo.getLast_content());
                String nameShow = imMessageCenterPojo.getNameShow();
                HashMap<String, String> privateGidName = eVar.getPrivateGidName();
                if (privateGidName != null) {
                    privateGidName.put(imMessageCenterPojo.getGid(), nameShow);
                }
            }
            eVar.setUnReadPrivateMessageCount(eVar.getUnReadPrivateMessageCount() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && f.cxu().isAcceptNotify()) {
            eVar.setUnReadStrangerMergeCount(imMessageCenterPojo.getUnread_count());
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && c.cxr().isAcceptNotify()) {
            eVar.setUnReadOfficialMergeCount(imMessageCenterPojo.getUnread_count());
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            eVar.setUnReadGroupValidate(imMessageCenterPojo.getUnread_count());
            eVar.setLatestSummaryValidate(imMessageCenterPojo.getLast_content());
            eVar.setGroupValidateName(imMessageCenterPojo.getGroup_name());
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo, e eVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -3) {
            eVar.setGroupUpdatesName(imMessageCenterPojo.getGroup_name());
            eVar.setLatestSummaryGroupUpdates(imMessageCenterPojo.getLast_content());
            eVar.setUnReadGroupUpdates(imMessageCenterPojo.getUnread_count());
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
            return p(imMessageCenterPojo);
        }
        if (imMessageCenterPojo.getCustomGroupType() != -3 && imMessageCenterPojo.getCustomGroupType() != -4) {
            if (imMessageCenterPojo.getCustomGroupType() == 4) {
                return p(imMessageCenterPojo);
            }
            if (imMessageCenterPojo.getCustomGroupType() == -8) {
                return true;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                return p(imMessageCenterPojo);
            }
            return imMessageCenterPojo.getCustomGroupType() == -7;
        }
        return true;
    }

    private boolean p(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        return (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) ? false : true;
    }
}
