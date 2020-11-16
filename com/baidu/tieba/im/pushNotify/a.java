package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.model.f;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.settingcache.c;
import com.baidu.tieba.im.settingcache.d;
import com.baidu.tieba.im.settingcache.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static volatile a koz;
    private List<ImMessageCenterPojo> mList = new LinkedList();
    private final CustomMessageListener jZz = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.pushNotify.a.1
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.bvi().c(new f());
                    com.baidu.tbadk.coreExtra.messageCenter.b.bvi().setMsgChat(0);
                    com.baidu.tbadk.coreExtra.messageCenter.b.bvi().bvA();
                    com.baidu.tbadk.coreExtra.messageCenter.b.bvi().bvu();
                } else if (customResponsedMessage.getCmd() == 2016010 && a.this.mList != null) {
                    a.this.refresh(false);
                }
            }
        }
    };

    public static a cUs() {
        if (koz == null) {
            synchronized (a.class) {
                if (koz == null) {
                    koz = new a();
                }
            }
        }
        return koz;
    }

    private a() {
        registerListener();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.jZz);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.jZz);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CLEAR, this.jZz);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.jZz);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.jZz);
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
            return e.cUN().ft(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() != 1) {
            if (imMessageCenterPojo.getCustomGroupType() == 4) {
                return d.cUM().ft(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            }
            if (imMessageCenterPojo.getCustomGroupType() == -3 || imMessageCenterPojo.getCustomGroupType() == -4) {
            }
            return false;
        }
        return false;
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
        f fVar = new f();
        fVar.setShowInNotifyBar(z);
        d(fVar);
        fVar.setLastMsgGroupName();
        fVar.setLastPrivateMsgUserName();
        fVar.setUnReadPrivateMessagePreCount(com.baidu.tbadk.coreExtra.messageCenter.b.bvi().bvE().getUnReadPrivateMessageCount());
        fVar.setUnReadGroupMessagePreCount(com.baidu.tbadk.coreExtra.messageCenter.b.bvi().bvE().getUnReadGroupMessageCount());
        fVar.setUnReadOfficialMessagePreCount(com.baidu.tbadk.coreExtra.messageCenter.b.bvi().bvE().getUnReadOfficialMessageCount());
        fVar.setUnReadGroupValidatePre(com.baidu.tbadk.coreExtra.messageCenter.b.bvi().bvE().getUnReadGroupValidate());
        fVar.setUnReadGroupUpdatesPre(com.baidu.tbadk.coreExtra.messageCenter.b.bvi().bvE().getUnReadGroupUpdates());
        A(fVar.getOfficialNotificationListData(), com.baidu.tbadk.coreExtra.messageCenter.b.bvi().bvE().getOfficialNotificationListData());
        if (!com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bwb()) {
            fVar.setUnReadGroupMessage(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvT()) {
            fVar.setUnReadPrivateMessageCount(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bwf()) {
            fVar.setUnReadOfficialMessageCount(0);
            fVar.setUnReadOfficialMergeCount(0);
            fVar.setUnReadOfficialAccountCount(0);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bvL().bvO() <= 0) {
            fVar.setUnReadGroupMessage(0);
            fVar.setUnReadPrivateMessageCount(0);
            fVar.setUnReadOfficialMergeCount(0);
            fVar.setUnReadOfficialMessageCount(0);
            fVar.setUnReadOfficialAccountCount(0);
            fVar.setUnReadStrangerMergeCount(0);
            fVar.setShowInNotifyBar(false);
        }
        if ((((((fVar.getUnReadPrivateMessageCount() + fVar.getUnReadGroupMessage()) + fVar.getUnReadGroupUpdates()) + fVar.getUnReadGroupValidate()) + fVar.getUnReadOfficialMergeCount()) + fVar.getUnReadOfficialMessageCount()) - fVar.getUnReadGroupMessageNotNotify() <= 0) {
            fVar.setShowInNotifyBar(false);
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.bvi().b(fVar);
    }

    private void A(List<f.a> list, List<f.a> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (f.a aVar : list) {
                if (aVar != null) {
                    for (f.a aVar2 : list2) {
                        if (aVar2 != null && au.equals(aVar.gid, aVar2.gid)) {
                            aVar.unReadPreCount = aVar2.unReadCount;
                        }
                    }
                }
            }
        }
    }

    private void d(f fVar) {
        if (fVar != null) {
            for (ImMessageCenterPojo imMessageCenterPojo : this.mList) {
                if (imMessageCenterPojo != null && imMessageCenterPojo.getIs_hidden() != 1 && isNeed(imMessageCenterPojo)) {
                    a(imMessageCenterPojo, fVar);
                    b(imMessageCenterPojo, fVar);
                    c(imMessageCenterPojo, fVar);
                    f(imMessageCenterPojo, fVar);
                    g(imMessageCenterPojo, fVar);
                    e(imMessageCenterPojo, fVar);
                    d(imMessageCenterPojo, fVar);
                }
            }
        }
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, f fVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 1) {
            HashMap<String, String> groupGidName = fVar.getGroupGidName();
            if (!com.baidu.tieba.im.settingcache.b.cUK().ft(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                fVar.setUnReadGroupMessageNotNotify(fVar.getUnReadGroupMessageNotNotify() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    fVar.setLatestSummary(imMessageCenterPojo.getLast_content());
                } else {
                    fVar.setLatestSummary(imMessageCenterPojo.getLast_user_name() + ":" + imMessageCenterPojo.getLast_content());
                }
                groupGidName.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            fVar.setUnReadGroupMessage(fVar.getUnReadGroupMessage() + imMessageCenterPojo.getUnread_count());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(ImMessageCenterPojo imMessageCenterPojo, f fVar) {
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
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && d.cUM().ft(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0 && (userType = imMessageCenterPojo.getUserType()) != 3) {
            f.a aVar = new f.a();
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
                                fVar.getOfficialNotificationListData().add(aVar);
                                if (userType == 4) {
                                }
                                fVar.setUnReadOfficialMessageCount(fVar.getUnReadOfficialMessageCount() + imMessageCenterPojo.getUnread_count());
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
            fVar.getOfficialNotificationListData().add(aVar);
            if (userType == 4) {
                fVar.setUnReadOfficialAccountCount(fVar.getUnReadOfficialAccountCount() + imMessageCenterPojo.getUnread_count());
            }
            fVar.setUnReadOfficialMessageCount(fVar.getUnReadOfficialMessageCount() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, f fVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && e.cUN().ft(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                fVar.setLatestSummaryPrivateMessage(imMessageCenterPojo.getLast_content());
                String nameShow = imMessageCenterPojo.getNameShow();
                HashMap<String, String> privateGidName = fVar.getPrivateGidName();
                if (privateGidName != null) {
                    privateGidName.put(imMessageCenterPojo.getGid(), nameShow);
                }
            }
            fVar.setUnReadPrivateMessageCount(fVar.getUnReadPrivateMessageCount() + imMessageCenterPojo.getUnread_count());
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, f fVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && com.baidu.tieba.im.settingcache.f.cUO().isAcceptNotify()) {
            fVar.setUnReadStrangerMergeCount(imMessageCenterPojo.getUnread_count());
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, f fVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && c.cUL().isAcceptNotify()) {
            fVar.setUnReadOfficialMergeCount(imMessageCenterPojo.getUnread_count());
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo, f fVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            fVar.setUnReadGroupValidate(imMessageCenterPojo.getUnread_count());
            fVar.setLatestSummaryValidate(imMessageCenterPojo.getLast_content());
            fVar.setGroupValidateName(imMessageCenterPojo.getGroup_name());
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo, f fVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -3) {
            fVar.setGroupUpdatesName(imMessageCenterPojo.getGroup_name());
            fVar.setLatestSummaryGroupUpdates(imMessageCenterPojo.getLast_content());
            fVar.setUnReadGroupUpdates(imMessageCenterPojo.getUnread_count());
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
