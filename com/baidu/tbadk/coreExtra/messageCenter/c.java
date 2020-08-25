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
/* loaded from: classes2.dex */
public class c {
    private static volatile c eCk;
    private final LinkedList<ImMessageCenterPojo> mList = new LinkedList<>();
    private int eCl = 0;
    private int eCm = 0;
    private int mReplyNum = 0;
    private int eCn = 0;
    private int eCo = 0;
    private boolean eCp = false;
    private int eCq = 0;
    private boolean eCr = false;
    private final CustomMessageListener eCs = new CustomMessageListener(0) { // from class: com.baidu.tbadk.coreExtra.messageCenter.c.1
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
                    c.this.bov();
                } else if (customResponsedMessage.getCmd() == 2016011) {
                    c.this.bow();
                }
            }
        }
    };

    private c() {
    }

    public static c bou() {
        if (eCk == null) {
            synchronized (c.class) {
                if (eCk == null) {
                    eCk = new c();
                }
            }
        }
        return eCk;
    }

    public void init() {
        reset();
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_HOME_NOTIFY_MSG);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.eCs);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.eCs);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.eCs);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CLEAR, this.eCs);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.eCs);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.eCs);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.eCs);
    }

    private void reset() {
        this.mList.clear();
        this.eCl = 0;
        this.eCm = 0;
        this.mReplyNum = 0;
        this.eCn = 0;
        this.eCo = 0;
        this.eCp = false;
        this.eCq = 0;
        this.eCr = false;
        this.eCq = 0;
        this.eCr = false;
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
            box();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bov() {
        t(this.eCl, this.eCm, this.mReplyNum, this.eCn);
        aY(this.mList);
        box();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bow() {
        t(this.eCl, this.eCm, this.mReplyNum, this.eCn);
        aY(this.mList);
        box();
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
                aY(this.mList);
                box();
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
            aY(this.mList);
            box();
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
        aY(this.mList);
        box();
    }

    private void t(int i, int i2, int i3, int i4) {
        boolean z = i > 0 || i2 > 0 || i3 > 0 || i4 > 0;
        int i5 = (i <= 0 || !d.boy().boP()) ? 0 : 0 + i;
        if (i2 > 0 && d.boy().boD()) {
            i5 += i2;
        }
        if (i3 > 0 && d.boy().boF()) {
            i5 += i3;
        }
        if (i4 > 0 && d.boy().boE()) {
            i5 += i4;
        }
        int i6 = d.boy().boB() == 0 ? 0 : i5;
        this.eCp = i6 <= 0 ? false : z;
        this.eCo = i6;
        this.eCl = i;
        this.eCm = i2;
        this.mReplyNum = i3;
        this.eCn = i4;
    }

    private void aY(List<ImMessageCenterPojo> list) {
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
                        if (d.boy().boO()) {
                            GroupSettingItemData eS = com.baidu.tieba.im.settingcache.b.cIh().eS(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                            if (eS != null) {
                                if (eS.isAcceptNotify()) {
                                    i += imMessageCenterPojo.getUnread_count();
                                }
                            } else {
                                i += imMessageCenterPojo.getUnread_count();
                            }
                            z = true;
                        }
                        z = true;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        if (d.boy().boG()) {
                            PersonalSettingItemData eS2 = com.baidu.tieba.im.settingcache.e.cIk().eS(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                            if (eS2 != null) {
                                if (eS2.isAcceptNotify()) {
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
                            if (d.boy().boG()) {
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
            if (d.boy().boB() == 0) {
                i = 0;
            }
            boolean z2 = i > 0 ? z : false;
            this.eCq = i;
            this.eCr = z2;
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

    private void box() {
        NewsRemindMessage newsRemindMessage = new NewsRemindMessage();
        newsRemindMessage.setMsgAgreeCount(this.eCl);
        newsRemindMessage.setMsgAtCount(this.eCm);
        newsRemindMessage.setMsgReplyCount(this.mReplyNum);
        newsRemindMessage.setMsgFansCount(this.eCn);
        newsRemindMessage.setMsgCount(this.eCo);
        newsRemindMessage.setHasMsgRemind(this.eCp);
        newsRemindMessage.setChatCount(this.eCq);
        newsRemindMessage.setHasChatRemind(this.eCr);
        MessageManager.getInstance().dispatchResponsedMessage(newsRemindMessage);
    }
}
