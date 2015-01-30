package com.baidu.tieba.im.floatwindow;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ b aYM;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(b bVar) {
        super(2016003);
        this.aYM = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        ArrayList arrayList;
        int i;
        a aVar;
        a aVar2;
        if ((customResponsedMessage instanceof MemoryChangedMessage) && !TbadkCoreApplication.m255getInst().isMIUIRom() && TbadkCoreApplication.m255getInst().getChatFloatWindowLocked()) {
            z = this.aYM.isBackground;
            if (!z && TbadkCoreApplication.m255getInst().getMsgFrequency() != 0 && TbadkCoreApplication.m255getInst().isMsgChatOn()) {
                ImMessageCenterPojo data = ((MemoryChangedMessage) customResponsedMessage).getData();
                if (2 == data.getCustomGroupType() || -7 == data.getCustomGroupType()) {
                    arrayList = this.aYM.aYD;
                    if (!arrayList.contains(data.getGid())) {
                        if ((TbadkCoreApplication.m255getInst().isStrangerChatOn() || data.getIsFriend() != 0) && com.baidu.tieba.im.settingcache.j.Tu().aH(TbadkCoreApplication.getCurrentAccount(), data.getGid())) {
                            if (2 == data.getCustomGroupType()) {
                                aVar2 = this.aYM.aYC;
                                i = aVar2.g(data);
                            } else if (-7 == data.getCustomGroupType()) {
                                aVar = this.aYM.aYC;
                                i = aVar.h(data);
                            } else {
                                i = 0;
                            }
                            if (i != 0 && i != 3) {
                                this.aYM.cJ(true);
                            }
                        }
                    }
                }
            }
        }
    }
}
