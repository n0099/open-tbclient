package com.baidu.tbadk.coreExtra.messageCenter;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
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
    private static volatile c elF;
    private final LinkedList<ImMessageCenterPojo> mList = new LinkedList<>();
    private int elG = 0;
    private int elH = 0;
    private int mReplyNum = 0;
    private int elI = 0;
    private boolean elJ = false;
    private int elK = 0;
    private boolean elL = false;
    private int elM = 0;
    private boolean elN = false;
    private final CustomMessageListener elO = new CustomMessageListener(0) { // from class: com.baidu.tbadk.coreExtra.messageCenter.c.1
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
                    c.this.bbS();
                } else if (customResponsedMessage.getCmd() == 2016011) {
                    c.this.bbT();
                }
            }
        }
    };

    private c() {
    }

    public static c bbR() {
        if (elF == null) {
            synchronized (c.class) {
                if (elF == null) {
                    elF = new c();
                }
            }
        }
        return elF;
    }

    public void init() {
        reset();
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_HOME_NOTIFY_MSG);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.elO);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.elO);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CHANGED, this.elO);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_CLEAR, this.elO);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.elO);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.elO);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.elO);
    }

    private void reset() {
        this.mList.clear();
        this.elG = 0;
        this.elH = 0;
        this.mReplyNum = 0;
        this.elI = 0;
        this.elJ = false;
        this.elK = 0;
        this.elL = false;
        this.elK = 0;
        this.elL = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            z(newsNotifyMessage.getMsgAgree(), newsNotifyMessage.getMsgAtme(), newsNotifyMessage.getMsgReplyme());
            bbU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbS() {
        z(this.elG, this.elH, this.mReplyNum);
        aS(this.mList);
        aT(this.mList);
        bbU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbT() {
        z(this.elG, this.elH, this.mReplyNum);
        aS(this.mList);
        aT(this.mList);
        bbU();
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
                aS(this.mList);
                aT(this.mList);
                bbU();
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
            aS(this.mList);
            aT(this.mList);
            bbU();
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
        aS(this.mList);
        aT(this.mList);
        bbU();
    }

    private void z(int i, int i2, int i3) {
        boolean z = i > 0 || i2 > 0 || i3 > 0;
        int i4 = (i <= 0 || !d.bbV().bcm()) ? 0 : 0 + i;
        if (i2 > 0 && d.bbV().bca()) {
            i4 += i2;
        }
        if (i3 > 0 && d.bbV().bcc()) {
            i4 += i3;
        }
        int i5 = d.bbV().bbY() == 0 ? 0 : i4;
        this.elJ = i5 <= 0 ? false : z;
        this.elI = i5;
        this.elG = i;
        this.elH = i2;
        this.mReplyNum = i3;
    }

    private void aS(List<ImMessageCenterPojo> list) {
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
                        if (d.bbV().bcl()) {
                            GroupSettingItemData ez = com.baidu.tieba.im.settingcache.b.cto().ez(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                            if (ez != null) {
                                if (ez.isAcceptNotify()) {
                                    i += imMessageCenterPojo.getUnread_count();
                                }
                            } else {
                                i += imMessageCenterPojo.getUnread_count();
                            }
                            z = true;
                        }
                        z = true;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        if (d.bbV().bcd()) {
                            PersonalSettingItemData ez2 = com.baidu.tieba.im.settingcache.e.ctr().ez(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                            if (ez2 != null) {
                                if (ez2.isAcceptNotify()) {
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
                            if (d.bbV().bcd()) {
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
            if (d.bbV().bbY() == 0) {
                i = 0;
            }
            boolean z2 = i > 0 ? z : false;
            this.elK = i;
            this.elL = z2;
        }
    }

    private void aT(List<ImMessageCenterPojo> list) {
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
            this.elM = i2;
            this.elN = z2;
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
        HashMap<Integer, HashSet> bbM = b.bbo().bbM();
        if (bbM != null && bbM.size() > 0) {
            HashSet hashSet = bbM.get(0);
            HashSet hashSet2 = bbM.get(1);
            if (hashSet != null && !ar.isEmpty(imMessageCenterPojo.getGid()) && hashSet.contains(imMessageCenterPojo.getGid())) {
                return false;
            }
            if (hashSet2 != null && !ar.isEmpty(imMessageCenterPojo.getGid()) && hashSet2.contains(imMessageCenterPojo.getGid())) {
                return false;
            }
        }
        return true;
    }

    private boolean c(ImMessageCenterPojo imMessageCenterPojo) {
        HashSet hashSet;
        HashMap<Integer, HashSet> bbM = b.bbo().bbM();
        return (bbM == null || bbM.size() <= 0 || (hashSet = bbM.get(0)) == null || ar.isEmpty(imMessageCenterPojo.getGid()) || !hashSet.contains(imMessageCenterPojo.getGid())) ? false : true;
    }

    private void bbU() {
        NewsRemindMessage newsRemindMessage = new NewsRemindMessage();
        newsRemindMessage.setMsgAgreeCount(this.elG);
        newsRemindMessage.setMsgAtCount(this.elH);
        newsRemindMessage.setMsgReplyCount(this.mReplyNum);
        newsRemindMessage.setMsgCount(this.elI);
        newsRemindMessage.setHasMsgRemind(this.elJ);
        newsRemindMessage.setChatCount(this.elK);
        newsRemindMessage.setHasChatRemind(this.elL);
        newsRemindMessage.setNotificationCount(this.elM);
        newsRemindMessage.setHasNotificationRemind(this.elN);
        MessageManager.getInstance().dispatchResponsedMessage(newsRemindMessage);
    }
}
