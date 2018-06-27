package com.baidu.tbadk.coreExtra.messageCenter;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
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
    private static volatile b aDP;
    private final LinkedList<ImMessageCenterPojo> mList = new LinkedList<>();
    private int aka = 0;
    private int aDQ = 0;
    private int mReplyNum = 0;
    private int aDR = 0;
    private boolean aDS = false;
    private int aDT = 0;
    private boolean aDU = false;
    private int aDV = 0;
    private boolean aDW = false;
    private final CustomMessageListener aDX = new CustomMessageListener(0) { // from class: com.baidu.tbadk.coreExtra.messageCenter.b.1
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
                    b.this.DT();
                } else if (customResponsedMessage.getCmd() == 2016011) {
                    b.this.DU();
                }
            }
        }
    };

    private b() {
    }

    public static b DS() {
        if (aDP == null) {
            synchronized (b.class) {
                if (aDP == null) {
                    aDP = new b();
                }
            }
        }
        return aDP;
    }

    public void init() {
        reset();
        MessageManager.getInstance().registerStickyMode(2921002);
        MessageManager.getInstance().registerListener(2001120, this.aDX);
        MessageManager.getInstance().registerListener(2016002, this.aDX);
        MessageManager.getInstance().registerListener(2016004, this.aDX);
        MessageManager.getInstance().registerListener(2016001, this.aDX);
        MessageManager.getInstance().registerListener(2016007, this.aDX);
        MessageManager.getInstance().registerListener(2016011, this.aDX);
        MessageManager.getInstance().registerListener(2016010, this.aDX);
    }

    private void reset() {
        this.mList.clear();
        this.aka = 0;
        this.aDQ = 0;
        this.mReplyNum = 0;
        this.aDR = 0;
        this.aDS = false;
        this.aDT = 0;
        this.aDU = false;
        this.aDT = 0;
        this.aDU = false;
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
            DV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DT() {
        m(this.aka, this.aDQ, this.mReplyNum);
        C(this.mList);
        D(this.mList);
        DV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DU() {
        m(this.aka, this.aDQ, this.mReplyNum);
        C(this.mList);
        D(this.mList);
        DV();
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
                C(this.mList);
                D(this.mList);
                DV();
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
            C(this.mList);
            D(this.mList);
            DV();
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
        C(this.mList);
        D(this.mList);
        DV();
    }

    private void m(int i, int i2, int i3) {
        boolean z = i > 0 || i2 > 0 || i3 > 0;
        int i4 = (i <= 0 || !c.DW().Em()) ? 0 : 0 + i;
        if (i2 > 0 && c.DW().Eb()) {
            i4 += i2;
        }
        if (i3 > 0 && c.DW().Ed()) {
            i4 += i3;
        }
        int i5 = c.DW().DZ() == 0 ? 0 : i4;
        this.aDS = i5 <= 0 ? false : z;
        this.aDR = i5;
        this.aka = i;
        this.aDQ = i2;
        this.mReplyNum = i3;
    }

    private void C(List<ImMessageCenterPojo> list) {
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
                        if (c.DW().El()) {
                            GroupSettingItemData bu = com.baidu.tieba.im.settingcache.b.aMt().bu(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                            if (bu != null) {
                                if (bu.isAcceptNotify()) {
                                    i += imMessageCenterPojo.getUnread_count();
                                }
                            } else {
                                i += imMessageCenterPojo.getUnread_count();
                            }
                            z = true;
                        }
                        z = true;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        if (c.DW().Ee()) {
                            PersonalSettingItemData bu2 = e.aMw().bu(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                            if (bu2 != null) {
                                if (bu2.isAcceptNotify()) {
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
                            if (c.DW().Ee()) {
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
            if (c.DW().DZ() == 0) {
                i = 0;
            }
            boolean z2 = i > 0 ? z : false;
            this.aDT = i;
            this.aDU = z2;
        }
    }

    private void D(List<ImMessageCenterPojo> list) {
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
            this.aDV = i2;
            this.aDW = z2;
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
        HashMap<Integer, HashSet> DN = a.Dp().DN();
        if (DN != null && DN.size() > 0) {
            HashSet hashSet = DN.get(0);
            HashSet hashSet2 = DN.get(1);
            if (hashSet != null && !ap.isEmpty(imMessageCenterPojo.getGid()) && hashSet.contains(imMessageCenterPojo.getGid())) {
                return false;
            }
            if (hashSet2 != null && !ap.isEmpty(imMessageCenterPojo.getGid()) && hashSet2.contains(imMessageCenterPojo.getGid())) {
                return false;
            }
        }
        return true;
    }

    private boolean c(ImMessageCenterPojo imMessageCenterPojo) {
        HashSet hashSet;
        HashMap<Integer, HashSet> DN = a.Dp().DN();
        return (DN == null || DN.size() <= 0 || (hashSet = DN.get(0)) == null || ap.isEmpty(imMessageCenterPojo.getGid()) || !hashSet.contains(imMessageCenterPojo.getGid())) ? false : true;
    }

    private void DV() {
        NewsRemindMessage newsRemindMessage = new NewsRemindMessage();
        newsRemindMessage.setMsgAgreeCount(this.aka);
        newsRemindMessage.setMsgAtCount(this.aDQ);
        newsRemindMessage.setMsgReplyCount(this.mReplyNum);
        newsRemindMessage.setMsgCount(this.aDR);
        newsRemindMessage.setHasMsgRemind(this.aDS);
        newsRemindMessage.setChatCount(this.aDT);
        newsRemindMessage.setHasChatRemind(this.aDU);
        newsRemindMessage.setNotificationCount(this.aDV);
        newsRemindMessage.setHasNotificationRemind(this.aDW);
        MessageManager.getInstance().dispatchResponsedMessage(newsRemindMessage);
    }
}
