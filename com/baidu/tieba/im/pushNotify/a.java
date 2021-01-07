package com.baidu.tieba.im.pushNotify;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
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
    private static volatile a kHt;
    private List<ImMessageCenterPojo> mList = new LinkedList();
    private final CustomMessageListener kzM = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.pushNotify.a.1
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
                    com.baidu.tbadk.coreExtra.messageCenter.b.bBd().c(new f());
                    com.baidu.tbadk.coreExtra.messageCenter.b.bBd().setMsgChat(0);
                    com.baidu.tbadk.coreExtra.messageCenter.b.bBd().bBv();
                    com.baidu.tbadk.coreExtra.messageCenter.b.bBd().bBp();
                } else if (customResponsedMessage.getCmd() == 2016010 && a.this.mList != null) {
                    a.this.qd(false);
                }
            }
        }
    };

    public static a cZs() {
        if (kHt == null) {
            synchronized (a.class) {
                if (kHt == null) {
                    kHt = new a();
                }
            }
        }
        return kHt;
    }

    private a() {
        registerListener();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.kzM);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.kzM);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CLEAR, this.kzM);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.kzM);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.kzM);
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
            qd(o);
        }
    }

    private boolean o(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
            return e.cZO().fz(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() != 1) {
            if (imMessageCenterPojo.getCustomGroupType() == 4) {
                return d.cZN().fz(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
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
    public void qd(boolean z) {
        f fVar = new f();
        fVar.setShowInNotifyBar(z);
        d(fVar);
        fVar.setLastMsgGroupName();
        fVar.setLastPrivateMsgUserName();
        fVar.setUnReadPrivateMessagePreCount(com.baidu.tbadk.coreExtra.messageCenter.b.bBd().bBz().getUnReadPrivateMessageCount());
        fVar.setUnReadGroupMessagePreCount(com.baidu.tbadk.coreExtra.messageCenter.b.bBd().bBz().getUnReadGroupMessageCount());
        fVar.setUnReadOfficialMessagePreCount(com.baidu.tbadk.coreExtra.messageCenter.b.bBd().bBz().getUnReadOfficialMessageCount());
        fVar.setUnReadGroupValidatePre(com.baidu.tbadk.coreExtra.messageCenter.b.bBd().bBz().getUnReadGroupValidate());
        fVar.setUnReadGroupUpdatesPre(com.baidu.tbadk.coreExtra.messageCenter.b.bBd().bBz().getUnReadGroupUpdates());
        C(fVar.getOfficialNotificationListData(), com.baidu.tbadk.coreExtra.messageCenter.b.bBd().bBz().getOfficialNotificationListData());
        if (!com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBW()) {
            fVar.setUnReadGroupMessage(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBO()) {
            fVar.setUnReadPrivateMessageCount(0);
        }
        if (!com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bCa()) {
            fVar.setUnReadOfficialMessageCount(0);
            fVar.setUnReadOfficialMergeCount(0);
            fVar.setUnReadOfficialAccountCount(0);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bBG().bBJ() <= 0) {
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
        com.baidu.tbadk.coreExtra.messageCenter.b.bBd().b(fVar);
    }

    private void C(List<f.a> list, List<f.a> list2) {
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            for (f.a aVar : list) {
                if (aVar != null) {
                    for (f.a aVar2 : list2) {
                        if (aVar2 != null && at.equals(aVar.gid, aVar2.gid)) {
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
            if (!com.baidu.tieba.im.settingcache.b.cZL().fz(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
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

    /* JADX WARN: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011f  */
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
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && d.cZN().fz(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0 && (userType = imMessageCenterPojo.getUserType()) != 3) {
            f.a aVar = new f.a();
            aVar.gid = imMessageCenterPojo.getGid();
            aVar.gName = imMessageCenterPojo.getGroup_name();
            if (userType == 4) {
                try {
                    JSONArray jSONArray = new JSONArray(imMessageCenterPojo.getLastContentRawData());
                    if (jSONArray.length() == 1) {
                        JSONObject jSONObject = jSONArray.getJSONObject(0);
                        str2 = jSONObject.optString("title", null);
                        try {
                            str = jSONObject.optString("text", null);
                            try {
                                str6 = jSONObject.optString("isShow", null);
                            } catch (Exception e) {
                                e = e;
                                BdLog.e(e);
                                str3 = null;
                                if (str != null) {
                                }
                                if (str5 == null) {
                                }
                                aVar.title = str5;
                                aVar.content = str4;
                                aVar.isShow = str3;
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
                            str = null;
                        }
                    } else {
                        str6 = null;
                        str = null;
                        str2 = null;
                    }
                    str3 = str6;
                } catch (Exception e3) {
                    e = e3;
                    str = null;
                    str2 = null;
                }
                if (str != null) {
                    str5 = imMessageCenterPojo.getGroup_name();
                    str4 = imMessageCenterPojo.getLast_content();
                } else {
                    str4 = str;
                    str5 = str2;
                }
                if (str5 == null) {
                    str5 = imMessageCenterPojo.getGroup_name();
                }
                aVar.title = str5;
                aVar.content = str4;
                aVar.isShow = str3;
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
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && e.cZO().fz(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
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
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && com.baidu.tieba.im.settingcache.f.cZP().isAcceptNotify()) {
            fVar.setUnReadStrangerMergeCount(imMessageCenterPojo.getUnread_count());
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, f fVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && c.cZM().isAcceptNotify()) {
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
