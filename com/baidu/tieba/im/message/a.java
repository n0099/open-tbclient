package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.im.d;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.e;
/* loaded from: classes10.dex */
public class a extends com.baidu.adp.framework.a.a {
    public a() {
        super(CmdConfigCustom.MEMORY_CHANGED);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: j */
    public CustomResponsedMessage a(CustomResponsedMessage customResponsedMessage) {
        if (customResponsedMessage == null) {
            return null;
        }
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            ImMessageCenterPojo data = ((MemoryChangedMessage) customResponsedMessage).getData();
            if (data != null && data.getCustomGroupType() == -8) {
                return new MemoryChangedMessage(d.d(data), ((MemoryChangedMessage) customResponsedMessage).isFromServer(), ((MemoryChangedMessage) customResponsedMessage).getType());
            }
            if (data != null && data.getCustomGroupType() == -7) {
                return new MemoryChangedMessage(e.e(data), ((MemoryChangedMessage) customResponsedMessage).isFromServer(), ((MemoryChangedMessage) customResponsedMessage).getType());
            }
            return customResponsedMessage;
        }
        return customResponsedMessage;
    }
}
