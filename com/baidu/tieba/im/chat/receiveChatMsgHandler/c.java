package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
public interface c {
    void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z);

    void b(String str, List<CommonMsgPojo> list);
}
