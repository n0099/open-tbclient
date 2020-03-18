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
    private static volatile c doJ;
    private final LinkedList<ImMessageCenterPojo> mList = new LinkedList<>();
    private int doK = 0;
    private int doL = 0;
    private int mReplyNum = 0;
    private int doM = 0;
    private boolean doN = false;
    private int doO = 0;
    private boolean doP = false;
    private int doQ = 0;
    private boolean doR = false;
    private final CustomMessageListener doS = new CustomMessageListener(0) { // from class: com.baidu.tbadk.coreExtra.messageCenter.c.1
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
                    c.this.aLn();
                } else if (customResponsedMessage.getCmd() == 2016011) {
                    c.this.aLo();
                }
            }
        }
    };

    private c() {
    }

    public static c aLm() {
        if (doJ == null) {
            synchronized (c.class) {
                if (doJ == null) {
                    doJ = new c();
                }
            }
        }
        return doJ;
    }

    public void init() {
        reset();
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_HOME_NOTIFY_MSG);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.doS);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.doS);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.doS);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CLEAR, this.doS);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.doS);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.doS);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.doS);
    }

    private void reset() {
        this.mList.clear();
        this.doK = 0;
        this.doL = 0;
        this.mReplyNum = 0;
        this.doM = 0;
        this.doN = false;
        this.doO = 0;
        this.doP = false;
        this.doO = 0;
        this.doP = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            y(newsNotifyMessage.getMsgAgree(), newsNotifyMessage.getMsgAtme(), newsNotifyMessage.getMsgReplyme());
            aLp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLn() {
        y(this.doK, this.doL, this.mReplyNum);
        aE(this.mList);
        aF(this.mList);
        aLp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLo() {
        y(this.doK, this.doL, this.mReplyNum);
        aE(this.mList);
        aF(this.mList);
        aLp();
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
                aLp();
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
            aLp();
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
        aLp();
    }

    private void y(int i, int i2, int i3) {
        boolean z = i > 0 || i2 > 0 || i3 > 0;
        int i4 = (i <= 0 || !d.aLq().aLH()) ? 0 : 0 + i;
        if (i2 > 0 && d.aLq().aLv()) {
            i4 += i2;
        }
        if (i3 > 0 && d.aLq().aLx()) {
            i4 += i3;
        }
        int i5 = d.aLq().aLt() == 0 ? 0 : i4;
        this.doN = i5 <= 0 ? false : z;
        this.doM = i5;
        this.doK = i;
        this.doL = i2;
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
                        if (d.aLq().aLG()) {
                            GroupSettingItemData dD = com.baidu.tieba.im.settingcache.b.bYs().dD(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                            if (dD != null) {
                                if (dD.isAcceptNotify()) {
                                    i += imMessageCenterPojo.getUnread_count();
                                }
                            } else {
                                i += imMessageCenterPojo.getUnread_count();
                            }
                            z = true;
                        }
                        z = true;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        if (d.aLq().aLy()) {
                            PersonalSettingItemData dD2 = com.baidu.tieba.im.settingcache.e.bYv().dD(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                            if (dD2 != null) {
                                if (dD2.isAcceptNotify()) {
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
                            if (d.aLq().aLy()) {
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
            if (d.aLq().aLt() == 0) {
                i = 0;
            }
            boolean z2 = i > 0 ? z : false;
            this.doO = i;
            this.doP = z2;
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
            this.doQ = i2;
            this.doR = z2;
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
        HashMap<Integer, HashSet> aLh = b.aKJ().aLh();
        if (aLh != null && aLh.size() > 0) {
            HashSet hashSet = aLh.get(0);
            HashSet hashSet2 = aLh.get(1);
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
        HashMap<Integer, HashSet> aLh = b.aKJ().aLh();
        return (aLh == null || aLh.size() <= 0 || (hashSet = aLh.get(0)) == null || aq.isEmpty(imMessageCenterPojo.getGid()) || !hashSet.contains(imMessageCenterPojo.getGid())) ? false : true;
    }

    private void aLp() {
        NewsRemindMessage newsRemindMessage = new NewsRemindMessage();
        newsRemindMessage.setMsgAgreeCount(this.doK);
        newsRemindMessage.setMsgAtCount(this.doL);
        newsRemindMessage.setMsgReplyCount(this.mReplyNum);
        newsRemindMessage.setMsgCount(this.doM);
        newsRemindMessage.setHasMsgRemind(this.doN);
        newsRemindMessage.setChatCount(this.doO);
        newsRemindMessage.setHasChatRemind(this.doP);
        newsRemindMessage.setNotificationCount(this.doQ);
        newsRemindMessage.setHasNotificationRemind(this.doR);
        MessageManager.getInstance().dispatchResponsedMessage(newsRemindMessage);
    }
}
