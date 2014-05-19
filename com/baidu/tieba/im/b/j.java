package com.baidu.tieba.im.b;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.model.r;
import java.io.File;
/* loaded from: classes.dex */
public class j extends c {
    private static j c;
    private String d = x.a + File.separator + TbConfig.getTempDirName() + File.separator + "OfficialBarMsgMemoryCache.";

    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            if (c == null) {
                c = new j();
            }
            jVar = c;
        }
        return jVar;
    }

    private j() {
    }

    public void a(String str, int i, CommonMsgPojo commonMsgPojo, boolean z) {
        e.a(this, str, i, commonMsgPojo);
    }

    @Override // com.baidu.tieba.im.b.c
    protected void b() {
        ImMessageCenterPojo b = com.baidu.tieba.im.db.h.a().b("-1000");
        if (b != null) {
            r.a(b.getUnread_count() > 0);
        }
        e.b(this);
    }

    public void c() {
        if (x.a()) {
            this.b.a(new File(String.valueOf(this.d) + TbadkApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tieba.im.b.c
    public void d() {
        if (x.a()) {
            this.b.b(new File(String.valueOf(this.d) + TbadkApplication.getCurrentAccount()));
        }
    }
}
