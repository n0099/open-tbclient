package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import java.util.List;
/* loaded from: classes.dex */
public class ca extends com.baidu.adp.framework.a.a {
    public ca() {
        super(2016006);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: g */
    public CustomResponsedMessage a(CustomResponsedMessage customResponsedMessage) {
        List<ImMessageCenterPojo> data;
        if (customResponsedMessage == null) {
            return null;
        }
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            if (responsedMemoryListMessage.getType() == 1 && (data = responsedMemoryListMessage.getData()) != null) {
                ImMessageCenterPojo imMessageCenterPojo = null;
                ImMessageCenterPojo imMessageCenterPojo2 = null;
                for (ImMessageCenterPojo imMessageCenterPojo3 : data) {
                    if (imMessageCenterPojo3 != null && imMessageCenterPojo3.getCustomGroupType() == -8) {
                        imMessageCenterPojo2 = imMessageCenterPojo3;
                    }
                    if (imMessageCenterPojo3 != null && imMessageCenterPojo3.getCustomGroupType() == -7) {
                        imMessageCenterPojo = imMessageCenterPojo3;
                    }
                }
                if (imMessageCenterPojo2 != null) {
                    data.remove(imMessageCenterPojo2);
                    data.add(bz.s(imMessageCenterPojo2));
                }
                if (imMessageCenterPojo != null) {
                    data.remove(imMessageCenterPojo);
                    data.add(cb.t(imMessageCenterPojo));
                }
            }
        }
        return customResponsedMessage;
    }
}
