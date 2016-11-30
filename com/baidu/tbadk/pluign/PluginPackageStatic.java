package com.baidu.tbadk.pluign;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class PluginPackageStatic {
    static {
        MessageManager.getInstance().registerListener(new a(CmdConfigCustom.CMD_BACKGROUND_SWTICH));
    }
}
