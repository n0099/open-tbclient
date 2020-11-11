package com.baidu.tbadk.coreExtra.messageCenter;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static volatile c feN;
    private final LinkedList<ImMessageCenterPojo> mList = new LinkedList<>();
    private int feO = 0;
    private int feP = 0;
    private int mReplyNum = 0;
    private int feQ = 0;
    private int feR = 0;
    private boolean feS = false;
    private int feT = 0;
    private boolean feU = false;
    private final CustomMessageListener feV = new CustomMessageListener(0) { // from class: com.baidu.tbadk.coreExtra.messageCenter.c.1
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
                    c.this.bws();
                } else if (customResponsedMessage.getCmd() == 2016011) {
                    c.this.bwt();
                }
            }
        }
    };

    private c() {
    }

    public static c bwr() {
        if (feN == null) {
            synchronized (c.class) {
                if (feN == null) {
                    feN = new c();
                }
            }
        }
        return feN;
    }

    public void init() {
        reset();
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_HOME_NOTIFY_MSG);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.feV);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.feV);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.feV);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CLEAR, this.feV);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.feV);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.feV);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.feV);
    }

    private void reset() {
        this.mList.clear();
        this.feO = 0;
        this.feP = 0;
        this.mReplyNum = 0;
        this.feQ = 0;
        this.feR = 0;
        this.feS = false;
        this.feT = 0;
        this.feU = false;
        this.feT = 0;
        this.feU = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            t(newsNotifyMessage.getMsgAgree(), newsNotifyMessage.getMsgAtme(), newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgFans());
            bwu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bws() {
        t(this.feO, this.feP, this.mReplyNum, this.feQ);
        bw(this.mList);
        bwu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwt() {
        t(this.feO, this.feP, this.mReplyNum, this.feQ);
        bw(this.mList);
        bwu();
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
                bw(this.mList);
                bwu();
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
            bw(this.mList);
            bwu();
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
        bw(this.mList);
        bwu();
    }

    private void t(int i, int i2, int i3, int i4) {
        boolean z = i > 0 || i2 > 0 || i3 > 0 || i4 > 0;
        int i5 = (i <= 0 || !d.bwv().bwM()) ? 0 : 0 + i;
        if (i2 > 0 && d.bwv().bwA()) {
            i5 += i2;
        }
        if (i3 > 0 && d.bwv().bwC()) {
            i5 += i3;
        }
        if (i4 > 0 && d.bwv().bwB()) {
            i5 += i4;
        }
        int i6 = d.bwv().bwy() == 0 ? 0 : i5;
        this.feS = i6 <= 0 ? false : z;
        this.feR = i6;
        this.feO = i;
        this.feP = i2;
        this.mReplyNum = i3;
        this.feQ = i4;
    }

    private void bw(List<ImMessageCenterPojo> list) {
        if (list != null) {
            int i = 0;
            boolean z = false;
            for (int i2 = 0; i2 < list.size(); i2++) {
                ImMessageCenterPojo imMessageCenterPojo = list.get(i2);
                if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0) {
                    if (imMessageCenterPojo.getCustomGroupType() == -4) {
                        z = true;
                    } else if (imMessageCenterPojo.getCustomGroupType() == -3) {
                        z = true;
                    } else if (imMessageCenterPojo.getCustomGroupType() == -7) {
                        z = true;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        if (d.bwv().bwL()) {
                            GroupSettingItemData fs = com.baidu.tieba.im.settingcache.b.cVe().fs(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                            if (fs != null) {
                                if (fs.isAcceptNotify()) {
                                    i += imMessageCenterPojo.getUnread_count();
                                }
                            } else {
                                i += imMessageCenterPojo.getUnread_count();
                            }
                            z = true;
                        }
                        z = true;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        if (d.bwv().bwD()) {
                            PersonalSettingItemData fs2 = com.baidu.tieba.im.settingcache.e.cVh().fs(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                            if (fs2 != null) {
                                if (fs2.isAcceptNotify()) {
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
                            if (d.bwv().bwD()) {
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
            if (d.bwv().bwy() == 0) {
                i = 0;
            }
            boolean z2 = i > 0 ? z : false;
            this.feT = i;
            this.feU = z2;
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

    private void bwu() {
        NewsRemindMessage newsRemindMessage = new NewsRemindMessage();
        newsRemindMessage.setMsgAgreeCount(this.feO);
        newsRemindMessage.setMsgAtCount(this.feP);
        newsRemindMessage.setMsgReplyCount(this.mReplyNum);
        newsRemindMessage.setMsgFansCount(this.feQ);
        newsRemindMessage.setMsgCount(this.feR);
        newsRemindMessage.setHasMsgRemind(this.feS);
        newsRemindMessage.setChatCount(this.feT);
        newsRemindMessage.setHasChatRemind(this.feU);
        MessageManager.getInstance().dispatchResponsedMessage(newsRemindMessage);
    }
}
