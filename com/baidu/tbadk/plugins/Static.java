package com.baidu.tbadk.plugins;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class Static {
    public static final String[] aIn = {"android.content.res.Resources$NotFoundException", "android.view.InflateException"};

    static {
        MessageManager.getInstance().registerListener(new f(CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        MessageManager.getInstance().registerListener(new g(CmdConfigCustom.UEXCEPTION_MESSAGE));
    }
}
