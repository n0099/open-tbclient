package com.baidu.tbadk.coreExtra.messageCenter;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.im.settingcache.e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static volatile b aCV;
    private final LinkedList<ImMessageCenterPojo> mList = new LinkedList<>();
    private int ajF = 0;
    private int aCW = 0;
    private int mReplyNum = 0;
    private int aCX = 0;
    private boolean aCY = false;
    private int aCZ = 0;
    private boolean aDa = false;
    private int aDb = 0;
    private boolean aDc = false;
    private final CustomMessageListener aDd = new CustomMessageListener(0) { // from class: com.baidu.tbadk.coreExtra.messageCenter.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001120) {
                    b.this.c((ResponsedMessage<?>) customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016002) {
                    b.this.c(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016004) {
                    b.this.e(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016007) {
                    b.this.d(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016001) {
                    b.this.f(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016010) {
                    b.this.DB();
                } else if (customResponsedMessage.getCmd() == 2016011) {
                    b.this.DC();
                }
            }
        }
    };

    private b() {
    }

    public static b DA() {
        if (aCV == null) {
            synchronized (b.class) {
                if (aCV == null) {
                    aCV = new b();
                }
            }
        }
        return aCV;
    }

    public void init() {
        reset();
        MessageManager.getInstance().registerStickyMode(2921002);
        MessageManager.getInstance().registerListener(2001120, this.aDd);
        MessageManager.getInstance().registerListener(2016002, this.aDd);
        MessageManager.getInstance().registerListener(2016004, this.aDd);
        MessageManager.getInstance().registerListener(2016001, this.aDd);
        MessageManager.getInstance().registerListener(2016007, this.aDd);
        MessageManager.getInstance().registerListener(2016011, this.aDd);
        MessageManager.getInstance().registerListener(2016010, this.aDd);
    }

    private void reset() {
        this.mList.clear();
        this.ajF = 0;
        this.aCW = 0;
        this.mReplyNum = 0;
        this.aCX = 0;
        this.aCY = false;
        this.aCZ = 0;
        this.aDa = false;
        this.aCZ = 0;
        this.aDa = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            m(newsNotifyMessage.getMsgAgree(), newsNotifyMessage.getMsgAtme(), newsNotifyMessage.getMsgReplyme());
            DD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DB() {
        m(this.ajF, this.aCW, this.mReplyNum);
        B(this.mList);
        C(this.mList);
        DD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DC() {
        m(this.ajF, this.aCW, this.mReplyNum);
        B(this.mList);
        C(this.mList);
        DD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && data != null) {
                this.mList.clear();
                for (ImMessageCenterPojo imMessageCenterPojo : data) {
                    if (imMessageCenterPojo != null && a(imMessageCenterPojo)) {
                        this.mList.add(imMessageCenterPojo);
                    }
                }
                B(this.mList);
                C(this.mList);
                DD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        MemoryChangedMessage memoryChangedMessage;
        ImMessageCenterPojo data;
        if ((customResponsedMessage instanceof MemoryChangedMessage) && (data = (memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage).getData()) != null && !TextUtils.isEmpty(data.getGid())) {
            if (memoryChangedMessage.getType() == 1) {
                a(this.mList, data);
                if (a(data)) {
                    this.mList.add(data);
                }
            } else if (memoryChangedMessage.getType() == 2) {
                a(this.mList, data);
            }
            B(this.mList);
            C(this.mList);
            DD();
        }
    }

    private void a(LinkedList<ImMessageCenterPojo> linkedList, ImMessageCenterPojo imMessageCenterPojo) {
        if (linkedList != null && linkedList.size() > 0 && imMessageCenterPojo != null) {
            Iterator<ImMessageCenterPojo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                if (next != null && next.getGid() == imMessageCenterPojo.getGid()) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        this.mList.clear();
        B(this.mList);
        C(this.mList);
        DD();
    }

    private void m(int i, int i2, int i3) {
        boolean z = i > 0 || i2 > 0 || i3 > 0;
        int i4 = (i <= 0 || !c.DE().DU()) ? 0 : 0 + i;
        if (i2 > 0 && c.DE().DJ()) {
            i4 += i2;
        }
        if (i3 > 0 && c.DE().DL()) {
            i4 += i3;
        }
        int i5 = c.DE().DH() == 0 ? 0 : i4;
        this.aCY = i5 <= 0 ? false : z;
        this.aCX = i5;
        this.ajF = i;
        this.aCW = i2;
        this.mReplyNum = i3;
    }

    private void B(List<ImMessageCenterPojo> list) {
        if (list != null) {
            int i = 0;
            boolean z = false;
            for (int i2 = 0; i2 < list.size(); i2++) {
                ImMessageCenterPojo imMessageCenterPojo = list.get(i2);
                if (imMessageCenterPojo != null && b(imMessageCenterPojo) && !TextUtils.isEmpty(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0) {
                    if (imMessageCenterPojo.getCustomGroupType() == -4) {
                        z = true;
                    } else if (imMessageCenterPojo.getCustomGroupType() == -3) {
                        z = true;
                    } else if (imMessageCenterPojo.getCustomGroupType() == -7) {
                        z = true;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        if (c.DE().DT()) {
                            GroupSettingItemData bq = com.baidu.tieba.im.settingcache.b.aLN().bq(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                            if (bq != null) {
                                if (bq.isAcceptNotify()) {
                                    i += imMessageCenterPojo.getUnread_count();
                                }
                            } else {
                                i += imMessageCenterPojo.getUnread_count();
                            }
                            z = true;
                        }
                        z = true;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        if (c.DE().DM()) {
                            PersonalSettingItemData bq2 = e.aLQ().bq(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                            if (bq2 != null) {
                                if (bq2.isAcceptNotify()) {
                                    i += imMessageCenterPojo.getUnread_count();
                                }
                            } else {
                                i += imMessageCenterPojo.getUnread_count();
                            }
                            z = true;
                        }
                        z = true;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        if (imMessageCenterPojo.getUserType() == 4) {
                            if (c.DE().DM()) {
                                i += imMessageCenterPojo.getUnread_count();
                                z = true;
                            }
                            z = true;
                        }
                    } else if (imMessageCenterPojo.getCustomGroupType() == -8) {
                        z = true;
                    }
                }
            }
            if (c.DE().DH() == 0) {
                i = 0;
            }
            boolean z2 = i > 0 ? z : false;
            this.aCZ = i;
            this.aDa = z2;
        }
    }

    private void C(List<ImMessageCenterPojo> list) {
        if (list != null) {
            int i = 0;
            int i2 = 0;
            boolean z = false;
            while (i < list.size()) {
                ImMessageCenterPojo imMessageCenterPojo = list.get(i);
                if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && imMessageCenterPojo.getUserType() == 4 && c(list.get(i)) && imMessageCenterPojo.getUnread_count() > 0) {
                    z = true;
                    i2 += imMessageCenterPojo.getUnread_count();
                }
                i++;
                z = z;
                i2 = i2;
            }
            boolean z2 = i2 > 0 ? z : false;
            this.aDb = i2;
            this.aDc = z2;
        }
    }

    private boolean a(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null || imMessageCenterPojo.getIs_hidden() == 1) {
            return false;
        }
        if ((TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) || imMessageCenterPojo.getLast_content_time() == 0) {
            return false;
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name());
        }
        if (imMessageCenterPojo.getCustomGroupType() != -3 && imMessageCenterPojo.getCustomGroupType() != -4) {
            if ((imMessageCenterPojo.getCustomGroupType() != 4 || imMessageCenterPojo.getUserType() != 4) && imMessageCenterPojo.getCustomGroupType() != -8 && imMessageCenterPojo.getCustomGroupType() != -7) {
                if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
                    return (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) ? false : true;
                }
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean b(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        HashMap<Integer, HashSet> Dv = a.CX().Dv();
        if (Dv != null && Dv.size() > 0) {
            HashSet hashSet = Dv.get(0);
            HashSet hashSet2 = Dv.get(1);
            if (hashSet != null && !ao.isEmpty(imMessageCenterPojo.getGid()) && hashSet.contains(imMessageCenterPojo.getGid())) {
                return false;
            }
            if (hashSet2 != null && !ao.isEmpty(imMessageCenterPojo.getGid()) && hashSet2.contains(imMessageCenterPojo.getGid())) {
                return false;
            }
        }
        return true;
    }

    private boolean c(ImMessageCenterPojo imMessageCenterPojo) {
        HashSet hashSet;
        HashMap<Integer, HashSet> Dv = a.CX().Dv();
        return (Dv == null || Dv.size() <= 0 || (hashSet = Dv.get(0)) == null || ao.isEmpty(imMessageCenterPojo.getGid()) || !hashSet.contains(imMessageCenterPojo.getGid())) ? false : true;
    }

    private void DD() {
        NewsRemindMessage newsRemindMessage = new NewsRemindMessage();
        newsRemindMessage.setMsgAgreeCount(this.ajF);
        newsRemindMessage.setMsgAtCount(this.aCW);
        newsRemindMessage.setMsgReplyCount(this.mReplyNum);
        newsRemindMessage.setMsgCount(this.aCX);
        newsRemindMessage.setHasMsgRemind(this.aCY);
        newsRemindMessage.setChatCount(this.aCZ);
        newsRemindMessage.setHasChatRemind(this.aDa);
        newsRemindMessage.setNotificationCount(this.aDb);
        newsRemindMessage.setHasNotificationRemind(this.aDc);
        MessageManager.getInstance().dispatchResponsedMessage(newsRemindMessage);
    }
}
