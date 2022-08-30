package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
/* loaded from: classes4.dex */
public interface ho5 {
    public static final boolean a;

    static {
        a = TbadkCoreApplication.getInst().isDebugMode() || mn4.h();
    }

    void a();

    boolean b();

    String c();

    AdLoadState d();

    void destroy();

    void e(jm4 jm4Var);

    String f();

    void show();
}
