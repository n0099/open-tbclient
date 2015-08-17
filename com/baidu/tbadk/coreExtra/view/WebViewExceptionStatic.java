package com.baidu.tbadk.coreExtra.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class WebViewExceptionStatic {
    static {
        MessageManager.getInstance().registerListener(new ah(CmdConfigCustom.UEXCEPTION_MESSAGE));
    }
}
