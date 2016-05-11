package com.baidu.tbadk.plugins;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class Static {
    public static final String[] aze = {"android.content.res.Resources$NotFoundException", "android.view.InflateException"};

    static {
        MessageManager.getInstance().registerListener(new b(CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.UEXCEPTION_MESSAGE));
    }
}
