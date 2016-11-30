package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.ca;
/* loaded from: classes.dex */
public class FrsHotThreadStatic {
    static {
        ca.adF().ia(2);
        MessageManager.getInstance().registerListener(new c(CmdConfigCustom.CMD_FRS_ADD_MODEL));
    }
}
