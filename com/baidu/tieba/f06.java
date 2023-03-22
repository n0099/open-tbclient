package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
/* loaded from: classes4.dex */
public interface f06 {
    public static final boolean a;

    void a();

    boolean b();

    String c();

    AdLoadState d();

    void destroy();

    void e(et4 et4Var);

    String f();

    void show();

    static {
        boolean z;
        if (!TbadkCoreApplication.getInst().isDebugMode() && !hv4.h()) {
            z = false;
        } else {
            z = true;
        }
        a = z;
    }
}
