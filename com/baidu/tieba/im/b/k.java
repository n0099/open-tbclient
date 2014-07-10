package com.baidu.tieba.im.b;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.model.p;
import java.io.File;
/* loaded from: classes.dex */
public class k extends c {
    private static k c;
    private String d = z.a + File.separator + TbConfig.getTempDirName() + File.separator + "PersonalChatMemoryCache.";

    public static synchronized k a() {
        k kVar;
        synchronized (k.class) {
            if (c == null) {
                c = new k();
            }
            kVar = c;
        }
        return kVar;
    }

    private k() {
    }

    public void a(String str, int i, CommonMsgPojo commonMsgPojo, boolean z) {
        e.a(this, str, i, commonMsgPojo);
    }

    @Override // com.baidu.tieba.im.b.c
    protected void b() {
        ImMessageCenterPojo b = com.baidu.tieba.im.db.h.a().b("-1001");
        if (b != null) {
            p.b(b.getUnread_count() > 0);
        }
        e.a(this);
    }

    public void c() {
        if (z.a()) {
            this.b.a(new File(String.valueOf(this.d) + TbadkApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.im.b.c
    public void d() {
        if (z.a()) {
            this.b.b(new File(String.valueOf(this.d) + TbadkApplication.getCurrentAccount()));
        }
    }
}
