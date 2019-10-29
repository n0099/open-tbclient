package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.im.d;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.e;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.framework.a.a {
    public b() {
        super(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: j */
    public CustomResponsedMessage a(CustomResponsedMessage customResponsedMessage) {
        List<ImMessageCenterPojo> data;
        ImMessageCenterPojo imMessageCenterPojo = null;
        if (customResponsedMessage == null) {
            return null;
        }
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            if (responsedMemoryListMessage.getType() == 1 && (data = responsedMemoryListMessage.getData()) != null) {
                ImMessageCenterPojo imMessageCenterPojo2 = null;
                for (ImMessageCenterPojo imMessageCenterPojo3 : data) {
                    if (imMessageCenterPojo3 != null && imMessageCenterPojo3.getCustomGroupType() == -8) {
                        imMessageCenterPojo2 = imMessageCenterPojo3;
                    }
                    if (imMessageCenterPojo3 == null || imMessageCenterPojo3.getCustomGroupType() != -7) {
                        imMessageCenterPojo3 = imMessageCenterPojo;
                    }
                    imMessageCenterPojo = imMessageCenterPojo3;
                }
                if (imMessageCenterPojo2 != null) {
                    data.remove(imMessageCenterPojo2);
                    data.add(d.d(imMessageCenterPojo2));
                }
                if (imMessageCenterPojo != null) {
                    data.remove(imMessageCenterPojo);
                    data.add(e.e(imMessageCenterPojo));
                }
            }
        }
        return customResponsedMessage;
    }
}
