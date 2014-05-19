package com.baidu.tieba.im.b;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import java.io.File;
/* loaded from: classes.dex */
public class k extends c {
    private static k c;
    private String d = x.a + File.separator + TbConfig.getTempDirName() + File.separator + "PersonalChatMemoryCache.";

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
        e.a(this);
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
