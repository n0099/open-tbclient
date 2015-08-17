package com.baidu.tbadk.kuang;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class KuangLoginStatic {
    static {
        a aVar = new a(CmdConfigCustom.CMD_LOGIN_STATUS_KUANG);
        if ("kuang".equals(TbConfig.getSubappType())) {
            MessageManager.getInstance().registerListener(aVar);
        }
    }
}
