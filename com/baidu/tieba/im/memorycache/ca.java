package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class ca extends com.baidu.adp.framework.a.a {
    public ca() {
        super(2016006);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: f */
    public CustomResponsedMessage a(CustomResponsedMessage customResponsedMessage) {
        List<ImMessageCenterPojo> data;
        ImMessageCenterPojo imMessageCenterPojo;
        if (customResponsedMessage == null) {
            return null;
        }
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            if (responsedMemoryListMessage.getType() == 1 && (data = responsedMemoryListMessage.getData()) != null) {
                Iterator<ImMessageCenterPojo> it = data.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        imMessageCenterPojo = null;
                        break;
                    }
                    imMessageCenterPojo = it.next();
                    if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8) {
                        data.remove(imMessageCenterPojo);
                        break;
                    }
                }
                if (imMessageCenterPojo != null) {
                    data.add(bz.l(imMessageCenterPojo));
                    return customResponsedMessage;
                }
                return customResponsedMessage;
            }
            return customResponsedMessage;
        }
        return customResponsedMessage;
    }
}
