package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
/* loaded from: classes.dex */
public class by extends com.baidu.adp.framework.a.a {
    public by() {
        super(2016003);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: f */
    public CustomResponsedMessage a(CustomResponsedMessage customResponsedMessage) {
        ImMessageCenterPojo data;
        if (customResponsedMessage == null) {
            return null;
        }
        if ((customResponsedMessage instanceof MemoryChangedMessage) && (data = ((MemoryChangedMessage) customResponsedMessage).getData()) != null && data.getCustomGroupType() == -8) {
            return new MemoryChangedMessage(bz.l(data), ((MemoryChangedMessage) customResponsedMessage).isFromServer(), ((MemoryChangedMessage) customResponsedMessage).getType());
        }
        return customResponsedMessage;
    }
}
