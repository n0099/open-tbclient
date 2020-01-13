package com.baidu.tbadk.coreExtra.messageCenter;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
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
    private static volatile c dkb;
    private final LinkedList<ImMessageCenterPojo> mList = new LinkedList<>();
    private int dkc = 0;
    private int dkd = 0;
    private int mReplyNum = 0;
    private int dke = 0;
    private boolean dkf = false;
    private int dkg = 0;
    private boolean dkh = false;
    private int dki = 0;
    private boolean dkj = false;
    private final CustomMessageListener dkk = new CustomMessageListener(0) { // from class: com.baidu.tbadk.coreExtra.messageCenter.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001120) {
                    c.this.d((ResponsedMessage<?>) customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016002) {
                    c.this.c(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016004) {
                    c.this.e(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016007) {
                    c.this.d(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016001) {
                    c.this.f(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016010) {
                    c.this.aIN();
                } else if (customResponsedMessage.getCmd() == 2016011) {
                    c.this.aIO();
                }
            }
        }
    };

    private c() {
    }

    public static c aIM() {
        if (dkb == null) {
            synchronized (c.class) {
                if (dkb == null) {
                    dkb = new c();
                }
            }
        }
        return dkb;
    }

    public void init() {
        reset();
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_HOME_NOTIFY_MSG);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.dkk);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.dkk);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.dkk);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CLEAR, this.dkk);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.dkk);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.dkk);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.dkk);
    }

    private void reset() {
        this.mList.clear();
        this.dkc = 0;
        this.dkd = 0;
        this.mReplyNum = 0;
        this.dke = 0;
        this.dkf = false;
        this.dkg = 0;
        this.dkh = false;
        this.dkg = 0;
        this.dkh = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            x(newsNotifyMessage.getMsgAgree(), newsNotifyMessage.getMsgAtme(), newsNotifyMessage.getMsgReplyme());
            aIP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIN() {
        x(this.dkc, this.dkd, this.mReplyNum);
        aE(this.mList);
        aF(this.mList);
        aIP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIO() {
        x(this.dkc, this.dkd, this.mReplyNum);
        aE(this.mList);
        aF(this.mList);
        aIP();
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
                aE(this.mList);
                aF(this.mList);
                aIP();
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
            aE(this.mList);
            aF(this.mList);
            aIP();
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
        aE(this.mList);
        aF(this.mList);
        aIP();
    }

    private void x(int i, int i2, int i3) {
        boolean z = i > 0 || i2 > 0 || i3 > 0;
        int i4 = (i <= 0 || !d.aIQ().aJh()) ? 0 : 0 + i;
        if (i2 > 0 && d.aIQ().aIV()) {
            i4 += i2;
        }
        if (i3 > 0 && d.aIQ().aIX()) {
            i4 += i3;
        }
        int i5 = d.aIQ().aIT() == 0 ? 0 : i4;
        this.dkf = i5 <= 0 ? false : z;
        this.dke = i5;
        this.dkc = i;
        this.dkd = i2;
        this.mReplyNum = i3;
    }

    private void aE(List<ImMessageCenterPojo> list) {
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
                        if (d.aIQ().aJg()) {
                            GroupSettingItemData dw = com.baidu.tieba.im.settingcache.b.bWw().dw(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                            if (dw != null) {
                                if (dw.isAcceptNotify()) {
                                    i += imMessageCenterPojo.getUnread_count();
                                }
                            } else {
                                i += imMessageCenterPojo.getUnread_count();
                            }
                            z = true;
                        }
                        z = true;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        if (d.aIQ().aIY()) {
                            PersonalSettingItemData dw2 = com.baidu.tieba.im.settingcache.e.bWz().dw(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                            if (dw2 != null) {
                                if (dw2.isAcceptNotify()) {
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
                            if (d.aIQ().aIY()) {
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
            if (d.aIQ().aIT() == 0) {
                i = 0;
            }
            boolean z2 = i > 0 ? z : false;
            this.dkg = i;
            this.dkh = z2;
        }
    }

    private void aF(List<ImMessageCenterPojo> list) {
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
            this.dki = i2;
            this.dkj = z2;
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
        HashMap<Integer, HashSet> aIH = b.aIj().aIH();
        if (aIH != null && aIH.size() > 0) {
            HashSet hashSet = aIH.get(0);
            HashSet hashSet2 = aIH.get(1);
            if (hashSet != null && !aq.isEmpty(imMessageCenterPojo.getGid()) && hashSet.contains(imMessageCenterPojo.getGid())) {
                return false;
            }
            if (hashSet2 != null && !aq.isEmpty(imMessageCenterPojo.getGid()) && hashSet2.contains(imMessageCenterPojo.getGid())) {
                return false;
            }
        }
        return true;
    }

    private boolean c(ImMessageCenterPojo imMessageCenterPojo) {
        HashSet hashSet;
        HashMap<Integer, HashSet> aIH = b.aIj().aIH();
        return (aIH == null || aIH.size() <= 0 || (hashSet = aIH.get(0)) == null || aq.isEmpty(imMessageCenterPojo.getGid()) || !hashSet.contains(imMessageCenterPojo.getGid())) ? false : true;
    }

    private void aIP() {
        NewsRemindMessage newsRemindMessage = new NewsRemindMessage();
        newsRemindMessage.setMsgAgreeCount(this.dkc);
        newsRemindMessage.setMsgAtCount(this.dkd);
        newsRemindMessage.setMsgReplyCount(this.mReplyNum);
        newsRemindMessage.setMsgCount(this.dke);
        newsRemindMessage.setHasMsgRemind(this.dkf);
        newsRemindMessage.setChatCount(this.dkg);
        newsRemindMessage.setHasChatRemind(this.dkh);
        newsRemindMessage.setNotificationCount(this.dki);
        newsRemindMessage.setHasNotificationRemind(this.dkj);
        MessageManager.getInstance().dispatchResponsedMessage(newsRemindMessage);
    }
}
