package com.baidu.tieba.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
/* loaded from: classes.dex */
public class EnterForumActivityStatic {
    static {
        a();
    }

    private static void a() {
        MessageManager.getInstance().registerListener(new l(CmdConfig.INIT_HAO123_DATA));
    }
}
