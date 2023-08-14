package com.baidu.tieba;

import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
/* loaded from: classes5.dex */
public interface a76 {
    public static final boolean a;

    void a();

    boolean b();

    String c();

    AdLoadState d();

    void destroy();

    void e(iw4 iw4Var);

    String f();

    void show();

    static {
        boolean z;
        if (!TbadkCoreApplication.getInst().isDebugMode() && !GlobalBuildConfig.isTiebaDebugTool()) {
            z = false;
        } else {
            z = true;
        }
        a = z;
    }
}
