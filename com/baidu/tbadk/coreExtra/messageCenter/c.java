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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static volatile c bYT;
    private final LinkedList<ImMessageCenterPojo> mList = new LinkedList<>();
    private int bYU = 0;
    private int bYV = 0;
    private int mReplyNum = 0;
    private int bYW = 0;
    private boolean bYX = false;
    private int bYY = 0;
    private boolean bYZ = false;
    private int bZa = 0;
    private boolean bZb = false;
    private final CustomMessageListener bZc = new CustomMessageListener(0) { // from class: com.baidu.tbadk.coreExtra.messageCenter.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001120) {
                    c.this.c((ResponsedMessage<?>) customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016002) {
                    c.this.c(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016004) {
                    c.this.e(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016007) {
                    c.this.d(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016001) {
                    c.this.f(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016010) {
                    c.this.aie();
                } else if (customResponsedMessage.getCmd() == 2016011) {
                    c.this.aif();
                }
            }
        }
    };

    private c() {
    }

    public static c aid() {
        if (bYT == null) {
            synchronized (c.class) {
                if (bYT == null) {
                    bYT = new c();
                }
            }
        }
        return bYT;
    }

    public void init() {
        reset();
        MessageManager.getInstance().registerStickyMode(2921002);
        MessageManager.getInstance().registerListener(2001120, this.bZc);
        MessageManager.getInstance().registerListener(2016002, this.bZc);
        MessageManager.getInstance().registerListener(2016004, this.bZc);
        MessageManager.getInstance().registerListener(2016001, this.bZc);
        MessageManager.getInstance().registerListener(2016007, this.bZc);
        MessageManager.getInstance().registerListener(2016011, this.bZc);
        MessageManager.getInstance().registerListener(2016010, this.bZc);
    }

    private void reset() {
        this.mList.clear();
        this.bYU = 0;
        this.bYV = 0;
        this.mReplyNum = 0;
        this.bYW = 0;
        this.bYX = false;
        this.bYY = 0;
        this.bYZ = false;
        this.bYY = 0;
        this.bYZ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            r(newsNotifyMessage.getMsgAgree(), newsNotifyMessage.getMsgAtme(), newsNotifyMessage.getMsgReplyme());
            aig();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aie() {
        r(this.bYU, this.bYV, this.mReplyNum);
        X(this.mList);
        Y(this.mList);
        aig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aif() {
        r(this.bYU, this.bYV, this.mReplyNum);
        X(this.mList);
        Y(this.mList);
        aig();
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
                X(this.mList);
                Y(this.mList);
                aig();
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
            X(this.mList);
            Y(this.mList);
            aig();
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
        X(this.mList);
        Y(this.mList);
        aig();
    }

    private void r(int i, int i2, int i3) {
        boolean z = i > 0 || i2 > 0 || i3 > 0;
        int i4 = (i <= 0 || !d.aih().aiy()) ? 0 : 0 + i;
        if (i2 > 0 && d.aih().aim()) {
            i4 += i2;
        }
        if (i3 > 0 && d.aih().aio()) {
            i4 += i3;
        }
        int i5 = d.aih().aik() == 0 ? 0 : i4;
        this.bYX = i5 <= 0 ? false : z;
        this.bYW = i5;
        this.bYU = i;
        this.bYV = i2;
        this.mReplyNum = i3;
    }

    private void X(List<ImMessageCenterPojo> list) {
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
                        if (d.aih().aix()) {
                            GroupSettingItemData cZ = com.baidu.tieba.im.settingcache.b.bwa().cZ(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                            if (cZ != null) {
                                if (cZ.isAcceptNotify()) {
                                    i += imMessageCenterPojo.getUnread_count();
                                }
                            } else {
                                i += imMessageCenterPojo.getUnread_count();
                            }
                            z = true;
                        }
                        z = true;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        if (d.aih().aip()) {
                            PersonalSettingItemData cZ2 = com.baidu.tieba.im.settingcache.e.bwd().cZ(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                            if (cZ2 != null) {
                                if (cZ2.isAcceptNotify()) {
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
                            if (d.aih().aip()) {
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
            if (d.aih().aik() == 0) {
                i = 0;
            }
            boolean z2 = i > 0 ? z : false;
            this.bYY = i;
            this.bYZ = z2;
        }
    }

    private void Y(List<ImMessageCenterPojo> list) {
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
            this.bZa = i2;
            this.bZb = z2;
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
        HashMap<Integer, HashSet> ahY = b.ahA().ahY();
        if (ahY != null && ahY.size() > 0) {
            HashSet hashSet = ahY.get(0);
            HashSet hashSet2 = ahY.get(1);
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
        HashMap<Integer, HashSet> ahY = b.ahA().ahY();
        return (ahY == null || ahY.size() <= 0 || (hashSet = ahY.get(0)) == null || ap.isEmpty(imMessageCenterPojo.getGid()) || !hashSet.contains(imMessageCenterPojo.getGid())) ? false : true;
    }

    private void aig() {
        NewsRemindMessage newsRemindMessage = new NewsRemindMessage();
        newsRemindMessage.setMsgAgreeCount(this.bYU);
        newsRemindMessage.setMsgAtCount(this.bYV);
        newsRemindMessage.setMsgReplyCount(this.mReplyNum);
        newsRemindMessage.setMsgCount(this.bYW);
        newsRemindMessage.setHasMsgRemind(this.bYX);
        newsRemindMessage.setChatCount(this.bYY);
        newsRemindMessage.setHasChatRemind(this.bYZ);
        newsRemindMessage.setNotificationCount(this.bZa);
        newsRemindMessage.setHasNotificationRemind(this.bZb);
        MessageManager.getInstance().dispatchResponsedMessage(newsRemindMessage);
    }
}
