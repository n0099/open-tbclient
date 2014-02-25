package com.baidu.tieba.im.net;

import com.baidu.tieba.util.cb;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class f {
    private List<String> a;
    private boolean b;

    public static f a() {
        f fVar;
        fVar = g.a;
        return fVar;
    }

    private f() {
        this.a = null;
        this.b = false;
        this.a = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(f fVar) {
        this();
    }

    public void a(String str) {
        cb.b(str, "", "");
        com.baidu.adp.lib.util.f.e(str);
        com.baidu.tieba.log.a.b(str);
        this.a.add(str);
    }

    public void b() {
        if (!this.b) {
            d();
        } else if (this.a != null && this.a.size() >= 1) {
            StringBuilder sb = new StringBuilder();
            for (String str : this.a) {
                sb.append(str);
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
        }
    }

    public void c() {
        this.b = true;
    }

    private void d() {
        this.b = false;
        if (this.a != null) {
            this.a.clear();
        }
    }
}
