package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
/* loaded from: classes3.dex */
public interface er5 {
    public static final boolean a;

    static {
        a = TbadkCoreApplication.getInst().isDebugMode() || aq4.h();
    }

    void a();

    boolean b();

    String c();

    AdLoadState d();

    void destroy();

    void e(xo4 xo4Var);

    String f();

    void show();
}
